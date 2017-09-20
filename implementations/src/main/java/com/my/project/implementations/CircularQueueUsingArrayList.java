package com.my.project.implementations;

import java.util.LinkedList;
import java.util.List;

/**
 * Unguided take, on implementing circular queue using array-list.
 * It should be easy-peasy
 *  
 * @author soufrk
 *
 */
public class CircularQueueUsingArrayList {
    
    private List<Object> listOfObjects;
    private int size;
    
    public CircularQueueUsingArrayList(int size){
	this.size = size;
	listOfObjects = new LinkedList<>();
    }

    /**
     * Basic Test
     */
    public static void main1(String[] args) {
	CircularQueueUsingArrayList q = new CircularQueueUsingArrayList(2);
	q.enqueue(10);
    }
    
    /**
     * Print Test
     */
    public static void main2(String[] args) {
	CircularQueueUsingArrayList q = new CircularQueueUsingArrayList(2);
	q.enqueue(10);
	System.out.println(q);
    }
    
    /**
     * Second enqueue Test
     */
    public static void main3(String[] args) {
	CircularQueueUsingArrayList q = new CircularQueueUsingArrayList(2);
	q.enqueue(10);
	System.out.println(q);
	q.enqueue(20);
	System.out.println(q);
    }
    
    /**
     * Enqueue overflow Test
     */
    public static void main4(String[] args) {
	CircularQueueUsingArrayList q = new CircularQueueUsingArrayList(2);
	q.enqueue(10);
	System.out.println(q);
	q.enqueue(20);
	System.out.println(q);
	q.enqueue(30);
    }
    
    /**
     * Print after Enqueue overflow Test
     */
    public static void main5(String[] args) {
	CircularQueueUsingArrayList q = new CircularQueueUsingArrayList(2);
	q.enqueue(10);
	System.out.println(q);
	q.enqueue(20);
	System.out.println(q);
	q.enqueue(30);
	System.out.println(q);
    }
    
    /**
     * First dequeue Test.
     */
    public static void main6(String[] args) {
	CircularQueueUsingArrayList q = new CircularQueueUsingArrayList(2);
	q.enqueue(10);
	System.out.println(q);
	q.enqueue(20);
	System.out.println(q);
	q.dequeue();
	System.out.println(q);
    }
    
    /**
     * Circular enqueue Test.
     */
    public static void main7(String[] args) {
	CircularQueueUsingArrayList q = new CircularQueueUsingArrayList(2);
	q.enqueue(10);
	System.out.println(q);
	q.enqueue(20);
	System.out.println(q);
	q.dequeue();
	System.out.println(q);
	q.enqueue(30);
    }
    
    /**
     * Print Circular enqueue Test.
     */
    public static void main(String[] args) {
	CircularQueueUsingArrayList q = new CircularQueueUsingArrayList(2);
	q.enqueue(10);
	System.out.println(q);
	q.enqueue(20);
	System.out.println(q);
	q.dequeue();
	System.out.println(q);
	q.enqueue(30);
	System.out.println(q);
    }

    private void dequeue() {
	System.out.println("Trying to dQ.");
	if(this.isEmpty())
	    System.out.println("Queue is empty !!");
	else{
	    System.out.println("Removing element:" + listOfObjects.get(0));
	    listOfObjects.remove(0);
	}
    }

    public void enqueue(int i) {
	System.out.println("Trying to enQ.");
	if(this.isFull()){
	    System.out.println("Queue is full !!");
	}
	else {
	    System.out.println("There is space in Q !!");
	    this.listOfObjects.add(i);
	    System.out.println("Inserting element:" + i);
	} 
    }

    private boolean isEmpty() {
	return listOfObjects.size() == 0;
    }

    private boolean isFull() {
	return listOfObjects.size() == size;
    }
    
    @Override
    public String toString() {
	StringBuilder formatter = new StringBuilder();
	formatter.append("HEAD");
	for(Object i:listOfObjects)
	    formatter.append("->" + i);
	formatter.append("->TAIL");
        return formatter.toString() + "\n";
    }

}
