package com.my.project.implementations.generics;

import java.util.Arrays;
import java.util.List;

public class FindHighestInSubList {
	
	public static void main(String args[]){
		List<Integer> listOfIntegers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		System.out.println(findMax(listOfIntegers, 0, 2));
		System.out.println(findMax(listOfIntegers, 1, 3));
	}
	
	public static <T extends Comparable<T>> T findMax(List<T> list, int begin, int end){
		T result = null;
		if(begin < 0)
		    throw new IndexOutOfBoundsException(begin + " is less than zero");
		if (begin > list.size())
		    throw new IndexOutOfBoundsException(begin + " greater than length");
		if(end < 0)
		    throw new IndexOutOfBoundsException(end + " is less than zero");
		if (end > list.size() + 1)
		    throw new IndexOutOfBoundsException(end + " greater than length");
		if (begin > end)
			throw new IndexOutOfBoundsException("begin-index greater than end-index");
		if (begin == end)
			result = list.get(begin);
		else{
			T highest = list.get(begin);
			for(int counter = begin+1; counter<=end; counter++) {
				T current = list.get(counter);
				if(current.compareTo(highest) > 0)
					highest = current;
			}
			result = highest;
		}
		return result;
	}

}
