
import java.time.LocalDate;
import java.util.ArrayList;

import ExrionsLibrary.*;
import renovationACE.*;

public class C206_CaseStudy {
	// Main Menu (Login)
	private Menu menLogin = new Menu();

	// Menu User
	private Menu menUser = new Menu();

	// Menu Admin
	private Menu menAdmin = new Menu();
	private Menu menAdminPackage = new Menu();

	// ArrayLists for various things
	// TODO: Add objects into ArrayLists in genArrList()
//	ArrayList<Account> accountList = new ArrayList<Account>();
	ArrayList<RenoPackage> packageList = new ArrayList<RenoPackage>();
//	ArrayList<Quote> quoteList = new ArrayList<Quote>();
	ArrayList<Appointment> apptList = new ArrayList<Appointment>();
	ArrayList<Quotation> QuotationList = new ArrayList<Quotation>();

	public static void main(String[] args) {
		C206_CaseStudy r = new C206_CaseStudy();
		r.run();
	}

	private void run() {
		genArrList();

		// Login Menu generated
		genMenuLogin();

		// User Menu generated
		genMenuUser();

		// Admin Menu generated
		genMenuAdmin();
		genMenuAdminPackage(); // Manage Packages

		int choice = -1;

		while (choice != 4) {
			menLogin.printMenu("LOGIN");
			choice = Validator.readIntPos("Enter choice > ");

			switch (choice) {
			case 1:
				// TODO: Login for Users; NOTE ONLY USE runUser() when logged in successfully in
				// another method; its just here temporarily
				runUser();
				break;
			case 2:
				// TODO: Login for Admins; NOTE ONLY USE runAdmin() when logged in successfully
				// in another method; its just here temporarily
				runAdmin();
				break;
			case 3:
				// TODO: Register new users
				regUser();
				break;
			case 4:
				// Terminate Program
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

		while (choice != 3) {
			menUser.printMenu("Reno ACE App - CUSTOMER");
			choice = Validator.readIntPos("Enter choice > ");

			switch (choice) {
			case 1:
				// TODO: Request Quote method

				break;
			case 2:
				// TODO: Manage Appointment
				manageAppt();
				break;
			case 3:
				// Logout
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

		while (choice != 6) {
			menAdmin.printMenu("Reno ACE App - ADMIN");
			choice = Validator.readIntPos("Enter choice > ");

			switch (choice) {
			case 1:
				// TODO: Manage Customer

				break;
			case 2:
				// TODO: Manage Package
				managePackage();
				break;
			case 3:
				// TODO: Manage Request for Quotation

				break;
			case 4:
				// TODO: Manage Quotation
				manageQuotation();
				break;
			case 5:
				// TODO: Manage Appointment
				manageAppt();
				break;
			case 6:
				// Logout
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

	// Manage Packages - Admin sub-menu
	private void managePackage() {
		int choice = -1;

		while (choice != 4) {
			menAdminPackage.printMenu("Reno ACE App - Manage Packages");
			choice = Validator.readIntPos("Enter choice > ");

			switch (choice) {
			case 1:
				// TODO: Add Package
				managePackageAdd();				
				break;
			case 2:
				// TODO: View All Packages
				managePackageView();
				break;
			case 3:
				// TODO: Delete Package
				managePackageDelete();				
				break;
			case 4:
				// Exit
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}

	private void managePackageDelete() {
		Menu.printTitle("Delete Package");
		
		String output = String.format("%-5s %-30s %-12s %-12s %s\n", "Code", "Description", "Start Date", "End Date", "Amount");
		int input = Validator.readIntPos("Enter package code > ");
		int deleteCode = -1;
		
		for(RenoPackage p : packageList) {
			if(input == p.getCode()) {
				output += String.format("%-5d %-30s %-12s %-12s $%.2f\n", p.getCode(), p.getDesc(), p.getStartDate(), p.getEndDate(), p.getAmount());
				deleteCode = packageList.indexOf(p);
			}
		}
		
		System.out.println(output);
		
		char confirm = Validator.readChar("Confirm Deletion of Package with Code - " + (deleteCode + 1) + " (y/n) > ");
		
		if(!(confirm == 'y' || confirm == 'n')) {
			System.out.println("Invalid choice");
		} else {
			if(confirm == 'y') {
				packageList.remove(deleteCode);
				System.out.println("Package Deleted.");
			} else if (confirm == 'n') {
				System.out.println("Operation Cancelled.");
			}
		}
	}

	private void managePackageView() {
		Menu.printTitle("View All Packages");
		
		String output = String.format("%-5s %-30s %-12s %-12s %s\n", "Code", "Description", "Start Date", "End Date", "Amount");
		
		for(RenoPackage p : packageList) {
			output += String.format("%-5d %-30s %-12s %-12s $%.2f\n", p.getCode(), p.getDesc(), p.getStartDate(), p.getEndDate(), p.getAmount());
		}
		
		System.out.println(output);
	}

	private void managePackageAdd() {
		Menu.printTitle("Add Package");
		int code = getPackageCode();
		String desc = Validator.readString("Enter Description > ");
		String start = Validator.readString("Enter Start Date (YYYY-MM-DD) > ");
		String end = Validator.readString("Enter End Date (YYYY-MM-DD) > ");
		double value = Validator.readDoublePos("Enter Amount (Price) of Package > ");

		String regexDate = "(19|20)\\d\\d-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])";

		dateCheck dc = (String date) -> date.matches(regexDate);
		
		LocalDate dateStart = dateChecker(dc, start, "Start");
		LocalDate dateEnd = dateChecker(dc, end, "End");
		
		packageList.add(new RenoPackage(code, desc, dateStart, dateEnd, value));
	}
	
	private LocalDate dateChecker(dateCheck condition, String date, String type) {
		String newDate = "";
		LocalDate localDate = null;
		boolean newDateVal = false;
		
		while (!condition.checker(date)) {
			System.out.println("Invalid date format, please try again");
			newDate = Validator.readString("Enter " + type + " Date (YYYY-MM-DD) > ");
			
			if(condition.checker(newDate)) {
				localDate = LocalDate.parse(newDate);
				newDateVal = true;
				break;
			}
		}
		
		if(!newDateVal) {
			localDate = LocalDate.parse(date);
		}
		
		return localDate;
	}
	
	// Manage Appointments - Admin & Login sub-menu
	private void manageAppt() {
		int choice = -1;

		while (choice != 4) {
			apptMenu();
			choice = Validator.readIntPos("Enter choice > ");

			switch (choice) {
			case 1:
				viewAllAppointment();
				break;
			case 2:
				addAppointment();
				break;
			case 3:
				deleteAppointment();
				break;
			case 4:
				// Exit
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}
	private void manageQuotation() {
		int choice = -1;

		while (choice != 4) {
				QuotationMenu();
				choice = Validator.readIntPos("Enter choice > ");

			switch (choice) {
			case 1:
				viewQuotation();
				break;
			case 2:
				Quotation Q = InputQuotation();
				 C206_CaseStudy.addQuotation(QuotationList, Q);
				 

				
				break;
			case 3:
				DeleteQuotation();
				break;
			case 4:
				// Exit
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}

	private int getPackageCode() {
		int code = 1;
		for (RenoPackage p : packageList) {
			if (p.getCode() != code) {
				break;
			} else {
				code++;
			}
		}
		return code;
	}

	// Generates Menu for login screen
	private void genMenuLogin() {
		menLogin.addOption("User Login");
		menLogin.addOption("Admin Login");
		menLogin.addOption("Visitor Account Registration");
		menLogin.addOption("Quit");
	}

	// Generates Menu for user screen
	private void genMenuUser() {
		menUser.addOption("Request for Quotation");
		menUser.addOption("Manage Appointment");
		menUser.addOption("Quit");
	}

	// Generates Menu for admin screen
	private void genMenuAdmin() {
		menAdmin.addOption("Manage Customer");
		menAdmin.addOption("Manage Package");
		menAdmin.addOption("Manage Request for Quotation");
		menAdmin.addOption("Manage Quotation");
		menAdmin.addOption("Manage Appointment");
		menAdmin.addOption("Quit");
	}

	// Generates Manage Package - Admin
	private void genMenuAdminPackage() {
		menAdminPackage.addOption("Add Package");
		menAdminPackage.addOption("View All Packages");
		menAdminPackage.addOption("Delete Package");
		menAdminPackage.addOption("Quit");
	}

	// Generates ArrayList data
	private void genArrList() {
		// packageList
		packageList.add(new RenoPackage(1, "Majulah Package", LocalDate.of(2021, 8, 1), LocalDate.of(2021, 8, 31), 20000));
		packageList.add(new RenoPackage(2, "New Year Package", LocalDate.of(2021, 12, 31), LocalDate.of(2022, 1, 12), 35000));
		packageList.add(new RenoPackage(3, "Premium Terrace Package", LocalDate.of(2020, 4, 28),LocalDate.of(2021, 11, 16), 148000));
	}

	// ================================= Manage Appointment =====================================
	private void apptMenu() {
		System.out.println("1. View Appointment");
		System.out.println("2. Add Appointment");
		System.out.println("3. Delete Appointment");
		System.out.println("4. Quit");
	}

	// Option 1 Adding the Appointment
	private void addAppointment() {
		int id = Helper.readInt("Enter Appointment ID > ");
		String name = Helper.readString("Enter Name > ");
		String s = Integer.toString(id);
		String dName = Helper.readString("Enter Designer Name > ");
		String date = Helper.readString("Enter Date of Appointment (dd/mm/yyyy) > ");
		String time = Helper.readString("Enter Time of Appointment (hh:mm am/pm) >");
		String address = Helper.readString("Enter Address > ");

		boolean isValid = false;

		if (dName.isEmpty() || date.isEmpty() || time.isEmpty() || address.isEmpty() || s.isEmpty() || name.isEmpty()) {
			isValid = false;
		} else {
			isValid = true;
		}

		if (isValid == false) {
			System.out.println("Unable to add appointment!");
		} else {
			apptList.add(new Appointment(id, name, dName, date, time, address));
			System.out.println("Appointment successfully added!");
		}

	}

	// Option 2 Viewing all the Appointment
	private void viewAllAppointment() {
		Helper.line(150, "-");
		System.out.println("VIEW APPOINTMENT");
		Helper.line(150, "-");
		String output = String.format("%-10s %-25s %-25s %-15s %-15s %-30s\n", "ID", "CUSTOMER", "DESIGNER", "DATE",
				"TIME", "ADDRESS");
		for (int i = 0; i < apptList.size(); i++) {
			output += String.format("%-10s %-25s %-25s %-15s %-15s %-30s\n", apptList.get(i).getAppId(),
					apptList.get(i).getCustName(), apptList.get(i).getdName(), apptList.get(i).getDateofApp(),
					apptList.get(i).getTimeofApp(), apptList.get(i).getAddress());
		}
		System.out.println(output);
	}

	// Option 3 Deleting of the Appointment
	private void deleteAppointment() {
		viewAllAppointment();
		int apptID = Helper.readInt("Enter Appointment ID > ");
		String output = "";

		for (int i = 0; i < apptList.size(); i++) {
			if (apptList.get(i).getAppId() == apptID) {
				char decision = Helper.readChar("Do you want to delete this appointment? (Y/N) > ");
				if (decision == 'y' || decision == 'Y') {
					apptList.remove(i);
					output = "Appointment successfully deleted!";
				}
				break;
			} else {
				output = "No such ID found!";
			}
		}
		System.out.println(output);

	}
	
	// ================================= Manage Quotation =====================================
		private void QuotationMenu() {
			System.out.println("1. View all Quotation");
			System.out.println("2. Add Quotation");
			System.out.println("3. Delete Quotation");
			System.out.println("4. Quit");
		}	
		
		 public static Quotation InputQuotation() {
			 Quotation Q =null;
			int RequestId = Helper.readInt("Enter Request ID > ");
			int quotationId = Helper.readInt("Enter Quotation ID > ");
			String RenoCategory = Helper.readString("Enter Category> ");
			String items = Helper.readString("Enter Items > ");
			String DesignerName = Helper.readString("Enter Designer name > ");
			String StartDate = Helper.readString("Enter Date of Appointment (dd/mm/yyyy) > ");
			int totalAmount = Helper.readInt("Enter total amount > $");
			
			//change to string
			String RID = Integer.toString(RequestId);
			String QID = Integer.toString(quotationId);
			String AMT = Integer.toString(totalAmount);

			if (RID.isEmpty() || QID.isEmpty() || RenoCategory.isEmpty() || items.isEmpty() || DesignerName.isEmpty() || StartDate.isEmpty() || AMT.isEmpty()) {
				System.out.println("Unable to add Quotation!");
			} else {
				Q = new Quotation(RequestId, quotationId, RenoCategory, items, DesignerName,StartDate,totalAmount);
				
				
//						System.out.println("Quotation successfully added!");
			}
			return Q;
		}
		
		 
		 public static void addQuotation(ArrayList<Quotation> QuotationList, Quotation Q) {   
				
			 QuotationList.add(Q);
			 System.out.println("Quotation successfully added!");
			}
		 
		
		private void DeleteQuotation() {
			int QuotationID = Helper.readInt("Enter Quotation ID > ");
			String output = "";

			for (int i = 0; i < QuotationList.size(); i++) {
				if (QuotationList.get(i).getRequestId() == QuotationID) {
					String ans = Helper.readString("Do you want to delete this appointment? (Y/N) > ");
					if (ans.equalsIgnoreCase("y")) {
						QuotationList.remove(i);
						output = "Quotation successfully deleted!";
					}
					break;
				} else {
					output = "No such ID can be found!";
				}
			}
			System.out.println(output);
		}
		
		private void viewQuotation() {
			Helper.line(80, "-");
			System.out.println("VIEW Quotation");
			Helper.line(80, "-");
			String output = String.format("%-10s %-25s %-25s %-15s %-15s %-15s %-30s\n", " REQUEST ID", "QUOTATION ID", "CATEGORY", "ITEMS",
					"DESIGNER NAME ","START DATE", "TOTAL AMOUNT");
			for (int i = 0; i < QuotationList.size(); i++) {
				output += String.format("%-10d %-25d %-25s %-15s %-15s %-15s %-30d\n", QuotationList.get(i).getRequestId(),
						QuotationList.get(i).getQuotationId(), QuotationList.get(i).getRenoCategory(), QuotationList.get(i).getItems(),
						QuotationList.get(i).getDesignerName(), QuotationList.get(i).getStartDate(),QuotationList.get(i).getTotalAmount());
			}
			System.out.println(output);
		}
		
	
}
