
public class StarCraft {
	
	public static void main(String[] args) {
		Star[] arr = new Star[3]; //�迭�� Ÿ���� �θ�
			/////Star�� �θ�Ŭ������ ����, �׶�, ���並 �迭�� �����ؼ� ��ü ��������
			arr[0] = new Zerg(); //�ڽĵ� ��ü ����
			arr[1] = new Terran();
			arr[2] = new Protoss();
			for (int i = 0; i < arr.length; i++) {
				arr[i].Attack();
			}
	}
}


/* Star Zerg = new Zerg ();
Star Terran = new Terran();
Star Protoss = new Protoss ();

���� �ִ� �� �Ʒ��ִ°��� �׳� �迭�� �ٲ۰���

Star[] arr = new Star[3]; //�迭�� Ÿ���� �θ�
/////Star�� �θ�Ŭ������ ����, �׶�, ���並 �迭�� �����ؼ� ��ü ��������
arr[0] = new Zerg(); //�ڽĵ� ��ü ����
arr[1] = new Terran();
arr[2] = new Protoss();
for (int i = 0; i < arr.length; i++) {
	arr[i].Attack();
} */
