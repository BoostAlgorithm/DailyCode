import java.util.Scanner;


public class PrinterQueue_1966 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcaseNum = sc.nextInt(); // 테스트 케이스 수
		
		while(testcaseNum-->0) {
			int n = sc.nextInt(); // 전체문서 수
			int m = sc.nextInt(); // 궁금한 문서의 현위치
			
			int [][] array = new int[n][2]; 
			
			for(int i=0; i<n; i++) {
				array[i][0] = 0; // 출력 됐다면 1, 안됐다면 0
				array[i][1] = sc.nextInt(); // 중요도
			}
			
			int headIndex=0;
			int max=0;
			int count = 0;
			
			while(true) {
				
				for(int i=0; i<array.length; i++) {
					/*
					 * 기준 값 보다 처음으로 큰 값이 나오는 곳을 새로운 헤드 위치로
					 * */
					if(array[i][0]==0 && (array[i][1]>array[headIndex][1])) {
						headIndex++;
						break;
					}
				}
/*
				System.out.println("headIndex : " + headIndex);
				System.out.println("=====================");
				*/
				/*
				 * 처음으로 헤드보다 큰 값이 나온 곳이
				 * 큐 값 중 가장 크다면 걔를 출력
				 * */
				max = array[headIndex][1];
				int k=headIndex;
				for(int j=0; j<array.length; j++) {
					if(j==headIndex) continue; 
					if(max<array[j][1] && array[j][0]==0) {
						max = array[j][1];
						k = j;
					}
				}/*
				
				System.out.println("k : " + k);
				System.out.println("headIndex : " + headIndex);*/
				
				if(k==headIndex) {
					array[headIndex][0] = 1;
					headIndex++;
					count++;
				}
				
				if(headIndex==array.length) headIndex=0;
				
				if(array[m][0]==1) {
					System.out.println(count);
					break;
				}
				
			}
			
			
			

		}
	}
	// 정렬(값 큰->작, 번호같다면 작->큰)
		/*public void sort(int [][] data, int leftIndex, int rightIndex) {
			int left = leftIndex;
			int right = rightIndex;
			int pivot = data[(left+right)/2][1];
			do {
				while(data[left][1]>pivot) left++;
				while(data[right][1]<pivot) right--;
				if(left <= right){    
	                int temp[] = data[left];
	                data[left] = data[right];
	                data[right] = temp;
	                left++;
	                right--;
	            }
	        }while (left <= right);
	        if(leftIndex > right) sort(data, leftIndex, right);
	        if(rightIndex < left) sort(data, left, rightIndex);
			
		}*/
}