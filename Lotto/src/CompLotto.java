
public class CompLotto{
	
	UserCreate user = new UserCreate();
	ComCreate computer = new ComCreate(); //객체를 생성해서 데이터를 받아온다.
	
	public void comp() { //void로 무조건 실행되게 만든다.
		
		user.use(); //호출해주고
		computer.com();
		int right = 0; //몇 개 맞았는지 카운트 역할
		for (int i = 0; i < 6; i++) { //갯수를 모르니깐 6개
			for (int j = 0; j < 6; j++) { //갯수를 모르니깐 6개, user에서 갖고있는 userNum과 com에서 갖고있는 comNum 비교
				if ( user.userNum[i] == computer.comNum[j]){ //userNum과 comNum이 같다면
					right++;//카운트
					break;	
				}		
			}
		}
		System.out.print("입력숫자 : ");
		for (int i = 0; i < 6; i++) {
			System.out.print(user.userNum[i] + " ");
		}
		System.out.print("컴퓨터 숫자 : ");
		for (int i = 0;i < 6; i++) {
			System.out.print(computer.comNum[i] + " ");		
		}
		System.out.println("결과 : ");
		if (right == 0){
			System.out.println("꽝");
		}
		else if (right == 1){
			System.out.println("백 원");		
		}
		else if (right == 2){
			System.out.println("천 원");		
		}
		else if (right == 3){
			System.out.println("만 원");		
		}
		else if (right == 4){
			System.out.println("일 억 원");		
		}
		else if (right == 5){
			System.out.println("십 억 원");		
		}
		else if (right == 6){
			System.out.println("백 억 원");		
		}
			
		}
		
	}
	
