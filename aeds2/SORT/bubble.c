#include "swap.h"
// ===
#include <stdio.h>
#include <stdlib.h>

void bolha(int *array, int n)
{
    int i, j;
    for (i = 0; i < (n - 1); i++)
    {
        for (j = (n - 1); j > 0; j--)
        {
            if (array[j] < array[j - 1])
            {
                swap(&array[j], &array[j - 1]);
                printf("houve um swap \n");
                printf("swap entre %d e %d\n", array[j], array[j - 1]);
            }
        }
    }
}

int main()
{
    int n = 5;
    int a[5] = {2, 6, 7, 8, 1};
    bolha(a, n);
    printf("EXIBINDO ARRAY ORDENADO:\n");

    for (int i = 0; i < n; i++)
    {
        printf("%d ", a[i]);
    }
    printf("\nFIM\n");
}