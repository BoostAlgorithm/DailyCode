import java.util.Scanner;
import java.util.Stack;

public class StackStick_v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner inputScanner = new Scanner(System.in);
		char[] input=inputScanner.nextLine().toCharArray();
		char prev=' '; int count=0;
		int size=0;
		for(int i=0; i<input.length; i++){
			
			if(input[i] == '(') {
				//push
				size++;
			}
			else if(input[i]==')'){
				size--;
				if(prev==')') 
					count++;
				
				else if(prev=='(')
					count +=size;
			}
			prev=input[i];
		}
		System.out.println(count);
		
	}
}
