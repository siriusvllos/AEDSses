//package ex04;

import java.util.Random;
import java.util.Scanner;


public class q04 {
    private static Random gerador = new Random();

    public static void trocarLetra(String ent) {
        char letraTrocar = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
        char letraNova = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));

        String novaEnt = ent.replace(letraTrocar, letraNova);
        System.out.println(novaEnt);
    }

    public static void main(String[] args) {
        gerador.setSeed(4);

        Scanner sc = new Scanner(System.in);
        String ent = sc.nextLine();

        while (!ent.equals("FIM")) {
            trocarLetra(ent);
            ent = sc.nextLine();
        }

        sc.close();
    }
}