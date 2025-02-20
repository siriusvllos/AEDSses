package ex04;

import java.util.Scanner;
import java.util.Random;

/* Olá, aqui é o Sirius
 * basicamente o que eu to tentando fazer aqui é tentar gerar uma letra a trocar e uma 
 * letra nova (que vai substituir a letra a trocar), ai percorrer a entrada toda e ir trocando
 * essas duas. Uma coisa que eu descobri é que eu só posso setar a seed (linha 25) UMA VEZ
 * e que existe uma função pra percorrer a string etc (nome.replace(), linha 21)
*/

public class q04 {
    private static Random gerador = new Random();

    public static void trocarLetra(String txt) {
        char letraTrocar = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
        char letraNova = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));

        String novaEnt = txt.replace(letraTrocar, letraNova);
        System.out.println(novaEnt);
    }

    public static void main(String[] args) {
        gerador.setSeed(4);

        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();

        while (!entrada.equals("FIM")) {
            trocarLetra(entrada);
            entrada = sc.nextLine();
        }

        sc.close();
    }
}