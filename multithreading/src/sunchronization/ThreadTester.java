package sunchronization;

public class ThreadTester {

	public static void main(String[] args) {
		Stack stack = new Stack(5);
		
		new Thread(() -> {
			for(int i = 0; i < 10; i++) {
				boolean pushed = stack.push(100);
				System.out.println("push status for " + i + " is " + pushed);
			}
		}).start();
		
		new Thread(() -> {
			for(int i = 0; i < 10; i++) {
				int poped = stack.pop();
				System.out.println("popped element for " + i + " is " + poped);
			}
		}).start();
	}

}
