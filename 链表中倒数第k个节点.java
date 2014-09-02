题目：输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
即链表的尾节点是倒数第1个节点。例如一个链表有6个节点，从头结点开始它们的值依次是1、2、3
4、5、6.这个链表的倒数第三个节点是4
代码如下所示：
package com.offer.chapter3;

public class FindKthToTail {
	public static ListNode buildList(int A[]) {
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

	public static ListNode findKthToTail(ListNode head, int k) {
		int count = 0;
		ListNode p = head;
		while (p != null) {
			count++;
			p = p.next;
		}
		if (k > count) {
			return null;
		}
		ListNode q = null;
		p = head;
		int i = 0;
		while (p != null) {
			i++;
			if (i == k) {
				q = head;
			}
			if (q != null && i > k) {
				q = q.next;
			}
			p = p.next;
		}
		return q;
	}

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ListNode head = buildList(A);
//		while (head != null) {
//			System.out.print(head.val+",");
//			head = head.next;
//		}
      ListNode p = findKthToTail(head,9);
      System.out.println(p.val);
	}

}
