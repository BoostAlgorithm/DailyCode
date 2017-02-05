
public class StackImpl implements Stack {
	
	private StackNode top; 
	
	public StackImpl() {
		this.top=null;
	}
	
	@Override
	public void push(int data) {
		StackNode node = new StackNode(data, top);
		top = node;
	}

	@Override
	public int pop() {
		if(isEmpty()) {
			System.out.println("������ ������ϴ�");
			return -1;
		} else {
			StackNode node = top; // ���� ž
			top = node.getPreNode(); // ���� ��带 top����
			return node.getItem();
		}
	}

	@Override
	public int peek() {
		if(isEmpty()) {
			System.out.println("������ ������ϴ�");
			return -1;
		} else {
			return top.getItem();
		}
	}

	@Override
	public boolean isEmpty() {
		return (top==null);
	}
	
	@Override
	public void printStack() {
		if(isEmpty()) {
			System.out.println("������ ��� �ֽ��ϴ�");
		} else {
			StackNode node = top;
			while(node.getPreNode()!=null) {
				System.out.println(node.getItem());
				node = node.getPreNode();
			}
			System.out.println(node.getItem());
		}
	}

}
