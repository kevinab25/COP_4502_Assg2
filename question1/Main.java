import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int numGuests;
	public static boolean[] hadCake;
	public static boolean[] doneThreads;
	private volatile boolean weAreDone; 
	public static void main(String[] args) {
		
        Scanner scan = new Scanner(System.in);
        // System.out.print("Enter the number of guests : ");
        // int numGuests = scan.nextInt();
       int numGuests = 5;
		scan.close();
        System.out.println("Number of Guests : " + numGuests);
        
		Thread guestThreads[] = new Thread[numGuests];
		Guest guests[] = new Guest[numGuests];
		hadCake = new boolean[numGuests];
		doneThreads = new boolean[numGuests];
		Arrays.fill(hadCake, false);
		Arrays.fill(doneThreads, false);

		Main mainthread = new Main();
		
		for(int i = 0 ; i < numGuests  ; i++ ) {
			guests[i] = new Guest(mainthread, i, hadCake);
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
				
		System.out.println("All Guests have visted the labryinth");

	}
		public boolean AreWeDone() {
			return weAreDone;
		}

		public void setDone(boolean weAreDone) {
			this.weAreDone = weAreDone;
		}
       
}

