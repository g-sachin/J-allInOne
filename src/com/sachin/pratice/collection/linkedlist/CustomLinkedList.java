package com.sachin.pratice.collection.linkedlist;

import java.util.NoSuchElementException;

public class CustomLinkedList {

	Node head = null;
	//Node tail = null;
	private int size = 0;

	/**
	 * @method 
	 * @param data
	 */
	private void insertAtEnd(int data) {
		Node newNode = new Node(data);

		/*if (head == null) {
			head = newNode;
		} else {
			// tail.next = newNode;
			tail.setNext(newNode);
		}
		tail = newNode;*/
		if(head == null) {
			head = newNode;
		} else {
			Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.setNext(newNode);
		}
		size++;
	}

	private void insertAtFirst(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			//tail = newNode;
		} else {
			newNode.setNext(head); // better to have parameteric c'tor with data
									// and next
			head = newNode;
		}
		size++;
	}

	private void inserAtAnySpecificPos(int pos, int data) {
		if (size < pos || pos < 0)
			throw new NoSuchElementException();

		int count = 1;
		Node newNode = new Node(data);
		Node current = head;
		/*while (current.next != null) {
			if (count == pos) {
				newNode.next = current.next;
				current.next = newNode;
				break;
			}
			current = current.next;
			count++;
		}*/
		for(int i=1;i<pos;i++) {
			current = current.next;
		}
		newNode.setNext(current.next);
		current.next = newNode;
		size++;
	}

	@SuppressWarnings("unused")
	private void removeFromBegin() {
		if (head == null){
			return;
		}
		Node temp = head;
		head = temp.next;
		temp = null;
		size--;
	}
	
	private void deleteNode(int data) {
		Node temp = head;
		Node prev = null;

		if (temp != null && temp.data == data) {
			head = temp.next;
			return;
		}
		while (temp != null && temp.data != data) {
			prev = temp;
			temp = temp.next;
		}
		if (temp == null)
			return;
		prev.next = temp.next;
		size--;
	}

    private void deleteSpecificPos(int pos){
    	if(pos >= size)
    		throw new NoSuchElementException();
    	Node current = head, prev = null;

    	if(pos == 0){
    		head = current.next;
    		return;
    	}
    	while(pos > 1 && current.next != null){
    		prev= current;
    		current = current.next;
    		pos--;
    	}
    	prev.next = current.next;
    	
    	/*//can be done with single node
    	for(int i=1; i< pos; i++) {
    		current = current.next;
    	}
    	current.next = current.next.next;*/
    	
    	//current = null;
    }

    /**
     * copy the data from the next node to the node to be deleted and delete the next node
     * @param delete
     * 
     * would be issue if delete is last node
     */
    private void deleteAnySpecficeNode(Node delete){
    	Node temp = delete.next;
    	delete.data = temp.data;
    	delete.next = temp.next;
    	temp = null;
	}
	
    
    private Node deleteLastNode(Node head) {
    	if (head == null) return null;
    	if (head.next == null) return null;
    	
    	Node current = head;
    	while(current.next.next != null) //iterate till one node before last
    		current = current.next;
    	
    	current.next = null; //set the last node as null
    	return head;
    }
    
	private int size() {
		return size;
	}


	private Node get(int pos){
	
		if(pos > size)
			throw new NoSuchElementException();
		
		Node current = head;
		while(pos >0 && current!= null){
			current = current.next;
			pos--;
		}
		return current;
	}
	
	private void findMiddle(){
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("Middle element is: "+slow.data);
	}
	
	private void hasLoop(){
		Node slow = head;
		Node fast = head;
		
		while(slow != null && fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				System.out.println("Found LOOP");
		}
	}
	
	private boolean search(int key){
		Node current = head;
		
		while(current != null){
			if(current.data == key)
				return true;
			current = current.next;
		}
		
		return false;
	}
	
	private void printInReverseOrder(){
		Node current = head;
		printInReverseOrder(current);
	}
	
	private void printInReverseOrder(Node current){
		if(current == null)
			return;
		printInReverseOrder(current.next);
		
		System.out.print(current.data+" ");
	}
	
	private void findNthNode(int pos){
		Node current = head;
		int length = 0;
		while(current != null){
			current = current.next;
			length++;
		}
		
		Node temp = head;
		for(int i=1; i< length-pos+1; i++){
			temp = temp.next;
		}
		System.out.println("Node at positon: "+pos+" is: "+temp.data);
	}
	
	private void reverse(){
		Node prev= null;
		Node next = null;
		Node current = head;
		
		while(current != null){
			next = current.next;
			current.next = prev;
			prev=current;
			current = next;
		}
		head = prev;
	}
	
	private void display() {
		Node current = head;

		while (current != null) {
			System.out.print(current.data);
			System.out.print(",");
			current = current.next;
		}
	}

	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedList();

		// Appends the specified element to the end of this list.
		list.insertAtEnd(1);
		list.insertAtEnd(6);
		list.insertAtEnd(9);
		list.insertAtEnd(12);
		list.insertAtEnd(62);
		list.display();

		// append the element at the end
		System.out.println("  ");
		System.out.println("----------------------");
		list.insertAtEnd(34);
		list.display();

		// add the element at First Position
		System.out.println("  ");
		System.out.println("----------------------");
		list.insertAtFirst(19);
		list.display();

		// append element at nth position
		System.out.println("  ");
		System.out.println("----------------------");
		list.inserAtAnySpecificPos(2, 44);
		list.display();

		// check size of list
		System.out.println("  ");
		System.out.println("----------------------");
		System.out.println("List Size::" + list.size());

		// delete a node
		System.out.println("  ");
		System.out.println("----------------------");
		list.deleteNode(34);
		System.out.println("List after deleting :9: ");
		System.out.println("List size: " + list.size());
		list.display();

		// delete after specific position
		System.out.println("  ");
		System.out.println("----------------------");
		list.deleteSpecificPos(5);
		list.display();
		
		
		//find element at Nth position
		System.out.println("  ");
		System.out.println("----------------------");
        System.out.println("Element at Nth pos:from beginging: "+list.get(2).data);


        //Middle element
		System.out.println("  ");
		System.out.println("----------------------");
        list.findMiddle();
		
		
		//Detect a loop
		System.out.println("  ");
		System.out.println("----------------------");
		list.hasLoop();
		
        System.out.println("searched? "+list.search(4));
	
        System.out.println("----Print List in reverse order----");
        list.printInReverseOrder();
        
        System.out.println(" \n Nth node from last");
        list.findNthNode(4);
        
		//REVRSE link list
		list.reverse();
		System.out.println(" \n Reverse linked list: ");
		list.display();
	}

	static class Node {
		private int data;
		Node next = null;

		Node(int data) {
			this.data = data;
			this.next = null;
		}

		void setNext(Node temp) {
			this.next = temp;
		}
		
		
	}

}
