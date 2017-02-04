import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode {
	TreeNode parent; // �θ���
	int data; // ��
	List <TreeNode> children; // �ڽĳ���
	
	public TreeNode() {
	}
	public TreeNode(int data) {
		this.data = data;
		this.parent = new TreeNode();
		this.children = new ArrayList<TreeNode>();
	}
}

public class Tree_1068 {

	static TreeNode nodes[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ����� ��
		nodes = new TreeNode[n];
		
		for(int i=0; i<n; i++) {
			nodes[i] = new TreeNode(i);
			int parent = sc.nextInt(); // �θ� ���
			if(parent!=-1) {
				nodes[i].parent=nodes[parent];
			} else {
				nodes[i].parent.data=-1;
			}
		}
		
		for(int i=0; i<n; i++) {
			int parentData = nodes[i].parent.data;
			if(parentData!=-1) {
				nodes[parentData].children.add(nodes[i]);
			}
		}
		
		int removeNode = sc.nextInt(); // ������ ���
		removeTree(nodes[removeNode]);
		int count=0;
		for(int i=0; i<nodes.length; i++) {
			try {
				if(nodes[i].children.size()==0) {
					count++;
				}
			} catch(Exception e) {
			}
		}
		System.out.println(count);
	}

	private static void removeTree(TreeNode removeNode) {
		for(int i = 0; i < removeNode.children.size(); i++) {  //child ��ȸ
			removeTree(removeNode.children.get(i));
		}
		nodes[removeNode.data]=null;
	}
}