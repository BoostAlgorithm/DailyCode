import java.util.Scanner;

public class KeyLogger_5397_v2 {
//** 
	public static char[]  move (char[] origin,int from, int to, int n){
		
		if ( n > 0 ){
			//�ڿ�������
			for(int i =to; i>=from; i-- )
				origin[i+n] = origin[i];
		}
		else if(n < 0){
			//�տ�������
			for(int i =from; i<=to; i++ )
				origin[i+n] = origin[i];
		}
		
		return origin;
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner (System.in);
		int lines=inputScanner.nextInt();
		for(int i=0; i<lines; i++){
		//System.out.println(i);
			//char[] out=inputScanner.nextLine().toCharArray();
			char[] out=inputScanner.next().toCharArray();
			//System.out.println(out);
			int indW = -1;//writier poiner
			int tail =-1;
			//�׻� indW<= tail <=indR
			//0 ~ tail ���� ����
			//indW: �Է� ������-���������� �Է��� �ڸ� -�ʱⰪ -1, tail �ʱⰪ -1

			for(int indR=0; indR<out.length;indR++){

				switch (out[indR]){
				
				case '>':
				//	if(out[indW+1] !='>'&& out[indW+1]!= '<' && out[indW+1] !='-'){ //indW ������ �̵�Ű�϶� (���ĺ��� �ƴҶ�) 
				//	if(out[indW+1]!= '>'){
						// == �ϋ�, indW�� ������ ���������� ���̻� �̵��Ұ� do nothing
					if(indW!=tail){
						indW++;
					}

					break;
				case '<':
					if(indW!=-1){
						indW --;
					}
					break;
				case '-':
					if(indW == -1){
						//do nothing
					}
					else if(indW==tail){
						indW --;
						tail--;
					}else{
						//0<indW<tail
						// indW+1 ~ tail�� ��ĭ ������ �ű��
						out=move(out,indW+1,tail,-1);
						//������, tail ��ĭ ������
						indW -- ;
						tail --;
					}
					break;
				default:
					//indW�� ������ ���� ���� ���� ��쿡�� �ڷ� ��ĭ �ű�� ���� ����
					if(indW==tail){
						indW++;
						tail++;
						out[indW] = out[indR];
					}/*else if(indW== -1){
					}*/else if(indW<tail){
						
						//indW+1~tail 
						out =move(out,indW+1,tail,1);
						indW++;
						tail++;
						out[indW]= out[indR];
						
					}
					
					break;
				}
					/*System.out.println("Order "+out[indR]+" ");
					System.out.println("Current > indW "+indW);
					System.out.println("Current > Tail "+tail);
					System.out.println();
					for(char a=0;a<out.length;a++ ){
						System.out.print(out[a]);
					}*/
				
				
			}//System.out.print("\n");
			/*for(char a=0;a<=tail;a++ ){
				System.out.print(out[a]);
			}*/
			StringBuilder str = new StringBuilder(tail+1);
			for(char a=0;a<=tail;a++ ){
				str.append(out[a]);
			}
			System.out.println(str);
			
			
		}
	}

}
