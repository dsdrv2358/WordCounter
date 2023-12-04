
public class BTNode<T extends Comparable<T>> {

    // private T item;
    private String item = null;
    private int count = 0;
    private BTNode<T> left;
    private BTNode<T> right;

    public BTNode(String item){
        this.item = item;
        this.left = null;
        this.right = null;
    }

    public String getItem(){
        return item;
    }

    // public void setItem(T key) {
	// 	this.item = key;
	// }

    // gets roots left
	public BTNode<T> getLeft() {
		return left;
	}

    // gets roots right
	public BTNode<T> getRight() {
		return right;
    }

    // sets the roots left
	public void setLeft(BTNode<T> left) {
		this.left = left;
	}

    // sets the roots right
	public void setRight(BTNode<T> right) {
		this.right = right;
	}

    // returns number of instances of a priority
    public int getNodeCount(){
        return count;
    }
    
}
