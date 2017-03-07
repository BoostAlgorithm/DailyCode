package baekjoon.graph.boram;

import java.util.*;

// Ʋ�Ƚ��ϴ�.  ����: http://blog.naver.com/PostView.nhn?blogId=kks227&logNo=220620727135

public class GraphDFS_CrazyRobot_1405 {
	// ex) 2 25 25 25 25 > 0.75
	// n <= 14, ��� Ȯ���� �ڿ����̰� �� ���� 100
	
	// �� �̵������� ��, �� ��ȣ ���� �迭�� ����
	static int rowMove[] = {0, 0, 1, -1};
	static int colMove[] = {1, -1, 0, 0};
	
	static float probability[];
	static boolean visited[][];
	
	// ���� r�� c���� �ְ� movement�� �� �̵��� �� ������ �ܼ������ Ȯ��
	public static float crazyRobot(int row, int column, int movement){
		// ���� ���: ���� Ž���� ���߹Ƿ� �׻� �ܼ��ϴ�.
		if(movement == 0) return (float) (1.0);
		
		float result = (float) 0.0;
		visited[row][column] = true;
		// DFS�� �ٸ� ������� Ž���Ͽ� ����� ����
		for(int i = 0; i < 4; i++){
			int rowDFS = row + rowMove[i];
			int colDFS = column + colMove[i];
			if(visited[rowDFS][colDFS]){ continue; }
			// �ش� �������� �̵��� Ȯ���� ������ ����� ����
			result += probability[i] * crazyRobot(rowDFS, colDFS, movement-1); 
		}
		visited[row][column] = false;
		return result;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int movement = input.nextInt(); // ��ģ�κ��� ��� �̵��ߴ����� �޴� �κ� 
		probability= new float[4]; // E W N S ���� �̵����� ��, Ȯ�� (/100�� �ؾ���)
		visited = new boolean[29][29];
		float result; // Ȯ�� ���� ����ϴ� ����
		
		for(int i = 0; i < 4; i++){
			probability[i] =  (float) (input.nextInt() / 100.0);
		}
		
		result = crazyRobot(14, 14, movement);
		System.out.println(result);			

	}

}
