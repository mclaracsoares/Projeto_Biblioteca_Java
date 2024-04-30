// classe categoria:
import java.io.Serializable;
import java.util.ArrayList;

class Categoria implements Serializable {
    private final String nome;
    private ArrayList<Livro> livros;

    public Categoria(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
    }
    // Método estático para pesquisar livros por curso
    public static void pesquisarLivroPorCurso() {
        System.out.println("\n╭─────────────────────── Pesquisar Livro por Curso ─────────────────────╮");
        System.out.println("│                                                                         │");
        System.out.println("│   1. Administração                                                      │");
        System.out.println("│   2. Direito                                                            │");
        System.out.println("│   3. Computação                                                         │");
        System.out.println("│   4. Medicina                                                           │");
        System.out.println("│   5. Psicologia                                                         │");
        System.out.println("│   6. Odontologia                                                        │");
        System.out.println("│                                                                         │");
        System.out.println("╰─────────────────────────────────────────────────────────────────────────╯");
        System.out.print("Escolha um curso: ");
        int opcaoGenero = Main.scanner.nextInt();

        switch (opcaoGenero) {
            case 1:
                pesquisarLivroPorCurso("Administração");
                break;
            case 2:
                pesquisarLivroPorCurso("Direito");
                break;
            case 3:
                pesquisarLivroPorCurso("Computação");
                break;
            case 4:
                pesquisarLivroPorCurso("Medicina");
                break;
            case 5:
                pesquisarLivroPorCurso("Psicologia");
                break;
            case 6:
                pesquisarLivroPorCurso("Odontologia");
                break;
            default:
                System.out.println("╭─────────────────────────────────────────────────────────────────────╮");
                System.out.println("│ Opção inválida. Por favor, escolha novamente.                       │");
                System.out.println("╰─────────────────────────────────────────────────────────────────────╯");
        }
    }
    // Método para pesquisar livros por curso com base no nome do curso
    public static void pesquisarLivroPorCurso(String genero) {
        System.out.println("\n╭──────────────────── Livros no gênero de " + genero + " ────────────────────╮");
        for (Livro livro : Biblioteca.getListaLivros()) {
            if (livro.getCategoria().getNome().equalsIgnoreCase(genero)) {
                System.out.println("│ Título: " + livro.getTitulo());
                System.out.println("│ Autor: " + livro.getAutor());
                System.out.println("│"); // Linha em branco entre cada livro
            }
            System.out.println("╰─────────────────────────────────────────────────────────────────────────╯");

        }
    }
    // Método getter para obter o nome da categoria
    public String getNome() {
        return nome;
    }
    // Método getter para obter a lista de livros da categoria
    public ArrayList<Livro> getLivros() {
        return livros;
    }
}