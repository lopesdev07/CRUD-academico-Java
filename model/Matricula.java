package model;

public class Matricula {
    private int id; // identificador único da matrícula
    private Estudante estudante;
    private Disciplina disciplina;
    private Turma turma;

    public Matricula(int id, Estudante estudante, Disciplina disciplina, Turma turma) {
        this.id = id;
        this.estudante = estudante;
        this.disciplina = disciplina;
        this.turma = turma;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Estudante getEstudante() { return estudante; }
    public void setEstudante(Estudante estudante) { this.estudante = estudante; }

    public Disciplina getDisciplina() { return disciplina; }
    public void setDisciplina(Disciplina disciplina) { this.disciplina = disciplina; }

    public Turma getTurma() { return turma; }
    public void setTurma(Turma turma) { this.turma = turma; }

    @Override
    public String toString() {
        return String.format("Matrícula ID: %d, Estudante: %s, Disciplina: %s, Turma: %s",
                id,
                estudante.getNome(),
                disciplina.getNome(),
                turma.getCodigo());
    }
}
