import java.io.RandomAccessFile;
import java.util.Scanner;
/* Oi, aqui é o sirius
 * mesma coisa da questão 9 do tp (que é arquivo em c, que eu achei q fosse a 8)
 * eu usei a lib RandomAcessFile -p/ acessar os arquivos
 */

public class q09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        try {
            RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");

            for (int i = 0; i < n; i++) {
                raf.writeFloat(scanner.nextFloat());
            }

            raf.close();

            raf = new RandomAccessFile("file.txt", "r");

            raf.seek(raf.length());

            for (int i = n - 1; i >= 0; i--) {
                raf.seek(i * Float.BYTES);
                Float num = raf.readFloat();
                int numInt = num.intValue();

                if (num - numInt == 0)
                    System.out.println(numInt);
                else
                    System.out.println(num);
            }

            raf.close();
        } catch (Exception e) {
        }

        scanner.close();
    }
}