import java.util.Scanner;
import java.util.Stack;

public class StackStick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner inputScanner = new Scanner(System.in);
		char[] input=inputScanner.nextLine().toCharArray();
		char prev=' '; int count=0;
		Stack st = new Stack();
		for(int i=0; i<input.length; i++){
			
			if(input[i] == '(') {
				//push
				st.push(input[i]);
			}
			else if(input[i]==')'){
				st.pop();
				if(prev==')') 
					count++;
				
				else if(prev=='(')
					count +=st.size();
			}
			prev=input[i];
		}
		System.out.println(count);
		
	}

}
