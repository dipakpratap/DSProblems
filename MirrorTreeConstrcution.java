package com.test.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTreeConstrcution {

	public static void main(String[] args) {
		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		inorder(root);
		System.out.println("");
		constructMirror(root);
		inorder(root);
	}

	
	private static void  constructMirror(BTNode root) {
		if(root == null) {
			return;
		}
		Queue<BTNode> queue = new LinkedList<BTNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BTNode curr = queue.remove();
			BTNode temp = curr.right;
			curr.right = curr.left;
			curr.left = temp;
			if(curr.left != null) {
				queue.add(curr.left);
				
			}
			
			if(curr.right != null) {
				queue.add(curr.right);
			}
		}
		
	}


	private static void inorder(BTNode root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}


	private static Node constructMirror() {
		return null;
	}
	
	
}
class BTNode{
	Integer data;
	BTNode left;
	BTNode right;
	
	public BTNode(Integer data) {
		this.data = data;
	}
}