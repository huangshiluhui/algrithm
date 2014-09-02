/*
*  根据中序和后序创建二叉树
*/

package com.Tree;

public class BuildTree {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int len1 = inorder.length;
		int len2 = postorder.length;
		TreeNode root = buildSubTree(inorder,0,len1-1,postorder,0,len2-1);		
		return root;
	}
	public TreeNode buildSubTree(int[] inorder, int b1,int e1,int[] postorder,int b2,int e2) {
		if(b1 > e1 || b2 > e2){
			return null;
		}
		TreeNode root = new TreeNode(postorder[e2]);
		int pos = getPosition(root.val,inorder,b1,e1);
		root.left = buildSubTree(inorder,b1,pos-1,postorder,b2,e2-e1+pos-1);
		root.right = buildSubTree(inorder,pos+1,e1,postorder,e2-e1+pos,e2-1);
		return root;		
	}
	public int getPosition(int val,int[] inorder,int begin,int end){
		int index = begin;
		for(int i = begin; i <= end; i ++){
			if(inorder[i] == val){
				index = i;
			}
		}
		return index;
	}
}
