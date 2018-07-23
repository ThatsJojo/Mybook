package util;

/**
 * Estrutura para armazenamento e busca de objetos através de hashCode com 
 * fator de sobrecarga de 50%.
 * @author Cleyton
 */
public class HashSet implements IHashSet{
    private static class Empty{}
    //Atributos de classe.
    private static final Empty EMPTY = new Empty();
    private static final double FATORDECARGA = 0.5;
    //Atributos de objeto.
    private Object array[];
    private int size;
    
    HashSet(){
        array = new Object [31];
        size = 0;
    }
    
    /**
     * @param i Tamanho inicial da estrutura.
     */
    HashSet(int i){
        array = new Object [i];
        size = 0;
    }
    
    
    private boolean sobrecarregado (){
        return ((double) size/array.length)>FATORDECARGA;
    }
    
    @Override
    public void clear(){
        array = new Object[31];
        size = 0;
    }
    
    private void resize(){
        size = 0;
        Object[] auxArray = array;
        array = new Object[Primos.nextPrime(array.length*2)];
        for (Object auxArray1 : auxArray)
            if (auxArray1 != null && auxArray1!=EMPTY)
                add(auxArray1);
    }
    
    @Override
    public int size(){
        return size;
    }
    
    private int hash(Object key){
        int ret = key.hashCode()%array.length;
        return ret >0? ret : - ret;
    }
    
    @Override
    public void add(Object key){
        
        if(key == null)
            return;
        if(this.contains(key))
            return;
        int index = hash(key);       
        while(array[index]!=null && array[index]!=EMPTY)
            index = index == array.length -1? 0 : index +1;
        array[index] = key;
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
            if(array[i].equals(key))
                return i;
            i = i == array.length -1? 0 : i +1;
        }while (i!=index);
        return -1;
    }
    
    @Override
    public boolean contains(Object key){
        return findIndex(key) != -1;
    }
    
    @Override
    public boolean remove(Object key){
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
}
