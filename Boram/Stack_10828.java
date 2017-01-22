import java.util.*;
import java.util.Stack;

public class Stack_10828 {
	
	static void pushStack(Stack st, int number){
		st.push(number);
		//System.out.println("push:"+number);
	}
	
	static void popStack(Stack st){
		try{
		if(st.isEmpty()){ System.out.println("-1"); }
		int in = (int) st.pop();
		//System.out.println("pop:"+in);
		System.out.println(in);
		}catch(EmptyStackException e){
			e.toString();
		}
		
	}
	
	static void sizeStack(Stack st){
		//System.out.println("size:"+st.size());
		System.out.println(st.size());
	}
	
	static void emptyStack(Stack st){
		try{
		if(st.isEmpty()){ System.out.println("1");}
		else { System.out.println("0"); }
		
		}catch(EmptyStackException e){
			e.toString();
		}
	}
	
	static void topStack(Stack st){
		try{
		if(st.isEmpty()){ System.out.println("-1"); }
		System.out.println(st.peek());
		
		}catch(EmptyStackException e){
			e.toString();
		}
	}
	
	public static void main(String args[]){
	
		Stack st = new Stack();
		Scanner input = new Scanner(System.in);
		int count = input.nextInt();
		String str;
		String[] tokens;
		
		for(int i=0; i<=count; i++){			
			str =input.nextLine();
			tokens = str.split(" ");
			if(tokens[0].equals("push")){ pushStack(st, Integer.parseInt(tokens[1]));}
			if(str.equals("pop")){ popStack(st);}
			if(str.equals("empty")){ emptyStack(st);}
			if(str.equals("size")){ sizeStack(st);}
			if(str.equals("top")){ topStack(st);}
		}
	}
}
	
