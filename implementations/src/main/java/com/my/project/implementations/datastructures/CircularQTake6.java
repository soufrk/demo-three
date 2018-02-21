package com.my.project.implementations.datastructures;

import java.util.Formatter;

/**
 * Correcting previous example conceptually.
 * 1.) Behaviour of HEAD wrt to queue.
 * 2.) Added REAR in toString() method.
 * 3.) Added closing of formatter in toString() method.
 * 
 * @author soufrk
 *
 */
public class CircularQTake6 {

    public static void main1(String[] args) {
	CircularQTake6 q = new CircularQTake6(2);
	q.enqueue(10);
	q.enqueue(20);
	System.out.println(q);
	int x = q.dequeue();
	System.out.println("Removed:" + x);
	x = q.dequeue();
	System.out.println("Removed:" + x);
    }
    
    public static void main2(String[] args) {
	CircularQTake6 q = new CircularQTake6(2);
	q.enqueue(10);
	System.out.println(q);
	int x = q.dequeue();
	System.out.println("Removed:" + x);
	System.out.println(q);
	q.enqueue(20);
	System.out.println(q);
	x = q.dequeue();
	System.out.println("Removed:" + x);
	System.out.println(q);
	q.enqueue(30);
	System.out.println(q);
	x = q.dequeue();
	System.out.println("Removed:" + x);
	System.out.println(q);
    }
    
    /**
     * Try breaking the design. 
     */
    public static void main3(String[] args) {
	CircularQTake6 q = new CircularQTake6(2);
	q.enqueue(10);
	q.enqueue(20);
	System.out.println(q);
	try{
	    q.enqueue(30);	    
	} catch(IndexOutOfBoundsException e){
	    System.out.println(e.getMessage());
	}
	int x = q.dequeue();
	System.out.println("Removed:" + x);
	x = q.dequeue();
	System.out.println("Removed:" + x);
    }
    
    /**
     * Try breaking the design. 
     */
    public static void main(String[] args) {
	CircularQTake6 q = new CircularQTake6(2);
	System.out.println(q);
	try{
	    q.getFirst();	    
	} catch(IndexOutOfBoundsException e){
	    System.out.println("Exception:" + e.getMessage());
	}
	try{
	    q.getLast();	    
	} catch(IndexOutOfBoundsException e){
	    System.out.println("Exception:" + e.getMessage());
	}
	try{
	    q.dequeue();  
	} catch(IndexOutOfBoundsException e){
	    System.out.println("Exception:" + e.getMessage());
	}
    }
    
    private static Node HEAD, REAR;
    private static int SIZE, CURRENT_SIZE;
    
    public CircularQTake6(){
	HEAD = null;
	REAR = null;
    }
    
    public CircularQTake6(int size){
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
	return HEAD == null;
    }
    
    public void enqueue(int i) {
	Node n = new Node();
	n.setValue(i);
	n.setNext(null);
	if(isEmpty()){
	    HEAD = n;
	    REAR = n;
	}
	if(CURRENT_SIZE < SIZE){
	    n.next = HEAD;
	    HEAD = n;
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
	String result = "";
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
            formatter.format(" -> %s", "REAR");
        }
        result = formatter.toString(); 
        formatter.close();
        return result;
    }

}
