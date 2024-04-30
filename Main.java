
import java.util.Scanner;


public class Main {
   public static Biblioteca biblioteca = new Biblioteca();
   public static Scanner scanner = new Scanner(System.in);
   public static Cliente usuarioLogado;






   public static void menuInicial() {
       int opcao;
       do {
           System.out.println("\n===== Menu Inicial =====");
           System.out.println("1. Sou Aluno");
           System.out.println("2. Sou Funcionario");
           System.out.println("3. Sair");
           System.out.print("Escolha uma opção: ");
           opcao = scanner.nextInt();


           switch (opcao) {
               case 1:
                   Cliente.menuUsuario();
                   break;
               case 2:
                   Funcionario.menuFuncionario();
                   break;
               case 3:
                   System.out.println("Saindo...");
                   break;
               default:
                   System.out.println("Opção inválida. Escolha novamente.");
           }
       } while (opcao != 3);
   }
}
