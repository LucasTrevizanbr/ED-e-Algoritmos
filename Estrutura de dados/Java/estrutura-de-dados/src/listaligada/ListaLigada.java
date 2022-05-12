package listaligada;

public class ListaLigada {

    private Celula primeira = null;
    private Celula ultima = null ;
    private int totalElementos = 0;

    public void adicionaNoComeco(Object elemento){

        this.primeira = new Celula(elemento, this.primeira);

        if(totalElementos == 0 ){
            this.ultima = this.primeira;
        }

        this.totalElementos ++;
    }

    public void adiciona(Object elemento){

        if(this.totalElementos == 0){
            this.adicionaNoComeco(elemento);

        }else{

            Celula novaCelula = new Celula(elemento, null);
            this.ultima.setProximo(novaCelula);
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

            Celula anterior = this.pegaCelula(posicao - 1);
            Celula nova = new Celula(elemento, anterior.getProximo());

            anterior.setProximo(nova);
            this.totalElementos ++;
        }

    }

    public Object pega(int posicao){
        return this.pegaCelula(posicao).getElemento();
    }

    private Celula pegaCelula(int posicao){

        if(!posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inexistente");
        }

        Celula atual = this.primeira;

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

    public void remove(int posicao){

    }

    public boolean contem(Object elemento){
        return false;
    }

    @Override
    public String toString() {

        if(this.totalElementos == 0){
            return "[]";
        }

        Celula celulaAtual = primeira;

        StringBuilder builder = new StringBuilder("[");

        for( int i = 0; i < totalElementos; i++){
            builder.append(celulaAtual.getElemento())
                    .append(", ");

            celulaAtual = celulaAtual.getProximo();
        }

        return  builder.append("]").toString();
    }
}
