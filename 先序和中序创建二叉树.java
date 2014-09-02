/*
 * 根据先序和中序序列创建二叉树
 */
 
 package com.Tree;

public class BuildTree_1 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int len1 = inorder.length;
		int len2 = preorder.length;
		TreeNode root = buildSubTree(inorder,0,len1-1,preorder,0,len2-1);		
		return root;
	}
	public TreeNode buildSubTree(int[] inorder, int b1,int e1,int[] preorder,int b2,int e2) {
		if(b1 > e1 || b2 > e2){
			return null;
		}
		TreeNode root = new TreeNode(preorder[b2]);
		int pos = getPosition(root.val,inorder,b1,e1);
		root.left = buildSubTree(inorder,b1,pos-1,preorder,b2+1,e2-e1+pos);
		root.right = buildSubTree(inorder,pos+1,e1,preorder,e2-e1+pos+1,e2);
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
