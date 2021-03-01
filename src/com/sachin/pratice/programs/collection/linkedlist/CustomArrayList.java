package com.sachin.pratice.programs.collection.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;

interface List<X> {
	public void add(X data);
	
	public void add(int pos, X data);
	
	public int size();
	
	public X get(int i);
	
	public void remove(int pos);

}

public class CustomArrayList<X> implements List<X>{

	private int size = 0;
    private X data[] = null;
    private int DEFAULT_CAPACITY = 20;
    
    public CustomArrayList(){
    	data = (X[]) new Object [DEFAULT_CAPACITY];
    }
	
	@Override
	public void add(X value) {

		if(size+1 == data.length)
			resize(data.length*2);
		
		data[size+1] = value;
		size++;
	}

	@Override
	public void add(int pos, X value) {

		//Array are store in contiguous memeory location. size check is required.
		//new element at given position can be added of given size
		if(pos < 0  || pos > size+1)
			throw new IndexOutOfBoundsException();
		
		for(int i=pos ; i < size-1 ; i++){
			data[i+1] = data[i];
		}
		data[pos] = value;
		size++;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public X get(int i) {
		return data[i];
	}

	@Override
	public void remove(int pos) {
		// TODO Auto-generated method stub
	    for(int i=pos; i<data.length; i++){
	  	  data[i] = data[i+1];
	  	}
		
		size--;
	}

	private void resize(int capacity){
		X temp [] = (X[]) new Object[capacity];
		System.arraycopy(data, 0, temp, 0, data.length);
		
		data = temp;
	}
	
	public String toString() {
		
		return Arrays.toString(data);
	}
	public static void main(String[] args) {
		CustomArrayList<Integer> al = new CustomArrayList<>();
		al.add(5);
		
		System.out.println(al);
	}

}
