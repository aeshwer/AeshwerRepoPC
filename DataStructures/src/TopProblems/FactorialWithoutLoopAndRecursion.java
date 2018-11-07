package TopProblems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.Timer;

public class FactorialWithoutLoopAndRecursion {
	
	private static int factorial(int _n) {
        final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);
        final Timer timer = new Timer(0, null);
        timer.addActionListener(new ActionListener() {
        	 int result = 1;
             int n = _n;
			@Override
			public void actionPerformed(ActionEvent e) {
				result *= n;
                n--;
                if(n == 0) 
                {
                    try {
                        queue.put(result);
                    } catch(Exception ex) {
                    }
                    timer.stop();
                }
			}
		});
        
        timer.start();
        int result = 0;
        try {
            result = queue.take();
        } catch(Exception ex) {
        }
        return result;
}

	public static void main(String[] args) {
		 System.out.println(factorial(5));
	}
}
