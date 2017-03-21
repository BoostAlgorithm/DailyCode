package AlgStudy;

import java.util.Stack;

public class Alg13 {
	
	boolean check[];
	static Stack<Integer> st;
	static Stack<Integer> emptySt;
	
	public void solution(String[] arr){
		check = new boolean[arr.length];
		emptySt = new Stack<>();
		
		System.out.println("{}");
		int len = (int)Math.pow(2, arr.length);
		for(int i=1; i<len; i++){
			
			 emptySt = cal(i, arr.length);
			 
			 int j=0;
			 while(true){
				 if(emptySt.isEmpty()){
					 break;
				 }
				 if(emptySt.pop() == 1){
					 check[j] = true;
				 }else{
					 check[j] = false;
				 }
				 j++;
			 }
			 
			 for(int k=0; k<check.length;k++){
				 if(check[k]){
					 System.out.print(arr[k]);
				 }
			 }
			 System.out.println();
			 st.clear();
			 emptySt.clear();
		}
	}
	
	static Stack<Integer> cal(int num, int length) {
		st = new Stack<>();
		while(true){
			if(num == 1){
				st.push(num);
				break;
			}
			
			if(num % 2 == 0){
				st.push(0);
			}else{
				st.push(num%2);
			}
			num = num/2;
		}
		
		int l = length - st.size();
		for(int i=0; i<l; i++){
			st.push(0);	
		}
			
		return st;
	}
	
	public static void main(String[] args) {
		Alg13 main = new Alg13();
		String[] arr1 = {"a", "b", "c"};
		String[] arr2 = {"a", "b", "c", "d"};
		main.solution(arr1);
		System.out.println();
		System.out.println();
		main.solution(arr2);
	}
}
