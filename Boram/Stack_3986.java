import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Stack_3986 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();
		int goodCount = 0;
		Stack<Character> myStack;
		String str;
		
		for(int i = 0; i < count; i++){
			str = input.next(); 
			myStack = new Stack<Character>();
			char word; 
			try{
			for (int j = 0; j < str.length(); j++){				
				word = str.charAt(j);
				if(j==0){
					myStack.push(word);
				}			
				else if(myStack.isEmpty() || myStack.peek()!=word){
					myStack.push(word);
				}		
				else if(myStack.peek()==word){
					myStack.pop(); 
				}						
			}
			if(myStack.isEmpty()){goodCount++;}
			
			}catch(EmptyStackException e){
			e.toString();
			}
		}			
		System.out.println(goodCount);		
	}

}
