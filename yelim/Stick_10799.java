import java.util.Scanner;
import java.util.Stack;


public class Stick_10799 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char sticks[] = sc.next().toCharArray();
		char preChar='\u0000';
		Stack<Character> stack = new Stack<Character>();
		int count=0;
		
		for(char ch : sticks) {
			if(ch=='(') {
				stack.push(ch);
			} else {
				stack.pop();
				if(preChar=='(') {
					count+=stack.size();
				} else {
					count++;
				}
			}
			preChar=ch;
		}
		System.out.println(count);
	}

}
