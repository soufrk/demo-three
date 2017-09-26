package com.my.project.implementations;

/**
 * Remove duplicate characters from a given string.
 * 
 * @author soufrk
 *
 */
public class RemoveDuplicateCharFromString {

    public static void main(String[] args) {
	String input[] = {"1", "12", "112", "122", "121", "1212",
	"1213", "1232"	
	};
	for(String temp:input)
	    System.out.println(removeDuplicates(temp));

    }
    
    private static String removeDuplicates(String input){
	String tempCopy = input.trim();
	for(int i=0; i<tempCopy.length(); i++){
	    String unit = tempCopy.substring(i, i+1);
	    int copyIndex = tempCopy.lastIndexOf(unit);
	    int existingIndex = tempCopy.indexOf(unit);
	    if(copyIndex > 0 && existingIndex != copyIndex){
		String part1 = tempCopy.substring(0, copyIndex);
		String part2 = tempCopy.substring(copyIndex+1);
		tempCopy = part1 + part2;
	    }
	}
	return tempCopy;
    }

}
