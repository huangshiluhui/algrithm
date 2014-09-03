题目：定义一个函数，输入一个链表的头结点，反转该链表并输出翻转后链表的头结点。
分析：当链表为空的时候，和链表中只有一个节点的时候，不需要反转
以下我写的分两种情况，主要是因为我对无头结点和有头结点操作不是很熟悉，因此将这两种都写下来了
代码一：有头结点的
package com.offer.chapter3;

public class IQ_16 {
	/*
	 * 有头结点的情况
	 */
	public void reverseList(ListNode head){
		if(head == null || head.next == null||head.next.next == null){
			return;
		}
		ListNode p = head.next;
		ListNode q = p.next;
		ListNode current;
		p.next = null;
		while(q != null){
			current = q.next;
			q.next = p;
			head.next = q;
			p = q;
			q = current;
		}		
	}
	public static void main(String[] args) {
		IQ_5 test = new IQ_5();
		int A[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ListNode head = test.buildList(A);
		test.traverseList(head);
		System.out.println();
		IQ_16 t = new IQ_16();
		t.reverseList(head);
		test.traverseList(head);
	}
}
代码二：无头结点的情况
package com.offer.chapter3;

public class IQ_16_1 {
	/*
	 * 无头结点的情况
	 */
	public ListNode reverseList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode post = head;
		ListNode pre = head.next;
		post.next = null;
		ListNode current;
		while(pre != null){
			current = pre.next;
			pre.next = post;
			post = pre;
			pre = current;
		}
		return post;
	}
	public static void main(String[] args) {
		IQ_5 test = new IQ_5();
		int A[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ListNode head = test.buildList(A);
		test.traverseList(head);
		System.out.println();
		IQ_16_1 t = new IQ_16_1();
		ListNode post = t.reverseList(head);
		test.traverseList(post);
	}
}
