import java.util.*;


public class Queue_10845 {

	public static void main(String[] args) throws Exception {
		/* 큐 구현하기	(Queue implement) */
		Scanner input = new Scanner(System.in);
		Queue<Integer> myQueue = new LinkedList<Integer>();
		int count = input.nextInt();
		String str; 
		int back =0 ;
		
		for (int i = 0; i < count; i++) {
			str = input.next();
			switch (str) {
			case "push":
				int push_x = Integer.parseInt(input.next());
				myQueue.add(push_x); back = push_x;
				break;
			case "pop":
				try{
				if (myQueue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(myQueue.peek());
					myQueue.remove(); 
					back = myQueue.peek();
					if(myQueue.isEmpty()){ back = 0; }
				}
				}catch(Exception e){ e.toString(); }
				break;
			case "size":
				System.out.println(myQueue.size());
				break;
			case "empty":				
				if (myQueue.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "front":
				if (myQueue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(myQueue.peek());
				}
				break;
			case "back":
				if (myQueue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(back);
				}
				break;
			}

		}
	}
}
