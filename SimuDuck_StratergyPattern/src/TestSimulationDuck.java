

public class TestSimulationDuck {

	
	public static void main(String[] args) { 
		
		Duck modelDuck = new ModelDuck();
		modelDuck.display();
		modelDuck.performFlying();
		modelDuck.performQucking();
		// changing behaviour at run time
		modelDuck.setquackBehaviour(new Squeek());
		modelDuck.performQucking();
		
		
	}
	
}
