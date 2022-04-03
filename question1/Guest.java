import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class Guest implements Runnable {
	
	private Cake cake;
	private int id;
	public int counter = 0;
	public static Lock lock = new ReentrantLock();
	public static boolean[] hadCake;
	public boolean notifyMinotaur = false;
	// public boolean[] doneThreads; 
	public int numGuests;
	Main th;
	boolean done = false;
	
	public Guest(Main mainthread, int id, boolean[] hadCake) {
		cake = new Cake();
		this.th = mainthread;
		this.id = id;
		this.hadCake = hadCake;
		numGuests = hadCake.length;
	}

	@Override
	public void run() {
		 while(!done && !th.AreWeDone()){
			lock.lock();
			try{
				System.out.println("Guest " + id + " in maze");
				System.out.println("Found way out");
				
				if (id == 0) {
					if (cake.isAvailable()) {
						System.out.println("no one ate cake");
					}
					else {
						System.out.println("oops no cake, gotta replace it");
						cake.orderCake();
						counter++;
					}
				}
				else {
					if(!cake.isAvailable()) {
						System.out.println("no cake :/");
					}
					else{
						if (hadCake[id]){
							System.out.println("I aready had cake");
						}
						else{
							cake.eatCake();
							hadCake[id] = true;
							System.out.println("Yum.. cupcake");
						}
					}
				}
				
				if (counter == numGuests-1) {
					notifyMinotaur = true;
					System.out.println("Finally my cupckae.. We all had cake! YAY\n");
					System.out.println("We are done Mr. Minatour");
					th.setDone(true);
				}
				
			}
			finally{
				lock.unlock();
			}

			try{
				Thread.sleep(1000);
			} catch (Exception e) {
				}

			done = false;
			th.doneThreads[id] = true;
			

			// while (!done) {
			// 	try {
			// 		Thread.sleep(100);
			// 		done = true;
			// 		for (int i = 0; i < numGuests; i++) {
			// 			if (!th.doneThreads[i]) {
			// 				done = false;
			// 				break;
			// 			}
			// 		}
			// 	} catch (Exception e) {
			// 	}
			// }
			
		}
	}

}
