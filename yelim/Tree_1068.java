import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode {
	TreeNode parent; // 부모노드
	int data; // 값
	List <TreeNode> children; // 자식노드들
	
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
		int n = sc.nextInt(); // 노드의 수
		nodes = new TreeNode[n];
		
		for(int i=0; i<n; i++) {
			nodes[i] = new TreeNode(i);
			int parent = sc.nextInt(); // 부모 노드
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
		
		int removeNode = sc.nextInt(); // 제거할 노드
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
		for(int i = 0; i < removeNode.children.size(); i++) {  //child 순회
			removeTree(removeNode.children.get(i));
		}
		nodes[removeNode.data]=null;
	}
}