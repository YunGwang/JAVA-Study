
public class SuvCar extends SportsCar {
	
	public SuvCar(String name) { //������ ����
		carName = name; //�̸��� �޾� ���� ��	
	}
	
	public void speedUp() { 
		//velocity += 10;
		super.speedUp();
	}
	
	public void speedDown() {
		velocity -= 3;
		if ( velocity < 0)
			velocity =0;	
	}
	
	//////////////////////////�޼ҵ� ���� ���̵��� �� �� (��� �޾Ƽ� ������ �� ��)
	
	public void stop() {
		super.stop();
	}
}
// *�θ�Ŭ������ �����ڰ� �ִٸ� �ݵ�� �θ�ũ������ �����ڸ� ���� �������ش�
