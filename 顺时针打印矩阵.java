题目：输入一个矩阵，按照从外向里以顺时针依次打印出每一个数字。

代码如下：
这里是我的代码，有点复杂，不是很好：
package com.offer.chapter4;

public class IQ_20 {
	public static void print(int A[][]){
		int row = A.length;
		int column = A[0].length;
		int min = row > column ? column:row;
		int i,j,k,m,n;
		for(i = 0; i < ((min+1)/2); i++){
			for(j = i; j < column-i; j ++){
				System.out.print(A[i][j]+"a ");
			}
//			System.out.println();
			for(k = i+1; k < row-i; k ++ ){
				System.out.print(A[k][column-i-1]+"b ");
			}
//			System.out.println();
			if(i < column-i-1 && i < row - 2){
			for(m = column-i-2; m >= i;m --){
				System.out.print(A[row-i-1][m]+"c ");
			}
			}
		
	//		System.out.println();
			if(i < column - i - 1 && i < row - 2){
			for(n = row-2-i; n > i; n --){
				System.out.print(A[n][i]+"d ");
			}
			}
	//		System.out.println();
		}
	}
	public static void main(String[] args) {
		int m = 5;
		int n = 5;
		int A[][] = new int[m][n];
		int count = 0;
		for(int i = 0; i < m; i ++){
			for(int j = 0; j < n; j ++){
				A[i][j] = count;
				count++;
				System.out.print(A[i][j]+"  ");
			}
			System.out.println();
		}
		print(A);
	}
}

这里是书上的代码：
package com.offer.chapter4;

public class IQ_20_1 {
	public void printClockWisely(int A[][]){
		int column = A[0].length;
		int row = A.length;
		if(A == null){
			return;
		}
		int min = row > column ? column:row;
		int clock = ( min + 1)/2;
		int turns = 0;
		while(turns < clock){
			printMatrixInCircle(A,column,row,turns);
			turns++;
		}
	}
	public void printMatrixInCircle(int A[][],int column,int row,int start){
		int x = column - start - 1;
		int y = row - start - 1;
		//从左到右打印
		for(int i = start; i <= x; i ++){
			System.out.print(A[start][i]+" ");
		}
		//从上到下
		if(start < y){
		for(int i = start+1; i <= y;i ++){
			System.out.print(A[i][x]+" ");
		}
		}
		//从右到左
		if(start < x && start < y){
			for(int i = x - 1; i >= start;i --){
				System.out.print(A[y][i]+" ");
			}
		}
		//从下到上
		if(start < x && start < y){
			for(int i = y-1;i > start; i --){
				System.out.print(A[i][start]+" ");
			}
		}		
	}
	public static void main(String[] args) {
		int m = 6;
		int n = 2;
		int A[][] = new int[m][n];
		int count = 0;
		for(int i = 0; i < m; i ++){
			for(int j = 0; j < n; j ++){
				A[i][j] = count;
				count++;
				System.out.print(A[i][j]+"  ");
			}
			System.out.println();
		}
		IQ_20_1 test = new IQ_20_1();
		test.printClockWisely(A);
	}
}
