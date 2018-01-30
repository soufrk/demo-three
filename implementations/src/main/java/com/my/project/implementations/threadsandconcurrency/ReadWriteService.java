package com.my.project.implementations.threadsandconcurrency;

/**
 * A simple read/write implementation using wait/notify.
 * 
 * @author soufrk
 *
 */
public class ReadWriteService {
    
    private volatile boolean readFlag;
    private volatile boolean writeFlag;
    private Object readLock;
    private Object writeLock;
    
    private int value;
    
    private void getValue() {
        System.out.println("Reading value");
        System.out.println("Read value:" + value);
    }

    private void setValue(int value) {
	System.out.println("Writing value");
        this.value = value;
        System.out.println("Written value:" + value);
    }

    public ReadWriteService(){
	readFlag = false;
	writeFlag = false;
	readLock = new Object();
	writeLock = new Object();
    }

    public static void main(String[] args) {
	final ReadWriteService object = new ReadWriteService();
	Thread readThread = new Thread() {
	    @Override
	    public void run() {
	        object.read();
	    }
	};
	
	Thread writeThread = new Thread() {
	    @Override
	    public void run() {
	        object.add(10);
	    }
	};
	writeThread.start();
	readThread.start();
	try {
	    writeThread.join();
	    readThread.join();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }
    
    public void add(int x){
	System.out.println("Checking write");
	if(!writeFlag || !readFlag){
	    synchronized (writeLock) {
		try {
		    while(writeFlag || readFlag)
		    	writeLock.wait();
		    writeFlag = true;
		    //delegates addition
		    this.setValue(x);
		    writeFlag = false;
		    writeLock.notifyAll();
		    //readLock.notifyAll();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}
    }
    
    public void read(){//delegates read
	System.out.println("Checking read");
	if(!writeFlag){
	    synchronized (writeLock) {
		try {
		    while(writeFlag)
			writeLock.wait();
		    readFlag = true;
		    //delegates addition
		    this.getValue();
		    readFlag = false;
		    writeLock.notifyAll();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}
    }

}
