package renovationACE;

import ExrionsLibrary.*;

public class renoACE_Main {
	//Main Menu (Login)
	private Menu menLogin = new Menu();
	
	//Menu User
	private Menu menUser = new Menu();
	
	//Menu Admin
	private Menu menAdmin = new Menu();
	private Menu menAdminPackage = new Menu();

	public static void main(String[] args) {
		renoACE_Main r = new renoACE_Main();
		r.run();
	}
	
	private void run() {
		//Login Menu generated
		genMenuLogin();
		
		//User Menu generated
		genMenuUser();
		
		//Admin Menu generated
		genMenuAdmin();
		genMenuAdminPackage(); //Manage Packages
		
		int choice = -1;
		
		while(choice != 4) {
			menLogin.printMenu("LOGIN");
			choice = Validator.readIntPos("Enter choice > ");
			
			switch(choice) {
			case 1:
				//TODO: Login for Users; NOTE ONLY USE runUser() when logged in successfully in another method; its just here temporarily
				runUser();
				break;
			case 2:
				//TODO: Login for Admins; NOTE ONLY USE runAdmin() when logged in successfully in another method; its just here temporarily
				runAdmin();
				break;
			case 3:
				//TODO: Register new users
				regUser();
				break;
			case 4:
				//Terminate Program
				System.out.println("App exited successfully");
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}
	
	private void runUser() {
		int choice = -1;
		
		while(choice != 3) {
			menUser.printMenu("Reno ACE App - CUSTOMER");
			choice = Validator.readIntPos("Enter choice > ");
			
			switch(choice) {
			case 1: 
				//TODO: Request Quote method
				
				break;
			case 2: 
				//TODO: Manage Appointment
				
				break;
			case 3:
				//Logout
				System.out.println("Logged out of account");
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}
	
	private void runAdmin() {
		int choice = -1;
		
		while(choice != 6) {
			menAdmin.printMenu("Reno ACE App - ADMIN");
			choice = Validator.readIntPos("Enter choice > ");
			
			switch(choice) {
			case 1: 
				//TODO: Manage Customer
				
				break;
			case 2: 
				//TODO: Manage Package
				
				break;
			case 3: 
				//TODO: Manage Request for Quotation
				
				break;
			case 4: 
				//TODO: Manage Quotation
				
				break;
			case 5: 
				//TODO: Manage Appointment
				
				break;
			case 6:
				//Logout
				System.out.println("Logged out of account");
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}
	
	private void regUser() {
		
	}
	
	//Manage Packages - Admin sub-menu
	private void managePackage() {
		int choice = -1;
		
		while(choice != 4) {
			menUser.printMenu("Reno ACE App - Manage Packages");
			choice = Validator.readIntPos("Enter choice > ");
			
			switch(choice) {
			case 1: 
				//TODO: Add Package
				
				break;
			case 2: 
				//TODO: View All Packages
				
				break;
			case 3:
				//TODO: Delete Package
				
				break;
			case 4:
				//Logout
				System.out.println("Logged out of account");
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}
	
	//Generates Menu for login screen
	private void genMenuLogin() {
		menLogin.addOption("User Login");
		menLogin.addOption("Admin Login");
		menLogin.addOption("Visitor Account Registration");
		menLogin.addOption("Quit");
	}
	
	//Generates Menu for user screen
	private void genMenuUser() {
		menUser.addOption("Request for Quotation");
		menUser.addOption("Manage Appointment");
		menUser.addOption("Quit");
	}
	
	//Generates Menu for admin screen
	private void genMenuAdmin() {
		menAdmin.addOption("Manage Customer");
		menAdmin.addOption("Manage Package");
		menAdmin.addOption("Manage Request for Quotation");
		menAdmin.addOption("Manage Quotation");
		menAdmin.addOption("Manage Appointment");
		menAdmin.addOption("Quit");
	}
	
	//Generates Manage Package - Admin
	private void genMenuAdminPackage() {
		menAdminPackage.addOption("Add Package");
		menAdminPackage.addOption("View All Packages");
		menAdminPackage.addOption("Delete Package");
		menAdminPackage.addOption("Quit");
	}
	

}
