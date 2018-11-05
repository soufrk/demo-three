package com.my.project.implementations.dynamicprogramming;

/**
 * Take 2 Starting with the negative cases - null/empty Adding utility inner
 * class
 * 
 * @author soufrk
 *
 */
public class Lcs2 {

    public static void main(String[] args) {
	String[] inputs = { null, "", " ", "A", "B", "AB", "ABC", "BCD" };
	Lcs2 object = new Lcs2();
	// object.findLcs(inputs[0], inputs[0]);
	// object.findLcs(inputs[0], inputs[1]);
	// object.findLcs(inputs[1], inputs[1]);
	// object.findLcs(inputs[1], inputs[2]);
	// object.findLcs(inputs[2], inputs[1]);
	// object.findLcs(inputs[2], inputs[2]);
	object.findLcs(inputs[2], inputs[3]);
	// object.findLcs(inputs[3], inputs[2]);
	// object.findLcs(inputs[3], inputs[3]);
    }

    private void findLcs(String string1, String string2) {
	LcsString o1 = new LcsString(string1);
	LcsString o2 = new LcsString(string2);
	if (o1.isNullOrEmpty)
	    throw new NullPointerException("Provided String is null/empty");
	if (o2.isNullOrEmpty)
	    throw new NullPointerException("Provided String is null/empty");
    }

    class LcsString {
	private String value;
	private boolean isNullOrEmpty;
	private boolean isSingleChar;
	private boolean isMultiChar;
	private String lastChar;

	public LcsString(String value) {
	    this.value = value;
	    isNullOrEmpty = value != null ? value.trim().isEmpty() : false;
	    if (!isNullOrEmpty) {
		isSingleChar = value.length() == 1;
		// isMultiChar = value.length() > 1;
		if (isSingleChar)
		    lastChar = value;
		// if(isMultiChar)
		else
		    lastChar = value.substring(value.length() - 1, value.length());
	    }
	}
    }

}
