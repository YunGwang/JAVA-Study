package car;

public class SuvCar {

	int velocity;
	int wheelNum;
	String carName;
	
	public SuvCar(){ //����Ʈ ������
		
		
	}
	
	public SuvCar(String name){
		
		carName = name;
	}
	
	public void speedUp(){
		
		velocity += 7;
		
	}
	
	public void speedDown(){
		
		velocity -= 2;
		if (velocity < 0)
			velocity = 0;
	}
	
	public void stop(){
		
		velocity = 0;
	}
}
