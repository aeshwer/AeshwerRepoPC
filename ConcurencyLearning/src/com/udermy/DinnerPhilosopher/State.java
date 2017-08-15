package com.udermy.DinnerPhilosopher;

public enum State {

	LEFT(),RIGHT;
	
	public String getDisplayString(State state){
		
		if(state == LEFT)
		{
			return "left Choptick ";
		}
		else
		{
			return "right Choptick ";
		}
	}
}
