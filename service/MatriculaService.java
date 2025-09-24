package service;

import model.Matricula;
import model.Estudante;
import model.Disciplina;
import model.Turma;
import repository.MatriculaRepository;
import java.util.List;

public class MatriculaService {
    private final MatriculaRepository repository = new MatriculaRepository();
    private int contadorId = 1; // gera IDs automáticos

    public void adicionar(Estudante estudante, Disciplina disciplina, Turma turma) {
        if (estudante == null) {
            throw new IllegalArgumentException("Estudante não pode estar vazio.");
        }
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina não pode estar vazia.");
        }
        if (turma == null) {
            throw new IllegalArgumentException("Turma não pode estar vazia.");
        }

        Matricula matricula = new Matricula(contadorId++, estudante, disciplina, turma);
        repository.adicionar(matricula);
    }

    public boolean remover(int id) {
        return repository.removerPorId(id);
    }

    public Matricula buscar(int id) {
        return repository.buscarPorId(id);
    }

    public List<Matricula> listar() {
        return repository.listarTodas();
    }
}
