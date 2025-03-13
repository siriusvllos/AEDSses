//package ex05;

import java.util.Scanner;

public class ex05 {
    public static String and(String entrada) {
        for (int i = 0; i < entrada.length(); i++) {
            if (entrada.charAt(i) == '0') {
                return "0";
            } else {
                return "1";
            }
        }
        return "erro";
    }

    public static String or(String entrada) {
        for (int i = 0; i < entrada.length(); i++) {
            if (entrada.charAt(i) == '1') {
                return "1";
            } else {
                return "0";
            }
        }
        return "erro";
    }

    public static String not(String entrada) {
        if (entrada.equals("1")) {
            return "0";
        } else if (entrada.equals("0")) {
            return "1";
        } else {
            return "erro";
        }
    }

    public static String removerNumArgs(String entrada) {
        int i = 0, count = 0;
        while (entrada.charAt(i) != ' ') {
            count++;
            i++;
        }
        String entradaSemNumArgs = "";
        for (int j = count; j < entrada.length(); j++) {
            entradaSemNumArgs += entrada.charAt(j);
        }
        return entradaSemNumArgs;
    }

    public static String removerArgs(String entrada) {
        int i = 0;
        String aRemover = "";
        while (entrada.charAt(i) >= '0' && entrada.charAt(i) <= '9') {
            aRemover += entrada.charAt(i);
            i ++;
        }
        entrada = entrada.replace(aRemover, "");
        return entrada;
    }

    public static String removerEspaco(String entrada) {
        String entradaSemEspaco = entrada.replace(" ", "");
        return entradaSemEspaco;
    }

    public static String substituiVariaveis(String entrada) {
        for (int i = 0; i < entrada.length(); i++) {
            if (entrada.charAt(i) >= 'A' && entrada.charAt(i) <= 'Z') {
                int indice = entrada.charAt(i) - 'A';
                entrada = entrada.replace(entrada.charAt(i), entrada.charAt(indice));
            }
        }
        return entrada;
    }

    public static String executarOperacoes(String entrada) {
        int fechaParenteses = 0;
        int abreParenteses = 0;
        for (int i = entrada.length() - 1; i >= 0; i--) {
            if (entrada.charAt(i) == ')') {
                fechaParenteses = i;
            }
            if (entrada.charAt(i) == '(') {
                abreParenteses = i;
                break;
            }
        }
        char idOperacao = entrada.charAt(abreParenteses - 1);

        String pedacoEntradaOperar = "", pedacoEntradaSubstituir = "";
        for (int j = abreParenteses + 1; j < fechaParenteses; j++) {
            pedacoEntradaOperar += entrada.charAt(j);
        }

        String resposta = "";
        if (idOperacao == 't') {
            resposta = not(pedacoEntradaOperar);
            pedacoEntradaSubstituir = "not";
            for (int j = abreParenteses; j <= fechaParenteses; j++) {
                pedacoEntradaSubstituir += entrada.charAt(j);
            }
        } else if (idOperacao == 'r') {
            pedacoEntradaSubstituir = "or";
            for (int j = abreParenteses; j <= fechaParenteses; j++) {
                pedacoEntradaSubstituir += entrada.charAt(j);
            }
            resposta = or(pedacoEntradaOperar);
        } else if (idOperacao == 'd') {
            pedacoEntradaSubstituir = "and";
            for (int j = abreParenteses; j <= fechaParenteses; j++) {
                pedacoEntradaSubstituir += entrada.charAt(j);
            }
            resposta = and(pedacoEntradaOperar);
        }
        entrada = entrada.replace(pedacoEntradaSubstituir, resposta);
        return entrada;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();

        while (!entrada.equals("0")) {
            entrada = removerNumArgs(entrada);
            entrada = removerEspaco(entrada);
            entrada = substituiVariaveis(entrada);
            entrada = removerArgs(entrada);

            while (entrada.length() > 1) {
                entrada = executarOperacoes(entrada);
            }

            System.out.println(entrada);
            System.out.println(entrada);

            entrada = sc.nextLine();
        }
        sc.close();
    }
}
