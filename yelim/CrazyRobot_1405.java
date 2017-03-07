import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CrazyRobot_1405 {

	static boolean map[][];
	static int adjacentX[] = {0, 0, 1,  -1}; // �� �� �� �� ��� ��ǥ 
	static int adjacentY[] = {1, -1, 0, 0};
	static int [] probability;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strArr[] = br.readLine().split(" ");
		int actionCount = Integer.parseInt(strArr[0]);
		probability = new int[] {Integer.parseInt(strArr[1]),  // ��, ��, ��, �� Ȯ��
				Integer.parseInt(strArr[2]), 
				Integer.parseInt(strArr[3]), 
				Integer.parseInt(strArr[4])};
		map = new boolean[actionCount*2+1][actionCount*2+1]; // �ִ� N�� �̵� ��� ������ �� ��쿡 ���� ��
		
		System.out.println(visit(actionCount, actionCount, actionCount));
		
	}
	
	/**
	 * ���� �� �ٽ� Ž������ ������ ��ΰ� �ܼ�
	 * �׼� Ƚ���� ä�� ���� Ž��
	 * Ž�������� �湮�� �����̸� ���ƿͼ� ��Ž��
	 * */
	private static double visit(int x, int y, int actionCount) {
		if(actionCount==0) return 1.0;
		map[x][y]=true;
		double percent=0.0;
		for(int i=0; i<4; i++) { // �������� xyȮ��
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
