import Estructura_De_Datos.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EstructuraDeDatos estructura = new EstructuraDeDatos("Estructura1", 0);
        estructura.agregarNodo();

        ArbolAvl arbolAVL = new ArbolAvl();

        arbolAVL.insertarNodo(5);
        arbolAVL.insertarNodo(3);
        arbolAVL.insertarNodo(7);


        System.out.println("Recorrido preorden del árbol AVL:");
        arbolAVL.preOrden();
        System.out.println("\nRecorrido inorden del árbol AVL:");
        arbolAVL.inOrden();
        System.out.println("\nRecorrido postorden del árbol AVL:");
        arbolAVL.postOrden();


        ArbolNegroRojo arbolRN = new ArbolNegroRojo();


        arbolRN.insertarNodo(10);
        arbolRN.insertarNodo(5);
        arbolRN.insertarNodo(15);

        arbolRN.eliminarNodo(5);


        ListaCircular listaCircular = new ListaCircular();
        listaCircular.recorrer(0);

        Grafo grafo = new Grafo(false); // Grafo no dirigido

        Vertice v1 = new Vertice("A");
        Vertice v2 = new Vertice("B");
        Vertice v3 = new Vertice("C");

        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);

        grafo.agregarArista(v1, v2);
        grafo.agregarArista(v2, v3);

        grafo.eliminarVertice(v2);

        List<Vertice> adyacentes = grafo.obtenerAdyacentes(v1);
    }
}
