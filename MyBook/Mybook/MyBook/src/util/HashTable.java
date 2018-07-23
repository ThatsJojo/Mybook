package util;

import java.util.Iterator;

/**
 * Estrutura para armazenamento e busca de objetos com palavra chave através de
 *  hashCode com fator de sobrecarga de 50%.
 * @author Cleyton & Matheus
 */
public class HashTable implements IHashTable{
    private static class Empty{}
    private static final Empty EMPTY = new Empty();
    private static final double FATORDECARGA = 0.5;
    private Object array[];
    private int size;
    
    private boolean sobrecarregado (){
        return ((double) size/array.length)>FATORDECARGA;
    }
    
    private void resize(){
        size = 0;
        Object[] auxArray = array;
        array = new Object[Primos.nextPrime(array.length*2)];
        //Recomendável utilizar números primos, para diminuir as colisões
        for (Object auxArray1 : auxArray)
            if (auxArray1 != null && auxArray1 != EMPTY)
                put(((Entry) auxArray1).getKey(), ((Entry) auxArray1).getValue());
    }
    
    /**
     * Utilizado para pegar a quantidade de elementos da estrutura.
     * @return quantidade de elementos presentes na estrutura.
     */
    @Override
    public int size(){
        return size;
    }
    
    private int hash(Object key){
        int ret = key.hashCode()%array.length;
        return ret >0? ret : - ret;
    }
    
    /**
     * Adicionar um elemento à estrutura.
     * @param key Chave para busca da estrutura e gerar hashCode.
     * @param value Conteúdo a ser buscado pela chave.
     */
    @Override
    public void put(Object key, Object value){
        if(key == null || value == null)
            return;
        Entry e = new Entry(key, value);
        int index = hash(key);       
        while(array[index]!=null && array[index] != EMPTY)
            index = index == array.length -1? 0 : index +1;
        array[index] = e;
        size++;
        if(sobrecarregado())
            resize();
    }
    
    private int findIndex(Object key){
        int index = hash(key);
        int i = index;
        do{
            if(array[i] == null)
                return -1;
            if(array[i] !=EMPTY &&((Entry) array[i]).getKey().equals(key))
                return i;
            i = i == array.length -1? 0 : i +1;
        }while (i!=index);
        return -1;
    }
    
    @Override
    public Object get(Object key){
        int index = findIndex(key);
        return index ==-1? null : ((Entry) array[index]).getValue();
    }
        
    @Override
    public boolean contains(Object key){
        return findIndex(key) != -1;
    }
    
    public HashTable(){
        array = new Object [31];
        size = 0;
    }

    @Override
    public boolean removeValue(Object value) {
        if(value==null)
            return false;
        for(int i = 0; i<array.length; i++)
            if(array[i]!= null && array[i] !=EMPTY && ((Entry)array[i]).getValue().equals(value)){
                array[i]=EMPTY;
                return true;
            }
        return false;
    }

    @Override
    public boolean removeKey(Object key){
        int index = findIndex(key);
        if(index!=-1){
            array[index] = EMPTY;
            size--;
            return true;
        }
        return false;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public Iterator iterator(){
        return new MyIterator();
    }
    
    private class MyIterator implements Iterator{
        int count;
        
        public MyIterator(){
            count = -1;
            countToProx();
        }
        
        @Override
        public boolean hasNext() {
            return count<=array.length;
        }

        @Override
        public Object next() {
            if(count>=array.length)
                return null;
            int ret = count;
            countToProx();
            return ((Entry) array[ret]).getValue();
        }
        
        private void countToProx(){
            count++;
            for(;count<array.length &&( array[count]==null|| array[count] == EMPTY);count++){}
        }
        
    }
    
    private class Entry{
        private Object key;
        private Object value;

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
        
        public Entry(Object key, Object value){
            this.key = key;
            this.value = value;
        }
        
        @Override
        public boolean equals(Object o){
            return o!=null && o instanceof Entry? ((Entry) o).key.equals(key) : false;
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }
}
