import java.util.Scanner;

public class PermuteSum_1024_v2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		/*int initialSum=0;
		for(int i=N/L; i<N/L+L; i++)
			initialSum +=i;
	
		int start = permuteSum(N/L, L, initialSum, N);*/
		int start = permuteSum(N, L);
		StringBuilder sb = new StringBuilder();
		int sum =0;
		if(start<0) sb.append(-1);
		while(start>=0 && sum<=N){
			sb.append(start++ +" ");
			sum +=start;
		}
		System.out.println(sb.toString());
	}
	public static int permuteSum(int i, int curL, int sum, int targetSum){
		if(curL>100 || i<0) return -1;
		if(sum == targetSum) return i;
	//	if(sum+(i-1) == targetSum ||sum+(i-1)-(i+curL-1)==targetSum) return i-1;
		if(sum>targetSum){
			return permuteSum(i-1,curL, sum+(i-1)-(i+curL-1), targetSum);
		}else{
			return permuteSum(i-1,curL+1, sum+(i-1), targetSum);
		}
		
	}
	public static int permuteSum(int N, int L){
		int curL=L;
		int i=N/L;
		int sum=0;
		for(int j=N/L; j<N/L+L; j++)
			sum +=j;
		while(curL<=100 && i>=0){
			if(sum ==N) break;
			if(sum>N){
				i--;
				sum += (i)-(i+curL);
			}else{
				i--;
				curL++;
				sum+=(i);
			}
		}
		if(curL>100 || i<0) return -1;
		else return i;
	//	if(sum+(i-1) == targetSum ||sum+(i-1)-(i+curL-1)==targetSum) return i-1;
		
		
	}
}
