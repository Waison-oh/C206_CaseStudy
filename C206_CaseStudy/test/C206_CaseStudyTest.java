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
	private Menu monthMenu;
	private Menu monthMenu1;

	private ArrayList<Menu> menuList;
	private ArrayList<Account> accountList;
	private ArrayList<Order> orderList;
	private ArrayList<MenuItem> items;
	private ArrayList<Bill> billList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		//all the arrayList:
		
		menuList = new ArrayList<Menu>();
		accountList = new ArrayList<Account>();
		orderList = new ArrayList<Order>();
		items = new ArrayList<MenuItem>();
		billList = new ArrayList<Bill>();
		
		
		// menu item
		MI1 = new MenuItem("Western", "Chicken nugget", false, 6);
		MI2 = new MenuItem("Vegetarian", "Potato", true, 5);
		
		items.add(MI1);
		items.add(MI2);
		
		//monthly menu
		monthMenu = new Menu("Jan menu", 1, 1, items);
		monthMenu1 = new Menu("Feb menu", 2, 1, items);
		menuList.add(monthMenu);
		menuList.add(monthMenu1);

		//account stuff
		A1 = new Account(null, null, null, null);
		A2 = new Account(null, null, null, null);

	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test
	public void createMenuTest() {
		// test if the menu is created - normal
		C206_CaseStudy.createMenu(menuList, monthMenu);
		assertSame("Check that menu is create", monthMenu.getDisplayName(), menuList.get(0).getDisplayName());
		
		//test 

	}

	@Test
	public void viewMenuTest() {

	}

	@Test
	public void deleteMenuTest() {

	}

	@After
	public void tearDown() throws Exception {
	}

}
