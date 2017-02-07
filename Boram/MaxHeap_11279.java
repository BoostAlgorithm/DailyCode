import java.io.*;

public class MaxHeap_11279 {

	public static void main(String[] args) throws IOException {
		// MAX HEAP 11279, 최대힙 입력과 출력 (런타임에러)
		int cnt; // 입력받을 횟수
		int input_node; // 입력받은 값 (0 혹은 자연수)
		int[] max_heap; // max heap을 저장할 배열공간

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		cnt = Integer.parseInt(in.readLine());
		max_heap = new int[cnt];
		Max_Heap myHeap = new Max_Heap(max_heap);

		for (int i = 0; i < cnt; i++) {
			input_node = Integer.parseInt(in.readLine());
//			System.out.println("input_node:" + input_node);
			if (input_node == 0) {
				// 최대힙의 값 을 출력 (아무 것도 없으면 0을 출력함)
//				System.out.println("delete maxheap");
				myHeap.deleteHeap();
				continue;
			}
			// 자연수가 입력되면, 최대힙 배열에 맨마지막 인덱스에 삽입, 위치를 찾을 때까지 크기 비교
			myHeap.insertHeap(input_node);
		}
	}
}

class Max_Heap {
	int size = 0; // 최대힙의 노드 갯수
	int index = 0; // 배열에 삽입한 힙의 인덱스
	int[] max_heap; // max heap을 저장할 배열공간

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
				// value가 부모노드보다 작다면 그자리에 머문다
				if (p_index % 2 == 0 && value < max_heap[(p_index - 2) / 2]) {
					break;
				} else if (p_index % 2 != 0 && value < max_heap[(p_index - 1) / 2]) {
					break;
				}
				// value가 부모노드보다 크다면 swap()을 호출
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
		
		if (p_index % 2 == 0 && value > max_heap[(p_index - 2) / 2]) { // 짝수이면
																		// (n-2)/2
//			System.out.println("- 짝수 index: " + p_index);
//			System.out.println("스왑 전 자식노드의 값 " + max_heap[p_index]);
//			System.out.println("스왑 전 부모노드의 값 " + max_heap[(p_index - 2) / 2]);

			temp = max_heap[(p_index - 2) / 2];
			max_heap[(p_index - 2) / 2] = max_heap[p_index];
			max_heap[p_index] = temp;

//			System.out.println("스왑 후 자식노드의 값 " + max_heap[p_index]);
//			System.out.println("스왑 후 부모노드의 값 " + max_heap[(p_index - 2) / 2]);

		} else if (p_index % 2 == 1 && value > max_heap[(p_index - 1) / 2]) { // 홀수이면
																			// (n-1)/2
//			System.out.println("- 홀수 index: " + p_index);
//			System.out.println("스왑 전 자식노드의 값 " + max_heap[p_index]);
//			System.out.println("스왑 전 부모노드의 값 " + max_heap[(p_index - 1) / 2]);

			temp = max_heap[(p_index - 1) / 2];
			max_heap[(p_index - 1) / 2] = max_heap[p_index];
			max_heap[p_index] = temp;

//			System.out.println("스왑 후 자식노드의 값 " + max_heap[p_index]);
//			System.out.println("스왑 후 부모노드의 값 " + max_heap[(p_index - 1) / 2]);
		}
	}

	public void deleteHeap() {
		int p_index;
		// 최대힙의 값 을 출력 (아무 것도 없으면 0을 출력함)
		if (this.size == 0) {
			System.out.println(0);
		} else {
//			System.out.println("최대힙 출력(root): " + max_heap[0]);
			System.out.println(max_heap[0]);
			size--;
			index--;
			max_heap[0] = max_heap[index];
			max_heap[index] = 0;
			p_index = 0;
			while (max_heap[p_index] > 0) {
				// 새로 삽입된 max_heap[0](루트)가 자식노드보다 크다면 그 자리에 머문다.
				if (max_heap[p_index] > max_heap[2 * p_index + 2] && max_heap[p_index] > max_heap[2 * p_index + 1]) {
					break;
				}				
				p_index = swapDown(max_heap[p_index], p_index);
//				System.out.println("p_index: "+ p_index);
//				System.out.println("* swapdown 성공, p_index: " + p_index);
			}
		}
 	}

	public int swapDown(int value, int p_index) {
		int temp, max = 0;
		max = findMax(value, max_heap[2 * p_index + 1], max_heap[2 * p_index + 2]);

		if (max == max_heap[2 * p_index + 2]) { // 짝수이면 (n-2)/2
//			 System.out.println("- 짝수 index: " + p_index );
//			 System.out.println("스왑 전 부모노드의 값 " + max_heap[p_index]);
//			 System.out.println("스왑 전 자식노드의 값 " + max_heap[2*p_index+2] );

			temp = max_heap[2 * p_index + 2];
			max_heap[2 * p_index + 2] = max_heap[p_index];
			max_heap[p_index] = temp;

//			 System.out.println("스왑 전 부모노드의 값 " + max_heap[p_index]);
//			 System.out.println("스왑 전 자식노드의 값 " + max_heap[2*p_index+2] );
			return (2 * p_index + 2);
		} else if (max == max_heap[2 * p_index + 1]) { // 홀수이면 (n-1)/2
//			 System.out.println("- 홀수 index: " + p_index);
//			 System.out.println("스왑 전 부모노드의 값 " + max_heap[p_index]);
//			 System.out.println("스왑 전 자노드의 값 " + max_heap[2*p_index+1] );

			temp = max_heap[2 * p_index + 1];
			max_heap[2 * p_index + 1] = max_heap[p_index];
			max_heap[p_index] = temp;

//			 System.out.println("- 홀수 index: " + p_index);
//			 System.out.println("스왑 전 부모노드의 값 " + max_heap[p_index]);
//			 System.out.println("스왑 전 자식노드의 값 " + max_heap[2*p_index+1] );
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
//		System.out.println("max의 값은 ? " + max);
		return max;
	}
}