import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * Run the server first and then the client
 */
public class Client {
	
	public static void main(String[] args) throws IOException {
		//hi
		//Open a client socket and accept the number 
		Socket chatSocket = new Socket("127.0.0.1",1900);
		BufferedReader read  = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number");
		int number = Integer.parseInt(read.readLine());
		
		//pass the number to the server
		PrintWriter write = new PrintWriter(chatSocket.getOutputStream());
		write.println(number);
		
		//Accept the result from the server
		InputStreamReader stream = new InputStreamReader(chatSocket.getInputStream());
		BufferedReader readFromServer  = new BufferedReader(stream);
		int result = Integer.parseInt(readFromServer.readLine());
		System.out.println("Result is : " + result);
	}

}
