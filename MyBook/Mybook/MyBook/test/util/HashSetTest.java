package util;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HashSetTest {
    HashSet hashSet;
    
    @Before
    public void setUp() {
        hashSet = new HashSet();
    }

    @Test
    public void testClear() {
        hashSet.add(1);
        hashSet.add(5);
        hashSet.add(4);
        hashSet.add(3);
        hashSet.add(2);
        hashSet.clear();
        assertTrue(hashSet.isEmpty());
    }

    @Test
    public void testSize() {
        for(int i = 1; i<1000; i++){
            hashSet.add(i);
            assertEquals(i, hashSet.size());
        }
    }

    @Test
    public void testAddEContains() {
        for(int i = 1; i<1000; i++){
            hashSet.add(i);
            assertTrue(hashSet.contains(i));
        }
    }

    @Test
    public void testRemoveEIsEmpty() {
        assertTrue(hashSet.isEmpty());
        for(int i = 0; i<1000; i++)
            hashSet.add(i);
        for(int i = 0; i<1000; i++){
            hashSet.remove(i);
            assertFalse(hashSet.contains(i));
        }
        assertTrue(hashSet.isEmpty());    
    }
        
}
