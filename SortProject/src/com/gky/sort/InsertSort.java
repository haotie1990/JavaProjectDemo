package com.gky.sort;


public class InsertSort {
	
	/**
	 * 插入排序
	 * 空间复杂度 O(1)
	 * 时间复杂度O(n2),正序情况下O(n)
	 * @param values
	 */
	public static void Sort(int[] values) {

		for (int i : values) {
			System.out.print(i+" ");
		}
		System.out.println("");
		for (int i = 2; i < values.length; i++) {
			if (values[i] < values[i-1]) {//若大于有序区中的所有数据,则保留原位置不动
				values[0] = values[i];//设置哨兵,保存数据i
				int j = i-1;
				do {
					values[j+1] = values[j];
					j--;
				} while (values[0] < values[j]);//由于采用index为0的位置作为哨兵，则一旦越界j=0,则会和哨兵自己比较，跳出循环，避免每次都要判断越界
				values[j+1] = values[0];
			}
		}
		/*
		for (int i = 1; i < values.length; i++) {
			if (values[i] < values[i-1]) {//若大于有序区中的所有数据,则保留原位置不动
				int key = values[i];//设置哨兵,保存数据i
				for (int j = i-1; j >= 0; j--) {
					if (key < values[j]) {
						values[j+1] = values[j];
						values[j] = key;
					}
				}
			}
		}
		*/
		for (int i : values) {
			System.out.print(i+" ");
		}
		System.out.println("");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = new int[]{-1,3,2,8,5,9,6,1,7,4};
		InsertSort.Sort(values);
	}

}
