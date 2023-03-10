package sunchronization;

public class Stack {
	private int[] arr;
	private int stackTop;
	Object lock;
	
	public Stack(int capacity) {
		arr = new int[capacity];
		stackTop = -1;
		lock = new Object();
	}
	
	public synchronized boolean push(int element) {
		if(isFull()) {
			return false;
		}
		stackTop++;
		try {Thread.sleep(1000); } catch (Exception e) {}
		arr[stackTop] = element;
		return true;
	}
	
	public int pop(){
		synchronized (this) {
			if(isEmpty()) {
				return Integer.MIN_VALUE;
			}
			int element = arr[stackTop];
			arr[stackTop] = Integer.MIN_VALUE;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			
			stackTop--;
			return element;
		}
	}
	
	public boolean isFull() {
		return stackTop >= arr.length;
	}
	
	public boolean isEmpty() {
		return stackTop < 0;
	}
}
