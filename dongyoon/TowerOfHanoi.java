

//재귀
public class TowerOfHanoi {
	static int count = 0;
	public static void main(String[] args) {
		 int nDisks = 3;
	      doTowers(nDisks, 'A', 'B', 'C');
	}
	
	private static void doTowers(int topN, char from, char inter, char to){
		System.out.println("topN: "+ topN + " from " + from + " inter "+ inter+ " to "+ to);
		count++;
		if (topN == 1) {
			System.out.println("count-: " + count +" Disk 1 from " + from + " to " + to);
		} else {
			doTowers(topN-1, from, to, inter);
			 System.out.println("count--: " + count +" Disk "
			         + topN + " from " + from + " to " + to);
			 doTowers(topN-1, inter, from, to);
		}
	}

}
