import java.util.Scanner;

public class ArrayIncreasing_2846 {
	/* �迭�� �Ⱦ��� ���� ���� ���� cur, ���� ���� ���� prev, �迭 ���� ���ڸ� min�� ����
	 * cur, prev�����Ͽ� ����/���� �Ǵ�
	 * ���Ҹ� ������ - max ���� ���� Ȯ�� �� ����
	 * ������ ������ -  (������ ���� ���ڱ��� �� �����ϴ� ����� ����)max ���� ���� Ȯ�� �� ����
	 *  
	 * min > 0 �� ���������� ���۵Ǿ����� �Ǵ� 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		int num = inputScanner.nextInt();
		int pointer=1,max = 0, cur; //���������� ���� ��� 0
		// count �� ���� Ƚ��, count+1�� �����ϴ� ��������, max�� pointer��ġ���� �о�����  �����ϴ� ���� ������ �ִ밪 
		int prev=inputScanner.nextInt();
		int min=-1; // 1<=pi<=1000
		while(pointer<num){
			cur=inputScanner.nextInt();
			if(prev < cur){

				//����
				if(pointer == (num-1) && min>0 && (cur-min)>max) max = cur-min;//������ ���ڱ��� �����ϰ�� /
				if(min<0)  min = prev; //prev�� �������� ���� 
			}else if(min > 0){
				//���� & �����ϴ� ���� ���� ��� //prev�� ���������� �������� �ɰ�!!  (cur�� �ƴ�..)
				if((prev-min)> max) max= prev-min;  // �ִ� ���� ����
				min = -1;
			}

			prev = cur;
			pointer ++; 
		}
		System.out.println(max);
	}

}
