import java.util.*;

public class Stack_10799 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String stick = input.nextLine();
		int total =0, iron = 0;
		
		for(int i = 0; i < stick.length(); i++){		
			if(stick.charAt(i)=='('){
				iron++;				
			}
			else{				
				if(stick.charAt(i-1)=='(') { iron--; total+=iron; }
				else{ iron--; total++; }	
			}
		}
		System.out.println(total);	
		
	}

}
