import java.util.*;

public class Queue_10845 {

	public static void main(String[] args) throws Exception {
		/* 큐 구현하기 (Queue implement) */
		/* 제출 성공, 시간  메모리 줄이는 방향으로 수정하기 */
		Scanner input = new Scanner(System.in);
		// Queue <Integer> myQueue = new LinkedList<Integer>();
		// offer(e), poll(), peek() : Queue 인터페이스 함수 , false (add의 경우) or null 반환
		// add(e), remove(), element() : Collections 인터페이스 함수 , Exception 발생
		List <Integer> myQueue = new LinkedList<Integer>();
		// back의 원소를 확인하기 위해서 List 인터페이스를 사용함. list.get(index);
		int count = input.nextInt();
		String str;

		for (int i = 0; i < count; i++) {
			str = input.next();
			switch (str) {
			case "push":
				int push_x = Integer.parseInt(input.next());
				myQueue.add(push_x);
				break;
			case "pop":
				try {
					if (myQueue.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(myQueue.get(0));
						myQueue.remove(0);
					}
				} catch (Exception e) {
					e.toString();
				}
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
					System.out.println(myQueue.get(0));
				}
				break;
			case "back":
				if (myQueue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(myQueue.get(myQueue.size()-1));
				}
				break;
			}

		}
	}
	// 시간 복잡도  O(n), 공간복잡도  S(n)
}
