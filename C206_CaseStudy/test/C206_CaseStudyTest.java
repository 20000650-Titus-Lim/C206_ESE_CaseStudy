import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Quotation Q1;
	private Quotation Q2;
	ArrayList<Quotation> QuotationList = new ArrayList<Quotation>();
	@Before
	public void setUp() throws Exception {
		
		Q1 = new Quotation(1, 1, "Living Room","Door","Nicholas","8/8/2021",1500);
		Q2 = new Quotation(2, 2, "Kitchen","Door","TOM","10/8/2021",2000);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
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
		
	

}
