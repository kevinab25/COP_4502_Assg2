import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Guest implements Runnable {
	
	private ShowRoom room;
	private int id;
	public static Lock lock = new ReentrantLock();

	
	public Guest(int id) {
		room = new ShowRoom();
		this.id = id;
	}

	@Override
	public void run() {
		lock.lock();
		synchronized (room) {
			try {
				room.enterRoom(id);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
			
		room.leaveRoom();
		lock.unlock();
	}

}
