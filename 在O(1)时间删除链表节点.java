题目：给定单向链表的头指针和一个节点指针：定义一个函数在O(1)时间删除该节点。
链表的结构定义：
class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { 	
			 val = x; 
			 next = null;
		 }
}
代码如下：
package com.offer.chapter3;

public class IQ_12 {
	/*
	 * 在O(1)时间内删除链表
	 * 需要考虑如下情况
	 * 1、如果是第一个节点
	 * 2、最后一个节点
	 * 3、中间节点
	 */
	public void deleteListNode(ListNode head,ListNode l){
		if(head == null || l == null){
			return;
		}
		if(l == head){
			head = head.next;
			l.next = null;
			l = null;
		}
		if(l.next == null){
			ListNode pre = head;
			while(pre.next != l){
				pre = pre.next;
			}
			pre.next = null;
		}
		ListNode post = l.next;
		l.next = post.next;
		l.val = post.val;
		post = null;
	}
}
