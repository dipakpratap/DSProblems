package com.test.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		System.out.println("Height by Recursive");
		int height = heightByRecusrive(root);
		System.out.println("height of tree is :  " + height);
		
		System.out.println("Height by Iterative");
		height = heightByIterative(root);
		System.out.println("Height of tree is : " + height);
		
	}

	private static int heightByIterative(Node root) {
		if(root == null) {
			return 0;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		int height = 0;
		while (true) {
			int nodeCount = queue.size();
			 if(nodeCount == 0)
		        return height;
		    else
		        height++;
			while (nodeCount > 0) {
				Node temp = queue.remove();
				if(temp.left != null) {
					queue.add(temp.left);
				}
				if(temp.right != null) {
					queue.add(temp.right);
				}
				nodeCount--;
			}
		}
	}

	private static int heightByRecusrive(Node root) {
		if(root == null) {
			return 0;
		}
		return Math.max(heightByRecusrive(root.left), heightByRecusrive(root.right) + 1);
	}

}
