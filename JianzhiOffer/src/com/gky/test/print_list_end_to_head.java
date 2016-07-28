package com.gky.test;

import java.util.ArrayList;
import java.util.Stack;


public class print_list_end_to_head {
	
	static class ListNode{
		
		int value;
		
		ListNode next = null;

		public ListNode(int value) {
			this.value = value;
		}
	}
	
	public static void printListFromEndToHead(ListNode listNode){
		
		//以下为翻转链表
//		ListNode nNode = head.next;
//		ListNode pNode = head;
//		pNode.next = null;
//		while(nNode.next != null){
//			ListNode temp = nNode.next;
//			nNode.next = pNode;
//			pNode = nNode;
//			nNode = temp;
//		}
//		nNode.next = pNode;
//		return nNode;
		
		// 利用栈的后进先出的特性
		Stack<ListNode> stack = new Stack<>();
		
		if(null == listNode){
			return;
		}
		
		ListNode node = listNode;
		while(node.next != null){
			stack.push(node);
			node = node.next;
		}
		stack.push(node);
		
		node = stack.pop();
		while(!stack.isEmpty()){
			node = stack.pop();
			System.out.println(node.value);
		}
	}
	
	// 递归
	public static void pintFromETS(ListNode node){
		if(node != null){
			if(node.next != null){
				pintFromETS(node.next);
			}
		}
		System.out.println(node.value);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = null;
		
		pintFromETS(null);
//		printListFromEndToHead(one);
	}

}
