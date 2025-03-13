import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
//package ex12;

public class ex12 {

    public static boolean verify(String ent) {
        boolean valid;
        if (ent.length() < 8) {
            valid = false;
            return valid;
        }
        int countcs = 0, countLm = 0, countlm = 0, countnum = 0;
        for (int i = 0; i < ent.length(); i++) {
            if (ent.charAt(i) > 31 && ent.charAt(i) < 48 || ent.charAt(i) > 57 && ent.charAt(i) < 65) {
                countcs++;
            }
            if (ent.charAt(i) > 47 && ent.charAt(i) < 58) {
                countnum++;
            }
            if (ent.charAt(i) > 64 && ent.charAt(i) < 90) {
                countLm++;
            }
            if (ent.charAt(i) > 96 && ent.charAt(i) < 123) {
                countlm++;
            }
        }
        if (countLm > 0 && countlm > 0 && countcs > 0 && countnum > 0) {
            valid = true;
        } else {
            valid = false;
        }
        return valid;
    }

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Scanner sc = new Scanner(System.in);
        String ent = sc.nextLine();
        while (!ent.equals("FIM")) {
            boolean resp = verify(ent);
            if (resp) {
                System.out.println("SIM");
            } else {
                System.out.println("N\u00C3O");
            }
            ent = sc.nextLine();
        }
    }
}
