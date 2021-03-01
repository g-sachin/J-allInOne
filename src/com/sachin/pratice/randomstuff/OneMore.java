package com.sachin.pratice.randomstuff;

public class OneMore {

	public static void main(String[] args) {
		new OneMore().check();
		new Thread(){
			public void run(){
				try {
					System.out.println("Thread start...");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread end");
			}
		}.start();
		
		System.out.println("Main end...");
	}
	
	

	/**
	 * valueOf public static Integer valueOf(int i) Returns an Integer instance
	 * representing the specified int value. If a new Integer instance is not
	 * required, this method should generally be used in preference to the
	 * constructor Integer(int), as this method is likely to yield significantly
	 * better space and time performance by caching frequently requested values.
	 * This method will always cache values in the range -128 to 127, inclusive,
	 * and may cache other values outside of this range.
	 */
	private void check() {
		int i1 = 127;
		int i2 = 127;
		System.out.println(" check? " + (i1 == i2)); // true

		Integer i3 = 128;
		Integer i4 = 128;
		System.out.println(" check? " + (i3 == i4)); // false
		
	}
}
