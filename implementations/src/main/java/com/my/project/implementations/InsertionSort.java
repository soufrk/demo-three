package com.my.project.implementations;

import java.util.Arrays;

/**
 * Start with Insertion Sort.
 * Array in left is always sorted. 
 * Pick next element to right and find correct position in array to left. 
 * 
 * @author soufrk
 *
 */
public class InsertionSort {

    public static void main(String[] args) {
	int[] input = {3, 7, 5, 1, 8, 2, 0, 9};
	System.out.println(Arrays.toString(sortAscending(input)));
	System.out.println(Arrays.toString(sortDescending(input)));
	
	Integer[] integers = {6, 2, 9, 1, 3, 5, 0, 7};
	System.out.println(Arrays.toString(sortAscending(integers)));
	System.out.println(Arrays.toString(sortDescending(integers)));
    }

    private static int[] sortAscending(int[] input) {
	for (int i = 0; i < input.length - 1; i++) {
	    int j = i;
	    while (j > -1 && input[j] > input[j + 1]) {
		int temp = input[j];
		input[j] = input[j + 1];
		input[j + 1] = temp;
		j--;
	    }
	}
	return input;
    }

    private static int[] sortDescending(int[] input) {
	for (int i = 0; i < input.length - 1; i++) {
	    int j = i;
	    while (j > -1 && input[j] < input[j + 1]) {
		int temp = input[j];
		input[j] = input[j + 1];
		input[j + 1] = temp;
		j--;
	    }
	}
	return input;
    }

    private static <T extends Comparable<T>> T[] sortAscending(T[] input) {
	for (int i = 0; i < input.length - 1; i++) {
	    int j = i;
	    while (j > -1 && input[j].compareTo(input[j + 1]) > 0) {
		T temp = input[j];
		input[j] = input[j + 1];
		input[j + 1] = temp;
		j--;
	    }
	}
	return input;
    }
    
    private static <T extends Comparable<T>> T[] sortDescending(T[] input) {
	for (int i = 0; i < input.length - 1; i++) {
	    int j = i;
	    while (j > -1 && input[j].compareTo(input[j + 1]) < 0) {
		T temp = input[j];
		input[j] = input[j + 1];
		input[j + 1] = temp;
		j--;
	    }
	}
	return input;
    }

}
