import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Editor_1406_v2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner (System.in);
		char[] input=inputScanner.nextLine().toCharArray();
		int lines = inputScanner.nextInt();
		
		Element_E first= new Element_E(' ',null,null); //임의의 헤드 노드 넣기
		first.setPrevious(first);
		
		Element_E current = first; 
		for(int i =0; i<input.length;i++){
			Element_E newOne =new Element_E(input[i],null,current);
			current.setNext(newOne);
			current = current.getNext();
		}
		
		/* 현재 포인터 위치가 current(커서의 오른쪽) 일때,
		 * 삭제는 current, 후에 previous로 이동
		 * 왼쪽 이동은 previous
		 * 삽입과 오른쪽 이동은 next
		 * 
		 *current.getPrevious() == current //맨앞 OR 빈문자열
		 * 
		 */
		for(int i=0; i<lines; i++){
			switch (inputScanner.next()){
			case "P":
				
				Element_E newOne =new Element_E(inputScanner.next().charAt(0),null,null);
				
				if(current.getNext()!=null){	
						current.getNext().setPrevious(newOne);
						newOne.setNext(current.getNext());
					}
					current.setNext(newOne);
					newOne.setPrevious(current);
					current = current.getNext();
				break;
			case "L":
				if(current.getPrevious() != current) //빈 문자열이 아닌경우 //맨앞이 아닌 경우
					current = current.getPrevious();
				break;
			case "D":
				if(current.getNext()!=null) //맨끝이 아닌 경우
					current = current.getNext();
				
				break;
			case "B":
				if(current.getPrevious() != current){//맨앞/빈 문자열아닐경우
					 //current = 삭제 대상 노드
					
					if(current.getNext()!=null && current.getPrevious()!=null){
						current.getPrevious().setNext(current.getNext());
						current.getNext().setPrevious(current.getPrevious());
					}
					else if(current.getNext()!=null) current.getNext().setPrevious(null);
					else if(current.getPrevious()!=null) current.getPrevious().setNext(null);
					current = current.getPrevious();
				}
				break;
			}
		}
		first = first.getNext(); //헤드 노드 제외
		while(first!=null){
			System.out.print(first.getData());
			first=first.getNext();
		}
		
	}

}
class Element_E{
	private Element_E next;
	private Element_E previous;
	//private char data;
	private Object data;
	Element_E(){
		
	}
	Element_E(Object data, Element_E next,Element_E preivous){
		this.data = data;
		this.next=next;
		this.previous=preivous;
	}
	public Element_E getNext() {
		return next;
	}
	public void setNext(Element_E next) {
		this.next = next;
	}
	public Element_E getPrevious() {
		return previous;
	}
	public void setPrevious(Element_E previous) {
		this.previous = previous;
	}
	public char getData() {
		return (char)data;
	}
	
}

