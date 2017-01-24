
import java.util.Scanner;

public class StackSequence {
	static class DoubleLinked{
		DoubleLinked previous;
		DoubleLinked next;
		int data;
		public DoubleLinked(int data){
			this.data = data;
		}
		public DoubleLinked(){
			
		}
	}
	//
	//수열이 주어졌을 때 수열을 만들 수 있는지 없는지 (오름차순 수열 주어짐)
	//push 와 pop 연산 순서
	
	public static void main(String[] arg){
		// input
		
		Scanner inputStream = new Scanner(System.in);
		//int lines= inputStream.nextInt();
		int lines=Integer.parseInt(inputStream.nextLine());
		DoubleLinked list = new DoubleLinked(1);
		
		DoubleLinked current =list;
		for(int i =2; i<=lines; i++){
			DoubleLinked newOne=new DoubleLinked(i);
			newOne.previous= current; 
			current.next=newOne;
			current = current.next;
		}
		current.next = list;
		list.previous= current;
		
		/*
		 * Test 
		 * while(list.next!=null){
			System.out.println(list.data);
			list= list.next;
		}
		while(list.previous!=null){
			System.out.println(list.data);
			list=list.previous;
		}*/
		// initialize pointer
		DoubleLinked pointer= list;
		
		int nextNum=0, prevNum=0;
		for(int i = 0 ; i<lines ; i++){ //pointer - 마지막으로 pop한 후의 previous 
			prevNum = nextNum;
			//nextNum= inputStream.nextInt();
			nextNum= Integer.parseInt(inputStream.nextLine());
			//System.out.println("Prev "+prevNum +" Next "+nextNum);
			if(prevNum<nextNum){
				while(pointer.data != nextNum ){
				//	System.out.println("Push "+pointer.data);
					pointer = pointer.next;
					
					System.out.println("+"); //push until smaller pointer reaches bigger pointer
					
				}
				//System.out.println("Pop "+pointer.data);
				System.out.println("-");
				DoubleLinked temp = pointer.previous;
				pointer.previous.next = pointer.next;
				pointer.next.previous=pointer.previous;
				pointer= temp;
			}
			else if(prevNum>nextNum){//set smaller pointer
				while(pointer.data!=nextNum){
					//System.out.println("Pop "+pointer.data);
					pointer = pointer.previous;
					System.out.println("-"); //pop
				}
				//System.out.println("Pop "+pointer.data);
				DoubleLinked temp = pointer.previous;
				pointer.previous.next = pointer.next;
				pointer.next.previous=pointer.previous;
				pointer = temp;
			}
			
			
			
		}
		
	}

}

