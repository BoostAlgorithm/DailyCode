import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CrazyRobot_1405 {

	static boolean map[][];
	static int adjacentX[] = {0, 0, 1,  -1}; // 동 서 남 북 상대 좌표 
	static int adjacentY[] = {1, -1, 0, 0};
	static int [] probability;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strArr[] = br.readLine().split(" ");
		int actionCount = Integer.parseInt(strArr[0]);
		probability = new int[] {Integer.parseInt(strArr[1]),  // 동, 서, 남, 북 확륙
				Integer.parseInt(strArr[2]), 
				Integer.parseInt(strArr[3]), 
				Integer.parseInt(strArr[4])};
		map = new boolean[actionCount*2+1][actionCount*2+1]; // 최대 N번 이동 모두 직진만 할 경우에 맞춰 맵
		
		System.out.println(visit(actionCount, actionCount, actionCount));
		
	}
	
	/**
	 * 같은 곳 다시 탐색하지 않으면 경로가 단순
	 * 액션 횟수를 채울 동안 탐색
	 * 탐색지점이 방문한 공간이면 돌아와서 재탐색
	 * */
	private static double visit(int x, int y, int actionCount) {
		if(actionCount==0) return 1.0;
		map[x][y]=true;
		double percent=0.0;
		for(int i=0; i<4; i++) { // 동서남북 xy확인
			int nx = x + adjacentX[i];
			int ny = y + adjacentY[i];
			if(map[nx][ny]!=true) { 
				double per = visit(nx, ny, actionCount-1);
				System.out.println(x + ", " + y + " => " + nx + ", " + ny + " Midpercent : " + per);
				percent += probability[i]/100.0*per;
				System.out.println("percent : " + percent);
				map[nx][ny]=false;
			}
			
		}
		return percent;
	}

}
