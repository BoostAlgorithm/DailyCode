import java.util.Scanner;

public class TreeBinary_5639_v3 {
	static String str;
	static int data;
	static Node root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		if(sc.hasNextLine()&&!(str = sc.nextLine()).equals("")){
			root = new Node(Integer.parseInt(str),null,null,null, false);
		}
		Node lastPrintedLeftRoot = root;
		Node curNode = root;
		while(sc.hasNextLine()&& !(str = sc.nextLine()).equals("")){
			
			data = Integer.parseInt(str);
			if( curNode.data > data){ //left child--parent>left child
				Node newOne = new Node(data,null,null,curNode,true);
				curNode.left = newOne;
				lastPrintedLeftRoot = newOne;
			System.out.println("P: "+curNode.data+"N: "+newOne.data+" AS LEFT");
				curNode = newOne;
			}else{
				/*while(curNode!=null){409 479 10 838 150 441
					if(curNode.data < data){
						curNode = curNode.left;
						Node newOne = new Node(data,null,null,curNode);
						curNode.right = newOne;
						curNode= newOne;
						break;
					}curNode = curNode.parent;
				} // 전위 - 부모가 맨 처음에 출력되므로 그담의 노드들은 다 자식 =root까지 올라갔을때 새로운 right의 자리 찾았을 것 = while 문 종료 전에 새로운 노드 위치 찾았을
				*/
				
				/*if(!curNode.isLeft){ // parent(right) > right child
					Node newOne = new Node(data,null,null,curNode,false);
					curNode.right = newOne;
					continue;
				}*/
				
			/*
				while ( curNode.parent !=null && curNode.parent.data<data && curNode.parent.isLeft || curNode.parent == root) ) //&& (curNode.isLeft && curNode.parent.right == null))//&& !curNode.parent.isLeft){curNode.parent != null &&
						curNode = curNode.parent;*/
				/*while(curNode.right!=null){
					curNode = curNode.right;
				}*/	
				//keep the right position
				
				// go up to parent while parent.data < data 
				/*
				 * 50
										40
										30
										31
										32
										33
										34
										
										409 479 10 838 150 441
										
10 150 441 838 479 409
				 */
				Node tempNode = curNode; //rightmost
				
				curNode = lastPrintedLeftRoot;
				while ( curNode.parent !=null && curNode.parent.data<data && curNode.parent.left == curNode){
						curNode = curNode.parent;
				}
				if(curNode == lastPrintedLeftRoot) curNode = tempNode;
				else lastPrintedLeftRoot = curNode;
					Node newOne = new Node(data,null,null,curNode,false);
					curNode.right = newOne; 
					System.out.println("P: "+curNode.data+"N: "+newOne.data	+" AS RIGHT");
					curNode= newOne;
				}
			System.out.println("Last Printed Left Root "+lastPrintedLeftRoot.data);
		}
				
		System.out.println(printPostOrder(root, new StringBuffer()).toString());
		
	}
	private static StringBuffer printPostOrder(Node root,StringBuffer sb) {
		if(root== null) return sb;
		sb = printPostOrder(root.left, sb);
		sb = printPostOrder(root.right, sb);
		sb.append(root.data+"\n");
		return sb;
	}
	static class Node{
		Node left;
		Node right;
		Node parent;
		boolean isLeft;
		
		int data;
		public Node(int data, Node left, Node right){
			this.data=data;
			this.left=left;
			this.right=right;
		}
		public Node(int data, Node left, Node right,Node parent,boolean isLeft){
			this(data,left,right);
			this.parent=parent;
			this.isLeft=isLeft;
		}
	}
}
