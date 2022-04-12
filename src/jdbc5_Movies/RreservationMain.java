package jdbc5_Movies;

public class RreservationMain {

	public static void main(String[] args) {

		ReservationManager manager = new ReservationManager();
		boolean run = true;
		
		while(run) {
			int menuSel = manager.scan.nextInt();
			
			switch(menuSel) {
			case 0:
				run = false;
				break;
			}
		}
	}

}
