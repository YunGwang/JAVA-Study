
public class SuvCar extends SportsCar {
	
	public SuvCar(String name) { //생성자 생성
		carName = name; //이름을 받아 오는 것	
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
	
	//////////////////////////메소드 오버 라이딩을 한 것 (상속 받아서 재정의 한 것)
	
	public void stop() {
		super.stop();
	}
}
// *부모클래스에 생성자가 있다면 반드시 부모크래스의 생성자를 먼저 생성해준다
