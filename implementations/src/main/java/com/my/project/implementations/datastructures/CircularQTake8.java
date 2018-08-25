package collections;

import java.util.Formatter;

/**
 * Correcting previous example design,
 * 1.) size, currentSize made private variables. 
 * 2.) head, tail chracter case changed.
 * 
 * @author soufrk
 *
 */
public class CircularQTake8<T> {

    public static void main1(String[] args) {
	CircularQTake8<Integer> q = new CircularQTake8<>(2);
	q.enqueue(10);
	q.enqueue(20);
	System.out.println(q);
	int x = q.dequeue();
	System.out.println("Removed:" + x);
	x = q.dequeue();
	System.out.println("Removed:" + x);
    }

    public static void main2(String[] args) {
	CircularQTake8<Integer> q = new CircularQTake8<>(2);
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
	CircularQTake8<Integer> q = new CircularQTake8<>(2);
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
	CircularQTake8<Integer> q = new CircularQTake8<>(2);
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
	CircularQTake8<String> q = new CircularQTake8<>(2);
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
	CircularQTake8<Double> q1 = new CircularQTake8<>(3);
	q1.enqueue(1.05d);
	q1.enqueue(2.05d);
	q1.enqueue(3.05d);
	System.out.println(q1.getCurrentSize());
	CircularQTake8<String> q2 = new CircularQTake8<>(3);
	System.out.println(q2.getCurrentSize());
	q1.enqueue(4.05d);
	q2.enqueue("Abc");
	q2.enqueue("Bcd");
	q2.enqueue("Cde");
	q1.dequeue();
	System.out.println(q1);
	System.out.println(q2);
    }


    private Node<T> head, rear;
    private int size, currentSize;

    public CircularQTake8() {
	head = null;
	rear = null;
    }

    public CircularQTake8(int size) {
	this();
	this.size = size;
	currentSize = 0;
    }

    public T getLast() {
	T result = null;
	if (isEmpty())
	    throw new IndexOutOfBoundsException("No elements present !!");
	else
	    result = rear.value;
	return result;
    }

    public T getFirst() {
	T result = null;
	if (isEmpty())
	    throw new IndexOutOfBoundsException("No elements present !!");
	else
	    result = head.value;
	return result;
    }

    public int getSize() {
	return size;
    }

    public int getCurrentSize() {
	return currentSize;
    }

    public boolean isEmpty() {
	return head == null;
    }

    public void enqueue(T t) {
	Node<T> n = new Node<>();
	n.setValue(t);
	n.setNext(null);
	if (isEmpty()) {
	    head = n;
	    rear = n;
	}
	if (currentSize < size) {
	    n.next = head;
	    head = n;
	    currentSize++;
	} else {
	    throw new IndexOutOfBoundsException("The queue is full !!");
	}
    }

    public T dequeue() {
	Node<T> removedElement;
	if (isEmpty()) {
	    throw new IndexOutOfBoundsException("The queue is empty !!");
	} else {
	    Node<T> node = head;
	    if (getCurrentSize() == 1) {
		removedElement = head;
		rear = null;
		head = null;
	    } else {
		while (node.next != rear)
		    node = node.next;
		rear = node;
		removedElement = node.next;
		removedElement.next = null;
	    }
	    currentSize--;
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
	Node<T> pointer = head;
	// We can use the new method to check empty.
	if (isEmpty())
	    formatter.format("%s", "Empty");
	else {
	    formatter.format("%s -> %s", "HEAD", pointer.value);
	    while (pointer != rear) {
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
 * Major design problem,
 * 1.) The queue needs to be initialized with size, if not, it results in an exception.
 * 2.) Should post assignment of queue size be an answer. If so, do we need checks.
 */
