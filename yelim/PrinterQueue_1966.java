import java.util.Scanner;


public class PrinterQueue_1966 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcaseNum = sc.nextInt(); // �׽�Ʈ ���̽� ��
		
		while(testcaseNum-->0) {
			int n = sc.nextInt(); // ��ü���� ��
			int m = sc.nextInt(); // �ñ��� ������ ����ġ
			
			int [][] array = new int[n][2]; 
			
			for(int i=0; i<n; i++) {
				array[i][0] = 0; // ��� �ƴٸ� 1, �ȵƴٸ� 0
				array[i][1] = sc.nextInt(); // �߿䵵
			}
			
			int headIndex=0;
			int max=0;
			int count = 0;
			
			while(true) {
				
				for(int i=0; i<array.length; i++) {
					/*
					 * ���� �� ���� ó������ ū ���� ������ ���� ���ο� ��� ��ġ��
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
				 * ó������ ��庸�� ū ���� ���� ����
				 * ť �� �� ���� ũ�ٸ� �¸� ���
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
	// ����(�� ū->��, ��ȣ���ٸ� ��->ū)
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