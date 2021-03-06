package StackAndQueues;
// PROS: Easy to implement. Memory is saved as pointers are not involved.
// CONS: It is not dynamic. It doesn�t grow and shrink depending on needs at runtime.

public class StackImplementationUsingArrays {
	
	//instance variable 
	static final int MAX = 1000;
    int top;
    int a[] = new int[MAX]; // Maximum size of Stack
	
    //constructor 
	StackImplementationUsingArrays()
	{
		top = -1;	
	}
	
	 boolean isEmpty()
     {
		 return (top < 0);
	 }

    boolean push(int x)
    {
    	if (top >= MAX)
        {
            System.out.println("Stack Overflow");
            return false;
        }
    	
    	else
        {
            a[++top] = x;
            return true;
        }
    }

    int pop()
    {
    	if (top < 0)
        {
            System.out.println("Stack Underflow");
            return 0;
        }
    	
    	else
        {
            int x = a[top--];
            return x;
        }
    	
    }
    
    void print(){
    	for(int i= 0; i <= top ;i++){
    		System.out.print(a[i] +" ");
    	}
    	System.out.println();
    }
    
    public static void main(String args[])
    {
    	StackImplementationUsingArrays s = new StackImplementationUsingArrays();
        s.push(10);
        s.push(20);
        s.push(30);
        s.print();
        System.out.println(s.pop() + " Popped from stack");
    }
}
