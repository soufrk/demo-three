package com.my.project.implementations.threadsandconcurrency;

/**
 * Simple demonstration of problems while working with multi-threading
 * 
 * @author soufrk
 *
 */
public class MultiThreadProblem {

    public static void main(String[] args) throws InterruptedException {
	int x = 0;
	Thread t1 = new Thread(new MyThread(x));
	t1.start();
	Thread t2 = new Thread(new MyThread(x));
	t2.start();
	t1.join();
	t2.join();
	System.out.println(x);
    }
    
    static class MyThread implements Runnable {
	
	private int x;
	
	public MyThread(int x) {
	    super();
	    this.x = x;
	}

	@Override
	public void run() {
	    for(int i=0;i<100000;i++) {
		x = x + 1;
	    }
	    
	}
    }

}
