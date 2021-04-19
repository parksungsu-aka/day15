package day15;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;


public class BankMain {


	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		
		// 고객 전체를 저장할 List 선언 
		List<BankDTO> clientList = new ArrayList<BankDTO>();
		// Bank 클래스 타입 : 고객번호, 이름, 계좌번호, 잔고를 모두 담고 있는 타입 
		
		// BankDTO 클래스 타입의 변수 client
		BankDTO client = null;
		
		
		while (run) {
			System.out.println("------------------------------------------------------------------------");
			System.out.println("1. 고객등록(get,set) | 2.고객등록(생성자) | 3.입금 | 4.출금 | 5.고객리스트 | 6.종료");
			System.out.println("------------------------------------------------------------------------");
			System.out.print("선택> ");
			int select = scan.nextInt();

			switch (select) {
			case 1:
				client = new BankDTO();
				int clientNumber = clientList.size() + 1;
				System.out.print("이름 : ");
				String name = scan.next();
				System.out.print("계좌 : ");
				String accountNumber = scan.next();
				System.out.print("입금액 : ");
				int balance = scan.nextInt();
				// 입력받은 값을 BankDTO 객체 필드값으로 저장 
				client.setClientNumber(clientNumber);
				client.setName(name);
				client.setAccountNumber(accountNumber);
				client.setBalance(balance);
				// 한세트가 다 만들어지면(필드값 세팅이 끝나면) ArrayList에 저장 
				clientList.add(client);
				break;
			case 2:
				// 고객번호를 어떻게 하나씩 올릴지..
				System.out.print("이름 : ");
				name = scan.next();
				System.out.print("계좌 : ");
				accountNumber = scan.next();
				System.out.print("입금액 : ");
				balance = scan.nextInt();
				client = new BankDTO(0, name, accountNumber, balance);
				clientList.add(client);
				break;
			case 3:
				// 입금할 계좌번호와 입금금액을 입력받고 
				// 입력받은 계좌번호와 동일한 계좌번호가 ArrayList에서 어디에 위치해 있는지 찾아야 함. 
				// 계좌번호(String) String이 같은지 비교할 때는 == 쓰지 않고 .equals() 메소드를 사용함. 
				System.out.print("계좌");
				accountNumber = scan.next();
				System.out.print("입금액");
				int deposit = scan.nextInt();
				for(int i=0; i<clientList.size(); i++) {
					if(accountNumber.equals(clientList.get(i).getAccountNumber())) {
						// 같은 계좌를 찾았으면 입금처리 
						// 입금처리 : 기존 잔고에 입금액을 더해서 잔고값을 바꾸는 것 
						balance = clientList.get(i).getBalance() + deposit;
						clientList.get(i).setBalance(balance);
//						clientList.get(i).setBalance(clientList.get(i).getBalance() + deposit);
					} else {
						System.out.println("없는 계좌 입니다.");
					}
				}
				break;
			case 4:
				System.out.print("계좌");
				accountNumber = scan.next();
				System.out.print("출금액");
				int withdraw = scan.nextInt();
				for(int i=0; i<clientList.size(); i++) {
					if(accountNumber.equals(clientList.get(i).getAccountNumber())) {
						if(withdraw <= clientList.get(i).getBalance()) {
							balance = clientList.get(i).getBalance() - withdraw;
							clientList.get(i).setBalance(balance);
						} else {
							System.out.println("잔고가 부족합니다.");
						}
					} else {
						System.out.println("없는 계좌 입니다.");
					}
				}
				break;
			case 5:
				for(int i=0; i<clientList.size(); i++) {
					System.out.println(clientList.get(i));
				}
				break;
			case 6:
				break;
			default:
				System.out.println("메뉴에 없는 번호 입니다.");
				break;
			}
		}

		scan.close();
	}

}


