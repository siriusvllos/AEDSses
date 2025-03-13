#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool comparaRec(char ent[], int dir, int esq)
{
    if (esq >= dir)
    {
        return true;
    }
    else
    {
        if (ent[dir] == ent[esq])
        {
            return (comparaRec(ent, dir - 1, esq + 1));
        }
        else
        {
            return false;
        }
    }
}

int main()
{
    char ent[500];
    scanf(" %[^\n\r]", ent);
    while (strcmp(ent, "FIM"))
    {
        bool resp = comparaRec(ent, strlen(ent) - 1, 0);
        if (resp)
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }
        scanf(" %[^\n\r]", ent);
    }
}