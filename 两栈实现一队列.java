package com.offer;

import java.util.Stack;

public class IQ_7 {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	public void initStack(int A[]){
		int i = 0;
		int len = A.length;
		System.out.println("len:"+len);
		while(i < len){
			stack1.push(A[i]);
			i ++;
		}
		stack2.clear();
	}
	public void appendTail(Integer p){
		stack1.push(p);
	}
	public int deleteHead(){
		while(!stack1.isEmpty()){
			int i = stack1.pop();
			System.out.println("i"+i);
			stack2.push(i);
		}
		System.out.println("huahau");
		if(stack2.isEmpty()){
			try {
				throw new Exception("队列为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return stack2.pop();
	}
	
	public static void main(String[] args) {
		int A[] = {1,2,3,4,5,6,7,8,9,0};
		//int A[]={};
		IQ_7 test = new IQ_7();
		test.initStack(A);
		
		test.appendTail(100);
		int head = test.deleteHead();
	    System.out.println("头结点为："+head);
	}
}
