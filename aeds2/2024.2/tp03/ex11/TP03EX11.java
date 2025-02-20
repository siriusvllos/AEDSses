
import java.util.*;

class No {

    int val;
    No sup, esq, dir, inf;

    public No() {
        this.sup = this.esq = this.dir = this.inf = null;
    }

    public No(int val) {
        this();
        this.val = val;
    }
}

class Matriz {

    No head;
    int totLn;
    int totCol;

    public Matriz(int ln, int col, Scanner sc) {
        this.totLn = ln;
        this.totCol = col;

        No start = new No();
        No aux = new No();

        for (int i = 0; i < ln; i++) {
            for (int j = 0; j < col; j++) {
                No newNo = new No();
                newNo.val = sc.nextInt();

                if (i == 0 && j == 0) {
                    this.head = newNo;
                    start = newNo;
                    aux = newNo;
                } else if (i == 0) {
                    newNo.esq = aux;
                    aux.dir = newNo;
                    aux = aux.dir;
                } else if (j == 0) {
                    newNo.sup = start;
                    start.inf = newNo;
                    aux = newNo;
                } else {
                    newNo.esq = aux;
                    aux.dir = newNo;
                    newNo.esq.sup.dir.inf = newNo;
                    newNo.sup = newNo.esq.sup.dir;
                    aux = aux.dir;
                }
            }

            if (i != 0) {
                start = start.inf;
            }

            aux = start;
        }
    }

    public void mostrarDiagonalPrincipal() {
        if (this.totLn != this.totCol) {
            return;
        }

        No curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");

            if (curr.inf == null) {
                break;
            }

            curr = curr.inf.dir;
        }

        System.out.println();
    }

    public void mostrarDiagonalSecundaria() {
        if (this.totLn != this.totCol) {
            return;
        }

        No curr = head;

        while (curr.dir != null) {
            curr = curr.dir;
        }

        while (curr != null) {
            System.out.print(curr.val + " ");

            if (curr.esq == null) {
                break;
            }

            curr = curr.esq.inf;
        }

        System.out.println();
    }

    public void soma(Matriz m1, Matriz m2) {
        No aux1 = m1.head;
        No aux2 = m2.head;

        while (aux1 != null && aux2 != null) {
            No curr1 = aux1;
            No curr2 = aux2;

            while (curr1 != null && curr2 != null) {
                int sum = curr1.val + curr2.val;
                System.out.print(sum + " ");

                curr1 = curr1.dir;
                curr2 = curr2.dir;
            }

            System.out.println();

            aux1 = aux1.inf;
            aux2 = aux2.inf;
        }
    }
}

class TP03EX11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ct = sc.nextInt();

        while (ct > 0) {
            int l = sc.nextInt();
            int c = sc.nextInt();

            Matriz mat1 = new Matriz(l, c, sc);
            Matriz mat2 = new Matriz(l, c, sc);

            mat1.mostrarDiagonalPrincipal();
            mat1.mostrarDiagonalSecundaria();

            mat2.mostrarDiagonalPrincipal();
            mat2.mostrarDiagonalSecundaria();

            mat1.soma(mat1, mat2);

            ct--;
        }
    }
}
