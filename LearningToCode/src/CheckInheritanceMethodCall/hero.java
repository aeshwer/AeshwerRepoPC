package CheckInheritanceMethodCall;

public class hero extends Actor
{
	void fuck()
	{
		System.out.println("Hero fuck");
	}
	@Override
	void dance()
	{
		System.out.println("Hero dance");
	}
}