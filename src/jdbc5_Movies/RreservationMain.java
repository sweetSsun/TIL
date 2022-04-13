package jdbc5_Movies;

public class RreservationMain {

	public static void main(String[] args) {

		ReservationManager manager = new ReservationManager();
		boolean run = true;
		
		while(run) {
			manager.showMenu();
			int menuSel = manager.scan.nextInt();
			
			switch(menuSel) {
			case 1:
				if (manager.loginId.equals("")) {
					manager.memberJoin();
				} else {
					manager.moviesList();
				}
				break;
				
			case 2:
				if (manager.loginId.equals("")) {
					manager.memberLogin();
				} else {
					manager.theatersList();
				}
				break;
			case 3:
				manager.reservationMovie();
				break;
			case 6:
				manager.searchMovie();
				break;
			
			case 0:
				if (manager.loginId.equals("")) {
					run = false;
				} else {
					manager.memberLogout();
				}
				break;
			}
		}
	}

}
