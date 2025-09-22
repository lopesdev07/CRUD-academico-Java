package Projeto;
import java.util.Scanner;
import java.util.ArrayList;

public class Professores {
    private String nome;
    private String disciplinas;
    private String CPF;
    private static ArrayList<Professores> listaProfessores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Professores(String nome, String disciplinas, String CPF) {
        this.nome = nome;
        this.disciplinas = disciplinas;
        this.CPF = CPF;
    }

    public String getNome() { 
        return nome; }
    public void setNome(String nome) { 
        this.nome = nome; }
    public String getDisciplinas() { 
        return disciplinas; }
    public void setDisciplinas(String disciplinas) { 
        this.disciplinas = disciplinas; }
    public String getCPF() { 
        return CPF; }
    public void setCPF(String CPF) { 
        this.CPF = CPF; }

    public static void menuProfessores(){
        int opcao;
        while (true) {
            System.out.println("Agora você está no menu de Professores");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Professor");
            System.out.println("2. Remover Professor");
            System.out.println("3. Listar Professores");
            System.out.println("4. Atualizar Professor");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Qual opção você deseja?: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao == 1){
                System.out.println("Digite o nome do professor:");
                String nome = scanner.nextLine();
                System.out.println("Digite as disciplinas do professor:");
                String disciplinas = scanner.nextLine();
                System.out.println("Digite o CPF do professor:");
                String CPF = scanner.nextLine();
                listaProfessores.add(new Professores(nome, disciplinas, CPF));
                System.out.println("Professor " + nome + " adicionado com sucesso!");
            }
            else if (opcao == 2){
                System.out.println("Digite o CPF do professor que deseja remover:");
                String cpfRemover = scanner.nextLine();
                boolean removido = false;
                if (cpfRemover.length() == 11) {
                    for (int i = 0; i < listaProfessores.size(); i++) {
                        if (listaProfessores.get(i).getCPF().equalsIgnoreCase(cpfRemover)) {
                            listaProfessores.remove(i);
                            System.out.println("Professor com CPF " + cpfRemover + " removido com sucesso!");
                            removido = true;
                            break;
                        }
                    }}
                else {
                    System.out.println("CPF inválido. Deve conter 11 caracteres.");
                    continue;
                }
                if (!removido) {
                    System.out.println("Nenhum professor encontrado com o CPF " + cpfRemover + ".");
                }
            }
            else if (opcao == 3){
                System.out.println("Lista de Professores:");
                if (listaProfessores.isEmpty()) {
                    System.out.println("Nenhum professor cadastrado no sistema.");
                } else {
                    for (Professores prof : listaProfessores) {
                        System.out.printf("Nome: %s, Disciplinas: %s, CPF: %s%n", prof.getNome(), prof.getDisciplinas(), prof.getCPF());
                    }
                }
            }
            else if (opcao == 4){
                System.out.println("Digite o CPF do professor que deseja atualizar:");
                String cpfAtualizar = scanner.nextLine();
                boolean encontrado = false;
                if (cpfAtualizar.length() == 11) {
                    for (int i = 0; i < listaProfessores.size(); i++) {
                        if (listaProfessores.get(i).getCPF().equalsIgnoreCase(cpfAtualizar)) {
                            System.out.println("Digite o novo nome do professor:");
                            String novoNome = scanner.nextLine();
                            System.out.println("Digite as novas disciplinas do professor:");
                            String novasDisciplinas = scanner.nextLine();
                            listaProfessores.get(i).setNome(novoNome);
                            listaProfessores.get(i).setDisciplinas(novasDisciplinas);
                            System.out.println("Professor com CPF " + cpfAtualizar + " atualizado com sucesso!");
                            encontrado = true;
                            break;
                    }
                }
                }
                else {
                    System.out.println("CPF inválido. Deve conter 11 caracteres.");
                    continue;
                }
                if (!encontrado) {
                    System.out.println("Nenhum professor encontrado com o CPF " + cpfAtualizar + ".");
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