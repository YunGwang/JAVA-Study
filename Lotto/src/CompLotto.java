
public class CompLotto{
	
	UserCreate user = new UserCreate();
	ComCreate computer = new ComCreate(); //��ü�� �����ؼ� �����͸� �޾ƿ´�.
	
	public void comp() { //void�� ������ ����ǰ� �����.
		
		user.use(); //ȣ�����ְ�
		computer.com();
		int right = 0; //�� �� �¾Ҵ��� ī��Ʈ ����
		for (int i = 0; i < 6; i++) { //������ �𸣴ϱ� 6��
			for (int j = 0; j < 6; j++) { //������ �𸣴ϱ� 6��, user���� �����ִ� userNum�� com���� �����ִ� comNum ��
				if ( user.userNum[i] == computer.comNum[j]){ //userNum�� comNum�� ���ٸ�
					right++;//ī��Ʈ
					break;	
				}		
			}
		}
		System.out.print("�Է¼��� : ");
		for (int i = 0; i < 6; i++) {
			System.out.print(user.userNum[i] + " ");
		}
		System.out.print("��ǻ�� ���� : ");
		for (int i = 0;i < 6; i++) {
			System.out.print(computer.comNum[i] + " ");		
		}
		System.out.println("��� : ");
		if (right == 0){
			System.out.println("��");
		}
		else if (right == 1){
			System.out.println("�� ��");		
		}
		else if (right == 2){
			System.out.println("õ ��");		
		}
		else if (right == 3){
			System.out.println("�� ��");		
		}
		else if (right == 4){
			System.out.println("�� �� ��");		
		}
		else if (right == 5){
			System.out.println("�� �� ��");		
		}
		else if (right == 6){
			System.out.println("�� �� ��");		
		}
			
		}
		
	}
	
