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
     */
    private void deleteAnySpecficeNode(Node delete){
    	Node temp = delete.next;
    	delete.data = temp.data;
    	delete.next = temp.next;
    	temp = null;
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
		System.out.println(Messages.getString("CustomLinkedList.test0")+slow.data); //$NON-NLS-1$
	}
	
	private void hasLoop(){
		Node slow = head;
		Node fast = head;
		
		while(slow != null && fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				System.out.println(Messages.getString("CustomLinkedList.test1")); //$NON-NLS-1$
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
		
		System.out.print(current.data+Messages.getString("CustomLinkedList.test2")); //$NON-NLS-1$
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
		System.out.println(Messages.getString("CustomLinkedList.test3")+pos+Messages.getString("CustomLinkedList.test4")+temp.data); //$NON-NLS-1$ //$NON-NLS-2$
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
			System.out.print(Messages.getString("CustomLinkedList.test5")); //$NON-NLS-1$
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
		System.out.println(Messages.getString("CustomLinkedList.test6")); //$NON-NLS-1$
		System.out.println(Messages.getString("CustomLinkedList.test7")); //$NON-NLS-1$
		list.insertAtEnd(34);
		list.display();

		// add the element at First Position
		System.out.println(Messages.getString("CustomLinkedList.test8")); //$NON-NLS-1$
		System.out.println(Messages.getString("CustomLinkedList.test9")); //$NON-NLS-1$
		list.insertAtFirst(19);
		list.display();

		// append element at nth position
		System.out.println(Messages.getString("CustomLinkedList.test10")); //$NON-NLS-1$
		System.out.println(Messages.getString("CustomLinkedList.test11")); //$NON-NLS-1$
		list.inserAtAnySpecificPos(2, 44);
		list.display();

		// check size of list
		System.out.println(Messages.getString("CustomLinkedList.test12")); //$NON-NLS-1$
		System.out.println(Messages.getString("CustomLinkedList.test13")); //$NON-NLS-1$
		System.out.println(Messages.getString("CustomLinkedList.test14") + list.size()); //$NON-NLS-1$

		// delete a node
		System.out.println(Messages.getString("CustomLinkedList.test15")); //$NON-NLS-1$
		System.out.println(Messages.getString("CustomLinkedList.test16")); //$NON-NLS-1$
		list.deleteNode(34);
		System.out.println(Messages.getString("CustomLinkedList.test17")); //$NON-NLS-1$
		System.out.println(Messages.getString("CustomLinkedList.test18") + list.size()); //$NON-NLS-1$
		list.display();

		// delete after specific position
		System.out.println(Messages.getString("CustomLinkedList.test19")); //$NON-NLS-1$
		System.out.println(Messages.getString("CustomLinkedList.test20")); //$NON-NLS-1$
		list.deleteSpecificPos(5);
		list.display();
		
		
		//find element at Nth position
		System.out.println(Messages.getString("CustomLinkedList.test21")); //$NON-NLS-1$
		System.out.println(Messages.getString("CustomLinkedList.test22")); //$NON-NLS-1$
        System.out.println(Messages.getString("CustomLinkedList.test23")+list.get(2).data); //$NON-NLS-1$


        //Middle element
		System.out.println(Messages.getString("CustomLinkedList.test24")); //$NON-NLS-1$
		System.out.println(Messages.getString("CustomLinkedList.test25")); //$NON-NLS-1$
        list.findMiddle();
		
		
		//Detect a loop
		System.out.println(Messages.getString("CustomLinkedList.test26")); //$NON-NLS-1$
		System.out.println(Messages.getString("CustomLinkedList.test27")); //$NON-NLS-1$
		list.hasLoop();
		
        System.out.println(Messages.getString("CustomLinkedList.test28")+list.search(4)); //$NON-NLS-1$
	
        System.out.println(Messages.getString("CustomLinkedList.test29")); //$NON-NLS-1$
        list.printInReverseOrder();
        
        System.out.println(Messages.getString("CustomLinkedList.test30")); //$NON-NLS-1$
        list.findNthNode(4);
        
		//REVRSE link list
		list.reverse();
		System.out.println(Messages.getString("CustomLinkedList.test31")); //$NON-NLS-1$
		list.display();
	}

	static class Node {
		private int data;
		Node next = null;

		Node(int data) {
			next = new Node(data);
			this.data = data;
			this.next = null;
		}

		void setNext(Node temp) {
			this.next = temp;
		}
		
		
	}

}
