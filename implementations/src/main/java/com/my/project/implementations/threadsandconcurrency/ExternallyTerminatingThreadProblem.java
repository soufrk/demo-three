package com.my.project.implementations.threadsandconcurrency;

/**
 * The main thread waits for 2s and signals the other thread
 * to stop execution. At least that's what it was intended to do.
 * 
 * @author soufrk
 *
 */
public class ExternallyTerminatingThreadProblem extends Thread {
    
    private boolean stopFlag;

    public ExternallyTerminatingThreadProblem() {
	this.stopFlag = true;
    }

    public static void main(String[] args) {
	ExternallyTerminatingThreadProblem object = new ExternallyTerminatingThreadProblem(); 
	Thread t = object;
	t.start();
	try {
	    t.sleep(2000);
	    object.stopFlag = false;
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void run() {
	while(stopFlag){}
	System.out.println("Exitting");
    }
}
