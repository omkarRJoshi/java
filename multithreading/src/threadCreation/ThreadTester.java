package threadCreation;

public class ThreadTester {

	public static void main(String[] args) {
		System.out.println("starting main thread");
		Thread t1 = new DemoThread("thread1");
		Thread t2 = new DemoThread("thread2");
		t1.start();
		t2.start();
		
		//DemoThread2 is a class which implements Runnable Interface
		Thread t3 = new Thread(new DemoThread2(), "implemented thread");
		t3.start();
		System.out.println("exiting main thread"); 
	}

}
