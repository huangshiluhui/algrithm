题目：
代码如下：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如，序列1、2、3、4、5是某栈的压栈序列，序列4、5、3、2、1是
该压栈序列对应的一个弹出序列，但4、3、5、1、2就不可能是该呀栈序列的弹出序列。

package com.offer.chapter4;

import java.util.Stack;

public class IQ_22 {
	public boolean popStack(int A[],int B[]){
	    boolean flag = false;
		Stack<Integer> stack = new Stack<Integer>();
		int len_a = A.length;
		int len_b = B.length;
		if(len_a != len_b){
			return flag;
		}
		int j = 0;
		int i = 0;
		while(j < len_b){
			if(stack.isEmpty()||stack.lastElement() != B[j]){
				if(i <= len_a-1){
				stack.push(A[i]);
				i++;
				}
				else{
					flag = false;
					break;
				}
			}
			else{
				stack.pop();
				j++;
			}
		}
		if(j == len_b ){
			flag = true;
		}		
		return flag;
	}
	public static void main(String[] args) {
		int A[] = {1,2,3,4,5};
		int B[] = {4,3,5,1,2};
		IQ_22 test = new IQ_22();
		boolean flag =test.popStack(A, B);
		System.out.println("flag:"+flag);
	}
}
