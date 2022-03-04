import java.util.Random;

import question02.Guest;

public class Cake {

	private static boolean available = true;
	
	public Cake() {
	}
	
	public void orderCake() {
		System.out.println("Ordering Cake...");
		this.available = true;
	}
	
	public boolean isAvailable() {
		return this.available;
	}
	
	
	public void eatCake() {

		// Random rand = new Random();
		// int choice = rand.nextInt((1 - 0) + 1);
		
		// if(choice == 1)
		System.out.println("Eating cake");
			
		// if(choice == 0)
		// 	System.out.println("Choice : Not eating cake");
			
		if(this.isAvailable()) {
			this.available = false;
		}
		else{
			System.out.println("no cake here my guy");
		}
		
	}
	

	
	

}
