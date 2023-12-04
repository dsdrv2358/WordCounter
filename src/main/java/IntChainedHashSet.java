import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class IntChainedHashSet<T> {

    private WordItem[] myArray;
    private int size = 0;
    private int numItems = 0;

    /**
     * creates a new IntHashSet with the specified size for the underlying array
     */
    public IntChainedHashSet(int size){
        this.myArray = new WordItem[size];
        this.size = size;
    } 


    /**
     * @post adds an item to the set
     */
    public void add(String item){
        WordItem newWord = new WordItem(item);
        int hashIndex = customHash(item);
        if (myArray[hashIndex] == null){
            myArray[hashIndex] = newWord;
            numItems++;
        }
        else if (myArray[hashIndex].getItem().equals(item)){
            myArray[hashIndex].increaseCount();
            return;
        }
        else { 
            WordItem current = myArray[hashIndex];
            while (current.getNext() != null){
                if (current.getItem().equals(item)){
                    current.increaseCount();
                    return;
                }
                current = current.getNext();
            }
            if (current.getItem().equals(item)){
                current.increaseCount();
                return;
            }
            current.setNext(newWord);
            numItems++;
        }
    }

    public int getNumItems(){
        return this.numItems;
    }

    public int getCount(String item){
        int hashIndex = customHash(item);
        if (myArray[hashIndex] == null){
            return 0;
        }
        else if (myArray[hashIndex].getItem().equals(item)){
            return myArray[hashIndex].getCount();
        }
        else { 
            WordItem current = myArray[hashIndex];
            while (current.getNext() != null){
                if (current.getItem().equals(item)){
                    return current.getCount();
                }
                current = current.getNext();
            }
            if (current.getItem().equals(item)){
                return current.getCount();
            }
            return 0;
        }
    }

    /**
     * @return true if the item is in the set, false otherwise
     */
    public boolean contains(String item){
        int hashIndex = customHash(item);
        if (myArray[hashIndex] == null){
            return false;
        }
        else if (myArray[hashIndex].getItem().equals(item)){
            return true;
        }
        else { 
            WordItem current = myArray[hashIndex];
            while (current.getNext() != null){
                if (current.getItem().equals(item)){
                    return true;
                }
                current = current.getNext();
            }
            if (current.getItem().equals(item)){
                return true;
            }
            return false;
        }
    }


    public int hash(String item) {
        return item.hashCode();
    }
    
    public int customHash(String item) {
        int hashValue = hash(item);
        int index = hashValue % this.size;
        return Math.abs(index);
    }

    /**
     * @post changes the size of the underlying array, and rehashes and relcoates each item
     */

     /* O(n) */
    public void resize(int newSize){
        WordItem[] oldArray = this.myArray;
        this.myArray = new WordItem[newSize];
        this.size = newSize;
        ArrayList<String> wordList;

        for (int i = 0; i < oldArray.length ; i++){
            if (oldArray[i] != null){
                wordList = oldArray[i].getChain();
                for (int m = 0; m < wordList.size(); m++){
                    this.add(wordList.get(m));
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
    }*/

    /**
     * @return the number of items / the size of the current hash array, or -1 if the array size is 0
     
    public double loadFactor(){
        if (this.size == 0){
            return -1;
        }
        return (this.numItems / this.size);
    }*/

    public void printSet() {
        for (int i = 0; i < this.size; i++) {
            System.out.print("Slot " + i + ": ");
            if (this.myArray[i] != null) {
                ArrayList<String> chain = this.myArray[i].getChain();
                System.out.println(chain);
            } else {
                System.out.println("Empty");
            }
        }
    }
}
