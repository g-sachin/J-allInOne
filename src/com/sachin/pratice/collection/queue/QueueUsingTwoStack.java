package com.sachin.pratice.collection.queue;

import java.util.Stack;

import javax.management.RuntimeErrorException;

/**
 * Implement queue using two stack
 * 
 * Enqueue O(1)
 * i) Push item to stack-1
 * 
 * Dequeue
 * i)Raise error if both stack1 and stack2 are empty
 * ii) IF Stack2 is empty and stack1 is non-empty - copy stack1 to stack2
 * iii) pop element from stack2
 * @author GUR40832
 *
 */
public class QueueUsingTwoStack {

	private Stack<Integer> s1 = new Stack<>();
	private Stack<Integer> s2 = new Stack<>();
	
	public void enqeue(int data){
		s1.push(data);
	}
	
	public int deqeue(){
	
		if(s1.empty() && s2.empty())
			throw new RuntimeException("No element present. Queue is empty");
		
		if(s2.empty() && !s1.empty()){
			while(! s1.empty()){
				s2.push(s1.pop());
			}
		}
		int item = s2.pop();
		return item;
	}
	
	public static void main(String[] args) {
		//QueueUsingTwoStack queue = new QueueUsingTwoStack();
		AnotherWay queue = new AnotherWay();
		queue.enqeue(44);
		queue.enqeue(4);

		System.out.println("dequeue: "+queue.deqeue());
	}
}

/**
 * Another way queue using two stack making enqeue operation costly
 * 
 * Enqeue-
 * i) copy s1 to s2
 * ii) push to s1
 * iii) again reverse copy s2 to s1
 * 
 * Deqeue-
 * i) pop element from s1
 * 
 * @author GUR40832
 *
 */
class AnotherWay{
	private Stack<Integer> s1 = new Stack<>();
	private Stack<Integer> s2 = new Stack<>();
	
	public void enqeue(int data){
		while(! s1.empty()){
			s2.push(s1.pop());
		}
		
		s1.push(data);
		
		while(! s2.empty()){
			s1.push(s2.pop());
		}
	}
	
	public int deqeue(){
		if(s1.empty())
			throw new RuntimeException("queue is empty");
		
		int item = s1.pop();
		return item;
	}
}