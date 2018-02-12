package com.my.project.implementations.datastructures;

import java.util.Formatter;

/**
 * The main intention is to check the breakage in previous implementation.
 * 
 * If queue is empty,
 * 1.) getFirst() and getLast() returns -1 and a significant message.
 * 
 * @author soufrk
 *
 */
public class CircularQTake4 {

    /**
     * Check problem targeted to be resolved.
     * @param args
     */
    public static void main1(String[] args) {
	CircularQTake4 queue = new CircularQTake4(2);
	System.out.println(queue.getFirst());
	System.out.println(queue.getLast());
    }
    
    /**
     * Sanity of existing functionality.
     * @param args
     */
    public static void main2(String[] args) {
	CircularQTake4 queue = new CircularQTake4(2);
	System.out.println(queue);
	queue.insert(10);
	System.out.println(queue);
	queue.insert(20);
	System.out.println(queue);
	queue.insert(30);
	System.out.println(queue);
    }
    
    /**
     * Sanity of existing functionality.
     * @param args
     */
    public static void main3(String[] args) {
	CircularQTake4 queue = new CircularQTake4(2);
	System.out.println(queue);
	queue.insert(10);
	System.out.println(queue);
	System.out.println(queue.getFirst());
	System.out.println(queue.getLast());
	queue.insert(20);
	System.out.println(queue);
	System.out.println(queue.getFirst());
	System.out.println(queue.getLast());
	queue.insert(30);
	System.out.println(queue);
	System.out.println(queue.getFirst());
	System.out.println(queue.getLast());
    }
    
    /**
     * Sanity of existing functionality.
     * @param args
     */
    public static void main4(String[] args) {
	CircularQTake4 queue = new CircularQTake4(2);
	System.out.println(queue);
	System.out.println(queue.getCurrentSize());
	System.out.println(queue.getSize());
	queue.insert(10);
	System.out.println(queue);
	System.out.println(queue.getFirst());
	System.out.println(queue.getLast());
	System.out.println(queue.getCurrentSize());
	System.out.println(queue.getSize());
	queue.insert(20);
	System.out.println(queue);
	System.out.println(queue.getFirst());
	System.out.println(queue.getLast());
	System.out.println(queue.getCurrentSize());
	System.out.println(queue.getSize());
	queue.insert(30);
	System.out.println(queue);
	System.out.println(queue.getFirst());
	System.out.println(queue.getLast());
	System.out.println(queue.getCurrentSize());
	System.out.println(queue.getSize());
    }
    
    private static Node HEAD, REAR;
    private static int SIZE, CURRENT_SIZE;
    
    public CircularQTake4(){
	HEAD = null;
	REAR = null;
    }
    
    public CircularQTake4(int size){
	this();
	SIZE = size;
	CURRENT_SIZE = 0;
    }
    
    public int getLast() {
	int result = -1;
	if(isEmpty())
	    System.out.println("No elements present !!");
	else
	    result = REAR.value;
	return result;
    }
    
    public int getFirst() {
	int result = -1;
	if(isEmpty())
	    System.out.println("No elements present !!");
	else
	    result = HEAD.value;
	return result;
    }
    
    public int getSize(){
	return SIZE;
    }
    
    public int getCurrentSize(){
	return CURRENT_SIZE;
    }
    
    public boolean isEmpty(){
	return HEAD==null;
    }
    
    public void insert(int i) {
	Node n = new Node();
	n.setValue(i);
	n.setNext(null);
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
        // We can use the new method to check empty.
        if(isEmpty())
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
 * 1.) isEmpty(), returns true is queue is empty.
 * 
 * But, we have new problems with this implementation.
 * 1.) getFirst(), returns a value if queue is empty.
 * 
 * Correct behaviour should throw a RuntimeException instead.
 * 
 * FURTHER: Throwing RuntimeException can be added as behaviour
 * in other corner cases.
 * 1.) Insertion on full queue.
 * 2.) Removal from empty queue.
 */
