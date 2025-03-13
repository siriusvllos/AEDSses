import java.util.Scanner;

public class ex07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.nextLine());

        while (!str.toString().equals("FIM")) {
            int tam = str.length();
            for (int i = 0; i < (tam) / 2; i++) {
                char first = str.charAt(i), last = str.charAt(tam - 1 - i);
                str.setCharAt(i, last);
                str.setCharAt(tam - 1 - i, first);
            }
            System.out.println(str);
            str = new StringBuilder(sc.nextLine());
        }
    }
}