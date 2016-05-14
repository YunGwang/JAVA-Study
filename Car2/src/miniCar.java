
// ********** 부모클래스에 생성자가 있다면 반드시 부모클래스의 생성자를 먼저 생성해준다 ****************
// ********** super()는 반드시 메소드 안에서 가장 먼저 나온다. ****************
public class miniCar extends SuvCar {

	public miniCar(String name) { //miniCar는 생성자가 3개 ////생성자도 메소드임///
		super(name);
		carName = name; // 생성자
	}
	
	public miniCar(int speed) { 
		super(null);
		carName = "미니쿠퍼";
		velocity = speed; //파라미터로 스피드를 받아옴		
	}

	public miniCar (int speed, String name) {
		super(null);
		carName = name;
		velocity = speed;		
	}
	////////////// 메소드 오버로딩 (똑같은 이름의 메소드를 여러개 생성) //부모가 SportsCar일때 얘기임 헷갈리기 ㄴㄴ
	
	public void  speedUp() {
		velocity += 5;	
	}
	
	public void  speedDown() {
		velocity -= 1;
		if ( velocity < 0)
			stop();	//스탑 호출 람보르기니 미니카에서 스피드 다운을 부르면 
	}
	
	public void stop() { //그래서 밑에 있는 얘가 호출 됨
		//velocity = 0;
		super.stop(); //SportsCar에 있는 stop을 호출
		
	}
	
	
}
