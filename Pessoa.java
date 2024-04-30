import java.io.Serializable;
import java.util.ArrayList;


class Pessoa implements Serializable {
   public String nome;


public Pessoa(String nome) {
   this.nome = nome;
}




   public String getNome() {
       return nome;
   }
}
class Cliente extends Pessoa implements Serializable {
   private final int idCliente;
   private final String senha;
   private final ArrayList<Livro> livrosEmprestados;


   public Cliente(String nome, String senha, int idCliente) {
       super(nome);
       this.senha = senha;
       this.idCliente = idCliente;
       this.livrosEmprestados = new ArrayList<>();
   }


   public static void adicionarCliente(Cliente cliente) {
       Biblioteca.getListaClientes().add(cliente);
   }


   public static void menuUsuario() {
       System.out.println("\n===== Menu Aluno =====");
       System.out.println("1. Fazer login");
       System.out.println("2. Cadastrar");
       System.out.println("3. Voltar");
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
       System.out.println("\n===== Login de Aluno =====");
       System.out.print("Nome de usuário: ");
       String nomeUsuario = Main.scanner.next().toLowerCase();
       System.out.print("Senha: ");
       String senha = Main.scanner.next();


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
       System.out.println("\n===== Cadastro do Aluno =====");
       System.out.print("Nome de usuário: ");
       String nome = Main.scanner.next();


       // Verifica se o nome de usuário já existe (sem diferenciar maiúsculas e minúsculas)
       for (Cliente cliente : Biblioteca.getListaClientes()) {
           if (cliente.getNome().equalsIgnoreCase(nome)) {
               System.out.println("Este nome de usuário já está em uso. Escolha outro.");
               return; // Retorna ao menu
           }
       }
       System.out.print("Senha: ");
       String senha = Main.scanner.next();


       // ID único para o novo usuário
       int idUsuario = Utils.gerarIDAleatorio();


       Cliente novoCliente = new Cliente(nome, senha, idUsuario);


       adicionarCliente(novoCliente); // Adiciona o novo cliente à lista de clientes da biblioteca


       System.out.println("Usuário cadastrado com sucesso! Seu ID é: " + idUsuario);
   }


   public static void menuOperacoesUsuario() {
       int opcao;
       // Loop principal do menu de operações do usuário
       do {
           System.out.println("\n===== Menu de Opções do Aluno =====");
           System.out.println("1. Emprestimo de livro");
           System.out.println("2. Devolver livro");
           System.out.println("3. Lista de livros");
           System.out.println("4. Pesquisar livro por gênero");
           System.out.println("5. Histórico de empréstimos");
           System.out.println("6. Ver ID do aluno");
           System.out.println("7. Livros mais bem avaliados");
           System.out.println("8. Fazer Logout");
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
                   System.out.println("\n=== Lista de Livros Disponíveis ===");
                   Biblioteca.imprimirListaLivros(true); // imprime apenas livros disponíveis
                   System.out.println("\n=== Lista de Livros Indisponíveis ===");
                   Biblioteca.imprimirListaLivros(false); // Imprime apenas livros indisponíveis
                   break;
               case 4:
                   Categoria.pesquisarLivroPorCurso();
                   break;
               case 5:
                   System.out.println("\n===== Histórico =====");
                   System.out.println("Escolha uma opção:");
                   System.out.println("1. Histórico de empréstimos de livros");
                   System.out.println("2. Histórico de leitura do usuário");
                   System.out.print("Opção: ");
                   int opcaoHistorico = Main.scanner.nextInt();
                   switch (opcaoHistorico) {
                       case 1:
                           Emprestimo.imprimirHistoricoEmprestimos();
                           break;
                       case 2:
                           Biblioteca.imprimirHistoricoLeitura();
                           break;
                       default:
                           System.out.println("Opção inválida.");
                   }
                   break;
               case 6:
                   System.out.println("Seu ID de usuário é: " + Main.usuarioLogado.getIdCliente());
                   break;
               case 7:
                   Livro.listarLivrosMaisBemAvaliados();
                   break;
               case 8:
                   Main.usuarioLogado = null; // Faz logout, limpando o usuário logado
                   System.out.println("Voltando ao menu inicial...");
                   break;
               default:
                   System.out.println("Opção inválida. Por favor, escolha novamente.");


           }
       } while (opcao != 8); // continua no loop


       System.out.print("Digite 'easter' para um Easter Egg: ");
       String easterInput = Main.scanner.next().toLowerCase();
       if (easterInput.equals("easter")) {
           ativarEasterEgg();
       }
   }




   private static void ativarEasterEgg() {
       System.out.println("Surpresa! Você encontrou o Easter Egg!");
       System.out.println("Parabéns! Aqui está uma piada para você:");
       System.out.println("Por que o programador foi preso durante as férias?");
       System.out.println("Porque ele deletou todos os seus cookies!");
       // Você pode adicionar mais interações especiais aqui
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




class Funcionario extends Pessoa implements Serializable {
   public Funcionario(String nome) {
       super(nome);
   }


   public static void cadastrarFuncionario() {
       System.out.println("Favor entrar em contato diretamente com a direção.");
   }


   public static void menuOperacoesFuncionario() {
       int opcao;
       do {
           System.out.println("\n===== Menu de Operações do Funcionário =====");
           System.out.println("1. Adicionar Livro");
           System.out.println("2. Remover Livro");
           System.out.println("3. Atualizar Nome do Livro");
           System.out.println("4. Ver Livros Emprestados");
           System.out.println("5. Ver Avaliações dos Livros");
           System.out.println("6. Fazer Logout");
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
                   Livro.verAvaliacoesLivros();
                   break;
               case 6:
                   System.out.println("Saindo");
                   break;
               default:
                   System.out.println("Opção inválida. Escolha novamente.");
           }
       } while (opcao != 6);
   }




   public static void menuFuncionario() {
       System.out.println("\n===== Menu Funcionário =====");
       System.out.println("1. Fazer login");
       System.out.println("2. Cadastrar");
       System.out.println("3. Voltar");
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
               System.out.println("Voltando ao menu inicial...");
               break;
           default:
               System.out.println("Opção inválida. Por favor, escolha novamente.");
       }
   }


   public static void fazerLoginFuncionario() {
       System.out.println("\n===== Login de Funcionário =====");
       System.out.print("Senha: ");
       String senha = Main.scanner.next();


       if (senha.equals("UNICAP2024")) {
           System.out.println("Login de funcionário bem-sucedido!");
           Funcionario.menuOperacoesFuncionario();
       } else {
           System.out.println("Senha incorreta. Tente novamente.");
       }
   }
}
