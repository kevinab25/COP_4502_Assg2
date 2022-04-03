import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of guests : ");
        int numGuests = scan.nextInt();
		// int numGuests = 5;

		scan.close();
        System.out.println("The number entered by user: " + numGuests);
        
		Thread guestThreads[] = new Thread[numGuests];
		Guest guests[] = new Guest[numGuests];
		for(int i = 0 ; i < numGuests  ; i++ ) {
			guests[i] = new Guest(i);
			guestThreads[i] = new Thread(guests[i]);
			guestThreads[i].start();
		}
		
		
		for(int i = 0 ; i < numGuests  ; i++ ) {
			try {
				guestThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("All Guests have visted the Show Room");
		
		
	}

}
