package Lesson2;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test {

	public static void main(String[] args) {
		Integer[] arr = new Integer[]{1,2,3,4,5}; 
		List<Integer> list = Arrays.asList(arr);
		System.out.println(list.toString());
		list=list.stream().filter( element -> element > 3).collect(Collectors.toList());
		System.out.println(list.toString());
	}
}
