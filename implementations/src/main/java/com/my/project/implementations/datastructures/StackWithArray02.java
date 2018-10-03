package com.my.project.implementations.datastructures;

/**
 * Here are the errors of previous attempt, after putting code in IDE<ul>
 * 
 * <li>1. Unsupported generic array declaration
 * <pre>public StackWithArray02(int size) {
 *    stack = new Node<>[size];</pre>
 * Use array of Object instead</li>
 * <li>2. Missing returns in <tt>push()</tt> and <tt>pop()</tt> methods</li>
 * <li>3. Useless parameter declaration in <tt>pop()</tt> method</li>
 * <li>4. Missing method <tt>peek()</tt></li>
 * </ul>
 * Question: Will this demonstrate behaviour of stack correctly ?
 * 
 * @author soufrk
 * 
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

    public T pop() {
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

