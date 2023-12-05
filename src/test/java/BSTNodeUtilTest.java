

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import BST.BSTNodeUtil;
import BST.BTNode;
import BST.BTNodeUtil;

public class BSTNodeUtilTest {

    public BTNode<String> createExampleBstWithAddTail(){
        //need to create root node to start
        BTNode<String> root = new BTNode<String>("q");

        BSTNodeUtil.bstAddTail(root, "h");
        BSTNodeUtil.bstAddTail(root, "e");
        BSTNodeUtil.bstAddTail(root, "m");
        BSTNodeUtil.bstAddTail(root, "b");
        BSTNodeUtil.bstAddTail(root, "f");
        BSTNodeUtil.bstAddTail(root, "j");
        BSTNodeUtil.bstAddTail(root, "o");

        BSTNodeUtil.bstAddTail(root, "y");
        BSTNodeUtil.bstAddTail(root, "t");
        BSTNodeUtil.bstAddTail(root, "x");
        BSTNodeUtil.bstAddTail(root, "u");
        BSTNodeUtil.bstAddTail(root, "v");
        return root;
    }


    public BTNode<String> createExampleBstWithAdd(){
        //start with null
        BTNode<String> root = null;
        
        root = BSTNodeUtil.bstAdd(root, "q");
        root = BSTNodeUtil.bstAdd(root, "h");
        root = BSTNodeUtil.bstAdd(root, "e");
        root = BSTNodeUtil.bstAdd(root, "m");
        root = BSTNodeUtil.bstAdd(root, "b");
        root = BSTNodeUtil.bstAdd(root, "f");
        root = BSTNodeUtil.bstAdd(root, "j");
        root = BSTNodeUtil.bstAdd(root, "o");

        root = BSTNodeUtil.bstAdd(root, "y");
        root = BSTNodeUtil.bstAdd(root, "t");
        root = BSTNodeUtil.bstAdd(root, "x");
        root = BSTNodeUtil.bstAdd(root, "u");
        root = BSTNodeUtil.bstAdd(root, "v");
        return root;
    }


    //relies on BTNodeUtil.height working
    public void verifyBst(BTNode<String> root){
        assertEquals(5, BTNodeUtil.height(root));
        assertEquals(2, BTNodeUtil.height(root.getLeft()));
        assertEquals(4, BTNodeUtil.height(root.getRight()));
        assertEquals(1, BTNodeUtil.height(root.getLeft().getRight()));

        assertEquals("m", root.getLeft().getRight().getItem());
        assertEquals("x", root.getRight().getLeft().getRight().getItem());

        assertNull(root.getRight().getLeft().getRight().getLeft().getRight().getLeft());
        assertNull(root.getRight().getLeft().getRight().getLeft().getRight().getRight());
        assertNull(root.getLeft().getRight().getRight().getLeft());
        assertNull(root.getLeft().getRight().getRight().getRight());
    }


    @Test
    public void bstAddTailTest(){
        final BTNode<String> root = createExampleBstWithAddTail();
        verifyBst(root);

        assertThrows(IllegalArgumentException.class, ()-> BSTNodeUtil.bstAddTail(root, "q"));
        assertThrows(IllegalArgumentException.class, ()-> BSTNodeUtil.bstAddTail(root, "t"));
        assertThrows(IllegalArgumentException.class, ()-> BSTNodeUtil.bstAddTail(root, "j"));
        assertThrows(IllegalArgumentException.class, ()-> BSTNodeUtil.bstAddTail(root, "v"));

        assertThrows(IllegalArgumentException.class, ()-> BSTNodeUtil.bstAddTail(null, "j"));
    }


    @Test
    public void bstAddTest(){
        BTNode<String> root = createExampleBstWithAdd();
        verifyBst(root);
        
        BSTNodeUtil.bstAdd(root, "q");
        BSTNodeUtil.bstAdd(root, "t");
        BSTNodeUtil.bstAdd(root, "j");
        BSTNodeUtil.bstAdd(root, "v");

        assertEquals(2, root.getNodeCount());
        assertEquals(2, root.getRight().getLeft().getNodeCount());
        assertEquals(2, root.getLeft().getRight().getLeft().getNodeCount());
        assertEquals(2, root.getRight().getLeft().getRight().getLeft().getRight().getNodeCount());



    }


    //currently relies on bstAddTail
    @Test
    public void bstContainsTest(){
        BTNode<String> root = createExampleBstWithAddTail();
        for (String itemExpectedPresent : new String[] {"b", "e", "f", "h", "j", "m", "o", "q", "t", "u", "v", "x", "y"}){
            assertTrue(BSTNodeUtil.bstContains(root, itemExpectedPresent));
        }
        for (String itemExpectedMissing : new String[] {"c", "k", "d", "p", "n", "l"}){
            assertFalse(BSTNodeUtil.bstContains(root, itemExpectedMissing));
        }

        root = root.getRight();
        for (String itemExpectedPresent : new String[] {"t", "u", "v", "x", "y"}){
            assertTrue(BSTNodeUtil.bstContains(root, itemExpectedPresent));
        }
        for (String itemExpectedMissing : new String[] {"b", "e", "f", "h", "j", "m", "o", "q", "c", "k", "d", "p", "n", "l"}){
            assertFalse(BSTNodeUtil.bstContains(root, itemExpectedMissing));
        }

        assertTrue(BSTNodeUtil.bstContains(new BTNode<String>("l"), "l"));
        assertFalse(BSTNodeUtil.bstContains(new BTNode<String>("e"), "d"));
        assertFalse(BSTNodeUtil.bstContains(null, "f"));
    }

}
