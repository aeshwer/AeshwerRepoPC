//Atomic Reference

package ExtraOnMultiThreadingfWorld;
import java.util.concurrent.atomic.AtomicReference;

//Atomic reference should be used in a setting where you need to do simple atomic (i.e. thread safe, non-trivial) operations on a reference, 
//for which monitor-based synchronization is not appropriate. 

public class AtomicRefernceExample {

	public static void main(String[] args) {
		String initialReference = "initial value referenced";
		AtomicReference<String> atomicStringReference = new AtomicReference<String>(initialReference);

		String newReference = "new value referenced";
		boolean exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
		System.out.println("exchanged: " + exchanged);

		exchanged = atomicStringReference.compareAndSet(initialReference, newReference);
		System.out.println("exchanged: " + exchanged);
	}

}
