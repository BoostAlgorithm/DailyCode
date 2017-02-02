import java.util.*;

public class NodeList_KeyLogger5397 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int cnt = input.nextInt();
		String str;
		char word;
		int cursor = 0;
		LinkedList list;

		for (int i = 0; i < cnt; i++) {
			str = input.next();
			cursor = 0;
			list = new LinkedList();

			for (int j = 0; j < str.length(); j++) {
				word = str.charAt(j);
				switch (word) {
				case '-':
					cursor--;
					list.remove(cursor);
					// System.out.println("cursor: "+ cursor + ", remove - " +
					// word);
					break;
				case '<':
					cursor--;
					if (cursor < 0) {
						cursor = 0;
					}
					// System.out.println("cursor: "+ cursor + ", add < " +
					// word);
					break;
				case '>':
					cursor++;
					if (cursor > list.size()) {
						cursor = list.size();
					}
					// System.out.println("cursor: "+ cursor + ", add > " +
					// word);
					break;
				default:
					list.add(cursor, word);
					cursor++;
					// System.out.println("cursor: "+ cursor + ", add default "
					// + word);
					break;
				}
			}

			for (int k = 0; k < list.size(); k++) {
				System.out.print(list.get(k));
			}
			System.out.println("");
			list.removeAll();
		}
	}

	public static class LinkedList {

		private Node head;
		private Node tail;
		private int size = 0;

		private class Node {
			private Object data;
			private Node next;

			public Node(Object input) {
				this.data = input;
				this.next = null;
			}

			public String toString() {
				return String.valueOf(this.data);
			}
		}

		Node node(int index) {
			Node x = head;
			for (int i = 0; i < index; i++)
				x = x.next;
			return x;
		}

		public void addFirst(Object input) {
			Node newNode = new Node(input);
			newNode.next = head;
			head = newNode;
			size++;

			if (head.next == null) {
				tail = head;
			}
		}

		public void addLast(Object input) {
			Node newNode = new Node(input);

			if (size == 0) {
				addFirst(input);
			} else {
				tail.next = newNode;
				tail = newNode;
				size++;
			}
		}

		public void add(int k, Object input) {
			if (k == 0) {
				addFirst(input);
			} else {
				Node temp1 = node(k - 1);
				Node temp2 = temp1.next;
				Node newNode = new Node(input);

				temp1.next = newNode;
				newNode.next = temp2;
				size++;

				if (newNode.next == null) {
					tail = newNode;
				}
			}
		}

		public Object removeFirst() {
			Node temp = head;
			head = temp.next;

			Object returnData = temp.data;
			temp = null;
			size--;

			return returnData;
		}

		public Object remove(int k) {
			if (k == 0) {
				return removeFirst();
			}
			Node temp = node(k - 1);
			Node todoDeleted = temp.next;
			temp.next = temp.next.next;
			Object returnData = todoDeleted.data;

			if (todoDeleted == tail) {
				tail = temp;
			}
			todoDeleted = null;
			size--;

			return returnData;
		}

		public Object removeLast() {
			return remove(size - 1);
		}

		public void removeAll(){
			for(int i = 0; i < this.size; i++){
				removeLast();
			}
		}
		
		public int size() {
			return size;
		}

		public Object get(int k) {
			Node temp = node(k);
			return temp.data;
		}
	}

}
