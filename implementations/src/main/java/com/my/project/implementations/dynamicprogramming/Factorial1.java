package com.my.project.implementations.dynamicprogramming;

/**
 * Sample implementation of Factorial - iteration vs recursion.
 * 
 * @author soufrk
 *
 */
public class Factorial1 {

	public static void main(String[] args) {
		int[] numbers = {0, 1, 2, 3, 4, 5};
		//System.out.println(calculateByIterarion(numbers[3]));
		System.out.println(calculateByRecursion(numbers[3]));
	}
	
	private static long calculateByIterarion(int number){
		long result = 1;
		if(number < 0)
			throw new IllegalArgumentException("Number cannot be negative");
		/*if(number == 0)
			result = 1;*/
		if(number > 1){
			for(int i=1; i<=number;i++)
				result *= i;
		}
		return result;
	}
	
	private static long calculateByRecursion(int number){
		long result = 1;
		if(number < 0)
			throw new IllegalArgumentException("Number cannot be negative");
		if(number == 0)
			result = 1;
		if(number == 1){
			result = 1;
		} else{
			result = number * calculateByRecursion(number-1);
		}
		return result;
	}

}
