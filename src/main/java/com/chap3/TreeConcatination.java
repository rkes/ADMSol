package com.chap3;

public class TreeConcatination {

	public static void main(String[] args) {
		TreeImpl trImpl = new TreeImpl();
		TreeNode root = null;
		root = trImpl.insert(root, 5);
		root = trImpl.insert(root, 6);
		root = trImpl.insert(root, 8);
		root = trImpl.insert(root, 9);
		root = trImpl.insert(root, 3);
		root = trImpl.insert(root, 1);
		
		System.out.println(trImpl.getHeight(root));
		
		System.out.println();
	}

}
