import java.util.*;

public class BinarySearchTree_5639 {
	static Node root;
	// static List<Node> binaryTree = new ArrayList<Node>();
	public static void addNode(int value){
		// add할 Node를 초기화하는 부분
		Node newNode = new Node(value);
		
		// 처음에 add하는 경우  root노드를 추가함
		if(root == null){
			root = newNode;
		}else{
		// root 노드 이외의 다른 노드가 추가 될때, root보다
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
		 * preorder 순으로 입력을 받고, Node로 트리를 추가 시킨뒤에
		 * postOrderTraverseTree(root: 전역변수로 선언된 루트노드)로 출력
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

