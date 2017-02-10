import java.io.*;

public class MaxHeap_11279 {

	public static void main(String[] args) throws IOException {
		// MAX HEAP 11279, �ִ��� �Է°� ��� (��Ÿ�ӿ��� > ����) 
		// ��Ÿ�ӿ���: while�� �� ������ (1, 2)
		int cnt; // �Է¹��� Ƚ��
		int input_node; // �Է¹��� �� (0 Ȥ�� �ڿ���)
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		cnt = Integer.parseInt(in.readLine());
		Max_Heap myHeap = new Max_Heap(cnt);

		for (int i = 0; i < cnt; i++) {
			input_node = Integer.parseInt(in.readLine());
			if (input_node == 0) {
				// �ִ����� �� �� ��� (�ƹ� �͵� ������ 0�� �����)
				myHeap.deleteHeap();	
			}else{
				// �ڿ����� �ԷµǸ�, �ִ��� �迭�� �Ǹ����� �ε����� ����, ��ġ�� ã�� ������ ũ�� ��
				myHeap.insertHeap(input_node);
			}
		}
	}
}

class Max_Heap {
	int index; // �迭�� ������ ���� �ε���
	int size; // ����� ����
	int array_size; // �Է¹��� �� �ִ� �ִ����� ��� ���� (max_heap �迭����ũ��)
	int[] max_heap; // max heap�� ������ �迭����

	public Max_Heap(int cnt) {
		max_heap = new int [cnt]; 
		array_size = cnt;
		index = 0;
		size = 0;
	}

	public void insertHeap(int value) {
		int presentIndex = index;

		if (array_size == size) // �Է¹��� �� �ִ� ũ�� �̻��� ���
			return;
		
		if (index == 0) {
			max_heap[0] = value;
			
		} else {
			max_heap[index] = value;
			// ��Ÿ�ӿ���: while�� �� ������ (1): presentIndex > 0,  ������ �߰�!
			while (presentIndex > 0 && value > max_heap[(presentIndex - 1) / 2]) {
				// max_heap[presentIndex]�� value�� �θ����� max_heap[(presentIndex-1)/2]���� ũ�ٸ� swap()�� ȣ��	
				swapUp(max_heap[presentIndex], presentIndex);
				presentIndex = (presentIndex - 1) / 2;
				
			}
		}
		index++;
		size++;
	}

	public void swapUp(int value, int childIndex) {
		int temp;
		int parentIndex = (childIndex - 1) / 2 ;
		if (value > max_heap[parentIndex]) {
			temp = max_heap[childIndex];
			max_heap[childIndex] = max_heap[parentIndex];
			max_heap[parentIndex] = temp;
		}
	}
	
	public void deleteHeap() {
		int parentIndex = 0;	
		int leftChildIndex = 2 * parentIndex + 1; 
		int rightChildIndex = 2 * parentIndex + 2;
		// �ִ����� �� �� ��� (�ƹ� �͵� ������ 0�� �����)
		if (size == 0) {
			System.out.println(0);
			return;
		}else{
			// System.out.println("�ִ��� ���(root): " + max_heap[0]);
			System.out.println(max_heap[0]);
			size--;
			index--;
			max_heap[0] = max_heap[index];
			max_heap[index] = 0;
			// ��Ÿ�ӿ���: while�� �� ������ (2) : leftChildIndex < size�� �߰� �Ͽ���
			while (leftChildIndex < size) {
				// ���� ���Ե� max_heap[0](��Ʈ)�� �ڽĳ�庸�� ũ�ٸ� �� �ڸ��� �ӹ���.
				if (max_heap[parentIndex] >= max_heap[rightChildIndex] && max_heap[parentIndex] >= max_heap[leftChildIndex]) {
					break;
				}
				parentIndex = swapDown(max_heap[parentIndex], parentIndex);
				
				if(parentIndex == -1) { break; }
				leftChildIndex = 2 * parentIndex + 1;
				rightChildIndex = 2 * parentIndex + 2;
			}
		}
	}

	public int swapDown(int value, int parentIndex) {
		int temp, max = 0;
		int leftChildIndex = 2 * parentIndex + 1;
		int rightChildIndex = 2 * parentIndex + 2;
		// �θ��� ��(value), �����ڽ��� ��(2*i+1), ������ �ڽ��� ��(2*i+2)�� ���� ���ÿ� ��, 
		// �� �� �������  max ���� �����ϴ� �Լ�
		max = findMax(value, max_heap[leftChildIndex], max_heap[rightChildIndex]);

		if (max == max_heap[rightChildIndex]) { // ¦���̸�,  2 * presentIndex +2
			temp = max_heap[rightChildIndex];
			max_heap[rightChildIndex] = max_heap[parentIndex];
			max_heap[parentIndex] = temp;
			
			return rightChildIndex;
			
		} else if (max == max_heap[leftChildIndex]) { // Ȧ���̸�,  2 * presentIndex + 1
			temp = max_heap[leftChildIndex];
			max_heap[leftChildIndex] = max_heap[parentIndex];
			max_heap[parentIndex] = temp;
			
			return leftChildIndex;
		}
		
		return -1;
	}

	int findMax(int parent, int leftChild, int rightChild) {
		int max = 0;

		if (parent < leftChild) {
			max = leftChild;
		} else if (parent < rightChild) {
			max = rightChild;
		}

		if (leftChild < rightChild) {
			max = rightChild;
		} else {
			max = leftChild;
		}
		
		return max;
	}
}