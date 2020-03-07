package Company_Solution;

import java.util.HashMap;
import java.util.Map;

public class DummyTester {

	public static class parent {
		private void hello() {
			System.out.println("Hello From Parent");
		}
	}

	public static class child extends parent {
		private void hello() {
			System.out.println("Hello From Child");
		}
	}

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put(new String("A"), 10);
		map.put(new String("B"), 200);
		map.remove(new String("A"));
		System.out.println(map);

		parent A = new parent();
		parent B = new child();
		A.hello();
		B.hello();
	}
}
