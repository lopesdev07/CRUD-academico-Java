package repository;

import model.Disciplina;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaRepository {
    private final List<Disciplina> disciplinas = new ArrayList<>();

    public void adicionar(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public boolean removerPorCodigo(String codigo) {
        return disciplinas.removeIf(d -> d.getCodigo().equalsIgnoreCase(codigo));
    }

    public Disciplina buscarPorCodigo(String codigo) {
        return disciplinas.stream()
                .filter(d -> d.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);
    }

    public List<Disciplina> listarTodas() {
        return new ArrayList<>(disciplinas);
    }
}
