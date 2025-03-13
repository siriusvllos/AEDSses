#include <stdio.h>
#include <string.h>

void swap(char *esq, char *dir)
{
    char temp = *esq;
    *esq = *dir;
    *dir = temp;
}

int inverte(char ent[], int pos)
{
    if (pos >= strlen(ent) / 2)
    {
        return 0;
    }
    else
    {
        swap(&ent[pos], &ent[strlen(ent) - 1 - pos]);
        return inverte(ent, pos + 1);
    }
}
int main()
{
    char ent[500];
    scanf(" %[^\n\r]", ent);
    while (strcmp(ent, "FIM"))
    {
        inverte(ent, 0);
        printf("%s\n", ent);
        scanf(" %[^\n\r]", ent);
    }
    return 0;
}