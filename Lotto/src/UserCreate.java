import java.util.Scanner;

public class UserCreate {

	public int userNum[] = new int[6]; //�迭 ����
	
	public void use() {
		
		Scanner scan  = new Scanner(System.in);
		System.out.println("�ζ� ��ȣ 6���� �Է����ּ��� : ");
		
		for (int i = 0; i < userNum.length; i++) { //�迭�� ���̸�ŭ for���� ������	
			userNum[i] = scan.nextInt();
			//if else ������ ���� ����� if�� �� ¦�� �ȴ�. �̰� ��۸� else		
			{
			if ( userNum[i] <= 0 || userNum[i] > 45){
				System.out.println("��ȣ�� ������ �ʰ��߽��ϴ�. (1~45) �Է����ּ���");
				i--; //i��°�� �� �κ��� �ǵ�ȱ� ������ �ٽ� ���ְ� ��Ƽ�������� ����������.
				continue; //���ǹ����� �ٽ� �Ѿ�� ���ؼ�
				}
			for (int j=0; j < i; j++){
				if(userNum[i] == userNum[j]){ //�ߺ� ���� ����
					System.out.println("�ߺ��� ��ȣ�Դϴ�. �ٽ� �Է����ּ���");
					i--;
							
					}
				}	
			}		
		}	
	}
}
	
