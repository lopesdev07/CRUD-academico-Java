package repository;

import model.Matricula;
import java.util.ArrayList;
import java.util.List;

public class MatriculaRepository {
    private final List<Matricula> matriculas = new ArrayList<>();

    public void adicionar(Matricula matricula) {
        matriculas.add(matricula);
    }

    public boolean removerPorId(int id) {
        return matriculas.removeIf(m -> m.getId() == id);
    }

    public Matricula buscarPorId(int id) {
        return matriculas.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Matricula> listarTodas() {
        return new ArrayList<>(matriculas);
    }
}
