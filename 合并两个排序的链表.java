题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
在这里使用两个无头链表，在使用无头链表的时候要注意第一个结点与后面结点处理方法不一样
代码如下：
package com.offer.chapter3;

public class IQ_17 {
	/*
	 * 合并两个无头链表
	 */
	public ListNode merge(ListNode head1,ListNode head2){
		if(head1 == null ){
			return head2;
		}
		if(head2 == null){
			return head1;
		}
		ListNode p,q,current = null,head = null;
		p = head1;
		q = head2;
		int count = 0;
		while(p != null && q != null){
			count ++;
			if(p.val >= q.val && count == 1 ){
				current = q;
				q = q.next;
			}
			else if(p.val < q.val && count == 1){
				current = p;
				p = p.next;
			}
			if(count == 1){
				head = current;
			}
			if(p.val >= q.val && count > 1){
				current.next = q;
				current = current.next;
				q = q.next;
			}
			else if (p.val < q.val && count > 1){
				current.next = p;
				current = current.next;
				p = p.next;
			}
		}
		if(p != null){
			current.next = p;
		}
		if(q != null){
			current.next = q;
		}
		return head;
	}
	
	public ListNode buildList(int A[]) {
		ListNode head = new ListNode(-1);
		ListNode p = head;
		for (int i = 0; i < A.length; i++) {
			ListNode q = new ListNode(A[i]);
			p.next = q;
			p = q;
		}
		p = head.next;
		return p;
	}
	public void traverse(ListNode head){
		ListNode p = head;
		while(p != null){
			System.out.print(p.val+",");
			p = p.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int A[] = { 1, 3, 4, 5, 8, 9 };
		int B[] = {0,2,6,7,8,10,11,12};
		IQ_17 test = new IQ_17();
		ListNode head1 = test.buildList(A);
		ListNode head2 = test.buildList(B);
		test.traverse(head1);		
		test.traverse(head2);		
		ListNode head = test.merge(head1, head2);
		test.traverse(head);
	}
}
