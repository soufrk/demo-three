package com.my.project.implementations;

import java.util.Arrays;

public class SweepZerosTake1 {

    public static void main(String[] args) {
	int[][] input = {{1, 0, 2, 4},{1, 0, 2, 4, 0}, {0, 5, 7, 0, 0, 1}};
	for(int[] s:input)
	    System.out.println(Arrays.toString(sweepZerosToRight(s)));
    }

    private static int[] sweepZerosToRight(int[] input) {
	int nonZeroLength = input.length;
	for (int i = 1; i < nonZeroLength; i++) {
	    int j = i;
	    if (input[j - 1] == 0) {
		int temp = input[j - 1];
		while (j < nonZeroLength) {
		    input[j - 1] = input[j];
		    j++;
		}
		input[j-1] = temp;
		nonZeroLength--;
	    }
	}
	return input;
    }

}
