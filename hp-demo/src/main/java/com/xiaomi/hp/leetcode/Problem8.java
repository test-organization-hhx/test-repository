package com.xiaomi.hp.leetcode;

public class Problem8 {

	public static void main(String[] args) {
		
//		String str = "42";
//		String str = "   -42";
//		String str = "4193 with words";
//		String str = "words and 987";
//		String str = "-91283472332";
//		String str = "+";
//		String str = "20000000000000000000";
//		String str = "-abc";
		String str = "  0000000000012345678";
		
		Problem8 problem8 = new Problem8();
		int result = problem8.myAtoi(str);
		System.out.println(result);

	}
	
	public int myAtoi(String str) {
		
		if (str == null || str.length() == 0) {
			return 0;
		}
		
		char firstChar = ' ';
		int firstIndex = 0;
		for (int i=0;i<str.length();i++) {
			char tmp = str.charAt(i);
			if (tmp != ' ') {
				firstChar = tmp;
				firstIndex = i;
				break;
			}
		}
		
		boolean valid = (firstChar == '+' || firstChar == '-' || (firstChar > '0' && firstChar <= '9'));
		if (!valid) {
			return 0;
		}
		
		boolean isNegative = false;
		if (firstChar == '+') {
			firstIndex = firstIndex + 1;
		} else if(firstChar == '-') {
			isNegative = true;
			firstIndex = firstIndex + 1;
		}
		
		if (firstIndex < str.length() && (str.charAt(firstIndex) < '1' || str.charAt(firstIndex) > '9')) {
			return 0;
		}
		
		int lastIndex = firstIndex;
		for (int i=firstIndex+1;i<str.length();i++) {
			char tmp = str.charAt(i);
			if (tmp >= '0' && tmp <= '9') {
				lastIndex = i;
			} else {
				break;
			}
		}
		
		if (lastIndex >= str.length()) {
			return 0;
		}
		
		String min = String.valueOf(Integer.MIN_VALUE);
		
		int maxLength = min.length() + 1;
		
		String resultStr = str.substring(firstIndex, lastIndex + 1);
		
		if (resultStr.length() > maxLength){
			if (isNegative) {
				return Integer.MIN_VALUE;
			} else {
				return Integer.MAX_VALUE;
			}
		}
		
		long result = Long.parseLong(str.substring(firstIndex, lastIndex + 1));
		
		if (isNegative) {
			result = -result;
		}
		
		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} 
		
		if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		
        return (int)result;
    }

}
