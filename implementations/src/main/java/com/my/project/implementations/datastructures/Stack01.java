package com.my.project.implementations.datastructures;

/**
 * First take implementing stack, in text-editor only.
 * Spot the errors
 * 
 * @author soufrk
 */
public class Stack01<E> {

    private static int maxSize;
    private int currentSize;
    private Node<E> TOP;
    private Node<E> BOTTOM;

    public Stack01(int size) {
	maxSize = size;
	currentSize = 0;
	TOP = null;
	BOTTOM = null;
    }

    public <E> E push(E e){
	E element = null;
	if(currentSize < maxSize){
	    Node<E> e = new Node<>(E e);
	    if(currentSize == 0){
		BOTTOM = e;
	    } else {
		TOP.next = e;
	    }
	    TOP = e;
	    currentSize++;
	    element = e;
	} else {
	    throw new IndexOutOfBoundsException("Stack is full !!!");
	}
	return element;
    }

    public <E> E pop() {
	Node<E> element = null;
	if (currentSize > 0) {
	    element = HEAD;
	    while (element.next != TOP) {
		element = element.next;
	    }
	    TOP = element;
	    TOP.next = null;
	    currentSize--;
	}
	return element.value;
    }

    public <E> E peek() {
	if (currentSize == 0)
	    throw new IndexOutOfBoundsException("Stack is empty");
	return TOP.value;
    }

    private class Node<E> {
	E e value;
	Node<E> next;
	
	public Node(E e){
	    this.e = e;
	    next = null;
	}
    }

}
