

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import bst.BTNode;
import bst.BTNodeUtil;

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


        assertFalse(BTNodeUtil.contains(SampleTrees.getTree1(), "v"));
        assertFalse(BTNodeUtil.contains(SampleTrees.getTree2(), "o"));
        assertFalse(BTNodeUtil.contains(SampleTrees.getTree3(), "l"));

        assertTrue(BTNodeUtil.contains(SampleTrees.getTree4(), "p"));
        assertTrue(BTNodeUtil.contains(SampleTrees.getTree4(), "r"));
        assertTrue(BTNodeUtil.contains(SampleTrees.getTree4(), "b"));
        assertTrue(BTNodeUtil.contains(SampleTrees.getTree4(), "h"));

        assertFalse(BTNodeUtil.contains(SampleTrees.getTree4().getRight(), "b"));
        assertTrue(BTNodeUtil.contains(SampleTrees.getTree4().getRight(), "u"));

        assertFalse(BTNodeUtil.contains(null, "x"));
        assertFalse(BTNodeUtil.contains(new BTNode<String>("plank"), "t"));
        assertTrue(BTNodeUtil.contains(new BTNode<String>("spank"), "spank"));
    }

    @Test
    public void preOrderStringTest(){
        assertEquals("a, b, c, d, e, f, g, ", BTNodeUtil.preOrderString(SampleTrees.getTree2()));
        // assertEquals("100, 22, 5, 1, 17, 132, 105, 122, 112, ", BTNodeUtil.preOrderString(SampleTrees.getTree4()));
    }

    @Test
    public void postOrderStringTest(){
        assertEquals("a, b, c, d, e, f, g, ", BTNodeUtil.postOrderString(SampleTrees.getTree3()));
        // assertEquals("1, 17, 5, 22, 112, 122, 105, 132, 100, ", BTNodeUtil.postOrderString(SampleTrees.getTree4()));

    }

    @Test
    public void inOrderStringTest(){
        assertEquals("a, b, c, d, e, f, h, ", BTNodeUtil.inOrderString(SampleTrees.getTree1()));
        // assertEquals("1, 5, 17, 22, 100, 105, 112, 122, 132, ", BTNodeUtil.inOrderString(SampleTrees.getTree4()));
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

    
}
