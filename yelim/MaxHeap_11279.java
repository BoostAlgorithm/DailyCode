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
		heap[currentIndex++] = x; // 우선 힙에 값 삽입하고 다음에 들어갈 위치++
	}
	
	public void pop() {
		sort(0, maxSize-1); // 배열의 인덱스 맨 처음, 마지막 인덱스
	/*	for(int x : heap) {
			System.out.print(x);
		}*/
		System.out.println();
		int top=0;
		if(maxSize!=0) {
			top = heap[0];// 무조건 최상단의 것이 최대값
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
	 * 최대 힙 : 부모 노드의 값이 항상 자식 노드의 값보다 큼
	 * */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//	Scanner sc = new Scanner(System.in); // BufferedReader로 변경
		int n = Integer.parseInt(br.readLine()); // 연산 수
		Heap heap = new Heap(n); // n번 모두 push만 했을 수도 있어서
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine()); // 연산에 대한 정보
			if(x==0) {
				heap.pop();
			} else {
				heap.push(x);
			}
		}
	}
}
