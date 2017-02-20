import java.io.BufferedReader;
import java.io.InputStreamReader;

class QueueNode {
	private int value;
	private QueueNode nextNode;
	
	public QueueNode() {}
	public QueueNode(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public QueueNode getNextNode() {
		return nextNode;
	}
	public void setNextNode(QueueNode nextNode) {
		this.nextNode = nextNode;
	}
}

class Queue {
	private QueueNode head;
	
	void push(int value) {
		QueueNode node = new QueueNode(value);
		if(empty()==1) head = node;
		else getTail().setNextNode(node);
	}
	
	QueueNode getTail() {
		QueueNode node = head;
		while(node.getNextNode()!=null) {
			node = node.getNextNode();
		}
		return node;
	}
	
	int pop() {
		if(empty()==1) return -1;
		QueueNode preHead = head;
		head = preHead.getNextNode();
		return preHead.getValue();
	}
	
	int size() {
		QueueNode node = head;
		int count=0;
		
		while(node!=null) {
			count++;
			node = node.getNextNode();
		}
		return count;
		
	}
	
	int empty() {
		if(head==null) return 1;
		return 0;
	}
	
	int front() {
		if(empty()==1) return -1;
		return head.getValue();
	}
	
	int back() {
		if(empty()==1) return -1;
		return getTail().getValue();
	}
	
}
public class Queue_10845 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		String order;
		Queue que = new Queue();
		int value=0;
		
		for(int i=0; i<num; i++) {
			order = br.readLine();
			if(order.contains(" ")) {
				value = Integer.parseInt(order.split(" ")[1]);
				order = order.split(" ")[0];
			}
			switch (order) {
				case "push":
					que.push(value);
					break;
				case "pop":
					System.out.println(que.pop());
					break;
				case "size":
					System.out.println(que.size());
					break;
				case "empty":
					System.out.println(que.empty());		
					break;
				case "front":
					System.out.println(que.front());			
					break;
				case "back":
					System.out.println(que.back());				
					break;
				}
		}
	}

}
