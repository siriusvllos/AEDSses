#include <stdio.h>

/* Oi, aqui é o sirius
 o que eu estou tentando fazer é abrir um arquivo file.txt, ler os floats nele,
 salvar em um arquivo e imprimir na ordem inversa*/
int main()
{
    FILE *arq = fopen("file.txt", "wb");
    int qtde, numInt;
    float num;

    scanf("%d", &qtde);

    for (int i = 0; i < qtde; i++)
    {
        scanf("%f", &num);
        fwrite(&num, sizeof(float), 1, arq);
    }
    fclose(arq);

    arq = fopen("file.txt", "rb");

    fseek(arq, 0, SEEK_END);
    for (int i = qtde - 1; i >= 0; i--)
    {
        fseek(arq, i * sizeof(float), SEEK_SET);

        fread(&num, sizeof(float), 1, arq);

        numInt = (int)num;

        if (numInt - num == 0)
            printf("%d\n", numInt);
        else
            printf("%g\n", num);
    }

    fclose(arq);
    return 0;
}