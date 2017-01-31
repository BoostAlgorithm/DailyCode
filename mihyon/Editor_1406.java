import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Editor_1406 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner (System.in);
		char[] input=inputScanner.nextLine().toCharArray();
		int lines = inputScanner.nextInt();
		ArrayList<Character> al = new ArrayList<Character>(input.length*2);
		for(char i : input){
			al.add(i);	
		}
		ListIterator iter=al.listIterator();
		while(iter.hasNext())
			iter.next();
		/* 현재 포인터 위치(값)이 iter (커서의 왼쪽)일때,
		 * 삭제와 왼쪽 이동은 previous
		 * 삽입은 current
		 * 오른쪽 이동은 next
		 */
		for(int i=0; i<lines; i++){
			switch (inputScanner.next()){
			case "P":
				//현재 포인터 다음의 위치에 add시키고 포인터 이동
				iter.add(inputScanner.next());
				break;
			case "L":
				if(!al.isEmpty()&&iter.hasPrevious())
					iter.previous();
				
				break;
			case "D":
				if(!al.isEmpty()&&iter.hasNext())
					iter.next();
				
				break;
			case "B":
				if(!al.isEmpty()&&iter.hasPrevious()){
					iter.previous();
					iter.remove();
				}
				break;
			}
		}
		
		while(iter.hasPrevious())
			iter.previous();
		while(iter.hasNext())
			System.out.print(iter.next());
		
	}

}
