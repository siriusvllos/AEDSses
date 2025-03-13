
//package ex03;
import java.util.Scanner;

public class q03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ent = sc.nextLine();

        while (!ent.equals("FIM")) {
            String novaString = "";

            for (int i = 0; i < ent.length(); i++) {
                if (ent.charAt(i) >= 0 && ent.charAt(i) <= 127) { // verifica se não é char especial
                    int caract = ent.charAt(i); // type casting implicito
                    caract += 3;
                    char novoCaract = (char) caract;
                    novaString += novoCaract;
                } else {
                    novaString += ent.charAt(i);
                }
            }
            System.out.println(novaString);
            ent = sc.nextLine();
        }
        sc.close();
    }
}
