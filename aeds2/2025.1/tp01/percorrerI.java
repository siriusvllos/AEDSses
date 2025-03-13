// percorrer a string
import java.util.Scanner;

public class percorrer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int tam = str.length();
        for (int i = 0; i < tam - 1; i++) {
            char atual = str.charAt(i);
            System.out.println(atual);
        }
    }
}
