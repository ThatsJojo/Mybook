package util;

import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HashTableTest {
       HashTable hashTable;
    
    @Before
    public void setUp() {
        hashTable = new HashTable();
    }
    
    @Test
    public void testSize() {
        assertEquals(0, hashTable.size());
        for(int i = 1; i<1000;i++){
            hashTable.put(i, "User" + i);
            assertEquals(i,hashTable.size());
        }
    }

    @Test
    public void testPutEGet() {
        for(int i = 0; i<1000;i++){
            hashTable.put(i, "Objeto: " + i);
            assertEquals("Objeto: " + i,hashTable.get(i));
        }
    }

    @Test
    public void testContains() {
        for(int i = 0; i<1000;i++)
            hashTable.put(i, "Objeto: " + i);
        for(int i = 0; i<1000;i++)
            hashTable.contains(i); 
    }

    @Test
    public void testRemoveValue() {
        for(int i = 0; i<1000; i++)
            assertFalse(hashTable.removeValue(i));
        for(int i = 0; i<1000;i++)
            hashTable.put(i, "Objeto: " + i);
        for(int i = 0; i<1000;i++){
            assertTrue(hashTable.contains(i));
            assertTrue(hashTable.removeValue("Objeto: " + i));
            assertFalse(hashTable.contains(i));
        }
    }

    @Test
    public void testRemoveKey() {
        for(int i = 0; i<1000; i++)
            assertFalse(hashTable.removeKey(i));
        for(int i = 0; i<1000;i++)
            hashTable.put(i, "Objeto: " + i);
        for(int i = 0; i<1000;i++){
            assertTrue(hashTable.contains(i));
            assertTrue(hashTable.removeKey(i));
            assertFalse(hashTable.contains(i));
        }
    }

    @Test
    public void testIsEmpty() {
        assertTrue(hashTable.isEmpty());
        for(int i =0; i<1000; i++)
            hashTable.put(i, i);
        for(int i = 0; i<1000; i++)
            hashTable.removeKey(i);
        assertTrue(hashTable.isEmpty());
    }

    @Test
    public void testIterator() {
        
        for(int i = 0; i<1000; i++)
            hashTable.put(i, "Objeto: "+ i);
        
        Iterator it = hashTable.iterator();
        for(int i = 0; it.hasNext()&&i<1000; i++)
            assertEquals("Objeto: " + i, it.next());
    }  
}
