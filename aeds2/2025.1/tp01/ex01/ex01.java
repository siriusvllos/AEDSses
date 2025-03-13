
import java.util.Scanner;

public class ex01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        while (!str.equals("FIM")) {
            int tam = str.length() - 1;
            boolean resp = true;
            for (int i = 0; i < tam / 2; i++) {
                if (str.charAt(i) != str.charAt(tam - i)) {
                    resp = false;
                    i = tam;
                }
            }
            if (resp) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            str = sc.nextLine();
        }

        /* Esse método do count não funciona, pq (no exemplo "laicos- social"), nós temos:
        - tam = 13 - 1 (12)
        - tam / 2 = 6
        - 6 verificações(todos os caracteres de social/laicos), oq é de fato palindromo
        Mas não entramos na comparação entre '-' e ' ', que seria uma sétima comparação

        pq q nesse caso eu precisaria de uma sétima comparação, e portanto, de fazer (i <= tam / 2) como condição
        de parada, mas em outros casos tipo ("a�a"), que também é impar, eu não precisaria?

         * public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        while (!str.equals("FIM")) {
            int tam = str.length() - 1, count = 0;
            for (int i = 0; i < tam / 2; i++) {
                if (str.charAt(i) == str.charAt(tam - i)) {
                    count++;
                }
            }
            if (count == tam / 2) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            str = sc.nextLine();
            }
        }
         */
    }
}

/*
 * for (int i = 0; i < tam / 2; i++) {
                if (str.charAt(i) == str.charAt(tam - i)) {
                    resp = true;
                } else {
                    resp = false;
                }
                if (resp) {
                    System.out.println("SIM");
                } else {
                    System.out.println("NAO");
                }
            }
 */
