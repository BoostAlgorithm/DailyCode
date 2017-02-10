import java.io.*;
import java.util.*;

public class Stack_keyLogger_5397_v3 {
	/** Stack 으로 구현한 Keylogger 문제 풀기 **/
	// 런타임에러, while문 때문인 것 같은데, 이유를 찾지 못함...
	// 시간복잡도 O(n), 공간복잡도 S(n)
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		// firStack: input stack , SecStack: output stack
		Stack<Character> firStack; 
		Stack<Character> secStack;
		// 입력변수 (cnt: 전체 입력 수, test: 한줄 문장전체, word: test.charAt(index)값,)
		int cnt = input.read();
		String test;
		char word;
		// sb: 출력변수
		// StringBuilder sb = new StringBuilder();;

		for (int i = 0; i < cnt; i++) {
			test = input.readLine();
			firStack = new Stack<Character>();
			secStack = new Stack<Character>();		
			for (int j = 0; j < test.length(); j++) {
				word = test.charAt(j);
				switch (word) {
				case '<':
					if (!firStack.empty()) {
						secStack.push(firStack.pop());
					}
					break;
				case '>':
					if (!secStack.empty()) {
						firStack.push(secStack.pop());
					}
					break;
				case '-':
					if (!firStack.empty()) {
						firStack.pop();
					}
					break;
				default:
					firStack.push(word);
					break;
				}
			}
			
			while (!firStack.empty()) {
				secStack.push(firStack.pop());
			}

			while (!secStack.empty()) {
				System.out.print(secStack.pop());
				//sb.append(secStack.pop());
			}
			System.out.println("");
			//System.out.println(sb);
			//sb.delete(0, sb.length());
		}

	}
}
