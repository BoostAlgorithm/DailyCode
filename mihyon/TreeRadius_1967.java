import java.awt.image.PixelGrabber;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class TreeRadius_1967 {
	static int lines ;
	static int[] maxPath;
	static int[][] weightPath;
	static int[][] pathToLeaf;
	
//정확히 정의하자면 트리에 존재하는 모든 경로들 중에서 가장 긴 것의 길이를 말한다.
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner ds = new Scanner(System.in);
		lines= ds.nextInt();
		initialize(lines);
		for(int i=2; i <= lines; i++){
			makeEdge(ds.nextInt()-1, ds.nextInt()-1,ds.nextInt());
		}
		calculatePathToLeaf();
		System.out.println(calculateMaxPath());
	}

private static int calculateMaxPath() {
		for(int i= lines-1; i>=0 ; i--){
			maxPath[i] = pathToLeaf[i][0]+pathToLeaf[i][1];
		}
		int max =0;
		for(int i =0; i<lines; i++){
			max=Math.max(max, maxPath[i]);
		} return max;
	}

private static void calculatePathToLeaf() {
	// TODO Auto-generated method stub
	for(int i=lines-1; i>=0; i--){
		int longest =0;
		int nextLongest =0;
		for(int j=0; j<lines; j++){
			if(weightPath[i][j]>0 ){
				int newPath=weightPath[i][j]+pathToLeaf[j][0];
				 if(longest < newPath){
					 nextLongest = longest;
					 longest = newPath;
				 }else if(nextLongest <newPath){
					 nextLongest = newPath;
				 }
			}
		}
		pathToLeaf[i][0] =longest;
		pathToLeaf[i][1] = nextLongest;
	}
}

private static void initialize(int lines) {
	// TODO Auto-generated method stub
	maxPath= new int[lines];
	weightPath = new int[lines][lines];
	pathToLeaf = new int[lines][2];
}

private static void makeEdge(int parent, int child, int weight) {
	// TODO Auto-generated method stub
	weightPath[parent][child] = weight;
	weightPath[child][parent] = -weight;
}


}
