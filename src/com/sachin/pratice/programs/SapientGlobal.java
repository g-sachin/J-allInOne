package com.sachin.pratice.programs;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class SapientGlobal {
	public static void main(String[] args) {
		new SapientGlobal().logic();
	}

	private void logic() {
		List<CapitaIncome> list = new ArrayList<>();
		List.of(new CapitaIncome("Boston", "USA", "M", 12));
		list.add(new CapitaIncome("Boston", "USA", "M", 12));
		list.add(new CapitaIncome("hkg", "HongKong", "M", 11));
		list.add(new CapitaIncome("Syndney", "Australia", "M", 13));
		list.add(new CapitaIncome("Seattle", "USA", "F", 14));
		list.add(new CapitaIncome("Bombay", "India", "F", 15));
		list.add(new CapitaIncome("Huston", "USA", "M", 16));
		list.add(new CapitaIncome("New delhi", "India", "M", 17));
		list.add(new CapitaIncome("Perth", "Australia", "F", 18));
		list.add(new CapitaIncome("Huston", "USA", "M", 20));
		list.add(new CapitaIncome("Chennai", "India", "F", 20));
		list.add(new CapitaIncome("Gurgaon", "", "F", 10));
		list.add(new CapitaIncome("Gurgaon", "", "F", 20));
		
		System.out.println("before: " + list.toString());

		// logic
		// print a list of CapitaIncome with Country and gender wise with
		// average avgAmount
		Set<CapitaIncome> outputSet = new LinkedHashSet<>();
		// List<CapitaIncome> outputSet = new ArrayList<>();
		for (CapitaIncome capita : list) {
			double amount = 0;
			
			//////JAVA 8 IMpl
			/*if(outputSet.contains(capita)) {
				Optional<CapitaIncome> op = outputSet.stream().filter( test -> test.equals(capita)).findAny();
				System.out.println("outpt: "+op.get().toString());
				System.out.println(" set avg: "+op.get().getAvgAmount() + " list avg: "+capita.getAvgAmount());
				double agg = op.get().getAvgAmount() + capita.getAvgAmount();
				capita.setAvgAmount(agg);
			}
			outputSet.add(capita);*/
			
			for (CapitaIncome ouput : outputSet) {
				if (capita.equals(ouput)) {
					amount = ouput.getAvgAmount();
					break;
				}
			}
			outputSet.add(capita);
			if (outputSet.contains(capita)) {
				outputSet.remove(capita);
				capita.setAvgAmount(capita.getAvgAmount() + amount);
				outputSet.add(capita);
			}
		}
		System.out.println(" unique elements: " + outputSet.toString());
		System.out.println(" initial size: " + list.size() + " after size: " + outputSet.size());
	}
}

class CapitaIncome {
	private String city;
	private String country;
	private String gender;
	private double avgAmount;

	CapitaIncome(String city, String country, String gender, double amount) {
		this.city = city;
		this.country = country;
		this.gender = gender;
		this.avgAmount = amount;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getAvgAmount() {
		return avgAmount;
	}

	public void setAvgAmount(double avgAmount) {
		this.avgAmount = avgAmount;
	}

	/*
	 * @Override public int hashCode(){ int result = 1; final int prime = 31;
	 * result = prime *result; result = result + country == null ? 0 :
	 * country.hashCode(); result = result + gender == null ? 0 :
	 * gender.hashCode(); return result; }
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
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
		CapitaIncome other = (CapitaIncome) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		return true;
	}

	/*
	 * @Override public boolean equals(Object obj){ if(this == obj) return true;
	 * if (obj == null) return false; if(obj.getClass() != this.getClass())
	 * return false;
	 * 
	 * CapitaIncome capita = (CapitaIncome)obj; return (capita.getCountry() ==
	 * this.getCountry() || capita.getCountry() != null &&
	 * capita.getCountry().equals(this.getCountry())); }
	 */

	@Override
	public String toString() {
		return "CapitaIncome [city=" + city + ", country=" + country + ", gender=" + gender + ", avgAmount=" + avgAmount
				+ "]";
	}
}

