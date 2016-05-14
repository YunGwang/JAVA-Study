package car;

public class CarMain {

	public static void main(String[] args){
		
		Car myCar = new Car();
		myCar.speedUp();
		myCar.speedUp();
		myCar.speedDown();
		myCar.carName = "티코";
		System.out.println(myCar.carName + "의 속도는 " + myCar.velocity + "km");
		
		Car yourCar = new Car();
		yourCar.carName = "람보르기니";
		yourCar.speedUp();
		System.out.println(yourCar.carName + "의 속도는 " + yourCar.velocity + "km");
		
		SuvCar hisCar = new SuvCar("싼타페");
		hisCar.speedUp();
		System.out.println(hisCar.carName + "의 속도는 " + hisCar.velocity + "km");
		
		MiniCar goodCar = new MiniCar("미니쿠퍼");
		MiniCar itsCar = new MiniCar(80);
		MiniCar thisCar = new MiniCar("벤틀리", 80);
		System.out.println(goodCar.carName + "의 속도는 " + goodCar.velocity + "km");
		System.out.println(itsCar.carName + "의 속도는 " + itsCar.velocity + "km");
		System.out.println(thisCar.carName + "의 속도는 " +thisCar.velocity + "km");
		
		
	}
	
}