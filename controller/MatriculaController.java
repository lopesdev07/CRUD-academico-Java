package controller;

import service.MatriculaService;
import service.EstudanteService;
import service.DisciplinaService;
import service.TurmaService;
import model.Matricula;
import model.Estudante;
import model.Disciplina;
import model.Turma;

import java.util.Scanner;

public class MatriculaController {
    private final MatriculaService matriculaService = new MatriculaService();
    private final EstudanteService estudanteService;
    private final DisciplinaService disciplinaService;
    private final TurmaService turmaService;
    private final Scanner scanner = new Scanner(System.in);

    public MatriculaController(EstudanteService estudanteService,
                               DisciplinaService disciplinaService,
                               TurmaService turmaService) {
        this.estudanteService = estudanteService;
        this.disciplinaService = disciplinaService;
        this.turmaService = turmaService;
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\n=== Menu Matrículas ===");
            System.out.println("1. Adicionar uma matrícula");
            System.out.println("2. Remover uma matrícula");
            System.out.println("3. Listar as matrículas");
            System.out.println("4. Voltar ao menu principal");
            System.out.print("Qual operação deseja realizar? ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionar();
                case 2 -> remover();
                case 3 -> listar();
                case 4 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
    }

    private void adicionar() {
        System.out.print("Matrícula do estudante: ");
        int matriculaEstudante = scanner.nextInt();
        scanner.nextLine();
        Estudante estudante = estudanteService.buscar(matriculaEstudante);

        System.out.print("Código da disciplina: ");
        String codigoDisciplina = scanner.nextLine();
        Disciplina disciplina = disciplinaService.buscar(codigoDisciplina);

        System.out.print("Código da turma: ");
        String codigoTurma = scanner.nextLine();
        Turma turma = turmaService.buscar(codigoTurma);

        try {
            matriculaService.adicionar(estudante, disciplina, turma);
            System.out.println("Matrícula adicionada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void remover() {
        System.out.print("Informe o ID da matrícula: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(matriculaService.remover(id) ? "Matrícula removida!" : "Matrícula não encontrada.");
    }

    private void listar() {
        System.out.println("\n--- Lista de Matrículas ---");
        var lista = matriculaService.listar();

        if (lista.isEmpty()) {
            System.out.println("Nenhuma matrícula cadastrada ainda.");
        } else {
            for (Matricula m : lista) {
                System.out.println(m);
            }
        }
    }
}
    