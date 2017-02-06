import java.util.Scanner;

public class MaxHeap_11279_array_from1 {
	static int[] maxHeap; // 주의 1부터 시작 
	static int pointer;
	public static void main(String[] args) {
		Scanner inputScanner= new Scanner(System.in);
		int lines=inputScanner.nextInt();
		maxHeap = new int[100001];
		for(int i=0; i<maxHeap.length; i++)
			maxHeap[i]=-1;
		maxHeap[0] = -100000;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<lines;i++){
			int next = inputScanner.nextInt();
			if(next>0){
				maxHeap = insert(next);		
			}
			else if(next ==0){
				sb.append(findMax()+"\n");
				maxHeap=removeMax();
			}
		}System.out.println(sb.toString());
		
	}
	private static int[] removeMax() {
		int i =1;
		maxHeap[i]= -1;
		while(2*i+1<maxHeap.length){
			 /*if(h[i]>h[i*2] && h[i]>h[i*2+1]) break;
		        else if (h[i*2]>h[i*2+1]){
		            swap(i,i*2); i=i*2;
		        } 
		        else {
		            swap(i,i*2+1); i=i*2+1;
		        }*/
			if(maxHeap[i]>maxHeap[i*2] && maxHeap[i]>maxHeap[i*2+1]) break;
			
			else if(maxHeap[2*i]>maxHeap[2*i+1]){
				int temp = maxHeap[2*i];
				maxHeap[2*i] = maxHeap[i];
				maxHeap[i]= temp;
				i = 2*i;
			}
			else{
				int temp2 = maxHeap[2*i+1];
				maxHeap[2*i+1] = maxHeap[i];
				maxHeap[i]= temp2;
				i = 2*i+1;
			}
				/* 원래 내가 했던 코드 -- 틀림
			if(maxHeap[2*i]>maxHeap[2*i+1]  && maxHeap[2*i]>maxHeap[i]){
				int temp = maxHeap[2*i];
				maxHeap[2*i] = maxHeap[i];
				maxHeap[i]= temp;
				i = 2*i;
				
			}else if((maxHeap[2*i+1]>maxHeap[2*i]  && maxHeap[2*i+1]>maxHeap[i])){
				int temp2 = maxHeap[2*i+1];
				maxHeap[2*i+1] = maxHeap[i];
				maxHeap[i]= temp2;
				i = 2*i+1;
			}else break;*/
			
		}
		// i -실제 삭제된 노드 자리--

		//System.out.println("Removed max -- at "+i);	
		return maxHeap;
	}
	private static int findMax() {
		// TODO Auto-generated method stub
		return (maxHeap[1]<0 ? 0: maxHeap[1]);
	}
	private static int[] insert(int next) {
		// TODO Auto-generated method stub
		int i=1;
		while(i<maxHeap.length && maxHeap[i]>0){
			i++;
		}
	
		//i - index to be inserted - next to the last node
		maxHeap[i]=next;
		
		while(i>1){
			if(maxHeap[i]<maxHeap[i/2]) break;
				
			int temp = maxHeap[i/2];
			maxHeap[i/2] = maxHeap[i];
			maxHeap[i]= temp;
			i = i/2;
			
		}//Inside your loop you are setting i to (i - 1) / 2, this is -1 / 2, which is rounded towards zero, yielding 0 again.
		//System.out.println("Inserted "+ next+" at "+maxHeap[i]);
		return maxHeap;
	}

}
