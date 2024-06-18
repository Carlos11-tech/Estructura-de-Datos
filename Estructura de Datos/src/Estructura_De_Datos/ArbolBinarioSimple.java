package Estructura_De_Datos;

public class ArbolBinarioSimple extends ArbolBinario {

    public void insertarNodo(int dato) {
        insertacion(dato);
    }

    public NodoDeArbol eliminarNodo(int dato) {
        eliminacion(dato);
        return raiz;
    }
}

