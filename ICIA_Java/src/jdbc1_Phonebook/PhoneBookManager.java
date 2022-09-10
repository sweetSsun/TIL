package jdbc1_Phonebook;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookManager {

	Scanner scan = new Scanner(System.in);
	
	private PhoneBookDao pbdao = new PhoneBookDao();
	
	public void showMenu() {
		System.out.println("\n=====================================");
		System.out.println("1.입력 | 2.출력 | 3.삭제 | 4.수정 | 0.종료");
		System.out.println("=====================================");
		System.out.print("메뉴선택 >> ");
	}
	
	public void insertPhoneBook() {
		System.out.println("[1.입력]");
		
		PhoneBook pb = new PhoneBook();
		
		System.out.print("이름 입력 >> ");
		String name = scan.next();
		System.out.print("번호 입력 >> ");
		String tel = scan.next();
		
		pb.setPb_name(name);
		pb.setPb_tel(tel);
		
		// pb객체를 PHONEBOOK_TBL에 Insert 수행
		int insertResult = pbdao.insertPhoneBook(pb);
		
		System.out.println("insertResult : " + insertResult);
		System.out.println("새 연락처가 등록되었습니다.");
	}

	public void selectPhoneBook() {
		System.out.println("[2.출력]");
		
		ArrayList<PhoneBook> pbList = pbdao.selectPhoneBook();
		
		for(int i = 0; i < pbList.size(); i++) {
			System.out.print("이름 : " + pbList.get(i).getPb_name());
			System.out.println(", 전화번호 : " + pbList.get(i).getPb_tel());
		}
	}

	public void deletePhoneBook() {
		System.out.println("[3.삭제]");
		
		System.out.print("삭제할 이름 >> ");
		String delName = scan.next();
		
		int deleteResult = pbdao.deletePhoneBook(delName);
		if (deleteResult > 0) {
			System.out.println(deleteResult + "개의 연락처가 삭제되었습니다.");
		} else {
			System.out.println("이름을 찾을 수 없습니다.");
		}
		
	}

	public void updatePhoneBook() {
		System.out.println("[4.수정]");
		System.out.print("검색할 이름 >> ");
		String pbName = scan.next();
		System.out.print("새 전화번호 >> ");
		String newPbTel = scan.next();
		
		int updateResult = pbdao.updatePhoneBook(pbName, newPbTel);
		
		if (updateResult > 0) {
			System.out.println(updateResult + "개의 연락처가 수정되었습니다.");
		} else {
			System.out.println("이름을 찾을 수 없습니다.");
		}
		
	}

	
	
	
}
