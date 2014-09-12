题目：输入一个整型数组，数组里有正数也有负数。数组中一个或者连续的多个整数组成一个子数组。
求所有子数组的和的最大值。要求时间复杂度为O(n)。
代码如下：
package com.offer.chapter5;

public class IQ_31 {
	public static int  maxSumOfSubArray(int[] array){
		int len = array.length;
		if(len == 0){
			return 0;
		}
		int maxSum = array[0];
		int sum = array[0];
		for(int i = 1; i < len; i ++){
			sum += array[i];
			if(sum < 0){
				sum = 0;
			}
			if(sum > maxSum){
				maxSum = sum;
			}
		}			
		return maxSum;
	}
	public static void main(String[] args) {
		int[] array = {3,-2,3,10,-4,-7,2,-5};
		int max = maxSumOfSubArray(array);
		System.out.println("max:"+max);
	}
}
