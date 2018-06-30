package threads;

public class SimpleThreadSynchronize {
	
	public void methodOne() {
		System.out.println("I am method one..");
	}
	
	public synchronized void methodTwo() {
		System.out.println("I am method two..");
	}
	
	public synchronized void methodThree() {
		System.out.println("I am method three..start sleeping");
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("I am method three..end sleeping");
	}

}
