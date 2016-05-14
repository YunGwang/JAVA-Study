
public class SportsCar {
	int velocity;
	int wheelNum;
	String carName;
	
	public void speedUp(){
		velocity = velocity + 20;
	}
	
	public void speedDown(){
		velocity -= 5;
		if (velocity < 0)
			//velocity = 0;
		stop();
	}
	
	public void stop(){
		velocity = 0;
	}
}
