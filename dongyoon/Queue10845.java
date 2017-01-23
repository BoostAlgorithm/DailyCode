package Queue;

import java.util.Scanner;

public class Queue10845 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCount = sc.nextInt();
		ListQueue queue = new ListQueue();
		String command;
		for (int i = 0; i < testCount; i++) {
			command = sc.next();
			switch (command) {

			case "push":
				int item = sc.nextInt();
				queue.enqueue(item);
				break;
			case "pop":
				System.out.println(queue.dequeue());
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				System.out.println(queue.isEmpty() ? 1 : 0);
				break;
			case "front":
				System.out.println(queue.peek());
				break;
			case "back":
				System.out.println(queue.back());
				break;
			default:
				break;
			}
		}

	}

	static class ListQueue {
		int N;
		Node front;
		Node rear;

		private class Node {
			Object item;
			Node nextNode;
		}

		public boolean isEmpty() {
			return front == null;
		}

		public int size() {
			return N;
		}

		public void enqueue(Object item) {
			Node node = new Node();
			node.item = item;
			node.nextNode = null;
			if (isEmpty()) {
				rear = node;
				front = node;
			} else {
				rear.nextNode = node;
				rear = node;
			}
			N++;

		}

		public Object peek() {
			if (isEmpty()) {
				return -1;
			} else {
				return front.item;
			}
		}

		public Object back() {
			if (isEmpty()) {
				return -1;
			}
			return rear.item;

		}

		public Object dequeue() {
			if (isEmpty()) {
				return -1;
			}
			Object item = front.item;
			front = front.nextNode;
			if (front == null) {
				rear = null;
			}
			N--;
			return item;
		}
	}

}
