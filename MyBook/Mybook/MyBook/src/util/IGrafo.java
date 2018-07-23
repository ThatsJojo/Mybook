package util;

import java.util.Iterator;

public interface IGrafo {
    public void addVertice(Vertice v);
    public Iterator vertices();
    public int numVertices();
    public void removeVertice(Object key);
    public void addAresta(Vertice u, Vertice v);
    public Aresta getAresta(Object u, Object v);
    public int numArestas();
}
