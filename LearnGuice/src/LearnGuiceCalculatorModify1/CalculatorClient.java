package LearnGuiceCalculatorModify1;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class CalculatorClient {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new CalculatorModule());
		Calculator calculator = injector.getInstance(Calculator.class);
		System.out.println(calculator);
		System.out.println("ADD " + calculator.add(100, 200));
		System.out.println("SUB " + calculator.sub(700, 200));
		System.out.println("MUL " + calculator.mul(10, 20));

		Calculator calculator2 = injector.getInstance(Calculator.class);
		System.out.println(calculator2);
		// calculator and calculator2 will be different objects if not binded in singleton scope
	
	}
}
