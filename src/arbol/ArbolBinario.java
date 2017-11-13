package arbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Licencia pendiente, para cambiar la licencia ir a -> Tools | Templates
 */
/**
 *
 * @author Ilich Arredondo
 */
public class ArbolBinario {

    private Nodo raiz;

    public void agregarNodo(Nodo nuevoNodo) {

        if (raiz == null) {
            raiz = nuevoNodo;
            return;
        }

        //Empezamos las comparaciones con el nodo padre
        Nodo nodoActual = this.raiz;
        //Este sera el nodo que cambiara con cada iteracion
        Nodo nodoPadre;

        while (true) {
            //Empezamos con el ultimo nodo recorrido en el cliclo
            nodoPadre = nodoActual;

            //Si el valor numerico de la clave del nodo a insertar
            //es menor al nodo que estamos evaluando insertamos el nodo a la izquierda
            if (nuevoNodo.getClave() < nodoActual.getClave()) {
                //Ahora el nodo actual es el nodo izquierdo del que era el nodo acutal
                nodoActual = nodoActual.getNodoIzquierdo();
                //Si el nodo que evaluamos es el ultimo del arbol insertamos el nodo aqui
                //Si el nodo actual no es el ultimo, seguimos iterando hasta llegar al ultimo
                if (nodoActual == null) {
                    nodoPadre.setNodoIzquierdo(nuevoNodo);
                    return;
                }
            } else {
                //Si llegamos aqui debemos insertar el nodo a la derecha
                nodoActual = nodoActual.getNodoDerecho();

                if (nodoActual == null) {
                    nodoPadre.setNodoDerecho(nuevoNodo);
                    return;
                }

            }

        }

    }

    public void recorridoPreorden(Nodo nodoActual) {

        //Si el nodo actual es nulo, llegamos al final de una rama.
        if (nodoActual != null) {
            System.out.print(nodoActual.getValor());
            recorridoPreorden(nodoActual.getNodoIzquierdo());
            recorridoPreorden(nodoActual.getNodoDerecho());
        }

    }
    
    public Nodo getNodoRaiz() {
        return this.raiz;
    }

    public static void main(String[] args) {
        /**
         * @Integrante Pablo Escoto
         * @Integrante Alvaro Castañeda (Tanke)
         * @Integrante Martin Avila
         * @Integrante Yhair Perez (El Brayan)
         * @Integrante Ilich Arredondo
         */
        Scanner entradaUsuario = new Scanner(System.in);
        List<String> lineas = new ArrayList<>();
        String lineaActual = "";

        String linea = entradaUsuario.nextLine();
        while (true) {
            if (linea.equals("*") || linea.equals("$")) {
                //Agregamos la lina concatenada a la lista de lineas
                lineas.add(lineaActual);
                //Seteamos la linea actual a un string vacio
                lineaActual = "";
            } else {
                lineaActual += linea;
            }
            
            if(linea.equals("$")) break;
            
            linea = entradaUsuario.nextLine();
        }
        
        for (String linea1 : lineas) {
            
            //linea1 a charArray
            char[] nodos = linea1.toCharArray();
            //Nuestro fabuloso arbol binario
            ArbolBinario arbolBinario = new ArbolBinario();
            //Recoremos la linea de derecha a izquierda
            for(int i = nodos.length-1; i >= 0; i--) {
                arbolBinario.agregarNodo(new Nodo(Character.toString(nodos[i])));
            }
            arbolBinario.recorridoPreorden(arbolBinario.getNodoRaiz());
            System.out.println();
        }
        
    }

}
