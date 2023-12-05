package BST;

public class BTNode<T extends Comparable<T>> {

    // private T item;
    private String item;
    private int key;
    private int count;
    private BTNode<T> left;
    private BTNode<T> right;

    public BTNode(String item){
        this.item = item;
        this.key = hash(item);
        this.count = 0;
        this.left = null;
        this.right = null;
    }

        //hash function
    public static int hash(String item){
        int hash = 0;
        for (char c : item.toCharArray()) {
            hash = 31 * hash + c;  // A common multiplier (31) is used for better distribution
        }
        return hash;
    }

    public String getItem(){
        return item;
    }

    public void setItem(String item) {
		this.item = item;
	}

    public int getKey(){
        return key;
    }

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
