package car;

public class CarMain {

	public static void main(String[] args){
		
		Car myCar = new Car();
		myCar.speedUp();
		myCar.speedUp();
		myCar.speedDown();
		myCar.carName = "Ƽ��";
		System.out.println(myCar.carName + "�� �ӵ��� " + myCar.velocity + "km");
		
		Car yourCar = new Car();
		yourCar.carName = "���������";
		yourCar.speedUp();
		System.out.println(yourCar.carName + "�� �ӵ��� " + yourCar.velocity + "km");
		
		SuvCar hisCar = new SuvCar("��Ÿ��");
		hisCar.speedUp();
		System.out.println(hisCar.carName + "�� �ӵ��� " + hisCar.velocity + "km");
		
		MiniCar goodCar = new MiniCar("�̴�����");
		MiniCar itsCar = new MiniCar(80);
		MiniCar thisCar = new MiniCar("��Ʋ��", 80);
		System.out.println(goodCar.carName + "�� �ӵ��� " + goodCar.velocity + "km");
		System.out.println(itsCar.carName + "�� �ӵ��� " + itsCar.velocity + "km");
		System.out.println(thisCar.carName + "�� �ӵ��� " +thisCar.velocity + "km");
		
		
	}
	
}