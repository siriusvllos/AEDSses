public class preProvaI {

    static int[] array = { 8, 6, -3, 9, -7, -2, 2, 1 };

    public static void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(int[] entrada) {
        int n = entrada.length, numsNeg = 0;
        int[] posNumNegs = new int[n];
        for (int i = 0; i < n; i++) {
            if (entrada[i] < 0) {
                posNumNegs[numsNeg] = i;
                numsNeg++;
            }
        }

        for (int i = 0; i < numsNeg; i++) {
            swap(posNumNegs[i], i);
        }

        for (int i = numsNeg; i < n; i++) {
            int menor = i;
            for (int j = i; j < n; j++) {
                if (entrada[menor] > entrada[j]) {
                    menor = j;
                }
            }
            swap(menor, i);
        }

    }

    public static void main(String[] args) {
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}