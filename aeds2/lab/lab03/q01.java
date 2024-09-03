import java.util.Scanner;

public class q01 {
    public static int contarUltParenteses(String entrada, char qual) {
        for (int i = entrada.length() -1; i >= 0; i--) {
            if (entrada.charAt(i) == qual) {
                return i;
            }
        }
        return 0;
    }

    public static int contarPrimParenteses(String entrada, char qual) {
        for (int i = 0; i < entrada.length(); i++) {
            if (entrada.charAt(i) == qual) {
                return i;
            }
        }
        return 0;
    }

    public static boolean compararParenteses(String entrada) {
        int abreParentesesCount = 0, fechaParentesesCount = 0;
        int primeiroAP = contarPrimParenteses(entrada, '('), primeiroFP = contarPrimParenteses(entrada, ')'),
                ultimoAP = contarUltParenteses(entrada, '('), ultimoFP = contarUltParenteses(entrada, ')');

        for (int i = 0; i < entrada.length(); i++) {
            if (entrada.charAt(i) == '(') {
                abreParentesesCount++;
            } else if (entrada.charAt(i) == ')') {
                fechaParentesesCount++;
            }
        }
        if (primeiroAP > primeiroFP) {
            return false;
        }
        if (ultimoFP < ultimoAP){
            return false;
        }
        if (abreParentesesCount == fechaParentesesCount) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        while (!entrada.equals("FIM")) {
            boolean resp = compararParenteses(entrada);
            if (resp) {
                System.out.println("correto");
            } else {
                System.out.println("incorreto");
            }
            entrada = sc.nextLine();
        }
        sc.close();
    }
}