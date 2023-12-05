

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import BST.BTNode;
import BST.BTNodeUtil;

public class BTNodeUtilTest {


    @Test
    public void nodeCountTest(){
        assertEquals(7, BTNodeUtil.nodeCount(SampleTrees.getTree1()));
        assertEquals(9, BTNodeUtil.nodeCount(SampleTrees.getTree4()));
        assertEquals(3, BTNodeUtil.nodeCount(SampleTrees.getTree1().getRight()));
        assertEquals(4, BTNodeUtil.nodeCount(SampleTrees.getTree4().getLeft()));
        assertEquals(4, BTNodeUtil.nodeCount(SampleTrees.getTree4().getRight()));

        assertEquals(0, BTNodeUtil.nodeCount(null));
        assertEquals(1, BTNodeUtil.nodeCount(new BTNode<String>("plank")));
    }

    @Test
    public void containsTest(){
        for (int key=1; key<8; key++){
            assertTrue(BTNodeUtil.contains(SampleTrees.getTree1(), key));
            assertTrue(BTNodeUtil.contains(SampleTrees.getTree2(), key));
            assertTrue(BTNodeUtil.contains(SampleTrees.getTree3(), key));
        }

        assertFalse(BTNodeUtil.contains(SampleTrees.getTree1(), 0));
        assertFalse(BTNodeUtil.contains(SampleTrees.getTree2(), 8));
        assertFalse(BTNodeUtil.contains(SampleTrees.getTree3(), 12));

        assertTrue(BTNodeUtil.contains(SampleTrees.getTree4(), 100));
        assertTrue(BTNodeUtil.contains(SampleTrees.getTree4(), 122));
        assertTrue(BTNodeUtil.contains(SampleTrees.getTree4(), 112));
        assertTrue(BTNodeUtil.contains(SampleTrees.getTree4(), 17));

        assertFalse(BTNodeUtil.contains(SampleTrees.getTree4().getRight(), 100));
        assertTrue(BTNodeUtil.contains(SampleTrees.getTree4().getRight(), 132));

        assertFalse(BTNodeUtil.contains(null, 100));
        assertFalse(BTNodeUtil.contains(new BTNode<String>("plank"), 3));
        assertTrue(BTNodeUtil.contains(new BTNode<String>("spank"), 5));
    }

    @Test
    public void preOrderStringTest(){
        assertEquals("1, 2, 3, 4, 5, 6, 7, ", BTNodeUtil.preOrderString(SampleTrees.getTree2()));
        assertEquals("100, 22, 5, 1, 17, 132, 105, 122, 112, ", BTNodeUtil.preOrderString(SampleTrees.getTree4()));
    }

    @Test
    public void postOrderStringTest(){
        assertEquals("1, 2, 3, 4, 5, 6, 7, ", BTNodeUtil.postOrderString(SampleTrees.getTree3()));
        assertEquals("1, 17, 5, 22, 112, 122, 105, 132, 100, ", BTNodeUtil.postOrderString(SampleTrees.getTree4()));

    }

    @Test
    public void inOrderStringTest(){
        assertEquals("1, 2, 3, 4, 5, 6, 7, ", BTNodeUtil.inOrderString(SampleTrees.getTree1()));
        assertEquals("1, 5, 17, 22, 100, 105, 112, 122, 132, ", BTNodeUtil.inOrderString(SampleTrees.getTree4()));
    }

    @Test
    public void heightTest(){
        assertEquals(2, BTNodeUtil.height(SampleTrees.getTree1()));
        assertEquals(2, BTNodeUtil.height(SampleTrees.getTree2()));
        assertEquals(4, BTNodeUtil.height(SampleTrees.getTree4()));
        assertEquals(1, BTNodeUtil.height(SampleTrees.getTree1().getRight()));
        assertEquals(2, BTNodeUtil.height(SampleTrees.getTree4().getLeft()));
        assertEquals(3, BTNodeUtil.height(SampleTrees.getTree4().getRight()));

        assertEquals(-1, BTNodeUtil.height(null));
        assertEquals(0, BTNodeUtil.height(new BTNode<String>("plank")));
    }

    // @Test
    // public void printingHashes(){
    //     List<String> words = new ArrayList<>();
    //     Collections.addAll(words, "apple", "banana", "orange", "grape", "kiwi",
    //             "melon", "pear", "cherry", "strawberry", "blueberry",
    //             "watermelon", "pineapple", "peach", "apricot", "plum",
    //             "lemon", "lime", "raspberry", "blackberry", "cranberry");
    //     for (int i = 0; i < words.size(); i++){
    //         System.out.println(words.get(i) + ":" + String.valueOf(BTNode.hash(words.get(i))));
    //     }
    // }
    
}
