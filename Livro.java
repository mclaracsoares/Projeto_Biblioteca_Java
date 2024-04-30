// classe livro:
// Classe Livro

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

class Livro implements Serializable {

    private double avaliacao; // Avaliação média do livro
    private String titulo; // Título do livro
    private String autor; // Autor do livro
    private final int idLivro; // ID único do livro
    private boolean disponivel; // Indica se o livro está disponível para empréstimo
    private Categoria categoria; // Categoria à qual o livro pertence
    private ArrayList<Emprestimo> historicoEmprestimos; // Histórico de empréstimos do livro

    // Construtor da classe Livro
    public Livro(String titulo, String autor, int idLivro, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.idLivro = idLivro;
        this.categoria = categoria;
        this.disponivel = true;
        this.historicoEmprestimos = new ArrayList<>();
        this.avaliacao = 0;
    }

    public static void listarLivrosMaisBemAvaliados() {
        System.out.println("\n===== Livros Mais Bem Avaliados =====");
        ArrayList<Livro> livrosOrdenados = new ArrayList<>(Biblioteca.getListaLivros());
        livrosOrdenados.sort(Comparator.comparingDouble(Livro::getAvaliacao).reversed());
        int count = 1;
        for (Livro livro : livrosOrdenados) {
            if (livro.getAvaliacao() > 0) {
                System.out.println(count + ". Título: " + livro.getTitulo());
                System.out.println("   Avaliação: " + livro.avaliacao); // Aqui está a correção
                System.out.println("   Autor: " + livro.getAutor());
                System.out.println("   ID: " + livro.getIdLivro());
                System.out.println("   Curso: " + livro.getCategoria().getNome());
                count++;
            }
        }
        if (count == 1) {
            System.out.println("Nenhum livro foi avaliado ainda.");
        }
    }

    public static void verAvaliacoesLivros() {
        System.out.println("\n===== Avaliações dos Livros =====");
        for (Livro livro : Biblioteca.getListaLivros()) {
            if (livro.getAvaliacao() != 0) {
                System.out.println("Livro: " + livro.getTitulo());
                System.out.println("Avaliação: " + livro.getAvaliacao());
            }
        }
    }
    public static void cadastrarLivro() {
        System.out.println("\n╭─────────────────────── Cadastro de Livro ───────────────────────╮");
        Main.scanner.nextLine(); // buffer - quebra de linha
        System.out.print("│ Título: ");
        String titulo = Main.scanner.nextLine();
        System.out.print("│ Autor: ");
        String autor = Main.scanner.nextLine();
        System.out.print("│ ID do Livro: ");
        int idLivro = Main.scanner.nextInt();

        // verifica se o ID do livro já foi usado anteriormente
        if (livroComMesmoIdExiste(idLivro)) {
            System.out.println("│ Já existe um livro cadastrado com esse ID. Por favor, escolha outro ID.");
            System.out.println("╰──────────────────────────────────────────────────────────────╯");
            return;
        }

        // Exibir opções de curso
        System.out.println("│ Escolha o curso do livro:");
        System.out.println("│ 1. Administração");
        System.out.println("│ 2. Direito");
        System.out.println("│ 3. Computação");
        System.out.println("│ 4. Medicina");
        System.out.println("│ 5. Psicologia");
        System.out.println("│ 6. Odontologia");
        System.out.print("│ Opção: ");
        int opcaoGenero = Main.scanner.nextInt();
        String genero = switch (opcaoGenero) {
            case 1 -> "Administração";
            case 2 -> "Direito";
            case 3 -> "Computação";
            case 4 -> "Medicina";
            case 5 -> "Psicologia";
            case 6 -> "Odontologia";
            default -> {
                System.out.println("│ Opção inválida. O livro será cadastrado como 'Outros'.");
                yield "Outros";
            }
        };

        Categoria novaCategoria = new Categoria(genero);

        // cria um novo livro e adicionar à biblioteca
        Livro novoLivro = new Livro(titulo, autor, idLivro, novaCategoria);
        adicionarLivro(novoLivro); // Aqui você deve implementar o método adicionarLivro()
        System.out.println("│ Livro cadastrado com sucesso!");
        System.out.println("╰──────────────────────────────────────────────────────────────╯");
    }

    private static boolean livroComMesmoIdExiste(int idLivro) {
        for (Livro livro : Biblioteca.getListaLivros()) {
            if (livro.getIdLivro() == idLivro) {
                return true;
            }
        }
        return false;
    }

    public static void adicionarLivro(Livro livro) {
        Biblioteca.getListaLivros().add(livro);
        // Adicionar o livro à sua categoria - aprimorar
        livro.getCategoria().getLivros().add(livro);
    }

    public static void removerLivro() {
        System.out.println("\n╭─────────────────────── Remover Livro ────────────────────────╮");
        System.out.print("│ ID do Livro a ser removido: ");
        int idLivro = Main.scanner.nextInt();
        Main.scanner.nextLine(); // Consumir a quebra de linha pendente

        Livro livro = Biblioteca.buscarLivroPorID(idLivro);

        if (livro != null) {
            // Remove o livro da lista de livros da biblioteca
            Biblioteca.getListaLivros().remove(livro);
            // Remove o livro da lista de livros da categoria
            livro.getCategoria().getLivros().remove(livro);
            System.out.println("│ Livro removido com sucesso!                                  │");
        } else {
            System.out.println("│ Livro não encontrado.                                        │");
        }
        System.out.println("╰──────────────────────────────────────────────────────────────╯");
    }
    public static void atualizarLivro() {
        System.out.println("\n╭────────────────────── Atualizar Livro ───────────────────────╮");
        System.out.print("│ ID do Livro a ser atualizado: ");
        int idLivro = Main.scanner.nextInt();
        Main.scanner.nextLine(); // Consumir a quebra de linha pendente

        Livro livro = Biblioteca.buscarLivroPorID(idLivro);

        if (livro != null) {
            System.out.print("│ Novo Título: ");
            String novoTitulo = Main.scanner.nextLine();
            livro.setTitulo(novoTitulo);
            System.out.println("│ Livro atualizado com sucesso!                                │");
        } else {
            System.out.println("│ Livro não encontrado.                                        │");
        }
        System.out.println("╰──────────────────────────────────────────────────────────────╯");
    }

    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
    }
    public double getAvaliacao() {
        return this.avaliacao;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public int getIdLivro() {
        return idLivro;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public void avaliarLivro(double avaliacao) {
        this.avaliacao = (this.avaliacao + avaliacao) / 2.0;
    }
}
