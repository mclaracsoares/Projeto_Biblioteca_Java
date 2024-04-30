// classe biblioteca:

import java.util.ArrayList;

public class Biblioteca {
    private static ArrayList<Livro> listaLivros = new ArrayList<>();;
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();

    public Biblioteca() {
        listaLivros = new ArrayList<>();
        listaClientes = new ArrayList<>();
    }

    public static void imprimirListaLivros(boolean disponiveis) {
        System.out.println("\n╭─────────────────────── Lista de Livros ───────────────────────╮");
        for (Livro livro : listaLivros) {
            if (livro.isDisponivel() == disponiveis) {
                String status = disponiveis ? "Disponível" : "Indisponível";
                System.out.println("│ Nome: " + livro.getTitulo());
                System.out.println("│ ID: " + livro.getIdLivro());
                System.out.println("│ Curso: " + livro.getCategoria().getNome());
                System.out.println("│ Status: " + status);
                System.out.println("│"); // Linha em branco entre cada livro
            }
        }
        System.out.println("╰──────────────────────────────────────────────────────────────╯");
    }
    // Método getter para obter a lista de livros
    public static ArrayList<Livro> getListaLivros() {
        return listaLivros;
    }
    // Método getter para obter a lista de clientes
    public static ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    // Método para buscar um livro pelo ID
    public static Livro buscarLivroPorID(int idLivro) {
        for (Livro livro : listaLivros) {
            if (livro.getIdLivro() == idLivro) {
                return livro;
            }
        }
        return null; // se nao encontrar livro c ID
    }
}