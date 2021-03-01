package com.sachin.pratice.oops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Employee implements Comparable<Employee> {

	private String name;
	private int id;
	private String cmpny;
	
	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cmpny == null) ? 0 : cmpny.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	
/*	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
*/
	/*
	 * @Override public boolean equals(Object o){ if(this == o) return true;
	 * if(o==null) return false; if(getClass() != o.getClass()) return false;
	 * Employee emp = (Employee)o;
	 * 
	 * if(getName() == null){ if(emp.getName() == null) return true; } else
	 * if(getName().equals(emp.getName())) return true;
	 * 
	 * if(getId() != emp.getId()){ return false; } return true; }
	 * 
	 * @Override public int hashCode(){ final int prime = 31; int res = 0; res =
	 * res * prime + id; res = res * prime + getName()==null ? 0 :
	 * getName().hashCode();
	 * 
	 * return res; }
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		//using ternary
		//if((cmpny == null) ? (other.cmpny != null) : cmpny.equals(other.cmpny))
			//	return false;
		if (cmpny == null) {
			if (other.cmpny != null)
				return false;
		} else if (!cmpny.equals(other.cmpny))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println("comapre string:  " + ("sachin".compareTo("sachin")));
		Employee.setUtil();
	}

	private static void setUtil() {
		//Set<Employee> set = new TreeSet<>(new AgeComparator());

		Set<Employee> set = new TreeSet<>();
		
		Employee e1 = new Employee("Sachin", 222);
		Employee e2 = new Employee("Grover", 333);
		Employee e3 = new Employee("sachin", 444);
		Employee e4 = new Employee("sachin", 222);
		Employee e5 = new Employee("padtec", 333);

		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);

		System.out.println("Set: size: " + set.size() + " data: " + set.toString());
		//TreeSet return 4 record's while HashSet return's 5 records due to equal and compareTo inequality.
		
		/**
		 * HashSet uses equals() method to compare two object in Set and for detecting
		 * duplicates. TreeSet uses compareTo() method for same purpose. If equals() and
		 * compareTo() are not consistent, i.e. for two equal object equals should
		 * return true while compareTo() should return zero, than it will break contract
		 * of Set interface and will allow duplicates in Set implementations like
		 * TreeSet
		 */

		List<Employee> ls = new ArrayList<>(set);
		Collections.sort(ls, new AgeComparator());
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return name.compareTo(o.getName());
		// return Integer.compare(id, o.getId());
	}

}

class AgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// return (x < y) ? -1 : ((x == y) ? 0 : 1);
		return o1.getId() - o2.getId();
	}

}
