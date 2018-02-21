package com.my.project.implementations.datastructures;

import java.util.Formatter;

/**
 * Continuing from previous version, the main highlights of this one will be,
 * 1.) Renaming insert() to enqueue().
 * 2.) Provide removal method deque().
 * 3.) Exception scenarios - getFirst() and getLast() on empty queue.
 * 4.) Exception scenarios - enqueue() on full queue.
 * 5.) Exception scenarios - dequeue() on empty queue.
 *     
 * 
 * 
 * If queue is empty,
 * 1.) getFirst() and getLast() returns -1 and a significant message.
 * 
 * @author soufrk
 *
 */
public class CircularQTake5 {

    public static void main1(String[] args) {
	CircularQTake5 q = new CircularQTake5(2);
	q.enqueue(10);
	int x = q.dequeue();
	System.out.println("Removed:" + x);
    }
    
    public static void main2(String[] args) {
	CircularQTake5 q = new CircularQTake5(2);
	q.enqueue(10);
	int x = q.dequeue();
	System.out.println("Removed:" + x);
	q.enqueue(20);
	x = q.dequeue();
	System.out.println("Removed:" + x);
    }
    
    public static void main(String[] args) {
	CircularQTake5 q = new CircularQTake5(2);
	q.enqueue(10);
	q.enqueue(20);
	System.out.println(q);
	int x = q.dequeue();
	System.out.println("Removed:" + x);
	x = q.dequeue();
	System.out.println("Removed:" + x);
    }
    
    private static Node HEAD, REAR;
    private static int SIZE, CURRENT_SIZE;
    
    public CircularQTake5(){
	HEAD = null;
	REAR = null;
    }
    
    public CircularQTake5(int size){
	this();
	SIZE = size;
	CURRENT_SIZE = 0;
    }
    
    public int getLast() {
	int result = -1;
	if(isEmpty())
	    throw new IndexOutOfBoundsException("No elements present !!");
	else
	    result = REAR.value;
	return result;
    }
    
    public int getFirst() {
	int result = -1;
	if(isEmpty())
	    throw new IndexOutOfBoundsException("No elements present !!");
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
    
    public void enqueue(int i) {
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
	    throw new IndexOutOfBoundsException("The queue is full !!");
	}
    }
    
    public int dequeue(){
	Node removedElement;
	if(isEmpty()){
	    throw new IndexOutOfBoundsException("The queue is empty !!");
	} else {
	    Node node = HEAD;
	    //if(HEAD == REAR){
	    if(getCurrentSize() == 1){
		removedElement = HEAD;
		REAR = null;
		HEAD = null;
	    } else {
		while(node.next != REAR)
		    node = node.next;
		REAR = node;
		removedElement = node.next;
		removedElement.next = null;		
	    }
	    CURRENT_SIZE--;
	}
	return removedElement.value;
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
 * Major conceptual problem,
 * 1.) HEAD always points to element recently updated.
 * 2.) REAR always points to element first added.
 */
