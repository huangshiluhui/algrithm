package com.offer;

import java.util.LinkedList;
import java.util.Queue;

public class IQ_7_1 {
	Queue<Integer> queue1 = new LinkedList<Integer>();
	Queue<Integer> queue2 = new LinkedList<Integer>();

	public void initQueue(int A[]){
		int i = 0;
		int len = A.length;
		while(i < len){
			queue1.add(A[i]);
			i++;
		}
		queue2.clear();
	}
	public void push(int a) {
		queue1.add(a);
	}

	public int pop() {
		if(queue1.size() == 0){
			try {
				throw new Exception("栈为空！！！");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(queue1.size() != 1){
			queue2.add(queue1.poll());
		}
		int top = queue1.poll();
		while(!queue2.isEmpty()){
			queue1.add(queue2.poll());
		}
		return top;
	}
	
	public static void main(String[] args) {
		IQ_7_1 test = new IQ_7_1();
		int A[] = {1,2,3,4,5,6,7,8,9,0};
		test.initQueue(A);
		test.push(100);
		int top = test.pop();
		System.out.println("top:"+top);
	}
}
