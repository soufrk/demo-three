package com.my.project.implementations;

import java.util.Formatter;

public class CircularQTake1 {

    private static Node HEAD, REAR;
    private static int SIZE;

    CircularQ() {
	HEAD = null;
	REAR = null;
    }

    CircularQ(int size) {
	this();
	SIZE = size;
    }

    public static void main(String[] args) {
	// CircularQ newInstance = new CircularQ();
	CircularQ newInstance = new CircularQ(2);
	newInstance.insert(10);
	System.out.println(newInstance);
	newInstance.insert(20);
	System.out.println(newInstance);
    }

    public void insert(int i) {
	Node n = new Node();
	n.setValue(i);
	n.setNext(null);
	HEAD = n;
	REAR = null;
    }

    public static class Node {
	int value;
	Node next;

	public void setValue(int value) {
	    this.value = value;
	}

	public void setNext(Node next) {
	    this.next = next;
	}
    }

    @Override
    public String toString() {
	Formatter formatter = new Formatter();
	Node pointer = HEAD;
	if (pointer != null) {
	    formatter.format("%s -> %s", "HEAD", pointer.value);
	    pointer = pointer.next;
	}
	while (pointer != null) {
	    formatter.format(" -> %s", pointer.value);
	    pointer = pointer.next;
	}
	return formatter.toString();
    }

}
