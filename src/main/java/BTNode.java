package edu.ithaca.dragon.datastructures.tree;

import java.util.LinkedList;

public class BTNode<T extends Comparable<T>> {

    // private T item;
    private LinkedList<T> item_list = new LinkedList<T>();
    private BTNode<T> left;
    private BTNode<T> right;

    public BTNode(T item){
        this.item_list.add(item);
        this.left = null;
        this.right = null;
    }

    public T getItem(){
        return item_list.getFirst();
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
        return item_list.size();
    }

    // removes the next item from nodes item list
    public void removeItem(){
        this.item_list.removeFirst();
    }

    // adds a new item to the BTNodes item list
    public void addItem(T item){
        this.item_list.addLast(item);
    }
    
}
