package ExtraOnMultiThreadingfWorld;
import java.util.concurrent.atomic.AtomicStampedReference;

//Atomic Stamped Reference
//The get() method returns the reference as return value from the method. The stamp is inserted into an int[] array that is passed as parameter to the get() method.
//Being able to obtain both reference and stamp as a single atomic operation is important for some types of concurrent algorithms
public class AtomicStampedRefernceExample {

	public static void main(String[] args) {
		String initialRef   = "text";
		int initialStamp = 0;

		AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<String>(initialRef, initialStamp);

		int[] stampHolder = new int[1];
		Object ref = atomicStampedReference.get(stampHolder);

		System.out.println("ref = " + ref);
		System.out.println("stamp = " + stampHolder[0]);


		// Part 2 of this
		String initialRef2 = "initial value referenced";
		int initialStamp2 = 0;
		AtomicStampedReference<String> atomicStringReference = new AtomicStampedReference<String>( initialRef2, initialStamp2);

		String newRef = "new value referenced";
		int newStamp2 = initialStamp2 + 1;

		boolean exchanged = atomicStringReference.compareAndSet(initialRef2, newRef, initialStamp2, newStamp2);
		System.out.println("exchanged: " + exchanged);  //true

		exchanged = atomicStringReference.compareAndSet(initialRef2, "new string", newStamp2, newStamp2 + 1); // both the stamp and ref value should be same ,then only the swap operation occurs
		System.out.println("exchanged: " + exchanged);  //false

		exchanged = atomicStringReference.compareAndSet(newRef, "new string", initialStamp2, newStamp2 + 1);
		System.out.println("exchanged: " + exchanged);  //false

		exchanged = atomicStringReference.compareAndSet(newRef, "new string", newStamp2, newStamp2 + 1);
		System.out.println("exchanged: " + exchanged);  //true
	}

}
