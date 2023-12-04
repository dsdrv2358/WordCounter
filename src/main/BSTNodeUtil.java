package edu.ithaca.dragon.datastructures.tree;

public class BSTNodeUtil {

    /**
     * @pre root must be a node of a valid binary search tree
     * @pre the BST from root must not already contain item 
     * @post BST from root will be mutatated to contain a new node with the given item
     * @throws IllegalArgumentException if root is null or the BST already contains item
     */
    public static <T extends Comparable<T>> void bstAddTail(BTNode<T> root, T item){
        if (root==null){
            throw new IllegalArgumentException("Root is null");
        }
        else{
            if(root.getItem().compareTo(item)==0){
                throw new IllegalArgumentException("Item already exists");
            }
        }

            if(root.getItem().compareTo(item)<0){
                // if (root.getRight()==null){
                //     root.setRight(new BTNode<T>(item));
                 }
                else{
                    bstAddTail(root.getRight(),item);
                }
            if(root.getItem().compareTo(item)>0){
                if (root.getLeft()==null){
                    root.setLeft(new BTNode<T>(item));
                }
                else{
                    bstAddTail(root.getLeft(),item);
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
        if (root == null){
            return new BTNode<T>(item);
        }
        else{
            // if(root.getItem().compareTo(item)==0){
            //     throw new IllegalArgumentException("Item already exists");
            // }
            // if(root.getItem().compareTo(item)<0){
            //     root.setRight(bstAdd(root.getRight(), item));
            // }
            // if(root.getItem().compareTo(item)>0){
            //     root.setLeft(bstAdd(root.getLeft(), item));
            // }
            bstAddTail(root, item);
        return root;
        }
    }

    /**
     * @pre root must be a node of a valid binary search tree, or null
     * @return true if the item is found in the bst, false otherwise 
     */
    public static <T extends Comparable<T>> boolean bstContains(BTNode<T> root, T item){
        if (root==null){
            return false;
        }
        else{
            if (root.getItem().equals(item)){
                //Why does == fail on line 42
                return true;
            }
            else{
                boolean isItTrue=false;
                if(root.getItem().compareTo(item)<0){
                    isItTrue = bstContains(root.getRight(),item);
                }
                if(root.getItem().compareTo(item)>0){
                    isItTrue = bstContains(root.getLeft(),item);
                }
                return isItTrue;
                }
            }
        }
        /**
     * @pre root must be a node of a valid binary search tree, or null 
     * @return  the minimum item from the BST, or null if there are no items
     */
    public static <T extends Comparable<T>> T bstFindMin(BTNode<T> root){
        if (root ==null){
            return null;
        }
        else{
            if (root.getLeft()==null){
                return root.getItem();
            }
            else{
                return bstFindMin(root.getLeft());
            }
        }
    }

    /**
    * @pre root must be a node of a valid binary search tree, or null 
    * @return  the root of a BST with the minimum removed, or null if empty
    * @post original BST might be modified to have the minimum removed
    */
    public static <T extends Comparable<T>> BTNode<T> bstRemoveMin(BTNode<T> root){
        // if (root ==null){
        //     return null;
        // }
        // if (root.getLeft() ==null){
        //     if (root.getRight()==null){
        //         return null;
        //     }
        //     else{
        //     return root.getRight();
        //     }
        // }
        // else{
        //     if (root.getLeft().getLeft()==null){
        //         if (root.getLeft().getRight()== null){
        //             root.setLeft(null);
        //         }
        //         else{
        //             root.setLeft(root.getLeft().getRight());
        //         }
        //         return root;
        //     }
        //     else{
        //         bstRemoveMin(root.getLeft());
        //         return root;
        //     }
        // }
        if (root ==null){
            return null;
        }
        else if (root.getLeft()==null){
            return root.getRight();
        }
        else{
            root.setLeft(bstRemoveMin(root.getLeft()));
            return root;
        }
    }
    public static <T extends Comparable<T>> T bstFind(BTNode<T> root, T itemToFind){
            if (root==null){
                return null;
            }
            else{
                if (root.getItem().compareTo(itemToFind)<0){
                    return bstFind(root.getRight(), itemToFind);
                }
                if (root.getItem().compareTo(itemToFind)>0){
                    return bstFind(root.getLeft(), itemToFind);
                }
            }
            return root.getItem();
    }
}

