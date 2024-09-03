
//package ex03;
import java.util.Scanner;

/* Oi, aqui é o Sirius
 * Basicamente o que eu estou tentando fazer aqui é pegar uma entrada, transformar em int
 * adicionar o num 3, q é a "cifra", e voltar para caracter, adicionando a uma nova string
 * uma coisa que talvez pudesse ter sido melhor é se eu conseguisse simplesmente alterar o caracter na string
 * entrada ao invés de ter que criar a novaString, mas o java reclama
 */
public class q03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();

        while (!entrada.equals("FIM")) {
            String novaString = "";

            for (int i = 0; i < entrada.length(); i++) {
                if (entrada.charAt(i) >= 0 && entrada.charAt(i) <= 127) { // verifica se não é char especial
                    int caract = entrada.charAt(i); // type casting implicito
                    caract += 3;
                    char novoCaract = (char) caract;
                    novaString += novoCaract;
                } else {
                    novaString += entrada.charAt(i);
                }
            }
            System.out.println(novaString);
            entrada = sc.nextLine();
        }
        sc.close();
    }
}
