package com.sachin.pratice.collection.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class CustomBST {
	Queue<Integer> queue = new LinkedList<>();
	Node root = null;
	int max_level = 0;
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
		}
	}
	
	private void inOrderTraversal(){
		inOrderTraversal(root);	
	}
	
	//Inorder (Left, Root, Right) 
	private void inOrderTraversal(Node node){
		if(node == null)
			return;
		inOrderTraversal(node.left);
		
		System.out.println(node.data+" ");
		
		inOrderTraversal(node.right);
	}
	
	//Postorder (Left, Right, Root)s
	private void postOrderTraversal(Node node){
		
		if(node == null)
			return;
		
		postOrderTraversal(node.left);
		
		postOrderTraversal(node.right);
		
		System.out.println(node.data);
	}
	
	//Preorder (Root, Left, Right)
	private void preOrderTraversal(Node node){
		if(node == null)
			return;
		
		System.out.println(node.data);
		
		preOrderTraversal(node.left);
		
		preOrderTraversal(node.right);
	}
	
	
	public Node searchRecursive(Node root, int key) {
		if (root == null || root.data == key)
			return root;
		if (root.data > key)
			return searchRecursive(root.left, key);
		else
			return searchRecursive(root.right, key);
	}

	public Node searchIterative(int key){
	
		Node current = root;
		
		while(current != null){
			if(current.data == key)
				return current;
			
			if(current.data > key)
				current = current.left;
			else
				current = current.right;
			
			if(current == null)
				return null;
		}
		return current;
	}
	
	public void insert(int data){
	 root = insertRecursive(root, data);
	}
	
	public Node insertRecursive(Node root, int data){
		Node newNode = new Node(data);
		if(root == null) {
			root = newNode;
			return root;
		}
		if(data < root.data){
			root.left = insertRecursive(root.left, data);
		} else
			root.right = insertRecursive(root.right, data);
		
		return root;
	}
	
	public void insertIterative(int data){
		Node newNode = new Node(data);
		if(root == null) {
			root = newNode;
			return;
		}
		
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			
			if(data < current.data)
				current= current.left;
				
			if(current == null){
			    parent.left = newNode;
				return;
			}
			if(data > current.data)
				current = current.right;
			if(current == null){
			    parent.right = newNode;
				return;
			}
		}
	}
	
	private void levelOrderTraversal(){
		levelOrderTraversal(root);
	}
	
	
	private void levelOrderTraversal(Node current){
		System.out.println("level order traversing...");
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node temp = (Node) queue.poll();
			System.out.println(temp.data);
			
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
		}
	}

	public void diagonalTraversal(Node node) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		diagonalTraversal_recursive(node, 0, map);
		Set<Entry<Integer, List<Integer>>>  entry = map.entrySet();
		for(Entry e : entry){
			System.out.println(e.getValue().toString());
		}
		
		diagonalTraversal_iterative(node);
	}
	
	/**
	 * Creats a map where each key represents a diagonal and value represent the no of nodes in that diagonal
	 * Do pre-order traversal and update map
	 * for each node increase diagonal by 1 for left node and keep same for right node/subtree
	 * 
	 * @param node
	 * @param diagonal
	 * @param map
	 */
	private void diagonalTraversal_recursive(Node node, int diagonal, Map<Integer, List<Integer>> map){
		if(node == null)
			return;
		
		if(! map.containsKey(diagonal))
			map.put(diagonal, new ArrayList<Integer>());
		
		map.get(diagonal).add(node.data);
		
		//increase diagonal/slope if left child
		diagonalTraversal_recursive(node.left, diagonal+1, map);
		//slope remain same for right child
		diagonalTraversal_recursive(node.right, diagonal, map);
	}
	
	/**
	 * by using queue, 
	 * @param node
	 */
	private void diagonalTraversal_iterative(Node node){
		
	}
	
	/**
	 * Display the left view of tree
	 * solutions
	 * i) do level order traversing and print first node of each line
	 * ii) do Recursive Traversal(left before right) and maintain level. Increase level in each recursive travesal.
	 * Node which is level higher than maximum print the node.
	 */
	private void leftView(Node root){
		leftView_recursive(root, 1);
		leftView_levelOrder(root);
	}
	
	private void leftView_recursive(Node root, int level){
		
		if(root == null)
			return;
		if(max_level < level){
			System.out.println(root.data);
			max_level = level;
		}
		
		leftView_recursive(root.left, level+1);
		leftView_recursive(root.right, level+1);
	}
	
	/**
	 * While doing level order traversal, after traversing all node at each
	 * level, push a NULL delimiter to mark the end of the current level. So, do
	 * the level order traversal of the tree. Print the first node at each level
	 * in the tree and push the children of all nodes at each level in the queue
	 * until a NULL delimiter is encountered.
	 * 
	 * @param root
	 */
	private void leftView_levelOrder(Node root){
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(! queue.isEmpty()){
			Node temp = queue.peek();
			
			if(temp != null){
				System.out.println(temp.data);
				while(temp != null){
					if(temp.left != null)
						queue.add(temp.left);
					if(temp.right != null)
						queue.add(temp.right);
					
					queue.remove();
					temp = queue.peek();
				}
				queue.add(null); //next level
			}
			
			queue.remove(); //remove NULL 
		}
	}
	
	public void zigzagTraversal(Node node){
		//https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
		//https://www.geeksforgeeks.org/zigzag-tree-traversal/
	}
	
	/**
	 * he height of a binary tree is the number of edges between the tree's root and its furthest leaf. This means that
	 * a tree containing a single node has a height of .
	 * @return
	 */
	public int height(){
		Node left = root;
		Node right = root;
		
		int lCount = 0;
		while(left != null){
			left = left.left;
			lCount++;
		}
		
		int rCount = 0;
		while(right != null){
			right = right.right;
			rCount++;
		}
		System.out.println("left heigh: "+lCount+" right height: "+rCount);
		return lCount > rCount ? lCount : rCount;
	}
	
	public int recursiveHeight(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute the depth of each subtree */
			int lDepth = recursiveHeight(root.left);
			int rDepth = recursiveHeight(root.right);

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}
	
	public static void main(String[] args) {
		CustomBST bst = new CustomBST();
		//Queue s = new LinkedList();
		
		
		CustomBST tree = new CustomBST();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
        System.out.println("-----Diagonal Traversal----");
        tree.diagonalTraversal(tree.root);
        System.out.println("----LEFT view----");
        tree.leftView(tree.root);
        System.out.println("----Post order---");
        tree.postOrderTraversal(tree.root);
		
//		 Node root = new Node(8); 
//	        root.left = new Node(3); 
//	        root.right = new Node(10); 
//	        root.left.left = new Node(1); 
//	        root.left.right = new Node(6); 
//	        root.right.right = new Node(14); 
//	        root.right.right.left = new Node(13); 
//	        root.left.right.left = new Node(4); 
//	        root.left.right.right = new Node(7);
//	        bst.inOrderTraversal(root);
		bst.insert(50);
		bst.insert(30);
		bst.insert(80);
		bst.insert(40);
		bst.insert(20);
		bst.insert(90);
		bst.insert(35);
		bst.insert(42);
		
		System.out.println("---Preorder------");
		bst.preOrderTraversal(bst.root);
		System.out.println("-----Inorder----------");
		bst.inOrderTraversal();
		System.out.println("-----Postorder----");
		bst.postOrderTraversal(bst.root);

		bst.levelOrderTraversal();
		bst.height();
	}
}
