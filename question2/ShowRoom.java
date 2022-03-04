public class ShowRoom {
	
	private static boolean Available = true;
	
	public ShowRoom() {
	}
	
	
	public synchronized void enterRoom(int id) throws InterruptedException {
		if(Available == false)
			System.out.println("Room BUSY");
		
		while(Available == false) {
			wait();
		}
		
		System.out.println("Guest " + id +" Entering...");	
		Available = false;
		System.out.println("Room Occupied");
		
	}
	
	public synchronized void leaveRoom() {
		Available = true;
		System.out.println("Leaving...");
		notifyAll();
		System.out.println("Room Available");
	}

	public static boolean isAvailable() {
		return Available;
	}

}
