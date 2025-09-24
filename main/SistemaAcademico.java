package main;

import controller.EstudanteController;
import controller.ProfessorController;
import controller.DisciplinaController;
import controller.TurmaController;
import service.DisciplinaService;
import service.EstudanteService;
import service.TurmaService;
import controller.MatriculaController;
import java.util.Scanner;

public class SistemaAcademico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Instancia os controllers (e os services, no caso da matrícula)
        EstudanteService estudanteService = new EstudanteService();
        DisciplinaService disciplinaService = new DisciplinaService();
        TurmaService turmaService = new TurmaService();
        EstudanteController estudanteController = new EstudanteController();
        ProfessorController professorController = new ProfessorController();
        DisciplinaController disciplinaController = new DisciplinaController();
        TurmaController turmaController = new TurmaController();
        MatriculaController matriculaController = new MatriculaController(estudanteService, disciplinaService, turmaService);

        int opcao;
        do {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Estudantes");
            System.out.println("2. Professores");
            System.out.println("3. Disciplinas");
            System.out.println("4. Turmas");
            System.out.println("5. Matrículas");
            System.out.println("6. Sair");
            System.out.print("Qual menu deseja acessar?: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> estudanteController.menu();
                case 2 -> professorController.menu();
                case 3 -> disciplinaController.menu();
                case 4 -> turmaController.menu();
                case 5 -> matriculaController.menu();
                case 6 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
