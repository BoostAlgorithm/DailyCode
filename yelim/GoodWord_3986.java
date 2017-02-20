import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class GoodWord_3986 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count=0;
		for(int i=0; i<n; i++) {
			String word = br.readLine();
			Stack<Character> st = new Stack<Character>();
			
			for(int j=0; j<word.length(); j++) {
				char ch = word.charAt(j);
				if(!st.empty() && st.peek().equals(ch)) {
					st.pop();
				} else {
					st.add(ch);
				}
			}
			if(st.isEmpty())count++;
		}
		System.out.println(count);
	}

}
