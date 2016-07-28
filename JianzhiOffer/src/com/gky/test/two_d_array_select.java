package com.gky.test;

public class two_d_array_select {
	
	public static boolean searche(int[][] array, int target){
		
		int colLength = array.length;
		int rowLength = array[0].length;
		
		if(colLength == 0 || rowLength == 0){
			return false;
		}
		
		for (int i = 0, len = colLength; i < len; i++) {
			if(target <= array[i][rowLength-1]){
				for (int j = rowLength-1; j >= 0; j--) {
					if(target == array[i][j]){
						return true;
					}
				}
			}else{
				continue;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] array = {{1,2,3,4,5,6,7,8,9},{2,3,4,5,6,7,8,9,10}};
		int target = 9;
		System.out.println(searche(array, target));
	}

}
