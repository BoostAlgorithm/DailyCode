import java.io.*;
import java.util.*;

public class Stack_keyLogger_5397_v3 {
	/** Stack ���� ������ Keylogger ���� Ǯ�� **/
	// ��Ÿ�ӿ���, while�� ������ �� ������, ������ ã�� ����...
	// �ð����⵵ O(n), �������⵵ S(n)
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		// firStack: input stack , SecStack: output stack
		Stack<Character> firStack; 
		Stack<Character> secStack;
		// �Էº��� (cnt: ��ü �Է� ��, test: ���� ������ü, word: test.charAt(index)��,)
		int cnt = input.read();
		String test;
		char word;
		// sb: ��º���
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
