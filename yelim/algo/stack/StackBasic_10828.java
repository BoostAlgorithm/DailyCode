package algo.stack;

import java.util.Scanner;

public class StackBasic_10828 {
	public static int[] stack;
	public static int top;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 명령의 갯수
		stack = new int[10000]; // 스택
		top=0; // 스택 인덱스(포인터?) 
		for(int i=0; i<n; i++) {
			String order = sc.next();
			if(order.contains("push")) {
				int value = sc.nextInt();
				push(value);
			} else if(order.contains("pop")) {
				pop();
			} else if(order.contains("size")) {
				size();
			} else if(order.contains("empty")) {
				empty();
			} else if(order.contains("top")) { 
				top();
			}
		}
		sc.close();
	}
	
	private static void push(int value) {
		stack[top]=value;
		top++;
	}

	private static void top() {
		if(top==0) System.out.println(-1);
		else System.out.println(stack[top-1]);
	}

	private static void empty() {
		if(top==0) System.out.println(1);
		else System.out.println(0);
	}

	private static void size() {
		System.out.println(top);
	}

	private static void pop() {
		if(top==0) System.out.println(-1);
		else {
			System.out.println(stack[top-1]);
			stack[top-1]=0;
			top--;
		}
	}
}


/*
 *
import java.lang.reflect.Method;
import java.util.Scanner;

public class StackBasic {

	public static int top=-1;
	public static Integer stack[]; 
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int n = sc.nextInt(); // 명령의 수
		stack = new Integer[n]; // 스택
		String orderList[] = {"push", "pop", "size", "empty", "top"};
	
		for(int i=0; i<stack.length; i++) {
			String value = sc2.nextLine();
			for(String order : orderList) {
				if(value.contains(order)) {
					Class<?> c = Class.forName("StackBasic");
					Object o = c.newInstance();
					Method m;
					if(value.contains("push")) {
						Class[] cArg = new Class[1];
						cArg[0] = String.class;
						m = o.getClass().getDeclaredMethod(order, cArg);
						m.invoke(o, value);
					} else {
						m = o.getClass().getDeclaredMethod(order);
						System.out.println(m.invoke(o));
					}
					
					
				}
			}
			
		}
		sc.close();
		sc2.close();
	}
	
	public void push(String order) {
		top++;
		stack[top]=Integer.parseInt(order.trim().substring(5));
	}
	
	public int pop() {
		int num = top(); // 맨 위의 정수
		if(num>0) top--;
		return num;
	}
	
	public int size() {
		return top+1;
	}
	
	public int top() {
		if(top<0) return -1;
		return stack[top];
	}
	
	public int empty() {
		if(top<0) return 1;
		return 0;
	}
	
}
*/
