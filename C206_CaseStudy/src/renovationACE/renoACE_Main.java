package renovationACE;

import ExrionsLibrary.*;

public class renoACE_Main {
	//Main Menu (Login)
	private Menu menLogin = new Menu();

	public static void main(String[] args) {
		renoACE_Main r = new renoACE_Main();
		r.run();
	}
	
	private void run() {
		genMenuLogin();
		int choice = -1;
		
		while(choice != 3) {
			menLogin.printMenu("LOGIN");
			choice = Validator.readIntPos("Enter choice > ");
			
			switch(choice) {
			case 1:
				//TODO: Login for Users
				runUser();
				break;
			case 2:
				//TODO: Login for Admins
				runAdmin();
				break;
			case 3:
				//Terminate Program
				System.out.println("App exited successfully");
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
	
	private void runUser() {
		
	}
	
	private void runAdmin() {
		
	}
	
	private void genMenuLogin() {
		menLogin.addOption("User Login");
		menLogin.addOption("Admin Login");
		menLogin.addOption("Quit");
	}

}
