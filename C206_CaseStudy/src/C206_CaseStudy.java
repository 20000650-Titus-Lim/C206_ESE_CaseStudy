
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
	private Menu menAdminAccount = new Menu();
	private Menu menAdminPackage = new Menu();

	// ArrayLists for various things
	// TODO: Add objects into ArrayLists in genArrList()
	ArrayList<Account> accountList = new ArrayList<Account>();
	ArrayList<RenoPackage> packageList = new ArrayList<RenoPackage>();
//		ArrayList<Quote> quoteList = new ArrayList<Quote>();
	ArrayList<Appointment> apptList = new ArrayList<Appointment>();
	ArrayList<Quotation> QuotationList = new ArrayList<Quotation>();

	Account Acc1 = new Account("Vedha", "Admin", "Vedha@gmail.com", "Class", "Confirmed");
	Account Acc2 = new Account("Titus", "Admin", "Titus@gmail.com", "Class", "Confirmed");
	Account Acc3 = new Account("Qis", "Admin", "Qis@gmail.com", "Class", "Confirmed");
	Account Acc4 = new Account("Nic", "Admin", "Nic@gmail.com", "Class", "Confirmed");

	Account Acc5 = new Account("Vedha1", "User", "Vedha1@gmail.com", "Class1", "Confirmed");
	Account Acc6 = new Account("Titus1", "User", "Titus1@gmail.com", "Class1", "Confirmed");
	Account Acc7 = new Account("Qis1", "User", "Qis1@gmail.com", "Class1", "Confirmed");
	Account Acc8 = new Account("Nic1", "User", "Nic1@gmail.com", "Class1", "Confirmed");

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
		genMenuAdminUser();
		genMenuAdminPackage(); // Manage Packages

		accountList.add(Acc1);
		accountList.add(Acc2);
		accountList.add(Acc3);
		accountList.add(Acc4);
		accountList.add(Acc5);
		accountList.add(Acc6);
		accountList.add(Acc7);
		accountList.add(Acc8);

		int choice = -1;

		while (choice != 4) {
			menLogin.printMenu("LOGIN");
			choice = Validator.readIntPos("Enter choice > ");
			String output = "";
			switch (choice) {
			case 1:
				// TODO: Login for Users; NOTE ONLY USE runUser() when logged in successfully in
				// another method; its just here temporarily
				String Inputname = Helper.readString("Enter Username: ");
				String Inputpass = Helper.readString("Enter Password: ");
				for (Account A : accountList) {
					if (A.getPassword().equals(Inputpass) && A.getName().equals(Inputname) && A.getRole().equals("User")) {
						runUser();
					} else {
						output = "Invalid Username or Password";
					}
				}
				System.out.println(output);
				break;
			case 2:
				// TODO: Login for Admins; NOTE ONLY USE runAdmin() when logged in successfully
				// in another method; its just here temporarily
				String InputAdminname = Helper.readString("Enter Username: ");
				String InputAdminpass = Helper.readString("Enter Password: ");
				for (Account A : accountList) {
					if (A.getPassword().equals(InputAdminpass) && A.getName().equals(InputAdminname) && A.getRole().equals("Admin")) {
						runAdmin();
					} else {
						output = "Invalid Username or Password";
					}
				}
				System.out.println(output);
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
				manageAccount();
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
		String name = Helper.readString("Enter name: ");
		String role = Helper.readString("Enter role (Customer/Admin/Designer): ");
		String email = Helper.readString("Enter email: ");
		String password = Helper.readString("Enter password: ");
		String status = "New";
		Account Act1 = new Account(name, role, email, password, status);
		accountList.add(Act1);
		System.out.println(name + " Account Added!");

	}

	private void manageAccount() {
		int choice = -1;
		while (choice != 4) {
			menAdminAccount.printMenu("Reno ACE App - Manage Account");
			choice = Validator.readIntPos("Enter choice > ");

			switch (choice) {
			case 1:
				// TODO: Add Account
				regUser();
				break;
			case 2:
				// TODO: View All User
				viewUser(accountList);
				break;
			case 3:
				// TODO: Delete Account
				deleteAccount(accountList);
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

	// Code for getting account deatils from admin and Adding into the array list -
	// Vedha

	// code for view user - Vedha
	public static String viewUser(ArrayList<Account> accountList) {
		String viewUser = String.format("%-15s %-11s %-20s %-20s %-10s\n", "Account Name", "Role", "Email", "Password",
				"Status");
		for (int x = 0; x < accountList.size(); x++) {
			viewUser += String.format("%-15s %-11s %-20s %-20s %-10s\n", accountList.get(x).getName(),
					accountList.get(x).getRole(), accountList.get(x).getEmail(), accountList.get(x).getPassword(),
					accountList.get(x).getStatus());
		}
		System.out.println(viewUser);
		return viewUser;
	}

	public static void deleteAccount(ArrayList<Account> accountList) {
		viewUser(accountList);
		String Inputname = Helper.readString("Enter account name to delete: ");
		String output = "";
		for (Account A : accountList) {
			if (Inputname.equals(A.getName())) {
				char decision = Helper.readChar("Do you want to delete this appointment? (Y/N) > ");
				if (decision == 'y' || decision == 'Y') {
					accountList.remove(A);
					output = Inputname + " Account has been deleted!";
				}
				else if(decision == 'N' || decision == 'n'){
					output += "Deletion Cancled!";
			}
				else {
					output = Inputname + " Account invalid!";
				}
				break;
			}
		}
		System.out.println(output);
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
				System.out.println(managePackageView(packageList));
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

		String output = String.format("%-5s %-30s %-12s %-12s %s\n", "Code", "Description", "Start Date", "End Date",
				"Amount");
		int input = Validator.readIntPos("Enter package code > ");
		int deleteCode = -1;

		for (RenoPackage p : packageList) {
			if (input == p.getCode()) {
				output += String.format("%-5d %-30s %-12s %-12s $%.2f\n", p.getCode(), p.getDesc(), p.getStartDate(),
						p.getEndDate(), p.getAmount());
				deleteCode = packageList.indexOf(p);
			}
		}

		System.out.println(output);

		char confirm = Validator.readChar("Confirm Deletion of Package with Code - " + (deleteCode + 1) + " (y/n) > ");

		if (!(confirm == 'y' || confirm == 'n')) {
			System.out.println("Invalid choice");
		} else {
			if (confirm == 'y') {
				deletePackage(deleteCode, packageList);
				System.out.println("Package Deleted.");
			} else if (confirm == 'n') {
				System.out.println("Operation Cancelled.");
			}
		}
	}

	public static void deletePackage(int deleteCode, ArrayList<RenoPackage> packageList) {
		packageList.remove(deleteCode);
	}

	public static String managePackageView(ArrayList<RenoPackage> packageList) {
		Menu.printTitle("View All Packages");

		String output = String.format("%-5s %-30s %-12s %-12s %s\n", "Code", "Description", "Start Date", "End Date",
				"Amount");

		for (RenoPackage p : packageList) {
			output += String.format("%-5d %-30s %-12s %-12s $%.2f\n", p.getCode(), p.getDesc(), p.getStartDate(),
					p.getEndDate(), p.getAmount());
		}

		return output;
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

		RenoPackage newPackage = new RenoPackage(code, desc, dateStart, dateEnd, value);
		addPackage(packageList, newPackage);
	}

	public static void addPackage(ArrayList<RenoPackage> packageList, RenoPackage p) {
		packageList.add(p);
		System.out.println("Package Added!");
	}

	private LocalDate dateChecker(dateCheck condition, String date, String type) {
		String newDate = "";
		LocalDate localDate = null;
		boolean newDateVal = false;

		while (!condition.checker(date)) {
			System.out.println("Invalid date format, please try again");
			newDate = Validator.readString("Enter " + type + " Date (YYYY-MM-DD) > ");

			if (condition.checker(newDate)) {
				localDate = LocalDate.parse(newDate);
				newDateVal = true;
				break;
			}
		}

		if (!newDateVal) {
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
				C206_CaseStudy.viewAllAppointment(apptList);
				break;
			case 2:
				Appointment appt = inputAppointment();
				C206_CaseStudy.addAppointment(apptList, appt);
				break;
			case 3:
				C206_CaseStudy.viewAllAppointment(apptList);
				int apptID = Helper.readInt("Enter Appointment ID to delete > ");
				C206_CaseStudy.deleteAppointment(apptList, apptID);
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

				C206_CaseStudy.viewQuotation(QuotationList);
				break;
			case 2:
				Quotation Q = InputQuotation();
				C206_CaseStudy.addQuotation(QuotationList, Q);

				break;
			case 3:
				int QuotationID = Helper.readInt("Enter Quotation ID > ");
				C206_CaseStudy.DeleteQuotation(QuotationList, QuotationID);
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

	// Generates Manage User - Admin
	private void genMenuAdminUser() {
		menAdminAccount.addOption("Add Account");
		menAdminAccount.addOption("View All User");
		menAdminAccount.addOption("Delete Account");
		menAdminAccount.addOption("Quit");
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
		packageList
				.add(new RenoPackage(1, "Majulah Package", LocalDate.of(2021, 8, 1), LocalDate.of(2021, 8, 31), 20000));
		packageList.add(
				new RenoPackage(2, "New Year Package", LocalDate.of(2021, 12, 31), LocalDate.of(2022, 1, 12), 35000));
		packageList.add(new RenoPackage(3, "Premium Terrace Package", LocalDate.of(2020, 4, 28),
				LocalDate.of(2021, 11, 16), 148000));
	}

	// ================================= Manage Appointment
	// ===================================== (Qisthina)
	private void apptMenu() {
		System.out.println("1. View Appointment");
		System.out.println("2. Add Appointment");
		System.out.println("3. Delete Appointment");
		System.out.println("4. Quit");
	}

	// Option 1 Adding the Appointment
	public static Appointment inputAppointment() {
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
		}
		Appointment appt = new Appointment(id, name, dName, date, time, address);
		return appt;

	}

	public static void addAppointment(ArrayList<Appointment> apptList, Appointment appt) {
		apptList.add(appt);
		System.out.println("Appointment successfully added!");
	}

	// Option 2 Viewing all the Appointment
	public static String retrieveAllAppointment(ArrayList<Appointment> apptList) {
		String output = "";
		for (int i = 0; i < apptList.size(); i++) {
			output += String.format("%-10d %-20s %-20s %-15s %-15s %-30s\n", apptList.get(i).getAppId(),
					apptList.get(i).getCustName(), apptList.get(i).getdName(), apptList.get(i).getDateofApp(),
					apptList.get(i).getTimeofApp(), apptList.get(i).getAddress());
		}
		return output;
	}

	public static void viewAllAppointment(ArrayList<Appointment> apptList) {
		Helper.line(150, "-");
		System.out.println("VIEW APPOINTMENT");
		Helper.line(150, "-");
		String output = String.format("%-10s %-20s %-20s %-15s %-15s %-30s\n", "ID", "CUSTOMER", "DESIGNER", "DATE",
				"TIME", "ADDRESS");
		output += retrieveAllAppointment(apptList);
		System.out.println(output);
	}

	// Option 3 Deleting of the Appointment
	public static void deleteAppointment(ArrayList<Appointment> apptList, int x) {
		String output = "";

		for (int i = 0; i < apptList.size(); i++) {
			if (apptList.get(i).getAppId() == x) {
				char decision = Helper.readChar("Do you want to delete this appointment? (Y/N) > ");
				if (decision == 'y' || decision == 'Y') {
					apptList.remove(i);
					output = "Appointment successfully deleted!";
				} else {
					output = "Appointment not deleted!";
				}
			} else {
				output = "No such ID found!";
			}
		}
		System.out.println(output);

	}

	// ================================= Manage Quotation
	// =====================================
	private void QuotationMenu() {
		System.out.println("1. View all Quotation");
		System.out.println("2. Add Quotation");
		System.out.println("3. Delete Quotation");
		System.out.println("4. Quit");
	}

	public static Quotation InputQuotation() {
		Quotation Q = null;
		int RequestId = Helper.readInt("Enter Request ID > ");
		int quotationId = Helper.readInt("Enter Quotation ID > ");
		String RenoCategory = Helper.readString("Enter Category> ");
		String items = Helper.readString("Enter Items > ");
		String DesignerName = Helper.readString("Enter Designer name > ");
		String StartDate = Helper.readString("Enter Date of Appointment (dd/mm/yyyy) > ");
		int totalAmount = Helper.readInt("Enter total amount > $");

		// change to string
		String RID = Integer.toString(RequestId);
		String QID = Integer.toString(quotationId);
		String AMT = Integer.toString(totalAmount);

		if (RID.isEmpty() || QID.isEmpty() || RenoCategory.isEmpty() || items.isEmpty() || DesignerName.isEmpty()
				|| StartDate.isEmpty() || AMT.isEmpty()) {
			System.out.println("Unable to add Quotation!");
		} else {
			Q = new Quotation(RequestId, quotationId, RenoCategory, items, DesignerName, StartDate, totalAmount);

//							System.out.println("Quotation successfully added!");
		}
		return Q;
	}

	public static void addQuotation(ArrayList<Quotation> QuotationList, Quotation Q) {

		QuotationList.add(Q);
		System.out.println("Quotation successfully added!");
	}

	public static void DeleteQuotation(ArrayList<Quotation> QuotationList, int quotationID) {

		String output = "";

		for (int i = 0; i < QuotationList.size(); i++) {
			if (QuotationList.get(i).getRequestId() == quotationID) {
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

	public static String retrieveQuotation(ArrayList<Quotation> QuotationList) {
		String output = "";
		for (int i = 0; i < QuotationList.size(); i++) {
			output += String.format("%-10d %-25d %-25s %-15s %-15s %-15s %-30d\n", QuotationList.get(i).getRequestId(),
					QuotationList.get(i).getQuotationId(), QuotationList.get(i).getRenoCategory(),
					QuotationList.get(i).getItems(), QuotationList.get(i).getDesignerName(),
					QuotationList.get(i).getStartDate(), QuotationList.get(i).getTotalAmount());
		}
		return output;
	}

	public static void viewQuotation(ArrayList<Quotation> QuotationList) {
		Helper.line(80, "-");
		System.out.println("VIEW Quotation");
		Helper.line(80, "-");
		String output = String.format("%-10s %-25s %-25s %-15s %-15s %-15s %-30s\n", " REQUEST ID", "QUOTATION ID",
				"CATEGORY", "ITEMS", "DESIGNER NAME ", "START DATE", "TOTAL AMOUNT");
		output += retrieveQuotation(QuotationList);
		System.out.println(output);
	}

}
