package service;

import model.Turma;
import repository.TurmaRepository;
import java.util.List;

public class TurmaService {
    private final TurmaRepository repository = new TurmaRepository();

    public void adicionar(String codigo, String nome, String semestre) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código da turma não pode estar vazio.");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome da turma não pode estar vazio.");
        }
        if (semestre == null || semestre.isBlank()) {
            throw new IllegalArgumentException("Semestre não pode estar vazio.");
        }
        repository.adicionar(new Turma(codigo, nome, semestre));
    }

    public boolean remover(String codigo) {
        return repository.removerPorCodigo(codigo);
    }

    public Turma buscar(String codigo) {
        return repository.buscarPorCodigo(codigo);
    }

    public boolean atualizar(String codigoAtual, String novoCodigo, String nome, String semestre) {
        Turma t = repository.buscarPorCodigo(codigoAtual);
        if (t == null) return false;

        if (novoCodigo == null || novoCodigo.isBlank()) {
            throw new IllegalArgumentException("Código da turma não pode estar vazio.");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome da turma não pode estar vazio.");
        }
        if (semestre == null || semestre.isBlank()) {
            throw new IllegalArgumentException("Semestre não pode estar vazio.");
        }

        t.setCodigo(novoCodigo);
        t.setNome(nome);
        t.setSemestre(semestre);
        return true;
    }

    public List<Turma> listar() {
        return repository.listarTodas();
    }
}
