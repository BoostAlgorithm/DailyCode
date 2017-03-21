public class SetExam01 {

	static int[] arr = {1, 2, 3};
	static int[] isVisited = {0, 0, 0};
	
	public static void main(String[] args) {
		
		int i = 010; // 앞에 0붙이면 8진수, 0x붙이면 16진수
		System.out.println(i);
		
	//	set(0, arr.length);
		// set2();
		
	}
/*	private static void set2() {
		
		int m=1;
		int arr2[] = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			arr2[i] = i+1;
			m *= 2; // Math.pow(2, arr.length);
		}
		
		int index;
		for(int i=0; i<m; i++) {
			index = i;
			int j = 0;
			while(index != 0) {
				if(index %2 == 1) {
				//	System.out.print(" index " + index + " value " + arr2[j]);
				}
				j++;
				index /= 2;			}

			System.out.println();
		}*/
		/*int max = (int)Math.pow(2, arr.length);
		int count=0;
		//while(count!=max) { 
			for(int i=0; i<arr.length; i++) {
				isVisited[i]=1;
				System.out.println(i+1);
				for(int j=i+1; j<arr.length; j++) {
					isVisited[j]=1;
					for(int k=0; k<arr.length; k++) {
						if(isVisited[k]==1) {
							System.out.print(arr[k]);
						}
					}
					//isVisited[j]=0;
					System.out.println();
			//		count++;
				}
				isVisited[i]=0;
			}*/
		//}
//	}
	
	private static void set(int i, int max) {
		
		if(i==max) {
			System.out.print("{");
			for(int j=0; j<max; j++) {
				if(isVisited[j]==1) {
					System.out.print(arr[j]);
				}
			}
			System.out.println("}");
			return;
		}
		
		isVisited[i]=1;
		set(i+1, max);
		isVisited[i]=0;
		set(i+1, max);
	}
}
