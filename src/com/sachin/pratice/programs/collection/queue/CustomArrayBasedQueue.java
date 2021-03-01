package com.sachin.pratice.programs.collection.queue;

/**
 * Array based queue implementation in circular manner
 * @author GUR40832
 *
 */
public class CustomArrayBasedQueue {
	int front;
	int rear;
	int array[];
	static int DEFAULT_CAPACITY=20;
	int capacity;
	int size;
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public boolean isFull(){
		return size == this.capacity;
	}
	
	public CustomArrayBasedQueue(){
		this(DEFAULT_CAPACITY);
	}
	
	public CustomArrayBasedQueue(int capacity){
		this.capacity = capacity;
		this.front = -1;
		this.rear = -1;
	}
	
	public void enqeue(int data) throws Exception{
		//check capacity
		if(isFull()){
			System.out.println("Queue is full");
			throw new Exception("full queue");
		}
		if(isEmpty()){
			front = 0;
			rear = 0;
		}
		
		array[++rear] = data;
		size++;
	}
	
	public int deqeue() throws Exception{
		if(isEmpty()){
			throw new Exception("queue empty");
		}
		int temp = array[front];
		
		size--;
		return temp;
		
	}
	
	
	public static void main(String[] args) {
		CustomArrayBasedQueue queue = new CustomArrayBasedQueue(10);
	}
}
