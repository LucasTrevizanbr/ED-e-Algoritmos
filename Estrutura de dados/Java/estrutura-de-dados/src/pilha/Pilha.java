package pilha;

import java.util.Locale;
import java.util.Stack;

public class Pilha {

    public static void main(String[] args) {

        Stack<Character> pilha = new Stack<>();

        String palavra = "Caminhão";

        char[] letras = palavra.toLowerCase(Locale.ROOT).toCharArray();

        for (char letra : letras){
            pilha.push(letra);
        }

        StringBuilder palavraContrario = new StringBuilder();

        while(!pilha.isEmpty()){
            palavraContrario.append(pilha.pop());
        }

        System.out.println(palavraContrario);


    }


}
