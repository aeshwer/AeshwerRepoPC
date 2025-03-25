package BussySpiningProblemExample;

import java.util.ArrayList;
import java.util.List;

public class ProducerThread implements Runnable{
	
	List<Integer> sharedListObj;
    boolean flag;
    
    ProducerThread(){
        System.out.println("Constructor Producer Thread");
        this.sharedListObj = new ArrayList<Integer>();
        this.flag = true;
    }
    @Override
    public void run() {
        System.out.println(" Producer Thread run");
        for(int i = 0; i < 5; i++){
            System.out.println("Adding to queue - " + Thread.currentThread().getName() + " " + i);
            sharedListObj.add(i);
        }
        flag = false;        
    }   

}
