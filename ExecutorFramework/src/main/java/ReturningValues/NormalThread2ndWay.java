package ReturningValues;

public class NormalThread2ndWay {
	
	public static void main(String[] args) {
		
	String currentThread = Thread.currentThread().getName(); 
	
	System.out.println(currentThread + "Main Thread Starts Here");
	
	ValueReturningTaskB task1 =new ValueReturningTaskB(1, 4, 2000,new SumObserver("task-1"));
	Thread t1 =new Thread(task1,"Thread--1");
	ValueReturningTaskB task2 =new ValueReturningTaskB(1, 4, 1000,new SumObserver("task-2"));
	Thread t2 =new Thread(task2,"Thread--2");
    ValueReturningTaskB task3 =new ValueReturningTaskB(1, 4, 500,new SumObserver("task-3"));
    Thread t3 =new Thread(task3,"Thread--3");
	
    t1.start();
    t2.start();
    t3.start();

    //System.out.println("Result-1 =" + task1.getSum()); removed calls to get sum... we will use call back method here+ observer pattern
    //System.out.println("Result-2 =" + task2.getSum());
    //System.out.println("Result-3 =" + task3.getSum());
    
	System.out.println(currentThread + "Main Thread ENDS Here");
}

}
