题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1,2,3,3，3，3，4,5}和数字3，
由于3在这个数组中出现了四次，因此输出4
思路：1、我们可以遍历数组，寻找第一次3出现的位置，开始计数，到最后一个3出现，我们可以返回3出现的次数
      2、由于数组是有序的，我们可以利用二分查找找出3第一次出现的位置和最后一次出现的位置，然后两个相减+1就是3出现的次数
代码如下：第一种是我自己写的，代码有点混乱，第二种是按照书上的思路来的，比较清晰
第一种：
package com.offer.chapter6;

public class IQ_38 {
	public int appearTimes(int A[], int x) {
		int len = A.length;
		int low = 0;
		int high = len - 1;
		return getPos(A, x, low, high);
	}

	public int getPos(int A[], int x, int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;
			if (A[mid] > x) {
				return getPos(A, x, low, mid - 1);
			} else if (A[mid] < x) {
				return getPos(A, x, mid + 1, high);
			} else {
				return getHigh(A,x,low,high) - getLow(A,x,low,high)+1;
			}
		}
		return 0;
	}

	public int getLow(int A[], int x, int low, int high) {
		if(low > high){
			return -1;
		}
		if (low == high) {
			return low;
		}
		int mid = (low + high) / 2;
		if (A[mid] >= x) 
			return getLow(A, x, low, mid);
		
	    return getLow(A, x, mid + 1, high);
		
	}

	public int getHigh(int A[], int x, int low, int high){
		if(low > high){
			return -1;
		}
		if (low == high ) {
			return high;
		}
		if((high-low)==1 && A[high]!= A[low]){
			return low;
		}
		int mid = (low + high) / 2;
		if (A[mid] <= x) 
			return getHigh(A, x, mid, high);
		
	    return getHigh(A, x, low, mid - 1);
	}
	public static void main(String[] args) {
		int A[] = { 1, 2, 2, 2, 3, 3, 3, 3, 3, 3,3, 4, 5 };
//		int A[] = {1,2,3,4,5};
		int len = A.length - 1;
		IQ_38 test = new IQ_38();
		int times = test.getPos(A, 3, 0, len);
//		int low = test.getLow(A, 3, 0, len);
//		int high = test.getHigh(A, 3, 0, len);
//		System.out.println("low:"+low);
//		System.out.println("high:" + high);
//		System.out.println("出现的次数为："+(high - low+1));
		System.out.println("出现的次数为："+times);
	}

}
第二种：
package com.offer.chapter6;

public class IQ_38_1 {
	public int getFirstK(int[] A, int k,int low,int high){
		if(low > high){
			return -1;
		}
		int mid = (low + high)/2;
		if(A[mid] == k){
			if(mid == 0 || A[mid-1] != k){
				return mid;
			}
			else{
				high = mid - 1;
			}
		}
		else if(A[mid] > k){
			high = mid - 1;
		}
		else{
			low = mid + 1;
		}
		return getFirstK(A,k,low,high);
	}
	public int getLastK(int[] A, int k,int low,int high){
		if(low > high){
			return -1;
		}
		int mid = (low + high)/2;
		if(A[mid] == k){
			if(mid == high || A[mid+1] != k){
				return mid;
			}
			else{
				low = mid + 1;
			}
		}
		else if(A[mid] > k){
			high = mid - 1;
		}
		else{
			low = mid + 1;
		}
		return getLastK(A,k,low,high);
	}
	public static void main(String[] args) {
		int A[] = { 1, 2, 2, 2, 3, 3, 3, 3, 3, 3,3, 4, 5 };
//		int A[] = {1,2,3,4,5};
		int len = A.length - 1;
		IQ_38_1 test = new IQ_38_1();
		int high = test.getLastK(A, 4, 0, len);
		int low = test.getFirstK(A, 4, 0, len);
		int times = high - low +1;
		System.out.println("出现的次数为："+ times);
	}
}

