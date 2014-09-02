题目：输入两个链表，找出它们的第一个公共节点。
链表定义如下：
public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { 	
			 val = x; 
			 next = null;
		 }

}

代码如下(代码风格不是很好)：
package com.offer.chapter5;

public class IQ_37 {
	public ListNode findFirstCommonNode(ListNode head1,ListNode head2){
		int len1 = 0;
		int len2 = 0;
		ListNode p = head1;
		ListNode q;
		while(p != null){
			len1++;
			p = p.next;
		}
		p = head2;
		while(p != null){
			len2++;
			p = p.next;
		}
		if(len1 >= len2){
			int dif = len1 - len2;
			int i = 0;
			p = head1;
			while(i < dif){
				p = p.next;
				i ++;
			}
			q = head2;
			while(p != q){
				p = p.next;
				q = q.next;
			}
			return p;
		}
		else{
			int dif = len1 - len2;
			int i = 0;
			p = head2;
			while(i < dif){
				p = p.next;
				i ++;
			}
			q = head1;
			while(p != null && q != null && p != q ){
				p = p.next;
				q = q.next;
			}
			return p;
		}
	}
}
