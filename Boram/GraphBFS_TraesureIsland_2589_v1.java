package baekjoon.graph.boram;

import java.util.*;

public class GraphBFS_TraesureIsland_2589_v1 {
	/**
	 BFS : ���� ������ �־��� ��, ������ ���� �ִ� �� �� ���� �ִ� �Ÿ��� �̵��ϴ� �ð��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 */
	// Ʋ�Ƚ��ϴ�.  
	// ���� ��α�: http://blog.naver.com/PostView.nhn?blogId=kks227&logNo=220601223982&parentCategoryNo=&categoryNo=280&viewDate=&isShowPopularPosts=false&from=postView
	
	static boolean [][] map; // ���������� �����ϴ� ����
	static int row, column; // ��� ������ �����ϴ� ����
	static Queue<Integer> myQueue;
	
	public static int BFS(int y, int x) {
		myQueue = new LinkedList<Integer>();
		myQueue.add(y*100 + x);
		int result = 0, i, j; // �ִܰ���� ���̸� ���ϴ� result
		Integer current; // current�� ���� �̿��ؼ� row, column�� ����
		while(!myQueue.isEmpty()){
			result++;
			for(int k = 0; k < myQueue.size(); k++){
				current = myQueue.poll();	
				i = current / 100;
				j = current % 100;			
				if(map[i][j]){ continue; }
				map[i][j] = true; // visited
				if(i-1 > 0 && !map[i-1][j]) { myQueue.add((i-1)*100 + j);}
				if(i+1 < row && !map[i+1][j]) { myQueue.add((i+1)*100 + j);}
				if(j-1 > 0 && !map[i][j-1]) { myQueue.add(i*100 + (j-1));}
				if(j+1 < column && !map[i][j+1]) { myQueue.add(i*100 + (j+1));}
			}			
		}	
		return result;
	}
	
	public static void clear() {
		for(int i = 0; i < row; i++){		
			for(int j = 0; j < column; j++){
				if(map[i][j]) { map[i][j] = false;}
			}
		}		
	}	
	
	
	public static void main(String args[]){

		Scanner input = new Scanner(System.in);
		row = input.nextInt();
		column = input.nextInt();
		map = new boolean [row][column];
		
		for(int i = 0; i < row; i++){
			String oneLine = input.next();	
			for(int j = 0; j < column; j++){
				char check = oneLine.charAt(j);		
				if(check == 'L') { map[i][j] = false;}
				else { map[i][j] = true; }
			}
		}
			
//		for(int i = 0; i < row; i++){
//			System.out.println(i + " ");
//			for(int j = 0; j < column; j++){
//				System.out.print(map[i][j]);
//			}
//			System.out.println("");
//		}
		
		int result = 0;
		for (int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				if(!map[i][j])
					result = Math.max(result, BFS(i, j)); 
			}			
		}
		clear();
		System.out.println(result);
	}
}
