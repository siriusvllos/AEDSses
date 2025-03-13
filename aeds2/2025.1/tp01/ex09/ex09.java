
import java.util.Scanner;

public class ex09 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ent = sc.nextLine();

        while (!ent.equals("FIM")) {
            ent = ent.toLowerCase();
            char[] s1 = new char[ent.length() / 2];
            char[] s2 = new char[ent.length() / 2];
            int hif = 0;
            for (int i = 0; i < ent.length(); i++) {
                if (ent.charAt(i) == '-') {
                    hif = i;
                }
            }
            for (int j = 0; j < hif; j++) {
                s1[j] = ent.charAt(j);
            }
            int nextStr = ent.length() - 1 - hif;
            for (int k = 0; k < nextStr; k++) {
                s2[k] = ent.charAt(hif + 1 + k);
            }
            boolean resp = true;
            for (int l = 0; l < hif; l++) {
                for (int m = 0; m < hif; m++) {
                    if (s1[l] == s2[m]) {
                        resp = true;
                        m = hif;
                    } else {
                        resp = false;
                    }
                }
            }
            /*OBS: esse método de baixo "funciona" majoritariamente, mas nao funciona se eu tiver uma string 2 c
             * menos caracteres q a string 1, ou vice versa
             * tenso.
             */
            // int count = 0;
            // for (int l = 0; l < hif; l++) {
            //     for (int m = 0; m < hif; m++) {
            //         if (s1[l] == s2[m]) {
            //             count++;
            //             //m = hif;
            //         }
            //     }
            // }

            if (resp) {
                System.out.println("SIM");
            } else {
                System.out.println("N\\u00C3O");
            }
            ent = sc.nextLine();
        }
    }
}
