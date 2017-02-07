import java.util.Scanner;

public class MaxHeap_11279_array {
	static int[] maxHeap; // 주의 1부터 시작 
	static int pointer;
	public static void main(String[] args) {
		Scanner inputScanner= new Scanner(System.in);
		int lines=inputScanner.nextInt();
		maxHeap = new int[100000];
		for(int i=0; i<maxHeap.length; i++)
			maxHeap[i]=-1;
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
		int i =0;
		maxHeap[i]= -1;
		while(2*i+2<maxHeap.length){
			if(maxHeap[2*i+1]<0){
				// no child
				break;
			}
			if(maxHeap[2*i+2]>0 && maxHeap[i]<maxHeap[2*i+2]){ // two child - move to 2*i+2
				int temp = maxHeap[2*i+2];
				maxHeap[2*i+2] = maxHeap[i];
				maxHeap[i]= temp;
				i = 2*i+2;
				continue;
			}
			if(maxHeap[2*i+1]>0&& maxHeap[i]<maxHeap[2*i+1]){ // one child - move to 2*i+1
				int temp2 = maxHeap[2*i+1];
				maxHeap[2*i+1] = maxHeap[i];
				maxHeap[i]= temp2;
				i = 2*i+1;
			}
		}
		// i -실제 삭제된 노드 자리--

		//System.out.println("Removed max -- at "+i);	
		return maxHeap;
	}
	private static int findMax() {
		// TODO Auto-generated method stub
		return (maxHeap[0]<0 ? 0: maxHeap[0]);
	}
	private static int[] insert(int next) {
		// TODO Auto-generated method stub
		int i=0;
		while(i<maxHeap.length && maxHeap[i]>0){
			i++;
		}
		//i - index to be inserted - next to the last node
		maxHeap[i]=next;
		
		while(i>0){
			if(maxHeap[i]<maxHeap[(i-1)/2]) break;
				
			int temp = maxHeap[(i-1)/2];
			maxHeap[(i-1)/2] = maxHeap[i];
			maxHeap[i]= temp;
			i = (i-1)/2;
			
		}//Inside your loop you are setting i to (i - 1) / 2, this is -1 / 2, which is rounded towards zero, yielding 0 again.
		//System.out.println("Inserted "+ next+" at "+maxHeap[i]);
		return maxHeap;
	}

}
