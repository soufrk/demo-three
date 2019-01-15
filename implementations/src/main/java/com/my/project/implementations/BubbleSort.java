package com.my.project.implementations;

import java.util.Arrays;

/**
 * Iterate over array and exchange any two sequential elements, that are out of order.
 * 
 * @author soufrk
 *
 */
public class BubbleSort {

    public static void main(String[] args) {
	int[] input = { 9, 4, 6, 5, 3, 8, 2, 0, 1, 7 };
	System.out.println(Arrays.toString(sortAscending(input)));
	System.out.println(Arrays.toString(sortDescending(input)));

	Integer[] integers = { 8, 6, 2, 9, 1, 3, 5, 0, 7, 4 };
	System.out.println(Arrays.toString(sortAscending(integers)));
	System.out.println(Arrays.toString(sortDescending(integers)));
    }

    private static int[] sortAscending(int[] input) {
	boolean unsorted = true;
	do {
	    unsorted = false;
	    for (int i = 0; i < input.length - 1; i++) {
		if (input[i] > input[i + 1]) {
		    int temp = input[i];
		    input[i] = input[i + 1];
		    input[i + 1] = temp;
		    unsorted = true;
		}
	    }
	} while (unsorted);
	return input;
    }
    
    private static int[] sortDescending(int[] input) {
	boolean unsorted = true;
	do {
	    unsorted = false;
	    for (int i = 0; i < input.length - 1; i++) {
		if (input[i] < input[i + 1]) {
		    int temp = input[i];
		    input[i] = input[i + 1];
		    input[i + 1] = temp;
		    unsorted = true;
		}
	    }
	} while (unsorted);
	return input;
    }
    
    private static<T extends Comparable<T>> T[] sortAscending(T[] input) {
	boolean unsorted = true;
	do {
	    unsorted = false;
	    for (int i = 0; i < input.length - 1; i++) {
		if (input[i].compareTo(input[i + 1]) > 0) {
		    T temp = input[i];
		    input[i] = input[i + 1];
		    input[i + 1] = temp;
		    unsorted = true;
		}
	    }
	} while (unsorted);
	return input;
    }
    
    private static<T extends Comparable<T>> T[] sortDescending(T[] input) {
	boolean unsorted = true;
	do {
	    unsorted = false;
	    for (int i = 0; i < input.length - 1; i++) {
		if (input[i].compareTo(input[i + 1]) < 0) {
		    T temp = input[i];
		    input[i] = input[i + 1];
		    input[i + 1] = temp;
		    unsorted = true;
		}
	    }
	} while (unsorted);
	return input;
    }

}
