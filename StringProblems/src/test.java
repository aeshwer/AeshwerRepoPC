import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class test {

	public static void main(String[] args) {
		
		int arr[]   = new int[10];
		arr[0]=1;
		arr[2]=3;
		arr[3]=12;
		arr[1]=33;
		List<Integer> list = new ArrayList<>();
		list =Arrays.stream(arr).boxed().collect(Collectors.toList());
		Collections.sort(list);
		int N=100;
		int temp=N;
		Iterator<Integer> itr = list.iterator();
        while(itr.hasNext())
        {
        	System.out.println(itr.next() + " ");
        	
        }
		
	}
}
