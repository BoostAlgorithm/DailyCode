import java.io.*;
import java.util.*;

public class Stack_keyLogger_5397_v1 {
	/** Stack 으로 구현한 Keylogger 문제 풀기 **/
	// 시간복잡도 O(n), 공간복잡도 S(n)
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> firStack = new Stack<Character>(); // firStack: input stack 
		Stack<Character> secStack = new Stack<Character>(); // SecStack: output stack
		 // cursor: 커서의 현재위치, left: '<' 커서 왼쪽 이동횟 수, right: '>' 커서 오른쪽 이동횟수
		int cursor, right, left;
		// 입력변수 (cnt: 전체 입력 수, test: 한줄 문장전체, word: test.charAt(index)값,) 출력변수 (sb)
		int cnt = input.read();
		String test;
		char word;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < cnt; i++) {
			test = input.readLine();
			cursor = 0;
			right = 0;
			left = 0;
			for (int j = 0; j < test.length(); j++) {
				word = test.charAt(j);
				switch (word) {
				case '<':
					if (firStack.empty()) {
						continue;
					}
					cursor--;
					left++;
					// System.out.println("<, cursor --: " + cursor);
					break;
				case '>':
					if (cursor == firStack.size() + secStack.size()) {
						continue;
					}
					cursor++;
					right++;
					// System.out.println(">, cursor ++: " + cursor);
					break;
				case '-':
					if (firStack.empty()) {
						continue;
					} else if (cursor > 0 && cursor < firStack.size()) {
						cursor--;
					}
					firStack.pop();
					break;
				default:
					firStack.push(word);
					// System.out.println("firStack.push():" + firStack.peek());
					cursor++;
				}
				
				if (left > 0) {
					for (int k = 0; k < left; k++) {
						if (firStack.empty()) {
							break;
						}
						secStack.push(firStack.pop());
					}
					left = 0;

				}else if (right > 0) {
					for (int f = 0; f < right; f++) {
						if (secStack.empty()) {
							break;
						}
						firStack.push(secStack.pop());
					}
					right = 0;
				}

			}
			while (!firStack.empty()) {
				secStack.push(firStack.pop());
			}

			while (!secStack.empty()) {
				sb.append(secStack.pop());
			}
			System.out.println(sb.toString());
			sb.delete(0, sb.length());
		}

	}
}
