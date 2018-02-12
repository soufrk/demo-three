package com.my.project.implementations.datastructures;

import java.util.Formatter;

/**
 * Just like the previous one,
 * Let's begin by addressing the shortcoming's that 
 * the earlier implementation is having.
 * 
 * Full queue - prevents further addition of elements.
 * 
 * @author soufrk
 *
 */
public class CircularQTake3 {
    
    /**
     * Let's test the problem#1.
     * @param args
     */
    public static void main1(String[] args) {
	CircularQTake3 queue = new CircularQTake3(2);
	queue.insert(10);
	queue.insert(20);
	queue.insert(30);
    }
    
    /**
     * Tesing problem#2.
     * @param args
     */
    public static void main2(String[] args) {
	CircularQTake3 queue = new CircularQTake3(2);
	queue.insert(10);
	System.out.println(queue);
	queue.insert(20);
	System.out.println(queue);
    }
    
    /**
     * Analyzing no break in existing functionality.
     * @param args
     */
    public static void main3(String[] args) {
	CircularQTake3 queue = new CircularQTake3(2);
	System.out.println(queue);
	
	queue.insert(10);
	System.out.println(queue);
	System.out.println(queue.getFirst());
	System.out.println(queue.getLast());
	
	queue.insert(20);
	System.out.println(queue);
	System.out.println(queue.getFirst());
	System.out.println(queue.getLast());
    }
    
    /**
     * Verifying newly added functionality.
     * @param args
     */
    public static void main4(String[] args) {
	CircularQTake3 queue = new CircularQTake3(2);
	queue.insert(10);
	System.out.println(queue);
	System.out.println(queue.getCurrentSize());
	System.out.println(queue.getSize());
	
	queue.insert(20);
	System.out.println(queue);
	System.out.println(queue.getCurrentSize());
	System.out.println(queue.getSize());
    }
    
    /**
     * Let's try to break the design.
     * @param args
     */
    public static void main6(String[] args) {
	CircularQTake3 queue = new CircularQTake3(2);
	System.out.println(queue);
	System.out.println(queue.getFirst());
	System.out.println(queue.getLast());
	System.out.println(queue.getCurrentSize());
	System.out.println(queue.getSize());
    }
    
    /**
     * Sanity of new added methods.
     * @param args
     */
    public static void main(String[] args) {
	CircularQTake3 queue = new CircularQTake3(2);
	System.out.println(queue);
	System.out.println(queue.getCurrentSize());
	System.out.println(queue.getSize());
    }
    
    private static Node HEAD, REAR;
    // We need another variable to maintain the current-size.
    private static int SIZE, CURRENT_SIZE;
    
    public CircularQTake3(){
	HEAD = null;
	REAR = null;
    }
    
    public CircularQTake3(int size){
	this();
	SIZE = size;
	CURRENT_SIZE = 0;
    }
    
    public int getLast() {
	return REAR.value;
    }
    
    public int getFirst() {
	return HEAD.value;
    }
    
    public int getSize(){
	return SIZE;
    }
    
    public int getCurrentSize(){
	return CURRENT_SIZE;
    }
    
    public void insert(int i) {
	Node n = new Node();
	n.setValue(i);
	n.setNext(null);
	// Again, the logic changes over here.
	if(CURRENT_SIZE < SIZE){
	    if(HEAD == null){
		HEAD = n;
		REAR = n;
	    } else {
		REAR.next = n;
		REAR = n;
	    }
	    CURRENT_SIZE++;
	} else {
	    System.out.println("The queue is full !!");
	}
	
    }
    
    // Notice, we make this class private to comply with
    // encapsulation principle.
    private static class Node{
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
        Formatter formatter = new Formatter();
        Node pointer = HEAD;
        // This clause prevents display of first element.
        /*if(HEAD == REAR)
            formatter.format("%s", "Empty");*/
        // This is a better way to check empty condition.
        if(HEAD == null)
            formatter.format("%s", "Empty");
        else {
            formatter.format("%s -> %s", "HEAD", pointer.value);
            while(pointer != REAR){
        	pointer = pointer.next;
        	formatter.format(" -> %s", pointer.value);
            }
        }
        return formatter.toString();
    }

}
/*
 * The earlier problems have been resolved. Features added,
 * 1.) getSize(), returns the total size, and
 * 2.) getCurrentSize(), returns the current size of the queue.
 * 
 * But, we have new problems with this implementation.
 * 1.) getFirst(), fails on empty queue.
 * 
 * Spend some time to analyze what might be going wrong.
 * 
 * HINT: Does the insert() method take care of the size ?
 */
