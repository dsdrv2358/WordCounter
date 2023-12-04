

public class SampleTrees {
    public static BTNode<Integer> getTree1(){
        BTNode<Integer> root = new BTNode<Integer>(4);
       
        root.setLeft(new BTNode<Integer>(2));
        root.getLeft().setLeft(new BTNode<Integer>(1));
        root.getLeft().setRight(new BTNode<Integer>(3));

        root.setRight(new BTNode<Integer>(6));
        root.getRight().setLeft(new BTNode<Integer>(5));
        root.getRight().setRight(new BTNode<Integer>(7));

        return root;
        
    }

    public static BTNode<Integer> getTree2(){
        BTNode<Integer> root = new BTNode<Integer>(1);
       
        root.setLeft(new BTNode<Integer>(2));
        root.getLeft().setLeft(new BTNode<Integer>(3));
        root.getLeft().setRight(new BTNode<Integer>(4));

        root.setRight(new BTNode<Integer>(5));
        root.getRight().setLeft(new BTNode<Integer>(6));
        root.getRight().setRight(new BTNode<Integer>(7));
        return root;
        
    }

    public static BTNode<Integer> getTree3(){
        BTNode<Integer> root = new BTNode<Integer>(7);
       
        root.setLeft(new BTNode<Integer>(3));
        root.getLeft().setLeft(new BTNode<Integer>(1));
        root.getLeft().setRight(new BTNode<Integer>(2));

        root.setRight(new BTNode<Integer>(6));
        root.getRight().setLeft(new BTNode<Integer>(4));
        root.getRight().setRight(new BTNode<Integer>(5));
        return root;
    }

    public static BTNode<Integer> getTree4(){
        BTNode<Integer> root = new BTNode<Integer>(100);
       
        root.setLeft(new BTNode<Integer>(22));
        root.getLeft().setLeft(new BTNode<Integer>(5));
        root.getLeft().getLeft().setLeft(new BTNode<Integer>(1));
        root.getLeft().getLeft().setRight(new BTNode<Integer>(17));

        root.setRight(new BTNode<Integer>(132));
        root.getRight().setLeft(new BTNode<Integer>(105));
        root.getRight().getLeft().setRight(new BTNode<Integer>(122));
        root.getRight().getLeft().getRight().setLeft(new BTNode<Integer>(112));
        return root;
    }
}
