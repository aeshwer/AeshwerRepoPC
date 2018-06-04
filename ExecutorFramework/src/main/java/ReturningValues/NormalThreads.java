/*
 * Task return values not thread
 */
package ReturningValues;

public class NormalThreads {

	public static void main(String[] args) {
		
		String currentThread = Thread.currentThread().getName(); 
		
		System.out.println(currentThread + "Main Thread Starts Here");
		
		ValueReturningTask task1 =new ValueReturningTask(1, 4, 2000);
		Thread t1 =new Thread(task1,"Thread--1");
		ValueReturningTask task2 =new ValueReturningTask(1, 4, 2000);
		Thread t2 =new Thread(task2,"Thread--2");
	    ValueReturningTask task3 =new ValueReturningTask(1, 4, 2000);
	    Thread t3 =new Thread(task3,"Thread--3");
		
	    t1.start();
	    t2.start();
	    t3.start();

	    System.out.println("Result-1 =" + task1.getSum());
	    System.out.println("Result-2 =" + task2.getSum());
	    System.out.println("Result-3 =" + task3.getSum());
	    
		System.out.println(currentThread + "Main Thread ENDS Here");
	}

}
