package Estructura_De_Datos;

public class ArbolAvl extends ArbolBinario {

    public void insertarNodo(int dato) {
        raiz = insertarNodo(raiz, dato);
    }

    private NodoDeArbol insertarNodo(NodoDeArbol nodo, int dato) {
        if (nodo == null) {
            return new NodoDeArbol(dato);
        }
        if (dato < nodo.datos) {
            nodo.nodoIzquierdo = insertarNodo(nodo.nodoIzquierdo, dato);
        } else if (dato > nodo.datos) {
            nodo.nodoDerecho = insertarNodo(nodo.nodoDerecho, dato);
        } else {
            return nodo;
        }

        nodo.altura = 1 + Math.max(altura(nodo.nodoIzquierdo), altura(nodo.nodoDerecho));
        int balance = getBalance(nodo);

        if (balance > 1 && dato < nodo.nodoIzquierdo.datos) {
            return rightRotate(nodo);
        }

        if (balance < -1 && dato > nodo.nodoDerecho.datos) {
            return leftRotate(nodo);
        }

        if (balance > 1 && dato > nodo.nodoIzquierdo.datos) {
            nodo.nodoIzquierdo = leftRotate(nodo.nodoIzquierdo);
            return rightRotate(nodo);
        }

        if (balance < -1 && dato < nodo.nodoDerecho.datos) {
            nodo.nodoDerecho = rightRotate(nodo.nodoDerecho);
            return leftRotate(nodo);
        }

        return nodo;
    }

    public NodoDeArbol eliminarNodo(int dato) {
        raiz = eliminarNodo(raiz, dato);
        return raiz;
    }

    private NodoDeArbol eliminarNodo(NodoDeArbol nodo, int dato) {
        if (nodo == null) {
            return nodo;
        }

        if (dato < nodo.datos) {
            nodo.nodoIzquierdo = eliminarNodo(nodo.nodoIzquierdo, dato);
        } else if (dato > nodo.datos) {
            nodo.nodoDerecho = eliminarNodo(nodo.nodoDerecho, dato);
        } else {
            if ((nodo.nodoIzquierdo == null) || (nodo.nodoDerecho == null)) {
                NodoDeArbol temp = null;
                if (temp == nodo.nodoIzquierdo) {
                    temp = nodo.nodoDerecho;
                } else {
                    temp = nodo.nodoIzquierdo;
                }

                if (temp == null) {
                    temp = nodo;
                    nodo = null;
                } else {
                    nodo = temp;
                }
            } else {
                NodoDeArbol temp = minValueNode(nodo.nodoDerecho);
                nodo.datos = temp.datos;
                nodo.nodoDerecho = eliminarNodo(nodo.nodoDerecho, temp.datos);
            }
        }

        if (nodo == null) {
            return nodo;
        }

        nodo.altura = Math.max(altura(nodo.nodoIzquierdo), altura(nodo.nodoDerecho)) + 1;
        int balance = getBalance(nodo);

        if (balance > 1 && getBalance(nodo.nodoIzquierdo) >= 0) {
            return rightRotate(nodo);
        }

        if (balance > 1 && getBalance(nodo.nodoIzquierdo) < 0) {
            nodo.nodoIzquierdo = leftRotate(nodo.nodoIzquierdo);
            return rightRotate(nodo);
        }

        if (balance < -1 && getBalance(nodo.nodoDerecho) <= 0) {
            return leftRotate(nodo);
        }

        if (balance < -1 && getBalance(nodo.nodoDerecho) > 0) {
            nodo.nodoDerecho = rightRotate(nodo.nodoDerecho);
            return leftRotate(nodo);
        }

        return nodo;
    }

    private NodoDeArbol minValueNode(NodoDeArbol nodo) {
        NodoDeArbol current = nodo;
        while (current.nodoIzquierdo != null) {
            current = current.nodoIzquierdo;
        }
        return current;
    }

    private int altura(NodoDeArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    private int getBalance(NodoDeArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.nodoIzquierdo) - altura(nodo.nodoDerecho);
    }

    private NodoDeArbol rightRotate(NodoDeArbol y) {
        NodoDeArbol x = y.nodoIzquierdo;
        NodoDeArbol T2 = x.nodoDerecho;
        x.nodoDerecho = y;
        y.nodoIzquierdo = T2;
        y.altura = Math.max(altura(y.nodoIzquierdo), altura(y.nodoDerecho)) + 1;
        x.altura = Math.max(altura(x.nodoIzquierdo), altura(x.nodoDerecho)) + 1;
        return x;
    }

    private NodoDeArbol leftRotate(NodoDeArbol x) {
        NodoDeArbol y = x.nodoDerecho;
        NodoDeArbol T2 = y.nodoIzquierdo;
        y.nodoIzquierdo = x;
        x.nodoDerecho = T2;
        x.altura = Math.max(altura(x.nodoIzquierdo), altura(x.nodoDerecho)) + 1;
        y.altura = Math.max(altura(y.nodoIzquierdo), altura(y.nodoDerecho)) + 1;
        return y;
    }
}

