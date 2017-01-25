import java.util.Scanner;

public class KeyLogger_5397_v2 {
//** 
	public static char[]  move (char[] origin,int from, int to, int n){
		
		if ( n > 0 ){
			//뒤에서부터
			for(int i =to; i>=from; i-- )
				origin[i+n] = origin[i];
		}
		else if(n < 0){
			//앞에서부터
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
			//항상 indW<= tail <=indR
			//0 ~ tail 까지 문자
			//indW: 입력 포인터-마지막으로 입력한 자리 -초기값 -1, tail 초기값 -1

			for(int indR=0; indR<out.length;indR++){

				switch (out[indR]){
				
				case '>':
				//	if(out[indW+1] !='>'&& out[indW+1]!= '<' && out[indW+1] !='-'){ //indW 다음이 이동키일때 (알파벳이 아닐때) 
				//	if(out[indW+1]!= '>'){
						// == 일떈, indW이 문자의 마지막으로 더이상 이동불가 do nothing
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
						// indW+1 ~ tail을 한칸 앞으로 옮기기
						out=move(out,indW+1,tail,-1);
						//포인터, tail 한칸 앞으로
						indW -- ;
						tail --;
					}
					break;
				default:
					//indW가 문자의 끝에 있지 않은 경우에만 뒤로 한칸 옮기기 위해 복사
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
