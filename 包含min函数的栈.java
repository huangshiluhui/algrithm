题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
在该栈中，调用min、push及pop的时间复杂度都是O(1)。
代码如下：
package com.offer.chapter4;

import java.util.Stack;

public class IQ_21 {
	Stack<DoubleData> stack;
	public IQ_21(){
		stack = new Stack<DoubleData>();
	}
	//得到栈顶元素
	public int getTop(){
		if(stack.isEmpty()){
			return -100;
		}
		else{
			return stack.lastElement().data;
		}
	}
	//得到最小元素
	public int getMin(){
		if(stack.isEmpty()){
			return -100;
		}
		else{
			return stack.lastElement().min;
		}
	}
	

	public void pushX(int d){	
		DoubleData dd = new DoubleData();
		if(stack.isEmpty()){			
			dd.data = d;
			dd.min = d;
			stack.push(dd);
		}
		else{
			int min = getTop();
			if( d > min){
				dd.min = min;
				dd.data = d;				
			}
			else{
				dd.min = d;
				dd.data = d;	
			}
			stack.push(dd);
		}
		
	}
	public DoubleData popTop(){
		if(stack.isEmpty()){
			return null;
		}
		else{
			return stack.pop();
		}
		
	}
	public static void main(String[] args) {
		IQ_21 test = new IQ_21();
		int A[] = {3,4,1,2};
		int len = A.length;
		for(int i = 0; i < len; i ++){
			test.pushX(A[i]);
		}
		int data = test.getTop();
		int min = test.getMin();
		System.out.println("data:"+data+"   min:"+min);
		DoubleData d = test.popTop();
		System.out.println("DoubleData:"+d.data+","+d.min);
		data = test.getTop();
		min = test.getMin();
		System.out.println("data:"+data+"   min:"+min);
		d = test.popTop();
		data = test.getTop();
		min = test.getMin();
		System.out.println("data:"+data+"   min:"+min);
		d = test.popTop();
		data = test.getTop();
		min = test.getMin();
		System.out.println("data:"+data+"   min:"+min);
		d = test.popTop();
		System.out.println("DoubleData:"+d.data+","+d.min);
//		d = test.popTop();
//		System.out.println("DoubleData:"+d.data+","+d.min);
	}
}
