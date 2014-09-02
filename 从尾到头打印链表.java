/*有两种方法实现：
方法一：使用栈来实现*/
package com.offer;

import java.util.Stack;

public class IQ_5_1 {
	public static ListNode buildList(int A[]) {
		ListNode head = new ListNode(-1);
		ListNode p = head;
		for (int i = 0; i < A.length; i++) {
			ListNode q = new ListNode(A[i]);
			p.next = q;
			p = q;
		}
		return head;
	}
	
	public static void traverseList(ListNode head){
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode p = head.next;
		while(p != null){
			stack.push(p);
			p = p.next;
		}
		while(!stack.isEmpty()){
			p = stack.pop();
			System.out.println(p.val);
		}
	}
	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ListNode head = buildList(A);
		traverseList(head);
	}
}


/*方法二：使用递归实现*/
package com.offer;

public class IQ_5 {
	public static ListNode buildList(int A[]) {
		ListNode head = new ListNode(-1);
		ListNode p = head;
		for (int i = 0; i < A.length; i++) {
			ListNode q = new ListNode(A[i]);
			p.next = q;
			p = q;
		}
		return head;
	}

	public static void traverseList(ListNode head) {
		if(head == null){
			return;
		}
		traverseList(head.next);
		System.out.println(head.val);
	}

	public static void main(String[] args) {
		int A[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ListNode head = buildList(A);
		traverseList(head);
	}

}
