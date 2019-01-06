package com.my.project.implementations;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
	int[] input = { 3, 7, 5, 1, 8, 2, 0, 9 };
	System.out.println(Arrays.toString(sortAscending(input)));
	System.out.println(Arrays.toString(sortDescending(input)));

	Integer[] integers = { 6, 2, 9, 1, 3, 5, 0, 7 };
	System.out.println(Arrays.toString(sortAscending(integers)));
	System.out.println(Arrays.toString(sortDescending(integers)));
    }

    private static int[] sortAscending(int[] input) {
	for (int i = 0; i < input.length; i++) {
	    int currElement = input[i];
	    int lowestElement = currElement;
	    int lowestIndex = i;
	    for (int j = i; j < input.length; j++) {
		if (input[j] < lowestElement) {
		    lowestElement = input[j];
		    lowestIndex = j;
		}
	    }
	    if (lowestIndex != i) {
		int temp = input[i];
		input[i] = lowestElement;
		input[lowestIndex] = temp;
	    }
	}
	return input;
    }

    private static int[] sortDescending(int[] input) {
	for (int i = 0; i < input.length; i++) {
	    int currElement = input[i];
	    int highestElement = currElement;
	    int highestIndex = i;
	    for (int j = i; j < input.length; j++) {
		if (input[j] > highestElement) {
		    highestElement = input[j];
		    highestIndex = j;
		}
	    }
	    if (highestIndex != i) {
		int temp = input[i];
		input[i] = highestElement;
		input[highestIndex] = temp;
	    }
	}
	return input;
    }

    private static <T extends Comparable<T>> T[] sortDescending(T[] input) {
	for (int i = 0; i < input.length; i++) {
	    T highestElement = input[i];
	    int highestIndex = i;
	    for (int j = i; j < input.length; j++) {
		if (input[j].compareTo(highestElement) > 0) {
		    highestElement = input[j];
		    highestIndex = j;
		}
	    }
	    if (highestIndex != i) {
		T temp = input[i];
		input[i] = highestElement;
		input[highestIndex] = temp;
	    }
	}
	return input;
    }

    private static <T extends Comparable<T>> T[] sortAscending(T[] input) {
	for (int i = 0; i < input.length; i++) {
	    T lowestElement = input[i];
	    int lowestIndex = i;
	    for (int j = i; j < input.length; j++) {
		if (input[j].compareTo(lowestElement) < 0) {
		    lowestElement = input[j];
		    lowestIndex = j;
		}
	    }
	    if (lowestIndex != i) {
		T temp = input[i];
		input[i] = lowestElement;
		input[lowestIndex] = temp;
	    }
	}
	return input;
    }

}
