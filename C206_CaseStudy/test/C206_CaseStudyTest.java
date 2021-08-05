import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Quotation Q1;
	private Quotation Q2;
	ArrayList<Quotation> QuotationList = new ArrayList<Quotation>();

	private Appointment appt1;
	private Appointment appt2;
	
	private ArrayList<Appointment> apptList;
	
	@Before
	public void setUp() throws Exception {

		Q1 = new Quotation(1, 1, "Living Room", "Door", "Nicholas", "8/8/2021", 1500);
		Q2 = new Quotation(2, 2, "Kitchen", "Door", "TOM", "10/8/2021", 2000);
		
		appt1 = new Appointment(1, "Qisthina", "Lucy", "27/09/2021", "12:30 pm", "Block 533 Choa Chu Kang Strt 12 #12-315");
		appt2 = new Appointment(2, "Daniah", "Lucy", "30/09/2021", "4:00 pm", "Block 667 Yio Chu Kang Strt 4 #05-212");

		apptList = new ArrayList<Appointment>();
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test
	public void managePackageAddTest() {

	}

	@Test
	public void managePackageViewTest() {

	}

	@Test
	public void managePackageDeleteTest() {

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

		// Add another item. test The size of the list is 2?
		C206_CaseStudy.addQuotation(QuotationList, Q2);
		assertEquals("Test that Quotation arraylist size is 2?", 2, QuotationList.size());
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

	public void deleteAppointmentTest() {
		// Test if Appointment list is not null but empty -boundary
		assertNotNull("Test if there is valid Appointment arraylist to retrieve appointment", apptList);

		// Given an empty list, after adding 2 appointments, and 1 is removed, test if
		// the size of the list is 1
		C206_CaseStudy.addAppointment(apptList, appt1);
		C206_CaseStudy.addAppointment(apptList, appt2);
		assertSame("Check that first appointment is added", appt1, apptList.get(0));
		C206_CaseStudy.deleteAppointment(apptList, 1);
		assertEquals("Test that Appointment arraylist size is 1", 1, apptList.size());

		// Test if the size of the list is 0 after removing 1 more appointment
		C206_CaseStudy.deleteAppointment(apptList, 2);
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
