

import java.util.Scanner;

import org.omg.CORBA.INITIALIZE;

public class DFSChess_9663 {	
	static boolean[][] queenAt;
	boolean cannotPutN[][][];
	int N ;
	public DFSChess_9663(int n){
		N= n;
		availble = new boolean[n][n];
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				availble[i][j] = true;
		
		cannotPutN = new boolean[n][n][n+1];
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		if(!sc.hasNextInt()) return;
		DFSChess_9663 nQueen=new DFSChess_9663(sc.nextInt());
		System.out.println(nQueen.countWays());
		//nQueen.moveToNext();
	}

	public int countWays() {
		int count=0;
		for(int i =0; i<N; i++){
			for(int j =0; j<N; j++){
				count += canPutNQueen(i,j,N); 
			}
		}
		return count;
	}


/*	private boolean canPutNQueen(int i, int j, int rest) {
		if(rest ==0 ) return true; // Base Case
		//if(rest > countAvailble())
		if(isOut(i,j)) return false;
		if(rest>countCell(i+1, j+1)) return false;
		
		for(int k=i+1;k<N;k++){
			for(int t=j+1; t<N; t++){
				if(!isOut(k,t) && availble[k][t]){
					setAvaiable(k, t, false);
					if(canPutNQueen(k, t, rest-1)) return true;
					setAvaiable(k, t, true);
				}
			}
		}
	*/
	private int canPutNQueen(int i, int j, int rest) {
	
		if(rest ==0 ) return 1; // Base Case
		//if(rest > countAvailble())
		if(rest>countCell(i, j)){
			cannotPutN[i][j][rest] = true;
			return 0;
		}
		int count=0;
		
		/*for(int k=i;k<N;k++){
			for(int t=j; t<N; t++){*/
		int k=i; int t=j;
		while(!isOut(k,t)){
				if(canPutQueen(k,t) && !cannotPutN[k][t][rest-1]){
					
					queenAt[k][t]=true;
					count += canPutNQueen(k+1,t+1, rest-1);
					queenAt[k][t]=false;
					
					
					
					
				}
				t++;
				if(t>=N){t=0; k++;}
			}
		return count;
	}
	private static boolean canPutQueen(int i, int j) {
		for(int plus =0; plus<N; plus++){
			if(queenAt[plus][j] || queenAt[plus][j]||queenAt[(i+plus)%N][(j+plus)%N]) return false;
		}
		return true;
	}
	private boolean isOut(int i, int j) {
		if(i<N && j<N && i>=0 && j>=0) return false;
		return true;
	}

	private int countCell(int i, int j) {
		return (N-i)*(N-j) + i*(N-j-1);
	}

}
