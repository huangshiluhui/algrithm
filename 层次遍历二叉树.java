题目：从上往下打印出二叉树的节点，同一层的节点按照从左到右的顺序打印。

代码如下所示：

package com.offer.chapter4;

import java.util.LinkedList;

public class IQ_23 {
	public void traverse(TreeNode root){
		if(root == null){
		  return;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode tn = queue.poll();
			System.out.println(tn.val);
			TreeNode left = tn.left;
			if(left != null){
				queue.add(left);
			}
			TreeNode right = tn.right;
			if(right != null){
				queue.add(right);
			}			
		}
	}
}
