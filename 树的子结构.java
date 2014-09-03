题目：输入两棵二叉树A和B，判断B是不是A的子结构
二叉树定义如下：
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
代码如下：
package com.offer.chapter3;

public class IQ_18 {
	public static boolean isSubTree(TreeNode root1, TreeNode root2){
		boolean result = false;
		if(root1 != null && root2 != null){
			if(root1.val == root2.val){
				System.out.println("root1.val:"+root1.val);
				result = DoesTree1HaveTree2(root1,root2);
			}	
			if(!result){
				result = isSubTree(root1.left,root2);
			}
			if(!result){
				result = isSubTree(root1.right,root2);
			}
		}			
		return result;
	}
	public static boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2){
		if(root2 == null){
			return true;
		}
		if(root1 == null ){
			return false;
		}		
		if(root1.val != root2.val){
			return false;
		}
		return DoesTree1HaveTree2(root1.left,root2.left)&&
		    DoesTree1HaveTree2(root1.right,root2.right);
	}
	/*
	 * 
	 */
	public static void main(String args[]){
		int int1[] = {9,8,4,2,7,8,7};
		int postt1[] ={9,4,7,2,8,7,8};
		int int2[] = {4,2,7};
		int postt2[] ={4,7,2};
		BuildTree bt = new BuildTree();
		TreeNode root1 = bt.buildTree(int1, postt1);
		TreeNode root2 = bt.buildTree(int2, postt2);
		boolean flag = isSubTree(root1,root2);
		System.out.println("root2 is root1's structure:"+flag);
	}
}
