package com.my.project.implementations.datastructures;

/**
 * Here are the errors of previous attempt, after putting code in IDE<ul>
 * 
 * <li>1. Unsupported generic array declaration
 * <pre>public StackWithArray02(int size) {
 *    stack = new Node<>[size];</pre>
 * Use array of Object instead</li>
 * <li>1. Redundant type declaration <E> in methods push(), pop() etc</li>
 * <li>3. Name of Node-type as 'element' variable; use 'node'
 * <pre>    Node<E> element = null;</pre></li>
 * <li>4. Decalre nested class as <tt>private static</tt> not just <tt>private</tt></li>
 * <li>5. Wrong syntax of value, in nested class
 * <pre>    E e value;</pre></li>
 * </ul>
 * Question: Will this demonstrate behaviour of stack correctly ?
 * 
 * @author soufrk
 */
public class StackWithArray02<T> {
    private int maxSize, currSize;
    private Object[] stack;

    public StackWithArray02(int size) {
	stack = new Object[size];
	maxSize = size;
	currSize = 0;
    }

    public T push(T e) {
	if (currSize == maxSize)
	    throw new IndexOutOfBoundsException("Stack is full !!");
	Node<T> node = new Node<>(e);
	stack[currSize] = node;
	currSize++;
	return e;
    }

    public T pop(T e) {
	T result = null;
	if (currSize == 0)
	    throw new IndexOutOfBoundsException("Stack is empty !!");
	result = (T) stack[currSize--];
	stack[currSize] = null;
	return result;
    }

    public boolean isEmpty() {
	return currSize == 0;
    }

    private static class Node<T> {
	T value;

	public Node(T t) {
	    value = t;
	}
    }
}

