import java.io.IOException;
import java.util.Scanner;

public class StackSequence_1874 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int data;
		int index=0;
		int max=0; // �Էµ� ������ �ִ밪
		int stack[] = new int[100000];
		StringBuilder sb = new StringBuilder();


		for(int i=0; i<n; i++) {
			data = sc.nextInt();
			if(data>max) {
				// max ���� �� ���� data���� ���ÿ� push�ϰ� pop
				for(int j=max+1; j<=data; j++) {
					stack[index++]=j;
					sb.append("+\n");
				}
			} else 
				if(stack[index-1]!=data) {
					System.out.println("NO");
					return;
				}
			index--;
			sb.append("-\n");
			if (data > max) max = data;
			
		}
		System.out.println(sb);


	}
}



