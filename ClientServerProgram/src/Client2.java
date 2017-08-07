import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


public class Client2 {
	
	public static void main(String[] args) throws IOException {
		
		int number , temp ;
		Scanner sc = new Scanner(System.in);
		Socket s = new Socket("127.0.0.1",1900);
		Scanner sc1 = new Scanner(s.getInputStream());
		System.out.println("Enter the number");
		number = sc.nextInt();
		PrintStream p = new PrintStream(s.getOutputStream());
		p.println(number);
		temp= sc1.nextInt();
		System.out.println("Result is : " + temp);
	}
}