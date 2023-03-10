# Multithreading

## Multitasking
Multitasking allows several activities to occur concurrently on the computer.

- Process-based Multitasking
- Thread-based Multitasking

#### Process-based Multitasking
Allows process(i.e. program) to run concurrently on the computer
Eg: Running MS Paint while also working with the word processor

#### Thread-based Multitasking
Allows part of the same program to run concurrently on the computer
Eg: MS word is printing and formatting the words at a same time

## Thread vs Process
- 2 threads share the same address space
- context switching is usually less expensive in threads
- cost of communication is relatively less in the threads

## Why Multithreading
- In a single threaded environment, only one task at a time can be performed
- CPU cycles are wasted, for eg. when waiting for a user i/p
- Multitasking allows idle CPU time to be put to good use

## Threads:
- A thread is an independent sequential path of execution within a program
- Many threads can run concurrently within a program 
- At runtime, thread in a program exist in a common memory space and can, therefore, share the both data and code (i.e. they are lightweight compared to the process)

## The Main Thread
- when a stand-alone application is run, a user thread is automatically created to execute a main() method of the application. This thread is called the main thread.
- If no other user threads are spawned, the program terminates when the main() method finishes executing
- All other threads, called child threads, are spawned from the main thread
- The main() method can then finish, but the program will keep running until all user threads have completed
- The runtime environment distinguishes between user thread and demon thread
- calling the setDaemon(boolean) method in the Thread class marks the status of the thread as either daemon or user, but this must be done before the thread is started
- As long as user thread is alive, the JVM does not terminate
- A daemon thread is a mercy of the runtime system: It is stopped if there are no more user thread running, thus terminating the program

## Thread creation
#### we can create a thread by 2 ways
- Extending Thread class
- Implementing Runnable Interface

```
public static void main(String[] args) {
	System.out.println("starting main thread");
	
	//DemoThread is a class which Extends Thread class
	Thread t1 = new DemoThread("thread1");
	Thread t2 = new DemoThread("thread2");
	t1.start();
	t2.start();
	
	//DemoThread2 is a class which implements Runnable Interface
	Thread t3 = new Thread(new DemoThread2(), "implemented thread");
	t3.start();
	System.out.println("exiting main thread"); 
}
```

## Synchronization
- Threads share the same memory space, i.e. they can share resources (objects)
- However, there are critical situations where it is desirable that only one thread at a time has access to shared resource

## Synchronized methods
- while a thread is inside a synchronized method of an object, all other threads that wish to execute this synchronized method or any other synchronized method of an object will have to wait
- this restriction does not apply to the thread that already has a lock and is executing a synchronized method of the object 
- such a method can invoke other synchronized methods of the object without being blocked
- the non-synchronized methods can always be called at any time by any thread

## Rules of synchronization
- A thread must acquire the object lock associated with a shared resource before it can enter the shared resource
- The runtime system ensures that no other thread can enter a shared resource if another thread already holds the object lock associated with it
- if a thread cannot immediately acquire the object lock, it is locked, i.e. it must wait for the lock to become available
- when a thread exits a shared resource, the runtime system ensures that the object lock is also relinquished. If another thread is waiting for this object lock it can try to acquire the lock in order to gain the access to the shared resource
- it should be made clear that programs should not make any assumption about the order in which threads are granted ownership of a lock

#####Synchronized block
```
public boolean push(int element) {
	// lock is the object, Object lock = new Object()
	synchronized(lock) {
		if(isFull()) {
			return false;
		}
		stackTop++;
		try {Thread.sleep(1000); } catch (Exception e) {}
		arr[stackTop] = element;
		return true;
	}
}
```

#####Synchronized method: it creates a synchronized block with the object of the class
```
public synchronized boolean push(int element) {
	if(isFull()) {
		return false;
	}
	stackTop++;
	try {Thread.sleep(1000); } catch (Exception e) {}
	arr[stackTop] = element;
	return true;
}
```
above code is equivalent to

```
public boolean push(int element) {
	synchronized(this) {
		if(isFull()) {
			return false;
		}
		stackTop++;
		try {Thread.sleep(1000); } catch (Exception e) {}
		arr[stackTop] = element;
		return true;
	}
}
```

## Static Synchronized method
- A thread acquiring the lock of a class to execute a static synchronized method has no effect on any thread acquiring the lock on any object of the class to execute synchronized instance method
- in other words, synchronization of static method in the class is independent from the synchronization of the instance method on objects of the class

