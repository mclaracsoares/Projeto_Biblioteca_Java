// classe pessoa, cliente e funcionario:
import java.util.ArrayList;
import java.util.Comparator;

class Pessoa {
    public String nome;
    private static ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    public Pessoa(String nome) {
        this.nome = nome;
        listaPessoas.add(this); // Adiciona a pessoa à lista ao ser criada
    }
    public static ArrayList<Pessoa> getListaPessoas() {
        return listaPessoas;
    }
    public String getNome() {
        return nome;
    }
}

class Cliente extends Pessoa {
    private final int idCliente;
    private final String senha;
    private final ArrayList<Livro> livrosEmprestados;

    public Cliente(String nome, String senha, int idCliente) {
        super(nome);
        this.senha = senha;
        this.idCliente = idCliente;
        this.livrosEmprestados = new ArrayList<>();
    }

    public static void adicionarCliente(String nome, String senha) {
        int id = Utils.gerarIDAleatorio();
        Cliente cliente = new Cliente(nome, senha, id);
        Biblioteca.getListaClientes().add(cliente);
        System.out.println("Aluno adicionado com sucesso!");
    }

    public static void menuUsuario() {
        System.out.println("\n╭─────────────────────── Menu Aluno ────────────────────────╮");
        System.out.println("│                                                           │");
        System.out.println("│   ╭───────────────────────────────────────────────────╮   │");
        System.out.println("│   │                   Opções:                         │   │");
        System.out.println("│   │                                                   │   │");
        System.out.println("│   │   1. Fazer login                                  │   │");
        System.out.println("│   │   2. Cadastrar                                    │   │");
        System.out.println("│   │   3. Voltar                                       │   │");
        System.out.println("│   │                                                   │   │");
        System.out.println("│   ╰───────────────────────────────────────────────────╯   │");
        System.out.println("│                                                           │");
        System.out.println("╰───────────────────────────────────────────────────────────╯");
        System.out.print("Escolha uma opção: ");
        int opcao = Main.scanner.nextInt();

        switch (opcao) {
            case 1:
                fazerLoginUsuario();
                break;
            case 2:
                cadastrarUsuario();
                break;
            case 3:
                System.out.println("Voltando ao menu inicial...");
                break;
            default:
                System.out.println("Opção inválida. Escolha novamente.");
        }
    }

    public static void fazerLoginUsuario() {
        System.out.println("\n╭─────────────────────── Login de Aluno ───────────────────╮");
        System.out.print("│ Nome de usuário: ");
        String nomeUsuario = Main.scanner.next().toLowerCase();
        System.out.print("│ Senha: ");
        String senha = Main.scanner.next();
        System.out.println("╰──────────────────────────────────────────────────────────╯");


        // Verificar o login de usuário
        Main.usuarioLogado = verificarLoginUsuario(nomeUsuario, senha);
        if (Main.usuarioLogado != null) {
            menuOperacoesUsuario();
        } else {
            System.out.println("Usuário ou senha incorretos. Tente novamente.");
        }
    }

    public static Cliente verificarLoginUsuario(String nomeUsuario, String senha) {
        String nomeUsuarioLower = nomeUsuario.toLowerCase(); // Converter para minúsculas
        for (Cliente cliente : Biblioteca.getListaClientes()) {
            if (cliente.getNome().toLowerCase().equals(nomeUsuarioLower) && cliente.verificarSenha(senha)) {
                return cliente;
            }
        }
        return null;
    }

    public static void cadastrarUsuario() {
        System.out.println("\n╭───────────────────── Cadastro do Aluno ─────────────────╮");
        System.out.print("│ Nome de usuário: ");
        String nome = Main.scanner.next();

        // Verifica se o nome de usuário já existe (sem diferenciar maiúsculas e minúsculas)
        for (Cliente cliente : Biblioteca.getListaClientes()) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                System.out.println("│ Este nome de usuário já está em uso. Escolha outro.    ");
                System.out.println("╰─────────────────────────────────────────────────────────╯");
                return; // Retorna ao menu
            }
        }
        System.out.print("│ Senha: ");
        String senha = Main.scanner.next();

        // ID único para o novo usuário
        int idUsuario = Utils.gerarIDAleatorio();

        Cliente novoCliente = new Cliente(nome, senha, idUsuario);

        Biblioteca.getListaClientes().add(novoCliente);

        System.out.println("│ Usuário cadastrado com sucesso! Seu ID é: " + idUsuario + "            ");
        System.out.println("╰─────────────────────────────────────────────────────────╯");
    }

    public static void menuOperacoesUsuario() {
        int opcao;
        do {
            System.out.println("\n╭────────────────────────── Menu de Opções do Aluno ──────────────────────────╮");
            System.out.println("│                                                                             │");
            System.out.println("│   1. Emprestimo de livro                                                    │");
            System.out.println("│   2. Devolver livro                                                         │");
            System.out.println("│   3. Lista de livros                                                        │");
            System.out.println("│   4. Pesquisar livro por curso                                              │");
            System.out.println("│   5. Ver ID do aluno                                                        │");
            System.out.println("│   6. Ranking dos livros                                                     │");
            System.out.println("│   7. Fazer Logout                                                           │");
            System.out.println("│                                                                             │");
            System.out.println("╰─────────────────────────────────────────────────────────────────────────────╯");
            System.out.print("Escolha uma opção: ");

            opcao = Main.scanner.nextInt();

            switch (opcao) {
                case 1:
                    Emprestimo.emprestarLivro();
                    break;
                case 2:
                    Emprestimo.devolverLivro();
                    break;
                case 3:
                    System.out.println("\n──── Lista de Livros Disponíveis ────");
                    Biblioteca.imprimirListaLivros(true);
                    System.out.println("\n──── Lista de Livros Indisponíveis ──── ");
                    Biblioteca.imprimirListaLivros(false); // Imprime apenas livros indisponíveis

                    break;
                case 4:
                    Categoria.pesquisarLivroPorCurso();
                    break;
                case 5:
                    System.out.println("╭────────────────────────────────────────────────────╮");
                    System.out.println("│ Seu ID de usuário é: " + Main.usuarioLogado.getIdCliente() + "                                │");
                    System.out.println("╰────────────────────────────────────────────────────╯");
                    break;
                case 6:
                    Livro.listarLivrosMaisBemAvaliados();
                    break;
                case 7:
                    Main.usuarioLogado = null; // Faz logout, limpando o usuário logado
                    System.out.println("╭────────────────────────────────────────────────────╮");
                    System.out.println("│             Voltando ao menu inicial...            │");
                    System.out.println("╰────────────────────────────────────────────────────╯");
                    break;
                default:
                    System.out.println("╭────────────────────────────────────────────────────╮");
                    System.out.println("│    Opção inválida. Por favor, escolha novamente.   │");
                    System.out.println("╰────────────────────────────────────────────────────╯");

            }
        } while (opcao != 7); // continua no loop

        System.out.println("╭────────────────────────────────────────────────────╮");
        System.out.println("│ Digite 'easter' para um Easter Egg:                │");
        System.out.println("╰────────────────────────────────────────────────────╯");

        String easterInput = Main.scanner.next().toLowerCase();
        if (easterInput.equals("easter")) {
            ativarEasterEgg();
        }
    }

    private static void ativarEasterEgg() {
        System.out.println("╭────────────────────────────────────────────────────╮");
        System.out.println("│ Surpresa! Você encontrou o Easter Egg!             │");
        System.out.println("│ Parabéns! Aqui está uma piada para você:           │");
        System.out.println("│                                                    │");
        System.out.println("│ Por que o programador foi preso durante as férias? │");
        System.out.println("│ Porque ele deletou todos os seus cookies!          │");
        System.out.println("╰────────────────────────────────────────────────────╯");

    }

    public int getIdCliente() {
        return idCliente;
    }

    public ArrayList<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }
}

class Funcionario extends Pessoa {
    public Funcionario(String nome) {
        super(nome);
    }

    public static void cadastrarFuncionario() {
        System.out.println("╭────────────────────────────────────────────────────╮");
        System.out.println("│ Favor entrar em contato diretamente com a direção. │");
        System.out.println("╰────────────────────────────────────────────────────╯");

    }

    public static void menuOperacoesFuncionario() {
        int opcao;
        do {
            System.out.println("\n╭────────────────────── Menu de Operações do Funcionário ─────────────────────╮");
            System.out.println("│                                                                             │");
            System.out.println("│   1. Adicionar Livro                                                        │");
            System.out.println("│   2. Remover Livro                                                          │");
            System.out.println("│   3. Atualizar Nome do Livro                                                │");
            System.out.println("│   4. Ver Livros Emprestados                                                 │");
            System.out.println("│   5. Ver Avaliações dos Livros                                              │");
            System.out.println("│   6. Fazer Logout                                                           │");
            System.out.println("│                                                                             │");
            System.out.println("╰─────────────────────────────────────────────────────────────────────────────╯");
            System.out.print("Escolha uma opção: ");
            opcao = Main.scanner.nextInt();

            switch (opcao) {
                case 1:
                    Livro.cadastrarLivro();
                    break;
                case 2:
                    Livro.removerLivro();
                    break;
                case 3:
                    Livro.atualizarLivro();
                    break;
                case 4:
                    Emprestimo.verLivrosEmprestados();
                    break;
                case 5:
                    System.out.println("\n╭───────────────────── Avaliações dos Livros ───────────────────╮");
                    ArrayList<Livro> livrosOrdenados = new ArrayList<>(Biblioteca.getListaLivros());
                    livrosOrdenados.sort(Comparator.comparingDouble(Livro::getAvaliacao).reversed());
                    int count = 1;
                    for (Livro livro : livrosOrdenados) {
                        if (livro.getAvaliacao() > 0) {
                            System.out.println("│ " + count + ". Título: " + livro.getTitulo());
                            System.out.println("│    Avaliação: " + livro.getAvaliacao()); // Aqui está a correção
                            System.out.println("│    Autor: " + livro.getAutor());
                            System.out.println("│    ID: " + livro.getIdLivro());
                            System.out.println("│    Curso: " + livro.getCategoria().getNome());
                            System.out.println("│");
                            count++;
                        }
                    }
                    if (count == 1) {
                        System.out.println("│ Nenhum livro foi avaliado ainda.");
                    }
                    System.out.println("╰────────────────────────────────────────────────────────────────────╯");

                case 6:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }
        } while (opcao != 6);
    }

    public static void menuFuncionario() {
        System.out.println("\n╭─────────────────────── Menu Funcionário ─────────────────────╮");
        System.out.println("│                                                              │");
        System.out.println("│   1. Fazer login                                             │");
        System.out.println("│   2. Cadastrar                                               │");
        System.out.println("│   3. Voltar                                                  │");
        System.out.println("│                                                              │");
        System.out.println("╰──────────────────────────────────────────────────────────────╯");
        System.out.print("Escolha uma opção: ");

        int opcao = Main.scanner.nextInt();
        switch (opcao) {
            case 1:
                fazerLoginFuncionario();
                break;
            case 2:
                Funcionario.cadastrarFuncionario();
                break;
            case 3:
                System.out.println("╭────────────────────────────────────────────────────────────╮");
                System.out.println("│                 Voltando ao menu inicial...                │");
                System.out.println("╰────────────────────────────────────────────────────────────╯");
                break;
            default:
                System.out.println("╭────────────────────────────────────────────────────────────╮");
                System.out.println("│ Opção inválida. Por favor, escolha novamente.              │");
                System.out.println("╰────────────────────────────────────────────────────────────╯");
        }
    }

    public static void fazerLoginFuncionario() {
        System.out.println("\n╭─────────────────────── Login de Funcionário ─────────────────────╮");
        System.out.print("│ Senha: ");
        String senha = Main.scanner.next();

        if (senha.equals("UNICAP2024")) {
            System.out.println("│ Login de funcionário bem-sucedido!                               ");
            Funcionario.menuOperacoesFuncionario();
            System.out.println("╰───────────────────────────────────────────────────────────────────╯");
        } else {
            System.out.println("│ Senha incorreta. Tente novamente.                                │");
        }

    }
}
