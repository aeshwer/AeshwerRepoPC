/*
 * An Asynchronous call do not block the program from the code execution. 
 * when the call returns from the event the call returns back to the callback function.
 *  So in the context of java we have to Create a new thread invoke the callback method inside that thread. 
 *  Callback may be invoked from a thread but is not a requirement. A Callback may also start a new thread thus making 
 *  themselves asynchronous.
 */
package Callbacks;

//Java program to illustrate Asynchronous callback

interface OnGeekEventListener1 {

 // this can be any type of method
 void onGeekEvent();
}

public class AsynchrouousCallbacks {
	
	private OnGeekEventListener1 mListener; // listener field
	 
    // setting the listener
    public void registerOnGeekEventListener1(OnGeekEventListener1 mListener)
    {
        this.mListener = mListener;
    }
 
    // My Asynchronous task
    public void doGeekStuff()
    {
 
        // An Async task always executes in new thread
        new Thread(new Runnable() {
            public void run()
            {
 
                // perform any operation
                System.out.println("Performing operation in Asynchronous Task");
 
                // check if listener is registered.
                if (mListener != null) {
 
                    // invoke the callback method of class A
                    mListener.onGeekEvent();
                }
            }
        }).start();
    }

	public static void main(String[] args) {
		AsynchrouousCallbacks obj = new AsynchrouousCallbacks();
	        OnGeekEventListener1 mListener = new B();
	        obj.registerOnGeekEventListener1(mListener);
	        obj.doGeekStuff();
		
	}
}


class B implements OnGeekEventListener1 {
 
    @Override
    public void onGeekEvent()
    {
        System.out.println("Performing callback after Asynchronous Task");
        // perform some routine operation
    }
    // some class A methods
}