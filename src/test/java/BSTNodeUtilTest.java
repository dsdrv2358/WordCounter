

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BSTNodeUtilTest {
    public BTNode<Integer> createExampleBstWithAddTail(){
        //need to create root node to start
        BTNode<Integer> root = new BTNode<Integer>(100);

        BSTNodeUtil.bstAddTail(root, 50);
        BSTNodeUtil.bstAddTail(root, 75);
        BSTNodeUtil.bstAddTail(root, 25);
        BSTNodeUtil.bstAddTail(root, 35);
        BSTNodeUtil.bstAddTail(root, 65);
        BSTNodeUtil.bstAddTail(root, 90);
        BSTNodeUtil.bstAddTail(root, 10);

        BSTNodeUtil.bstAddTail(root, 200);
        BSTNodeUtil.bstAddTail(root, 150);
        BSTNodeUtil.bstAddTail(root, 175);
        BSTNodeUtil.bstAddTail(root, 172);
        BSTNodeUtil.bstAddTail(root, 174);
        return root;
    }


    public BTNode<Integer> createExampleBstWithAdd(){
        //start with null
        BTNode<Integer> root = null;
        
        root = BSTNodeUtil.bstAdd(root, 100);
        root = BSTNodeUtil.bstAdd(root, 50);
        root = BSTNodeUtil.bstAdd(root, 75);
        root = BSTNodeUtil.bstAdd(root, 25);
        root = BSTNodeUtil.bstAdd(root, 35);
        root = BSTNodeUtil.bstAdd(root, 65);
        root = BSTNodeUtil.bstAdd(root, 90);
        root = BSTNodeUtil.bstAdd(root, 10);

        root = BSTNodeUtil.bstAdd(root, 200);
        root = BSTNodeUtil.bstAdd(root, 150);
        root = BSTNodeUtil.bstAdd(root, 175);
        root = BSTNodeUtil.bstAdd(root, 172);
        root = BSTNodeUtil.bstAdd(root, 174);
        return root;
    }


    //relies on BTNodeUtil.height working
    public void verifyBst(BTNode<Integer> root){
        assertEquals(5, BTNodeUtil.height(root));
        assertEquals(2, BTNodeUtil.height(root.getLeft()));
        assertEquals(4, BTNodeUtil.height(root.getRight()));
        assertEquals(1, BTNodeUtil.height(root.getLeft().getRight()));

        assertEquals(75, root.getLeft().getRight().getItem().intValue());
        assertEquals(175, root.getRight().getLeft().getRight().getItem().intValue());

        assertNull(root.getRight().getLeft().getRight().getLeft().getRight().getLeft());
        assertNull(root.getRight().getLeft().getRight().getLeft().getRight().getRight());
        assertNull(root.getLeft().getRight().getRight().getLeft());
        assertNull(root.getLeft().getRight().getRight().getRight());
    }


    @Test
    public void bstAddTailTest(){
        final BTNode<Integer> root = createExampleBstWithAddTail();
        verifyBst(root);

        assertThrows(IllegalArgumentException.class, ()-> BSTNodeUtil.bstAddTail(root, 100));
        assertThrows(IllegalArgumentException.class, ()-> BSTNodeUtil.bstAddTail(root, 150));
        assertThrows(IllegalArgumentException.class, ()-> BSTNodeUtil.bstAddTail(root, 65));
        assertThrows(IllegalArgumentException.class, ()-> BSTNodeUtil.bstAddTail(root, 174));

        assertThrows(IllegalArgumentException.class, ()-> BSTNodeUtil.bstAddTail(null, 101));
    }


    @Test
    public void bstAddTest(){
        BTNode<Integer> root = createExampleBstWithAdd();
        verifyBst(root);
        
        assertThrows(IllegalArgumentException.class, ()-> BSTNodeUtil.bstAdd(root, 100));
        assertThrows(IllegalArgumentException.class, ()-> BSTNodeUtil.bstAdd(root, 150));
        assertThrows(IllegalArgumentException.class, ()-> BSTNodeUtil.bstAdd(root, 65));
        assertThrows(IllegalArgumentException.class, ()-> BSTNodeUtil.bstAdd(root, 174));
    }


    //currently relies on bstAddTail
    @Test
    public void bstContainsTest(){
        BTNode<Integer> root = createExampleBstWithAddTail();
        for (int itemExpectedPresent : new int[] {10, 25, 35, 50, 65, 75, 90, 100, 150, 172, 174, 175, 200}){
            assertTrue(BSTNodeUtil.bstContains(root, itemExpectedPresent));
        }
        for (int itemExpectedMissing : new int[] {1, 55, 99, 205, 2000, 173}){
            assertFalse(BSTNodeUtil.bstContains(root, itemExpectedMissing));
        }

        root = root.getRight();
        for (int itemExpectedPresent : new int[] {150, 172, 174, 175, 200}){
            assertTrue(BSTNodeUtil.bstContains(root, itemExpectedPresent));
        }
        for (int itemExpectedMissing : new int[] {10, 25, 35, 50, 65, 75, 90, 100, 1, 55, 99, 205, 2000, 173}){
            assertFalse(BSTNodeUtil.bstContains(root, itemExpectedMissing));
        }

        assertTrue(BSTNodeUtil.bstContains(new BTNode<Integer>(22), 22));
        assertFalse(BSTNodeUtil.bstContains(new BTNode<Integer>(101), 100));
        assertFalse(BSTNodeUtil.bstContains(null, 100));
    }

    @Test
    public void bstFndMinTest(){
        BTNode<Integer> root = createExampleBstWithAddTail();
        assertEquals(root.getLeft().getLeft().getLeft().getItem(), BSTNodeUtil.bstFindMin(root)); 
        assertEquals(root.getRight().getLeft().getItem(), BSTNodeUtil.bstFindMin(root.getRight()));
        assertEquals(null, BSTNodeUtil.bstFindMin(null));
    }


    @Test
    public void bstRemoveMinTest(){
        BTNode<Integer> root = createExampleBstWithAddTail();
        assertEquals(root.getLeft().getLeft().getItem(), BSTNodeUtil.bstRemoveMin(root).getItem()); 
        root = createExampleBstWithAddTail();
        assertEquals(null, BSTNodeUtil.bstRemoveMin(root).getLeft());
        root = createExampleBstWithAddTail();
        assertEquals(root.getRight().getItem(), BSTNodeUtil.bstRemoveMin(root.getRight()).getItem()); 
        assertEquals(null, BSTNodeUtil.bstFindMin(null));
    }

    @Test
    public void bstRemoveTest(){
        BTNode<Integer> root = createExampleBstWithAdd();
        verifyBst(root);
        BSTNodeUtil.bstRemove(root,35);
        assertFalse(BSTNodeUtil.bstContains(root, 35));
        root = createExampleBstWithAdd();
        verifyBst(root);
        BSTNodeUtil.bstRemove(root,75);
        assertFalse(BSTNodeUtil.bstContains(root, 75));
        root = createExampleBstWithAdd();
        verifyBst(root);
        BSTNodeUtil.bstRemove(root,100);
        assertFalse(BSTNodeUtil.bstContains(root, 100));
    }
}
