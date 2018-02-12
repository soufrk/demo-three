package com.my.project.implementations.datastructures;

import java.util.Formatter;

/**
 * Let's try to address the shortcoming's that the earlier implementation had.
 * 
 * 1st member is HEAD.
 * Subsequent members are next to HEAD.
 * 
 * REAR is member recently added.
 * 
 * Example: Ticket Counter
 * 
 * @author soufrk
 *
 */
public class CircularQTake2 {
    
    private static Node HEAD, REAR;
    private static int SIZE;
    
    CircularQTake2(){
	HEAD = null;
	REAR = null;
    }
    
    CircularQTake2(int size){
	this();
	SIZE = size;
    }

    /**
     * Let's test basic functionality.
     * @param args
     */
    public static void main1(String[] args) {
	CircularQTake2 newInstance = new CircularQTake2(2);
	newInstance.insert(10);
	newInstance.insert(20);
	System.out.println(newInstance);
	newInstance.insert(30);
	System.out.println(newInstance);
    }
    
    /**
     * This is an added functionality.
     * @param args
     */
    public static void main(String[] args) {
	CircularQTake2 newInstance = new CircularQTake2(2);
	newInstance.insert(10);
	System.out.println(newInstance);
	System.out.println(newInstance.getFirst());
	System.out.println(newInstance.getLast());
	newInstance.insert(20);
	System.out.println(newInstance);
	System.out.println(newInstance.getFirst());
	System.out.println(newInstance.getLast());
    }
    
    /**
     * Let's try breaking this design.
     * @param args
     */
    public static void main3(String[] args) {
	CircularQTake2 newInstance = new CircularQTake2(2);
	newInstance.insert(10);
	newInstance.insert(20);
	System.out.println(newInstance);
	newInstance.insert(30);
	System.out.println(newInstance);
    }
    
    public int getLast() {
	return REAR.value;
    }
    
    public int getFirst() {
	return HEAD.value;
    }

    public void insert(int i) {
	Node n = new Node();
	n.setValue(i);
	n.setNext(null);
	// Notice the difference here compared to previous 
	// implementation.
	if(HEAD == null){
	    HEAD = n;
	    REAR = n;
	} else {
	    //n.next = REAR;
	    REAR.next = n;
	    REAR = n;
	}
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
        Formatter formatter = new Formatter();
        Node pointer = HEAD;
        if(HEAD == REAR)
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
 * 1.) getLast(), shows REAR element value, and
 * 2.) getFirst() methods, which show the HEAD element value.
 * 
 * But now, we have a new problem with this implementation.
 * 1.) Queue with first element inserted, is not printed properly.
 * 1.) Elements can still be added after specifying the size.
 * 
 * Spend some time to analyze what might be going wrong.
 * 
 * HINT: Does the insert() method take care of the size ?
 */

