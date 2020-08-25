import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private MenuItem MI1;
	private MenuItem MI2;
	private Account A1;
	private Account A2;
	private Order order1;
	private Order order2;
	

	private ArrayList<Menu> menuList;
	private ArrayList<Account> accountList;
	private ArrayList<Order> orderList ;
	private ArrayList<MenuItem> items ;
	private ArrayList<Bill> billList ;

	@Before
	public void setUp() throws Exception {
		//fill in respectively, thanksss
		MI1 = new MenuItem(null, null, false, 0);
		MI2 = new MenuItem(null, null, false, 0);
		A1 = new Account(null, null, null, null);
		A2 = new Account(null, null, null, null);

		menuList= new ArrayList<Menu>();
		accountList= new ArrayList<Account>();
		orderList = new ArrayList<Order>();
		items = new ArrayList<MenuItem>();
		billList = new ArrayList<Bill>();		
	}
	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	@Test
	public void createMenuTest() {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	

}
