package baekjoon.recursionNsearch.boram;

import java.util.*;

public class SequenceSum_1024 {
	// 시간초과: Linear Search?
	// ex) 18 2 > 5 6 7
	// 		3 2 > 0 1 2
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int sum = input.nextInt(); // 연속된 음이아닌 정수의 합(0포함)인 N의 값을 받는 sum 변수 ( N < 1000000000 )
		int length = input.nextInt(); // 연속된 음이 아닌 정수의 갯수 L를 나타는 length 변수 (2 <= L <= 100)
		List<Integer> seqNumbers = new ArrayList<>(); // 연속된 음이 아닌 정수를 담는 arrayList
		
//		for(int i = 0; i <= (sum-length); i++){
//			int total = 0;
//			for(int j = 0; j <= length; j++){
//				total += i + j;
//			}
//			//System.out.println("total: " + total);
//			if(total == sum){ 
//				for(int j = 0; j <= length; j++){
//					seqNumbers.add(i + j);
//				}
//				break; 
//			}			
//		}
				
		for(int i = sum/(length+1)-1; i <= (sum-length); i++){
			int total = 0;
			for(int j = 0; j <= length; j++){
				total += i + j;
			}
			System.out.println("total: " + total);
			if(total == sum){ 
				for(int j = 0; j <= length; j++){
					seqNumbers.add(i + j);
				}
				break; 
			}			
		}
					
		if(seqNumbers.isEmpty()){ seqNumbers.add(-1); }
		
		Iterator iter = seqNumbers.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next()+" ");
		}
		
	}

}
