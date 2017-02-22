import java.util.Scanner;

import com.sun.javafx.css.CalculatedValue;

public class TreeDiameter_1967 {

	static int n;
	static int[] maxPath;
	static int[][] weightPath; // 가중치 저장
	static int[][] pathToLeaf; // longest, nextLongest 저장
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 노드수 
		maxPath = new int[n];
		weightPath = new int[n][n];
		pathToLeaf = new int[n][2];
		
		for(int i=1; i<n; i++) {
			int parentNum = sc.nextInt()-1;
			int childNum = sc.nextInt()-1;
			int weight = sc.nextInt();
			
			makeWeightGraph(parentNum, childNum, weight);
		}
		calcPathToLeaf(); // 리프노드까지 거리
		System.out.println(calcMaxPath());
	}

	private static int calcMaxPath() {
		for(int i=n-1; i>=0; i--) { // 리프부터 i로 향하는 가장 긴 길이+그다음으로 긴길이를 더하면 i로 향하는 가장 긴 길이
			// System.out.println(pathToLeaf[i][0] + "  " + pathToLeaf[i][1]);
			maxPath[i] = pathToLeaf[i][0] + pathToLeaf[i][1];
			
		}
		int max = 0;
		for(int i=0; i<n; i++) {
			if(max<maxPath[i]) max = maxPath[i];
		}
		return max;
	}

	private static void calcPathToLeaf() {
		for(int i=n-1; i>=0; i--) { // 맨 아래층부터 시작
			int longest = 0; // i부터 맨 아래노드까지 길이가 가징 긴 길이
			int nextLongest = 0; // 그 다음으로 긴 길이
			
			for(int j=0; j<n; j++) {
				//System.out.println(i + " : " + j + " : " + weightPath[i][j]);
				if(weightPath[i][j]>0) {
					// 가장 긴 길이와 가중치 더함
					int newPath = weightPath[i][j] + pathToLeaf[j][0];
					
					//System.out.println(weightPath[i][j] + " + "+ pathToLeaf[j][0] + " = "+ newPath);
					if(longest < newPath) {
						nextLongest = longest;
						longest = newPath;
					} else if(nextLongest < newPath) {
						nextLongest = newPath;
					}
					//System.out.println("longest : " + longest + " nextLongest : " + nextLongest);
				}
			}
			pathToLeaf[i][0] = longest;
			pathToLeaf[i][1] = nextLongest;
		}
	}

	private static void makeWeightGraph(int parentNum, int childNum, int weight) {
		weightPath[parentNum][childNum] = weight;
	}

}
