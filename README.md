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
![image](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/133005094/628864b7-3abf-4646-81a7-8140d6a2f42d)

### Emprestimo de Livro:
![image](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/133005094/90bf039f-cd01-4bc1-b433-80a45f2a8625)
### Devolver Livro Emprestado
![image](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/133005094/c247bf73-b8b1-4dc2-9ce8-3ac1c9675dd0)
### Devolver Livro Não Emprestado
![image](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/133005094/6363baf4-1a8d-48b1-b2e8-d37e3ae8b43b)
### Lista Livros
![image](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/133005094/d58ab959-1dd8-484e-abda-aefd7d089304)
### Pesquisar Livro por Curso
![image](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/133005094/f343d9a3-13f6-4ec9-8e38-7762f7b95f52)
### Ver ID do Aluno Logado
![image](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/133005094/9ea47894-f3be-4d85-ac86-1a92194155c6)
### Ver Ranking dos Livros
![image](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/133005094/43ab406d-9669-4279-be89-4559da71e8a8)
### Easter Egg no Logout
![image](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/133005094/11bdad3b-5723-4e89-b2d3-ac0e1fc0e8af)


### Interface Funcionário:
#### Cadastro:
![print funcionario 2](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/142945811/c7abfb05-9a80-4f2c-951e-c4607e418bbe)
#### Login:
![print funcionario 1](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/142945811/2304a0bc-6b29-4da2-8e38-4e88c284e3c6)
### Cadastro de Livro
![image](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/133005094/3bf552d2-911a-490e-ba95-5e0f17cb9a59)
### Remover Livros
![image](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/133005094/62dca1a2-4359-4e50-932e-736ebfe83406)
### Lista de Livros Emprestados
![image](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/133005094/a6d9bd9a-88f1-4d79-86a2-954ca3daf6a6)
### Atualizar Nome do Livro
- Antes
![image](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/133005094/5df72e82-3da1-4c52-9bdb-8a1530d3dfcf)
- Depois
![image](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/133005094/1bb1011b-adfa-432b-90df-749c0d09ebc5)
### Ver Avaliação dos Livros
![image](https://github.com/mclaracsoares/Projeto_Biblioteca_Java/assets/133005094/3fb74315-a701-4b3d-a148-395f377bdc41)
