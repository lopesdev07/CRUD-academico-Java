package controller;

import service.TurmaService;
import model.Turma;
import java.util.Scanner;

public class TurmaController {
    private final TurmaService service = new TurmaService();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcao;
        do {
            System.out.println("\n=== Menu Turmas ===");
            System.out.println("1. Adicionar uma turma");
            System.out.println("2. Remover uma turma");
            System.out.println("3. Listar as turmas");
            System.out.println("4. Atualizar uma turma");
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
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Semestre: ");
        String semestre = scanner.nextLine();

        try {
            service.adicionar(codigo, nome, semestre);
            System.out.println("Turma adicionada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void remover() {
        System.out.print("Informe o código da turma: ");
        String codigo = scanner.nextLine();
        System.out.println(service.remover(codigo) ? "Turma removida!" : "Turma não encontrada.");
    }

    private void listar() {
        System.out.println("\n--- Lista de Turmas ---");
        var lista = service.listar();

        if (lista.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada ainda.");
        } else {
            for (Turma t : lista) {
                System.out.println(t);
            }
        }
    }

    private void atualizar() {
        System.out.print("Código atual: ");
        String codigoAtual = scanner.nextLine();
        System.out.print("Novo código: ");
        String novoCodigo = scanner.nextLine();
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo semestre: ");
        String semestre = scanner.nextLine();

        try {
            boolean atualizado = service.atualizar(codigoAtual, novoCodigo, nome, semestre);
            System.out.println(atualizado ? "Turma atualizada!" : "Turma não encontrada.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
