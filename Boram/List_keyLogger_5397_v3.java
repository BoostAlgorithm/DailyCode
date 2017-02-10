import java.io.*;
import java.util.*;

public class List_keyLogger_5397_v3 {
	/** List�� Keylogger ���� Ǯ�� **/
	//List�� ��� : �ð��ʰ� > ��Ÿ�ӿ��� > �ð��ʰ� > Ʋ�Ƚ��ϴ� > �ð��ʰ�
	
	public static void main(String[] args) throws IOException {
		//long start = System.currentTimeMillis();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(input.readLine());
		String text; 
		KeyLogger mykeylogger;
		
		for (int i = 0; i < cnt; i++) {
			text = input.readLine();
			mykeylogger = new KeyLogger();
			mykeylogger.check(text);
			mykeylogger.print();			
		}
		//long end = System.currentTimeMillis();
		//System.out.println( "���� �ð� : " + ( end - start )/1000.0 );
	}
	
	
}

class KeyLogger {

	private int cursor; // list index�� ��ġ
	List<Character> keyList; // LinkedList Collection ���

	public KeyLogger() {
		keyList = new LinkedList<>();
	}

	public void check(String key) {
		char word;
		cursor = 0 ;
		for (int j = 0; j < (int) key.length(); j++) {
			word = key.charAt(j);
			switch (word) {
			case '-':
				if (cursor != 0) {
					cursor --; 
					remove(keyList, cursor);
				}
				break;
			case '<':
				if (cursor != 0) {
					cursor--;
				}
				break;

			case '>':
				if (cursor < keyList.size()) {
					cursor++;
				}
				break;
			default:
				add(keyList, cursor, word);
				cursor++;
			}
		}

	}

	public void remove(List<Character> list, int cursor) {
		if (cursor >= list.size()) {
			cursor = list.size() - 1;
		} else if (cursor <= 0) {
			cursor = 0;
		}
		list.remove(list.get(cursor));
	}

	public void add(List<Character> list, int cursor, char word) {
		if (list.size() < cursor) {
			cursor = list.size();
		} else if (cursor <= 0) {
			cursor = 0;
		}
		list.add(cursor, word);
	}

	public void print() {
		Iterator it = keyList.iterator();
		StringBuilder sb = new StringBuilder();
		while (it.hasNext()) {
			// System.out.print(it.next());
			sb.append(it.next());
		}
		System.out.println(sb.toString());
		//keyList.removeAll(keyList);
	}
}