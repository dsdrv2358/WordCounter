
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

public class LyricDatabaseTest {

    @Test
    public void addTest(){
        LyricDatabase<String> collection = new ICHSLyricDatabase<String>();
        collection.add("test text");
        assertTrue(collection.contains("test test"));
    }

    @Test
    public void containsTest(){
        LyricDatabase<String> collection = new ICHSLyricDatabase<String>();
        collection.add("test text");
        assertTrue(collection.contains("test test"));
    }

    @Test
    public void getCountTest(){
        LyricDatabase<String> collection = new ICHSLyricDatabase<String>();
        collection.add("test text");
        collection.add("test text2");
        collection.add("test text");
        assertEquals(2,collection.getCount("test test"));
    }

    @Test
    public void getNumItemsTest(){
        LyricDatabase<String> collection = new ICHSLyricDatabase<String>();
        collection.add("test text");
        collection.add("test text2");
        collection.add("test text3");
        collection.add("test text4");
        collection.add("test text5");
        collection.add("test text6");
        assertEquals(6,collection.getCount("test test"));
    }
}
