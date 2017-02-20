import java.io.BufferedReader;
import java.io.InputStreamReader;


public class StackSequence_1874 {
	/**
	 * 1. ���� ���� top���� ũ��
	 * ���� top����
	 * �ش� ���ڰ� �� ������ push�ϰ� �����ϸ� pop(�ش簪-top ��ŭ)
	 * top�� ���� ������ 
	 * 2. top���� ������ 
	 * top���� �ش� ������ pop(top-�ش� �� ��ŭ)
	 * top���� ���� �ش簪�� �׻� top-1�ۿ� �� �� ����
	 * */
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num;
		int top=0;
		int index=0;
		int stack[] = new int[n];
		StringBuffer bf = new StringBuffer();
		
		for(int i=0; i<n; i++) {
			num = Integer.parseInt(br.readLine());
			if(num>top) {
				for(int j=top+1; j<=num; j++) {
					stack[index++] = j;
					bf.append("+\n");
				}
			} else {
				if(stack[index-1] != num) {
					System.out.println("NO");
					return;
				}
			}
			index--;
			bf.append("-\n");
			if(num>top) top=num;
		}
		
		System.out.println(bf);
	}

}
