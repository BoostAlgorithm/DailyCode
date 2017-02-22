import java.util.*;

public class BinarySearchTree_5639 {
	static Node root;
	// static List<Node> binaryTree = new ArrayList<Node>();
	public static void addNode(int value){
		// add�� Node�� �ʱ�ȭ�ϴ� �κ�
		Node newNode = new Node(value);
		
		// ó���� add�ϴ� ���  root��带 �߰���
		if(root == null){
			root = newNode;
		}else{
		// root ��� �̿��� �ٸ� ��尡 �߰� �ɶ�, root����
			Node focusNode = root;
			Node parent;
			while(true){
				parent = focusNode;
				if(value < focusNode.value){
					focusNode = focusNode.leftChild;
					if(focusNode == null){
						parent.leftChild = newNode;
						return;
					}
				}else{
					focusNode = focusNode.rightChild;
					if(focusNode == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
			
		}
	}

	public static void postOrderTraverseTree(Node focusNode){
		if(focusNode != null){
			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);
			//binaryTree.add(focusNode);
			System.out.println(focusNode.toString());
		}
	}

	static class Node{
		int value;
		Node rightChild;
		Node leftChild;
		Node(int value){
			this.value = value;
		}
		public String toString(){
			return this.value + "";
		}
	}

	public static void main(String[] args) throws Exception {
		/* 
		 * preorder ������ �Է��� �ް�, Node�� Ʈ���� �߰� ��Ų�ڿ�
		 * postOrderTraverseTree(root: ���������� ����� ��Ʈ���)�� ���
		 */
		Scanner input = new Scanner(System.in);
		List<Integer> preOrderBT = new ArrayList<Integer>();		
		int treeSize;
		int rootVal, index = 0;
		
		while(input.hasNextInt()){ 
			preOrderBT.add(input.nextInt());
		}		
		// System.out.println("tree size: " +  preOrderBT.size());
		
		for(int i = 0; i < preOrderBT.size(); i++){
			addNode(preOrderBT.get(i));
			// System.out.println("Preorder Add: "+ preOrderBT.get(i));
		}	
		postOrderTraverseTree(root);
	}
}

