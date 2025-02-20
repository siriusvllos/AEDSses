#include <stdio.h>
#include <string.h>

/* Olá, aqui é o Sirius
 * Eu escrevi esse código para cumprir a função da q01 do TP01,
 * ele lê uma entrada string, e retorna se essa string é um palindromo ou nao.
 * Eu fiz isso partindo a string no meio, e vindo da esquerda e direita comparando
 * os caracteres
 * FOI UM PARTO */
void isPalindrome(char string[])
{
    int esq = 0, dir = strlen(string) - 1;
    int count = 0;

    for (int i = 0; i < (strlen(string) / 2); i++)
    {
        if (string[esq] == string[dir])
        {
            count++;
        }
        dir--;
        esq++;
    }

    if (strlen(string) / 2 == count++)
    {
        printf("SIM\n");
    }
    else
    {
        printf("NAO\n");
    }
}

int main()
{
    char palindromo[500];
    scanf(" %[^\n\r]", palindromo);

    while (strcmp(palindromo, "FIM"))
    {
        isPalindrome(palindromo);
        scanf(" %[^\n\r]", palindromo);
    }

    return 0;
}