import java.io.*;
import java.util.*;

public class Stack_1874 {

	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		int input_count = input.nextInt();
		int number, max = 1;
		Stack<Integer> myStack = new Stack<Integer>();
		
		for (int i = 0; i < input_count; i++){
			number = input.nextInt();
			try{
			if(max < number){
				for(int j = max; j<= number; j++){
					myStack.push(j);
					System.out.println("+");	
				}
				max = number+1;
			}
			
			if(myStack.peek()!=number) {System.out.println("NO");}
			
			else if(myStack.peek()==number){
				myStack.pop();
				System.out.println("-");
			}
					
			}catch(EmptyStackException e){
				e.toString();
			}
		}		
	}

}
