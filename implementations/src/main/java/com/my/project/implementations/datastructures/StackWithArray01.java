package com.my.project.implementations.datastructures;

/**
 * First take implementing stack using array, 
 * written in text-editor only.
 * 
 * Spot the errors
 * 
 * @author soufrk
 */
public class StackWithArray01<T> {
    private int maxSize, currSize;
    private Node<T>[] stack;

    public StackWithArray01(int size) {
	stack = new Node<>[size];
	maxSize = size;
	currSize = 0;
    }

    public T push(T e) {
	if (currSize == maxSize)
	    throw new IndexOutOfBoundsException("Stack is full !!");
	Node<T> node = new Node<>(e);
	stack[currSize] = node;
	currSize++;
    }

    public T pop(T e) {
	if (currSize == 0)
	    throw new IndexOutOfBoundsException("Stack is empty !!");
	currSize--;
	stack[currSize] = null;
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
