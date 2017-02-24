import java.io.BufferedReader;
import java.io.InputStreamReader;


public class NQueen_9663 {

	/**
	 * 같은 행/열/대각선에 존재하면 X 
	 * */
	int count = 0;
	static int [] queensCols; // 몇 열에 퀸이 배치됐는지 저장
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // nXn
		queensCols = new int[n];
		NQueen_9663 nQueen = new NQueen_9663();
		nQueen.countQueen(0);
		System.out.println(nQueen.count);
	}

	/**
	 * 현재 이 행의 i열에 퀸을 놓아도 되는지 확인
	 * (위치가능한 자리인지)
	 * 1. 같은 열에 존재하면 X
	 * 2. 행의 차이 == 열의 차이 라면 대각선에 위치 
	 * */
	private boolean isOccupiable(int depth, int targetCol) {
		for(int i=0; i<depth; i++) {
			if(queensCols[i] == targetCol || 
					(Math.abs(depth-i)==Math.abs(targetCol-queensCols[i]))) {
				/*System.out.println(queensCols[i] + " / " + targetCol);
				System.out.println(Math.abs(depth-i) + " / " + Math.abs(targetCol-queensCols[i]));*/
				return false;
			}
		}
		return true;
	}
	
	/**
	 * depth : 퀸을 놓을 행
	 * */
	private void countQueen(int depth) {
		if(n==depth) {
			count++;
			return;
		}
		for(int i=0; i<n; i++) { // i : 열
			if(isOccupiable(depth, i)) { // 현재 이 행의 i열에 퀸을 놓아도 되는지 확인
				queensCols[depth] = i;
				countQueen(depth+1);
			}
		}
		queensCols[depth] = 0;
		return;
	}
}
