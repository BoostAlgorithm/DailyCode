package baekjoon.recursionNsearch.boram;

import java.util.*;

public class Recursion_HanoiTower_1914 {

	static int count = 0;
	static List<String> printOut;
	
	public static void moveHanoiTower(char first, char center, char last, int movement){
		// first: 원반이 있던 탑 / center: 중간위치 탑 / last: 원반들을 옮길 목적지 탑
		
		if(movement == 1){
			count++; 
			printOut.add(first + " " + last);
		}else{
			// 마지막 탑을 보조탑으로 이용하여 첫번째 탑에 있는 n-1개의 원반을 이동한다.
			moveHanoiTower(first, last, center, movement-1);
			count++; printOut.add(first + " " + last);
			// 첫번째 탑을 보조탑으로 이용하여 중간탑에 있는 n-1개의 원반을 이동한다.
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
