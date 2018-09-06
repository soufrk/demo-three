package com.my.project.implementations.datastructures;

/**
 * Here are the errors of previous attempt, after putting code in IDE
 * 
 * 1. Redundant type declaration <E> in methods push(), pop() etc
 * 2. Name of param same as method variable
 * push(E e){
 *    Node<E> e = new Node<>(E e);
 * }
 * 3. Name of Node-type as 'element' variable; use 'node'
 * 	Node<E> element = null;
 * 4. Decalre nested class as 'private static' not just 'private'
 * 5. Wrong syntax of value, in nested class
 *     E e value;
 *     
 * Question: Will this demonstrate behaviour of stack correctly ?
 * 
 * @author soufrk
 *
 * @param <E>
 */
public class Stack02<E> {

    private static int maxSize;
    private int currentSize;
    private Node<E> TOP;
    private Node<E> BOTTOM;

    public Stack02(int size) {
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
	Node<E> node = null;
	if (currentSize > 0) {
	    node = TOP;
	    while (node.next != TOP) {
		node = node.next;
	    }
	    TOP = node;
	    TOP.next = null;
	    currentSize--;
	} else {
	    throw new IndexOutOfBoundsException("Stack is empty !!");
	}
	return node.value;
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
	Stack02<String> myStack = new Stack02<>(2);
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
