
import java.util.*;

public class List_keylogger5397 {

	public static void main(String[] args) {
		/** List로 Keylogger 문제 풀기 **/
		// List를 사용했으나, 시간초과 : for 문이 많기 때문으로 예상됨.
		int cursor; // list index의 위치
		List<Character> keyList = new LinkedList<>();
		Scanner input = new Scanner(System.in);
		int cnt = input.nextInt();
		String key;
		char word;

		for (int i = 0; i < cnt; i++) {
			key = input.next();
			cursor = 0;
			for (int j = 0; j < key.length(); j++) {
				word = key.charAt(j);
				switch (word) {
				case '-':
					if (cursor == 0) {
						continue;
					} else if (keyList.size() <= cursor + 1) {
						cursor = keyList.size() - 1;
					}
					keyList.remove(keyList.get(cursor));
					//System.out.println("cursor: " + cursor + ", - remove ");
					break;
				case '<':
					if (cursor == 0) {
						continue;
					}
					cursor--;
					//System.out.println("cursor: " + cursor + ", < word :" + word);
					break;
				case '>':
					if (cursor == 0) {
						continue;
					}
					cursor++;
					//System.out.println("cursor: " + cursor + ", > word :" + word);
					break;
				default:
					if (keyList.size() < cursor) {
						cursor = keyList.size();
					} else if (cursor < 0) {
						cursor = 0;
					}
					keyList.add(cursor, word);
					//System.out.println("cursor: " + cursor + ", add :" + word);
					cursor++;
					break;
				}
			}
			for (int k = 0; k < keyList.size(); k++) {
				System.out.print(keyList.get(k));
			}
			System.out.println("");
			keyList.removeAll(keyList);

		}

	}
}
