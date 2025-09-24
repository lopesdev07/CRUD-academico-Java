# 📚 CRUD Acadêmico em Java (Evolução do projeto)

**Descrição:** CRUD acadêmico desenvolvido em **Java** para prática de desenvolvimento backend. Implementa operações de **criação, leitura, atualização e exclusão** de entidades utilizando **ArrayLists**. Projeto funcional e em constante evolução.

**❗❗ Atualizações deste commit:**

**Arquitetura:** Agora a arquitetura segue o padrão MVC em camadas (Model, Repository, Service, Controller), garantindo organização, manutenção facilitada e evolução contínua.

**Classes**: Todas as classes receberam atualizações em seus atributos, métodos, exceções capturadas e validações de entradas.

**Comparativos Antigo x Novo**

**Estudante**

Antes: nome, idade, CPF, matricula (lista estática, menu na mesma classe)

Agora: mesmos atributos, mas com validações reforçadas e arquitetura em camadas

**Professor**
Antes: nome, disciplinas (String simples), CPF

Agora: nome, idade, cpf, matricula

**Disciplina**
Antes: nome, professorTutor

Agora: nome, codigo, cargaHoraria

**Turma**
Antes: matricula (int), disciplinas (String simples)

Agora: codigo, nome, semestre

**Matrícula**
Antes: matricula (int), CPF

Agora: id, estudante, disciplina, turma

|-- ❗ Um adendo, a classe matrícula agora também não contém mais a função de atualizar matrícula, visto que em casos reais isso seria ineficiente.

---

## 🚀 Tecnologias Utilizadas
- Java 24
- IDE: VS Code
- Estrutura de dados: ArrayList

---

## 📂 Estrutura do Projeto
**Projeto/**

**Model** → classes que representam as entidades (Estudante, Professor, Disciplina, Turma, Matrícula).

**Repository** → armazenamento em memória (listas) e operações básicas de busca/remoção.

**Service** → regras de negócio e validações.

**Controller** → interação com o usuário via console (menus e mensagens).

**Main** → ponto de entrada, com menu principal que chama os controllers.

---

## ▶️ Como Executar
1. **Clone este repositório**
   ```bash
   git clone https://github.com/lopesdev07/CRUD-academico-Java
   ```
2. **Abra o projeto**
   Abra a pasta do projeto na sua IDE
3. **Compilar e executar**
   Localize na IDE o arquivo SistemaAcademico.java e dê **Run**

---

📌 **Funcionalidades**
➕ Adicionar entidades (disciplinas, estudantes, professores, turmas, matrículas)

📋 Listar entidades

✏️ Atualizar entidades

❌ Remover entidades

---

🛠 Próximos Passos:

1: Implementar persistência em banco de dados relacionais

2: Melhorar tratamento de exceções

3: Implementar testes unitários

4: Adicionar documentação/comentários nos métodos principais

5: Melhorar a eficiência do scanner (um único no main)

6: Padronizar injeção de dependências em todos os controllers
