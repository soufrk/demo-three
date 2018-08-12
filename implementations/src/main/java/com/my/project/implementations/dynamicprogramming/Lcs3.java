package com.my.project.implementations.dynamicprogramming;

/**
 * Updated code with single char match
 * 
 * @author soufrk
 *
 */
public class Lcs3 {

	public static void main(String[] args) {
		String[] inputs = { null, "", " ", "A", "B", "AB", "ABC", "BCD" };
		Lcs3 object = new Lcs3();
		/* Null/Empty negative tests - Results in exception */
		//object.findLcs(inputs[0], inputs[0]);
		//object.findLcs(inputs[0], inputs[1]);
		//object.findLcs(inputs[1], inputs[1]);
		//object.findLcs(inputs[1], inputs[2]);
		//object.findLcs(inputs[2], inputs[1]);
		//object.findLcs(inputs[2], inputs[2]);
		//object.findLcs(inputs[2], inputs[3]);
		//object.findLcs(inputs[3], inputs[2]);
		
		/* Positive(Single Char) - Same string match */
		//object.findLcs(inputs[3], inputs[3]);
		//System.out.println(object.findLcs(inputs[3], inputs[3]));
		
		/* Negative(Single Char) - No match */
		//System.out.println(object.findLcs(inputs[3], inputs[4]));
		//System.out.println(object.findLcs(inputs[4], inputs[3]));
		
		/* Positive(Single Char) - Same string match */
		//System.out.println(object.findLcs(inputs[4], inputs[4]));
		
		/* Positive(Single Char, Multi-char) - Single char match */
		//System.out.println(object.findLcs(inputs[3], inputs[5]));
		//System.out.println(object.findLcs(inputs[5], inputs[3]));
		//System.out.println(object.findLcs(inputs[3], inputs[6]));
		//System.out.println(object.findLcs(inputs[6], inputs[3]));
		//System.out.println(object.findLcs(inputs[4], inputs[5]));
		//System.out.println(object.findLcs(inputs[5], inputs[4]));
		//System.out.println(object.findLcs(inputs[4], inputs[6]));
		System.out.println(object.findLcs(inputs[6], inputs[4]));
	}

	private String findLcs(String string1, String string2) {
		String result = "";
		LcsString o1 = new LcsString(string1);
		LcsString o2 = new LcsString(string2);
		if (o1.isNullOrEmpty)
			throw new NullPointerException("Provided String is null/empty");
		if (o2.isNullOrEmpty)
			throw new NullPointerException("Provided String is null/empty");
		/*if(o1.isSingleChar && o2.isSingleChar && o1.lastChar.equals(o2.lastChar)){
			result = o1.lastChar;
		}*/
		if(o1.lastChar.equals(o2.lastChar)){
			result = o1.lastChar; 
			System.out.println("Macth found:" + result);
		}
		if (o1.isSingleChar && o2.isSingleChar) {
			//do nothing
			System.out.println("Exit Point 1");
		} else /*if (!o1.isSingleChar && !o2.isSingleChar)*/{
			result = findLcs(o1.isSingleChar?o1.lastChar:o1.lastSubString, o2.isSingleChar?o2.lastChar:o2.lastSubString);
		}
		return result;
	}

	class LcsString {
		private String value;
		private boolean isNullOrEmpty;
		private boolean isSingleChar;
		private boolean isMultiChar;
		private String lastChar;
		private String lastSubString;

		public LcsString(String value) {
			this.value = value;
			isNullOrEmpty = value != null ? value.trim().isEmpty() : false;
			if (!isNullOrEmpty) {
				isSingleChar = value.length() == 1;
				// isMultiChar = value.length() > 1;
				if (isSingleChar)
					lastChar = value;
				// if(isMultiChar)
				else{
					lastChar = value.substring(value.length() - 1, value.length());
					lastSubString = value.substring(0, value.length() - 1);
				}
			}
		}
	}

}
