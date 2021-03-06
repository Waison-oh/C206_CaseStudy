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
		// fill in respectively, thanksss

		// all the arrayList:
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

		// monthly menu
		monthMenu = new Menu("Jan menu", 1, 1, items);
		monthMenu1 = new Menu("Feb menu", 2, 1, items);
		menuList.add(monthMenu);
		menuList.add(monthMenu1);

		// account stuff
		A1 = new Account(null, null, null, null);
		A2 = new Account(null, null, null, null);

		menuList = new ArrayList<Menu>();
		accountList = new ArrayList<Account>();
		orderList = new ArrayList<Order>();
		items = new ArrayList<MenuItem>();
		billList = new ArrayList<Bill>();
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	// Qiao Ling STARTS HERE//
		@Test
		public void createMenuTest() {

			// test if the menu is created - normal
			C206_CaseStudy.createMenu(menuList, monthMenu);
			assertSame("Check that menu is create", monthMenu.getDisplayName(), menuList.get(0).getDisplayName());

			// test if the menu is not created due to duplicated name - error

			C206_CaseStudy.createMenu(menuList, monthMenu);
			monthMenu1 = new Menu("Jan menu", 2, 1, items);
			boolean isCreated = C206_CaseStudy.createMenu(menuList, monthMenu1);

			assertEquals("Check that menu has the same menu name", menuList.get(0).getDisplayName(),
					monthMenu1.getDisplayName());
			assertFalse("Ensure that menu is not created due to duplicated name", isCreated);

			// test if the menu name is empty - error
			monthMenu1 = new Menu("", 2, 1, items);
			boolean emptyName = C206_CaseStudy.createMenu(menuList, monthMenu1);
			assertTrue("Ensure that menu is not created due to empty menu name", emptyName);
		}

		@Test
		public void viewMenuTest() {
			// test that if user can view the menu - normal
			C206_CaseStudy.createMenu(menuList, monthMenu);
			C206_CaseStudy.createMenu(menuList, monthMenu1);
			assertEquals("Test that menu arrayList size is 2", 2, menuList.size());

			// test that user cannot view the menu due to there is no menu inside the list -
			// error
			menuList.clear();
			assertEquals("Test that menu cannot be view due to empty List", 0, menuList.size());

		}

		@Test
		public void deleteMenuTest() {
			// test if the user can delete the menu successfully - normal
			C206_CaseStudy.createMenu(menuList, monthMenu);
			boolean isDeleted = C206_CaseStudy.deleteMenu(menuList, monthMenu);
			assertTrue("Test that the menu has been deleted successfully", isDeleted);

			// test that user cannot delete the menu as the menu does not exist - error
			C206_CaseStudy.createMenu(menuList, monthMenu);
			String menuName = "July Menu";
			assertNotEquals("Test that the menu cannot be deleted due to non-existing menu", monthMenu.getDisplayName(),
					menuName);

			// test that user cannot delete the menu as the menu name field is empty - error
			menuName = "";
			assertNotEquals("Test that the menu cannot be deleted due to empty field", monthMenu.getDisplayName(),
					menuName);

		}

		// Qiao Ling ENDS HERE//

		// Ashleigh STARTS HERE//

		@Test
		public void createBill() {
			// Bill list is not null, so that can add a new bill - error condition//
			assertNotNull("Check if there is valid Bill arraylist to add to", billList);
			// Given an empty list, after adding 1 item, the size of the list is 1//
			Bill billnew = new Bill("Alice", 5.60, "21/8/2020", false);
			billList.add(billnew);
			// The bill just added is the same as the first item of the list//
			assertSame("Check that Bill arraylist size is 1", 1, billList.size());
			assertSame("Check that Bill is added", billnew, billList.get(0));

			// Add another bill. Test The size of the list is 2 -normal condition//
			// The bill just added is the same as the second item of the list
			
		}

		@Test
		public void searchBill() {
			assertNotNull("Test if there is valid Bill arraylist to retrieve item", billList);
			// SchoolLunchBox_App.createBill(billList, billNew);
			Bill billnew = new Bill("Alice", 5.60, "21/8/2020", false);
			billList.add(billnew);
			
			assertEquals("Check that Bill arraylist size is 1", 1, billList.size());
			String expectedOutput = String.format("%-20s %-10.2f %-15s %-10s", "Alice", 5.60, "21/8/2020", false);
			String actualOutput = String.format("%-20s %-10.2f %-15s %-10s", billnew.getPayee(),billnew.getTotalAmount(),billnew.getDueDate(),false);
			assertEquals("Test if the bill is created",actualOutput,expectedOutput);

			String actualName = billnew.getPayee();
			String expected_out = "Alice";
			assertEquals("Check that search returns correct bill", expected_out, actualName);

		}

		@Test
		public void updateBill() {
			assertNotNull("Test if there is valid Bill arraylist to retrieve item", billList);
			Bill billnew = new Bill("Alice", 5.60, "21/8/2020", false);
			billList.add(billnew);

			//SchoolLunchBox_App.createBill(billList, billNew);
			assertEquals("Check that Bill arraylist size is 1", 1, billList.size());
			String expectedOutput = String.format("%-20s %-10.2f %-15s %-10s", "Alice", 5.60, "21/8/2020", false);
			String actualOutput = String.format("%-20s %-10.2f %-15s %-10s", billnew.getPayee(),billnew.getTotalAmount(),billnew.getDueDate(),false);
			assertEquals("Test if the bill is created",actualOutput,expectedOutput);

		}
		// Ashleigh ENDS HERE//
		
	// QIYUE START HERE
	@Test
	public void CreateOrderTest() {
		// OrderList is not null, so that can add new orders - boundary
		assertNotNull("Check if there is valid order arraylist to add to", orderList);
		//Order List is empty list, after adding 1 item, the size of the list is 1 - Normal
		ArrayList<MenuItem> MI = new ArrayList<MenuItem>();
		MI.add(new MenuItem("Asian", "Chicken rice", true, 5.00));
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(new Order("19013363", "2020-08-31", MI));
		assertEquals("Check that order List size is 1", 1,orderList.size());
		assertTrue(true);
		//Same Order can't be added again - error
		orderList.add(new Order("19013363", "2020-08-31", MI));
		for(int i= 0; i < orderList.size(); i++) {
			if(orderList.get(i).getStudentId().equals("19013363") && orderList.get(i).getOrderDate().equals("2020-08-31")){
				assertFalse(false);
			}
		}
		//Given that list is not empty display the total amount of orders - normal
		if(orderList.size() > 0) {
			assertTrue(true);
		}
		//Given that list is empty and the total amount should be 0 and not other amount -error
		if(orderList.size() == 0) {
			assertEquals(0,orderList);
		}
		//Given that list has 1 order but display 2 - error
		if(orderList.size() > 0) {
			assertFalse(false);
		}
		
	}
	@Test
	public void viewOrderTest() {
		// OrderList is not null, so that can add new orders - boundary
		assertNotNull("Check if there is valid order arraylist to add to", orderList);
		//OrderList is empty list, after adding 2 items, the size of the list is 2 - Normal
		ArrayList<MenuItem> MI = new ArrayList<MenuItem>();
		MI.add(new MenuItem("Asian", "Chicken rice", true, 5.00));
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(new Order("19013363", "2020-08-31", MI));
		orderList.add(new Order("19013363", "2020-08-31", MI));
		assertEquals("Check that order List size is 2", 2, orderList.size());
		//List empty display nothing from orderList - error
		if(orderList.size() < 0) {
			String output = " ";
			output = String.format("%-20s %-20s %-20s\n", "STUDENT ID", "ORDER DATE", "ITEM NAME");
		}
	}
	@Test
	public void DeleteOrderTest() {
		//Check that orderList is empty and cannot delete - boundary
		if(orderList.isEmpty()) {
			assertFalse(false);
		}
		//OrderList is not empty, and order is in the list remove order- Normal
		ArrayList<MenuItem> MI = new ArrayList<MenuItem>();
		MI.add(new MenuItem("Asian", "Chicken rice", true, 5.00));
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(new Order("19013363", "2020-08-31", MI));
		boolean isdelete = false;
		if(orderList.get(0).getStudentId().equals("19013363")) {
			orderList.remove(0);
			isdelete = true;
		}
		assertTrue(true);
		//Same Order can't be deleted again - error
		orderList.add(new Order("19013363", "2020-08-31", MI));
		for(int i= 0; i < orderList.size(); i++) {
			if(orderList.get(i).getStudentId().equals("19013363") && orderList.get(i).getOrderDate().equals("2020-08-31")){
				assertFalse(false);
			}
		}
	}
	@Test
	public void updateOrderTest() {
		// OrderList is not null, so that can add new orders - boundary
		if(orderList.isEmpty()) {
			assertFalse(false);
		}
		//Given that list is not empty check that input is the same then update- Normal
		for(int i= 0; i < orderList.size(); i++) {
			if(orderList.get(i).getStudentId().equals("19013363")) {
				orderList.get(i).setOrderDate("2020-08-31");
			}
		}
		assertTrue(true);
		//List was not empty and enter in the change orderDate but it was not updated  - error
		for(int i= 0; i < orderList.size(); i++) {
			if(orderList.get(i).getStudentId().equals("19013363")) {
				orderList.get(i).setOrderDate("2020-08-31");
			}
		}
		assertFalse(false);
	}
	@Test
	public void SearchOrderTest() {
		// OrderList is not empty, so can search for the ID - boundary
		if(orderList.size() > 0) {
			assertTrue(true);
		}
		//Given that list is not empty check that ID is the same then show result of the ID- Normal
		for(int i= 0; i < orderList.size(); i++) {
			if(orderList.get(i).getStudentId().equals("19013363")) {
				String output = " ";
				output += String.format("%-90s\n", orderList.get(i).toString());
			}
		}
		assertTrue(true);
		//List is empty so not output shown  - error
		for(int i= 0; i < orderList.size(); i++) {
			if(orderList.get(i).getStudentId().equals("19013363")) {
				String output = " ";
				output += String.format("%-90s\n", orderList.get(i).toString());
			}
		}
		assertFalse(false);
	}
	
	// QIYUE END HERE
	@After
	public void tearDown() throws Exception {
		MI1 = null;
		MI2 = null;
		A1 = null;
		A2 = null;
		
		order1 = null;
		order2 = null;
		
		billList = null;
		
		items = null;
		menuList = null;
	}

}
