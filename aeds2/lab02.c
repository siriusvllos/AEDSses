#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void main()
{
    char string[100], gnirts[100];
    scanf("%s", string);
    while (strcmp(string, "FIM") != 0)
    {
        int size = strlen(string) - 1, i = 0;

        while (size >= 0)
        {
            gnirts[i] = string[size];
            printf("gnirts na posição %d: %c\n", i, gnirts[i]);
            i++, size--;
        }
         printf("GNIRTS = %s\n", gnirts);

        if (strcmp(string, gnirts) == 0)
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }
        scanf("%s", string);
    }
}

/*void main()
{
    char *string, *gnirts;
    int size, i = 0;
    printf("passe o tam:\n");
    scanf("%d", &size);

    string = (char *)malloc(sizeof(char) * size);
    while (i < size)
    {
        scanf(" %c", &string[i]);
        i++;
    }
    printf("STRING = %s\n", string);
    gnirts = (char *)malloc(sizeof(char) * size);
    i = 0;
    size--;
    while (size >= 0)
    {
        gnirts[i] = string[size];
        printf("gnirts na posição %d: %c\n", i, gnirts[i]);
        i++, size--;
    }
    printf("GNIRTS = %s\n", gnirts);

    if (strcmp(string, gnirts) == 0)
    {
        printf("SIM");
    }
    else
    {
        printf("NAO");
    }
}
*/
