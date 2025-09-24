package controller;

import service.EstudanteService;
import model.Estudante;
import java.util.Scanner;

public class EstudanteController {
    private final EstudanteService service = new EstudanteService();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcao;
        do {
            System.out.println("\n=== Menu Estudantes ===");
            System.out.println("1. Adicionar um estudante");
            System.out.println("2. Remover um estudante");
            System.out.println("3. Listar os estudantes");
            System.out.println("4. Atualizar um estudante");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Qual operação deseja realizar? ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionar();
                case 2 -> remover();
                case 3 -> listar();
                case 4 -> atualizar();
                case 5 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }

    private void adicionar() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Matrícula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        try {
            service.adicionar(nome, idade, cpf, matricula);
            System.out.println(" Estudante adicionado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void remover() {
        System.out.print("Informe a matrícula do estudante: ");
        int m = scanner.nextInt();
        scanner.nextLine();
        System.out.println(service.remover(m) ? "Estudante removido!" : "Estudante não encontrado.");
    }
    
    private void listar() {
        System.out.println("\n--- Lista de Estudantes ---");
        var lista = service.listar();

        if (lista.isEmpty()) {
            System.out.println("Nenhum estudante cadastrado ainda.");
        } else {
            for (Estudante e : lista) {
                System.out.println(e);
            }
        }
    }

    private void atualizar() {
        System.out.print("Matrícula atual: ");
        int atual = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nova matrícula: ");
        int nova = scanner.nextInt();
        scanner.nextLine();

        try {
            boolean atualizado = service.atualizar(atual, nome, idade, cpf, nova);
            System.out.println(atualizado ? "Estudante atualizado!" : "Estudante não encontrado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
