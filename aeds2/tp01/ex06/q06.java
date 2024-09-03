// package ex06;
/* Oi, aqui é o Sirius
 * O que eu tentei fazer aqui basicamente é uma função para testar cada condição, incluindo se a entrada é um numero
 * ou contem vogais, 
 * ai as funções vão chamando uma a outra bonitinho, e no final eu testo c varios if's
 */

import java.util.Scanner;

public class q06 {
    public static Boolean verificaNumero(String entrada) {
        int count = 0;
        for (int i = 0; i < entrada.length(); i++) {
            if (entrada.charAt(i) == '0' || entrada.charAt(i) == '1' || entrada.charAt(i) == '2' ||
                    entrada.charAt(i) == '3' || entrada.charAt(i) == '4' || entrada.charAt(i) == '5' ||
                    entrada.charAt(i) == '6' || entrada.charAt(i) == '7' || entrada.charAt(i) == '8' ||
                    entrada.charAt(i) == '9' || entrada.charAt(i) == ',' || entrada.charAt(i) == '.') {
                count++;
            }
        }
        if (count == entrada.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean contemVogais(char entrada) {
        if (entrada == 'a' || entrada == 'A' || entrada == 'e'
                || entrada == 'E' || entrada == 'i' || entrada == 'I'
                || entrada == 'o' || entrada == 'O' || entrada == 'u'
                || entrada == 'U') {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean compostaDeVogais(String entrada) {
        int count = 0;
        for (int i = 0; i < entrada.length(); i++) {
            if (contemVogais(entrada.charAt(i))) {
                count++;
            }
        }
        if (entrada.length() == count) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean compostaDeConsoantes(String entrada) {
        if (!verificaNumero(entrada)) {
            for (int i = 0; i < entrada.length(); i++) {
                if (contemVogais(entrada.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static int verificaIntReal(String entrada) {
        if (verificaNumero(entrada)) {
            int contadorPtVg = 0;
            for (int i = 0; i < entrada.length(); i++) {
                if (entrada.charAt(i) == ',' || entrada.charAt(i) == '.') {
                    contadorPtVg++;
                }
            }
            if (contadorPtVg == 0) {
                return 1; // int;
            } else if (contadorPtVg == 1) {
                return 2; // real;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();

        while (!entrada.equals("FIM")) {
            String resposta = "";
            if (compostaDeVogais(entrada)) {
                resposta += "SIM ";
            } else {
                resposta += "NAO ";
            }
            if (compostaDeConsoantes(entrada)) {
                resposta += "SIM ";
            } else {
                resposta += "NAO ";
            }
            if (verificaIntReal(entrada) == 1) {
                resposta += "SIM ";
            } else {
                resposta += "NAO ";
            }
            if (verificaIntReal(entrada) != 0) {
                resposta += "SIM";
            } else {
                resposta += "NAO";
            }
            System.out.println(resposta);
            entrada = sc.nextLine();
        }
        sc.close();
    }
}
