import java.io.*;

public class MaxHeap_11279 {

	public static void main(String[] args) throws IOException {
		// MAX HEAP 11279, 최대힙 입력과 출력 (런타임에러 > 성공) 
		// 런타임에러: while문 을 수정함 (1, 2)
		int cnt; // 입력받을 횟수
		int input_node; // 입력받은 값 (0 혹은 자연수)
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		cnt = Integer.parseInt(in.readLine());
		Max_Heap myHeap = new Max_Heap(cnt);

		for (int i = 0; i < cnt; i++) {
			input_node = Integer.parseInt(in.readLine());
			if (input_node == 0) {
				// 최대힙의 값 을 출력 (아무 것도 없으면 0을 출력함)
				myHeap.deleteHeap();	
			}else{
				// 자연수가 입력되면, 최대힙 배열에 맨마지막 인덱스에 삽입, 위치를 찾을 때까지 크기 비교
				myHeap.insertHeap(input_node);
			}
		}
	}
}

class Max_Heap {
	int index; // 배열에 삽입한 힙의 인덱스
	int size; // 노드의 갯수
	int array_size; // 입력받을 수 있는 최대힙의 노드 갯수 (max_heap 배열공간크기)
	int[] max_heap; // max heap을 저장할 배열공간

	public Max_Heap(int cnt) {
		max_heap = new int [cnt]; 
		array_size = cnt;
		index = 0;
		size = 0;
	}

	public void insertHeap(int value) {
		int presentIndex = index;

		if (array_size == size) // 입력받을 수 있는 크기 이상일 경우
			return;
		
		if (index == 0) {
			max_heap[0] = value;
			
		} else {
			max_heap[index] = value;
			// 런타임에러: while문 을 수정함 (1): presentIndex > 0,  조건을 추가!
			while (presentIndex > 0 && value > max_heap[(presentIndex - 1) / 2]) {
				// max_heap[presentIndex]의 value의 부모노드인 max_heap[(presentIndex-1)/2]보다 크다면 swap()을 호출	
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
		// 최대힙의 값 을 출력 (아무 것도 없으면 0을 출력함)
		if (size == 0) {
			System.out.println(0);
			return;
		}else{
			// System.out.println("최대힙 출력(root): " + max_heap[0]);
			System.out.println(max_heap[0]);
			size--;
			index--;
			max_heap[0] = max_heap[index];
			max_heap[index] = 0;
			// 런타임에러: while문 을 수정함 (2) : leftChildIndex < size을 추가 하였음
			while (leftChildIndex < size) {
				// 새로 삽입된 max_heap[0](루트)가 자식노드보다 크다면 그 자리에 머문다.
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
		// 부모의 값(value), 왼쪽자식의 값(2*i+1), 오른쪽 자식의 값(2*i+2)을 셋을 동시에 비교, 
		// 이 셋 노드중의  max 값을 리턴하는 함수
		max = findMax(value, max_heap[leftChildIndex], max_heap[rightChildIndex]);

		if (max == max_heap[rightChildIndex]) { // 짝수이면,  2 * presentIndex +2
			temp = max_heap[rightChildIndex];
			max_heap[rightChildIndex] = max_heap[parentIndex];
			max_heap[parentIndex] = temp;
			
			return rightChildIndex;
			
		} else if (max == max_heap[leftChildIndex]) { // 홀수이면,  2 * presentIndex + 1
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