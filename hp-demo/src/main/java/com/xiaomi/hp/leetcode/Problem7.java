package com.xiaomi.hp.leetcode;

public class Problem7 {

	public static void main(String[] args) {
		
//		int x = 123;
//		int x = -123;
//		int x = 120;
//		int x = 1534236469;
		int x = -2147483648;
		
//		System.out.println(Integer.MIN_VALUE);
		
		Problem7 problem7 = new Problem7();
		int result = problem7.reverse(x);
		System.out.println(result);

	}
	
	 public int reverse(int x) {
		 
		 if (x == 0 || x == Integer.MIN_VALUE) {
			 return 0;
		 }
		 
		 boolean isNegative = false;
		 if (x < 0) {
			 isNegative = true;
			 x = -x;
		 }
		 
		 int[] arr = new int[32];
		 
		 for (int i=0;i<arr.length;i++) {
			 arr[i] = 0;
		 }
		 
		 int index = 0;
		 
		 while(x != 0) {
			 arr[index++] = x % 10;
			 x = x / 10;
		 }
		 
		 int lastIndex = arr.length - 1;
		 for (;lastIndex>=0;lastIndex--) {
			 if (arr[lastIndex] > 0) {
				 break;
			 }
		 }
		 
		 long result = arr[0];
		 for (int i=1;i<=lastIndex;i++) {
			 result = result * 10 + arr[i];
		 }
		 
		 if (isNegative) {
			 result = -result;
		 }
		 
		 if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
			 return 0;
		 }
		 
	     return (int)result;
	    }

}
