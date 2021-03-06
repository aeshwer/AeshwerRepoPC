package com.udermy.DinnerPhilosopher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DinnerPhiloApp {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executerService = null;
		Philosopher[] philosopher = null;
		
		try
		{
			philosopher= new Philosopher[Constants.NUMBER_OF_PHILOSOPHER];
			Chopsitick[] Chopsiticks = new Chopsitick[Constants.NUMBER_OF_CHOPSTICKS];
			executerService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHER);
			
			for(int i=0;i<Constants.NUMBER_OF_CHOPSTICKS ; i++ )
			{
				// initializing the chopsticks with id and each get a new reentrant lock also(see constructor)
				Chopsiticks[i] =new Chopsitick(i);
			}
			
			for(int i=0;i<Constants.NUMBER_OF_PHILOSOPHER ; i++ )
			{
				philosopher[i] = new Philosopher(i, Chopsiticks[i],Chopsiticks[(i+1) % Constants.NUMBER_OF_CHOPSTICKS] );   // assign 2 chopstick to each philosoper
				executerService.execute(philosopher[i]);
			}
			
			Thread.sleep(Constants.SIMULATION_RUNTIME);
			//stop the philosopher by setting the termination flag
			for(Philosopher p : philosopher)
			{
				 p.setFull(true);
			}
			
		}
		finally
		{
			executerService.shutdown();
			while(!executerService.isTerminated()){
				Thread.sleep(1000);
			}
			
			for(Philosopher p : philosopher)
			{
				System.out.println(p+ "eats " +p.getCounter());
			}
			
		}
	}

}
