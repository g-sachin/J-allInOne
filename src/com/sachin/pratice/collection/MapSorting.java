package com.sachin.pratice.collection;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapSorting {

	public static void main(String[] args) {
		MapSorting.sortOnKey();
		sortCustomComparator();
	}

	public static void sortOnKey() {
		Map<String, Integer> map = new LinkedHashMap<>();

		map.put("a", 2);
		map.put("b", 2);
		map.put("A", 2);
		map.put("d", 2);
		map.put("z", 2);
		map.put("E", 2);
		map.put("x", 2);
		map.put("s", 2);
		map.put("c", 2);
		map.put("F", 2);
		map.put("J", 2);

		System.out.println("Wihtout soring: " + map.toString());

		Map<String, Integer> tree = new TreeMap<>(map);
		System.out.println("After sorting: " + tree.toString());
	}

	public static void sortCustomComparator() {
		class Employee {
			int id;
			String name;

			public Employee(int id, String name) {
				this.id = id;
				this.name = name;
			}

			@Override
			public String toString() {
				return "Employee [id=" + id + ", name=" + name + "]";
			}
			
		}

		Map<Employee, Integer> map = new TreeMap<Employee, Integer>(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.id - o2.id;
			}
		});
		
		//Throw classCast Exception since custom key<Employee> has not implemted compartor
		//Map<Employee, Integer> map = new TreeMap<Employee, Integer>();
		
		map.put(new Employee(1, "sac"), 22);
		map.put(new Employee(10, "sac"), 22);
		map.put(new Employee(2, "sac"), 22);
		map.put(new Employee(-5, "sac"), 22);
		
		System.out.println("map custom comprator: "+map.toString());
	}
	
	public static void sortByValue(){
		
	}
}
