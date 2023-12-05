import bst.BTNode;

public class SampleTrees {
    public static BTNode<String> getTree1(){
        BTNode<String> root = new BTNode<String>("d");
       
        root.setLeft(new BTNode<String>("b"));
        root.getLeft().setLeft(new BTNode<String>("a"));
        root.getLeft().setRight(new BTNode<String>("c"));

        root.setRight(new BTNode<String>("f"));
        root.getRight().setLeft(new BTNode<String>("e"));
        root.getRight().setRight(new BTNode<String>("h"));

        return root;
        
    }

    public static BTNode<String> getTree2(){
        BTNode<String> root = new BTNode<String>("a");
       
        root.setLeft(new BTNode<String>("b"));
        root.getLeft().setLeft(new BTNode<String>("c"));
        root.getLeft().setRight(new BTNode<String>("d"));

        root.setRight(new BTNode<String>("e"));
        root.getRight().setLeft(new BTNode<String>("f"));
        root.getRight().setRight(new BTNode<String>("g"));
        return root;
        
    }

    public static BTNode<String> getTree3(){
        BTNode<String> root = new BTNode<String>("g");
       
        root.setLeft(new BTNode<String>("c"));
        root.getLeft().setLeft(new BTNode<String>("a"));
        root.getLeft().setRight(new BTNode<String>("b"));

        root.setRight(new BTNode<String>("f"));
        root.getRight().setLeft(new BTNode<String>("d"));
        root.getRight().setRight(new BTNode<String>("e"));
        return root;
    }

    public static BTNode<String> getTree4(){
        BTNode<String> root = new BTNode<String>("n");
       
        root.setLeft(new BTNode<String>("k"));
        root.getLeft().setLeft(new BTNode<String>("e"));
        root.getLeft().getLeft().setLeft(new BTNode<String>("b"));
        root.getLeft().getLeft().setRight(new BTNode<String>("h"));

        root.setRight(new BTNode<String>("x"));
        root.getRight().setLeft(new BTNode<String>("p"));
        root.getRight().getLeft().setRight(new BTNode<String>("u"));
        root.getRight().getLeft().getRight().setLeft(new BTNode<String>("r"));
        return root;
    }
}
