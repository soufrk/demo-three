package com.my.project.implementations;

import java.util.Arrays;

/**
 * Merge-sort take 1
 * 
 * @author soufrk
 *
 */
public class MergeSort {

    public static void main(String[] args) {
	int[] input = { 9, 4, 6, 5, 3, 8, 2, 0, 1, 7 };
	sortAscending(input);
	System.out.println(Arrays.toString(input));
	// System.out.println(Arrays.toString(sortDescending(input)));

	Integer[] integers = { 8, 6, 2, 9, 1, 3, 5, 0, 7, 4 };
	// System.out.println(Arrays.toString(sortAscending(integers)));
	// System.out.println(Arrays.toString(sortDescending(integers)));
    }

    private static void sortAscending(int[] input) {
	mergesort(input, 0, input.length - 1);
	// return
    }

    private static int[] mergesort(int[] input, int p, int r) {
	//System.out.println("Merge p=" + p + ", r=" + r);
	if (p < r) {
	    int q = (p + r) / 2;
	    mergesort(input, p, q);
	    mergesort(input, p + 1, r);
	    merge(input, p, q, r);
	}
	return input;
    }

    private static void merge(int[] input, int p, int q, int r) {
	System.out.println("Merge p=" + p + ", q=" + q + ", r=" + r);
	int nL = q - p + 1;
	int nR = r - q;
	int[] leftArray = new int[nL];
	int[] rightArray = new int[nR];
	for (int i = 0; i < nL; i++) {
	    leftArray[i] = input[nL + i - 1];
	}
	for (int i = 0; i < nR; i++) {
	    rightArray[i] = input[q + i];
	}
	for (int i = 0, j = 0, k = p; k < r; k++) {
	    if (leftArray[i] < rightArray[j]) {
		input[k] = leftArray[i];
		i++;
	    } else {
		input[k] = rightArray[j];
		j++;
	    }
	}
    }

}
