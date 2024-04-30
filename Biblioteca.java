import java.util.ArrayList;
import java.io.Serializable;


public class Biblioteca implements Serializable {
   private static ArrayList<Livro> listaLivros = null;
   private static ArrayList<Cliente> listaClientes = null;


   public Biblioteca() {
       listaLivros = new ArrayList<>();
       listaClientes = new ArrayList<>();
   }


   public static void imprimirListaLivros(boolean disponiveis) {
       System.out.println("\n=== Lista de Livros ===");
       for (Livro livro : listaLivros) {
           if (livro.isDisponivel() == disponiveis) {
               String status = disponiveis ? "Disponível" : "Indisponível";
               System.out.println("Nome: " + livro.getTitulo());
               System.out.println("ID: " + livro.getIdLivro());
               System.out.println("Curso: " + livro.getCategoria().getNome());
               System.out.println("Status: " + status);
               System.out.println();
           }
       }
   }


   public static void imprimirHistoricoLeitura() {
       System.out.println("\n===== Histórico de Leitura do Usuário =====");
       System.out.println("Livros lidos por " + Main.usuarioLogado.getNome() + ":");


       if (Main.usuarioLogado.getLivrosEmprestados().isEmpty()) {
           System.out.println("O usuário ainda não leu nenhum livro.");
           return;
       }
       for (Livro livro : Main.usuarioLogado.getLivrosEmprestados()) {
           System.out.println("Título: " + livro.getTitulo());
           System.out.println("ID: " + livro.getIdLivro());
           System.out.println("Gênero: " + livro.getCategoria().getNome());
           System.out.println("Status: " + (livro.isDisponivel() ? "Disponível" : "Indisponível"));
           System.out.println();
       }
   }
   public static ArrayList<Livro> getListaLivros() {
       return listaLivros;
   }
   public static ArrayList<Cliente> getListaClientes() {
       return listaClientes;
   }
   public static Livro buscarLivroPorID(int idLivro) {
       for (Livro livro : listaLivros) {
           if (livro.getIdLivro() == idLivro) {
               return livro;
           }
       }
       return null; // se nao encontrar livro c ID
   }
}
