package LearnGuiceCalculatorModify2;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class CalculatorService {

	@Inject
	@Named("Real")
	private ICalculator calculator;
	
	public int calculate(int a,int b ,String oper) 
	{
		if(oper.equalsIgnoreCase("add"))
		{
			return calculator.add(a, b);
		}

		else if(oper.equalsIgnoreCase("sub"))
		{
			return calculator.sub(a, b);
		}
		
		else if(oper.equalsIgnoreCase("mul"))
		{
			return calculator.mul(a, b);
		}
		return 0;
	}
	
	
}
