import java.util.Scanner;

public class MadRobot_1405 {
	static int N;
	static int[][] relativeXY = {{1,0},{-1,0},{0,1},{0,-1}}; // E W S N
	static double[]  moveProb;
	static boolean[][] visited;
	public MadRobot_1405(int N, int probE, int probW, int probS, int probN){
		this.N= N;
		
		moveProb = new double[]{probE/100.0, probW/100.0, probS/100.0, probN/100.0};
		visited = new boolean[2*N+1][2*N+1]; // (0,0)~ (2N,2N)
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MadRobot_1405 mr = new MadRobot_1405(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		System.out.print(mr.wrapperDFS());
		

	}
	
	public double wrapperDFS(){
		visited[N][N] = true;
		return dfs(N, N, N);
	}
	public double dfs(int curX, int curY, int rest){
		if(rest==0) return 1.0;
		
		double prob=0;
		for(int i=0; i<relativeXY.length; i++){
			int nextX = curX+relativeXY[i][0]; int nextY=curY+relativeXY[i][1];
			if(visited[nextX][nextY]) continue;
			visited[nextX][nextY]= true;
			prob += moveProb[i] *dfs(nextX,nextY,rest-1);
			visited[nextX][nextY]= false;
		}
		return prob;
		
	}
	/*public int convertVisitState(int i, int j, int visited){
		int op = N^i+j;
		return (visited|op);
	}public boolean isVisited(int i, int j, int visited){
		int op = N^i+j;
		if((visited&op) >0) return true;
		return false;
	}*/

}
