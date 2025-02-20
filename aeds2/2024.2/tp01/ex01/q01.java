package ex01;
import java.util.Scanner;

/* Olá, aqui é o Sirius
 * Eu escrevi esse código para cumprir a função da q01 do TP01,
 * ele lê uma entrada string, e retorna se essa string é um palindromo ou nao.
 * Eu fiz isso partindo a string no meio, e vindo da esquerda e direita comparando
 * os caracteres */

public class q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palindromo = sc.nextLine();
        while (!palindromo.equals("FIM")) {

            int esq = 0, dir = palindromo.length() - 1;
            int count = 0;

            for (int i = 0; i < (palindromo.length() / 2); i++) {
                if (palindromo.charAt(esq) == palindromo.charAt(dir)) {
                    count++;
                }
                dir --;
                esq ++;
            }
            if (palindromo.length() / 2 == count++) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            palindromo = sc.nextLine();
        }
        sc.close();
    }
}