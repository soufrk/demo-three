package com.my.project.implementations.datastructures;

import java.util.Formatter;

/**
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
    
    CircularQ(){
	HEAD = null;
	REAR = null;
    }
    
    CircularQ(int size){
	this();
	SIZE = size;
    }

    public static void main(String[] args) {
	//CircularQ newInstance = new CircularQ();
	CircularQ newInstance = new CircularQ(2);
	newInstance.insert(10);
	//System.out.println(newInstance);
	//System.out.println(newInstance.getFirst());
	//System.out.println(newInstance.getLast());
	newInstance.insert(20);
	//System.out.println(newInstance.getFirst());
	//System.out.println(newInstance.getLast());
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
