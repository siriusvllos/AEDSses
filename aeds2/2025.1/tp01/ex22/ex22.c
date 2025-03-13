#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int somador(char ent[], int pos)
{
    if (pos >= strlen(ent))
    {
        return 0;
    }
    else
    {
        int resp = ent[pos] - '0';
        return somador(ent, pos + 1) + resp;
    }
}
int main()
{
    char ent[500];
    scanf(" %[^\n\r]", ent);
    while (strcmp(ent, "FIM"))
    {
        int resp = somador(ent, 0);
        printf("%d\n", resp);
        scanf(" %[^\n\r]", ent);
    }
    return 0;
}