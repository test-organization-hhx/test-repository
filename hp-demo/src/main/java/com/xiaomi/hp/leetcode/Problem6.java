package com.xiaomi.hp.leetcode;

public class Problem6 {

	public static void main(String[] args) {
		
		String s = "ABC";
//		String s = "PAYPALISHIRING";
//		int numRows = 3;
//		int numRows = 4;
		int numRows = 2;
		
		Problem6 problem6 = new Problem6();
		String result = problem6.convert(s, numRows);
		System.out.println(result);

	}
	
	public String convert(String s, int numRows) {
		
		if (s == null || s.length() <= 1 || numRows <= 1) {
			return s;
		}
		
		//平均每列元素个数
		double perCloumnNum = (numRows + (numRows - 2.0))/(numRows - 1.0);
		//最大列数量
		int maxColumnNum = (int)(s.length() / perCloumnNum) + 1;
		
		char[][] arr = new char[numRows][maxColumnNum];
		
		for (int j=0;j<maxColumnNum;j++) {
			for(int i=0;i<numRows;i++) {
				arr[i][j] = '0';
			}
		}
		
		int index = 0;
		
		for (int j=0;j<maxColumnNum;j++) {
			
			int mod = j % (numRows - 1);
			
			if (mod == 0) {
				for(int i=0;i<numRows;i++) {
					if (index < s.length()) {
						arr[i][j] = s.charAt(index++);
					}
				}
			} else {
				if (index < s.length()) {
					arr[numRows - 1 - mod][j] = s.charAt(index++);
				}
			}
		}
		
		char[] resultArr = new char[s.length()];
		
		index = 0;
		
		for (int i=0;i<numRows;i++) {
			for (int j=0;j<maxColumnNum;j++) {
				if (arr[i][j] != '0') {
					resultArr[index++] = arr[i][j];
				}
			}
		}
		
		
		String result = new String(resultArr);
		
		
        return result;
    }

}
