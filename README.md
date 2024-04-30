# Sistema de Biblioteca

Este é um sistema de biblioteca desenvolvido em Java que permite o gerenciamento de livros, usuários (clientes e funcionários), empréstimos, categorias de livros e avaliações.

## Autores
- Maria Clara C Soares
- Lucas Gurgel

## Funcionalidades Principais

- **Login e Cadastro:** Os usuários podem fazer login como aluno ou funcionário, e também podem se cadastrar como aluno.
- **Empréstimo e Devolução de Livros:** Os alunos podem emprestar livros disponíveis e devolvê-los após a leitura.
- **Pesquisa de Livros:** Os usuários podem pesquisar livros por curso (categoria) e ver uma lista de livros disponíveis e indisponíveis para empréstimos.
- **Avaliação de Livros:** Os alunos podem avaliar os livros após a devolução, fornecendo uma classificação de 0 a 5.
- **Gerenciamento de Livros:** Os funcionários podem adicionar, remover e atualizar informações de livros, como título, autor e categoria.
- **Easter Egg:** Há um easter egg oculto no sistema para entretenimento.

## Estrutura do Código

- **`Main`:** Classe principal que contém o método `main` e o menu inicial do sistema.
- **`Cliente` e `Funcionario`:** Classes que representam os usuários do sistema, com métodos para login, cadastro e operações específicas de cada tipo de usuário.
- **`Biblioteca`:** Classe que gerencia os livros e clientes da biblioteca, incluindo métodos para imprimir listas e buscar livros por ID.
- **`Categoria` e `Livro`:** Classes que representam as categorias de livros e os próprios livros, com métodos para pesquisa, cadastro e remoção.
- **`Emprestimo`:** Classe que trata das operações de empréstimo e devolução de livros, incluindo a avaliação.
- **`Utils`:** Classe utilitária para gerar IDs aleatórios.

## Screenshots
### Menu Inicial:
![image](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/133005094/a050d7a0-6533-4e6c-ad38-49bbae4e9b11)

### Interface Aluno:
#### Cadastro:
![print aluno 1](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/142945811/2e452809-a6ff-46a7-90cd-13b7ad1b0f60)
#### Login:
![print aluno 2](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/142945811/69cbd1e8-1ea5-423d-9bc5-f80849a409d0)
### Interface Funcionário:
#### Cadastro:
![print funcionario 2](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/142945811/c7abfb05-9a80-4f2c-951e-c4607e418bbe)
#### Login:
![print funcionario 1](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/142945811/2304a0bc-6b29-4da2-8e38-4e88c284e3c6)


