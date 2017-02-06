import java.util.Scanner;

public class Heap_11279 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		AscendHeap mHeap = new AscendHeap(size);

		for (int i = 0; i < size; i++) {
			int inputNum = sc.nextInt();
			if (inputNum == 0) {
				mHeap.delete();
			}

			mHeap.insert(inputNum);
		}
	}
}

class AscendHeap {
	int size;
	int usedSize;
	int[] heapArray;

	public AscendHeap(int size) {
		this.size = size;
		usedSize = 0;
		heapArray = new int[this.size];
	}

	public void insert(int data) {
		int currentIndex = usedSize;
		int parentIndex = getParentIndex(currentIndex);

		// 용량초과 리턴
		if (usedSize == size)
			return;

		// 삽입
		heapArray[currentIndex] = data;

		while (currentIndex > 0 && heapArray[currentIndex] > heapArray[parentIndex]) {
			swap(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = getParentIndex(currentIndex);
		}

		usedSize++;

	}

	public void delete() {
		if (usedSize == 0) {
			System.out.println("0");
			return;
		}

		usedSize--;
		int currentIndex = 0;
		int leftChildIndex = getLeftChildIndex(currentIndex);
		int rightChildIndex = getRightChildIndex(currentIndex);
		// 삭제
		System.out.println(heapArray[currentIndex]);
		heapArray[currentIndex] = 0;
		swap(currentIndex, usedSize);

		while (true) {
			int selectChildIndex = 0;
			if (leftChildIndex >= usedSize)
				break;

			if (rightChildIndex > usedSize) {
				selectChildIndex = leftChildIndex;
			} else {
				// 양쪽 다 자식노드가 있기 때문에 더 큰쪽을 선택한다.
				if (heapArray[leftChildIndex] > heapArray[rightChildIndex]) {

					selectChildIndex = leftChildIndex;
				} else {

					selectChildIndex = rightChildIndex;
				}
			}

			if (heapArray[selectChildIndex] > heapArray[currentIndex]) {
				swap(selectChildIndex, currentIndex);
				currentIndex = selectChildIndex;
			} else {
				break;
			}

			leftChildIndex = getLeftChildIndex(currentIndex);
			rightChildIndex = getRightChildIndex(currentIndex);
		}

	}

	public void swap(int currentIndex, int parentIndex) {
		int temp = heapArray[currentIndex];
		heapArray[currentIndex] = heapArray[parentIndex];
		heapArray[parentIndex] = temp;
	}

	public int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
		// k번째 인덱스의 위치에서 부모노드 (k-1) / 2
	}

	public int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
		// 왼쪽 자식 노드
	}

	public int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
		// 오른쪽 자식 노드
	}
}
