package Estructura_De_Datos;

import java.util.ArrayList;
import java.util.List;

public class ArbolAvl {
    private Nodo raiz;

    public ArbolAvl() {
        raiz = null;
    }

    public void insertarNodo(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor < nodo.valor) {
            nodo.izquierda = insertarRecursivo(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = insertarRecursivo(nodo.derecha, valor);
        }
        return nodo;
    }

    public String preOrden() {
        List<Integer> resultado = new ArrayList<>();
        preOrdenRecursivo(raiz, resultado);
        return resultado.toString();
    }

    private void preOrdenRecursivo(Nodo nodo, List<Integer> resultado) {
        if (nodo != null) {
            resultado.add(nodo.valor);
            preOrdenRecursivo(nodo.izquierda, resultado);
            preOrdenRecursivo(nodo.derecha, resultado);
        }
    }

    public String inOrden() {
        List<Integer> resultado = new ArrayList<>();
        inOrdenRecursivo(raiz, resultado);
        return resultado.toString();
    }

    private void inOrdenRecursivo(Nodo nodo, List<Integer> resultado) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.izquierda, resultado);
            resultado.add(nodo.valor);
            inOrdenRecursivo(nodo.derecha, resultado);
        }
    }

    public String postOrden() {
        List<Integer> resultado = new ArrayList<>();
        postOrdenRecursivo(raiz, resultado);
        return resultado.toString();
    }

    private void postOrdenRecursivo(Nodo nodo, List<Integer> resultado) {
        if (nodo != null) {
            postOrdenRecursivo(nodo.izquierda, resultado);
            postOrdenRecursivo(nodo.derecha, resultado);
            resultado.add(nodo.valor);
        }
    }

    public void inOrden(int i) {

    }
}

