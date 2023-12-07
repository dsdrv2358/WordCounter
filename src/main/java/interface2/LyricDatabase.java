

public interface LyricDatabase<T> {

    /**
     * puts item into datastructure 
     */
    void add(T item);

    /**
     * @param item
     * @return Boolean depending on if item entered is in data structure
     */
    boolean contains(T item);

    /**
     * @param item
     * @return number of times an item is used in the data structure
     */
    int getCount(T item);

    /*
     * @return the total number of unique item in the data structure
     */
    int getNumItems();
    


}
