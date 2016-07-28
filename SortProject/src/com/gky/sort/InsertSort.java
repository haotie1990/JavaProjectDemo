package com.gky.sort;


public class InsertSort {
	
	/**
	 * ��������
	 * �ռ临�Ӷ� O(1)
	 * ʱ�临�Ӷ�O(n2),���������O(n)
	 * @param values
	 */
	public static void Sort(int[] values) {

		for (int i : values) {
			System.out.print(i+" ");
		}
		System.out.println("");
		for (int i = 2; i < values.length; i++) {
			if (values[i] < values[i-1]) {//�������������е���������,����ԭλ�ò���
				values[0] = values[i];//�����ڱ�,��������i
				int j = i-1;
				do {
					values[j+1] = values[j];
					j--;
				} while (values[0] < values[j]);//���ڲ���indexΪ0��λ����Ϊ�ڱ�����һ��Խ��j=0,�����ڱ��Լ��Ƚϣ�����ѭ��������ÿ�ζ�Ҫ�ж�Խ��
				values[j+1] = values[0];
			}
		}
		/*
		for (int i = 1; i < values.length; i++) {
			if (values[i] < values[i-1]) {//�������������е���������,����ԭλ�ò���
				int key = values[i];//�����ڱ�,��������i
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
