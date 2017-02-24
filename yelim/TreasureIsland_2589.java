import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

class Treasure {
	private int x;
	private int y;
	
	public Treasure() {}
	public Treasure(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}

public class TreasureIsland_2589 {
	
	static char map[][];
	static int height;
	static int width;
	static int adjacentX[] = {-1, 0, 1, 0};
	static int adjacentY[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String strArr [] = br.readLine().split(" ");
		height = Integer.parseInt(strArr[0]); // 지도의 세로길이 - 5
		width = Integer.parseInt(strArr[1]); // 지도의 가로길이 - 7
		
		map = new char[height][width];
		int maxTime = 0;
		
		for(int i=0; i<map.length; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j]=='L') {
					int time = bfs(i, j);
					if(time > maxTime) maxTime = time;
				}
			}
		}
		System.out.println(maxTime);
	}

	private static int bfs(int x, int y) {
		int visited[][] = new int[height][width]; // 길이 저장
		ArrayList<Treasure> path = new ArrayList<Treasure>();
		
		Treasure start = new Treasure(x, y); // 시작점 저장 
		path.add(start);
		visited[x][y] = 0; 
		int time = 0;
		
		while(path.size()>=1) {
			x = path.get(0).getX();
			y = path.get(0).getY();
			path.remove(0);
			
			for(int i=0; i<4; i++) {
				// 인접한 위, 오, 아, 왼 중 방문하지 않았고 땅일 경우 확인
				int nextX = x + adjacentX[i]; // 인접한 X
				int nextY = y + adjacentY[i]; // 인접한 Y
				
				if(nextX>=0 && nextY>=0 && nextX<height && nextY<width && visited[nextX][nextY]==0 && map[nextX][nextY]=='L') {
					Treasure end = new Treasure(nextX, nextY); // 다음지점 저장 
					path.add(end);
					visited[nextX][nextY] = visited[x][y]+1;
					time = visited[nextX][nextY];
					//System.out.println(x + "," + y + " => " + nextX + "," + nextY + " & time : " + visited[nextX][nextY] );
				}
			}
		}
		return time;
	}

	
}
