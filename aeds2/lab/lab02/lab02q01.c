#include <stdio.h>
#include <string.h>

int main()
{
    char A[20];
    char B[20];
    scanf("%s", A);
    scanf("%s", B);

    /* printf("string A == %s", A);
    printf("string B == %s", B); */

    char alt[40] = "";
    int j = 0;
    int k = 0;
    for (int i = 0; i < 40; i++)
    {
        if (A[i] != '\x00' && B[i] != '\x00')
        {
            if (i % 2 == 0)
            {
                alt[i] = A[j];
                // printf("char at %d == %c\n", i, alt[i]);
                j++;
            }
            else if (i % 2 != 0)
            {
                alt[i] = B[k];
                // printf("char at %d == %c\n", i, alt[i]);
                k++;
            }
        }
        else if (A[i] == '\x00' && B[i] == '\x00')
        {
            break;
        }
        else if (A[i] == '\x00')
        {
            alt[i] = B[k];
            //printf("char at %d == %c\n", i, alt[i]);
        }
        else if (B[i] == '\x00')
        {
            alt[i] = A[j];
            //printf("char at %d == %c\n", i, alt[i]);
        }
        printf("i == %d\nj == %d\nk ==%d\n", i, j, k);
    }
    printf("alt == %s", alt);
}