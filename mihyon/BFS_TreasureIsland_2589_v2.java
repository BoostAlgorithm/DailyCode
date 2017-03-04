import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class BFS_TreasureIsland_2589_v2 {
	static int width, height;
	static Cell land[][];
	static int[][] adj = {{-1,0}, {1,0},{0,1},{0,-1}};

	static LinkedList next = new LinkedList();

	static class Cell{
		int x;
		int y;
		public Cell(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		if(!sc.hasNext()) return;
		
		String num[]=sc.nextLine().split(" ");
		height=Integer.parseInt(num[0]);
		width=Integer.parseInt(num[1]);
		
		land = new Cell[height][width];
		for(int i=0; i<height; i++){
			char[] next= sc.nextLine().toCharArray();
		
			for(int j=0; j<width;j++){
				//land[i][j] = (st.nextToken().equals("W"))? false:true;
				land[i][j] = (next[j]=='W')? null:new Cell(i,j);
			}
		}
		int max = 0;
		for( int i=0; i<height; i++)
			for(int j=0; j<width;j++)
				max = Math.max(max, bfs(i,j));
		System.out.println(max);
	}
	
		public static int bfs(int x, int y){
			if(land[x][y]==null) return 0;
			Map<Cell, Integer> dist = new HashMap<>();  // 이차원 배열보다 나을듯...
			next.add(land[x][y]);
			dist.put(land[x][y], 0);
			int ret=0;
			while(!next.isEmpty()){
				
				Cell cur=(Cell)next.poll();
				//ret = Math.max(ret, dist.get(land[cur.x][cur.y]));
				//System.out.println("CUR"+cur.x+" "+cur.y);
				for(int i=0; i<4; i++){
					int nextX = cur.x+adj[i][0]; int nextY = cur.y+adj[i][1];	
					if(isOut(nextX,nextY) || land[nextX][nextY]==null) continue;	// water이거나 ,  배열의 범위 밖 
					if(!dist.containsKey(land[nextX][nextY])){
						//System.out.println("ADJ"+nextX+ " "+nextY);
						dist.put(land[nextX][nextY],dist.get(land[cur.x][cur.y])+1);
						next.add(land[nextX][nextY]);
					}
				} if(next.isEmpty()) ret = dist.get(land[cur.x][cur.y]);
				
			}//System.out.println("END ");
			return ret;
		}

			private static boolean isOut(int x, int y ) {
				//if(x<=0 || y<=0 || x>=height|| y>=width) return true; 주의 ㅠ ㅠ 
				if(x<0 || y<0 || x>=height|| y>=width) return true;
				return false;
			}

}
