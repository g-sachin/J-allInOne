package com.sachin.pratice.programs.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Input: arr[] = {10, 3, 5, 10, 3, 5, 10};
 *  Output: Frequency of 10 is 3
 *       Frequency of 3 is 2
 *       Frequency of 5 is 2
 * @author GUR40832
 *
 */
public class CountFrequency {

	public static void main(String[] args) {

		new CountFrequency().checkFrequency();
		new CountFrequency().checkIntergerArrFreq();
	}

	private void checkFrequency() {
		String str[]  = {"f","a", "b", "c", "b", "d", "e", "b", "a", "f", "b", "c"};
		
		Map<String, Integer> map = new HashMap<>();
		
		Integer freqnecy = null;
		for(String s: str){
			freqnecy = map.get(s);
			if(freqnecy != null && freqnecy >= 1){
				map.put(s, ++freqnecy);
			} else {
				map.put(s, 1);
			}
		}
		int count=Integer.MIN_VALUE;
		String key = null;
		for(Entry<String, Integer> entry : map.entrySet()){
			System.out.println("Frequency of  "+entry.getKey()+" is "+entry.getValue());
			if(count < entry.getValue()){
				count = entry.getValue();
				key=entry.getKey();
			}
		}
		System.out.println("highesht frequency char is: "+key+ " val is: "+count);
		
	}

	private void checkIntergerArrFreq(){
		int arr[] = {10, 3, 5, 10, 3, 5, 10};
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i: arr){
			if(map.containsKey(i)) {
				int freq = map.get(i);
				map.put(i, ++freq);
			} else {
				map.put(i, 1);
			}
		}
		System.out.println("Interger freq map = "+map.toString());
	}
	
}
