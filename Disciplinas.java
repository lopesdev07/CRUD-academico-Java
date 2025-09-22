package Projeto;
import java.util.Scanner;
import java.util.ArrayList;

public class Disciplinas {
    private String nome;
    private String professorTutor;
    private static ArrayList<Disciplinas> listaDisciplinas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Disciplinas(String nome, String professorTutor) {
        this.nome = nome;
        this.professorTutor = professorTutor;
    }
    
    // Getters e Setters
    
    public String getNome() {
        return nome; }
    
    public void setNome(String nome) {
        this.nome = nome; }

    public String getProfessorTutor() { 
        return professorTutor; }

    public void setProfessorTutor(String professorTutor) {
        this.professorTutor = professorTutor; }

    public static void menuDisciplinas(){
        int opcao;
        while (true) {
            System.out.println("Agora você está no menu de Disciplinas");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Disciplina");
            System.out.println("2. Remover Disciplina");
            System.out.println("3. Listar Disciplinas");
            System.out.println("4. Atualizar Disciplina");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Qual opção você deseja?: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao == 1){
                System.out.println("Digite o nome da disciplina:");
                String nome = scanner.nextLine();
                System.out.println("Digite o nome do professor tutor:");
                String professorTutor = scanner.nextLine();
                listaDisciplinas.add(new Disciplinas(nome, professorTutor));
                System.out.println("Disciplina " + nome + " adicionada com sucesso!");
            }
            else if (opcao == 2){
                System.out.println("Digite o nome da disciplina que deseja remover:");
                String nomeRemover = scanner.nextLine();
                boolean removido = false;
                for (int i = 0; i < listaDisciplinas.size(); i++) {
                    if (listaDisciplinas.get(i).getNome().equalsIgnoreCase(nomeRemover)) {
                        listaDisciplinas.remove(i);
                        System.out.println("Disciplina " + nomeRemover + " removida com sucesso!");
                        removido = true;
                        break;
                    }
                }
                if (!removido) {
                    System.out.println("Nenhuma disciplina encontrada com o nome " + nomeRemover + ".");
                }
            }
            else if (opcao == 3){
                System.out.println("Lista de Disciplinas:");
                if (listaDisciplinas.isEmpty()) {
                    System.out.println("Nenhuma disciplina cadastrada no sistema.");
                } else {
                    for (Disciplinas disc : listaDisciplinas) {
                        System.out.printf("Nome: %s, Professor Tutor: %s%n", disc.getNome(), disc.getProfessorTutor());
                    }
                }
            }
            else if (opcao == 4){
                System.out.println("Digite o nome da disciplina que deseja atualizar:");
                String nomeAtualizar = scanner.nextLine();
                boolean encontrado = false;
                for (int i = 0; i < listaDisciplinas.size(); i++) {
                    if (listaDisciplinas.get(i).getNome().equalsIgnoreCase(nomeAtualizar)) {
                        System.out.println("Digite o novo nome da disciplina:");
                        String novoNome = scanner.nextLine();
                        System.out.println("Digite o novo professor tutor:");
                        String novoTutor = scanner.nextLine();
                        listaDisciplinas.get(i).setNome(novoNome);
                        listaDisciplinas.get(i).setProfessorTutor(novoTutor);
                        System.out.println("Disciplina " + nomeAtualizar + " atualizada com sucesso!");
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Nenhuma disciplina encontrada com o nome " + nomeAtualizar + ".");
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