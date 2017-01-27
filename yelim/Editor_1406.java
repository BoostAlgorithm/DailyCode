import java.util.LinkedList;
import java.util.Scanner;

public class Editor_1406 {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
        
		Scanner sc = new Scanner(System.in);
		LinkedList<Character> list = new LinkedList<Character>();
		char [] ch = sc.next().toCharArray();
		for(char c : ch) list.add(c);
		
		int cursor = list.size();
		
		int n = sc.nextInt(); // 명령어 갯수
		for(int i=0; i<n; i++) {
			switch (sc.next()) {
			case "L":
				if(cursor!=0) cursor--;
				break;
				
			case "D":
				if(cursor!=list.size()) cursor++;
				break;
	
			case "B":
				if(cursor!=0) list.remove(cursor-1);
				break;
	
			case "P":
				list.add(cursor, sc.next().charAt(0));
				cursor++;
				break;
			}
		}
		for(Character c : list) {
			System.out.print(c);
		}
		
		long end = System.currentTimeMillis();
        System.out.println("실행 시간 : " + (double)(end-start)/1000 + "(s)");
	}
}
