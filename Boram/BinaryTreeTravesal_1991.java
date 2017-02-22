import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BinaryTreeTravesal_1991 {
	
	static Node root;
	public static void addNode(Node parent, String value, String side){		
		// 처음에 add하는 경우  root노드를 추가함
		if(root == null){
			Node newNode = new Node(value);
			root = newNode;
			// System.out.println("root Node: " + root.toString());
			return;
		}
		Node newNode = new Node(parent, value);
		// root 노드 이외의 다른 노드가 추가 될때, root보다				
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
	
	// 전위 순회(preorder traversal)
	public static void preOrderTraverseTree(Node focusNode){
		if(focusNode != null){
			System.out.print(focusNode.toString());
			preOrderTraverseTree(focusNode.leftChild);
			preOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	// 중위 순회(inorder traversal)
	public static void inOrderTraverseTree(Node focusNode){
		if(focusNode != null){
			inOrderTraverseTree(focusNode.leftChild);
			System.out.print(focusNode.toString());
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	// 후위 순회(postorder traversal)
	public static void postOrderTraverseTree(Node focusNode){
		if(focusNode != null){
			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);
			System.out.print(focusNode.toString());
		}
	}
	
	// value 값을 갖고 있는 Parent 노드를 찾는 함수
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
	// Node는 String 값과  parent/rightChild/leftChild 값을 가진다.
    static class Node{
		String value;
		Node parent = null;
		Node rightChild = null;
		Node leftChild = null;
		// 루트노드일 경우 초기화
		Node(String value){
			this.parent = null;
			this.value = value;
		}
		// 루트노드가 아닐 경우 초기화
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
	 *  이진트리 전위순회, 중위순회, 후위순회로 출력하는 문제 
	 */
		Scanner input= new Scanner(System.in);		
		int count = input.nextInt();
		// StringTokenizer로 입력된 값을 받는다. (첫번째 값 parent, 두번째 값 leftChild, 세번째 값 rightChild) 
		for(int i = 0; i < count; i++){
			String str = input.nextLine();	
			String parent, leftChild, rightChild;	
			StringTokenizer st = new StringTokenizer(str," ");
			if(st.hasMoreTokens()){
				parent = st.nextToken();
				leftChild = st.nextToken();
				rightChild = st.nextToken();	
				// System.out.println(parent + leftChild + rightChild);
				// root 일 경우, 노드 추가
				if(root == null && parent.equals("A")){
					addNode(root, parent, null);
					addNode(root, leftChild, "leftChild");
					addNode(root, rightChild, "rightChild");
				// root가 아닐경우
				}else{	
					if(!leftChild.equals(".")){
						// System.out.println("return:" + findParent(root, parent));
						// findParent(root, parent)를 호출하면 B가 parent일 때, B를 값으로 가지고 있는  노드를 리턴
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