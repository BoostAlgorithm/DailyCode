package baekjoon.graph.boram;

import java.util.*;

// 틀렸습니다.  참조: http://blog.naver.com/PostView.nhn?blogId=kks227&logNo=220620727135

public class GraphDFS_CrazyRobot_1405 {
	// ex) 2 25 25 25 25 > 0.75
	// n <= 14, 모든 확률은 자연수이고 그 합은 100
	
	// 각 이동방향의 행, 열 번호 차를 배열로 저장
	static int rowMove[] = {0, 0, 1, -1};
	static int colMove[] = {1, -1, 0, 0};
	
	static float probability[];
	static boolean visited[][];
	
	// 현재 r행 c열에 있고 movement번 더 이동할 때 앞으로 단순경로일 확률
	public static float crazyRobot(int row, int column, int movement){
		// 기저 사례: 당장 탐색을 멈추므로 항상 단순하다.
		if(movement == 0) return (float) (1.0);
		
		float result = (float) 0.0;
		visited[row][column] = true;
		// DFS로 다른 방향들을 탐삭하여 결과를 구함
		for(int i = 0; i < 4; i++){
			int rowDFS = row + rowMove[i];
			int colDFS = column + colMove[i];
			if(visited[rowDFS][colDFS]){ continue; }
			// 해당 방향으로 이동할 확률을 곱새서 결과에 더함
			result += probability[i] * crazyRobot(rowDFS, colDFS, movement-1); 
		}
		visited[row][column] = false;
		return result;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int movement = input.nextInt(); // 미친로봇이 몇번 이동했는지를 받는 부분 
		probability= new float[4]; // E W N S 으로 이동했을 때, 확률 (/100을 해야함)
		visited = new boolean[29][29];
		float result; // 확률 값을 출력하는 변수
		
		for(int i = 0; i < 4; i++){
			probability[i] =  (float) (input.nextInt() / 100.0);
		}
		
		result = crazyRobot(14, 14, movement);
		System.out.println(result);			

	}

}
