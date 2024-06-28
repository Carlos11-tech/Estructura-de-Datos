package Estructura_De_Datos;

import java.util.ArrayList;
import java.util.List;

public class ArbolNegroRojo {
    private Nodo raiz;

    public ArbolNegroRojo() {
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

    public void eliminarNodo(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private Nodo eliminarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return nodo;
        }
        if (valor < nodo.valor) {
            nodo.izquierda = eliminarRecursivo(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = eliminarRecursivo(nodo.derecha, valor);
        } else {
            if (nodo.izquierda == null) {
                return nodo.derecha;
            } else if (nodo.derecha == null) {
                return nodo.izquierda;
            }
            nodo.valor = minValue(nodo.derecha);
            nodo.derecha = eliminarRecursivo(nodo.derecha, nodo.valor);
        }
        return nodo;
    }

    private int minValue(Nodo nodo) {
        int minValue = nodo.valor;
        while (nodo.izquierda != null) {
            nodo = nodo.izquierda;
            minValue = nodo.valor;
        }
        return minValue;
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
}

