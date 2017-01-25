import java.util.Scanner;


/**
 * ���� �� �������� ���ϱ�
 * */
public class Array_GetLength_2846 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ������ ũ��
		int road[] = new int[n];
		
		for(int i=0; i<n; i++) {
			road[i] = sc.nextInt();
		}
		
		System.out.println(getLongestLength(road)); 
	}

	private static int getLongestLength(int [] road) {
		int longestLength=0;
		int length=0;
		int count=0;
		
		for(int i=1; i<road.length; i++) {
			if(road[i-1]<road[i]) {
				// ���� ���� Ȯ��
				count++; 
				length = road[i]-road[i-count];
				if(longestLength<length) {
					longestLength = length;
				}
			} else {
				count=0;
			}
		}
		return longestLength;
	}
}




