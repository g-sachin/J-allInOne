package com.sachin.pratice.collection.linkedlist;

import java.util.ArrayList;

public class SinglyLinkedList {

	Node head = null;
	static class Node {
		int data;
		Node next = null;
		
		Node(int data){
			this.data = data;
		}
	}
	
	
	private void display(){
		Node current = head;
		
		while(current != null){
			System.out.println("element: "+current.data);
			current = current.next;
		}
		
	}
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		
		list.display();
		
		list.head.next = second;
		second.next = third;
		
		list.display();
	}
}
