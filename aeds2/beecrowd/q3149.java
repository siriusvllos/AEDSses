
import java.util.Scanner;

public class q3149 {
    public static void insertionSort(String[] n, String[] h){

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt(), q = sc.nextInt();

        String[] nomes = new String[q];
        String[] horarios = new String[q];

        for (int i = 0; i < q; i++) {
            String horas = "", nome = "", m = "", naoTratada = sc.nextLine();

            char h = naoTratada.charAt(0);
            int c = 0;
            while (h != ' ') {
                horas += naoTratada.charAt(c);
                c++;
                h = naoTratada.charAt(c);
                if (c == 3 || c == 4) {
                    m += naoTratada.charAt(c);
                }
            }

            int min = Integer.parseInt(m);
            if (min <= p) {
                h = naoTratada.charAt(6);
                c = 6;
                while (h != '\n') {
                    nome += naoTratada.charAt(c);
                    c++;
                    h = naoTratada.charAt(c);
                }
                nomes[i] = nome;
                horarios[i] = horas;
            }
        }


        sc.close();
    }

}
