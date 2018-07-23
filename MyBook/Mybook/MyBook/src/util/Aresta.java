package util;

public class Aresta {
    private Vertice verticeAdjacente;
    private int peso;

    public Aresta(Vertice verticeAdjacente, int peso) {
        this.verticeAdjacente = verticeAdjacente;
        this.peso = peso;
    }
    
    public Aresta(Vertice verticeAdjacente) {
        this.verticeAdjacente = verticeAdjacente;
    }
    
    public Aresta(int peso) {
        this.peso = peso;
    }
    
    public Aresta(){}

    public Object getVerticeAdjacente() {
        return verticeAdjacente;
    }

    public void setVerticeAdjacente(Vertice verticeAdjacente) {
        this.verticeAdjacente = verticeAdjacente;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
