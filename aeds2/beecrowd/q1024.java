import java.io.IOException;
import java.util.Scanner;

public class q1168 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < x; i++) {
            String og = sc.nextLine();
            char[] alt = og.toCharArray();
            int strLen = og.length();

            for (int j = 0; j < strLen; j++) {
                int crr = (int) og.charAt(j);
                if ((crr >= 65 && crr <= 90) || (crr >= 97 && crr <= 122)) {
                    crr += 3;
                }
                alt[strLen - j - 1] = (char) crr;
            }
            System.out.print("APOS A PRIMEIRA PASSADA E INVERSÃO, A STRING É ");
            System.out.println(new String(alt));

            for (int k = ((strLen / 2)); k < strLen; k++) {
                int crr = (int) alt[k];
                System.out.println("posicão = " + k + " e crr = " + crr);
                crr = crr - 1;
                alt[k] = (char) crr;
            }
            System.out.print("APOS A SEGUNDA PASSADA, A STRING É ");
            System.out.println(new String(alt));
        }

        sc.close();
    }
}
