import java.util.Scanner;

public class ArrayIncreasing_2846 {
	/* 배열을 안쓰고 현재 읽은 값을 cur, 전에 읽은 값을 prev, 배열 시작 숫자를 min에 저장
	 * cur, prev값비교하여 증가/감소 판단
	 * 감소를 만나면 - max 갱신 여부 확인 및 갱신
	 * 증가를 만나면 -  (마지막 읽은 숫자까지 쭉 증가하는 경우일 때만)max 갱신 여부 확인 및 갱신
	 *  
	 * min > 0 로 증가수열이 시작되었음을 판단 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		int num = inputScanner.nextInt();
		int pointer=1,max = 0, cur; //오르막길이 없는 경우 0
		// count 는 증가 횟수, count+1은 증가하는 수열길이, max는 pointer위치까지 읽었을때  증가하는 수열 길이의 최대값 
		int prev=inputScanner.nextInt();
		int min=-1; // 1<=pi<=1000
		while(pointer<num){
			cur=inputScanner.nextInt();
			if(prev < cur){

				//증가
				if(pointer == (num-1) && min>0 && (cur-min)>max) max = cur-min;//마지막 숫자까지 증가일경우 /
				if(min<0)  min = prev; //prev가 증가수열 시작 
			}else if(min > 0){
				//감소 & 증가하는 수열 끝난 경우 //prev가 증가수열의 마지막이 될것!!  (cur가 아님..)
				if((prev-min)> max) max= prev-min;  // 최대 길이 갱신
				min = -1;
			}

			prev = cur;
			pointer ++; 
		}
		System.out.println(max);
	}

}
