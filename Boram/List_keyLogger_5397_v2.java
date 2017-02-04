
import java.util.*;

public class List_keyLogger_5397_v2 {
	/** List로 Keylogger 문제 풀기 **/
	// List를 사용 : 시간초과 > 런타임에러
	
	public static void main(String[] args) throws Exception {
		// 수행 시간 계산 하는 함수 start
		// long start = System.currentTimeMillis();
		Scanner input = new Scanner(System.in);
		int cnt = input.nextInt();

		for (int i = 0; i < cnt; i++) {
			String key = input.next();
			keyLogger kg = new keyLogger();
			kg.check(key);
			kg.print();
		}
		// System.out.println("");
		// 수행 시간 계산 하는 함수 end
		// long end = System.currentTimeMillis();
		// System.out.println("실행 시간 : " + (end - start) / 1000.0);

	}
}

class keyLogger {

	private int cursor = 0; // list index의 위치
	List<Character> keyList; // LinkedList Collection 사용

	public keyLogger() {
		keyList = new LinkedList<>();
	}

	public void check(String key) {
		char word;
		cursor = 0 ;
		for (int j = 0; j < (int) key.length(); j++) {
			word = key.charAt(j);
			switch (word) {
			case '-':
				if (cursor == 0) {
					continue;
				}
				remove(keyList, cursor - 1);
				break;

			case '<':
				if (cursor == 0) {
					continue;
				}
				cursor--;
				break;

			case '>':
				if (cursor == keyList.size()) {
					continue;
				}
				cursor++;
				break;
			default:
				add(keyList, cursor, word);
				cursor++;
				break;
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
		System.out.println(sb);
		//keyList.removeAll(keyList);
	}
}