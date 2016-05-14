import java.util.Scanner;

public class UserCreate {

	public int userNum[] = new int[6]; //배열 생성
	
	public void use() {
		
		Scanner scan  = new Scanner(System.in);
		System.out.println("로또 번호 6개를 입력해주세요 : ");
		
		for (int i = 0; i < userNum.length; i++) { //배열의 길이만큼 for문을 돌려라	
			userNum[i] = scan.nextInt();
			//if else 문에서 가장 가까운 if와 한 짝이 된다. 이게 댕글링 else		
			{
			if ( userNum[i] <= 0 || userNum[i] > 45){
				System.out.println("번호의 범위를 초과했습니다. (1~45) 입력해주세요");
				i--; //i번째의 한 부분을 건드렸기 때문에 다시 빼주고 컨티뉴문으로 빠져나간다.
				continue; //조건문으로 다시 넘어가기 위해서
				}
			for (int j=0; j < i; j++){
				if(userNum[i] == userNum[j]){ //중복 방지 포문
					System.out.println("중복된 번호입니다. 다시 입력해주세요");
					i--;
							
					}
				}	
			}		
		}	
	}
}
	
