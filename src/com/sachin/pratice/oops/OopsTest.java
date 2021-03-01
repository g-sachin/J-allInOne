package com.sachin.pratice.oops;
import java.text.DecimalFormat;

public class OopsTest {

	   public static void main(String[] args)
	   {
	      Sandwich burger = new Sandwich("Cheeseburger",2.75);
	      Sandwich club = new Sandwich("Club Sandwich", 2.75);
	      Salad spinachSalad = new Salad("Spinach Salad",1.25);
	      Salad coleslaw = new Salad("Coleslaw", 1.25);
	      Drink orange = new Drink("Orange Soda", 1.25);
	      Drink cap = new Drink("Cappuccino", 3.50);
	      Trio trio1 = new Trio(burger,spinachSalad, orange);
	      System.out.println("It should print Cheeseburger/Spinach Salad/Orange Soda Trio and it prints: " + trio1.getName());
	      System.out.println("It should print 4.0 and it prints: " + trio1.getPrice());
	      Trio trio2 = new Trio(club,coleslaw,cap);
	      System.out.println("It should print Club Sandwich/Coleslaw/Capuccino Trio and it prints: " + trio2.getName());
	      System.out.println("It should print 6.25 and it prints: " + trio2.getPrice());
	   }
}

interface MenuItem
{
   /** @return the name of the menu item */
   String getName();

   /** @return the price of the menu item */
   double getPrice();
}

class SimpleLunchItem implements MenuItem
{
   private String name;
   private double price;

   public SimpleLunchItem(String aName, double aPrice)
   {
      name = aName;
      price = aPrice;
   }

   public String getName() { return name; }
   public double getPrice() { return price; }

   public String toString ()
   {
      DecimalFormat money = new DecimalFormat("0.00");
      return getName() + " " + money.format(getPrice());
   }
}

class Drink extends SimpleLunchItem
{
   public Drink(String name, double price)
   { super(name, price); }
}

class Salad extends SimpleLunchItem
{
   public Salad(String name, double price)
   { super(name, price); }
}

class Sandwich extends SimpleLunchItem
{
   public Sandwich(String name, double price)
   { super(name, price); }
}

class Trio implements MenuItem {
	
	private Sandwich sandwich;
	private Salad salad;
	private Drink drink;
	
	public Trio(Sandwich sandwich, Salad salad, Drink drink) {
		this.sandwich = sandwich;
		this.salad = salad;
		this.drink = drink;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		final String DELIMITER = "/";
		StringBuffer sb = new StringBuffer();
		sb.append(sandwich.getName());
		sb.append(DELIMITER);
		
		sb.append(salad.getName());
		sb.append(DELIMITER);
		
		sb.append(drink.getName());
		sb.append(" ");
		
		sb.append("Trio");
		return sb.toString();
	}
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		double sandwichPrice = sandwich.getPrice();
		double saladPrice = salad.getPrice();
		double drinkPrice = drink.getPrice();
		
		return calcPrice(sandwichPrice, saladPrice, drinkPrice);
	}
	
	private double calcPrice(double sandwichPrice, double saladPrice, double drinkPrice) {
		double finalPrice = 0;
		
		if(sandwichPrice > saladPrice && sandwichPrice > drinkPrice) {
	    	if(saladPrice > drinkPrice) {
	    		finalPrice = sandwichPrice + saladPrice;
	    	} else {
	    		finalPrice = sandwichPrice + drinkPrice;
	    	}
	    } else if(saladPrice > sandwichPrice && saladPrice > drinkPrice) {
	    	if(sandwichPrice > drinkPrice) {
	    		finalPrice = sandwichPrice + saladPrice;
	    	} else {
	    		finalPrice = saladPrice + drinkPrice;
	    	}
	    } else if(drinkPrice > saladPrice && drinkPrice > sandwichPrice) {
	    	if(saladPrice > sandwichPrice) {
	    		finalPrice = drinkPrice + saladPrice;
	    	} else {
	    		finalPrice = drinkPrice + sandwichPrice;
	    	}
	    } 
		return finalPrice;
	}
	
}