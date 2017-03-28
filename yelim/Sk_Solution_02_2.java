import java.util.Scanner;


public class Sk_Solution_02_2 {

	static int max=0;
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 숫자
 		Sk_Solution_02_2 sol = new Sk_Solution_02_2();
 		System.out.println(sol.solution(N));
	}
	
	// 조합 다 찾기아서 그 중 최대값
	public int solution(int N) {
		String strArr[] = String.valueOf(N).split(""); // int=>string
		return getSibling(strArr, 0);
	}

	
	private int getSibling(String[] strArr, int index) {
		
		if(index==strArr.length) {
			StringBuffer bf = new StringBuffer();
			for(int i=0; i<strArr.length; i++) {
				bf.append(strArr[i]);
			}
			
			int tmp = Integer.parseInt(bf.toString());
			//System.out.println("value : " + tmp);
			if(tmp>max) max = tmp;
			return max;
		}
		
		for(int i=index; i<strArr.length; i++) {
			swap(strArr, i, index);
			//System.out.println("preG => " + i + " = i " + ", " + index + " = index");
			getSibling(strArr, index+1);
			//System.out.println("afterG => "  + i + " =  i " + ", " + index + " = index");
			swap(strArr, i, index);
		}
		return max;
	}
	
	private void swap(String[] strArr, int i, int index) {
		String tmp = strArr[i];
		strArr[i] = strArr[index];
		strArr[index] = tmp;
	}
	
}
