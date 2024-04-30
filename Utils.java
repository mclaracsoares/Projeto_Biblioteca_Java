// classe utils para gerar ID aleatorio
import java.util.Random;

public class Utils {

    public static int gerarIDAleatorio() {
        Random random = new Random();
        return random.nextInt(9000) + 1000; // Gera um número aleatório entre 1000 e 9999
    }
}
