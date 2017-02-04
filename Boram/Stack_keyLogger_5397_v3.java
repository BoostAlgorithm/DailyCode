import java.io.*;
import java.util.*;

public class Stack_keyLogger_5397_v3 {
	/** Stack 으로 구현한 Keylogger 문제 풀기 **/
	// 시간복잡도 O(n), 공간복잡도 S(n)
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> firStack; // firStack: input stack
		Stack<Character> secStack; // SecStack: output stack
		// cursor: 커서의 현재위치
		int cursor;
		// 입력변수 (cnt: 전체 입력 수, test: 한줄 문장전체, word: test.charAt(index)값,)
		int cnt = input.read();
		String test;
		char word;
		// sb: 출력변수
		StringBuilder sb;

		for (int i = 0; i < cnt; i++) {
			test = input.readLine();
			cursor = 0;
			firStack = new Stack<Character>();
			secStack = new Stack<Character>();
			sb = new StringBuilder();
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
				}
			}
			while (!firStack.empty()) {
				secStack.push(firStack.pop());
			}

			while (!secStack.empty()) {
				sb.append(secStack.pop());
			}
			System.out.println(sb.toString());
			//sb.delete(0, sb.length());
		}

	}
}
