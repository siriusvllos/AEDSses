


public class quicksort {

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quicksortRec(int[] array, int esq, int dir) {
        int i = esq, j = dir;
        int pivo = array[(dir + esq) / 2];
        while (i <= j) {
            System.out.println("Primeiro loop while: "+i+" <= "+j);
            while (array[i] < pivo) {
                System.out.println("Loop interno: "+array[i]+" < "+pivo);
                System.out.println(array[i] + " menor que " + pivo);
                i++;
            }
            while (array[j] > pivo) {
                System.out.println("Loop subjacente: "+array[i]+" < "+pivo);
                System.out.println(array[j] + " maior que " + pivo);
                j--;
            }
            if (i <= j) {
                System.out.println("Swap ocorrendo ");
                swap(array, i, j);
                System.out.println("Trocamos " + i + " por " + j);
                i++;
                j--;
            }
        }
        if (esq < j) {
            System.out.println(esq + " menor que " + j + ". Chamamos quicksort rec com " + esq + "e " + j);
            quicksortRec(array, esq, j);
        }
        if (i < dir) {
            System.out.println(i + " menor que " + dir + ". Chamamos quicksort rec com " + i + "e " + dir);
            quicksortRec(array, i, dir);
        }
    }

    public static void quicksort(int[] array, int n) {
        quicksortRec(array, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] vet = {5, 2, 1, 4, 3};
        int ok = 0;
        while (ok <= 4) {
            System.out.println("vet na posição " + ok + " igual a " + vet[ok]);
            ok++;
        }
        System.out.println("chamando quicksort");
        quicksort(vet, 5);
        System.out.println("quicksort executado");
        ok = 0;
        while (ok <= 4) {
            System.out.println("vet na posição " + ok + " igual a " + vet[ok]);
            ok++;
        }
    }
}
