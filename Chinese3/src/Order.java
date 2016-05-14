
public class Order { //구현한 메뉴를 출력
	public static void main(String[] args) {
		Menu mn = new JJangke();
		mn.makeJJajang();
		mn.makeJJamBbong();
		mn.makeTangSuyook();
	}
}

//기능을 인터페이스로 만들어주고 A나 B를 일반클래스로 불러다가 구현해주면 된다
