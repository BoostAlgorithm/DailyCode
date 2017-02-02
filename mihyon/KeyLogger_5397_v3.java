import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class KeyLogger_5397_v3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner (System.in);
		int lines=inputScanner.nextInt();

		for(int i=0; i<lines; i++){
			char[] out=inputScanner.next().toCharArray();
			Stack left = new Stack();
			Stack right = new Stack();
			
			// Ŀ���� ������ �����ʿ� ��ġ�Ҷ�  ���ʹ��ڿ� -> left, Ŀ���� ������ ���ڿ�-> right
			for(int indR=0; indR<out.length;indR++){

				switch (out[indR]){
				
				case '>':
					if(!right.isEmpty()) left.push(right.pop());
					
					break;
				case '<':
					if(!left.isEmpty())  right.push(left.pop());
					break;
				case '-':
					if(!left.isEmpty()) left.pop(); 
					break;
				default:
					left.push(out[indR]);
					break;
				
				}
			
			}
		
		Iterator iter =left.iterator() ;
		while(iter.hasNext()) System.out.print(iter.next());
		
		while(!right.isEmpty()) System.out.print(right.pop());
		System.out.print("\n");
		
		}		
	}

}
