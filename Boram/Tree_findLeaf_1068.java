import java.io.*;

public class Tree_findLeaf_1068 {

	public static void main(String[] args) throws IOException {
		int n, d_node, leaf = 0; // n: N���� ���, d_node: ������ ���, ��eaf: leaf ��� ����
		int[] tree; // �Էµ� ���� ������ �迭 (Ʈ���� ���� ����)
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
				//System.out.println("tree[" + i + "]: " + tree[i] + " ");
				tree[i] = -2;
				if (n - 1 >= 2 * i + 2) {
					tn.findLeftChild(2 * i + 1);
					tn.findRightChild(2 * i + 2);
				}
			}
		}
		leaf = tn.checkLeafNode();
		System.out.println(leaf);
	}

}

class TreeNode { // Ʈ�� ������ ���� ( ������, leaf ����Ȯ��)
	int n;
	int[] tree;

	public TreeNode(int n, int[] tree) {
		this.n = n;
		this.tree = tree;
	}

	int checkLeafNode() { // leaf��尡 � ���� Ȯ���ϴ� �Լ�
		int leaf = 0;
		for (int i = 0; i < n; i++) {
			if (tree[i] == -2) {
				continue;
			} else if (n - 1 < 2 * i + 1 && n - 1 < 2 * i + 2) {
				leaf++;
			}
		}
		return leaf;
	}

	void findRightChild(int i) { // �־��� �����  rightChild�� �����ϸ� �����ϴ� �Լ� (��� ����)
		tree[i] = -2;
		if (n - 1 >= 2 * i + 2) {
			findLeftChild(2 * i + 1);
			findRightChild(2 * i + 2);
		}
	}

	void findLeftChild(int i) { // �־��� �����  leftChild�� �����ϸ� �����ϴ� �Լ�  (��� ����)
		tree[i] = -2;
		if (n - 1 >= 2 * i + 1) {
			findLeftChild(2 * i + 1);
			findRightChild(2 * i + 2);
		}
	}

}