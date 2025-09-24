package repository;

import model.Turma;
import java.util.ArrayList;
import java.util.List;

public class TurmaRepository {
    private final List<Turma> turmas = new ArrayList<>();

    public void adicionar(Turma turma) {
        turmas.add(turma);
    }

    public boolean removerPorCodigo(String codigo) {
        return turmas.removeIf(t -> t.getCodigo().equalsIgnoreCase(codigo));
    }

    public Turma buscarPorCodigo(String codigo) {
        return turmas.stream()
                .filter(t -> t.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);
    }

    public List<Turma> listarTodas() {
        return new ArrayList<>(turmas);
    }
}
