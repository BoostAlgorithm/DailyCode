import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Editor_1406_v2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner (System.in);
		char[] input=inputScanner.nextLine().toCharArray();
		int lines = inputScanner.nextInt();
		
		Element_E first= new Element_E(' ',null,null); //������ ��� ��� �ֱ�
		first.setPrevious(first);
		
		Element_E current = first; 
		for(int i =0; i<input.length;i++){
			Element_E newOne =new Element_E(input[i],null,current);
			current.setNext(newOne);
			current = current.getNext();
		}
		
		/* ���� ������ ��ġ�� current(Ŀ���� ������) �϶�,
		 * ������ current, �Ŀ� previous�� �̵�
		 * ���� �̵��� previous
		 * ���԰� ������ �̵��� next
		 * 
		 *current.getPrevious() == current //�Ǿ� OR ���ڿ�
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
				if(current.getPrevious() != current) //�� ���ڿ��� �ƴѰ�� //�Ǿ��� �ƴ� ���
					current = current.getPrevious();
				break;
			case "D":
				if(current.getNext()!=null) //�ǳ��� �ƴ� ���
					current = current.getNext();
				
				break;
			case "B":
				if(current.getPrevious() != current){//�Ǿ�/�� ���ڿ��ƴҰ��
					 //current = ���� ��� ���
					
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
		first = first.getNext(); //��� ��� ����
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

