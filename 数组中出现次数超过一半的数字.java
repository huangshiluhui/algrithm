题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为11的数组
{1,2,3,2,2,2,5,4,2,2,5}。由于数字2在数组中出现了6次，超过数组程度的一半，因此输出2。
代码如下：
package com.offer.chapter5;

public class IQ_29 {
	public int found(int A[]){
		int len = A.length;
		int flag = A[0];
		int count = 0;
		if(len == 0){
			return 0;
		}
		for(int i = 1; i < len; i ++){
			if(A[i] == flag){
				count++;
			}
			else {
				if(count == 0){
				    flag = A[i];
			    }
				else{
					count--;
				}
				
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		int A[] = {1,2,3,2,2,2,5,4,2,2,5};
		IQ_29 test = new IQ_29();
		int result = test.found(A);
		System.out.println("result:"+result);
	}
}
