import java.io.*;

public class MaxHeap_11279 {

	public static void main(String[] args) throws IOException {
		// MAX HEAP 11279, �ִ��� �Է°� ��� (��Ÿ�ӿ���)
		int cnt; // �Է¹��� Ƚ��
		int input_node; // �Է¹��� �� (0 Ȥ�� �ڿ���)
		int[] max_heap; // max heap�� ������ �迭����

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		cnt = Integer.parseInt(in.readLine());
		max_heap = new int[cnt];
		Max_Heap myHeap = new Max_Heap(max_heap);

		for (int i = 0; i < cnt; i++) {
			input_node = Integer.parseInt(in.readLine());
//			System.out.println("input_node:" + input_node);
			if (input_node == 0) {
				// �ִ����� �� �� ��� (�ƹ� �͵� ������ 0�� �����)
//				System.out.println("delete maxheap");
				myHeap.deleteHeap();
				continue;
			}
			// �ڿ����� �ԷµǸ�, �ִ��� �迭�� �Ǹ����� �ε����� ����, ��ġ�� ã�� ������ ũ�� ��
			myHeap.insertHeap(input_node);
		}
	}
}

class Max_Heap {
	int size = 0; // �ִ����� ��� ����
	int index = 0; // �迭�� ������ ���� �ε���
	int[] max_heap; // max heap�� ������ �迭����

	Max_Heap(int[] max_heap) {
		this.max_heap = max_heap;
	}

	public int getIndex() {
		return this.index;
	}

	public int getSize() {
		return this.size;
	}

	public void insertHeap(int value) {
		int p_index = index;
		if (index == 0) {
			max_heap[0] = value;
		} else {
			max_heap[index] = value;
			while (p_index > 0) {
//				System.out.println("p_index: " + p_index);	
				//if(p_index <= 0) { break; }
				// value�� �θ��庸�� �۴ٸ� ���ڸ��� �ӹ���
				if (p_index % 2 == 0 && value < max_heap[(p_index - 2) / 2]) {
					break;
				} else if (p_index % 2 != 0 && value < max_heap[(p_index - 1) / 2]) {
					break;
				}
				// value�� �θ��庸�� ũ�ٸ� swap()�� ȣ��
				else {
//					System.out.println(" Before, max_heap[" + p_index + "]: " + max_heap[p_index] );
					swapUp(max_heap[p_index], p_index);
//					System.out.println(" After, max_heap[" + p_index + "]: " + max_heap[p_index] );
					if (p_index % 2 == 0) {
						p_index = (p_index - 2) / 2;
					} else {
						p_index = (p_index - 1) / 2;
					}
				}
			}
		}
		index++;
		size++;
//		System.out.println("- index: " + index);
//		System.out.println("- size: " + size);
	}

	public void swapUp(int value, int p_index) {
		int temp;
		
		if (p_index % 2 == 0 && value > max_heap[(p_index - 2) / 2]) { // ¦���̸�
																		// (n-2)/2
//			System.out.println("- ¦�� index: " + p_index);
//			System.out.println("���� �� �ڽĳ���� �� " + max_heap[p_index]);
//			System.out.println("���� �� �θ����� �� " + max_heap[(p_index - 2) / 2]);

			temp = max_heap[(p_index - 2) / 2];
			max_heap[(p_index - 2) / 2] = max_heap[p_index];
			max_heap[p_index] = temp;

//			System.out.println("���� �� �ڽĳ���� �� " + max_heap[p_index]);
//			System.out.println("���� �� �θ����� �� " + max_heap[(p_index - 2) / 2]);

		} else if (p_index % 2 == 1 && value > max_heap[(p_index - 1) / 2]) { // Ȧ���̸�
																			// (n-1)/2
//			System.out.println("- Ȧ�� index: " + p_index);
//			System.out.println("���� �� �ڽĳ���� �� " + max_heap[p_index]);
//			System.out.println("���� �� �θ����� �� " + max_heap[(p_index - 1) / 2]);

			temp = max_heap[(p_index - 1) / 2];
			max_heap[(p_index - 1) / 2] = max_heap[p_index];
			max_heap[p_index] = temp;

//			System.out.println("���� �� �ڽĳ���� �� " + max_heap[p_index]);
//			System.out.println("���� �� �θ����� �� " + max_heap[(p_index - 1) / 2]);
		}
	}

	public void deleteHeap() {
		int p_index;
		// �ִ����� �� �� ��� (�ƹ� �͵� ������ 0�� �����)
		if (this.size == 0) {
			System.out.println(0);
		} else {
//			System.out.println("�ִ��� ���(root): " + max_heap[0]);
			System.out.println(max_heap[0]);
			size--;
			index--;
			max_heap[0] = max_heap[index];
			max_heap[index] = 0;
			p_index = 0;
			while (max_heap[p_index] > 0) {
				// ���� ���Ե� max_heap[0](��Ʈ)�� �ڽĳ�庸�� ũ�ٸ� �� �ڸ��� �ӹ���.
				if (max_heap[p_index] > max_heap[2 * p_index + 2] && max_heap[p_index] > max_heap[2 * p_index + 1]) {
					break;
				}				
				p_index = swapDown(max_heap[p_index], p_index);
//				System.out.println("p_index: "+ p_index);
//				System.out.println("* swapdown ����, p_index: " + p_index);
			}
		}
 	}

	public int swapDown(int value, int p_index) {
		int temp, max = 0;
		max = findMax(value, max_heap[2 * p_index + 1], max_heap[2 * p_index + 2]);

		if (max == max_heap[2 * p_index + 2]) { // ¦���̸� (n-2)/2
//			 System.out.println("- ¦�� index: " + p_index );
//			 System.out.println("���� �� �θ����� �� " + max_heap[p_index]);
//			 System.out.println("���� �� �ڽĳ���� �� " + max_heap[2*p_index+2] );

			temp = max_heap[2 * p_index + 2];
			max_heap[2 * p_index + 2] = max_heap[p_index];
			max_heap[p_index] = temp;

//			 System.out.println("���� �� �θ����� �� " + max_heap[p_index]);
//			 System.out.println("���� �� �ڽĳ���� �� " + max_heap[2*p_index+2] );
			return (2 * p_index + 2);
		} else if (max == max_heap[2 * p_index + 1]) { // Ȧ���̸� (n-1)/2
//			 System.out.println("- Ȧ�� index: " + p_index);
//			 System.out.println("���� �� �θ����� �� " + max_heap[p_index]);
//			 System.out.println("���� �� �ڳ���� �� " + max_heap[2*p_index+1] );

			temp = max_heap[2 * p_index + 1];
			max_heap[2 * p_index + 1] = max_heap[p_index];
			max_heap[p_index] = temp;

//			 System.out.println("- Ȧ�� index: " + p_index);
//			 System.out.println("���� �� �θ����� �� " + max_heap[p_index]);
//			 System.out.println("���� �� �ڽĳ���� �� " + max_heap[2*p_index+1] );
			return (2 * p_index + 1);
		}
		return -1;
	}

	int findMax(int present, int leftChild, int rightChild) {
		int max = 0;

		if (present < leftChild) {
			max = leftChild;
		} else if (present < rightChild) {
			max = rightChild;
		}

		if (leftChild < rightChild) {
			max = rightChild;
		} else {
			max = leftChild;
		}
//		System.out.println("max�� ���� ? " + max);
		return max;
	}
}