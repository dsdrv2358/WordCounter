package bst;

public class BTNodeUtil{

    public static <T extends Comparable<T>> int nodeCount(BTNode<T> root){
        if(root == null){
            return 0;
        }
       else{
            int num1 = nodeCount(root.getLeft());
            int num2 = nodeCount(root.getRight());
            return (num1 + num2 + root.getNodeCount());
        }
    }

    public static <T extends Comparable<T>> boolean contains(BTNode<T> root, String item){
        int keyToFind = BTNode.hash(item);
        if (root == null){
            return false;
        }
        if (root.getKey() == keyToFind){
            return true;
        }
        else{
            boolean ans1 = contains(root.getLeft(), item);
            boolean ans2 = contains(root.getRight(), item);
            if(ans1 == true || ans2 == true){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public static <T extends Comparable<T>> String preOrderString(BTNode<T> root){
        if (root == null){
            return "";
        }
        else {
            return root.getItem().toString() + ", " + preOrderString(root.getLeft()) + preOrderString(root.getRight()); 
        }
    }

    public static <T extends Comparable<T>> String inOrderString(BTNode<T> root){
        if (root == null){
            return "";
        }
        else{
            return inOrderString(root.getLeft())  + root.getItem().toString() + ", " + inOrderString(root.getRight()); 
        }
    }

    public static <T extends Comparable<T>> String postOrderString(BTNode<T> root){
        if (root == null){
            return "";
        }
        else{
            return postOrderString(root.getLeft()) + postOrderString(root.getRight()) + root.getItem().toString() + ", "; 
        }
    }

    public static <T extends Comparable<T>> int height(BTNode<T> root){
        if (root == null){
            return -1;
        }
        else{
            int ans1 = height(root.getLeft())+1;
            int ans2 = height(root.getRight())+1;
            if(ans1 >= ans2){
                return ans1;
            }
            else{
                return ans2;
            }
        }
    }    
}