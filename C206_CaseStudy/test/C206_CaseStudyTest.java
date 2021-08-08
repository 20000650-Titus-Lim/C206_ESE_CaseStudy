import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import renovationACE.Account;
import renovationACE.RenoPackage;

public class C206_CaseStudyTest {
	private Account Acc1;
	private Account Acc2;
	ArrayList<Account> accountList = new ArrayList<Account>();

	private Quotation Q1;
	private Quotation Q2;
	ArrayList<Quotation> QuotationList = new ArrayList<Quotation>();

	private Appointment appt1;
	private Appointment appt2;
	private ArrayList<Appointment> apptList = new ArrayList<Appointment>();

	private RenoPackage p1;
	private RenoPackage p2;
	private RenoPackage p3;
	private ArrayList<RenoPackage> packageList = new ArrayList<RenoPackage>();

	@Before
	public void setUp() throws Exception {

		Acc1 = new Account("Vedha", "Admin", "Vedha@gmail.com", "Class", "Confirmed");
		Acc2 = new Account("Vedha1", "User", "Vedha1@gmail.com", "Class1", "Confirmed");

		Q1 = new Quotation(1, 1, "Living Room", "Door",100, "Nicholas", "8-8-2021", 1500);
		Q2 = new Quotation(2, 2, "Kitchen", "Door", 100,"TOM", "10-8-2021", 2000);

		appt1 = new Appointment(1, "Qisthina", "Lucy", "27/09/2021", "12:30 pm",
				"Block 533 Choa Chu Kang Strt 12 #12-315");
		appt2 = new Appointment(2, "Daniah", "Lucy", "30/09/2021", "4:00 pm", "Block 667 Yio Chu Kang Strt 4 #05-212");

		p1 = new RenoPackage(1, "Majulah Package", LocalDate.of(2021, 8, 1), LocalDate.of(2021, 8, 31), 20000);
		p2 = new RenoPackage(2, "New Year Package", LocalDate.of(2021, 12, 31), LocalDate.of(2022, 1, 12), 35000);
		p3 = new RenoPackage(3, "Premium Terrace Package", LocalDate.of(2020, 4, 28), LocalDate.of(2021, 11, 16),
				148000);
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test
	public void manageAccountAddTest() {
		// Account list is not null, so that can add a new user - boundary
		assertNotNull("Check if there is valid Account arraylist to add to", accountList);

		// ------------------------------------------------------------------------------------------------------------------------------------------------

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The Account just added is as same as the first Account of the list
		C206_CaseStudy.regUser(accountList, Acc1);
		assertEquals("Check that Account arraylist size is 1", 1, accountList.size());
		assertSame("Check that Account is added", Acc1, accountList.get(0));

		// ------------------------------------------------------------------------------------------------------------------------------------------------

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.regUser(accountList, Acc2);
		assertEquals("Check that Account arraylist size is 2", 2, accountList.size());
		assertSame("Check that Account is added", Acc2, accountList.get(1));

		// ------------------------------------------------------------------------------------------------------------------------------------------------

		// Add another item. test The size of the list is not bigger than 2? -Error
		// The item just added is as same as the second item of the list
		assertNotEquals("Check that Account arraylist size is not bigger than 2", 3, accountList.size());
	}

	@Test
	public void manageAccountViewTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Account arraylist to retrieve item", accountList);

		// Given an empty list, after adding 1 appointment, the size of the list is 1 -
		// normal
		// The Package just added is as same as the first item of the list
		C206_CaseStudy.regUser(accountList, Acc1);
		assertEquals("Check that Account arraylist size is 1", 1, accountList.size());
		assertSame("Check that first Package is added", Acc1, accountList.get(0));

		// Test if the expected output string same as the list of Appointments retrieved
		// from the ArrayList
		String viewAccount = C206_CaseStudy.viewUser(accountList);
		String viewAccountTest = String.format("%-15s %-11s %-20s %-20s %-10s\n", "Account Name", "Role", "Email",
				"Password", "Status");
		viewAccountTest += String.format("%-15s %-11s %-20s %-20s %-10s\n", "Vedha", "Admin", "Vedha@gmail.com",
				"Class", "Confirmed");

		assertEquals("Test that output of method is the same as expected output", viewAccount, viewAccountTest);
	}

	@Test
	public void manageAccountDeleteTest() {
		// Account list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Account arraylist to add to", accountList);

		//
		C206_CaseStudy.regUser(accountList, Acc1);
		assertEquals("Check that Package arraylist size is 1", 1, accountList.size());
		assertSame("Check that first Package is added", Acc1, accountList.get(0));

		// Test if the size of the list is 0 after removing 1 more appointment
		C206_CaseStudy.deleteAccount(0, accountList);
		assertEquals("Test that the size of the list is 0 when the only package is removed.", accountList.size(), 0);
	}

	@Test
	public void managePackageAddTest() {
		// Package list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Package arraylist to add to", packageList);

		// Given an empty list, after adding 1 appointment, the size of the list is 1 -
		// normal
		// The Package just added is as same as the first item of the list
		C206_CaseStudy.addPackage(packageList, p1);
		assertEquals("Check that Package arraylist size is 1", 1, packageList.size());
		assertSame("Check that first Package is added", p1, packageList.get(0));

		// Add another Package. Test the size of the list is 2 - normal
		// The Package just added is as same as the second item of the list
		C206_CaseStudy.addPackage(packageList, p2);
		assertEquals("Check that Package arraylist size is 2", 2, packageList.size());
		assertSame("Check that second Package is added", p2, packageList.get(1));
	}

	@Test
	public void managePackageViewTest() {
		// Package list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Package arraylist to add to", packageList);

		// Given an empty list, after adding 1 appointment, the size of the list is 1 -
		// normal
		// The Package just added is as same as the first item of the list
		C206_CaseStudy.addPackage(packageList, p1);
		assertEquals("Check that Package arraylist size is 1", 1, packageList.size());
		assertSame("Check that first Package is added", p1, packageList.get(0));

		// Test if the expected output string same as the list of Appointments retrieved
		// from the ArrayList
		String viewPackages = C206_CaseStudy.managePackageView(packageList);
		String viewPackagesTest = String.format("%-5s %-30s %-12s %-12s %s\n", "Code", "Description", "Start Date",
				"End Date", "Amount");
		viewPackagesTest += String.format("%-5d %-30s %-12s %-12s $%.2f\n", 1, "Majulah Package", "2021-08-01",
				"2021-08-31", 20000.00);

		assertEquals("Test that output of method is the same as expected output", viewPackages, viewPackagesTest);
	}

	@Test
	public void managePackageDeleteTest() {
		// Package list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Package arraylist to add to", packageList);

		// Given an empty list, after adding 1 appointment, the size of the list is 1 -
		// normal
		// The Package just added is as same as the first item of the list
		C206_CaseStudy.addPackage(packageList, p1);
		assertEquals("Check that Package arraylist size is 1", 1, packageList.size());
		assertSame("Check that first Package is added", p1, packageList.get(0));

		// Test if the size of the list is 0 after removing 1 more appointment
		C206_CaseStudy.deletePackage(0, packageList);
		assertEquals("Test that the size of the list is 0 when the only package is removed.", packageList.size(), 0);
	}

	@Test
	public void testAddQuotation() {

		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Quotation arraylist to add to", QuotationList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addQuotation(QuotationList, Q1);
		assertEquals("Test if that Quotation arraylist size is 1?", 1, QuotationList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that new Quotation is added same as 1st item of the list?", Q1, QuotationList.get(0));

		// Add another item. test The size of the list is 2
		C206_CaseStudy.addQuotation(QuotationList, Q2);
		assertEquals("Test that Quotation arraylist size is 2?", 2, QuotationList.size());
	}

	@Test
	public void testViewQuotation() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Quotation arraylist to add to", QuotationList);

		// Given an empty list, after adding 2 item, the size of the list is 2
		C206_CaseStudy.addQuotation(QuotationList, Q1);
		C206_CaseStudy.addQuotation(QuotationList, Q2);
		assertEquals("Test if that Quotation arraylist size is 2", 2, QuotationList.size());

		
		// Test if the expected output string same as the quotation list retrieved
		// from the ArrayList
		String quotationView = C206_CaseStudy.retrieveQuotation(QuotationList,"all");

		String QuotaionTest = String.format("%-18d %-25d %-25s %-15s %-25d %-15s %-15s %-30d\n", 1, 1, "Living Room", "Door",
				 100 , "Nicholas", "8-8-2021", 1500);
		QuotaionTest += String.format("%-18d %-25d %-25s %-15s %-25d %-15s %-15s %-30d\n", 2, 2, "Kitchen", "Door",100, "TOM",
				"10-8-2021", 2000);

		assertEquals("Test that output of method is the same as expected output", quotationView, QuotaionTest);

	}

	@Test
	public void testQuotationDelete() {
		// Test if Quotation list is not null but empty
		assertNotNull("Test if there is valid Quotation arraylist to retrieve Quotation", QuotationList);

		// Given an empty list, after adding 2 Quotations, and 1 is then removed, test
		// that size of list is 1

		C206_CaseStudy.addQuotation(QuotationList, Q1);
		C206_CaseStudy.addQuotation(QuotationList, Q2);
		assertSame("Check that first Quotation is added", Q1, QuotationList.get(0));
		C206_CaseStudy.DeleteQuotation(1, QuotationList);

		assertEquals("Test that Quotation arraylist size is 1 after delete", 1, QuotationList.size());

		// Test that the correct variable is deleted.
		String quotationView = C206_CaseStudy.retrieveQuotation(QuotationList,"all");

		String QuotaionTest = String.format("%-18d %-25d %-25s %-15s %-25d %-15s %-15s %-30d\n", 1, 1, "Living Room", "Door",100,
				"Nicholas", "8-8-2021", 1500);

		assertEquals("Test that output of method is the same as expected output",quotationView, QuotaionTest);

	}

	@Test
	public void addAppointmentTest() {
		// Appointments list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Appointment arraylist to add to", apptList);

		// Given an empty list, after adding 1 appointment, the size of the list is 1 -
		// normal
		// The appointment just added is as same as the first item of the list
		C206_CaseStudy.addAppointment(apptList, appt1);
		assertEquals("Check that Appointment arraylist size is 1", 1, apptList.size());
		assertSame("Check that first appointment is added", appt1, apptList.get(0));

		// Add another appointment. Test the size of the list is 2 - normal
		// The appointment just added is as same as the second item of the list
		C206_CaseStudy.addAppointment(apptList, appt2);
		assertEquals("Check that Appointment arraylist size is 2", 2, apptList.size());
		assertSame("Check that second appointment is added", appt2, apptList.get(1));
	}

	@Test
	public void retrieveAllAppointmentTest() {
		// Test if Appointment list is not null but empty -boundary
		assertNotNull("Test if there is valid Appointment arraylist to retrieve appointment", apptList);

		// Test if the list of appointments retrieved from the C206_CaseStudy is empty -
		// boundary
		String allAppt = C206_CaseStudy.retrieveAllAppointment(apptList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allAppt);

		// Given an empty list, after adding 2 appointments, test if the size of the
		// list is 2
		// - normal
		C206_CaseStudy.addAppointment(apptList, appt1);
		C206_CaseStudy.addAppointment(apptList, appt2);
		assertEquals("Test that Appointment arraylist size is 2", 2, apptList.size());

		// Test if the expected output string same as the list of Appointments retrieved
		// from the SourceCentre
		allAppt = C206_CaseStudy.retrieveAllAppointment(apptList);
		testOutput = String.format("%-10d %-20s %-20s %-15s %-15s %-30s\n", 1, "Qisthina", "Lucy", "27/09/2021",
				"12:30 pm", "Block 533 Choa Chu Kang Strt 12 #12-315");
		testOutput += String.format("%-10d %-20s %-20s %-15s %-15s %-30s\n", 2, "Daniah", "Lucy", "30/09/2021",
				"4:00 pm", "Block 667 Yio Chu Kang Strt 4 #05-212");

		assertEquals("Test that ViewAllCamcorderlist", testOutput, allAppt);
	}

	@Test
	public void deleteAppointmentTest() {
		// Test if Appointment list is not null but empty -boundary
		assertNotNull("Test if there is valid Appointment arraylist to retrieve appointment", apptList);

		// Given an empty list, after adding 2 appointments, and 1 is removed, test if
		// the size of the list is 1
		C206_CaseStudy.addAppointment(apptList, appt1);
		C206_CaseStudy.addAppointment(apptList, appt2);
		assertSame("Check that first appointment is added", appt1, apptList.get(0));
		C206_CaseStudy.deleteAppointment(1, apptList);
		assertEquals("Test that Appointment arraylist size is 1", 1, apptList.size());

		// Test if the size of the list is 0 after removing 1 more appointment
		C206_CaseStudy.deleteAppointment(0, apptList);
		assertEquals("Test that Appointment arraylist size is 0", 0, apptList.size());

	}

	@After
	public void tearDown() throws Exception {
		Q1 = null;
		Q2 = null;
		appt1 = null;
		appt2 = null;

		apptList = null;
	}

}
