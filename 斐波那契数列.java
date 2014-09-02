题目：写一个函数，输入n，求斐波那契数列的第n项
有两种做法，一种是采用递归，这种方法的弊端就是当递归层次很深的时候会导致栈溢出。
方法一：递归
package com.offer;
/*
 * 斐波那契数列
 * 采用递归
 */
public class IQ_9 {	
	public static int fibonacci(int n){
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
	public static void main(String[] args) {
		int val = fibonacci(6);
		System.out.println("val:"+val);
	}
}
方法二：利用前面计算的结果，循环计算后面的值
这是我自己写的，采用了一个数组，后来发现数组不是必须的，没有必要保存所有的值，只需要保存第n项的前两项就行了
package com.offer;
/*
 * 斐波那契数列
 * 采用递归
 */
public class IQ_9_1 {
	public static int fibonacci(int n){
		int result[] = new int[n+1];
        result[0] = 0;
		result[1] = 1;
		int i;
		for(i = 2; i <= n; i ++){
			result[i] = result[i-1]+result[i-2];
		}
		return result[n];
	}
	
	public static void main(String[] args) {
		int val = fibonacci(6);
		System.out.println("val:"+val);
	}
}
优化的方法，只保存每项的前两项就行了，代码如下所示：
package com.offer;

public class IQ_9_2 {
	public static int fibonacci(int n){
	    if(n == 0){
	    	return 0;
	    }
	    if(n == 1){
	    	return 1;
	    }
        int fibone = 0;
		int fibtwo = 1;
		int fibN= 0;
		int i;
		for(i = 2; i <= n; i ++){
			fibN = fibone+fibtwo;
			fibone = fibtwo;
			fibtwo = fibN;
		}
		return fibN;
	}
	
	public static void main(String[] args) {
		int val = fibonacci(6);
		System.out.println("val:"+val);
	}
}

