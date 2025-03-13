import java.util.Scanner;
//package ex10;

public class ex10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ent = sc.nextLine();
        while (!ent.equals("FIM")) {
            int count = 1;
            for (int i = 0; i < ent.length(); i++) {
                //System.out.println("i = " + i + " e ent(i) = " + ent.charAt(i));
                if (Character.isWhitespace(ent.charAt(i))) {
                    count++;
                    //System.out.println("is");
                }
            }
            System.out.println(count);
            ent = sc.nextLine();
        }
    }
}
