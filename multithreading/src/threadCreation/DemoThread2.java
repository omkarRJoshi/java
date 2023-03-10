package threadCreation;

public class DemoThread2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("inside demo2 " + Thread.currentThread().getName() + " " + i);
		}
	}
	
}
