
public class Lamborghini {

	public static void main(String[] args) {
	
		SportsCar myCar = new SportsCar();
		myCar.carName = "람보르기니"; 
		myCar.speedUp();//Sports Car에서 상속받음
		System.out.println(myCar.carName + "의 속도는 " + myCar.velocity +"km");
		
		SuvCar yourCar = new SuvCar("랜드로버"); //SuvCar에서 name이라는 생성자를 만들었음
		yourCar.speedUp(); //SuvCar에서 상속받음
		yourCar.speedDown();
		System.out.println(yourCar.carName + "의 속도는 " + yourCar.velocity + "km");
		
		miniCar hisCar = new miniCar("프라이드"); //네임 스피드 가능
		hisCar.speedDown();
		System.out.println(hisCar.carName + "의 속도는 " + hisCar.velocity + "km");
		
		miniCar herCar = new miniCar(80); 
		System.out.println(herCar.carName + "의 속도는 " + herCar.velocity + "km"); //카네임은 미니쿠퍼로 받아옴
		
		miniCar itsCar = new miniCar(60, "티코");
		System.out.println(itsCar.carName + "의 속도는 " + itsCar.velocity + "km");
	}

}
