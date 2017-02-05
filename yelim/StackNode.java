
public class StackNode {

	private int data;
	private StackNode preNode; 
	
	public StackNode() {}
	public StackNode(int item, StackNode preNode) {
		this.data = item;
		this.preNode = preNode;
	}
	public int getItem() {
		return data;
	}
	public void setItem(int item) {
		this.data = item;
	}
	public StackNode getPreNode() {
		return preNode;
	}
	public void setPreNode(StackNode preNode) {
		this.preNode = preNode;
	}
}
