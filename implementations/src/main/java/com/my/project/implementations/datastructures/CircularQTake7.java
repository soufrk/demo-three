package com.my.project.implementations.datastructures;

import java.util.Formatter;

/**
 * Correcting previous example conceptually. 1.) Behaviour of HEAD wrt to queue.
 * 2.) Added REAR in toString() method. 3.) Added closing of formatter in
 * toString() method.
 * 
 * @author soufrk
 *
 */
public class CircularQTake7<T> {

    public static void main1(String[] args) {
	CircularQTake7<Integer> q = new CircularQTake7<>(2);
	q.enqueue(10);
	q.enqueue(20);
	System.out.println(q);
	int x = q.dequeue();
	System.out.println("Removed:" + x);
	x = q.dequeue();
	System.out.println("Removed:" + x);
    }

    public static void main2(String[] args) {
	CircularQTake7<Integer> q = new CircularQTake7<>(2);
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
	CircularQTake7<Integer> q = new CircularQTake7<>(2);
	q.enqueue(10);
	q.enqueue(20);
	System.out.println(q);
	try {
	    q.enqueue(30);
	} catch (IndexOutOfBoundsException e) {
	    System.out.println(e.getMessage());
	}
	int x = q.dequeue();
	System.out.println("Removed:" + x);
	x = q.dequeue();
	System.out.println("Removed:" + x);
    }

    /**
     * Check break of functionality.
     */
    public static void main4(String[] args) {
	CircularQTake7<Integer> q = new CircularQTake7<>(2);
	System.out.println(q);
	try {
	    q.getFirst();
	} catch (IndexOutOfBoundsException e) {
	    System.out.println("Exception:" + e.getMessage());
	}
	try {
	    q.getLast();
	} catch (IndexOutOfBoundsException e) {
	    System.out.println("Exception:" + e.getMessage());
	}
	try {
	    q.dequeue();
	} catch (IndexOutOfBoundsException e) {
	    System.out.println("Exception:" + e.getMessage());
	}
    }
    
    public static void main5(String[] args) {
	CircularQTake7<String> q = new CircularQTake7<>(2);
	q.enqueue("Abc");
	System.out.println(q);
	q.enqueue("Bcd");
	System.out.println(q);
	try {
	    q.enqueue("Cde");
	} catch (IndexOutOfBoundsException e) {
	    System.out.println(e.getMessage());
	}
	q.dequeue();
	System.out.println(q);
    }
    
    /**
     * Try breaking the design
     */
    public static void main(String[] args) {
	CircularQTake7<Double> q1 = new CircularQTake7<>(3);
	q1.enqueue(1.05d);
	q1.enqueue(2.05d);
	q1.enqueue(3.05d);
	System.out.println(CircularQTake7.CURRENT_SIZE);
	CircularQTake7<String> q2 = new CircularQTake7<>(3);
	System.out.println(CircularQTake7.CURRENT_SIZE);
	q1.enqueue(4.05d);
	q2.enqueue("Abc");
	q2.enqueue("Bcd");
	q2.enqueue("Cde");
	q1.dequeue();
	System.out.println(q1);
	System.out.println(q2);
    }

    private Node<T> HEAD, REAR;
    private static int SIZE, CURRENT_SIZE;

    public CircularQTake7() {
	HEAD = null;
	REAR = null;
    }

    public CircularQTake7(int size) {
	this();
	SIZE = size;
	CURRENT_SIZE = 0;
    }

    public T getLast() {
	T result = null;
	if (isEmpty())
	    throw new IndexOutOfBoundsException("No elements present !!");
	else
	    result = REAR.value;
	return result;
    }

    public T getFirst() {
	T result = null;
	if (isEmpty())
	    throw new IndexOutOfBoundsException("No elements present !!");
	else
	    result = HEAD.value;
	return result;
    }

    public int getSize() {
	return SIZE;
    }

    public int getCurrentSize() {
	return CURRENT_SIZE;
    }

    public boolean isEmpty() {
	return HEAD == null;
    }

    public void enqueue(T t) {
	Node<T> n = new Node<>();
	n.setValue(t);
	n.setNext(null);
	if (isEmpty()) {
	    HEAD = n;
	    REAR = n;
	}
	if (CURRENT_SIZE < SIZE) {
	    n.next = HEAD;
	    HEAD = n;
	    CURRENT_SIZE++;
	} else {
	    throw new IndexOutOfBoundsException("The queue is full !!");
	}
    }

    public T dequeue() {
	Node<T> removedElement;
	if (isEmpty()) {
	    throw new IndexOutOfBoundsException("The queue is empty !!");
	} else {
	    Node<T> node = HEAD;
	    if (getCurrentSize() == 1) {
		removedElement = HEAD;
		REAR = null;
		HEAD = null;
	    } else {
		while (node.next != REAR)
		    node = node.next;
		REAR = node;
		removedElement = node.next;
		removedElement.next = null;
	    }
	    CURRENT_SIZE--;
	}
	return removedElement.value;
    }

    private static class Node<T> {
	T value;
	Node<T> next;

	public void setValue(T value) {
	    this.value = value;
	}

	public void setNext(Node<T> next) {
	    this.next = next;
	}
    }

    @Override
    public String toString() {
	String result = "";
	Formatter formatter = new Formatter();
	Node<T> pointer = HEAD;
	// We can use the new method to check empty.
	if (isEmpty())
	    formatter.format("%s", "Empty");
	else {
	    formatter.format("%s -> %s", "HEAD", pointer.value);
	    while (pointer != REAR) {
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

/*
 * Minor design problem,
 * 1.) Variables SIZE, CURRENT_SIZE are static and hence break the behaviour of a utility class.
 * 
 * Major design problem,
 * 1.) The queue needs to be initialized with size, if not, it results in an exception.
 * 2.) Should post assignment of queue size be an answer. If so, do we need checks.
 */
