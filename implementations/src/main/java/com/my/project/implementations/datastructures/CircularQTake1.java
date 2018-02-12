package com.my.project.implementations.datastructures;

import java.util.Formatter;

/**
 * A simple, easy and casual take at implementing a
 * circular queue of integer(int) type.
 * 
 * @author soufrk
 *
 */
public class CircularQTake1 {

    // 1. Q pointers
    private static Node HEAD, REAR;
    // 2. Variable defining size
    private static int SIZE;

    // Initialize all pointers to null.
    CircularQTake1() {
	HEAD = null;
	REAR = null;
    }

    // Alternative constructor defining size as well.
    CircularQTake1(int size) {
	this();
	SIZE = size;
    }

    public static void main(String[] args) {
	// 1. Initialize the queue.
	// CircularQTake1 newInstance = new CircularQTake1();
	CircularQTake1 newInstance = new CircularQTake1(2);
	// 2. Add an element.
	newInstance.insert(10);
	// 3. Print the queue.
	System.out.println(newInstance);
	// 4 Add another element.
	newInstance.insert(20);
	// 5. Print the queue again.
	System.out.println(newInstance);
    }

    /**
     * Insert a new node with provided value
     * @param i integer value
     */
    public void insert(int i) {
	// 1. Create a new node
	Node n = new Node();
	// 2. Set the node value.
	n.setValue(i);
	// 3. Set the next pointer to null.
	n.setNext(null);
	// 4. Let the HEAD point to current node
	HEAD = n;
	// 5. Let REAR point to null.
	REAR = null;
    }

    /**
     * The node class.
     * @author soufrk
     *
     */
    public static class Node {
	// 1. Stores the value.
	int value;
	// 2. Points to next element.
	Node next;

	public void setValue(int value) {
	    this.value = value;
	}

	public void setNext(Node next) {
	    this.next = next;
	}
    }

    /**
     * The method to print and see the queue.
     */
    @Override
    public String toString() {
	Formatter formatter = new Formatter();
	Node pointer = HEAD;
	// 1. Start with the head.
	if (pointer != null) {
	    formatter.format("%s -> %s", "HEAD", pointer.value);
	    pointer = pointer.next;
	}
	// 2. Continue to print till the end.
	while (pointer != null) {
	    formatter.format(" -> %s", pointer.value);
	    pointer = pointer.next;
	}
	formatter.close();
	return formatter.toString();
    }

}
/*
 * Here are the problems with this design,
 * 1.) HEAD always points to recently inserted element.
 * 
 * Spend some time to analyze what might be going wrong.
 * 
 * HINT: Does the insert() method create a chain ?
 */
