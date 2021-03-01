package com.sachin.pratice.programs.multithreading.customthreadpool;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CustomBlockingQueue<Type> {

	    /**
	     * Implemetation using lock and condition interface:
	     * https://java2blog.com/custom-blockingqueue-implementation-java/
	     * 
	     */
	    private Queue<Type> queue = new LinkedList<Type>();
	    private int EMPTY = 0;
	    private int MAX_TASK_IN_QUEUE = -1;

	    public CustomBlockingQueue(int size){
	        this.MAX_TASK_IN_QUEUE = size;
	    }

	    public synchronized void enqueue(Type task)
	            throws InterruptedException  {
	        while(this.queue.size() == this.MAX_TASK_IN_QUEUE) {
	            wait();
	        }
	        if(this.queue.size() == EMPTY) {
	            notifyAll();
	        }
	        this.queue.offer(task);
	    }

	    public synchronized Type dequeue()
	            throws InterruptedException{
	        while(this.queue.size() == EMPTY){
	            wait();
	        }
	        if(this.queue.size() == this.MAX_TASK_IN_QUEUE){
	            notifyAll();
	        }
	        return this.queue.poll();
	    }
	}
