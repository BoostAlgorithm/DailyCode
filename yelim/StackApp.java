
public class StackApp {

	public static void main(String[] args) {

		Stack stack = new StackImpl();
		stack.push(1);
		stack.push(2);
		stack.push(4);
		stack.push(3);
		stack.pop();
		stack.pop();
		
		stack.printStack();
		
	}

}
