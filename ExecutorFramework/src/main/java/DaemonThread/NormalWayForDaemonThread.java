//special service providing and background running threads.. They are killed by the JVM as soon as  all user thread in app finished. 
//Can also be  killed normally 
//Main thread is the  user thread , not daemon thread
// we can put any kind of login in the daemon thread
package DaemonThread;

public class NormalWayForDaemonThread {

	public static void main(String[] args) {
	
	String currentThread = Thread.currentThread().getName(); 
	
	System.out.println(currentThread + "Main Thread Starts Here");
	
	Thread t1=new Thread(new LoopTaskD(500), "Thread-1");
	Thread t2=new Thread(new LoopTaskD(100), "Thread-2");
	t2.setDaemon(true);
	
	t1.start();
	t2.start();
	
	// In result observe that thread 2 will be killed suddenly after thread 1 is finished since thread 2 is daemon and is killed as soon as 
	// as there is no active user thread(main + thread 1)
	
	System.out.println(currentThread + "Main Thread ENDS Here");
	}
}