package bst;

import interface;

import java.util.NoSuchElementException;

public class BSTLyricDatabase<T> implements LyricDatabase <T> {

    private BTNode<String> root;

    public BSTLyricDatabase(){
        root = null;
    }


    /**
     * puts an item into the priorityQueue with the given priority
     */
    public void add(T item){
        // if node is empty
        root = BSTNodeUtil.bstAdd(root, item);
    }

    /*
     * returns true or false if item in data structure
     */
    public boolean contains(T item){
        return BSTNodeUtil.bstContains(root, item);
    }

    /*
     * returns the count of a specific word
     */
    public int getCount(T item){
        return BSTNodeUtil.BSTGetCount(root, item);
    }

    /*
     * returns total number of items
     */
    public int getNumItems(){
        return BTNodeUtil.nodeCount(root);
    }
}
