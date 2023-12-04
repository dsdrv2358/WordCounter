public class BTNode<T extends Comparable<T>> {

    private T item;
    private BTNode<T> left;
    private BTNode<T> right;

    public BTNode(T item){//WHY DOES THIS WORK WHEN THE ITEM IS PRIORITIZEDITEM TYPE AND NOT T
        this.item = item;
        this.left = null;
        this.right = null;
    }

    public T getItem(){
        return item;
    }

    public void setItem(T key) {
		this.item = key;
	}

	public BTNode<T> getLeft() {
		return left;
	}

	public BTNode<T> getRight() {
		return right;
    }

	public void setLeft(BTNode<T> left) {
		this.left = left;
	}

	public void setRight(BTNode<T> right) {
		this.right = right;
	}
    
}
