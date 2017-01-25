import java.util.Scanner;


/**
 * 가장 긴 오르막길 구하기
 * */
public class Array_GetLength_2846 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 수열의 크기
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
				// 증가 수열 확인
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




