import java.util.*;

public class List_editor_1406 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		int cnt = input.nextInt();
		List<Character> editor =new LinkedList<>();
		int cursor = 0; String command;

		for(int i = 0; i < text.length(); i++){
			editor.add(text.charAt(i));
			//System.out.print(text.charAt(i));
		}
		//System.out.println(" > editor·Î add ¿Ï·á");
		cursor = editor.size()-1;
		
		for(int j = 0; j < cnt; j++){
			command = input.next();
			
			switch(command){
			case "L":
				if(cursor == 0){ continue; }
				cursor--;
				break;
			case "D":
				if(cursor == editor.size()-1){ continue; }
				cursor++;
				break;
			case "B":
				if(cursor == 0){ editor.remove(cursor); continue; }
				else { editor.remove(cursor); cursor --;  }
				break;
			case "P": 
				command = input.next();
				cursor++;
				editor.add(cursor, command.charAt(0));	
			}
		}
		for(int k = 0; k < editor.size(); k++)
			System.out.print(editor.get(k));
	}

}
