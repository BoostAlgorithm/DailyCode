import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * ���� �ΰ� �̿�
 * */
public class KeyLogger_5397 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // �׽�Ʈ ���̽� ����
		Stack<Character> leftStack;
		Stack<Character> rightStack;
		
		for(int i=0; i<n; i++) {
			char [] chArr = sc.next().toCharArray();
			
			leftStack = new Stack<Character>();
			rightStack = new Stack<Character>();
			
			// Ŀ�� �������� left/rigth
			for(char ch : chArr) {
				switch (ch) {
				case '<':
					if(!leftStack.empty()) // Ŀ�� ���� ���� ��� ���� �ʴٸ� �̵� �� �� ����
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
