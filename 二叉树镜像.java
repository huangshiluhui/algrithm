题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像
方法一：采用递归来实现
package com.offer.chapter4;

public class IQ_19 {
	private TreeNode root;

	public void mirrorRecursively(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirrorRecursively(root.left);
		mirrorRecursively(root.right);
	}

	public void inOrder(TreeNode node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.val+" ");
			inOrder(node.right);
		}
	}

	public void buildTree(TreeNode node, int val) {
		if (root == null) {
			root = new TreeNode(val);
		} else {
			if (val < node.val) {
				if (node.left == null) {
					node.left = new TreeNode(val);
				} else {
					buildTree(node.left, val);
				}
			} else {
				if (node.right == null) {
					node.right = new TreeNode(val);
				} else {
					buildTree(node.right, val);
				}
			}
		}
	}

	public static void main(String[] args) {
		// int[] a = {1,2,3,4,5,6,7,8};
		int[] a = { 2, 4, 12, 45, 21, 6, 111 };
		IQ_19 bTree = new IQ_19();
		for (int i = 0; i < a.length; i++) {
			bTree.buildTree(bTree.root, a[i]);
		}
		bTree.inOrder(bTree.root);
		bTree.mirrorRecursively(bTree.root);
		System.out.println("对比：");
		bTree.inOrder(bTree.root);
	}
}
