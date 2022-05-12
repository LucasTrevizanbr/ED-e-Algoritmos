package vetor;

import modelo.Aluno;

import java.util.Arrays;

public class Vetor {

    private Aluno[] alunos = new Aluno[100];

    private int totalAlunos = 0;

    public void adiciona(Aluno aluno){
        this.garanteEspaco();

        this.alunos[totalAlunos] = aluno;
        totalAlunos++;
    }

    public void adiciona(int posicao, Aluno aluno){

        this.garanteEspaco();

        if(!posicaoValida(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }

        for(int i = totalAlunos - 1 ; i >= posicao; i-=1 ){
            alunos[i + 1] = alunos[i];
        }

        alunos[posicao] = aluno;
        totalAlunos++;
    }

    public void remove(int posicao){

        for (int i = posicao; i < this.totalAlunos - 1 ; i++){
            this.alunos[i] = this.alunos[i+1];
        }

        totalAlunos --;
    }

    public Aluno pega(int posicao){
        if(!posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }
        return alunos[posicao];
    }

    public boolean contem(Aluno aluno){
        for (Aluno a : alunos){
            if(aluno.equals(a)){
                return true;
            }
        }
        return false;
    }

    public int tamanho(){
        return this.totalAlunos;
    }

    private void garanteEspaco(){

        if(totalAlunos == alunos.length){
            Aluno[] novoArray = new Aluno[alunos.length * 2];
            for(int i = 0; i < alunos.length; i++){
                novoArray[i] = alunos[i];
            }

            this.alunos = novoArray;
        }

    }

    private boolean posicaoValida(int posicao){
        return posicao >= 0 && posicao <= totalAlunos;
    }

    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < totalAlunos;
    }


    @Override
    public String toString() {
        return Arrays.toString(alunos);
    }
}
