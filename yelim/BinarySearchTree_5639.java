import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	private int value;
	private Node leftNode;
	private Node rightNode;

	public Node() {
	}
	public Node(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
}

class RootIndex {
	int index=0;
}

public class BinarySearchTree_5639 {
	/**
	 * 1. 리스트에 전위순회 탐색 결과를 저장하고 트리를 재구성
	 * 2. 리스트의 첫값은 루트
	 * 3. 리스트에서 루트부터 탐색할 가장 높은 인덱스까지(루트 기준 리스트의 끝까지) 돌면서 
	 * 루트보다 처음으로 큰 값의 인덱스찾음 
	 * 이 인덱스 이후부터는 오른쪽 서브트리구성
	 * 그 이전까지는 왼쪽 서버트리 구성
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> preOrderList = new ArrayList<Integer>();
		RootIndex index = new RootIndex();
		while(sc.hasNextInt()) {
			preOrderList.add(sc.nextInt());
		}
		int length = preOrderList.size();
		Node root = getBinarySearchTree(preOrderList, index, 0, length-1, length);
		postOrder(root);
	}

	private static void postOrder(Node root) {
		if(root==null) return;
		postOrder(root.getLeftNode());
		postOrder(root.getRightNode());
		System.out.println(root.getValue());
	}

	private static Node getBinarySearchTree(List<Integer> list, RootIndex rootIndex, int lowIndex, int highIndex, int length) {
		if (rootIndex.index >= length || lowIndex > highIndex) {
			return null;
		}
		
		Node root = new Node(list.get(rootIndex.index)); // 루트 노드 생성
		rootIndex.index++; // 생성할 다음 노드 인덱스
			
		if(lowIndex==highIndex) return root;
		
		int i;
		for(i=lowIndex; i<=highIndex; i++) {
			if(list.get(i)>root.getValue()) {// 루트 기준으로 처음으로 큰 값의 인덱스 찾기
				break;
			}
		}
		// 루트<x<list.get(i)의 값들은 왼쪽 서브트리 구성
		root.setLeftNode(getBinarySearchTree(list, rootIndex, rootIndex.index, i-1, length));
		
		// list.get(i+1)<x<list.get(length-1) 값들은 오른쪽 서브트리 구성
		root.setRightNode(getBinarySearchTree(list, rootIndex, i, highIndex, length));
		
		return root;
	}
}
