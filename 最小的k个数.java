题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8这8个数字，
则最小的四个数字是1、2、3、4
解法一：利用快排的思想（改变了原来的数组）
代码如下：
package com.offer.chapter5;

public class KMinimum {
	public int  partition(int A[],int begin,int end){
		int key = A[begin];
		while(begin < end){
			while(begin < end && key <= A[end]) end --;
			A[begin] = A[end];
			while(begin < end && key >= A[begin]) begin ++;
			A[end] = A[begin];
		}
		A[begin] = key;
		return begin;
	}
	public void quickSort(int A[],int begin,int end,int k){
//		int len = A.length; 
		int privoloc = partition(A,begin,end);
		System.out.println("privoloc:"+privoloc);
		if( k-1 == privoloc ||k == privoloc  ){
			for(int i = 0; i < k; i ++){
				System.out.print(A[i]+" ");
			}
		}
		else if( k < privoloc-1){
			quickSort(A,begin,privoloc-1,k);
		}
		else{
			quickSort(A,privoloc+1,end,k);
		}
	}
	public static void main(String[] args) {
		int A[] = {5,4,1,6,2,7,3,8,9};
		int len = A.length;
		KMinimum test = new KMinimum();
		test.quickSort(A, 0, len-1, 4);
	}
}

方法二：采用最大堆来存储k个数，当遇到一个数比这个堆中最大的数大的时候，我们不需要改变堆，
当遇到一个小于堆中最大数时，我们需要将最大堆的堆顶元素替换掉，然后调整堆的大小，那么时间
复杂度是O(nlogk).
package com.offer.chapter5;

public class KMinimum_1 {
	public void buildHeap(int A[]){
		int len = A.length;
		System.out.println("len:"+len);
		for(int i = len/2-1;i >=0; i --){
			maxHeap(A,i,len);
		}
	}
	public void maxHeap(int[] A,int i,int maxSize){
		int maxIndex = i;
		if(2*i+1 <= maxSize-1 && A[2*i+1]> A[maxIndex]){
			maxIndex = 2*i+1;
		}
		if(2*i+2 <= maxSize-1 && A[2*i+2]> A[maxIndex]){
			maxIndex = 2*i+2;
		}
		if(maxIndex != i){
			int temp = A[i];
			A[i] = A[maxIndex];
			A[maxIndex] = temp;
			maxHeap(A,maxIndex,maxSize);
		}
	}
	public void mainHeap(int[] A){
		int len = A.length;
		for(int i = len-1; i > 0; i --){
			int temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			len = len-1;
//			System.out.println(len-1);
			maxHeap(A,0,len-1);
		}
	}
	
	public static void main(String[] args) {
		KMinimum_1 km = new KMinimum_1();
		int A[] = {5,4,1,6,2,7,3,8,9};
		km.buildHeap(A);
		for(int x : A){
			System.out.print(x+" ");
		}
		km.mainHeap(A);
		System.out.println("排序之后的数组：");
		for(int x : A){
			System.out.print(x+" ");
		}
	}
}


