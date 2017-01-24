
import java.util.Scanner;
import java.util.Stack;
public class StackAB_3986 {

		public static void main(String[] args) {
			Scanner inputScanner = new Scanner(System.in);
			int lines=Integer.parseInt(inputScanner.nextLine());
			int count=0;
			for(int j=0; j<lines; j++){
				
				char[] input=inputScanner.nextLine().toCharArray();
				Stack st = new Stack();
				for(int i =0; i<input.length; i++){
					if(st.isEmpty()) {
						st.push(input[i]);
						continue;
					}
					char top=(char) st.pop();
					if(input[i]!=top){
						st.push(top);
						st.push(input[i]);
					}
				}
				if(st.isEmpty()) count++; 
			}
			System.out.println(count);
		}
	
}
