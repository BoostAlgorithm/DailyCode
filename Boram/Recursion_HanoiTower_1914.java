package baekjoon.recursionNsearch.boram;

import java.util.*;

public class Recursion_HanoiTower_1914 {

	static int count = 0;
	static List<String> printOut;
	
	public static void moveHanoiTower(char first, char center, char last, int movement){
		// first: ������ �ִ� ž / center: �߰���ġ ž / last: ���ݵ��� �ű� ������ ž
		
		if(movement == 1){
			count++; 
			printOut.add(first + " " + last);
		}else{
			// ������ ž�� ����ž���� �̿��Ͽ� ù��° ž�� �ִ� n-1���� ������ �̵��Ѵ�.
			moveHanoiTower(first, last, center, movement-1);
			count++; printOut.add(first + " " + last);
			// ù��° ž�� ����ž���� �̿��Ͽ� �߰�ž�� �ִ� n-1���� ������ �̵��Ѵ�.
			moveHanoiTower(center, first, last, movement-1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printOut = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		int movement = input.nextInt();
		
		moveHanoiTower('1','2','3', movement);
		
		System.out.println(count);
		Iterator iter = printOut.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
	}

}
