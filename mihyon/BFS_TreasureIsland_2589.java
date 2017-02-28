import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
/*http://manducku.tistory.com/32 참조 
 * 
 * http://mrl.kr/dijkstra-algorithm/
 * 
 * PrioirtyQueue 이용하는 BFS*/
public class BFS_TreasureIsland_2589 {
	private static final int INF = 123456789;
	static boolean land[][];
	static PriorityQueue<GraphNode> prev ;
	static int width, height;
	static int[][] adj = {{-1,0}, {1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		if(!sc.hasNext()) return;
		
		String num[]=sc.nextLine().split(" ");
		height=Integer.parseInt(num[0]);
		width=Integer.parseInt(num[1]);
		
		prev= new PriorityQueue<GraphNode>();
	
		land = new boolean[height][width];
		for(int i=0; i<height; i++){
			char[] next= sc.nextLine().toCharArray();
		
			for(int j=0; j<width;j++){
				//land[i][j] = (st.nextToken().equals("W"))? false:true;
				land[i][j] = (next[j]=='W')? false:true;
			}
		}
		int min=0;
		for( int i=0; i<height; i++)
			for(int j=0; j<width;j++)
				if(land[i][j]){
					min = Math.max(min, calDistance(i,j));
				}
		System.out.println(min);
				
	}
	private static void init() {
		
		while(!prev.isEmpty()) prev.poll();
			
	}
	private static boolean isOut(int x, int y ) {
		//if(x<=0 || y<=0 || x>=height|| y>=width) return true; 주의 ㅠ ㅠ 
		if(x<0 || y<0 || x>=height|| y>=width) return true;
		return false;
	}
	//Dijkstra - BFS
	//Store the previous node in Queue
	private static int calDistance(int x,int y){

		int ret = 0;
		prev.offer(new GraphNode(x,y,0));
		int dist[][] = new int[height][width];
		for(int i=0; i<height; i++)
			for(int j=0; j<width; j++)
				dist[i][j]=INF;
		
		while(!prev.isEmpty()){
			GraphNode cur = prev.poll();
			
			if(cur.dist>dist[cur.x][cur.y]) continue;
			
		for(int i=0; i<4; i++){
			int nextX = cur.x+adj[i][0]; int nextY = cur.y+adj[i][1];
			
			if(isOut(nextX,nextY) || !land[nextX][nextY]) continue;	// water이거나 ,  배열의 범위 
			if(dist[nextX][nextY]>cur.dist+1){
			//if(dist[nextX][nextY] > dist[cur.x][cur.y] + 1){
				
				dist[nextX][nextY]=cur.dist + 1;
				prev.offer(new GraphNode(nextX, nextY, dist[nextX][nextY]));
				
				}
			}
			if(prev.isEmpty()) ret = cur.dist;
		}
		return ret;
			
	}
	static class GraphNode implements Comparable{
		int x;
		int y;
		int dist;
		public GraphNode(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist=dist;
		}
	
		@Override
		public int compareTo(Object o) {
			if(dist < ((GraphNode)o).dist) return -1;
			else if(dist > ((GraphNode)o).dist) return 1;
			return 0;
		}
	}

}
