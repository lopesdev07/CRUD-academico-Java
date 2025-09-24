package service;

import model.Disciplina;
import repository.DisciplinaRepository;
import java.util.List;

public class DisciplinaService {
    private final DisciplinaRepository repository = new DisciplinaRepository();

    public void adicionar(String nome, String codigo, int cargaHoraria) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome da disciplina não pode estarvazio.");
        }
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código da disciplina não pode estar vazio.");
        }
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("Carga horária deve ser maior que zero.");
        }
        repository.adicionar(new Disciplina(nome, codigo, cargaHoraria));
    }

    public boolean remover(String codigo) { 
        return repository.removerPorCodigo(codigo);
    }

    public Disciplina buscar(String codigo) {
        return repository.buscarPorCodigo(codigo);
    }

    public boolean atualizar(String codigoAtual, String nome, String novoCodigo, int cargaHoraria) {
        Disciplina d = repository.buscarPorCodigo(codigoAtual);
        if (d == null) return false;

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome da disciplina não pode estar vazio.");
        }
        if (novoCodigo == null || novoCodigo.isBlank()) {
            throw new IllegalArgumentException("Código da disciplina não pode estar vazio.");
        }
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("Carga horária deve ser maior que zero.");
        }

        d.setNome(nome);
        d.setCodigo(novoCodigo);
        d.setCargaHoraria(cargaHoraria);
        return true;
    }

    public List<Disciplina> listar() {
        return repository.listarTodas();
    }
}
