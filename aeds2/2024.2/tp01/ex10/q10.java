//package ex10;
/* Oi, aqui é o sirius
 *oq eu estou tentando fazer aqui basicamente é criar uma recursividade pra reoslver a questao 1
 * e essa recursividade funciona assim:
 * a condicao de perada é quando esquerda e direita forem iguais
 * esqueda comeca como 0 e direita comeca como o numero de indices totais da string de entrada
 * ai ele vai "comendo pelas beiradas" pra se aproximar da metade (que é quando esquerda for maior ou igual a 
 * direita, isso é, ultrapassou direita ou chegamos no meio exato)
 * se em qualquer momento o caracter na direita e na esquerda nao forem iguais, entao ele retorna false
 * é oisso, um beijo da anitta
*/
import java.util.Scanner;

public class q10 {
    public static boolean comparaRec(String ent, int esq, int dir) {
        if (esq >= dir) {
            return true;
        } else {
            if (ent.charAt(esq) == ent.charAt(dir)) {
                return (comparaRec(ent, esq + 1, dir - 1));
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palindromo = sc.nextLine();
        while (!palindromo.equals("FIM")) {
            boolean resp = comparaRec(palindromo, 0, palindromo.length() - 1);
            if (resp) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            palindromo = sc.nextLine();
        }
        sc.close();
    }
}
