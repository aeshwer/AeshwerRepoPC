package BussySpiningProblemExample;

public class ConsumerThread implements Runnable{
	
    ProducerThread pt;
    ConsumerThread(ProducerThread pt){
        System.out.println("Constructor Consumer Thread");
        this.pt = pt;
    }
    @Override
    public void run() { 
      // Busy spinning loop   
        while(this.pt.flag){
            System.out.println("Waiting busy spinning");
        }
        System.out.println("Consumer starting");
        for(Integer i: this.pt.sharedListObj){
            System.out.println("" + i);
        }
    }
}
