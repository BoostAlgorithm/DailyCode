
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
			System.out.println("스택이 비었습니다");
			return -1;
		} else {
			StackNode node = top; // 현재 탑
			top = node.getPreNode(); // 이전 노드를 top으로
			return node.getItem();
		}
	}

	@Override
	public int peek() {
		if(isEmpty()) {
			System.out.println("스택이 비었습니다");
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
			System.out.println("스택이 비어 있습니다");
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
