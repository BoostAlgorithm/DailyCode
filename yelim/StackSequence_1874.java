import java.io.BufferedReader;
import java.io.InputStreamReader;


public class StackSequence_1874 {
	/**
	 * 1. 들어온 값이 top보다 크면
	 * 이전 top부터
	 * 해당 숫자가 될 때까지 push하고 도달하면 pop(해당값-top 만큼)
	 * top을 들어온 값으로 
	 * 2. top보다 작으면 
	 * top부터 해당 값까지 pop(top-해당 값 만큼)
	 * top보다 작은 해당값은 항상 top-1밖에 될 수 없음
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
