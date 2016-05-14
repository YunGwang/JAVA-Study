
public class StarCraft {
	
	public static void main(String[] args) {
		Star[] arr = new Star[3]; //배열의 타입이 부모
			/////Star가 부모클래스인 저그, 테란, 플토를 배열을 설정해서 객체 생성해줌
			arr[0] = new Zerg(); //자식들 객체 생성
			arr[1] = new Terran();
			arr[2] = new Protoss();
			for (int i = 0; i < arr.length; i++) {
				arr[i].Attack();
			}
	}
}


/* Star Zerg = new Zerg ();
Star Terran = new Terran();
Star Protoss = new Protoss ();

위에 있는 게 아래있는거임 그냥 배열로 바꾼것임

Star[] arr = new Star[3]; //배열의 타입이 부모
/////Star가 부모클래스인 저그, 테란, 플토를 배열을 설정해서 객체 생성해줌
arr[0] = new Zerg(); //자식들 객체 생성
arr[1] = new Terran();
arr[2] = new Protoss();
for (int i = 0; i < arr.length; i++) {
	arr[i].Attack();
} */
