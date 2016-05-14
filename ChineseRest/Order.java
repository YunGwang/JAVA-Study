
public class Order {

	public static void main(String[] args) {
		
		Jjangke jj = new Jjangke();
		jj.makeZazang(); //짱깨에 있던 메소드를 불러옴
		
		SeoulJJangke sj = new SeoulJJangke();//서울 짱깨에 있던 메소드를 불러옴
		sj.makeOldZazang();
		sj.makeZazang();
		sj.makeZzambbong();
		System.out.println("===========================================");
		
		ShinguJJangke sg = new ShinguJJangke();
		sg.makeZazang();
		sg.wonjoZazang();
		System.out.println("===========================================");
		
		SeoulJJangke sg1 = new ShinguJJangke(); //부모 상속
		sg1.makeZazang();
		System.out.println("===========================================");
	
		
		Jjangke sg2 = new ShinguJJangke(); // 할아버지 상속
		sg2.makeZazang();
		System.out.println("===========================================");
		//원조짜장을 사용못하는 이유는 할아버지한테 makeZazang밖에 없기때문에
		
		
	}
}
