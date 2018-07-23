package util;

import java.util.Objects;

public class Vertice {
    private HashSet adjacencias;
    private Object key;
    private Object data;

    public Vertice (Object key){
        this.key = key;
    }
    
    public Vertice (Object key, Object data){
        this.key = key;
        this.data = data;
    }
    
    public Vertice (){}

    public HashSet getAdjacencias() {
        return adjacencias;
    }

    @Override
    public int hashCode(){
        return key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertice other = (Vertice) obj;
        return Objects.equals(this.key, other.key);
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
        
}
