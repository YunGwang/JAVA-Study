package car;

public class MiniCar {

	int velocity;
	int wheelNum;
	String carName;
	
	public MiniCar(String name){ //������ ����

		carName = name;
	}
	
	public MiniCar(int speed){ 

			carName = "���";
			velocity = speed;
	}
	
	public MiniCar(String name, int speed){ //ī���Ӱ� ���ǵ带 �޾ƿ´�

		carName = name;
		velocity = speed;
}
	public void speedUp(){
		
		velocity += 5;
		
	}
	
	public void speedDown(){
		
		velocity -= 1;
		if (velocity < 0)
			velocity = 0;
	}
	
	public void stop(){
		
		velocity = 0;
	}		
		
	
	
}
