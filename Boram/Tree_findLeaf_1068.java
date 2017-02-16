import java.io.*;
// 이진트리로 구현했기에 틀렸음
public class Tree_findLeaf_1068 {

	public static void main(String[] args) throws IOException {
		int n, d_node; // n: N개의 노드, d_node: 삭제할 노드, ㅣeaf: leaf 노드 개수
		int[] tree; // 입력된 값을 저장할 배열 (트리의 값을 저장)
		String in_tree;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		in_tree = in.readLine();
		
		String[] str = in_tree.split(" ");
		tree = new int[n]; 
		TreeNode tn = new TreeNode(n, tree);

		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(str[i]);
			//System.out.println("tree[" + i + "]: " + tree[i] + " ");
		}

		d_node = Integer.parseInt(in.readLine());
		// System.out.println("d_node: " + d_node + " ");
		for (int i = 0; i < n; i++) {
			if (i == d_node) {
				// System.out.println("tree[" + i + "]: " + tree[i] + " ");
				tree[i] = -2;
				if (n - 1 >= 2 * i + 2) {
					tn.findLeftChild(2 * i + 1);
					tn.findRightChild(2 * i + 2);
				}
			}
		}
		tn.checkLeafNode();
	}

}

class TreeNode { // 트리 연산을 위한 ( 노드삭제, leaf 갯수확인)
	int n; // 트리 저장공간 크기
	int size = 0;
	int[] tree;

	public TreeNode(int n, int[] tree) {
		this.n = n;
		this.tree = tree;
	}
	
	void getSize(){	
		for(int i = 0; i < n; i++){
			if(tree[i] >= -1) { size++; }
		}
		//System.out.println(size);
	}

	void checkLeafNode() { // leaf노드가 몇개 인지 확인하는 함수
		int leaf = 0;
		getSize();
		// node가 완전이진트리일때만 성립됨, 불완전이진트리일때도 가능하도록!
		for (int i = 0; i < n; i++) {
			if (tree[i] == -2) {
				continue;				
			} else if (size - 1 < 2 * i + 1 && size - 1 < 2 * i + 2) {
				leaf++;
			}
		}
		System.out.println(leaf);
	}

	void findRightChild(int i) { // 주어진 노드의  rightChild이 존재하면 삭제하는 함수 (재귀 양쪽)
		tree[i] = -2;
		getSize();
		if (size - 1 >= 2 * i + 2) {
			findLeftChild(2 * i + 1);
			findRightChild(2 * i + 2);
		}
	}

	void findLeftChild(int i) { // 주어진 노드의  leftChild이 존재하면 삭제하는 함수  (재귀 양쪽)
		tree[i] = -2;
		if (size - 1 >= 2 * i + 1) {
			findLeftChild(2 * i + 1);
			findRightChild(2 * i + 2);
		}
	}

}