import java.io.*;
import java.util.*;

public class Stack_keyLogger_5397_v2 {
	/** Stack ���� ������ Keylogger ���� Ǯ�� **/
	// �ð����⵵ O(n), �������⵵ S(n)
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> firStack = new Stack<Character>(); // firStack: input stack 
		Stack<Character> secStack = new Stack<Character>(); // SecStack: output stack
		 // cursor: Ŀ���� ������ġ
		int cursor, right, left;
		// �Էº��� (cnt: ��ü �Է� ��, test: ���� ������ü, word: test.charAt(index)��,) 
		int cnt = input.read();
		String test;
		char word;
		// sb: ��º���
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < cnt; i++) {
			test = input.readLine();
			cursor = 0;
			
			for (int j = 0; j < test.length(); j++) {
				word = test.charAt(j);
				switch (word) {
				case '<':
					if (firStack.empty()) {
						continue;
					}
					cursor--;
					secStack.push(firStack.pop());
					break;
				case '>':
					if (cursor == firStack.size() + secStack.size()) {
						continue;
					}
					cursor++;
					firStack.push(secStack.pop());
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
					cursor++;
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
