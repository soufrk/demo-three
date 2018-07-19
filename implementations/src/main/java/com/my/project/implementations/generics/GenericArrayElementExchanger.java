package com.my.project.implementations.generics;

import java.util.Arrays;

public class GenericArrayElementExchanger {

    public static void main(String[] args) {
	Object[][] objectArr = {{1, 2, 3},
		{'A', 'B', 'C'},
		{1.0, 2.0, 3.0},
		{"A", "B", "C"}};
	for(Object[] singleArray:objectArr) {	    
	    System.out.println(Arrays.asList(exchange(singleArray, 0, 1)));
	}
    }

    private static <T> T[] exchange(T[] arr, int indexOne, int indexTwo) {
	if(indexOne < 0)
	    throw new IndexOutOfBoundsException(indexOne + " is less than zero");
	if (indexOne > arr.length)
	    throw new IndexOutOfBoundsException(indexOne + " greater than length");
	if(indexTwo < 0)
	    throw new IndexOutOfBoundsException(indexTwo + " is less than zero");
	if (indexTwo > arr.length)
	    throw new IndexOutOfBoundsException(indexTwo + " greater than length");
	T temp = arr[indexOne];
	arr[indexOne] = arr[indexTwo];
	arr[indexTwo] = temp;
	return arr;
    }

}
