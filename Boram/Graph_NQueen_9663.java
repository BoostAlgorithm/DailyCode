package baekjoon.graph.boram;

import java.util.*;

public class Graph_NQueen_9663 {
	/**
		N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.		
		N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.		
		첫째 줄에 N이 주어진다. (1 ≤ N < 15)
	 */
	// 참조 : http://ddmix.blogspot.kr/2015/06/cppalgo-29-greedy-backtracking.html
	// row 행 , column 열
	
	static int nQueenCount = 0; // NQueen의 경우의 수
	
	// queen이 올 수 있는 자리인지를 확인 하는 함수
	public static boolean isPromising(int queen[], int count, int row){
		if(row < 1) {return true;} // 하나 놓인 경우
		for(int i = 0; i < row; i++){
			if(queen[row] == queen[i] || row - i == Math.abs(queen[row]-queen[i])) 
				// 퀸이 이미 놓인 열과 같은 경우 || 대각선일 경우 ( Queen이 잡을 수 있는 위치에 놓이는 경우)
				return false;
		}
		return true;
	}
	
	// NQueen 재귀 함수 (BackTraking 알고리즘의 성능을 개선한 2번째 방법론 사용)
	public static void NQueen(int queen[], int count, int row){
		for(int i = 0; i < count; i++){
			queen[row] = i;
			if(isPromising(queen, count, row)){
				if(row == count - 1) { // Queen이 모두 놓여질 경우
					nQueenCount++;
				}else{
					NQueen(queen, count, row + 1);
				}
			}
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int chessPiecesCount; // n개의 체스 갯수
		//byte [][] chessBoard; // byte 크기의 n*n 체스판
		int queen[]; // 퀸의  column 값을 저장 변수  ex) queen[0 > row] = 1 > column (1,2에 위치)
		
		Scanner input = new Scanner(System.in);
		chessPiecesCount = input.nextInt();
		// chessBoard = new byte[chessPiecesCount][chessPiecesCount];
		queen = new int[chessPiecesCount];
		
		NQueen(queen, chessPiecesCount, 0);
		System.out.println(nQueenCount);
		
	}

}
