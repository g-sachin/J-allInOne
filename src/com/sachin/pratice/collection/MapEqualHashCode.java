package com.sachin.pratice.collection;

import java.util.HashMap;
import java.util.Map;

public class MapEqualHashCode {

	public static void main(String[] args) {
		check();
	}

	private static void check() {
		Map<String, Employee> map = new HashMap<>();
		Employee e1 = new Employee("sachin", 27);
		Employee e2 = new Employee("Grhin", 28);

		map.put(e1.getName(), e1);
		map.put(e2.getName(), e2);
		
		e1.setName("grover");
		
		System.out.println(map.toString());
		System.out.println("emp name "+e1.getName());
		System.out.println(map.get(e1.getName()));
		
		Map<Employee, String> empMap = new HashMap<>();
		empMap.put(e1, "");
		empMap.put(e2, "");
		e1.setName("grover");
		
		System.out.println("emp map: "+empMap.toString());
		System.out.println(empMap.get(e1.getName())); //null
		
		
	}
}

class Employee {
	private String name;
	private int age;
	public Employee(String name, int age){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String str){
		this.name=str;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : 11);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equalsIgnoreCase(other.name))
			return false;
		return true;
	}
	
}

