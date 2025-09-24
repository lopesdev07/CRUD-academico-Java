package service;

import model.Estudante;
import repository.EstudanteRepository;
import java.util.List;

public class EstudanteService {
    private final EstudanteRepository repository = new EstudanteRepository();

    // Adicionar estudante com validações
    public void adicionar(String nome, int idade, String cpf, int matricula) {
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 caracteres. (Ex: 12345678901)");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode estar vazio.");
        }
        repository.adicionar(new Estudante(nome, idade, cpf, matricula));
    }

    // Remover estudante
    public boolean remover(int matricula) {
        return repository.removerPorMatricula(matricula);
    }

    // Buscar estudante
    public Estudante buscar(int matricula) {
        return repository.buscarPorMatricula(matricula);
    }

    // Atualizar estudante
    public boolean atualizar(int matricula, String nome, int idade, String cpf, int novaMatricula) {
        Estudante e = repository.buscarPorMatricula(matricula);
        if (e == null) return false;

        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 caracteres.");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }

        e.setNome(nome);
        e.setIdade(idade);
        e.setCpf(cpf);
        e.setMatricula(novaMatricula);
        return true;
    }

    // Listar todos
    public List<Estudante> listar() {
        return repository.listarTodos();
    }
}
