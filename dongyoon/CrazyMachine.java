import java.util.Scanner;

public class CrazyMachine {
	public enum Direction {
		left, right, up, down;
	}

	static double sum = 0.0;
	static double rightPossibility;
	static double leftPossibility;
	static double downPossibility;
	static double upPossibility;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		rightPossibility = sc.nextInt() * 0.01;
		leftPossibility = sc.nextInt() * 0.01;
		downPossibility = sc.nextInt() * 0.01;
		upPossibility = sc.nextInt() * 0.01;

		System.out.println(D(0, 0, 2));
	}

	private static double D(int X, int Y, int K) {
		if (K == 1) { // 탈출 조건
			return 1.0;
		}

		return D(X + 1, Y, K - 1) * getPossibility(Direction.right)
				+ D(X - 1, Y, K - 1) * getPossibility(Direction.left)
				+ D(X, Y + 1, K - 1) * getPossibility(Direction.up)
				+ D(X, Y - 1, K - 1) * getPossibility(Direction.down);
	}

	private static double getPossibility(Direction direction) {
		double possibility = 0.0;

		switch (direction) {
		case left:
			possibility = leftPossibility;
			break;
		case right:
			possibility = rightPossibility;
			break;
		case up:
			possibility = upPossibility;
			break;
		case down:
			possibility = downPossibility;
			break;
		default:
			break;
		}
		return possibility;
	}

}
