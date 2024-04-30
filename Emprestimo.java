// classe emprestimo:

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

class Emprestimo  {
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

    public static List<Emprestimo> getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }

    public static void verLivrosEmprestados() {
        System.out.println("\n╭─────────────────────── Livros Emprestados ───────────────────────╮");
        for (Cliente cliente : Biblioteca.getListaClientes()) {
            System.out.println("│ Aluno: " + cliente.getNome());
            for (Livro livro : cliente.getLivrosEmprestados()) {
                System.out.println("│ Livro: " + livro.getTitulo());
            }
            System.out.println("│"); // Linha em branco entre cada aluno
        }
        System.out.println("╰──────────────────────────────────────────────────────────────────╯");

    }

    public static void devolverLivro() {
        System.out.println("\n╭─────────────────────── Devolver Livro ───────────────────────╮");
        System.out.print("│ ID do Livro: ");
        int idLivro = Main.scanner.nextInt();

        Livro livro = Biblioteca.buscarLivroPorID(idLivro);

        if (livro != null) {
            if (!livro.isDisponivel()) { // Verifica se o livro está emprestado
                livro.setDisponivel(true); // Marca o livro como disponível novamente
                Main.usuarioLogado.getLivrosEmprestados().remove(livro); // Remove o livro dos empréstimos do usuário
                System.out.println("│ Livro devolvido com sucesso!                                    ");

                // Perguntar ao usuário se deseja avaliar o livro
                System.out.print("│ Deseja avaliar este livro? ");
                char resposta = Main.scanner.next().toLowerCase().charAt(0);
                if (resposta == 's') {
                    System.out.print("│ De 0 a 5, Qual sua avaliação para esse livro? ");
                    double avaliacao = Main.scanner.nextDouble();
                    while (avaliacao < 0 || avaliacao > 5) {
                        System.out.print("│ Insira uma avaliação válida entre 0 e 5: ");
                        avaliacao = Main.scanner.nextDouble();
                    }
                    livro.setAvaliacao(avaliacao);
                    System.out.println("│ Obrigado pela avaliação!                                         │");
                } else {
                    System.out.println("│ Livro devolvido sem avaliação.                                   │");
                }
            } else {
                System.out.println("│ Este livro atualmente ainda está disponível.                     │");
            }
        } else {
            System.out.println("│ Livro não encontrado.                                            ");
        }
        System.out.println("╰────────────────────────────────────────────────────────────────╯");
    }


    public static void emprestarLivro() {
        if (Biblioteca.getListaLivros().isEmpty()) {
            System.out.println("Não há livros disponíveis para empréstimo no momento");
            return;
        }
        System.out.println("\n╭─────────────────────── Emprestar Livro ───────────────────────╮");
        System.out.print("│ ID do Livro: ");
        int idLivro = Main.scanner.nextInt();

        Livro livro = Biblioteca.buscarLivroPorID(idLivro);

        if (livro != null) {
            if (livro.isDisponivel()) { // Verifica se o livro está disponível para empréstimo
                livro.setDisponivel(false); // Marca o livro como indisponível
                Main.usuarioLogado.getLivrosEmprestados().add(livro); // Adiciona o livro aos empréstimos do usuário
                Date dataEmprestimo = new Date(); // Data atual
                Emprestimo emprestimo = new Emprestimo(dataEmprestimo, Main.usuarioLogado);
                getHistoricoEmprestimos().add(emprestimo); // Adiciona o empréstimo ao histórico do livro
                System.out.println("│ Livro emprestado com sucesso! ");
            } else {
                System.out.println("│ Este livro atualmente não está disponível para empréstimo.     ");
            }
        } else {
            System.out.println("│ Livro não encontrado.                                           ");
        }
        System.out.println("╰───────────────────────────────────────────────────────────────╯");
    }
}