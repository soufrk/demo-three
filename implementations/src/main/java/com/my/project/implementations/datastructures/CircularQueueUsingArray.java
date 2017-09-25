package com.my.project.implementations.datastructures;

/**
 * Unguided take, implementing a circular queue
 * using arrays
 * 
 * @author soufrk
 *
 */
public class CircularQueueUsingArray {
    
    private Object[] arrayOfObjects;
    private int head, tail, size;
    
    public CircularQueueUsingArray(int size){
	this.size = size;
	arrayOfObjects = new Object[size];
	head = -1;
	tail = -1;
    }

    /**
     * Basic Test
     */
    public static void main1(String[] args) {
	CircularQueueUsingArray q = new CircularQueueUsingArray(2);
	q.enqueue(10);
    }
    
    /**
     * Print Test
     */
    public static void main2(String[] args) {
	CircularQueueUsingArray q = new CircularQueueUsingArray(2);
	q.enqueue(10);
	System.out.println(q);
    }
    
    /**
     * Second enqueue Test
     */
    public static void main3(String[] args) {
	CircularQueueUsingArray q = new CircularQueueUsingArray(2);
	q.enqueue(10);
	System.out.println(q + "\n");
	q.enqueue(20);
	System.out.println(q);
    }
    
    /**
     * Q-Full enqueue Test
     */
    public static void main4(String[] args) {
	CircularQueueUsingArray q = new CircularQueueUsingArray(2);
	q.enqueue(10);
	System.out.println(q);
	q.enqueue(20);
	System.out.println(q);
	q.enqueue(30);
    }
    
    /**
     * Print post Q-Full enqueue Test
     */
    public static void main5(String[] args) {
	CircularQueueUsingArray q = new CircularQueueUsingArray(2);
	q.enqueue(10);
	System.out.println(q);
	q.enqueue(20);
	System.out.println(q);
	q.enqueue(30);
	System.out.println(q);
    }
    
    /**
     * First dequeue Test
     */
    public static void main6(String[] args) {
	CircularQueueUsingArray q = new CircularQueueUsingArray(2);
	q.enqueue(10);
	System.out.println(q);
	q.enqueue(20);
	System.out.println(q);
	q.dequeue();
    }
    
    /**
     * Print post first dequeue Test
     */
    public static void main7(String[] args) {
	CircularQueueUsingArray q = new CircularQueueUsingArray(2);
	q.enqueue(10);
	System.out.println(q);
	q.enqueue(20);
	System.out.println(q);
	q.dequeue();
	System.out.println(q);
    }
    
    /**
     * Enqueue in cycle Test
     */
    public static void main8(String[] args) {
	CircularQueueUsingArray q = new CircularQueueUsingArray(2);
	q.enqueue(10);
	System.out.println(q);
	q.enqueue(20);
	System.out.println(q);
	q.dequeue();
	System.out.println(q);
	q.enqueue(30);
    }
    
    /**
     * Print after enqueue in cycle Test.
     */
    public static void main(String[] args) {
	CircularQueueUsingArray q = new CircularQueueUsingArray(2);
	q.enqueue(10);
	System.out.println(q);
	q.enqueue(20);
	System.out.println(q);
	q.dequeue();
	System.out.println(q);
	q.enqueue(30);
	System.out.println(q);
    }

    public void dequeue() {
	System.out.println("Trying to dQ.");
	if(this.isEmpty())
	    System.out.println("Q is empty !!");
	else if(head<tail && tail<size){
	    System.out.println("Removed element:" + arrayOfObjects[head] + ", from:" + head);
	    head++;
	}
    }

    public void enqueue(int i) {
	System.out.println("Trying to enQ.");
	if(this.isEmpty()){
	    System.out.println("Q is empty !!");
	    if(tail == size-1)
		tail = 0;
	    else
		tail++;
	    this.arrayOfObjects[tail] = i;
	    if(head == -1){
		head = 0;
		System.out.println("First insertion !!");
		System.out.println("Inserting element:" + i + ", at:" + tail);
	    }
	} else
	if(this.isFull()){
	    System.out.println("Queue is full !!");
	} else {
	    System.out.println("There is space in Q !!");
	    if(tail == size-1)
		tail = 0;
	    else
		tail++;
	    System.out.println("Inserting element:" + i + ", at:" + tail);
	    this.arrayOfObjects[tail] = i;
	}
    }

    private boolean isEmpty() {
	if(head == -1 && head == tail)
	    return true;
	else
	    return false;
    }

    private boolean isFull() {
	if(head == tail-1)
	    return true;
	else
	    return false;
    }
    
    @Override
    public String toString() {
	StringBuilder formatter = new StringBuilder();
	System.out.println("Head:" + head);
	System.out.println("Tail:" + tail);
	if(head == tail){
	    System.out.println("Single Element");
	    formatter.append("HEAD->" + arrayOfObjects[head] + "->TAIL");
	} else if(head<tail){
	    formatter.append("HEAD");
	    for(int i=head; i<=tail; i++){
		formatter.append("->" + arrayOfObjects[i]);
	    }
	    formatter.append("->TAIL");
	} else {
	    formatter.append("HEAD");
	    for(int i=head; i<size; i++){
		formatter.append("->" + arrayOfObjects[i]);
	    }
	    for(int i=0; i<head; i++){
		formatter.append("->" + arrayOfObjects[i]);
	    }
	    formatter.append("->TAIL");
	}
        return formatter.toString() + "\n";
    }

}
