
public class Lamborghini {

	public static void main(String[] args) {
	
		SportsCar myCar = new SportsCar();
		myCar.carName = "���������"; 
		myCar.speedUp();//Sports Car���� ��ӹ���
		System.out.println(myCar.carName + "�� �ӵ��� " + myCar.velocity +"km");
		
		SuvCar yourCar = new SuvCar("����ι�"); //SuvCar���� name�̶�� �����ڸ� �������
		yourCar.speedUp(); //SuvCar���� ��ӹ���
		yourCar.speedDown();
		System.out.println(yourCar.carName + "�� �ӵ��� " + yourCar.velocity + "km");
		
		miniCar hisCar = new miniCar("�����̵�"); //���� ���ǵ� ����
		hisCar.speedDown();
		System.out.println(hisCar.carName + "�� �ӵ��� " + hisCar.velocity + "km");
		
		miniCar herCar = new miniCar(80); 
		System.out.println(herCar.carName + "�� �ӵ��� " + herCar.velocity + "km"); //ī������ �̴����۷� �޾ƿ�
		
		miniCar itsCar = new miniCar(60, "Ƽ��");
		System.out.println(itsCar.carName + "�� �ӵ��� " + itsCar.velocity + "km");
	}

}
