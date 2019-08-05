package com.test.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTTraversal {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		System.out.println("Pre order recursive");
		preOrderRecusrive(root);
		System.out.println("");
		
		System.out.println("Pre order iterative");
		preOrderIterative(root);
		System.out.println("");
		
		System.out.println("In order recursive");
		inOrderRecusrive(root);
		System.out.println("");
		
		System.out.println("In order iterative");
		inOrderIterative(root);
		System.out.println("");
		
		System.out.println("Post order recursive");
		postOrderRecusrive(root);
		System.out.println("");
		
		System.out.println("Post order iterative");
		postOrderIterative(root);
		System.out.println("");
		
		System.out.println("Level Order/BFS traversal");
		levelOrderTraversal(root);
	}

	private static void levelOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.remove();
			System.out.print(temp.data + " ");
			if(temp.left != null) {
				queue.add(temp.left);
			}
			if(temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	private static void postOrderIterative(Node root) {
		if(root == null) {
			return;
		}
		
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		
		while (!s1.isEmpty()) {
			Node temp = s1.pop();
			s2.push(temp);
			if(temp.left != null) {
				s1.push(temp.left);
			}
			if(temp.right != null) {
				s1.push(temp.right);
			}
			
		}
		while (!s2.isEmpty()) {
			System.out.print(s2.pop().data + " ");
		}
		
	}

	private static void postOrderRecusrive(Node root) {
		if(root == null) {
			return;
		}
		postOrderRecusrive(root.left);
		postOrderRecusrive(root.right);
		System.out.print(root.data + " ");
	}

	private static void inOrderIterative(Node root) {
		if(root == null) {
			return;
		}
		
		Stack<Node> s = new Stack<Node>();
		Node cur = root;
		while (true) {
			while (cur != null) {
				s.push(cur);
				cur = cur.left;
			}
			if(s.empty()) {
				return;
			}
			cur = s.pop();
			System.out.print(cur.data + " ");
			cur = cur.right;
		}
	}

	private static void inOrderRecusrive(Node root) {
		if(root == null) {
			return;
		}
		
		inOrderRecusrive(root.left);
		System.out.print(root.data + " ");
		inOrderRecusrive(root.right);
		
	}

	private static void preOrderIterative(Node root) {
		if(root == null) {
			return;
		}
		Stack<Node> s = new Stack<>();
		s.push(root);
		while (!s.isEmpty()) {
			Node temp = s.pop();
			System.out.print(temp.data + " ");
			if(temp.right != null) {
				s.push(temp.right);
			}
			if(temp.left != null) {
				s.push(temp.left);
			}
			
		}
	}

	private static void preOrderRecusrive(Node root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		preOrderRecusrive(root.left);
		preOrderRecusrive(root.right);
	}
	
}
class Node{
	Integer data;
	Node left;
	Node right;
	
	public Node(Integer data) {
		super();
		this.data = data;
	}
	
}