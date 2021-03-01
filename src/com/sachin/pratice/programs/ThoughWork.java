package com.sachin.pratice.programs;

//https://www.glassdoor.co.in/Interview/Friends-A-B-C-D-go-for-a-trip-They-spend-on-various-expenses-Cost-of-the-expense-is-shared-Example-A-spends-QTN_2238151.htm
/**
 * Friends A, B, C, D go for a trip. They spend on various expenses. Cost of the
 * expense is shared. Example : A spends 100 for breakfast for A, B, C and D. D
 * spends 500 for cab for B and C B spends 300 for lunch for A, B and C Write a
 * program to calculate how much each should get or each should give to one
 * another. App should be scalable that number of friends can change
 * 
 * @author GUR40832
 *
 */
public class ThoughWork {

	public static void main(String... args) {
		new ThoughWork().test();
	}

	private void test() {
        Person a = new Person();
        Person b = new Person();
        Person c = new Person();
        Person d = new Person();
		
        share(0, 1000, a, a,b,c,d);
        share(0, 500, d, b,c);
        share(0, 1000, b, a,b,c);
		
        System.out.println("A:share "+a.getAmount()+ " totalspend: "+a.getSpend() +" has to pay: "+((a.getSpend() - a.getAmount()) > 0 ? (a.getSpend() - a.getAmount()): Math.abs(a.getSpend() - a.getAmount())));
        System.out.println("B:share "+b.getAmount()+ " totalspend: "+b.getSpend());
        System.out.println("C:share "+c.getAmount()+ " totalspend: "+c.getSpend());
        System.out.println("D:share "+d.getAmount()+ " totalspend: "+d.getSpend());

	}

	private void share(int shareAmt, int amount, Person payer, Person... p) {
		int length = p.length;
      
		shareAmt = amount / length;
		for(Person ps : p){
			ps.setAmount(ps.getAmount()+shareAmt);
		}
		
		payer.setSpend(amount+payer.getSpend());
	}
}

class Person {
	int amount;
	int spend;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSpend() {
		return spend;
	}

	public void setSpend(int spend) {
		this.spend = spend;
	}

	@Override
	public String toString() {
		return "Person [amount=" + amount + ", spend=" + spend + "]";
	}

}

//https://www.geeksforgeeks.org/find-next-greater-number-set-digits/