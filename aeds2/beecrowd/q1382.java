import java.io.IOException;
import java.util.Scanner;

public class q1382 {

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int quicksortRec(int[] array, int esq, int dir) {
        int i = esq, j = dir, trocas = 0;
        int pivo = array[(dir + esq) / 2];
        while (i <= j) {
            while (array[i] < pivo) {
                i++;
            }
            while (array[j] > pivo) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
                trocas++;
            }
        }
        if (esq < j) {
            return trocas + quicksortRec(array, esq, j);
        }
        if (i < dir) {
            return trocas + quicksortRec(array, i, dir);
        }
        return trocas;
    }

    public static int quicksort(int[] array, int n) {
        return quicksortRec(array, 0, n - 1);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T, N;
        T = sc.nextInt();
        while (T > 0) {
            N = sc.nextInt();
            int[] vet = new int[N];
            for (int i = 0; i < N; i++) {
                vet[i] = sc.nextInt();
            }
            System.out.println(quicksort(vet, N));
            // alguma coisa está errada no meu loop pq ele está retornando só o ultimo T
            T--;
        }
        sc.close();
    }
}