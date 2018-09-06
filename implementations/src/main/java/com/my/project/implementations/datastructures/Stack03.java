package com.my.project.implementations.datastructures;

/**
 * Here are the results of previous attempt(failures only 6 & 7)
 * 
 * 1. pop() method starts iteration from TOP; should be from BOTTOM
 * 	node = TOP;
 * 	while (node.next != TOP) {
 *     
 * Question: Will this solve the pop() method problem ?
 * 
 * @author soufrk
 *
 */
public class Stack03<E> {

    private static int maxSize;
    private int currentSize;
    private Node<E> TOP;
    private Node<E> BOTTOM;

    public Stack03(int size) {
	maxSize = size;
	currentSize = 0;
	TOP = null;
	BOTTOM = null;
    }

    public E push(E e) {
	E element = null;
	if (currentSize < maxSize) {
	    Node<E> node = new Node<>(e);
	    if (currentSize == 0) {
		BOTTOM = node;
	    } else {
		TOP.next = node;
	    }
	    TOP = node;
	    currentSize++;
	    element = node.value;
	} else {
	    throw new IndexOutOfBoundsException("Stack is full !!!");
	}
	return element;
    }

    public E pop() {
	E element = null;
	Node<E> node = null;
	if (currentSize > 0) {
	    node = BOTTOM;
	    while (node.next != TOP) {
		node = node.next;
	    }
	    TOP = node;
	    element = node.next.value;
	    TOP.next = null;
	    currentSize--;
	} else {
	    throw new IndexOutOfBoundsException("Stack is empty !!");
	}
	return element;
    }

    public E peek() {
	if (currentSize == 0)
	    throw new IndexOutOfBoundsException("Stack is empty");
	return TOP.value;
    }

    private static class Node<E> {
	E value;
	Node<E> next;

	public Node(E e) {
	    value = e;
	    next = null;
	}
    }

    public static void main(String[] args) {
	Stack03<String> myStack = new Stack03<>(2);
	// 1. Negative Test - Empty stack pop
	//myStack.pop();
	// 2. Negative Test - Empty stack peek
	//myStack.peek();
	// 3. Positive Test - Push element
	myStack.push("A");
	myStack.push("B");
	// 4. Negative Test - Full stack push
	//myStack.push("C");
	// 5. Positive Test - Stack peek
	//System.out.println(myStack.peek());
	// 6. Positive Test - Stack pop
	System.out.println(myStack.pop());
	System.out.println(myStack.peek());
	// 7. Positive Test - Pop till empty
	System.out.println(myStack.pop());
	System.out.println(myStack.peek());
	System.out.println(myStack.pop());
	System.out.println(myStack.peek());
    }
}
