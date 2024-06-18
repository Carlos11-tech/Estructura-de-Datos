package Estructura_De_Datos;

public class ArbolBinario {
    protected int numeroNodos;
    protected NodoDeArbol raiz;

    public ArbolBinario() {
        this.raiz = null;
        this.numeroNodos = 0;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public void preOrden() {
        preOrden(raiz);
    }

    private void preOrden(NodoDeArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.datos + " ");
            preOrden(nodo.nodoIzquierdo);
            preOrden(nodo.nodoDerecho);
        }
    }

    public void inOrden() {
        inOrden(raiz);
    }

    private void inOrden(NodoDeArbol nodo) {
        if (nodo != null) {
            inOrden(nodo.nodoIzquierdo);
            System.out.print(nodo.datos + " ");
            inOrden(nodo.nodoDerecho);
        }
    }

    public void postOrden() {
        postOrden(raiz);
    }

    private void postOrden(NodoDeArbol nodo) {
        if (nodo != null) {
            postOrden(nodo.nodoIzquierdo);
            postOrden(nodo.nodoDerecho);
            System.out.print(nodo.datos + " ");
        }
    }

    public void insertacion(int dato) {
        raiz = insertacion(raiz, dato);
        numeroNodos++;
    }

    private NodoDeArbol insertacion(NodoDeArbol nodo, int dato) {
        if (nodo == null) {
            return new NodoDeArbol(dato);
        }
        if (dato < nodo.datos) {
            nodo.nodoIzquierdo = insertacion(nodo.nodoIzquierdo, dato);
        } else {
            nodo.nodoDerecho = insertacion(nodo.nodoDerecho, dato);
        }
        return nodo;
    }

    public void eliminacion(int dato) {
        raiz = eliminacion(raiz, dato);
        numeroNodos--;
    }

    private NodoDeArbol eliminacion(NodoDeArbol nodo, int dato) {
        if (nodo == null) {
            return null;
        }
        if (dato < nodo.datos) {
            nodo.nodoIzquierdo = eliminacion(nodo.nodoIzquierdo, dato);
        } else if (dato > nodo.datos) {
            nodo.nodoDerecho = eliminacion(nodo.nodoDerecho, dato);
        } else {
            if (nodo.nodoIzquierdo == null) {
                return nodo.nodoDerecho;
            } else if (nodo.nodoDerecho == null) {
                return nodo.nodoIzquierdo;
            }
            nodo.datos = minValue(nodo.nodoDerecho);
            nodo.nodoDerecho = eliminacion(nodo.nodoDerecho, nodo.datos);
        }
        return nodo;
    }

    private int minValue(NodoDeArbol nodo) {
        int min = nodo.datos;
        while (nodo.nodoIzquierdo != null) {
            min = nodo.nodoIzquierdo.datos;
            nodo = nodo.nodoIzquierdo;
        }
        return min;
    }
}
