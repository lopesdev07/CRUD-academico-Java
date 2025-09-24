package controller;

import service.DisciplinaService;
import model.Disciplina;
import java.util.Scanner;

public class DisciplinaController {
    private final DisciplinaService service = new DisciplinaService();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcao;
        do {
            System.out.println("\n=== Menu Disciplinas ===");
            System.out.println("1. Adicionar uma disciplina");
            System.out.println("2. Remover uma disciplina");
            System.out.println("3. Listar as disciplinas");
            System.out.println("4. Atualizar uma disciplina");
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
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Carga horária: ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine();

        try {
            service.adicionar(nome, codigo, cargaHoraria);
            System.out.println("Disciplina adicionada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void remover() {
        System.out.print("Informe o código da disciplina: ");
        String codigo = scanner.nextLine();
        System.out.println(service.remover(codigo) ? "Disciplina removida!" : "Disciplina não encontrada.");
    }

    private void listar() {
        System.out.println("\n--- Lista de Disciplinas ---");
        var lista = service.listar();

        if (lista.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada ainda.");
        } else {
            for (Disciplina d : lista) {
                System.out.println(d);
            }
        }
    }

    private void atualizar() {
        System.out.print("Código atual: ");
        String codigoAtual = scanner.nextLine();
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo código: ");
        String novoCodigo = scanner.nextLine();
        System.out.print("Nova carga horária: ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine();

        try {
            boolean atualizado = service.atualizar(codigoAtual, nome, novoCodigo, cargaHoraria);
            System.out.println(atualizado ? "Disciplina atualizada!" : "Disciplina não encontrada.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
