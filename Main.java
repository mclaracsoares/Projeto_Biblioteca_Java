// Importar a classe Scanner para receber entrada do usuário e a classe InputMismatchException para lidar com entradas inválidas
import java.util.InputMismatchException;
import java.util.Scanner;

// Classe principal Main
public class Main {
    // Declaração de variáveis estáticas para a biblioteca, o scanner e o usuário logado
    public static Scanner scanner = new Scanner(System.in);
    public static Cliente usuarioLogado;

    // Método principal main
    public static void main(String[] args) {
        // Chama o método menuInicial para exibir o menu inicial
        menuInicial();
    }

    // Método para exibir o menu inicial e lidar com as opções do usuário
    public static void menuInicial() {
        int opcao; // Variável para armazenar a opção escolhida pelo usuário
        do {
            // Exibe o menu inicial com as opções disponíveis
            System.out.println("\n╭─────────────────────── Menu Inicial ──────────────────────╮");
            System.out.println("│                                                           │");
            System.out.println("│   ╭───────────────────────────────────────────────────╮   │");
            System.out.println("│   │                   Opções:                         │   │");
            System.out.println("│   │                                                   │   │");
            System.out.println("│   │   1. Sou Aluno                                    │   │");
            System.out.println("│   │   2. Sou Funcionário                              │   │");
            System.out.println("│   │   3. Sair                                         │   │");
            System.out.println("│   │                                                   │   │");
            System.out.println("│   ╰───────────────────────────────────────────────────╯   │");
            System.out.println("│                                                           │");
            System.out.println("╰───────────────────────────────────────────────────────────╯");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário
                switch (opcao) {
                    case 1:
                        Cliente.menuUsuario(); // Chama o menu do usuário para os alunos
                        break;
                    case 2:
                        Funcionario.menuFuncionario(); // Chama o menu do funcionário para os funcionários
                        break;
                    case 3:
                        System.out.println("Saindo..."); // Exibe uma mensagem de saída
                        break;
                    default:
                        System.out.println("Opção inválida. Escolha novamente."); // Exibe uma mensagem para opções inválidas
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número."); // Exibe uma mensagem para entradas inválidas
                scanner.nextLine(); // Limpa o buffer do scanner
                opcao = 0; // Define a opção como 0 para continuar o loop
            }
        } while (opcao != 3); // Continua o loop até que a opção escolhida seja 3 (Sair)
    }
}
