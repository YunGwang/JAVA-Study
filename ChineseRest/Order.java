
public class Order {

	public static void main(String[] args) {
		
		Jjangke jj = new Jjangke();
		jj.makeZazang(); //¯���� �ִ� �޼ҵ带 �ҷ���
		
		SeoulJJangke sj = new SeoulJJangke();//���� ¯���� �ִ� �޼ҵ带 �ҷ���
		sj.makeOldZazang();
		sj.makeZazang();
		sj.makeZzambbong();
		System.out.println("===========================================");
		
		ShinguJJangke sg = new ShinguJJangke();
		sg.makeZazang();
		sg.wonjoZazang();
		System.out.println("===========================================");
		
		SeoulJJangke sg1 = new ShinguJJangke(); //�θ� ���
		sg1.makeZazang();
		System.out.println("===========================================");
	
		
		Jjangke sg2 = new ShinguJJangke(); // �Ҿƹ��� ���
		sg2.makeZazang();
		System.out.println("===========================================");
		//����¥���� �����ϴ� ������ �Ҿƹ������� makeZazang�ۿ� ���⶧����
		
		
	}
}
