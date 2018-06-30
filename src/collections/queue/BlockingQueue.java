package collections.queue;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {
	
	private List<Object> queue = new LinkedList<Object>();
	private int limit = 10;
	
	public BlockingQueue(int limit) {
		this.limit = limit;
	}
	
	public synchronized void enqueue(Object item) throws InterruptedException {
		if (queue.size() == limit) {
			wait();
		}
		
		if (queue.size() == 0){
			notifyAll();
		}
		queue.add(item);
	}
	
	public synchronized Object dequeue() throws InterruptedException {
		if (queue.size() == 0) {
			wait();
		}
		
		if (queue.size() == limit) {
			notifyAll();
		}
		return queue.remove(0);
	}

}
