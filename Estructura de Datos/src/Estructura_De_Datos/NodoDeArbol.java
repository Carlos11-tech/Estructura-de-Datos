package Estructura_De_Datos;

public class NodoDeArbol {
    public NodoDeArbol nodoIzquierdo;
    public NodoDeArbol nodoDerecho;
    public NodoDeArbol nodoPadre;
    public int altura;
    public int datos;

    public NodoDeArbol(int datos) {
        this.datos = datos;
        this.altura = 1; // Asumimos que la altura inicial del nodo es 1
    }
}
