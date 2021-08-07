
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
					if (A.getPassword().equals(Inputpass) && A.getName().equals(Inputname)
							&& A.getRole().equals("User")) {
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
					if (A.getPassword().equals(InputAdminpass) && A.getName().equals(InputAdminname)
							&& A.getRole().equals("Admin")) {
						runAdmin();
					} else {
						output = "Invalid Username or Password";
					}
				}
				System.out.println(output);
				break;
			case 3:
				// TODO: Register new users
				manageRegUser(accountList);
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

	private void manageRegUser(ArrayList<Account> accountList) {
		String name = Helper.readString("Enter name: ");
		String role = Helper.readString("Enter role (User/Admin/Designer): ");
		String email = Helper.readString("Enter email: ");
		String password = Helper.readString("Enter password: ");
		String status = "New";
		if (!name.isEmpty() && !role.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
			if (role.equalsIgnoreCase("User") || role.equalsIgnoreCase("Admin") || role.equalsIgnoreCase("Designer")) {
				Account Act1 = new Account(name, role, email, password, status);
				regUser(accountList, Act1);
			} else {
				System.out.println("Wrong role!");
			}
		} else {
			System.out.println("Invliad Input!");
		}

	}

	public static void regUser(ArrayList<Account> accountList, Account Act1) {
		accountList.add(Act1);
		System.out.println("Account Added!");
	}

	private void manageAccount() {
		int choice = -1;
		while (choice != 4) {
			menAdminAccount.printMenu("Reno ACE App - Manage Account");
			choice = Validator.readIntPos("Enter choice > ");

			switch (choice) {
			case 1:
				// TODO: Add Account
				manageRegUser(accountList);
				break;
			case 2:
				// TODO: View All User
				viewUser(accountList);
				break;
			case 3:
				// TODO: Delete Account
				manageDeleteAccount();
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

	private void manageDeleteAccount() {
		viewUser(accountList);
		String Inputname = Helper.readString("Enter account name to delete: ");
		String output = "";
		int code = 0;
		for (Account A : accountList) {
			if (Inputname.equals(A.getName())) {
				char decision = Helper.readChar("Do you want to delete this appointment? (Y/N) > ");
				if (decision == 'y' || decision == 'Y') {
					code = accountList.indexOf(A);
					deleteAccount(code, accountList);
					output = Inputname + " Account has been deleted!";
				} else if (decision == 'N' || decision == 'n') {
					output += "Deletion Cancled!";
				}
				break;
			} else {
				output = Inputname + " Account invalid!";
			}
		}
		System.out.println(output);
	}

	public static boolean deleteAccount(int code, ArrayList<Account> accountList) {
		accountList.remove(code);
		return true;
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
			} else {
				System.out.println("No matching code found!");
				return;
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
				manageDeleteAppointment();
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
				System.out.println("Enter 'All' to view all output");

				String searchbyCat = Helper.readString("Search by > ");
				C206_CaseStudy.viewQuotation(QuotationList,searchbyCat);
				break;
			case 2:
				Quotation Q = InputQuotation();
				C206_CaseStudy.addQuotation(QuotationList, Q);

				break;
			case 3:
				ManageDeleteQuotation();
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
		Appointment appt = null;
		String pattern = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
		String pattern2 = "\\b((1[0-2]|0?[1-9]):([0-5][0-9]) ([AaPp][Mm]))";
		int id = Helper.readInt("Enter Appointment ID > ");
		String name = Helper.readString("Enter Name > ");
		String s = Integer.toString(id);
		String dName = Helper.readString("Enter Designer Name > ");
		String date = Helper.readStringRegEx("Enter Date of Appointment (dd/mm/yyyy) > ", pattern);
		String time = Helper.readStringRegEx("Enter Time of Appointment (hh:mm am/pm) >", pattern2);
		String address = Helper.readString("Enter Address > ");

		if (dName.isEmpty() || address.isEmpty() || s.isEmpty() || name.isEmpty()) {
			System.out.println("Unable to add appointment!");
			appt = null;
		} else {
			appt = new Appointment(id, name, dName, date, time, address);
		}
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
	private void manageDeleteAppointment() {
		String output = "";
		int apptID = Helper.readInt("Enter Appointment ID to delete > ");
		int deletion = -1;

		for (Appointment a : apptList) {
			if (apptID == a.getAppId()) {
				deletion = apptList.indexOf(a);
				char decision = Helper.readChar("Do you want to delete this appointment? (Y/N) > ");
				if (decision == 'y' || decision == 'Y') {
					deletion = apptList.indexOf(a);
					deleteAppointment(deletion, apptList);
					output = "Appointment successfully deleted!";
				} else if (decision == 'n' || decision == 'N') {
					output = "Appointment not deleted!";
				}
				break;

			} else {
				output = "No such ID found!";
			}
		}
		System.out.println(output);

	}

	public static void deleteAppointment(int deletion, ArrayList<Appointment> apptList) {
		apptList.remove(deletion);
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
		String String_check = "([a-zA-Z]+)|([a-zA-Z]+ [a-zA-Z]+)";
		String Int_check = "([1-9]|([1-9][0-9]+))";
		String datePattern = "((0[1-9]|[12]\\d|3[01])-(0[1-9]|1[0-2])-[12]\\d{3})";
		
		String RequestId = Helper.readStringRegEx("Enter Request ID > ",Int_check);
		String quotationId = Helper.readStringRegEx("Enter Quotation ID > ", Int_check);
		String RenoCategory = Helper.readStringRegEx("Enter Category> ",String_check);
		String items = Helper.readStringRegEx("Enter Items > ", String_check);
		int itemPrice = Helper.readInt("Enter item price > $");
		String DesignerName = Helper.readStringRegEx("Enter Designer name > ",String_check);
		String StartDate = Helper.readStringRegEx("Enter Date of Appointment (dd-mm-yyyy) > ", datePattern);
		int totalAmount = Helper.readInt("Enter total amount > $");

		String ItemPriceCheck = Integer.toString(itemPrice);
		String totalAmountCheck = Integer.toString(totalAmount);
		
		if (RequestId.isEmpty() || quotationId.isEmpty() || RenoCategory.isEmpty() || items.isEmpty() || ItemPriceCheck.isEmpty()|| DesignerName.isEmpty()
				|| StartDate.isEmpty() || totalAmountCheck.isEmpty()) {
			System.out.println("Unable to add Quotation!");
		} else {
			int addRequestId = Integer.parseInt(RequestId);
			int addquotationId = Integer.parseInt(quotationId);
			
			Q = new Quotation(addRequestId, addquotationId, RenoCategory, items,itemPrice, DesignerName, StartDate, totalAmount);

//							System.out.println("Quotation successfully added!");
		}
		return Q;
	}

	public static void addQuotation(ArrayList<Quotation> QuotationList, Quotation Q) {

		QuotationList.add(Q);
		System.out.println("Quotation successfully added!");
	}

	private void ManageDeleteQuotation() {
		Helper.line(80, "-");
		System.out.println("Delete Quotation");
		Helper.line(80, "-");
		int input = Validator.readIntPos("Enter package code > ");
		int deleteCode = -1;
		String output = "";

		for (Quotation Q : QuotationList) {

			if (input == Q.getRequestId()) {
				deleteCode = QuotationList.indexOf(Q);
				String ans = Helper.readString("Do you want to delete this appointment? (Y/N) > ");
				if (ans.equalsIgnoreCase("y")) {
					DeleteQuotation(deleteCode, QuotationList);
					output = "Quotation successfully deleted!";
				}
				break;
			} else {
				output = "No such ID can be found!";
			}
		}
		System.out.println(output);
	}

	public static void DeleteQuotation(int deleteCode, ArrayList<Quotation> QuotationList) {
		QuotationList.remove(deleteCode);
	}
	
//	REQUEST ID", "QUOTATION ID",
//	"CATEGORY", "ITEMS","ITEMS PRICE", "DESIGNER NAME ", "START DATE", "TOTAL AMOUNT
	
	public static String retrieveQuotation(ArrayList<Quotation> QuotationList, String searchbyCat) {
		
		String output = "";
		String datePattern = "((0[1-9]|[12]\\d|3[01])-(0[1-9]|1[0-2])-[12]\\d{3})";
		
	
		
		
		for (int i = 0; i < QuotationList.size(); i++) {
			if(searchbyCat.equalsIgnoreCase("REQUEST ID")) {
				int searchbyID = Helper.readInt("Enter request ID > ");
				if(QuotationList.get(i).getRequestId() == searchbyID) {
					output += String.format("%-10d %-25d %-25s %-15s %-25d %-15s %-15s %-30d\n", QuotationList.get(i).getRequestId(),
							QuotationList.get(i).getQuotationId(), QuotationList.get(i).getRenoCategory(),
							QuotationList.get(i).getItems(),QuotationList.get(i).getItemPrice(), QuotationList.get(i).getDesignerName(),
							QuotationList.get(i).getStartDate(), QuotationList.get(i).getTotalAmount());
				}else {
					System.out.println("No such ID exist.");
				}
			}else if(searchbyCat.equalsIgnoreCase("QUOTATION ID")){
				int searchbyQID = Helper.readInt("Enter QUOTATION ID > ");
				if(QuotationList.get(i).getQuotationId() == searchbyQID) {
					output += String.format("%-10d %-25d %-25s %-15s %-25d %-15s %-15s %-30d\n", QuotationList.get(i).getRequestId(),
							QuotationList.get(i).getQuotationId(), QuotationList.get(i).getRenoCategory(),
							QuotationList.get(i).getItems(),QuotationList.get(i).getItemPrice(), QuotationList.get(i).getDesignerName(),
							QuotationList.get(i).getStartDate(), QuotationList.get(i).getTotalAmount());
				}else {
					System.out.println("No such ID exist.");
				}
			}else if(searchbyCat.equalsIgnoreCase("CATEGORY")) {
				String searchbyCA = Helper.readString("Enter CATEGORY > ");
				if(QuotationList.get(i).getRenoCategory().equalsIgnoreCase(searchbyCA)) {
					output += String.format("%-10d %-25d %-25s %-15s %-25d %-15s %-15s %-30d\n", QuotationList.get(i).getRequestId(),
							QuotationList.get(i).getQuotationId(), QuotationList.get(i).getRenoCategory(),
							QuotationList.get(i).getItems(),QuotationList.get(i).getItemPrice(), QuotationList.get(i).getDesignerName(),
							QuotationList.get(i).getStartDate(), QuotationList.get(i).getTotalAmount());
				}else {
					System.out.println("No such category exist.");
				}
			}else if(searchbyCat.equalsIgnoreCase("name")) {
				String searchbyName = Helper.readString("Enter designer name > ");
				if(QuotationList.get(i).getDesignerName().equalsIgnoreCase(searchbyName)) {
					output += String.format("%-10d %-25d %-25s %-15s %-25d %-15s %-15s %-30d\n", QuotationList.get(i).getRequestId(),
							QuotationList.get(i).getQuotationId(), QuotationList.get(i).getRenoCategory(),
							QuotationList.get(i).getItems(),QuotationList.get(i).getItemPrice(), QuotationList.get(i).getDesignerName(),
							QuotationList.get(i).getStartDate(), QuotationList.get(i).getTotalAmount());
				}else {
					System.out.println("No such category exist.");
				}
			}else if(searchbyCat.equalsIgnoreCase("name")) {
				String searchbyDate = Helper.readStringRegEx("Enter date (dd-mm-yyyy) > ",datePattern);
				if(QuotationList.get(i).getStartDate().equalsIgnoreCase(searchbyDate)) {
					output += String.format("%-10d %-25d %-25s %-15s %-25d %-15s %-15s %-30d\n", QuotationList.get(i).getRequestId(),
							QuotationList.get(i).getQuotationId(), QuotationList.get(i).getRenoCategory(),
							QuotationList.get(i).getItems(),QuotationList.get(i).getItemPrice(), QuotationList.get(i).getDesignerName(),
							QuotationList.get(i).getStartDate(), QuotationList.get(i).getTotalAmount());
				}else {
					System.out.println("No such category exist.");
				}
			}else if(searchbyCat.equalsIgnoreCase("all")) {
				output += String.format("%-10d %-25d %-25s %-15s %-25d %-15s %-15s %-30d\n", QuotationList.get(i).getRequestId(),
						QuotationList.get(i).getQuotationId(), QuotationList.get(i).getRenoCategory(),
						QuotationList.get(i).getItems(),QuotationList.get(i).getItemPrice(), QuotationList.get(i).getDesignerName(),
						QuotationList.get(i).getStartDate(), QuotationList.get(i).getTotalAmount());
			}else {
				System.out.print("Unable to search by " + searchbyCat + ". Please Try again.");
			}
		}
//		String output = "";
//		for (int i = 0; i < QuotationList.size(); i++) {
//			output += String.format("%-10d %-25d %-25s %-15s %-25d %-15s %-15s %-30d\n", QuotationList.get(i).getRequestId(),
//					QuotationList.get(i).getQuotationId(), QuotationList.get(i).getRenoCategory(),
//					QuotationList.get(i).getItems(),QuotationList.get(i).getItemPrice(), QuotationList.get(i).getDesignerName(),
//					QuotationList.get(i).getStartDate(), QuotationList.get(i).getTotalAmount());
//		}
		return output;
	}

	public static void viewQuotation(ArrayList<Quotation> QuotationList, String searchbyCat) {
		Helper.line(80, "-");
		System.out.println("VIEW Quotation");
		Helper.line(80, "-");
		String output = String.format("%-10s %-25s %-25s %-15s %-25s %-15s %-15s %-30s\n", " REQUEST ID", "QUOTATION ID",
				"CATEGORY", "ITEMS","ITEMS PRICE", "DESIGNER NAME ", "START DATE", "TOTAL AMOUNT");
		output += retrieveQuotation(QuotationList, searchbyCat);
		System.out.println(output);
	}

}
