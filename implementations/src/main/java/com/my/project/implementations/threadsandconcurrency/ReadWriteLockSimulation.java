package com.my.project.implementations.threadsandconcurrency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ReadWriteLockSimulation {

    public static void main(String[] args) {
	CarService cs = new CarService();
	Thread t1 = new Thread(() -> {
	    //while (true) {
		System.out.println("Register");
		cs.registerCar(new Car("Tesla", Double.toString(Math.random())));
	    //}
	});

	Thread t2 = new Thread(() -> {
	    //while (true) {
		System.out.println("Deregister");
		cs.deRegisterCar(new Car("Tesla", Double.toString(Math.random())));
	    //}
	});

	Thread t3 = new Thread(() -> {
	    while (true) {
		System.out.println(Thread.currentThread().getId() + " : " + cs.getCar(Double.toString(Math.random())));
	    }
	});

	Thread t4 = new Thread(() -> {
	    while (true) {
		System.out.println(Thread.currentThread().getId() + " : " + cs.getCar(Double.toString(Math.random())));
	    }
	});

	Thread t5 = new Thread(() -> {
	    while (true) {
		System.out.println(Thread.currentThread().getId() + " : " + cs.getCar(Double.toString(Math.random())));
		try {
		    Thread.sleep(100);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	});

	t1.start();
	t2.start();
	t3.start();
	t4.start();
	t5.start();
	
	String input = "";
	do{
	    System.out.println("Enter a thread to notify(1/2/3/4):(T to terminate)");
	    Scanner scanner = new Scanner(System.in);
	    input = scanner.next();
	    switch(input){
	    case "1":
		synchronized(cs.getWritelock()){
		    cs.getWritelock().notifyAll();
		}
		break;
	    }
	} while(!input.equals("T"));
    }

}

class Car {
    String model;
    String regNo;

    public Car(String model, String regNo) {
	this.model = model;
	this.regNo = regNo;
    }

    @Override
    public String toString() {
	return "Car [model=" + model + ", regNo=" + regNo + "]";
    }
}

class CarService {
    private List<Car> carList = new ArrayList<>();
    private volatile int readers = 0;
    private static final Object writeLock = new Object();

    public void registerCar(Car car) {
	synchronized (writeLock) {
		try {
		    System.out.println("waiting in register");
		    //while (readers > 0) Assuming a check for writers here as well
			//writeLock.wait();
		    System.out.println("No readers currently");
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    carList.add(car);
	    System.out.println("Successfully registered");
	    // Note we don't call notify here. It will be called from main()
	}
    }

    public void deRegisterCar(Car car) {
	synchronized (writeLock) {
	    //while (readers > 0)
		try {
		    System.out.println("Waiting in deregister");
		    //while (readers > 0) Assuming a check for writers here as well
			writeLock.wait();
		    System.out.println("No readers currently");
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    carList.remove(car);
	    System.out.println("Successfully deregistered");
	    // Note we don't call notify here. It will be called from main()
	}
    }

    public Car getCar(String regNo) {
	readers++;
	Car car = null;
	synchronized (writeLock) {
	    Iterator<Car> itr = carList.iterator();
	    while (itr.hasNext()) {
		car = itr.next();
		itr.remove();
		if (car.regNo.equals(regNo))
		    break;
	    }
	    readers--;
	    if (readers == 0) {
		System.out.println("Notifying");
		writeLock.notifyAll();
	    }
	}
	return car;
    }

    public static Object getWritelock() {
        return writeLock;
    }
}
