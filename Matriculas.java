package Projeto;
import java.util.Scanner;
import java.util.ArrayList;

public class Matriculas {
    private int matricula;
    private String CPF;
    private static ArrayList<Matriculas> listaMatriculas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Matriculas(int matricula, String CPF) {
        this.matricula = matricula;
        this.CPF = CPF;
    }

    public int getMatricula() { 
        return matricula; }
    public void setMatricula(int matricula) {   
        this.matricula = matricula; }
    public String getCPF() { 
        return CPF; }
    public void setCPF(String CPF) { 
        this.CPF = CPF; }

    public static void menuMatriculas(){
        int opcao;
        while (true) {
            System.out.println("Agora você está no menu de Matrículas");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Matrícula");
            System.out.println("2. Remover Matrícula");
            System.out.println("3. Listar Matrículas");
            System.out.println("4. Atualizar Matrícula");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Qual opção você deseja?: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao == 1){
                System.out.println("Digite a matrícula:");
                int matricula = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Digite o CPF:");
                String CPF = scanner.nextLine();
                if (CPF.length() == 11) {
                    listaMatriculas.add(new Matriculas(matricula, CPF));
                    System.out.println("Matrícula " + matricula + " adicionada com sucesso!");
                } else {
                    System.out.println("CPF inválido. Deve conter 11 caracteres.");
            }}
            else if (opcao == 2){
                System.out.println("Digite a matrícula que deseja remover:");
                int matriculaRemover = scanner.nextInt();
                scanner.nextLine();
                boolean removido = false;
                for (int i = 0; i < listaMatriculas.size(); i++) {
                    if (listaMatriculas.get(i).getMatricula() == matriculaRemover) {
                        listaMatriculas.remove(i);
                        System.out.println("Matrícula " + matriculaRemover + " removida com sucesso!");
                        removido = true;
                        break;
                    }
                }
                if (!removido) {
                    System.out.println("Nenhuma matrícula encontrada com o número " + matriculaRemover + ".");
                }
            }
            else if (opcao == 3){
                System.out.println("Lista de Matrículas:");
                if (listaMatriculas.isEmpty()) {
                    System.out.println("Nenhuma matrícula cadastrada no sistema.");
                } else {
                    for (Matriculas mat : listaMatriculas) {
                        System.out.printf("Matrícula: %d, CPF: %s%n", mat.getMatricula(), mat.getCPF());
                    }
                }
            }
            else if (opcao == 4){
                System.out.println("Digite a matrícula que deseja atualizar:");
                int matriculaAtualizar = scanner.nextInt();
                scanner.nextLine();
                boolean encontrado = false;
                for (int i = 0; i < listaMatriculas.size(); i++) {
                    if (listaMatriculas.get(i).getMatricula() == matriculaAtualizar) {
                        System.out.println("Digite a nova matrícula:");
                        int novaMatricula = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite o novo CPF:");
                        String novoCPF = scanner.nextLine();
                        listaMatriculas.get(i).setMatricula(novaMatricula);
                        listaMatriculas.get(i).setCPF(novoCPF);
                        System.out.println("Matrícula " + matriculaAtualizar + " atualizada com sucesso!");
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Nenhuma matrícula encontrada com o número " + matriculaAtualizar + ".");
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