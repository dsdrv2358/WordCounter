package bst;

import interfaces.LyricDatabase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        this.root = BSTNodeUtil.bstAdd(this.root, item);
    }

    /*
     * returns true or false if item in data structure
     */
    public boolean contains(String item){
        return BSTNodeUtil.bstContains(this.root, item);
    }

    /*
     * returns the count of a specific word
     */
    public int getCount(String item){
        return BSTNodeUtil.BSTGetCount(this.root, item);
    }

    /*
     * returns total number of items
     */
    public int getNumItems(){
        return BTNodeUtil.nodeCount(this.root);
    }


    @Override
    public void populateDatabase(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null && count < 150000) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    count++;
                    if (word.length() > 3){
                       this.add(word);
                    }
                }
            }
        } catch (IOException e) {
        }
    }
}
