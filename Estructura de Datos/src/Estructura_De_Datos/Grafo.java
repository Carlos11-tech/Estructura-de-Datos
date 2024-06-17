package Estructura_De_Datos;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private boolean esDirigido;
    private List<Vertice> vertices;

    public Grafo(boolean esDirigido) {
        this.esDirigido = esDirigido;
        this.vertices = new ArrayList<>();
    }

    public void agregarVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public void agregarArista(Vertice origen, Vertice destino) {
        // Implementación del método para agregar arista
    }

    public void eliminarVertice(Vertice vertice) {
        vertices.remove(vertice);
    }

    public void eliminarArista(Vertice origen, Vertice destino) {
        // Implementación del método para eliminar arista
    }

    public boolean esDirigido() {
        return esDirigido;
    }

    public List<Vertice> obtenerAdyacentes(Vertice vertice) {
        // Implementación del método para obtener adyacentes
        return new ArrayList<>();
    }
}

