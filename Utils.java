import java.io.Serializable;
import java.util.Random;


public class Utils implements Serializable {


   public static int gerarIDAleatorio() {
       Random random = new Random();
       return random.nextInt(9000) + 1000; // Gera um número aleatório entre 1000 e 9999
   }
}
