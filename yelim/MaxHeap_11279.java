import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		sort(0, maxSize-1); // �迭�� �ε��� �� ó��, ������ �ε���
	/*	for(int x : heap) {
			System.out.print(x);
		}*/
		System.out.println();
		int top=0;
		if(maxSize!=0) {
			top = heap[0];// ������ �ֻ���� ���� �ִ밪
			heap[0]=0;
			//currentIndex--;
		}
		System.out.println(top);
		
	}
	
	public void sort(int leftIndex, int rightIndex) {
		int left = leftIndex;
		int right = rightIndex;
		int pivot = heap[(leftIndex+rightIndex)/2];

		while(left<=right) {
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
		if(leftIndex < right) sort(leftIndex, right); 
		//if(rightIndex >= left) sort(leftIndex, right);
	}
	
	
}

public class MaxHeap_11279 {
	/*
	 * �ִ� �� : �θ� ����� ���� �׻� �ڽ� ����� ������ ŭ
	 * */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//	Scanner sc = new Scanner(System.in); // BufferedReader�� ����
		int n = Integer.parseInt(br.readLine()); // ���� ��
		Heap heap = new Heap(n); // n�� ��� push�� ���� ���� �־
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine()); // ���꿡 ���� ����
			if(x==0) {
				heap.pop();
			} else {
				heap.push(x);
			}
		}
	}
}
