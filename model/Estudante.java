package model;

public class Estudante {
    private String nome;
    private int idade;
    private String cpf;
    private int matricula;

    public Estudante(String nome, int idade, String cpf, int matricula) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.matricula = matricula;
    }

    // Getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { this.matricula = matricula; }

    @Override
    public String toString() {
        return String.format("Nome: %s, Idade: %d, CPF: %s, Matrícula: %d",
                nome, idade, cpf, matricula);
    }
}
