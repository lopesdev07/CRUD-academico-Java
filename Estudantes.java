package Projeto;
import java.util.Scanner;
import java.util.ArrayList;

public class Estudantes {
    private String nome;
    private int idade;
    private String CPF;
    private int matricula;
    private static ArrayList<Estudantes> listaEstudantes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Estudantes(String nome, int idade, String CPF, int matricula) { // Construtor
        this.nome = nome;
        this.idade = idade;
        this.CPF = CPF;
        this.matricula = matricula;
    }
    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public static void menuEstudantes(){ //Principal metodo chamado na main
        int opcao;
        while (true) {
       System.out.println("Agora você está no menu de Estudantes");
       System.out.println("Escolha uma opção:");
         System.out.println("1. Adicionar Estudante");
            System.out.println("2. Remover Estudante");
            System.out.println("3. Listar Estudantes");
            System.out.println("4. Atualizar Estudante");
            System.out.println("5. Voltar ao menu principal"); 
            System.out.print("Qual opção você deseja?: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao == 1){
                System.out.println("Você escolheu adicionar um estudante.");
                System.out.println("Digite o nome do estudante:");
                String nome = scanner.nextLine();
                System.out.println("Digite a idade do estudante:");
                int idade = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Digite o CPF do estudante:");
                String CPF = scanner.nextLine();
                if (CPF.length() == 11) { //Continua o script caso o CPF seja valido
                    System.out.println("Digite a matrícula do estudante:");
                    int matricula = scanner.nextInt();
                    scanner.nextLine();
                    listaEstudantes.add(new Estudantes(nome, idade, CPF, matricula)); // Adiciona o novo estudante à lista
                    System.out.println("Estudante " + nome + " adicionado com sucesso!");}
                else {
                    System.out.println("CPF inválido. Deve conter 11 caracteres.");
                }
            }
            else if (opcao == 2){
                System.out.println("Você escolheu remover um estudante.");
                System.out.println("Digite a matrícula do estudante que deseja remover:");
                int matriculaRemover = scanner.nextInt();
                scanner.nextLine(); // Consome a nova linha
                boolean removido = false;
                for (int i = 0; i < listaEstudantes.size(); i++) {
                    if (listaEstudantes.get(i).getMatricula() == matriculaRemover) { //Verifica se a matricula corresponde com alguma da lista
                        listaEstudantes.remove(i); //Remove o estudante da lista
                        System.out.println("Estudante com matrícula " + matriculaRemover + " removido com sucesso!");
                        removido = true;
                        break;
                    }
                }
                if (!removido) {
                    System.out.println("Nenhum estudante encontrado com a matrícula " + matriculaRemover + ".");
                }
            }
            else if (opcao == 3){
                System.out.println("Você escolheu listar os estudantes.");
                System.out.println("Lista de Estudantes:");
                if (listaEstudantes.isEmpty()) {
                    System.out.println("Nenhum estudante cadastrado no sistema.");
                }
                else {
                    for (Estudantes estudante : listaEstudantes) {
                        System.out.printf("Nome: %s, Idade: %d, CPF: %s, Matrícula: %d%n", estudante.getNome(), estudante.getIdade(), estudante.getCPF(), estudante.getMatricula());
                    }}}
            else if (opcao == 4){
                System.out.println("Você escolheu atualizar um estudante.");
                System.out.println("Digite a matrícula do estudante que deseja atualizar:");
                int matriculaAtualizar = scanner.nextInt();
                scanner.nextLine(); // Consome a nova linha
                boolean encontrado = false;
                for (int i = 0; i < listaEstudantes.size(); i++) {
                    if (listaEstudantes.get(i).getMatricula() == matriculaAtualizar) { //Continua se a matricula for encontrada
                        System.out.println("Digite a nova matricula do estudante:");
                        int matriculaAtualizar2 = scanner.nextInt();
                        scanner.nextLine(); // Consome a nova linha
                        listaEstudantes.get(i).setMatricula(matriculaAtualizar2);
                        System.out.println("Digite o novo nome do estudante:");
                        String novoNome = scanner.nextLine();
                        listaEstudantes.get(i).setNome(novoNome);
                        System.out.println("Digite a nova idade do estudante:");
                        int novaIdade = scanner.nextInt();
                        scanner.nextLine(); // Consome a nova linha 
                        listaEstudantes.get(i).setIdade(novaIdade);
                        System.out.println("Digite o novo CPF do estudante:");
                        String novoCPF = scanner.nextLine();
                        if (novoCPF.length() == 11) { //Continua o script caso o CPF seja valido
                            listaEstudantes.get(i).setCPF(novoCPF);
                        } else {
                            System.out.println("CPF inválido. Deve conter 11 caracteres.");
                            break; // Sai do loop se o CPF for inválido
                        }
                        System.out.println("Estudante com matrícula " + matriculaAtualizar + " ajustado com sucesso!");
                        encontrado = true;
                        break;}}
                if (!encontrado) {
                    System.out.println("Nenhum estudante encontrado com a matrícula " + matriculaAtualizar + ".");}
            }
            
            else if (opcao == 5){
                System.out.println("Voltando ao menu principal...");
                break; // Sai do loop e volta ao menu principal
            }
            
            if (opcao < 1 || opcao > 5){
                System.out.println("Opção inválida. Tente novamente.");
            }


    }

    
}
}
