//package ex07;
/* Oi, aqui é o Sirius
 * eis o que eu tentei fazer nesse código além de não chorar:
 * eu tive que criar um método que faz um http request, oq seria fácil se eu pudesse usar shell script mas NAAAAO vamos fazelo em java
 * que eu passo pra um metodo que conta os elementos e depois conta as vogais e consoantes
 * tudo termina bem quando acaba bem
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class ex13 {
  private static String httpRequest(String url) {
    URL site;
    InputStream inputstream;
    BufferedReader bufferedReader;
    String response = "";
    String line;

    try {
      site = new URI(url).toURL();
      inputstream = site.openStream();
      bufferedReader = new BufferedReader(new InputStreamReader(inputstream));

      while ((line = bufferedReader.readLine()) != null) {
        response += line + "\n";
      }

      inputstream.close();
    } catch (Exception e) { }

    return response;
  }

  private static int[] countLetra(String texto, char[] letras) {
    int[] letrasCont = new int[letras.length];

    for (int i = 0; i < texto.length(); i++)
      for (int j = 0; j < letras.length; j++)
        if (texto.charAt(i) == letras[j])
          letrasCont[j]++;

    return letrasCont;
  }

  private static int[] countPalavra(String texto, String[] palavras) {
    int[] palavrasCont = new int[palavras.length];

    for (int i = 0; i < palavras.length; i++) {
      for (int j = 0; j < texto.length(); j++) {
        if (texto.charAt(j) == palavras[i].charAt(0) && j + palavras[i].length() < texto.length()) {
          int check = palavras[i].length();
          boolean igual = true;

          for (int k = 0; k < check; k++) {
            if (palavras[i].charAt(k) != texto.charAt(j + k))
              igual = false;
          }

          if (igual) palavrasCont[i]++;
        }
      }
    }

    return palavrasCont;
  }


  private static void contaElementos(String url, String texto) {
    String textoSite = httpRequest(url);

    char[] vogais = { 'a', 'e', 'i', 'o', 'u', '\u00E1', '\u00E9', '\u00ED', '\u00F3', '\u00FA', '\u00E0', '\u00E8', '\u00EC', '\u00F2', '\u00F9', '\u00E3', '\u00F5', '\u00E2', '\u00EA', '\u00EE', '\u00F4', '\u00FB' };
    char[] consoantes = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z' };
    String[] tags = {"<br>", "<table>"};

    int[] countVogais = countLetra(textoSite, vogais);

    int[] countConsoantes = countLetra(textoSite, consoantes);
    int totalConsoantes = 0;

    int[] countTags = countPalavra(textoSite, tags);
    countVogais[0] -= (1 * countTags[1]);
    countVogais[1] -= (1 * countTags[1]);
    totalConsoantes -= (3 * countTags[1]);
    totalConsoantes -= (2 * countTags[0]);


    for (int i = 0; i < vogais.length; i++)
      System.out.print(vogais[i] + "(" + countVogais[i] + ") ");

    for (int i = 0; i < countConsoantes.length; i++)
      totalConsoantes += countConsoantes[i];

    System.out.print("consoante(" + totalConsoantes + ") ");

    for (int i = 0; i < countTags.length; i++)
      System.out.print(tags[i] + "(" + countTags[i] + ") ");

    System.out.println(texto);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String entrada = scanner.nextLine();
    String url;

    while (!entrada.equals("FIM")) {
      url = scanner.nextLine();
      contaElementos(url, entrada);

      entrada = scanner.nextLine();
    }

    scanner.close();
  }
}