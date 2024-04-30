# Sistema de Biblioteca

Este é um sistema de biblioteca desenvolvido em Java que permite o gerenciamento de livros, usuários (clientes e funcionários), empréstimos, categorias de livros e avaliações.

## Funcionalidades Principais

- **Login e Cadastro:** Os usuários podem fazer login como aluno ou funcionário, e também podem se cadastrar como aluno.
- **Empréstimo e Devolução de Livros:** Os alunos podem emprestar livros disponíveis e devolvê-los após a leitura. O sistema registra o histórico de empréstimos.
- **Pesquisa de Livros:** Os usuários podem pesquisar livros por curso (categoria) e ver uma lista de livros disponíveis e indisponíveis para empréstimos.
- **Avaliação de Livros:** Os alunos podem avaliar os livros após a devolução, fornecendo uma classificação de 0 a 5.
- **Gerenciamento de Livros:** Os funcionários podem adicionar, remover e atualizar informações de livros, como título, autor e categoria.
- **Histórico de Leitura:** Os usuários podem visualizar seu histórico de leitura, incluindo os livros que já leram.
- **Easter Egg:** Há um easter egg oculto no sistema para entretenimento.

## Estrutura do Código

- **`Main`:** Classe principal que contém o método `main` e o menu inicial do sistema.
- **`Cliente` e `Funcionario`:** Classes que representam os usuários do sistema, com métodos para login, cadastro e operações específicas de cada tipo de usuário.
- **`Biblioteca`:** Classe que gerencia os livros e clientes da biblioteca, incluindo métodos para imprimir listas e buscar livros por ID.
- **`Categoria` e `Livro`:** Classes que representam as categorias de livros e os próprios livros, com métodos para pesquisa, cadastro e remoção.
- **`Emprestimo`:** Classe que trata das operações de empréstimo e devolução de livros, incluindo o registro de histórico e avaliação.
- **`Utils`:** Classe utilitária para gerar IDs aleatórios.


