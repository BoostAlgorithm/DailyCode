import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BinaryTreeTravesal_1991 {
	
	static Node root;
	public static void addNode(Node parent, String value, String side){		
		// ó���� add�ϴ� ���  root��带 �߰���
		if(root == null){
			Node newNode = new Node(value);
			root = newNode;
			// System.out.println("root Node: " + root.toString());
			return;
		}
		Node newNode = new Node(parent, value);
		// root ��� �̿��� �ٸ� ��尡 �߰� �ɶ�, root����				
		if(side.equals("leftChild")){
			if(parent != null){
				parent.leftChild = newNode;	
				// System.out.println("leftChild Node: " + newNode.toString());
			}
		}else{
			if(parent != null){
				parent.rightChild = newNode;
				// System.out.println("rightChild Node: " + newNode.toString());
			}
		}		
	}
	
	// ���� ��ȸ(preorder traversal)
	public static void preOrderTraverseTree(Node focusNode){
		if(focusNode != null){
			System.out.print(focusNode.toString());
			preOrderTraverseTree(focusNode.leftChild);
			preOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	// ���� ��ȸ(inorder traversal)
	public static void inOrderTraverseTree(Node focusNode){
		if(focusNode != null){
			inOrderTraverseTree(focusNode.leftChild);
			System.out.print(focusNode.toString());
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	// ���� ��ȸ(postorder traversal)
	public static void postOrderTraverseTree(Node focusNode){
		if(focusNode != null){
			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);
			System.out.print(focusNode.toString());
		}
	}
	
	// value ���� ���� �ִ� Parent ��带 ã�� �Լ�
	static Node findParent(Node focusNode, String value){
		Node temp = null;
		if(focusNode != null){
			if(focusNode.toString().equals(value)) { 
				return focusNode; 
			}					
			temp = findParent(focusNode.leftChild, value);
			if(temp != null && temp.toString().equals(value)){
				focusNode = temp;
			}
			temp = findParent(focusNode.rightChild, value);
			if(temp != null && temp.toString().equals(value)){
				focusNode = temp;
			}
		}
		return focusNode;
	}
	// Node�� String ����  parent/rightChild/leftChild ���� ������.
    static class Node{
		String value;
		Node parent = null;
		Node rightChild = null;
		Node leftChild = null;
		// ��Ʈ����� ��� �ʱ�ȭ
		Node(String value){
			this.parent = null;
			this.value = value;
		}
		// ��Ʈ��尡 �ƴ� ��� �ʱ�ȭ
		Node(Node parent, String value){
			this.parent = parent;
			this.value = value;
		}	
		public String toString(){
			return this.value;
		}

	}

	public static void main(String[] args) throws Exception {
	/*
	 *  ����Ʈ�� ������ȸ, ������ȸ, ������ȸ�� ����ϴ� ���� 
	 */
		Scanner input= new Scanner(System.in);		
		int count = input.nextInt();
		// StringTokenizer�� �Էµ� ���� �޴´�. (ù��° �� parent, �ι�° �� leftChild, ����° �� rightChild) 
		for(int i = 0; i < count; i++){
			String str = input.nextLine();	
			String parent, leftChild, rightChild;	
			StringTokenizer st = new StringTokenizer(str," ");
			if(st.hasMoreTokens()){
				parent = st.nextToken();
				leftChild = st.nextToken();
				rightChild = st.nextToken();	
				// System.out.println(parent + leftChild + rightChild);
				// root �� ���, ��� �߰�
				if(root == null && parent.equals("A")){
					addNode(root, parent, null);
					addNode(root, leftChild, "leftChild");
					addNode(root, rightChild, "rightChild");
				// root�� �ƴҰ��
				}else{	
					if(!leftChild.equals(".")){
						// System.out.println("return:" + findParent(root, parent));
						// findParent(root, parent)�� ȣ���ϸ� B�� parent�� ��, B�� ������ ������ �ִ�  ��带 ����
						addNode(findParent(root, parent), leftChild, "leftChild");			
					}
					if(!rightChild.equals(".")){
						// System.out.println("return:" + findParent(root, parent));
						addNode(findParent(root, parent) , rightChild, "rightChild");
					}
				}	
			}	
		}
		
		preOrderTraverseTree(root);
		System.out.println("");
		inOrderTraverseTree(root);
		System.out.println("");
		postOrderTraverseTree(root);
	}
}