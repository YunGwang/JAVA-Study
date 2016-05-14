package car;

public class MiniCar {

	int velocity;
	int wheelNum;
	String carName;
	
	public MiniCar(String name){ //생성자 생성

		carName = name;
	}
	
	public MiniCar(int speed){ 

			carName = "모닝";
			velocity = speed;
	}
	
	public MiniCar(String name, int speed){ //카네임과 스피드를 받아온다

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
