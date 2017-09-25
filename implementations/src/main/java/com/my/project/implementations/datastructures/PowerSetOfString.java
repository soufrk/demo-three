package com.my.project.implementations;

/**
 * Power set of String - Take 1
 * @author soufrk
 *
 */
public class PowerSetOfString {

    public static void main(String[] args) {
	String input = "abcd";
	findAnagrams(input);
    }
    
    private static void findAnagrams(String input){
	int size = input.length();
	int max = 1 << size;
	System.out.println("P:" + max);
	int maxBinarySize = Integer.toBinaryString(max-1).length();
	String format = "%0" + maxBinarySize + "d";
	for(int i=0;i<max-1;i++){
	    String binary = String.format(format, Integer.parseInt(Integer.toBinaryString(i+1)));
	    getOutput(binary, input);
	}
    }
    
    private static String getOutput(String binary, String input){
	String result = "";
	int size = input.length();
	for(int i=0; i<size; i++){
	    result += binary.charAt(i)=='1'?input.charAt(i):"";
	}
	System.out.println("Result:" + result);
	return result;
    }

}
