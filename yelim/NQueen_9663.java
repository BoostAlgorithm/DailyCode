import java.io.BufferedReader;
import java.io.InputStreamReader;


public class NQueen_9663 {

	/**
	 * ���� ��/��/�밢���� �����ϸ� X 
	 * */
	int count = 0;
	static int [] queensCols; // �� ���� ���� ��ġ�ƴ��� ����
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
	 * ���� �� ���� i���� ���� ���Ƶ� �Ǵ��� Ȯ��
	 * (��ġ������ �ڸ�����)
	 * 1. ���� ���� �����ϸ� X
	 * 2. ���� ���� == ���� ���� ��� �밢���� ��ġ 
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
	 * depth : ���� ���� ��
	 * */
	private void countQueen(int depth) {
		if(n==depth) {
			count++;
			return;
		}
		for(int i=0; i<n; i++) { // i : ��
			if(isOccupiable(depth, i)) { // ���� �� ���� i���� ���� ���Ƶ� �Ǵ��� Ȯ��
				queensCols[depth] = i;
				countQueen(depth+1);
			}
		}
		queensCols[depth] = 0;
		return;
	}
}
