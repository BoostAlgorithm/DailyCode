package baekjoon.recursionNsearch.boram;

import java.util.*;

public class SequenceSum_1024 {
	// �ð��ʰ�: Linear Search?
	// ex) 18 2 > 5 6 7
	// 		3 2 > 0 1 2
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int sum = input.nextInt(); // ���ӵ� ���̾ƴ� ������ ��(0����)�� N�� ���� �޴� sum ���� ( N < 1000000000 )
		int length = input.nextInt(); // ���ӵ� ���� �ƴ� ������ ���� L�� ��Ÿ�� length ���� (2 <= L <= 100)
		List<Integer> seqNumbers = new ArrayList<>(); // ���ӵ� ���� �ƴ� ������ ��� arrayList
		
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
