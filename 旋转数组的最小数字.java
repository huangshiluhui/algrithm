题目：把一个数组最开始的若干个数搬到数组末尾，我们称之为数组的旋转。
输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组
{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
下面有两种方法来做：递归和循环
方法一：递归
package com.offer;

public class IQ_8_1 {
	/*
	 * 采用递归实现
	 */
	public int minOfRotateArray(int A[],int begin,int end){
		int len= A.length;
		if(len == 0){
			try {
				throw new Exception("数组为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(len == 1){
			return A[0];
		}
		int mid = (begin+end)/2;
		if(A[mid]> A[begin]){
			return minOfRotateArray(A,mid,end);
		}
		else{
			return minOfRotateArray(A,begin,mid);
		}
	}
	public static void main(String[] args) {
		int A[] = {7,8,9,1,2,3,4,5,6};
		IQ_8 test = new IQ_8();
		int min = test.minOfRotateArray(A);
		System.out.println("min:"+min);
	}
}


方法二：循环实现
package com.offer;

public class IQ_8 {
	/*
	 * 采用循环
	 */
	public int minOfRotateArray(int A[]){
		int len = A.length;
		int mid ;
		int begin = 0;
		int end = len - 1;
		int min = A[0];
		while(begin < end){
			mid = (begin+end)/2;
			if(A[mid] > A[begin]){
				begin = mid ;
			}
			else{
				end = mid;
			}
			if(min > A[mid]){
			    min = A[mid];
			   }
		}
		return min;
	}
	public static void main(String[] args) {
		int A[] = {4,5,6,7,8,9,1,2,3};
		IQ_8 test = new IQ_8();
		int min = test.minOfRotateArray(A);
		System.out.println("min:"+min);
	}
}
