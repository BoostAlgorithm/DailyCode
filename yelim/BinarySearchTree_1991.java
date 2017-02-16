import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class NodeDTO {
	private char value;
	private char leftValue;
	private char rightValue;
	
	NodeDTO leftNode;
	NodeDTO rightNode;
	
	public NodeDTO() {}
	public NodeDTO(char value, char leftValue, char rightValue) {
		this.value = value;
		this.leftValue = leftValue;
		this.rightValue = rightValue;
	}
	public char getValue() {
		return value;
	}
	public void setValue(char value) {
		this.value = value;
	}
	public char getLeftValue() {
		return leftValue;
	}
	public void setLeftValue(char leftValue) {
		this.leftValue = leftValue;
	}
	public char getRightValue() {
		return rightValue;
	}
	public void setRightValue(char rightValue) {
		this.rightValue = rightValue;
	}
	public NodeDTO getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(NodeDTO leftNode) {
		this.leftNode = leftNode;
	}
	public NodeDTO getRightNode() {
		return rightNode;
	}
	public void setRightNode(NodeDTO rightNode) {
		this.rightNode = rightNode;
	}
	
}
public class BinarySearchTree_1991 {

	public static void main(String[] args) throws IOException {
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int n = Integer.parseInt(br.readLine()); // 이진 트리 노드의 갯수
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		NodeDTO nodes[] = new NodeDTO[n]; 
		
		char value;
		char leftValue;
		char rightValue;

		for(int i=0; i<n; i++) {
			value = sc.next().charAt(0); 
			leftValue = sc.next().charAt(0);
			rightValue = sc.next().charAt(0);
			
			NodeDTO node = new NodeDTO(value, leftValue, rightValue);
			nodes[i]=node;

			char parentLeft;
			char parentRight;
			
			for(int j=0; j<i; j++) {
				parentLeft = nodes[j].getLeftValue();
				parentRight = nodes[j].getRightValue();
				
				if(parentLeft==value) {
					nodes[j].leftNode=nodes[i];
				} 
				if(parentRight==value) {
					nodes[j].rightNode=nodes[i];
				}
			}
		}
		
		preOrder(nodes[0]);
		System.out.println();
		inOrder(nodes[0]);
		System.out.println();
		postOrder(nodes[0]);
	}

	private static void preOrder(NodeDTO root) {
		if(root==null) return;
		System.out.print(root.getValue());
		preOrder(root.getLeftNode());
		preOrder(root.getRightNode());
	}
	private static void inOrder(NodeDTO root) {
		if(root==null) return;
		inOrder(root.getLeftNode());
		System.out.print(root.getValue());
		inOrder(root.getRightNode());
	}
	private static void postOrder(NodeDTO root) {
		if(root==null) return;
		postOrder(root.getLeftNode());
		postOrder(root.getRightNode());
		System.out.print(root.getValue());
	}
}
