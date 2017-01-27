import java.io.*;
import java.util.*;

public class Stack_1874 {

	public static void main(String[] args) throws IOException {
		// 스택 수열 _ Error_ 출력초과 에러 : int배열로 스택 만들어 보기
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int input_count = Integer.parseInt(input.readLine());
		int number, max = 1;
		Stack<Integer> myStack = new Stack<Integer>();
		//StringBuilder sb = new StringBuilder();

		for (int i = 0; i < input_count; i++) {
			number = Integer.parseInt(input.readLine());
			try {
				if (max <= number) {
					for (int j = max; j <= number; j++) {
						myStack.push(j);
						System.out.println("+");
						//sb.append("+\n");
					}
					max = number + 1;
					myStack.pop();
					System.out.println("-");
					//sb.append("-\n");
				}

			    else if (myStack.peek() != number) {
					System.out.println("NO");
					//sb.append("NO\n");
				}
                
                else{
                    myStack.pop();
                    System.out.println("-");
                    //sb.append("-\n");
                }

			} catch (EmptyStackException e) {
				e.toString();
			}
		}
		//System.out.println(sb);
	}

}
