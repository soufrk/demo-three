package com.my.project.implementations.threadsandconcurrency;

/**
 * The objective is to have a bunch of threads each counting to a target
 * value. 
 * Restriction is, all counts of a single number should output together
 * before proceeding to next number.
 * 
 * @author soufrk
 *
 */
public class CountingInGroup {

    private int size, target;

    public CountingInGroup(int size, int target) {
	this.size = size;
	this.target = target;
    }

    public static void main(String[] args) {
	//CountingInGroup object = new CountingInGroup(2, 3);
	CountingInGroup object = new CountingInGroup(5, 20);
	for (int i = 0; i < object.size; i++) {
	    new CountingThread(object).start();
	}
    }

    public int getSize() {
	return size;
    }

    public int getTarget() {
	return target;
    }

}

class CountingThread extends Thread {

    private static CountingInGroup REFERENCE = null;
    private static volatile boolean STOP = false;
    private static volatile int memberCount = 0;

    public CountingThread(CountingInGroup object) {
	REFERENCE = object;
    }

    @Override
    public void run() {
	int value = 0;
	while (!STOP) {
	    // increment value counter
	    value++;
	    System.out.println(getName() + " counts:" + value);
	    if (value < REFERENCE.getTarget()) {
		//System.out.println(getName() + " trying to acquire lock on class");
		try {
		    // increment member counter
		    //System.out.println("Member Count:" + memberCount);
		    if (memberCount < REFERENCE.getSize() - 1)
			synchronized (CountingThread.class) {
			    memberCount++;
			    //System.out.println(getName() + " waits for others.");
			    CountingThread.class.wait();
			}
		    else {
			// reset member counter
			memberCount = 0;
			synchronized (CountingThread.class) {
			    //System.out.println(getName() + " notifies others.");
			    CountingThread.class.notifyAll();
			}
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    } else if (value == REFERENCE.getTarget()) {
		STOP = true;
	    }
	}
    }
}
