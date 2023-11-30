package a.k.l;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class IntChainedHashSet {

    private WordItem[] myArray; 
    private int size = 0;
    private int numItems = 0;

    /**
     * creates a new IntHashSet with the specified size for the underlying array
     */
    public IntChainedHashSet(int size){
        this.myArray = new CustomNode[size];
        this.size = size;
    } 


    /**
     * @post adds an item to the set
     */
    public void add(int item){
        WordItem newNode = new WordItem(item);
        int hashIndex = hash(item);
        System.out.println(item + " " + hashIndex);
        if (myArray[hashIndex] == null){
            myArray[hashIndex] = newNode;
            numItems++;
        }
        else if (myArray[hashIndex].containsNodeItem(item) == true){
            return;
        }
        else {
            CustomNode newTop = myArray[hashIndex].setTop(newNode);
            myArray[hashIndex] = newTop;
            numItems++;
        }
    }

    /**
     * @return true if the item is in the set, false otherwise
     */
    public boolean contains(int item){
        int hashIndex = hash(item);
        if (myArray[hashIndex] == null){
            return false;
        }
        return(myArray[hashIndex].containsNodeItem(item));
    }

    //---------------------------------------------
    // NOTE: methods below reveal internal details used for our analysis, would not generally be public methods used regularly 

    /**
     * @return a valid index that will be used for a given item in the current array
     */
    public int hash(int item){
        int hashIndex = item % this.size;
        return Math.abs(hashIndex);
    }

    /**
     * @post changes the size of the underlying array, and rehashes and relcoates each item
     */

     /* O(n) */
    public void resize(int newSize){
        CustomNode[] oldArray = this.myArray;
        this.myArray = new CustomNode[newSize];
        this.size = newSize;
        ArrayList<Integer> intList;

        for (int i = 0; i < oldArray.length ; i++){
            if (oldArray[i] != null){
                intList = oldArray[i].getChain();
                for (int m = 0; m < intList.size(); m++){
                    this.add(intList.get(m));
                }
                oldArray[i] = null;
            }
        }
    }


    /**
     * @return length of the longest chain in the hashList
     */
    /*
     * O(n)
     */
    public int longestChain(){
        int longest = 0;
        for (int i = 0; i < this.size; i++){
            if (this.myArray[i] != null){
                int maybeLongest = this.myArray[i].lengthNode();
                if (maybeLongest > longest){
                    longest = maybeLongest;
                }
            }
        }
        return longest;
    }

    /**
     * @return the number of items / the size of the current hash array, or -1 if the array size is 0
     */
    public double loadFactor(){
        if (this.size == 0){
            return -1;
        }
        return (this.numItems / this.size);
    }

    public void printSet() {
        for (int i = 0; i < this.size; i++) {
            System.out.print("Slot " + i + ": ");
            if (this.myArray[i] != null) {
                ArrayList<Integer> chain = this.myArray[i].getChain();
                System.out.println(chain);
            } else {
                System.out.println("Empty");
            }
        }
    }

    
    
}

    
}
