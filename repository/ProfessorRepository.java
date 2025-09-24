package repository;

import model.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {
    private final List<Professor> professores = new ArrayList<>();

    public void adicionar(Professor professor) {
        professores.add(professor);
    }

    public boolean removerPorMatricula(int matricula) {
        return professores.removeIf(p -> p.getMatricula() == matricula);
    }

    public Professor buscarPorMatricula(int matricula) {
        return professores.stream()
                .filter(p -> p.getMatricula() == matricula)
                .findFirst()
                .orElse(null);
    }

    public List<Professor> listarTodos() {
        return new ArrayList<>(professores);
    }
}
