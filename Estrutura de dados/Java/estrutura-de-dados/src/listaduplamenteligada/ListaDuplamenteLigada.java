package listaduplamenteligada;

import listaligada.Celula;

public class ListaDuplamenteLigada {

    private CelulaDupla primeira = null;
    private CelulaDupla ultima = null ;
    private int totalElementos = 0;

    public void adicionaNoComeco(Object elemento){

        if(totalElementos == 0 ){
            CelulaDupla novaCelula = new CelulaDupla(elemento);
            this.primeira = novaCelula;
            this.ultima = novaCelula;

        }else{

            CelulaDupla novaCelula = new CelulaDupla(elemento, this.primeira);
            this.primeira.setAnterior(novaCelula);
            this.primeira = novaCelula;
        }

        this.totalElementos ++;
    }

    public void adiciona(Object elemento){

        if(this.totalElementos == 0){
            this.adicionaNoComeco(elemento);

        }else{

            CelulaDupla novaCelula = new CelulaDupla(elemento);

            this.ultima.setProximo(novaCelula);
            novaCelula.setAnterior(this.ultima);

            this.ultima = novaCelula;

            this.totalElementos ++;

        }

    }

    public void adiciona(int posicao, Object elemento){

        if(posicao == 0){
            adicionaNoComeco(elemento);

        }else if(posicao == this.totalElementos){
            adiciona(elemento);

        }else{

            CelulaDupla celulaAnterior = this.pegaCelula(posicao - 1);
            CelulaDupla celulaProximaDaAnterior = celulaAnterior.getProximo();
            CelulaDupla novaCelula = new CelulaDupla(elemento, celulaAnterior.getProximo());

            novaCelula.setAnterior(celulaAnterior);

            celulaAnterior.setProximo(novaCelula);
            celulaProximaDaAnterior.setAnterior(novaCelula);

            this.totalElementos ++;
        }

    }

    public Object pega(int posicao){
        return this.pegaCelula(posicao).getElemento();
    }

    private CelulaDupla pegaCelula(int posicao){

        if(!posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inexistente");
        }

        CelulaDupla atual = this.primeira;

        for(int i = 0; i < posicao; i++){
            atual = atual.getProximo();
        }

        return atual;
    }

    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < this.totalElementos;
    }

    public void removeDoComeco(){
        if(this.totalElementos == 0){
            throw new IllegalArgumentException("Não existe uma celula no começo");
        }

        this.primeira = primeira.getProximo();
        this.totalElementos --;

        if(this.totalElementos == 0){
            this.primeira = null;
        }
    }

    public int tamanho(){
        return this.totalElementos;
    }

    public void removeDoFim(){
        if(this.totalElementos == 0){
            this.removeDoComeco();
        }else{

            CelulaDupla penultimaCelula = this.ultima.getAnterior();

            penultimaCelula.setProximo(null);
            this.ultima = penultimaCelula;

            this.totalElementos --;
        }
    }

    public void remove(int posicao){
        if(posicao == 0){
            this.removeDoComeco();

        }else if(posicao == this.totalElementos){
            this.removeDoFim();

        }else{
            CelulaDupla anterior = this.pegaCelula(posicao - 1);
            CelulaDupla atual = anterior.getProximo();
            CelulaDupla proxima = atual.getProximo();

            anterior.setProximo(proxima);
            proxima.setAnterior(anterior);

            this.totalElementos --;
        }
    }

    public boolean contem(Object elemento){
        return false;
    }

    @Override
    public String toString() {

        if(this.totalElementos == 0){
            return "[]";
        }

        CelulaDupla celulaAtual = primeira;

        StringBuilder builder = new StringBuilder("[");

        for( int i = 0; i < totalElementos; i++){
            builder.append(celulaAtual.getElemento())
                    .append(", ");

            celulaAtual = celulaAtual.getProximo();
        }

        return  builder.append("]").toString();
    }
}
