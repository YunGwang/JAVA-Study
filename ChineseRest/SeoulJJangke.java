
public class SeoulJJangke extends Jjangke{ //원조 짱깨집에서 전수를 받음
	
	public void makeOldZazang(){ //super <--- 부모를 호출하는 메소드
		System.out.println("어서오세요 서울점입니다");
		super.makeZazang();
			
	}

		public void makeZazang(){ //상속받았음
			System.out.println("돼지고기, 양파, 짜장 볶는다.");
			System.out.println("현대식 짜장 만든다.");
					
		}
		
		public void makeZzambbong(){
			System.out.println("짬뽕을 만든다.");
					
		}
 
	
}

//메소드 오버라이딩 : 부모 클래스에 있는 메소드를 자식 클래스에서 재정의 하는 것을 메소드 오버라이딩이라고 한다.//
//메소드 오버로딩   : 같은 클래스내에서 동일한 이름의 메소드가 여러개 만들어지는 것