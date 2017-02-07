package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class KeyLogger5397 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCount = sc.nextInt();
		for (int i = 0; i < testCount; i++) {
			String input = sc.next();
			System.out.println(solve(input));
		}
	}

	private static String solve(String input) {
		Stack<Character> resultStack = new Stack<>();
		Stack<Character> tempStack = new Stack<>();
		char[] insertArray = input.toCharArray();
		for (char c : insertArray) {
			if (c == '<') {
				if (!resultStack.isEmpty())
					tempStack.push(resultStack.pop());
			} else if (c == '>') {
				if (!tempStack.isEmpty())
					resultStack.push(tempStack.pop());
			} else if (c == '-') {
				if (!resultStack.isEmpty())
					resultStack.pop();
			} else {
				resultStack.push(c);
			}
		}
		while (!tempStack.isEmpty()) {
			resultStack.push(tempStack.pop());
		}

		while (!resultStack.isEmpty()) {
			tempStack.push(resultStack.pop());
		}
		StringBuffer sp = new StringBuffer();
		while (!tempStack.isEmpty()) {
			sp.append(tempStack.pop());
		}

		return sp.toString();
	}

}
