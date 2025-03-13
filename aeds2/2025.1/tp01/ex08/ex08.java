import java.util.Scanner;
public class ex08 {

    public static int somador(char[] ent, int i) {

        // System.out.println("dig at " + i + " == " + dig[i]);
        /* sum += dig[i]; // utilizando casting implicito recebemos um ERRO pois o sum recebe o valor
                /* ASCII do numero (ex, 1 = 49, etc)
                 * para resolver esse problema, vou utilizar o Character.getNumericValue():
     * O método Character.getNumericValue(char ch) converte um caractere para um valor numérico
             * real, de acordo com uma tabela interna da JVM que cobre múltiplos sistemas numéricos além
             * do ASCII.
         */
        if (i >= ent.length) {
            return 0;
        } else {
            int sum = Character.getNumericValue(ent[i]);
            return sum + somador(ent, i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ent = sc.nextLine();
        while (!ent.equals("FIM")) {
            char[] dig = ent.toCharArray();
            int sum = somador(dig, 0);

            System.out.println(sum);
            ent = sc.nextLine();
        }
        sc.close();
    }
}
