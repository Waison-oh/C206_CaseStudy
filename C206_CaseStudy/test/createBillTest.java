import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class createBillTest {
	ArrayList<Bill> billList = new ArrayList<Bill>(); 
	@Test
	public void test() {
		ArrayList<Bill> billList = new ArrayList<Bill>();
		C206_CaseStudyTest createBillTest = new C206_CaseStudyTest(); 
		String result = createBillTest.viewBill(billList);
		assertEquals(billList, result); 
	}

}
