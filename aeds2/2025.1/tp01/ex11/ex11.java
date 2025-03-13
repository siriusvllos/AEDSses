
import java.util.Scanner;

public class ex11 {

    public static int mede(String ent) {
        int n = ent.length();
        char old[] = new char[n];
        int maior = 0;
        for (int k = 0; k < n; k++) {
            boolean novo = true;
            int count = 0;
            for (int i = k; i < n; i++) {
                old[i] = ent.charAt(i);
                for (int j = k; j < i; j++) {
                    if (old[j] == ent.charAt(i)) {
                        j = n;
                        i = n;
                        novo = false;
                    }
                }
                if (novo) {
                    count++;
                }
                if (count > maior) {
                    maior = count;
                }
            }
        }
        return maior;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ent = ent = sc.nextLine();

        while (!ent.equals("FIM")) {
            int resp = mede(ent);
            System.out.println(resp);
            ent = sc.nextLine();
        }
    }
}
