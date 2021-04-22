package com.sachin.pratice.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CustomIterator {
	
	public static void main(String[] args) {
		List<Integer> ls = Arrays.asList(1, 2, 3,5,6,7,9);
		CustomList<Integer> cList = new CustomList<>(ls);
		
		Iterator<Integer> itr = cList.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		new LinkedList().iterator();
	}
}

class CustomList<T> implements Iterable<T>{

	private List<T> list;
	public CustomList(List<T> ls) {
		list = ls;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new CustIterator<T>();
	}
	
	class CustIterator<T> implements Iterator<T> {

		int currentPos;
		int size = list.size();
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currentPos < size;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			@SuppressWarnings("unchecked")
			T ls = (T) list.get(currentPos);
			currentPos+=2;
			return ls;
		}
		
	}

}

