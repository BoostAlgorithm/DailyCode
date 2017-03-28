import java.util.*;

public class Siblings_2 {

	public static void sorted(int[] numbers){
		List <Integer> sortedNumbers = new ArrayList<>();
		
		for(int i = 0; i < numbers.length; i++){
			sortedNumbers.add(numbers[i]);
		}
		Collections.sort(sortedNumbers);
		
		int j = 0;
		for(int i = sortedNumbers.size()-1; i >= 0; i--){
			numbers [j] = sortedNumbers.get(i);
			j++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String siblings = input.nextLine();
		
		if(Integer.parseInt(siblings) == 100000000) { System.out.println(-1); return; }
		
		System.out.println();
		char[] char_siblings = siblings.toCharArray();
		int [] numbers = new int [char_siblings.length];
		for(int i = 0; i <char_siblings.length; i++){
			numbers[i] = char_siblings[i] - 48;
		}
		
		sorted(numbers);
		
		for(int i = 0; i <numbers.length; i++){
			System.out.print(numbers[i]);
		}
		
	}
	

}
