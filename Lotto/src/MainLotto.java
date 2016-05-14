import java.util.Scanner;

public class MainLotto {

	public static void main(String[] args) {
		
		CompLotto comp = new CompLotto();
		comp.comp();
				
		Scanner scan  = new Scanner(System.in);
		int start;
		do { //재시작 할떈 웬만하면 do while로 한다.
			System.out.println("로또 프로그램 입니다.");
			System.out.println("숫자를 선택해 주세요 1.시작  2.종료");
			start = scan.nextInt();
			if (start ==1){ //스타트가 1일경우 저 밑에 문장 출력
				comp.comp();
				System.out.println("계속하시겠습니까? 1.계속하기 2.종료");
				int again = scan.nextInt(); // 어게인에 스캔넣어주고
				if (again == 1){ //1일경우 계속
					continue;
				}else  //아닐 경우 종료
				{
					System.out.println("종료");
					System.exit(0);
					}
				}	else { //스타트가 2일경우
					System.out.println("종료");
					System.exit(0);
				}
			
		} while (start == 1 || start == 2);
}
}
