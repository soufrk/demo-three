package strings;

public class Lcs {

	public static void main(String[] args) {
		String[] inputs = {"A", "B", "AB", "ABC", "BCD"};
		String result = "";
		System.out.println(findLcs(inputs[0], inputs[2], result));
	}
	
	public static String findLcs(String string1, String string2, String result){
		String lastChar1 = getLastChar(string1);
		String lastChar2 = getLastChar(string2); 
		System.out.println("Last character of String 1:" + lastChar1);
		System.out.println("Last character of String 2:" + lastChar2);
		if(lastChar1.equals(lastChar2)){
			result += lastChar1;
			findLcs(getSubStringWithoutLast(string1), getSubStringWithoutLast(string2), result);			
		} else
		if(!checkStringSingle(string1)){
			findLcs(string1, getSubStringWithoutLast(string2), result);
			findLcs(getSubStringWithoutLast(string1), string2, result);
		}
		return result;
	}
	
	private static String getLastChar(String input){
		String result = "";
		if(input.length() == 1)
			result = input;
		else
			result = input.substring(input.length()-1, input.length()); 
		return result;
	}
	
	private static String getSubStringWithoutLast(String input){
		return input.substring(0, input.length()-1);
	}
	
	private static boolean checkStringSingle(String input){
		return input.length()==1;
	}
	
	private static boolean checkAnyStringSingle(String input1, String input2){
		return (input1.length()==1||input2.length()==1);
	}

}
