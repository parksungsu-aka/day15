package day15;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;


public class BankMain {


	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		
		// �� ��ü�� ������ List ���� 
		List<BankDTO> clientList = new ArrayList<BankDTO>();
		// Bank Ŭ���� Ÿ�� : ����ȣ, �̸�, ���¹�ȣ, �ܰ� ��� ��� �ִ� Ÿ�� 
		
		// BankDTO Ŭ���� Ÿ���� ���� client
		BankDTO client = null;
		
		
		while (run) {
			System.out.println("------------------------------------------------------------------------");
			System.out.println("1. �����(get,set) | 2.�����(������) | 3.�Ա� | 4.��� | 5.������Ʈ | 6.����");
			System.out.println("------------------------------------------------------------------------");
			System.out.print("����> ");
			int select = scan.nextInt();

			switch (select) {
			case 1:
				client = new BankDTO();
				int clientNumber = clientList.size() + 1;
				System.out.print("�̸� : ");
				String name = scan.next();
				System.out.print("���� : ");
				String accountNumber = scan.next();
				System.out.print("�Աݾ� : ");
				int balance = scan.nextInt();
				// �Է¹��� ���� BankDTO ��ü �ʵ尪���� ���� 
				client.setClientNumber(clientNumber);
				client.setName(name);
				client.setAccountNumber(accountNumber);
				client.setBalance(balance);
				// �Ѽ�Ʈ�� �� ���������(�ʵ尪 ������ ������) ArrayList�� ���� 
				clientList.add(client);
				break;
			case 2:
				// ����ȣ�� ��� �ϳ��� �ø���..
				System.out.print("�̸� : ");
				name = scan.next();
				System.out.print("���� : ");
				accountNumber = scan.next();
				System.out.print("�Աݾ� : ");
				balance = scan.nextInt();
				client = new BankDTO(0, name, accountNumber, balance);
				clientList.add(client);
				break;
			case 3:
				// �Ա��� ���¹�ȣ�� �Աݱݾ��� �Է¹ް� 
				// �Է¹��� ���¹�ȣ�� ������ ���¹�ȣ�� ArrayList���� ��� ��ġ�� �ִ��� ã�ƾ� ��. 
				// ���¹�ȣ(String) String�� ������ ���� ���� == ���� �ʰ� .equals() �޼ҵ带 �����. 
				System.out.print("����");
				accountNumber = scan.next();
				System.out.print("�Աݾ�");
				int deposit = scan.nextInt();
				for(int i=0; i<clientList.size(); i++) {
					if(accountNumber.equals(clientList.get(i).getAccountNumber())) {
						// ���� ���¸� ã������ �Ա�ó�� 
						// �Ա�ó�� : ���� �ܰ� �Աݾ��� ���ؼ� �ܰ��� �ٲٴ� �� 
						balance = clientList.get(i).getBalance() + deposit;
						clientList.get(i).setBalance(balance);
//						clientList.get(i).setBalance(clientList.get(i).getBalance() + deposit);
					} else {
						System.out.println("���� ���� �Դϴ�.");
					}
				}
				break;
			case 4:
				System.out.print("����");
				accountNumber = scan.next();
				System.out.print("��ݾ�");
				int withdraw = scan.nextInt();
				for(int i=0; i<clientList.size(); i++) {
					if(accountNumber.equals(clientList.get(i).getAccountNumber())) {
						if(withdraw <= clientList.get(i).getBalance()) {
							balance = clientList.get(i).getBalance() - withdraw;
							clientList.get(i).setBalance(balance);
						} else {
							System.out.println("�ܰ� �����մϴ�.");
						}
					} else {
						System.out.println("���� ���� �Դϴ�.");
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
				System.out.println("�޴��� ���� ��ȣ �Դϴ�.");
				break;
			}
		}

		scan.close();
	}

}


