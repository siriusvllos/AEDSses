// percorrer a string

import java.util.Scanner;

public class percorrer {
    // tbm seria possível tipo, percorrer a string fazendo alterações
    // a cada caractere, passando uma func como parâmetro, oq seria
    // útil para Ciframento de César, e prob semelhantes



    /* DEUS ME AJUDE: usar lambda ou interfaces funcionais
    public static String mod (String str, int i, func()){

    } */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int tam = str.length();
        for (int i = 0; i < tam - 1; i++) {
            char atual = str.charAt(i);
            System.out.println(atual);
        }
    }
}
