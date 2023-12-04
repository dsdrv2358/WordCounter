

// import org.w3c.dom.Node;

public class BSTNodeUtil {


    /**
     * @pre root must be a node of a valid binary search tree
     * @pre the BST from root must not already contain item 
     * @post BST from root will be mutatated to contain a new node with the given item
     * @throws IllegalArgumentException if root is null or the BST already contains item
     */
    public static <T extends Comparable<T>> void bstAddTail(BTNode<T> root, T item){
        //TODO
        if (root == null){
            throw new IllegalArgumentException("Node is null");
        }

        int num = item.compareTo(root.getItem());

        if (num == 0){
            throw new IllegalArgumentException("BST already has item");
        }
        else{
            if(num < 0){
                if (root.getLeft() != null){
                    bstAddTail(root.getLeft(), item);
                }
                else{
                    BTNode<T> node = new BTNode<T>(item);
                    root.setLeft(node);
                }
            }
            else{
                if (root.getRight() != null){
                    bstAddTail(root.getRight(), item);
                }
                else{
                    BTNode<T> node = new BTNode<T>(item);
                    root.setRight(node);
                }
            }
        }
    }


    /**
     * @pre root must be a node of a valid binary search tree, or null
     * @pre the bst from root must not already contain item 
     * @return  the root of a BST which contains a new node the given item
     * @post original BST might be modified to contain a new node with the given item
     * @throws IllegalArgumentException if the bst already contains item
     */
    public static <T extends Comparable<T>> BTNode<T> bstAdd(BTNode<T> root, T item){
        //TODO
        // int tht represents if recursion should go left and right
        if (root == null) {
            return new BTNode<T>(item);
        }
        int num = item.compareTo(root.getItem());

        if (num == 0){
            // throw new IllegalArgumentException("BST already has item");
            root.addItem(item);
        }
        else{
            if(num < 0){
                if (root.getLeft() != null){
                    bstAdd(root.getLeft(), item);
                }
                else{
                    BTNode<T> node = new BTNode<T>(item);
                    root.setLeft(node);
                }
            }
            else{
                if (root.getRight() != null){
                    bstAdd(root.getRight(), item);
                }
                else{
                    BTNode<T> node = new BTNode<T>(item);
                    root.setRight(node);
                }
            }
        }
        return root;
    }


    /**
     * @pre root must be a node of a valid binary search tree, or null
     * @return true if the item is found in the bst, false otherwise 
     */
    public static <T extends Comparable<T>> boolean bstContains(BTNode<T> root, T item){
        //TODO
        if (root == null) {
            return false;
        }
        int num = item.compareTo(root.getItem());
        if (num == 0){
            return true;
        }
        else{
            if(num < 0){
                return bstContains(root.getLeft(), item);
            }
            else{
                return bstContains(root.getRight(), item);
            }
        }
    }


        /**
     * @pre root must be a node of a valid binary search tree, or null 
     * @return  the minimum item from the BST, or null if there are no items
     */
    public static <T extends Comparable<T>> T bstFindMin(BTNode<T> root){
        // throw new RuntimeException("Not implemented");
        if (root == null){
            return null;
        }
        if (root.getLeft() == null){
            return root.getItem();
        }
        else {
            return bstFindMin(root.getLeft());
        }
    }


    /**
    * @pre root must be a node of a valid binary search tree, or null 
    * @return  the root of a BST with the minimum removed, or null if empty
    * @post original BST might be modified to have the minimum removed
    */
    public static <T extends Comparable<T>> BTNode<T> bstRemoveMin(BTNode<T> root){
        // throw new RuntimeException("Not implemented");
        if (root == null){
            return null;
        }
        if (root.getLeft() == null){
            if (root.getNodeCount() > 1){
                root.removeItem();
                return root;
            }
            else{
                return root.getRight();
            }
        }
        else {

            BTNode<T> newLeftSubTree = bstRemoveMin(root.getLeft());
            root.setLeft(newLeftSubTree);
            return root;
        }


        // if (root.getLeft().getLeft() == null){
        //     if (root.getLeft().getNodeCount() > 1){
        //         root.removeItem();
        //         return root;
        //     }
        //     if (root.getLeft().getRight() != null){
        //         BTNode<T> node = root.getLeft().getRight();
        //         root.setLeft(node);
        //         return root;
        //     }
        //     else{
        //         root.setLeft(null);
        //         return root;
        //     }
        // }
        // else{
        //     return bstRemoveMin(root.getLeft());
        // }
    }

    /**
    * @pre root must be a node of a valid binary search tree, or null 
    * @return  the root of a BST with the minimum removed, or null if empty
    * @post original BST might be modified to have the minimum removed
    */
    public static <T extends Comparable<T>> BTNode<T> bstRemove(BTNode<T> root, T item){
        // if inittal root is null return null
        if (root == null){
            return null;
        }
        int num = item.compareTo(root.getItem());
        // if intal root is equivlent to the item to be removed
        if (num == 0){
            BTNode <T> newRoot = root.getLeft();
            root = root.getRight();
            while (root.getLeft() != null){
                root.getLeft();
            }
            root.setLeft(newRoot);
            return root;

        }
        // if item to remove is less than item in node
        if (num < 0){
            if (item.compareTo(root.getLeft().getItem()) == 0){
                if (root.getLeft().getLeft() == null && root.getLeft().getRight() == null){
                    root.setLeft(null);
                    return root;
                }
                if (root.getLeft().getLeft() != null && root.getLeft().getRight() == null){
                    root.setLeft(root.getLeft().getLeft());
                    return root;
                }
                if (root.getLeft().getLeft() == null && root.getLeft().getRight() != null){
                    root.setLeft(root.getLeft().getRight());
                    return root;
                }
                else{
                    BTNode <T> newRoot = root.getLeft().getLeft();
                    root.setLeft(root.getLeft().getRight());
                    while (BTNodeUtil.nodeCount(newRoot) > 0){
                        BSTNodeUtil.bstAdd(root, BSTNodeUtil.bstFindMin(newRoot));
                        BSTNodeUtil.bstRemoveMin(newRoot);
                    }
                    return root;
                }
            }
            else{
                return bstRemove(root.getLeft(), item);
            }
        // if item to remove is greater then node item
        }
        if (num > 0){
            if (item.compareTo(root.getRight().getItem()) == 0){
                if (root.getRight().getLeft() == null && root.getRight().getRight() == null){
                    root.setRight(null);
                    return root;
                }
                if (root.getRight().getLeft() != null && root.getRight().getRight() == null){
                    root.setRight(root.getRight().getLeft());
                    return root;
                }
                if (root.getRight().getLeft() == null && root.getRight().getRight() != null){
                    root.setRight(root.getRight().getRight());
                    return root;
                }
                else{
                    BTNode <T> newRoot = root.getRight().getLeft();
                    root.setLeft(root.getRight().getRight());
                    while (BTNodeUtil.nodeCount(newRoot) > 0){
                        BSTNodeUtil.bstAdd(root, BSTNodeUtil.bstFindMin(newRoot));
                        BSTNodeUtil.bstRemoveMin(newRoot);
                    }
                    return root;
                }
            }
            else{
                return bstRemove(root.getRight(), item);
            }
        }
        return root;
    }
}
