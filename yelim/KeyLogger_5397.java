import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * 스택 두개 이용
 * */
public class KeyLogger_5397 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 테스트 케이스 갯수
		Stack<Character> leftStack;
		Stack<Character> rightStack;
		
		for(int i=0; i<n; i++) {
			char [] chArr = sc.next().toCharArray();
			
			leftStack = new Stack<Character>();
			rightStack = new Stack<Character>();
			
			// 커서 기준으로 left/rigth
			for(char ch : chArr) {
				switch (ch) {
				case '<':
					if(!leftStack.empty()) // 커서 기준 앞이 비어 있지 않다면 이동 할 수 있음
						rightStack.push(leftStack.pop());					
					break;

				case '>':
					if(!rightStack.empty()) 
						leftStack.push(rightStack.pop());
					break;
					
				case '-':
					if(!leftStack.empty())
						leftStack.pop();
					break;
					
				default:
					leftStack.push(ch);
					break;
				}
			}
			
			for(int j=0; j<leftStack.size(); j++) {
				System.out.print(leftStack.get(j));
				System.out.print(rightStack.get(j));
			}
			System.out.println();
		}
	}
}
