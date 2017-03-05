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
		int n = Integer.parseInt(br.readLine()); // ù��° ��뿡 ���� ������ ��
		
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
	 * 1. n-1�� ��ŭ 2�� �̵�
	 * 2. n��°(������ ����)�� 3���� �̵�
	 * 3. 2�� n-1���� 3���� �̵� 
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
