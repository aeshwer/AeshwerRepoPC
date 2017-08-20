package Simulation_Duck_StratergyPattern;
public abstract class Duck {

	FlyBehaviour flyBehaviour;
	QuackBehaviour quackBehaviour;
	
	abstract void display();
	
	void swim()
	{
		System.out.println("All Ducks can Swim");
	}
	
	void performFlying()
	{
		flyBehaviour.performFly();	
	}
	
	void performQucking()
	{
		quackBehaviour.performQuack();
	}
	
	void setflyBehaviour(FlyBehaviour flyBehaviour)
	{
		this.flyBehaviour = flyBehaviour;
	}
	
	void setquackBehaviour(QuackBehaviour quackBehaviour)
	{
		this.quackBehaviour =  quackBehaviour;
	}
	
	
}
