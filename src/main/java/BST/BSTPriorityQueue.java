package BST;

import java.util.NoSuchElementException;

public class BSTPriorityQueue<T> implements PriorityQueue <T> {

    private BTNode<PriorityObject<T>> root;

    public BSTPriorityQueue(){
        root = null;
    }


    /**
     * puts an item into the priorityQueue with the given priority
     */
    public void offer(T item, int priority){
        // if node is empty
        PriorityObject<T> object = new PriorityObject<T>(item, priority);
        root = BSTNodeUtil.bstAdd(root,object);

    }


    /**
     * removes the "most important" item (the lowest priority number, think "priority number 1")
     * If items have equal priority, any of those items may be returned
     * @return the item removed
     * @throws NoSuchElement exception if the queue is empty
     */
    public T poll(){
        if(root == null){
            throw new NoSuchElementException("Root is null");
        }
        T priorityObject = BSTNodeUtil.bstFindMin(root).getItem();
        root = BSTNodeUtil.bstRemoveMin(root);
        return priorityObject;
    }


    /**
     * @return true if the queue has no items, false otherwise
     */
    public boolean isEmpty(){
        PriorityObject<T> item = BSTNodeUtil.bstFindMin(root);
        if (item != null){
            return false;
        }
        else{
            return true;
        }
    }


    /**
     * all items are removed, after calling this PriorityQueue is empty
     */
    public void makeEmpty(){
        root = null;
    }
}
