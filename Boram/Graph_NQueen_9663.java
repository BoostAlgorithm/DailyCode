package baekjoon.graph.boram;

import java.util.*;

public class Graph_NQueen_9663 {
	/**
		N-Queen ������ ũ�Ⱑ N �� N�� ü���� ���� �� N���� ���� ������ �� ���� ���� �����̴�.		
		N�� �־����� ��, ���� ���� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.		
		ù° �ٿ� N�� �־�����. (1 �� N < 15)
	 */
	// ���� : http://ddmix.blogspot.kr/2015/06/cppalgo-29-greedy-backtracking.html
	// row �� , column ��
	
	static int nQueenCount = 0; // NQueen�� ����� ��
	
	// queen�� �� �� �ִ� �ڸ������� Ȯ�� �ϴ� �Լ�
	public static boolean isPromising(int queen[], int count, int row){
		if(row < 1) {return true;} // �ϳ� ���� ���
		for(int i = 0; i < row; i++){
			if(queen[row] == queen[i] || row - i == Math.abs(queen[row]-queen[i])) 
				// ���� �̹� ���� ���� ���� ��� || �밢���� ��� ( Queen�� ���� �� �ִ� ��ġ�� ���̴� ���)
				return false;
		}
		return true;
	}
	
	// NQueen ��� �Լ� (BackTraking �˰����� ������ ������ 2��° ����� ���)
	public static void NQueen(int queen[], int count, int row){
		for(int i = 0; i < count; i++){
			queen[row] = i;
			if(isPromising(queen, count, row)){
				if(row == count - 1) { // Queen�� ��� ������ ���
					nQueenCount++;
				}else{
					NQueen(queen, count, row + 1);
				}
			}
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int chessPiecesCount; // n���� ü�� ����
		//byte [][] chessBoard; // byte ũ���� n*n ü����
		int queen[]; // ����  column ���� ���� ����  ex) queen[0 > row] = 1 > column (1,2�� ��ġ)
		
		Scanner input = new Scanner(System.in);
		chessPiecesCount = input.nextInt();
		// chessBoard = new byte[chessPiecesCount][chessPiecesCount];
		queen = new int[chessPiecesCount];
		
		NQueen(queen, chessPiecesCount, 0);
		System.out.println(nQueenCount);
		
	}

}
