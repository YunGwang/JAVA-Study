import java.util.Random;

public class ComCreate{
	
	public int comNum[] = new int[6];
	
	public void com() {
	
		for (int i = 0; i < comNum.length; i++) {
			Random rnd  = new Random();
			comNum[i] = (int) (rnd.nextInt(45)+1);//(int)로 강제 형변환
			
		for (int j = 0; j < i; j++) {
			
			if ( comNum[i] == comNum[j]){ //중복이 뜨면
				comNum[i] = (int) (rnd.nextInt(45)+1); //다시 생성해준다
				i--;
				
				}	
			}		
		}
	}	
}