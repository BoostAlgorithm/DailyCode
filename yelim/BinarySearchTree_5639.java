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
	 * 1. ����Ʈ�� ������ȸ Ž�� ����� �����ϰ� Ʈ���� �籸��
	 * 2. ����Ʈ�� ù���� ��Ʈ
	 * 3. ����Ʈ���� ��Ʈ���� Ž���� ���� ���� �ε�������(��Ʈ ���� ����Ʈ�� ������) ���鼭 
	 * ��Ʈ���� ó������ ū ���� �ε���ã�� 
	 * �� �ε��� ���ĺ��ʹ� ������ ����Ʈ������
	 * �� ���������� ���� ����Ʈ�� ����
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
		
		Node root = new Node(list.get(rootIndex.index)); // ��Ʈ ��� ����
		rootIndex.index++; // ������ ���� ��� �ε���
			
		if(lowIndex==highIndex) return root;
		
		int i;
		for(i=lowIndex; i<=highIndex; i++) {
			if(list.get(i)>root.getValue()) {// ��Ʈ �������� ó������ ū ���� �ε��� ã��
				break;
			}
		}
		// ��Ʈ<x<list.get(i)�� ������ ���� ����Ʈ�� ����
		root.setLeftNode(getBinarySearchTree(list, rootIndex, rootIndex.index, i-1, length));
		
		// list.get(i+1)<x<list.get(length-1) ������ ������ ����Ʈ�� ����
		root.setRightNode(getBinarySearchTree(list, rootIndex, i, highIndex, length));
		
		return root;
	}
}
