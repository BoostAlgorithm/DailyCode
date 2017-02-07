import java.util.Scanner;
public class StackSequence_1874 {
	static boolean[] used;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder out = new StringBuilder();
		Scanner inputStream = new Scanner(System.in);
		//int lines= inputStream.nextInt();
		int lines=Integer.parseInt(inputStream.nextLine());
		used = new boolean[lines+1];
		int previous =-1;
		for(int j=0; j<lines;j++){
			used[j] = false;
		}
		
		for (int i=0; i<lines ; i++){
			int next = inputStream.nextInt(); // index는 -1
			int leftCnt=0;
			if(previous == -1) { //첫번째 숫자
				for(int j=0; j<next; j++) out.append("+\n");
				out.append("-\n");
				used[next] = true;
				previous = next;
				continue;
			}
			if(previous < next){
				
				for(int k=previous; k<=next; k++){  
					if(used[k] == false) leftCnt++;
				}
				for(int j=0; j<leftCnt; j++) out.append("+\n");
				out.append("-\n");
			}else{ // previous>next
			
				for(int k=previous; k>next; k--){  
					if(used[k] == false) {
						leftCnt++; break; 
					}
				}
				if(leftCnt > 0 ){ out = new StringBuilder("NO"); break;}
				out.append("-\n");
			}
			
			used[next] = true;
			previous = next;
			
		}System.out.print(out.toString());
	}

}
