package Projeto;
import java.util.Scanner;

public class Sistemaacademico {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Sistema Acadêmico");
            System.out.println("1. Gerenciar Estudantes");
            System.out.println("2. Gerenciar Professores");
            System.out.println("3. Gerenciar Disciplinas");
            System.out.println("4. Gerenciar Turmas");
            System.out.println("5. Gerenciar Matriculas");
            System.out.println("6. Sair");
            System.out.print("Qual opção você deseja?: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1: Estudantes.menuEstudantes();
                continue;
                case 2: Professores.menuProfessores();
                continue;
                case 3: Disciplinas.menuDisciplinas();
                continue;
                case 4: Turmas.menuTurmas();
                continue;
                case 5: Matriculas.menuMatriculas();
                continue;
                case 6: System.out.println("Saindo do sistema..."); break;
                default: System.out.println("Opção inválida. Tente novamente.");
            }}
            while (opcao != 6);
            scanner.close();
        
        
        
    }
}
