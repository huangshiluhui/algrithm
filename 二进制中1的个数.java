题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数

方法一：需要移位32次才能完成，不一定所有的数都需要移位那么多次
package com.offer;

public class IQ_10_2 {
	public static int countOnes(int n){
		int count = 0;
		int flag = 1;
		while(flag != 0){
			if((n & flag) != 0)
				count++;
			flag = flag<<1;
			System.out.println("flag:"+flag);
		}
		return count;
	}
	public static void main(String[] args) {
		int n = -1;
		int count = countOnes(n);
		System.out.println("count:"+count);
	}
}
方法二：未考虑除法效率不高，这种方法会导致死循环
package com.offer;
/*
 * 这种方法没有考虑负数情况
 */
public class IQ_10_1 {
	public static int countOnes(int n){
		int count = 0;
		while(n != 0){
			if((n & 0x01) == 1)
				count++;
			n = n>>1;
		}
		return count;
	}
	public static void main(String[] args) {
		int n = 15;
		int count = countOnes(n);
		System.out.println("count:"+count);
	}
}

方法三：移位次数根据二进制中1的个数
package com.offer;

public class IQ_10_3 {
	public static int countOnes(int n){
		int count = 0;
		if(n == 0){
			return 0;
		}
		while(n != 0){
			count++;
			n = n&(n-1);
		}
		//count++;
		return count;
	}
	public static void main(String[] args) {
		int n = -1;
		int count = countOnes(n);
		System.out.println("count:"+count);
	}
}

