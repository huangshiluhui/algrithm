public class IQ_3 {
	/*
	 * 判断一个二维数组里面，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下
	 * 的顺序排列。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否存在 该整数。
	 */
	/*
	 * m为行，n为列
	 */
	public static Boolean isExist(int A[][], int num) {
		Boolean flag = false;
		int i, j;
		int row = A.length;
		int column = A[0].length;
		System.out.println(row+":"+column);
		for (i = column - 1, j = 0; i >= 0 && j < row;) {
			//System.out.println();
			if (A[j][i] == num) {
				flag = true;
				break;
			} else if (A[j][i] > num) {
				i--;
			} else {
				j++;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		int A[][] = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		for(int i =0;i < 4; i ++){
			for(int j = 0; j < 4; j ++){
				System.out.print(A[i][j]+",");
			}
			System.out.println();
		}
		Boolean flag = isExist(A,3);
		System.out.println("flag:"+flag);
	}
}
