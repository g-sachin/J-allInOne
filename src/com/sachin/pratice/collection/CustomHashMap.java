package com.sachin.pratice.collection;

import java.util.Arrays;

public class CustomHashMap<K, V> {

	Entry<K, V> bucket[] = null;
	int initialCapicity = 16;

	@SuppressWarnings("unchecked")
	public CustomHashMap() {
		bucket = new Entry[initialCapicity];
	}

	public void put(K key, V value) {
		int hashIndex = calcHash(key);
		Entry<K, V> entry = new Entry<>(key, value, null);
		if (bucket[hashIndex] == null) {
			bucket[hashIndex] = entry;
		} else {
			Entry<K, V> prev = null;
			Entry<K, V> current = bucket[hashIndex];
			while (current != null) {
				if (key.equals(current.key)) {
					current.value = value;
					bucket[hashIndex] = current;
					return;
				}
				current = current.next;
			}

			if (current.key.equals(key)) {
				current.value = value;
			} else {
				current.next = entry;
			}
		}
	}

	public V get(K key) {
		int hashIndex = calcHash(key);
		Entry<K, V> current = bucket[hashIndex];
		while (current != null){
		  if(key.equals(current.key))
			  return current.value;
		  
		  current = current.next;
		}
		return null;
	}

	public boolean containsKey(K key) {
		return false;
	}

	private int calcHash(K key) {
		return Math.abs(key.hashCode()) % initialCapicity;
	}

	class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next = null;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	@Override
	public String toString() {
		return "CustomHashMap [bucket=" + Arrays.toString(bucket) + ", initialCapicity=" + initialCapicity + "]";
	}

	public static void main(String[] args) {
		CustomHashMap<String, String> cm = new CustomHashMap<>();
		cm.put("Sachin", "Grover");
		cm.put("Aricent", "Gurgaon");
		cm.put("Delhi", "India");
		
		System.out.println(cm.get("Delhi"));
		System.out.println(cm.get("Sachin"));
		System.out.println(cm.get("Aricent"));
		System.out.println(cm.get("Del"));
		
	}
}
