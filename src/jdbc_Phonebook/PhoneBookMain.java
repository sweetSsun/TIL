package jdbc_Phonebook;

public class PhoneBookMain {

	public static void main(String[] args) {

		PhoneBookManager manager = new PhoneBookManager();
		
		boolean run = true;
		
		while(run) {
			manager.showMenu();
			int menuSel = manager.scan.nextInt();
			
			switch(menuSel) {
			case 0:
				run = false;
				break;
				
			case 1:
				manager.insertPhoneBook();
				break;
				
			case 2:
				manager.selectPhoneBook();
				break;
				
			case 3:
				manager.deletePhoneBook();
				break;
				
			case 4:
				manager.updatePhoneBook();
				break;
			}
			
			
			
			
			
			
			
		}
		
		
		
	}

}
