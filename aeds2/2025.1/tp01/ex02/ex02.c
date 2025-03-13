#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main()
{
    char ent[500];
    scanf(" %[^\n\r]", ent);
    while (strcmp(ent, "FIM"))
    {
        int esq = 0, dir = strlen(ent) - 1;
        bool resp = true;
        for (int i = 0; i < (strlen(ent) - 1) / 2; i++)
        {
            if (ent[esq] != ent[dir])
            {
                resp = false;
                i = strlen(ent);
            }
            esq++, dir--;
        }
        if (resp)
        {
            printf("\nSIM");
        }
        else
        {
            printf("\nNAO");
        }

        scanf(" %[^\n\r]", ent);
    }
    return 0;
}