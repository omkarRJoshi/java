package threadCreation;

public class DemoThread extends Thread{
	public DemoThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 50; i++) {
			System.out.println("inside demo thread " + Thread.currentThread().getName() + " " + i);
		}
	}
}
