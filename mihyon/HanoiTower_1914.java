import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class HanoiTower_1914 {
	static int[] state = new int[]{0,0,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //원판의 개수 N (1 ≤ N ≤ 100)
		//state[2] = 2^N-1; // 0~2^(N-1)의 모든 비트 1 
		state[2] = (int) (Math.pow(2, N) -1);
		Stack st = bfs(state, N);
		StringBuffer sb= new StringBuffer();
		sb.append(st.size()+"\n");
		while(!st.isEmpty()){
			int[] move=(int[])st.pop();
			sb.append(move[0]+" "+move[1]+"\n");
		}
		System.out.println(sb.toString());
		
	}
	public static Stack bfs(int[] initialState, int N){

		HashMap  parent= new HashMap(); //?
		LinkedList<int[]> stateQue = new LinkedList<int[]>();
		stateQue.add(Arrays.copyOf(initialState,initialState.length));
		int[] curState = initialState;
		int filled = (int) (Math.pow(2, N) -1); 
		while(!stateQue.isEmpty()){
			curState = stateQue.poll();
			if(curState[0]== filled)
				break;
			
			for(int i=0; i<state.length; i++){
				for(int j=0; j<state.length; j++){
					if(i!=j && getTop(i, curState)<getTop(j, curState)){
						
						curState= moveTop(i, j, curState);
						//stateQue.add(curState);
						int [] temp = Arrays.copyOf(curState, curState.length);
						parent.put(temp,new int[]{i,j});
						stateQue.add(temp);
						curState = moveTop(j,i, curState);
					}
					
				}
			}
		}if(curState[0]==filled){
			return processPath(curState,N,parent);
		}
		return null;
	}
	

    private static Stack processPath(int[] curState,int N,HashMap parent) {
		// TODO Auto-generated method stub
    	Stack shortestPath =new Stack<>();
		int filled = (int) (Math.pow(2, N) -1); 
		while(curState[2]!=filled){
			int[] move = null;
			if(parent.containsKey(curState)){  
				move = (int[]) parent.get(curState);
				shortestPath.push(move);
				curState = moveTop(move[1],move[0],curState);
			}
		}return shortestPath;
	}
	/*This approach would get complex managing, you could store a map:V->V [from vertices to vertices], which will map from each node v, the vertex u that "discovered" v.

You will populate this map during the iterations of BFS.

Later - you can reconstruct the path by simply going from the target node [in the map] - up until you get back to the source. This map can be implemented as an array, if you enumerate the vertices.
     * **
     * Adds the nodes involved in the shortest path.
     *
     * @param src         The source node.
     * @param destination The destination node.
     * @param path        The path that has nodes and their neighbours.
     * @return The shortest path.
     */
 /*   private static ArrayList<String> processPath(String src, String destination,
                                                 ArrayList<String> path) {

        // Finds out where the destination node directly comes from.
        int index = path.indexOf(destination);
        String source = path.get(index + 1);

        // Adds the destination node to the shortestPath.
        shortestPath.add(0, destination);

        if (source.equals(src)) {
            // The original source node is found.
            shortestPath.add(0, src);
            return shortestPath;
        } else {
            // We find where the source node of the destination node
            // comes from.
            // We then set the source node to be the destination node.
            return processPath(src, source, path);
        }
    }
}*/
	public static int getTop(int bitf, int[] curState){ // 최하위 비트 구하
		int rightBit  = curState[bitf] & -curState[bitf];
		return rightBit;
	}
	public static int[] moveTop( int fromBit,int toBit, int[] curState){
		curState[toBit]  |= (1 << getTop(fromBit,curState));
		curState[fromBit] = curState[fromBit]& (curState[fromBit] - 1);
		return curState;
	}
}
