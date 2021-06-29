package com.sachin.pratice.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {

	// map + flatten--> used to flatten the streem - if stream of stream of value -
	// convert to stream of values
	public static void main(String[] args) {
		//flatMapStreamOfSteams();
		//flatMapRealExample();
		testMap();
	}

	
	private static void testMap() {
		Student s1 = new Student(15, "sachin", "abc");
		Student s2 = new Student(25, "sachin1", "abc");
		Student s3 = new Student(5, "sachin2", "abc");
		Student s4 = new Student(45, "sachin3", "abc");
		Student s5 = new Student(55, "sachin4", "abc");
		
		List<String> ls = Stream.of(s1, s2, s3, s4, s5)
		.filter(student -> student.getAge() > 15)
		.map(student -> student.getName())
		.collect(Collectors.toList());
		System.out.println(ls);
	}


	private static void flatMapStreamOfSteams() {
		Stream<List<Integer>> st = Stream.of(Arrays.asList(1, 3, 5), Arrays.asList(2, 4, 6));
		st.flatMap(list -> list.stream()) // Stream<List<Integer>> convert to Stream<Integer>>
				.forEach(System.out::println);
	}
	
	private static void flatMapRealExample() {
		Card c1 = new Card("LINE_CARD");
		Card c2 = new Card("CONTROL_CARD");
		Card c3 = new Card("FAN_CARD");
		
		List<Card> cards = Arrays.asList(c1, c2);
		List<Card> cards_2 = Arrays.asList(c1, c2, c3);
		
		Server s1 = new Server("10.10.10.10", cards);
		Server s2 = new Server("5.5.5.5", cards_2);
		
		List<Server> servers = Arrays.asList(s1, s2);
		
		//find out line cards using flatMap
	       
		//MAP LIMITATION - it return List<List<Cards>>
		List<List<Card>> allCards = servers.stream()
		       .map(server -> server.getCards())
		       .collect(Collectors.toList());
		System.out.println(allCards.toString());
		
		//flatMap is remedy to return List<Cards>
		servers.stream()
	       .flatMap(server -> server.getCards().stream())
	       .map(card -> card.getName())
	       .forEach(System.out::println);
		       
	}
}

class Server {
	private String name;
	private List<Card> cards;

	public Server(String name, List<Card> cards) {
		super();
		this.name = name;
		this.cards = cards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}

class Card {
	private String name;

	public Card(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Card [name=" + name + "]";
	}
}


class Student{
	private int age;
	private String name;
	private String address;
	
	public Student(int age, String name, String address) {
		this.age = age;
		this.name = name;
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

class Address{
	
}
}