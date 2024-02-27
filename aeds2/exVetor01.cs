using System;

/*
 * Exemplo de Preenchimento do vetor com valores inteiros
 */
class MainClass {
    // Define o tamanho para o vetor
    const int TAM = 10;

    public static void Main (string[] args) {
        //Declaração vetor com tamanho TAM 
        int[] vetor = new int[TAM];
        
        //Cria objeto random para obter os números aleatórios
        Random rnd = new Random();
        for(int i=0; i<TAM; i++)
            vetor[i] = rnd.Next(10);

        //Imprime na tela os valores armazenados no vetor
        Console.Write("Array com valores inteiros: \n");
        Console.Write("[ ");
        for(int i=0; i<TAM; i++)
            Console.Write(vetor[i] + ",");
        Console.Write("]\n");
  }

}