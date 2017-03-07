import java.util.Scanner;

public class SequenceSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N, L;
		int start, middle, end;
		N = sc.nextInt();
		L = sc.nextInt();

		boolean isFindResult = false;

		while (L <= 100 && L*(L-1)/2 <= N) {
			// 홀수
			if (L % 2 == 1) {
				if (N % L == 0) {
					middle = N / L;
					start = middle - L / 2;
					end = middle + L / 2;
					for (int i = start; i <= end; i++) {
						System.out.print(i + " ");
					}
					isFindResult = true;
					break;
				}
			} else {
				// 짝수
				if (N % L == L / 2) {
					middle = N / L;
					end = middle + L / 2;
					start = end - L + 1;

					for (int i = start; i <= end; i++) {
						System.out.print(i + " ");
					}
					isFindResult = true;
					break;
				}
			}
			
			L++;
		}
		
		if (!isFindResult) {
			System.out.println(-1);
		}

	}

}
