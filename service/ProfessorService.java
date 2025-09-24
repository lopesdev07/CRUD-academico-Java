package service;

import model.Professor;
import repository.ProfessorRepository;
import java.util.List;

public class ProfessorService {
    private final ProfessorRepository repository = new ProfessorRepository();

    public void adicionar(String nome, int idade, String cpf, int matricula) {
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 caracteres. (Ex: 12345678901)");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode estar vazio.");
        }
        repository.adicionar(new Professor(nome, idade, cpf, matricula));
    }

    public boolean remover(int matricula) {
        return repository.removerPorMatricula(matricula);
    }

    public Professor buscar(int matricula) {
        return repository.buscarPorMatricula(matricula);
    }

    public boolean atualizar(int matricula, String nome, int idade, String cpf, int novaMatricula) {
        Professor p = repository.buscarPorMatricula(matricula);
        if (p == null) return false;

        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 caracteres. (Ex: 12345678901)");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode estar vazio.");
        }

        p.setNome(nome);
        p.setIdade(idade);
        p.setCpf(cpf);
        p.setMatricula(novaMatricula);
        return true;
    }

    public List<Professor> listar() {
        return repository.listarTodos();
    }
}
