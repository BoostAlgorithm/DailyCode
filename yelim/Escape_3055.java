import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class LocationDTO {
	int x;
	int y;
	
	public LocationDTO(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Escape_3055 {

	static char map[][];
	static int row;
	static int col;
	static int dx, dy;
	static int waterVisited[][]; // 물이 방문했는지 저장
	static ArrayList<LocationDTO> waterPath = new ArrayList<LocationDTO>();
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		row = Integer.parseInt(str[0]); // 행
		col = Integer.parseInt(str[1]); // 열
		map = new char[row][col];
		waterVisited = new int[row][col];
		
		for(int i=0; i<row; i++) { // 지도 정보 저장
			map[i] = br.readLine().toCharArray();
		}
		
		int x=0, y=0;
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(map[i][j]=='S') { // 고슴도치 시작 위치 저장
					x = i;
					y = j;
				} else if(map[i][j]=='*') { // 물 위치 저장(물이 여러 곳에 존재 할 수 있음(처음에는 한군데만 물이 있는지 알고 물 좌표도 넘겨주었으나 수정)
					waterVisited[i][j]=1;
					waterPath.add(new LocationDTO(i, j));
				} else if(map[i][j]=='D') { // 목적지 위치
					dx = i;
					dy = j;
				}
			}
		}
		
		bfs(x, y);
	}

	private static void bfs(int x, int y) {
		int adjacentX[] = {-1, 0, 1, 0};
		int adjacentY[] = {0, 1, 0, -1};
		
		int visited[][] = new int[row][col]; // 고슴도치 방문했는지 & 길이 확인
		
		ArrayList<LocationDTO> path = new ArrayList<LocationDTO>();
		path.add(new LocationDTO(x, y)); // 고슴도치 시작 위치 저장
		
		int count=1;
		int count2=0;
		
		int wx, wy;
		
		while(path.size()>=1) { // 고슴도치가 갈 수 있는 지점이 있을 동안
			/*
			 * 고슴도치 이동시키기 전에 물을 먼저 확장 시켜야 함
			 * */	
			while(waterPath.size()>=1) {
				wx = waterPath.get(0).x;
				wy = waterPath.get(0).y;
				
			//	System.out.println("WV : " + wx + ", " + wy + " : " + waterVisited[wx][wy] + "---------------------" + count);
				
				if (waterVisited[wx][wy] != count) {
	                count++;
	                break;
	            }
				waterPath.remove(0);
				
				for(int i=0; i<4; i++) {
					int nextWx = wx + adjacentX[i];
					int nextWy = wy + adjacentY[i];
					
					if(nextWx>=0 && nextWx<row && nextWy>=0 && nextWy<col && 
							map[nextWx][nextWy]!='X' && map[nextWx][nextWy]!='D' && waterVisited[nextWx][nextWy]==0) {
						waterVisited[nextWx][nextWy] = waterVisited[wx][wy] + 1;
						waterPath.add(new LocationDTO(nextWx, nextWy));
						//System.out.println("WATER : " + wx + "," + wy + " => " + nextWx+ "," + nextWy + " & " + waterVisited[nextWx][nextWy]);
					}
				}
			}
			
			while(path.size()>=1) {
				x = path.get(0).x;
				y = path.get(0).y;
				
			//	System.out.println("V : " + visited[x][y] + "---------------------" + count2);
				
				if (visited[x][y] != count2) {
	                count2++;
	                break;
	            }
				
				path.remove(0);
				
				for(int i=0; i<4; i++) {
					int nextX = x + adjacentX[i];
					int nextY = y + adjacentY[i];

					if(nextX>=0 && nextX<row && nextY>=0 && nextY<col && 
							map[nextX][nextY]!='X' && map[nextX][nextY]!='*' && visited[nextX][nextY]==0 && waterVisited[nextX][nextY]==0) {
						visited[nextX][nextY] = visited[x][y]+1;
						path.add(new LocationDTO(nextX, nextY));
						//System.out.println("PATH : " + x + "," + y + " => " + nextX + "," + nextY + " & time : " + visited[nextX][nextY] );
					}
				}
			}
		}
		
		
		if(visited[dx][dy]==0) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(visited[dx][dy]);
		}
	}
}
