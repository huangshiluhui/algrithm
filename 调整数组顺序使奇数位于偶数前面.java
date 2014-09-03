题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，
所有偶数位于数组的后半部分
有两种方法，但是这两种方法均采用两个指针来实现
第一种方法类似快排，第二种方法是前后指针，一个指向已经是排好序的尾指针，一个是寻找节点插入到有序列表的末尾
第一种方法：
package com.offer.chapter3;

public class IQ_12 {
	/*
	 * 调整数组顺序使奇数位于偶数前面
	 * 这里采用快排思想来实现,但是这里改变了原来数组之间的顺序
	 */
	public void partition(int A[]){
		int len = A.length;
		int low = 0;
		int high = len - 1;
		int temp;
		while(low < high){
			while(low < high && (A[high]&0x01) == 0) high --;
			while(low < high && (A[low]&0x01) != 0) low ++;
			temp = A[high];
			A[high] = A[low];
			A[low] = temp;
		}
	}
	public void traverse(int A[]){
		int len = A.length;
		for(int i = 0; i < len; i ++){
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int A[] = {1,2,3,4,5,6,7,8,9};
		IQ_12 test = new IQ_12();
		test.traverse(A);
		test.partition(A);
		test.traverse(A);
	}
}
第二种方法：
package com.offer.chapter3;

public class IQ12_1 {
	public void reOrder(int A[]){
		int len = A.length;
		int pre = 0; 
		int post = 0;
		int i = 0;
		int temp;
		for(i = 0 ; i < len; i ++){
			if(isOdd(A[i])==1){
				if(pre != post){
					swap(A,pre,post);
				}
				pre ++;
				post++;
			}
			else{
				pre++;
			}
		}
	}
	public  void swap(int[] data,int index1,int index2){
		   int tmp = data[index1];
		   data[index1] = data[index2];
		   data[index2] = tmp;
		}
	/*
	 * 判断一个整数是否为奇数或者偶数
	 */
	public int isOdd(int num){
		if((num&0x01) != 0){
			return 1;
		}
		return 0;
	}
	public void traverse(int A[]){
		int len = A.length;
		for(int i = 0; i < len; i ++){
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int A[] = {1,2,3,4,5,6,7,8,9};
		IQ12_1 test = new IQ12_1();
		test.traverse(A);
		test.reOrder(A);
		test.traverse(A);
	}
}
