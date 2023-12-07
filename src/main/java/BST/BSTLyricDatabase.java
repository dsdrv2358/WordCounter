package bst;

import interfaces.LyricDatabase;

import java.util.NoSuchElementException;

public class BSTLyricDatabase<T> implements LyricDatabase <T> {

    private BTNode<String> root;

    public BSTLyricDatabase(){
        root = null;
    }


    /**
     * puts an item into the priorityQueue with the given priority
     */
    public void add(String item){
        // if node is empty
        root = BSTNodeUtil.bstAdd(root, item);
    }

    /*
     * returns true or false if item in data structure
     */
    public boolean contains(String item){
        return BSTNodeUtil.bstContains(root, item);
    }

    /*
     * returns the count of a specific word
     */
    public int getCount(String item){
        return BSTNodeUtil.BSTGetCount(root, item);
    }

    /*
     * returns total number of items
     */
    public int getNumItems(){
        return BTNodeUtil.nodeCount(root);
    }


    @Override
    public void populateDatabase(String filename) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'populateDatabase'");
    }
}
