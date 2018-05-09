/*
 * The code execution will block or wait for the event before continuing. 
 * Until your event returns a response your program will not execute any further.
 * So Basically the callback performs all its work before returning to the call statement. 
 * The problem with synchronous callback is that they appear to lag.
 */
package Callbacks;

interface OnGeekEventListener {
	 //1) Define the methods in an interface that we want to invoke after callback.
    // this can be any type of method
    void onGeekEvent();
}
 
public class SynchronousCallback {
	
	//3) Define a reference in other class to register the callback interface.
	private OnGeekEventListener mListener; // listener field
	 
    // setting the listener
    public void registerOnGeekEventListener(OnGeekEventListener mListener)
    {
        this.mListener = mListener;
    }
 
    // my synchronous task
    public void doGeekStuff()
    {
 
        // perform any operation
        System.out.println("Performing callback before synchronous Task");
 
        // check if listener is registered.
        if (this.mListener != null) {
        	// 4)Use that reference to invoke the callback method
            // invoke the callback method of class A
            mListener.onGeekEvent();
        }
    }
 
    // Driver Function

	public static void main(String[] args) {
		
			SynchronousCallback obj = new SynchronousCallback();
	        OnGeekEventListener mListener = new A();
	        obj.registerOnGeekEventListener(mListener);
	        obj.doGeekStuff();
		
	}
}


//1) Define a class that will implement the callback methods of the interface.
class A implements OnGeekEventListener {
	 
    @Override
    public void onGeekEvent()
    {
        System.out.println("Performing callback after synchronous Task");
        // perform some routine operation
    }
    // some class A methods
}
