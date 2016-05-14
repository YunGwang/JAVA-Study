package car;

public class Car {

	int velocity;
	int wheelNum;
	String carName;
	
	public void speedUp(){
		
		velocity += 15;
		
	}
	
	public void speedDown(){
		
		velocity -= 5;
		if (velocity < 0)
			velocity = 0;
	}
	
	public void stop(){
		
		velocity = 0;
	}
	
	
}