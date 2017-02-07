import java.util.Scanner;
class Heap {
	int currentIndex;
	int maxSize;
	int [] heap;
	
	public Heap() {}
	public Heap(int maxSize) {
		this.currentIndex = 0;
		this.maxSize = maxSize;
		this.heap = new int[maxSize];
	} 
	
	public void push(int x) {
		heap[currentIndex++] = x; // �켱 ���� �� �����ϰ� ������ �� ��ġ++
	}
	
	public void pop() {
		sort(0, currentIndex); // �迭�� �ε��� �� ó��, ������ �ε���
		int top=0;
		if(currentIndex!=0) {
			top = heap[0];// ������ �ֻ���� ���� �ִ밪
			heap[0]=0;
			currentIndex--;
		}
		System.out.println(top);
	}
	
	public void sort(int leftIndex, int rightIndex) {
		int left = leftIndex;
		int right = rightIndex;
		int pivot = heap[(leftIndex+rightIndex)/2];

		while(left<right) {
			while(pivot<heap[left]) left++;
			while(pivot>heap[right]) right--;
			if(left<=right) {
				int tmp = heap[left];
				heap[left]=heap[right];
				heap[right]=tmp;
				left++;
				right--;
			}
		} 
		
		if(rightIndex > left) sort(left, rightIndex);
	}
	
	
}

public class MaxHeap_11279 {
	/*
	 * �ִ� �� : �θ� ����� ���� �׻� �ڽ� ����� ������ ŭ
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ���� ��
		Heap heap = new Heap(n); // n�� ��� push�� ���� ���� �־
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt(); // ���꿡 ���� ����
			if(x==0) {
				heap.pop();
			} else {
				heap.push(x);
			}
		}
	}
}
