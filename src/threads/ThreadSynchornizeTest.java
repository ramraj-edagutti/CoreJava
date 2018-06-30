package threads;

public class ThreadSynchornizeTest {
	
	public static void main(String[] args) {
		
		final SimpleThreadSynchronize sts = new SimpleThreadSynchronize();
		
		Runnable t1 = new Runnable() {
			@Override
			public void run() {
				sts.methodThree();
			}
		};
		new Thread(t1).start();
		
		Runnable t2 = new Runnable() {
			@Override
			public void run() {
				sts.methodTwo();
			}
		};
		new Thread(t2).start();
		
		Runnable t3 = new Runnable() {
			@Override
			public void run() {
				sts.methodOne();
			}
		};
		new Thread(t3).start();
		
	}

}
