import java.util.Scanner;

public class MainLotto {

	public static void main(String[] args) {
		
		CompLotto comp = new CompLotto();
		comp.comp();
				
		Scanner scan  = new Scanner(System.in);
		int start;
		do { //����� �ҋ� �����ϸ� do while�� �Ѵ�.
			System.out.println("�ζ� ���α׷� �Դϴ�.");
			System.out.println("���ڸ� ������ �ּ��� 1.����  2.����");
			start = scan.nextInt();
			if (start ==1){ //��ŸƮ�� 1�ϰ�� �� �ؿ� ���� ���
				comp.comp();
				System.out.println("����Ͻðڽ��ϱ�? 1.����ϱ� 2.����");
				int again = scan.nextInt(); // ����ο� ��ĵ�־��ְ�
				if (again == 1){ //1�ϰ�� ���
					continue;
				}else  //�ƴ� ��� ����
				{
					System.out.println("����");
					System.exit(0);
					}
				}	else { //��ŸƮ�� 2�ϰ��
					System.out.println("����");
					System.exit(0);
				}
			
		} while (start == 1 || start == 2);
}
}
