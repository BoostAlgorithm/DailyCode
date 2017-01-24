import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Queue_10845 {
	
	public static void main(String[] args) {
		Queue que = new Queue();
		Scanner inputScanner = new Scanner(System.in);
		int lines=Integer.parseInt(inputScanner.nextLine());
		for (int i =0; i<lines; i++){
			String order=inputScanner.nextLine();
			if(order.equals("back")){
				System.out.println(que.back());
			}else if(order.equals("front")){
				System.out.println(que.front());
			}else if(order.equals( "size")){
				System.out.println(que.size());
			}else if(order.equals( "empty")){
				System.out.println(que.empty());
			}else if(order.equals( "pop")){
				System.out.println(que.pop());
			}else if(order.split(" ")[0].equals( "push")){
				que.push(Integer.parseInt(order.split(" ")[1]));
			}
			
		}
	}
}
class Element{
	private int data;
	private Element next;
	public Element(int i){
		data = i;
	}
	public int getData(){
		return data;
	}public Element getNext(){
		return next;
	}public void setNext(Element e){
		next =e ;
	}
}class Queue{
	private Element head;
	//private Element tail;
	private void setHead(Element e){
		head=e;
	}
	private void setTail(Element e){
		Element current=head;
		//원소 없는 경우
//		if(getTail() == null){return; }
		if(head==null) return;
		
		//원소 하나인 경우
//		if(getTail()== head){
		if(current.getNext() == null) {
			head = e;
			return;
		}
		
		//원소 두개 이상인 경우
		while(current.getNext().getNext()!=null){ // current - 테일의 전 원소 **
			current=current.getNext();
		}
		current.setNext(null); //current - new Tail
	}

	private Element getTail(){
		
		Element current=head;
		while(current.getNext()!=null){ // 실수주의 ! current.getNext()== null-> 테일
			current=current.getNext();
		}return current;
	}
	
	public void push(int i){
		Element newOne = new Element(i);
		//원소 없음
		if(empty()==1){
			head = newOne;
			return;
		}
		else  getTail().setNext(newOne);
	}
	public int pop(){
		//원소없음
		if(empty() == 1) return -1;
		//if(getTail()==null) return -1;
		
		/*int data=getTail().getData();
		setTail(null);
		return data;*/
	
		int data= head.getData();
		head = head.getNext();
		return data;
	}
	public int size(){
		int size=0;
		Element current = head;
		while(current!=null){
			size++;
			current=current.getNext();
		}return size;
	}
	public int empty(){
		if(head == null ) return 1;
		else return 0;
	}
	public int front(){
		if(empty() == 1) return -1;
		//if(getTail()==null) return -1;
		return head.getData();
	}
	public int back(){
		//return back.data;
		
		if(empty() == 1) return -1;
		//if(getTail()==null) return -1;
		return getTail().getData();
	}
}
