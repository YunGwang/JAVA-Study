
// ********** �θ�Ŭ������ �����ڰ� �ִٸ� �ݵ�� �θ�Ŭ������ �����ڸ� ���� �������ش� ****************
// ********** super()�� �ݵ�� �޼ҵ� �ȿ��� ���� ���� ���´�. ****************
public class miniCar extends SuvCar {

	public miniCar(String name) { //miniCar�� �����ڰ� 3�� ////�����ڵ� �޼ҵ���///
		super(name);
		carName = name; // ������
	}
	
	public miniCar(int speed) { 
		super(null);
		carName = "�̴�����";
		velocity = speed; //�Ķ���ͷ� ���ǵ带 �޾ƿ�		
	}

	public miniCar (int speed, String name) {
		super(null);
		carName = name;
		velocity = speed;		
	}
	////////////// �޼ҵ� �����ε� (�Ȱ��� �̸��� �޼ҵ带 ������ ����) //�θ� SportsCar�϶� ����� �򰥸��� ����
	
	public void  speedUp() {
		velocity += 5;	
	}
	
	public void  speedDown() {
		velocity -= 1;
		if ( velocity < 0)
			stop();	//��ž ȣ�� ��������� �̴�ī���� ���ǵ� �ٿ��� �θ��� 
	}
	
	public void stop() { //�׷��� �ؿ� �ִ� �갡 ȣ�� ��
		//velocity = 0;
		super.stop(); //SportsCar�� �ִ� stop�� ȣ��
		
	}
	
	
}
