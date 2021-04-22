package com.sachin.pratice.annotation;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		new Test().test();
	}

	private void test() {
		Set<Employee> set = new TreeSet<>();
		Employee e1 = new Employee();
		e1.setEmpName("Sachin");
		e1.setAge(30);
		
		
		set.add(e1);
		
	}

}


class Employee implements Comparator<Employee>{
	private String empName;
	private int age;
	private String desgination;
	
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesgination() {
		return desgination;
	}
	public void setDesgination(String desgination) {
		this.desgination = desgination;
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		return 0;
	}

	
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}