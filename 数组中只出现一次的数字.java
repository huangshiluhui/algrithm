题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次，请写出程序来找出这两个只出现了一次的数字。
要求时间复杂度为O(n),空间复杂度为O(1).
代码如下：
package com.offer.chapter6;

public class IQ_40 {
	/*
	 * 返回乘积中从低位开始第一位出现1的位置，从0开始计
	 * 注意移位运算和按位与和按位异或
	 */
	public int getPosOfFirstOne(int A[]){
		int len = A.length;
		int result = A[0];
		for(int i = 1; i < len; i ++){
			result ^=A[i];
			System.out.println(result);
		}
		int index = 0;
        while((result & 0x01) == 0 && index < 32){
        	result = result>>1;
		    index++;
        }
		return index;
	}
	public boolean isOne(int num,int index){
		return ((num>>(index))&0x01) == 1;
	}
	public void getTwoAppearOne(int A[]){
		int index = getPosOfFirstOne(A);
		int num1 = 0, num2 = 0;
		for(int i = 0; i < A.length; i ++){
			if(isOne(A[i],index)){
				num1 ^= A[i];
			}
			else{
				num2 ^=A[i];
			}
		}
		System.out.println("num1:"+num1+"   "+"num2:"+num2);
	}
	public static void main(String[] args) {
		int A[] = {2,4,7,8,7,2,5,5};
		IQ_40 test = new IQ_40();
		int index = test.getPosOfFirstOne(A);
		System.out.println("index:"+index);
		test.getTwoAppearOne(A);
	}
}
