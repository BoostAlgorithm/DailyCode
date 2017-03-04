import java.util.Scanner;
/*
 *   public boolean canPlaceQueen(int r, int c) {
        /**
         * Returns TRUE if a queen can be placed in row r and column c.
         * Otherwise it returns FALSE. x[] is a global array whose first (r-1)
         * values have been set.
         */
/*        for (int i = 0; i < r; i++) {
            if (x[i] == c || (i - r) == (x[i] - c) ||(i - r) == (c - x[i])) 
            {
                return false;
            }
        }
        return true;
    }*/
 
public class DFS_NQueen_9663 {
	static boolean[][] queenAt;
	static int N ;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		if(!sc.hasNextInt()) return;
		N = sc.nextInt();
		init();
		System.out.println(canPutNQueen(0,N));
	}
	private static void init() {
		queenAt = new boolean[N][N];
		
	}
	/*public static void setAvaiable(int i, int j, boolean onFlag){
		queenAt[i][j]=onFlag;
		/*for(int plus=1; plus<N; plus++){
			availble[(i+plus)%N][j]=onFlag;
			availble[i][(j+plus)%N]=onFlag;
			availble[(i+plus)%N][(j+plus)%N]=onFlag;
		}*/
		/*for(int plus =0; plus<N; plus++){
			queenAt[plus][j]=onFlag;
			queenAt[i][plus]=onFlag;
			queenAt[(i+plus)%N][(j+plus)%N]=onFlag;
		}
	}*/
	private static boolean isOut(int i, int j) {
		if(i<N && j<N && i>=0 && j>=0) return false;
		return true;
	}


	/*
 1 search(col)
 2     if filled all columns
 3         print solution and exit 
 
 4   for each row
 5       if board(row, col) is not attacked
 6            place queen at (row, col)
 7            search(col+1)
 8            remove queen at (row, col)
 */
	private static int  canPutNQueen(int i, int rest) { // i -> i+1, rest -> rest-1 // 둘 중 하나만 써도 된다 
		
		if(rest ==0) {
			System.out.println("BASE");
			return 1; // Base Case
		}
		int count=0;
		for(int j=0; j<N; j++){
			/*if(!availble[i][j]) continue;
			setAvaiable(i, j, false);
			count += canPutNQueen(i+1,rest-1);
			setAvaiable(i, j, true);
			안되는 이유!이전단계에서 available- false 로 만든것도 다 true로 만듦 ㅠ ㅠ 
			- 이 방법을 유지하려면 매 단계 available 을 copy & paste하며, 유지해줘야
			*/
			if(!canPutQueen(i,j)) continue;
			queenAt[i][j]=true;
			count += canPutNQueen(i+1, rest-1);
			queenAt[i][j]=false;
			
		}return count;
		
		
	}
	private static boolean canPutQueen(int i, int j) {
		for(int plus =0; plus<N; plus++){
			if(queenAt[plus][j] || queenAt[i][plus]||queenAt[(i+plus)%N][(j+plus)%N]) return false;
		}
		return true;
		
		
	}

		
	
//	/*
//	 * 
//	 * 
//	 * bool isSafe(int board[N][N], int row, int col)
//	 *
//	{
//	    int i, j;
//	 
//	    /* Check this row on left side */
//	    for (i = 0; i < col; i++)
//	        if (board[row][i])
//	            return false;
//	 
//	    /* Check upper diagonal on left side */
//	    for (i=row, j=col; i>=0 && j>=0; i--, j--)
//	        if (board[i][j])
//	            return false;
//	 
//	    /* Check lower diagonal on left side */
//	    for (i=row, j=col; j>=0 && i<N; i++, j--)
//	        if (board[i][j])
//	            return false;
//	 
//	    return true;
//	}

}
