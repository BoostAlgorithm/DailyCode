import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;

class Tower {
	int start;
	int end;
	
	public Tower() {}
	public Tower(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public String toString() {
		return start + " " + end;
	}
}

public class HanoiTower_1914 {
	
	static ArrayList<Tower> list = new ArrayList<Tower>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 첫번째 장대에 쌓인 원판의 수
		
		BigDecimal change_val = new BigDecimal(Math.pow(2, n));
		BigDecimal change_val2 = new BigDecimal(1);
		
		System.out.println (change_val.subtract(change_val2).toString());

		if(n<=20) {
			moveTower(1, 2, 3, n);
			for(Tower tower : list) 
				System.out.println(tower);
		}
	}
	
	/**
	 * 1. n-1개 만큼 2로 이동
	 * 2. n번째(마지막 원판)를 3으로 이동
	 * 3. 2의 n-1개를 3으로 이동 
	 * */
	public static void moveTower(int start, int center, int end, int n) {
		if(n==1) {
			list.add(new Tower(start, end));
			return;
		} 
		moveTower(start, end, center, n-1);
		list.add(new Tower(start, end));
		moveTower(center, start, end, n-1);
	}
}
