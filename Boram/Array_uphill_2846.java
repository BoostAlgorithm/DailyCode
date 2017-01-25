import java.util.*;

public class Array_uphill_2846 {

	public static void main(String[] args) {
		// 가장 큰 오르막길을 구하는 프로그램 
		int height[], gap[];
		List <Integer> uphill = new ArrayList(); 
		int total=0, max = 0; boolean check = false;
		
		Scanner input = new Scanner(System.in);
		int cnt = input.nextInt();
		
		height = new int [cnt];
		gap = new int [cnt-1];
		
		for(int i = 0; i < cnt; i++){ // 0~7
			height[i] = input.nextInt();
		}
		
		for(int i = 0; i < cnt-1; i++){ // 0~6
			gap[i] = height [i+1] - height[i];
			if(gap[i]>0){ 
				total += gap[i];
				if(i==cnt-2){ uphill.add(total); } // 좀 더 깔끔하게 정리를 해보자!
			}
			else { 
				if(total==0) { continue; }
				uphill.add(total);
				total = 0;
			}
		}
		
		for(int i = 0; i < uphill.size(); i++){
			if(max < uphill.get(i)) { 
				max = uphill.get(i); 
			}	
			System.out.println(uphill.get(i));
		}
		System.out.println(max);
		
	}

}
