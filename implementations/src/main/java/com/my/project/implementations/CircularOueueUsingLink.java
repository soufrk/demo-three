package com.my.project.implementations;

/**
 * 2nd attempt at implementing circular-queue post success
 * with array & array-list.
 * 
 * 
 * @author soufrk
 *
 */
public class CircularOueueUsingLink {
    
    private static Node HEAD, TAIL;
    private static int CURRENT_SIZE, MAX_SIZE;
    
    CircularOueueUsingLink(){
	HEAD = null;
	TAIL = null;
    }
    
    CircularOueueUsingLink(int size){
	this();
	MAX_SIZE = size;
	CURRENT_SIZE = 0;
    }

    /**
     * First enqueue operation.
     */
    public static void main1(String[] args) {
	CircularOueueUsingLink newInstance = new CircularOueueUsingLink(2);
	newInstance.enqueue(10);
    }
    
    /**
     * Print queue post first enqueue operation.
     * Outcome - Does not print anything
     * Resolution 
     * - 1) Check enqueue method - reworked enqueue, toString methods
     * 
     * And, it works !!!
     */
    public static void main2(String[] args) {
	CircularOueueUsingLink newInstance = new CircularOueueUsingLink(2);
	newInstance.enqueue(10);
	System.out.println(newInstance);
    }
    
    public int getLast() {
	return TAIL.value;
    }
    
    public int getFirst() {
	return HEAD.value;
    }

    public void enqueue(int i) {
	System.out.println("Trying to enqueue.");
	Node n = new Node();
	n.setValue(i);
	n.setNext(null);
	System.out.println("Created a new node.");
	if(this.isEmpty()){
	    System.out.println("Q was empty");
	    HEAD = n;
	    TAIL = n;
	    CURRENT_SIZE++;
	    System.out.println("Added node:" + n.value);
	} else if(this.isFull()) {
	   System.out.println("Queue is full !!");
	} else {
	    System.out.println("Q has space");
	    TAIL.next = n;
	    TAIL = n;
	    CURRENT_SIZE++;
	}
	
    }

    private boolean isFull() {
	return CURRENT_SIZE==MAX_SIZE;
    }

    private boolean isEmpty() {
	return CURRENT_SIZE == 0;
    }

    public static class Node{
	int value;
	Node next;
	
	public void setValue(int value) {
	    this.value = value;
	}

	public void setNext(Node next) {
	    this.next = next;
	}
    }
    
    @Override
    public String toString() {
        StringBuilder formatter = new StringBuilder();
        Node pointer = HEAD;
        if(CURRENT_SIZE == 0)
            formatter.append("Q is empty !!!");
        else {
            formatter.append("HEAD->" + pointer.value);
            while(pointer != TAIL){
        	pointer = pointer.next;
        	formatter.append(" ->" + pointer.value);
            }
        }
        return formatter.toString();
    }

}
