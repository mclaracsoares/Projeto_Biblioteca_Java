import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;




class Emprestimo implements Serializable {
   private Date dataEmprestimo;
   private Date dataDevolucao;
   private Cliente cliente;
   private double avaliacao;
   private static List<Emprestimo> historicoEmprestimos = new ArrayList<>();


   public Emprestimo(Date dataEmprestimo, Cliente cliente) {
       this.dataEmprestimo = dataEmprestimo;
       this.cliente = cliente;
       this.avaliacao = -1; // Valor para indicar que ainda não foi avaliado
   }


   public Date getDataEmprestimo() {
       return dataEmprestimo;
   }


   public Date getDataDevolucao() {
       return dataDevolucao;
   }


   public Cliente getCliente() {
       return cliente;
   }


   public double getAvaliacao() {
       return avaliacao;
   }


   public static List<Emprestimo> getHistoricoEmprestimos() {
       return historicoEmprestimos;
   }


   public static void imprimirHistoricoEmprestimos() {
       System.out.println("\n=== Histórico de Empréstimos do Livro ===");
       List<Emprestimo> historico = getHistoricoEmprestimos();
       if (historico.isEmpty()) {
           System.out.println("O livro ainda não foi emprestado.");
           return;
       }


       for (Emprestimo emprestimo : historico) {
           System.out.println("Data de Empréstimo: " + emprestimo.getDataEmprestimo());
           System.out.println("Nome de usuario do aluno: " + emprestimo.getCliente().getNome());
           System.out.println("ID do aluno: " + emprestimo.getCliente().getIdCliente());
           if (emprestimo.getDataDevolucao() != null) {
               System.out.println("Data de Devolução: " + emprestimo.getDataDevolucao());
           } else {
               System.out.println("Ainda não devolvido.");
           }
           if (emprestimo.getAvaliacao() >= 0) {
               System.out.println("Avaliação do Aluno: " + emprestimo.getAvaliacao());
           } else {
               System.out.println("Livro ainda não avaliado pelo aluno.");
           }
           System.out.println();
       }
   }




   public static void verLivrosEmprestados() {
       System.out.println("\n===== Livros Emprestados =====");
       for (Cliente cliente : Biblioteca.getListaClientes()) {
           System.out.println("Aluno: " + cliente.getNome());
           for (Livro livro : cliente.getLivrosEmprestados()) {
               System.out.println("Livro: " + livro.getTitulo());
           }
       }
   }


   public static void devolverLivro() {
       System.out.println("\n===== Devolver Livro =====");
       System.out.print("ID do Livro: ");
       int idLivro = Main.scanner.nextInt();


       Livro livro = Biblioteca.buscarLivroPorID(idLivro);


       if (livro != null) {
           if (!livro.isDisponivel()) { // Verifica se o livro está emprestado
               livro.setDisponivel(true); // Marca o livro como disponível novamente
               Main.usuarioLogado.getLivrosEmprestados().remove(livro); // Remove o livro dos empréstimos do usuário
               System.out.println("Livro devolvido com sucesso!");


               // Perguntar ao usuário se deseja avaliar o livro
               System.out.print("Deseja avaliar este livro?");
               char resposta = Main.scanner.next().toLowerCase().charAt(0);
               if (resposta == 's') {
                   System.out.print("De 0 a 5, Qual sua avaliação para esse livro?");
                   float avaliacao = Main.scanner.nextFloat();
                   while (avaliacao < 0 || avaliacao > 5) {
                       System.out.print("Insira uma avaliação válida entre 0 e 5: ");
                       avaliacao = Main.scanner.nextFloat();
                   }
                   livro.setAvaliacao(avaliacao);
                   System.out.println("Obrigado pela avaliação");
               } else {
                   System.out.println("Livro devolvido sem avaliação");
               }
           } else {
               System.out.println("Este livro atualmente ainda está disponivel");
           }
       } else {
           System.out.println("Livro não encontrado.");
       }
   }


   public static void emprestarLivro() {
       if (Biblioteca.getListaLivros().isEmpty()) {
           System.out.println("Não há livros disponíveis para empréstimo no momento");
           return;
       }
       System.out.println("\n===== Emprestar Livro =====");
       System.out.print("ID do Livro: ");
       int idLivro = Main.scanner.nextInt();


       Livro livro = Biblioteca.buscarLivroPorID(idLivro);


       if (livro != null) {
           if (livro.isDisponivel()) { // Verifica se o livro está disponível para empréstimo
               livro.setDisponivel(false); // Marca o livro como indisponível
               Main.usuarioLogado.getLivrosEmprestados().add(livro); // Adiciona o livro aos empréstimos do usuário
               Date dataEmprestimo = new Date(); // Data atual
               Emprestimo emprestimo = new Emprestimo(dataEmprestimo, Main.usuarioLogado);
               getHistoricoEmprestimos().add(emprestimo); // Adiciona o empréstimo ao histórico do livro
               System.out.println("Livro emprestado com sucesso!");
           } else {
               System.out.println("Este livro atualmente não está disponível para empréstimo.");
           }
       } else {
           System.out.println("Livro não encontrado.");
       }
   }
}
