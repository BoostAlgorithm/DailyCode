import java.util.Scanner;

import com.sun.javafx.css.CalculatedValue;

public class TreeDiameter_1967 {

	static int n;
	static int[] maxPath;
	static int[][] weightPath; // ����ġ ����
	static int[][] pathToLeaf; // longest, nextLongest ����
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // ���� 
		maxPath = new int[n];
		weightPath = new int[n][n];
		pathToLeaf = new int[n][2];
		
		for(int i=1; i<n; i++) {
			int parentNum = sc.nextInt()-1;
			int childNum = sc.nextInt()-1;
			int weight = sc.nextInt();
			
			makeWeightGraph(parentNum, childNum, weight);
		}
		calcPathToLeaf(); // ���������� �Ÿ�
		System.out.println(calcMaxPath());
	}

	private static int calcMaxPath() {
		for(int i=n-1; i>=0; i--) { // �������� i�� ���ϴ� ���� �� ����+�״������� ����̸� ���ϸ� i�� ���ϴ� ���� �� ����
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
		for(int i=n-1; i>=0; i--) { // �� �Ʒ������� ����
			int longest = 0; // i���� �� �Ʒ������� ���̰� ��¡ �� ����
			int nextLongest = 0; // �� �������� �� ����
			
			for(int j=0; j<n; j++) {
				//System.out.println(i + " : " + j + " : " + weightPath[i][j]);
				if(weightPath[i][j]>0) {
					// ���� �� ���̿� ����ġ ����
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
