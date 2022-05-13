import conjunto.Conjunto;

public class Teste {

    public static void main(String[] args) {

        Conjunto conjunto = new Conjunto();

        conjunto.adiciona("Lauro");
        conjunto.adiciona("Lauro");
        conjunto.adiciona("Lucas");
        System.out.println(conjunto);

        conjunto.adiciona("Ana");
        System.out.println(conjunto);

    }

}
