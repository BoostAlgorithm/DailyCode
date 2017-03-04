import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SumofSequence_1024 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int n = Integer.parseInt(st.nextToken()); // �� N
		int l = Integer.parseInt(st.nextToken()); // N�� �̷�� �ڿ����� �ּ� ����
		
		getSumOfSequence(n, l);
 	}

	/**
	 * 15649836 16 
	 * 18 / 3 = 6 (5, 6, 7)
	 * 19 / 2 = 9 (9, 10) 
	 * 25 / 5 = 5 (3, 4, 5, 6, 7)
	 * ���� ���� ��
	 * 1~n���� ���ӵ� ���� �� = n(n+1)/2
	 * */
	private static void getSumOfSequence(int n, int l) {
		
		for(int i=l; i<100; i++) {
			int end = n/i + i/2; 
			int start = end-i+1;
			
			if(start <0 || end>n) {
				continue;
			} else if(n == end*(end+1)/2 - start*(start-1)/2) {
				for(int j=start; j<=end; j++) {
					System.out.print(j + " ");
				}
				return;
			}
		}
		System.out.println(-1);
	}

}
