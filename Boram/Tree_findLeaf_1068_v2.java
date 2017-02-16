import java.io.*;
import java.util.*;


// http://bestalign.github.io/2015/08/31/top-10-mistakes-java-developers-make-1/
// ���� ��ũ�� �����Ͽ�, java.util.ConcurrentModificationException ������ �ذ��� ��
// Runtime Error

public class Tree_findLeaf_1068_v2 {
	// Ʈ���� ������ findLeaf_ 1068
	static int leaf = 0;
	public static void main(String[] args) throws Exception {
		int total, deletedIndex; // �Էµ� ����� ����, ������ ����� ��ȣ
		List<Integer> parent = new ArrayList(); // �Էµ� ����� �θ��� ��
		Node treeNode[];
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		total = Integer.parseInt(in.readLine());

		treeNode = new Node[total];
		String secondInput = in.readLine();
		String[] numbers = secondInput.split(" ");
		
		deletedIndex = Integer.parseInt(in.readLine());
		
		// �Է¹��� �����͸� ArrayList�� �޾Ƽ�, List ���� 
		for(int i = 0; i < total; i++){			
			int data = Integer.parseInt(numbers[i]);
			//System.out.println("before sort: "+ data);
			parent.add(data);
		}
		Collections.sort(parent);
		
		for(int i = 0; i < total; i++){ 
			int parentIndex = (int) parent.get(i);
			//System.out.println("after sort: " + parent.get(i));
			if( parentIndex != -1){ // ��Ʈ�� �ƴ� ����� ���
				treeNode[i] = new Node(parentIndex, treeNode[parentIndex]);
				//treeNode[i].setParent(treeNode[parentIndex]);
				treeNode[parentIndex].addChild(treeNode[i]);
			}else{ // ��Ʈ�� ���, -1 ���� ����
				treeNode[i] = new Node(parentIndex);
			}
				
		}		
		//printTree(treeNode[0], " ");
		deleteTree(treeNode[deletedIndex]);
		//System.out.println("after delete treeNode[" + deletedIndex + "]: "+ treeNode[deletedIndex].getData());
		printTree(treeNode[0], " ");
		System.out.println(leaf);
	}
	
	public static void printTree(Node node, String appender){
		if(node.isLeaf()) { leaf++; }
		//System.out.println(appender + node.getData());
//		for(Node each: node.getChildren()){
//			printTree(each, appender + appender);
//			
//		}		
		Iterator<Node> iter = node.getChildren().iterator();		
		while(iter.hasNext()){
			Node each = iter.next();
			printTree(each, appender + appender);
		}
	}
	
	public static void deleteTree(Node node){
		List<Node> children = node.getChildren();	
		//System.out.println(children.size());
//		for(int i = 0; i < children.size(); i++){
//			if(children.isEmpty()){ break; }
//			//System.out.println(children.get(i).getData());			
//			children.get(i).deleteNode();
//			deleteTree(children.get(i));
//		}
		Iterator<Node> iter = children.iterator();
		while(iter.hasNext()){
			Node each = iter.next();
			if(children.isEmpty()){ break;}
			each.deleteNode();
			deleteTree(each);
		}		
		node.deleteNode();
	}

}

class Node { 
	private int data = -2; // root: -1
	private Node parent = null;
	private List<Node> children = new ArrayList<Node>();
	
	public Node(int data){
		this.data = data;
	}
	
	public Node(int data, Node parent){
		this.data = data;
		this.parent = parent; //this.setParent(parent);
	}
	
	public List<Node> getChildren(){
		return children;
	}
	
	public void setParent(Node Parent){
		parent.addChild(this);
		this.parent = parent;
	}
	
	public void addChild(int data){
		Node child = new Node(data);
		child.setParent(this);
		this.children.add(child);
	}
	
	public void addChild(Node child){
		//child.setParent(this);
		this.children.add(child);
	}
	
	public int getData(){
		return this.data;
	}
	
	public void setData(int data){
		this.data = data;		
	}
	
	public boolean isRoot(){
		return this.parent == null;
	}
	
	public boolean isLeaf(){
		if(this.children.size() == 0){
			return true;
		}else 
			return false;
	}
	
	public void removeParent(){
		this.parent = null;
	}
	
	public void deleteNode(){ // ��Ʈ �̿��� �ٸ� ��带 ������ ��
		if(parent != null){
			int index = this.parent.getChildren().indexOf(this);
			this.parent.getChildren().remove(this);
			
			for(Node each: getChildren()){
				each.setParent(this.parent);
			}
			this.parent.getChildren().addAll(index, this.getChildren());
		}
		this.getChildren().clear();		
	}
	
	public Node deleteRootNode(){
		if(parent != null){
			 throw new IllegalStateException("delete root node can be");
		}
		Node newParent = null;
		
		if(!getChildren().isEmpty()){
			newParent = getChildren().get(0);
			newParent.setParent(null);
			getChildren().remove(0);
			for(Node each : getChildren()){
				each.setParent(newParent);
			}
			newParent.getChildren().addAll(getChildren());
		}	
		this.getChildren().clear();
		
		return newParent;
	}
}