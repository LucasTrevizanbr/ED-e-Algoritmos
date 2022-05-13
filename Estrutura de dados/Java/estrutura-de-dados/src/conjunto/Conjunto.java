package conjunto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.List;

public class Conjunto {

    private final ArrayList<LinkedList<String>> tabela = new ArrayList<>();

    public Conjunto(){
        for(int i = 0; i < 26; i++){
            tabela.add(new LinkedList<String>());
        }
    }

    public void adiciona(String palavra){

        if(!contem(palavra)){

            int indice = this.calculaIndiceDaTabela(palavra);
            List<String> lista = tabela.get(indice);
            lista.add(palavra);
        }
        
    }

    public void remove(String palavra){

        if(!contem(palavra)){
            int indice = calculaIndiceDaTabela(palavra);
            List<String> lista = tabela.get(indice);
            lista.remove(palavra);
        }

    }

    private boolean contem(String palavra) {
        int indice = this.calculaIndiceDaTabela(palavra);
        return tabela.get(indice).contains(palavra);
    }

    private int calculaIndiceDaTabela(String palavra) {
        return palavra.toLowerCase(Locale.ROOT).charAt(0) % 26;
    }


    @Override
    public String toString() {
        return tabela.toString();
    }
}
