import java.util.Random;

public class ComCreate{
	
	public int comNum[] = new int[6];
	
	public void com() {
	
		for (int i = 0; i < comNum.length; i++) {
			Random rnd  = new Random();
			comNum[i] = (int) (rnd.nextInt(45)+1);//(int)�� ���� ����ȯ
			
		for (int j = 0; j < i; j++) {
			
			if ( comNum[i] == comNum[j]){ //�ߺ��� �߸�
				comNum[i] = (int) (rnd.nextInt(45)+1); //�ٽ� �������ش�
				i--;
				
				}	
			}		
		}
	}	
}