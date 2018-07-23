package util;

import java.util.Iterator;


public class Grafo implements IGrafo {
    private final HashTable usuarios;
    int numVertices;
    int numArestas;

    public Grafo(){
        this.usuarios = new HashTable();
        numVertices = 0;
        numArestas = 0;
    }
    
    public HashTable getUsuarios(){
        return usuarios;
    }
    
    
    
    
    
    
    @Override
    public void addVertice(Vertice v) {
        usuarios.put(v.getKey(), v);
        numVertices++;
    }

    @Override
    public Iterator vertices() {
        return usuarios.iterator();
    }

    @Override
    public int numVertices() {
        return numVertices;
    }

    @Override
    public void removeVertice(Object key) {
        
    }

    @Override
    public void addAresta(Vertice u, Vertice v) {
        
    }

    @Override
    public Aresta getAresta(Object u, Object v) {
        return null;
    }

    @Override
    public int numArestas() {
        return numArestas;
    }
    
    
    
}
