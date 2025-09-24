package repository;

import model.Estudante;
import java.util.ArrayList;
import java.util.List;

public class EstudanteRepository {
    private final List<Estudante> estudantes = new ArrayList<>();

    public void adicionar(Estudante estudante) {
        estudantes.add(estudante);
    }

    public boolean removerPorMatricula(int matricula) {
        return estudantes.removeIf(e -> e.getMatricula() == matricula);
    }

    public Estudante buscarPorMatricula(int matricula) {
        return estudantes.stream()
                .filter(e -> e.getMatricula() == matricula)
                .findFirst()
                .orElse(null);
    }

    public List<Estudante> listarTodos() {
        return new ArrayList<>(estudantes);
    }
}
