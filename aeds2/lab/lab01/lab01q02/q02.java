package aquecimento1.q02;

import java.util.Scanner;

// eu estou tendo um problema nessa questão pois ele não le as varias entradas como sendo separadas por enter

public class q02 {
    public static void contar(String string) {

        Scanner sc = new Scanner(System.in);
        if (string.equals("FIM")) {
            sc.close();
        } else {
            int count = 0;
            for (int i = 0; i < string.length(); i++) {
                int letraAtual = string.charAt(i);
                if (letraAtual >= 65 && letraAtual <= 90) {
                    count++;
                }
            }
            System.out.println(count);
            String novaString = sc.nextLine();
            contar(novaString);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        contar(entrada);
        sc.close();
    }
}