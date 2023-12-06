package bst;

public class BSTNodeUtil {


    /**
     * @pre root must be a node of a valid binary search tree
     * @pre the BST from root must not already contain item 
     * @post BST from root will be mutatated to contain a new node with the given item
     * @throws IllegalArgumentException if root is null or the BST already contains item
     */
    public static <T extends Comparable<T>> void bstAddTail(BTNode<T> root, String item){
        //TODO

        // item to find key
        int key = BTNode.hash(item);

        // if node is null throws argument
        if (root == null){
            throw new IllegalArgumentException("Node is null");
        }

        // int num = item.compareTo(root.getItem());

        // if item is in node throw an argument
        if (key == root.getKey()){
            throw new IllegalArgumentException("BST already has item");
        }
        //if item is not in node step in
        else{
            // if item to find key is less than node key
            if(key < root.getKey()){
                if (root.getLeft() != null){
                    bstAddTail(root.getLeft(), item);
                }
                else{
                    BTNode<T> node = new BTNode<T>(item);
                    root.setLeft(node);
                }
            }
            // if item to find key is greater than node key
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
    public static <T extends Comparable<T>> BTNode<T> bstAdd(BTNode<T> root, String item){
        //TODO
        // int tht represents if recursion should go left and right
        if (root == null) {
            return new BTNode<T>(item);
        }
        int num = item.compareTo(root.getItem());

        if (num == 0){
            // throw new IllegalArgumentException("BST already has item");
            root.addCount();
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
    public static <T extends Comparable<T>> boolean bstContains(BTNode<T> root, String item){
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

    /*
     * returns the count of a word if in data structure
     */
    public static <T extends Comparable<T>> int BSTGetCount(BTNode<T> root, String item){
        if (root == null) {
            throw new IllegalArgumentException("BST does not contain item");
        }
        int num = item.compareTo(root.getItem());
        if (num == 0){
            return root.getNodeCount();
        }
        else{
            if(num < 0){
                return BSTGetCount(root.getLeft(), item);
            }
            else{
                return BSTGetCount(root.getRight(), item);
            }
        }
    }


}

