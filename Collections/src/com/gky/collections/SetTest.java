package com.gky.collections;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	public static void main(String[] args) {
		HashSet hs = new HashSet<>();
		hs.add(new A(1));
		hs.add(new A(2));
		hs.add(new A(3));
		hs.add(new A(4));
		hs.add(new A(5));
		System.out.println(hs);//[[1]-hash:32, [2]-hash:33, [3]-hash:34, [4]-hash:35, [5]-hash:36]
		Iterator it = hs.iterator();
		A first = (A) it.next();
		System.out.println(first.id);//ȡ��һ��Ԫ�أ����Ҹı���ID����������HashCodeҲ�ı䣬����洢λ�ò���
		first.id = 2;//�ı���ID��ʹ��HashCode��ڶ�λԪ�����
		System.out.println(hs);//[[1]-hash:33, [2]-hash:33, [3]-hash:34, [4]-hash:35, [5]-hash:36]
//		System.out.println(hs.contains(new A(2)));
		hs.remove(new A(2));//ͨ��hashCode������洢λ�ò�ͨ��equals�����Ƚ���ȣ�ɾ���ڶ���Ԫ��
		//��ʱ���ڵ�һ��Ԫ�ص�λ����ID=1����õ�����������hashCode��ID=2����õ�
		//����������ͨ��new A(1)����new A(2)���޷���λ����һ��Ԫ��
		//new A(1)�ɶ�λ���洢λ�õ�equals��������false
		//new A(2)�޷���λ���洢λ��
		System.out.println(hs);//[[1]-hash:33, [3]-hash:34, [4]-hash:35, [5]-hash:36]
		System.out.println(new A(1));
		System.out.println(hs);
		System.out.println(hs.contains(new A(2)));
		System.out.println(hs.contains(new A(5)));
	}
}
