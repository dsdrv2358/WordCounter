
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

import ichs.ICHSLyricDatabase;
import interfaces.LyricDatabase;

import ichs.ICHSLyricDatabase;

import interfaces.LyricDatabase;

public class LyricDatabaseTest {

    @Test
    public void addContainsTest(){
        LyricDatabase<String> collection = new ICHSLyricDatabase<String>(1000000000);
        for (int i = 0; i < 1000000; i++){
            collection.add("test" + i);
        }
        for (int i = 0; i < 1000000; i++){
            assertTrue(collection.contains("test" + i));
        }
    }

    @Test
    public void getCountTest(){
        LyricDatabase<String> collection = new ICHSLyricDatabase<String>();
        for (int i = 0; i < 100000; i++){
            for (int j = 0; j < 100; j++){
                collection.add("test" + i);
            }
        }
        for (int i = 0; i < 100000; i++){
            assertEquals(100,collection.getCount("test" + i));
        }
    }

    @Test
    public void getNumItemsTest(){
        LyricDatabase<String> collection = new ICHSLyricDatabase<String>();
        for (int i = 0; i < 100000; i++){
            for (int j = 0; j < 100; j++){
                collection.add("test" + i);
            }
        }
        assertEquals(100000,collection.getNumItems());
    }
}
