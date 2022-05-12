import listaligada.ListaLigada;

public class Teste {

    public static void main(String[] args) {

        ListaLigada lista = new ListaLigada();

        System.out.println(lista);

        lista.adicionaNoComeco("Roberto");
        System.out.println(lista);

        lista.adicionaNoComeco("Mauro");
        System.out.println(lista);

        lista.adicionaNoComeco("Betinho saad");
        System.out.println(lista);

        lista.adiciona("Marcelo");
        System.out.println(lista);

        lista.adiciona(2, "Gabruxona");
        System.out.println(lista);

        System.out.println(lista.tamanho());



    }
}
