package com.test.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeafNodes {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		long sum = sumOfAllLeafNodes(root);
		System.out.println("Sum of all leaf Nodes : " + sum);
		
		
	}

	private static long sumOfAllLeafNodes(Node root) {
		if(root == null) {
			return 0;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int sum = 0;
		while(!queue.isEmpty()) {
			Node temp = queue.remove();
			if(temp.left != null) {
				queue.add(temp.left);
			}
			if(temp.right != null) {
				queue.add(temp.right);
			}
			if(temp.left == null && temp.right == null) {
				sum = sum + temp.data;
			}
		}
		return sum;
	}

}
