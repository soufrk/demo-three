package com.my.project.implementations.datastructures;

/**
 * Here are the short-comings of previous attempt
 * <ul>
 * <li>incorrect type-casting of elements in pop()</li>
 * <li>missing peek() method</li>
 * <li>addition of toString() method for display/debug</li>
 * </ul>
 * Question: Will this demonstrate behaviour of stack correctly ?
 *  
 * @author soufrk
 *
 */
public class StackWithArray03<T> {
    
    private int maxSize, currSize;
    private Object[] stack;

    public StackWithArray03(int size) {
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
	Node<T> result = null;
	if (currSize == 0)
	    throw new IndexOutOfBoundsException("Stack is empty !!");
	currSize--;
	result = (Node<T>) stack[currSize];
	return result.value;
    }
    
    public T peek() {
	Node<T> result = null;
	if (currSize == 0)
	    throw new IndexOutOfBoundsException("Stack is empty !!");
	result = (Node<T>) stack[currSize-1];
	return result.value;
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
    
    @Override
    public String toString() {
	String result = "";
        if(isEmpty()){
            result = "BOTTOM<->TOP";
        } else {
            result = "TOP";
            for(int counter = currSize; counter > 0; counter--){
        	Node<T> node = (Node<T>) stack[counter-1];
        	result += "\n" + node.value;
            }
            result += "\nBOTTOM";
        }
        return result;
    }
    
    public static void main(String args[]){
	StackWithArray03<String> myStack = new StackWithArray03<>(2);
	// 1. Negative Test - Empty stack pop
	//myStack.pop();
	// 2. Negative Test - Empty stack peek
	//myStack.peek();
	// 3. Positive Test - Push element
	myStack.push("A");
	//System.out.println(myStack.peek());
	myStack.push("B");
	//System.out.println(myStack.peek());
	// 4. Negative Test - Full stack push
	//myStack.push("C");
	// 5. Positive Test - Stack peek
	//System.out.println(myStack.peek());
	// 6. Positive Test - Stack pop
	//System.out.println(myStack.pop());
	//System.out.println(myStack.peek());
	// 7. Positive Test - Pop till empty
	//System.out.println(myStack.pop());
	//System.out.println(myStack.peek());
	//System.out.println(myStack.pop());
	//System.out.println(myStack.peek());
	// 8. Positive Test - Print stack
	System.out.println(myStack);
    }
    
}
