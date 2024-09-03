package aquecimento1;
import java.util.Scanner;

public class q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        while (!string.equals("FIM")) {
            int count = 0;
            for (int i = 0; i < string.length(); i++) {
                int letraAtual = string.charAt(i);
                if (letraAtual >= 65 && letraAtual <= 90) {
                    count++;
                }
            }
            System.out.println(count);
            string = sc.nextLine();
        }
        sc.close();
    }
}