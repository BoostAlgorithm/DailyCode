import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
/*
 * Java Tree Implementation
 * http://stackoverflow.com/questions/3522454/java-tree-data-structure
 * 
 * Assumed that tree is not a shared tree (parent �� �� & �׷��� �ƴ�) - not visiting a child twice using DFS
 * 
 * �޸� / �ð�
 * 9496 KB/104 MS
 */
public class Tree_1068_v2 {
	private static Node root;
	//root�� �ϳ� �̻��� �� �ִ�?
	static class Node{
		int data;
		Node parent;
		List<Node> child;
		
		public Node(int data, Node parent){
			this.data = data;
			this.parent = parent;
			this.child= new LinkedList<Node>();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner (System.in);
		int nodes = inputScanner.nextInt();
		Node[] parentN = new Node[nodes];
		Node[] n = new Node[nodes]; // ��� ��ü�� �ٷ� �����Ͽ� �θ�-�ڽ� ���� ������ ����
		
		/*for(int i =0; i<nodes; i++){
			int parent = inputScanner.nextInt();
			if(parent == -1){ 
				n[i] = new Node(i,null);
				root = n[i];
				continue;
				} //root 
			n[i]= new Node(i,n[parent]);
			 
			n[parent].child.add(n[i]); //i - child
		}
		-- �̷��� �ϸ� 
		 3 2 1 0 -1 
		 �̷������� �־����� 
		 n[parent].child���� NullPointerException 
		*/
		for(int i =0; i<nodes; i++){
			parentN[i] = new Node( inputScanner.nextInt(), null);
			n[i] = new Node(i,null); //i : index of node..
		}
		for(int j=0; j<nodes; j++){
			if(parentN[j].data == -1){
				root = parentN[j];
				continue;
			}
			parentN[parentN[j].data].child.add( parentN[j] );
			parentN[j].parent = parentN[parentN[j].data];
			parentN[j].data = j;
			
			/*
			n[j].parent= n[parentN[j].data];
			n[parentN[j].data].child.add(n[j]);
			  */
		}
		n = parentN;
		
		int toDelete = inputScanner.nextInt();
		//deleteNodes(n[toDelete]); -- ��� ���� 
		
		if(n[toDelete].parent != null) n[toDelete].parent.child.remove(n[toDelete]);
		else if(n[toDelete] == root){ //��Ʈ ����
			root = null;	
		}
		System.out.println(countLeaf(root));
	
		
	}	
	public static int countLeaf(Node x){
		int count =0;
		if(x == null) return 0;
		if(x.child.isEmpty()){
			return 1;
		}
		ListIterator<Node> li=x.child.listIterator();
		while(li.hasNext())
			count += countLeaf(li.next());
		
		return count;
	}
	public static Node deleteNodes( Node x ){
		//�ش� ���� �ش� ��带 ����Ʈ���� ���� ��� ��� ����  
		//���
		// �⺻ ���̽�: children�� ���� leaf ��忡 ���Ͽ� null?
		// ��� ���̽�: children�� ���Ͽ� deleteNodes ȣ�� & x.child���� ����
		
		if(x.child.isEmpty()){
			x.parent.child.remove(x);
			//x = null;
			return x; 
		} 
			ListIterator<Node> li=x.child.listIterator();
			while(li.hasNext()){
			
				Node child = li.next();
				deleteNodes(child);
			//	li.remove(); //child ���� 
		
			}
		
		return x;
	}

}
