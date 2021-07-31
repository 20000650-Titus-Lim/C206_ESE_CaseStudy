package renovationACE;

import ExrionsLibrary.*;

public class renoACE_Main {

	public static void main(String[] args) {
		renoACE_Main r = new renoACE_Main();
		r.run();
	}
	
	private void run() {
		int choice = -1;
		
		switch(choice) {
		case 1:
			//TODO: Login for Users
			runUser();
			break;
		case 2:
			//TODO: Login for Admins
			runAdmin();
			break;
		default:
			System.out.println("Invalid Choice");
		}
	}
	
	private void runUser() {
		
	}
	
	private void runAdmin() {
		
	}

}
