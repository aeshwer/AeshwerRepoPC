// Atomic Reference
// The AtomicStampedReference is designed to solve the A-B-A problem. 
// The A-B-A problem is when a reference is changed from pointing to A, then to B and then back to A.
// https://en.wikipedia.org/wiki/ABA_problem


// Thread 1 can copy the reference and stamp out of the AtomicStampedReference atomically using get(). If another thread changes 
// the reference from A to B and then back to A, then the stamp will have changed (provided threads update the stamp sensibly - e.g increment it).
package ExtraOnMultiThreadingfWorld;

import java.util.concurrent.atomic.AtomicStampedReference;

//Atomic Stamped Reference
public class AtomicStampedRefernceABAProblemDetection {

	public static void main(String[] args) {
		String initialRef   = "text";
		int initialStamp = 0;
		AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<String>(initialRef, initialStamp);
		
		int[] stampHolder = new int[1];
		Object ref = atomicStampedReference.get(stampHolder);

		if(ref == null){
		    //prepare optimistic modification
		}

		//if another thread changes the reference and stamp here,
		//it can be detected

		int[] stampHolder2 = new int[1];
		Object ref2 = atomicStampedReference.get(stampHolder);

		if(ref == ref2 && stampHolder[0] == stampHolder2[0]){
		    //no modification since optimistic modification was prepared

		} else {
		    //retry from scratch.
		}
	}

}
