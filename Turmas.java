package Projeto;
import java.util.Scanner;
import java.util.ArrayList;

public class Turmas {
    private int matricula;
    private String disciplinas;
    private static ArrayList<Turmas> listaTurmas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Turmas(int matricula, String disciplinas) {
        this.matricula = matricula;
        this.disciplinas = disciplinas;
    }

    public int getMatricula() { 
        return matricula; }
    public void setMatricula(int matricula) { 
        this.matricula = matricula; }
    public String getDisciplinas() { 
        return disciplinas; }
    public void setDisciplinas(String disciplinas) { 
        this.disciplinas = disciplinas; }

    public static void menuTurmas(){
        int opcao;
        while (true) {
            System.out.println("Agora você está no menu de Turmas");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Turma");
            System.out.println("2. Remover Turma");
            System.out.println("3. Listar Turmas");
            System.out.println("4. Atualizar Turma");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Qual opção você deseja?: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao == 1){
                System.out.println("Digite a matrícula da turma:");
                int matricula = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Digite as disciplinas da turma:");
                String disciplinas = scanner.nextLine();
                listaTurmas.add(new Turmas(matricula, disciplinas));
                System.out.println("Turma " + matricula + " adicionada com sucesso!");
            }
            else if (opcao == 2){
                System.out.println("Digite a matrícula da turma que deseja remover:");
                int matriculaRemover = scanner.nextInt();
                scanner.nextLine();
                boolean removido = false;
                for (int i = 0; i < listaTurmas.size(); i++) {
                    if (listaTurmas.get(i).getMatricula() == matriculaRemover) {
                        listaTurmas.remove(i);
                        System.out.println("Turma com matrícula " + matriculaRemover + " removida com sucesso!");
                        removido = true;
                        break;
                    }
                }
                if (!removido) {
                    System.out.println("Nenhuma turma encontrada com a matrícula " + matriculaRemover + ".");
                }
            }
            else if (opcao == 3){
                System.out.println("Lista de Turmas:");
                if (listaTurmas.isEmpty()) {
                    System.out.println("Nenhuma turma cadastrada no sistema.");
                } else {
                    for (Turmas turma : listaTurmas) {
                        System.out.printf("Matrícula: %d, Disciplinas: %s%n", turma.getMatricula(), turma.getDisciplinas());
                    }
                }
            }
            else if (opcao == 4){
                System.out.println("Digite a matrícula da turma que deseja atualizar:");
                int matriculaAtualizar = scanner.nextInt();
                scanner.nextLine();
                boolean encontrado = false;
                for (int i = 0; i < listaTurmas.size(); i++) {
                    if (listaTurmas.get(i).getMatricula() == matriculaAtualizar) {
                        System.out.println("Digite a nova matrícula da turma:");
                        int novaMatricula = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite as novas disciplinas da turma:");
                        String novasDisciplinas = scanner.nextLine();
                        listaTurmas.get(i).setMatricula(novaMatricula);
                        listaTurmas.get(i).setDisciplinas(novasDisciplinas);
                        System.out.println("Turma com matrícula " + matriculaAtualizar + " atualizada com sucesso!");
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Nenhuma turma encontrada com a matrícula " + matriculaAtualizar + ".");
                }
            }
            else if (opcao == 5){
                System.out.println("Voltando ao menu principal...");
                break;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}