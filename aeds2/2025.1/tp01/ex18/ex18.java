
import java.util.Scanner;

public class ex18 {

    public static int ciframento(StringBuilder ent, int pos) {
        if (pos >= ent.length()) {
            return 0;
        } else {
            if (ent.charAt(pos) >= 0 && ent.charAt(pos) <= 127) {
                int caract = ent.charAt(pos); // type casting implicito
                caract += 3;
                char novoCaract = (char) caract;
                ent.setCharAt(pos, novoCaract);
            }
            return ciframento(ent, pos + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder ent = new StringBuilder(sc.nextLine());

        while (!ent.toString().equals("FIM")) {
            ciframento(ent, 0);
            System.out.println(ent.toString());

            ent.setLength(0);
            ent.append(sc.nextLine());
        }

        sc.close();

    }
}
