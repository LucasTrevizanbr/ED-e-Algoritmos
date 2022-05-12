package listaduplamenteligada;

public class CelulaDupla {

    private Object elemento;

    private CelulaDupla proxima;
    private CelulaDupla anterior;

    public CelulaDupla(Object elemento, CelulaDupla proxima) {
        this.elemento = elemento;
        this.proxima = proxima;
    }

    public CelulaDupla(Object elemento) {
        this.elemento = elemento;
        this.proxima = null;
        this.anterior = null;
    }

    public Object getElemento() {
        return elemento;
    }

    public CelulaDupla getProximo() {
        return proxima;
    }

    public void setProximo(CelulaDupla proximo) {
        this.proxima = proximo;
    }

    public CelulaDupla getAnterior() {
        return anterior;
    }

    public void setAnterior(CelulaDupla anterior) {
        this.anterior = anterior;
    }
}
