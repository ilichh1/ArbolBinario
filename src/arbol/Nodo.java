package arbol;

/*
 * Licencia pendiente, para cambiar la licencia ir a -> Tools | Templates
 */

/**
 *
 * @author Ilich Arredondo
 */
public class Nodo {
    private String valor;
    private Nodo nodoIzquierdo;
    private Nodo nodoDerecho;
    
    public Nodo(String v) {
        this.valor = v;
        this.nodoIzquierdo = null;
        this.nodoDerecho = null;
    }
    
    public int getClave() {
        return Util.charToInt(this.valor.charAt(0));
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the nodoIzquierdo
     */
    public Nodo getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    /**
     * @param nodoIzquierdo the nodoIzquierdo to set
     */
    public void setNodoIzquierdo(Nodo nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    /**
     * @return the nodoDerecho
     */
    public Nodo getNodoDerecho() {
        return nodoDerecho;
    }

    /**
     * @param nodoDerecho the nodoDerecho to set
     */
    public void setNodoDerecho(Nodo nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }
  
}