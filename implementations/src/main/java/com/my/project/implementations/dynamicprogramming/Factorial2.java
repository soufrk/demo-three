package com.my.project.implementations.dynamicprogramming;

/**
 * Dynamic programming implementation of Factorial - tabulation vs memoization.
 * 
 * @author soufrk
 *
 */
public class Factorial2 {

    public static void main(String[] args) {
	int[] numbers = { 0, 1, 2, 3, 4, 5 };
	System.out.println(calculateByTabulation(numbers[4]));
	System.out.println(calculateByMemoization(numbers[4]));
    }

    /**
     * Bottom-up approach
     */
    private static long calculateByTabulation(int number) {
	long[] factorials = new long[number+1];
	if (number < 0)
	    throw new IllegalArgumentException("Number cannot be negative");
	factorials[0] = 1;
	if (number > 0) {
	    for (int i = 1; i <= number; i++)
		factorials[i] = factorials[i-1] * i;
	}
	return factorials[number];
    }

    /**
     * Top-down approach
     */
    private static long calculateByMemoization(int number) {
	long[] factorials = new long[number+1];
	if (number < 0)
	    throw new IllegalArgumentException("Number cannot be negative");
	//if (number == 0)
	factorials[0] = 1;
	if (factorials[number] == 0) {
	    buildFactorialMemo(factorials, number);
	}
	return factorials[number];
    }

    private static long buildFactorialMemo(long[] factorials, int number) {
	if (factorials[number] == 0){
	    factorials[number] = number * buildFactorialMemo(factorials, number-1);
	}
	return factorials[number];
    }

}
