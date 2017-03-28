import java.util.ArrayList;
import java.util.HashMap;

public class SK_Code {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	Solution2 s2 = new Solution2();
		System.out.println(s2.solution(15531293));
		*/
/*		Solution3 s3 = new Solution3();
		System.out.println(s3.solution("AABBCC"));
		*/
		Solution4 s4 = new Solution4();
		System.out.println(s4.solution(new int[]{1,6,3,3,7}));//3,3,1,5,5,7
	}
	
	
}
class Solution1{
	public int solution(int A, int B){
		double temp =Math.sqrt(A);
		double temp2 = Math.sqrt(B);
		if(temp%1.00 >0) return (int)temp-(int)temp2;
		else return (int)temp-(int)temp2-1;
	}
}
class Solution2{
	public int solution(int N){
		//N을 이루는 숫자들
		int[] digits = new int[10];
		int curN = N;
		while(curN>0){
			digits[curN%10]++;
			curN = curN/10;
		}
		int result=0;
		for(int i= digits.length-1; i>=0; i--){
			while(digits[i]>0){
				result *=10;
				result+=i;
				digits[i]--;
			}
		}
		return result;
	}
}class Solution3{
	public String solution(String S){
		HashMap<String, String> substitution = new HashMap<>();
		substitution.put("AB", "AA");
		substitution.put("BA", "AA");
		substitution.put("CB", "CC");
		substitution.put("BC", "CC");
		substitution.put("AA", "A");
		substitution.put("CC", "C");
		/*System.out.println(substitution.containsKey("AB"));
		System.out.println(substitution.containsKey(input[0]+input[1]+""));
		System.out.println(substitution.containsKey(S.substring(0,2)));*/
		while(true){
		
			int curP =0;
			ArrayList<String> modified = new ArrayList<>();
			int ruleCount =0;
			
			while(curP+2 <=S.length()){
				if(substitution.containsKey(S.substring(curP, curP+2))){
					ruleCount++;
					modified.add(S.substring(0,curP)+substitution.get(S.substring(curP, curP+2))+S.substring(curP+2));
				}curP++;
				
			}
			if(modified.size()==0) break;
			S = modified.get((int) (Math.random()*ruleCount));
			
		}
	return  S; 
		
	}

}class Solution4{
	public boolean solution(int[] A){
		boolean result=true;
		int minInd=0;
		int count=0;
		for(int i=1; i<A.length; i++){
			if(A[i-1]<A[i]) minInd =i;
			else if(A[i-1]>A[i]){
				if(minInd==0||A[minInd]<A[i]) {
					int temp = A[minInd];
					A[i]=temp;
					A[minInd] = A[i];
					break;
				}
			}
		}
		for(int i=1; i<A.length; i++){
			if(A[i-1]>A[i]) {
				result =false;
				break;
			}
		}
		return result;
		
	}
}
