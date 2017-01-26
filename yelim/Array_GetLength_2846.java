import java.util.Scanner;
/**
 * 가장 긴 오르막길 구하기
 * */
public class Array_GetLength_2846 {

	/*
	 * 시간 복잡도 : 중요한 명령어들이 몇개나 실행이 되는가 O(n) 
	 * 공간 복잡도 : 알고리즘을 실행하기 위한 최대 메모리 용량 (상수, 변수 사이즈, 가변 공간 등)
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 수열의 크기
		int road[] = new int[n];
		
		for(int i=0; i<n; i++) {
			road[i] = sc.nextInt();
		}
		
		System.out.println(getLongestLength(road)); 
	}

	/**
	 * 배열에서 값을 꺼내서
	 * 앞의 숫자보다 꺼낸 숫자가 크다면 증가 수열임을 확인하고 
	 * count값을 증가 (count : 현재 값과 시작 값까지 배열거리)
	 * 만약 (현재 값-증가수열 시작 값)이 기존 최대 거리보다 길다면 최대 값으로 대치 
	 * */
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

