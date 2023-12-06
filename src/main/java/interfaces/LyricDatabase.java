package interfaces;

public interface LyricDatabase<T> {

    /**
     * puts item into datastructure 
     */
    void add(String item);


    /**
     * @param filename
     * @post populates the data structure with the words in the file
     */
    void populateDatabase(String filename);

    /**
     * @param item
     * @return Boolean depending on if item entered is in data structure
     */
    boolean contains(String item);

    /**
     * @param item
     * @return number of times an item is used in the data structure
     */
    int getCount(String item);

    /*
     * @return the total number of unique item in the data structure
     */
    int getNumItems();
    


}
