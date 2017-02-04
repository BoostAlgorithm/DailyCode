
import java.util.*;

public class List_keyLogger_5397_v2 {
	/** List�� Keylogger ���� Ǯ�� **/
	// List�� ��� : �ð��ʰ� > ��Ÿ�ӿ���
	
	public static void main(String[] args) throws Exception {
		// ���� �ð� ��� �ϴ� �Լ� start
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
		// ���� �ð� ��� �ϴ� �Լ� end
		// long end = System.currentTimeMillis();
		// System.out.println("���� �ð� : " + (end - start) / 1000.0);

	}
}

class keyLogger {

	private int cursor = 0; // list index�� ��ġ
	List<Character> keyList; // LinkedList Collection ���

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