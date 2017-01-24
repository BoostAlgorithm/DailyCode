import java.util.Scanner;

public class Queue_1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		int lines=inputScanner.nextInt();
		for (int i =0; i<lines; i++){
			int n=inputScanner.nextInt();
			int m=inputScanner.nextInt();
			
			int[] imp = new int[n];
			boolean[] used =new boolean[n]; 

			//Initialize 			//Add elements 
			for(int i1=0; i1<n;i1++){
				used[i1]=false;
				imp[i1]=inputScanner.nextInt();
			}
			int count=0;
			int cur=0;
			//while(cur!=m){
			while(true){
				
				int j=cur;
				int max = cur;
				do{
					//System.out.println("CUR " +j);
					if( used[j]==false &&imp[max]<imp[j]){
						max= j;
					}
					j=(j+1)%n;
					
				}while(j!=cur);
				
				/*for(int j=cur;j!=prevMax; j=(j+1)%n){
					System.out.println("CUR " +j);
					if(used[j]==false && imp[cur]<imp[j])
						cur = j;
				}
				*/
				
				
				
				//System.out.println("Max : "+max);
				used[max]=true;
				count++;
				cur = max;
				//cur=(prevMax+1)%n; * 틀림 ㅠㅠ
				//cur 는 다음으로 오는 사용안한 원소 used = false!!!
				//모두 사용시?
				if(cur == m) break;
				while(used[cur]){
					cur= (cur+1)%n;
					//System.out.println("NEXT START " +cur);
				}
			}
			System.out.println(count);
		}
	}
}
