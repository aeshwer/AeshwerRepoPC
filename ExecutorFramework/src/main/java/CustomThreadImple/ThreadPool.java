package CustomThreadImple;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

    private BlockingQueue taskQueue = null;
    private List<PoolThread> threads = new ArrayList<PoolThread>();
    private boolean isStopped = false;

    public ThreadPool(int noOfThreads, int maxNoOfTasks){
        taskQueue = new BlockingQueue(maxNoOfTasks);

        for(int i=0; i<noOfThreads; i++){
            threads.add(new PoolThread(taskQueue));
        }
        for(PoolThread thread : threads){
            thread.start();
        }
    }

    //To execute a task the method ThreadPool.execute(Runnable r) is called with a Runnable implementation as parameter
    //The Runnable is enqueued in the blocking queue internally, waiting to be dequeued.
    //The Runnable will be dequeued by an idle PoolThread and executed. 
    public synchronized void  execute(Runnable task) throws Exception{
        if(this.isStopped) throw
            new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.enqueue(task);
    }

    /*To stop the ThreadPool the method ThreadPool.stop() is called. The stop called is noted internally in the isStopped member. 
    Then each thread in the pool is stopped by calling doStop() on each thread. 
    Notice how the execute() method will throw an IllegalStateException if execute() is called after stop() has been called.*/
    public synchronized void stop(){
        this.isStopped = true;
        for(PoolThread thread : threads){
           thread.doStop();
        }
    }

}