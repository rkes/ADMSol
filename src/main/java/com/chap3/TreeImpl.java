package com.chap3;

import java.util.Stack;

public class TreeImpl {
	public TreeNode insert(TreeNode root,int data){
		if(root == null){
			return new TreeNode(data);
		}
		else{
			if(root.data>data)
				root.left = insert(root.left,data);
			else
				root.right = insert(root.right,data);
		}
		root.height = Math.max(getHeight(root.left), getHeight(root.right))+1;
		int factor = getBalanceFactor(root);
		if(factor > 1 && data < root.left.data){
			return rotateRight(root); 
		}
		if(factor < -1 && data > root.right.data )
			return rotateLeft(root);
		if(factor > 1 && data > root.left.data){
			root.left = rotateLeft(root.left);
			return rotateRight(root);
		}
		if(factor < -1 && data < root.right.data){
			root.right = rotateRight(root.right);
			return rotateLeft(root);
		}
		return root;
	}
	
	public TreeNode rotateRight(TreeNode node){
		TreeNode x = node.left;
		TreeNode y = x.right;
		node.left = y; 
		x.right = node;
		node.height = Math.max(getHeight(node.left), getHeight(node.right))+1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right))+1;
		return x;
	}
	public TreeNode rotateLeft(TreeNode node){
		TreeNode x = node.right;
		TreeNode y = x.left;
		x.left = node;
		node.right = y;
		node.height = Math.max(getHeight(node.left), getHeight(node.right))+1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right))+1;
		return x;
	}
	public int getBalanceFactor(TreeNode node){
		if(node ==null)
			return 0;
		return getHeight(node.left)-getHeight(node.right);
	}
	public int getHeight(TreeNode node){
		if(node == null)
			return 0;
		return node.height;
	}
}
class TreeNode{
	TreeNode left;
	int data;
	TreeNode right;
	int height;
	public TreeNode(int data){
		this.data = data;
	}
	public TreeNode(){
		
	}
	public String toString(){
		Stack<TreeNode> stck = new Stack<TreeNode>();
		StringBuilder sBuilder = new StringBuilder();
		TreeNode temp = this;
		while(temp!=null){
			stck.push(temp);
			temp = temp.left;
		}
		while(stck.size()>0){
			temp = stck.pop();
			sBuilder.append(temp.data).append(" ");
			if(temp.right!=null){
				temp = temp.right;
				while(temp!=null){
					stck.push(temp);
					temp = temp.left;
				}
			}
		}
		return sBuilder.toString();
	}
	
}
