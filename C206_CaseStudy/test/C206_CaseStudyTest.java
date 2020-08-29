import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private MenuItem MI1;
	private MenuItem MI2;
	private Account a1;
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
		a1 = new Account("USERNAME", "USERROLE", "CONTACT NUMBER", "STUDENTID");

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
		assertFalse("Ensure that menu is not created due to empty menu name", emptyName);
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
		// The bill just added is the same as the first item of the list//
		assertEquals("Check that Bill arraylist size is 1", 1, billList.size());
		assertSame("Check that Bill is added", billnew, billList.get(0));

		// Add another bill. Test The size of the list is 2 -normal condition//
		// The bill just added is the same as the second item of the list
	}

	@Test
	public void searchBill() {
		assertNotNull("Test if there is valid Bill arraylist to retrieve item", billList);
		// SchoolLunchBox_App.createBill(billList, billNew);
		assertEquals("Check that Bill arraylist size is 1", 1, billList.size());
		assertSame("Check that bill is added", billList, billList.get(0));

		String actualOutput = SchoolLunchBox_App.searchBill(billList);
		String output = SchoolLunchBox_App.viewBill(billList);
		assertEquals("Check that search returns correct bill", output, actualOutput);

	}

	@Test
	public void updateBill() {
		assertNotNull("Test if there is valid Bill arraylist to retrieve item", billList);


		assertEquals("Check that Bill arraylist size is 1", 1, billList.size());
		assertSame("Check that bill is added", billList, billList.get(0));

	}
	// Ashleigh ENDS HERE//

	// QIYUE START HERE
	@Test
	public void CreateOrderTest() {
		// OrderList is not null, so that can add new orders - boundary
		assertNotNull("Check if there is valid order arraylist to add to", orderList);
		// Order List is empty list, after adding 1 item, the size of the list is 1 -
		// Normal
		ArrayList<MenuItem> MI = new ArrayList<MenuItem>();
		MI.add(new MenuItem("Asian", "Chicken rice", true, 5.00));
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(new Order("19013363", "2020-08-31", MI));
		assertEquals("Check that order List size is 1", 1, orderList.size());
		assertTrue(true);
		// Same Order can't be added again - error
		orderList.add(new Order("19013363", "2020-08-31", MI));
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getStudentId().equals("19013363")
					&& orderList.get(i).getOrderDate().equals("2020-08-31")) {
				assertFalse(false);
			}
		}
		// Given that list is not empty display the total amount of orders - normal
		if (orderList.size() > 0) {
			assertTrue(true);
		}
		// Given that list is empty and the total amount should be 0 and not other
		// amount -error
		if (orderList.size() == 0) {
			assertEquals(0, orderList);
		}
		// Given that list has 1 order but display 2 - error
		if (orderList.size() > 0) {
			assertFalse(false);
		}

	}

	@Test
	public void viewOrderTest() {
		// OrderList is not null, so that can add new orders - boundary
		assertNotNull("Check if there is valid order arraylist to add to", orderList);
		// OrderList is empty list, after adding 2 items, the size of the list is 2 -
		// Normal
		ArrayList<MenuItem> MI = new ArrayList<MenuItem>();
		MI.add(new MenuItem("Asian", "Chicken rice", true, 5.00));
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(new Order("19013363", "2020-08-31", MI));
		orderList.add(new Order("19013363", "2020-08-31", MI));
		assertEquals("Check that order List size is 2", 2, orderList.size());
		// List empty display nothing from orderList - error
		if (orderList.size() < 0) {
			String output = " ";
			output = String.format("%-20s %-20s %-20s\n", "STUDENT ID", "ORDER DATE", "ITEM NAME");
		}
	}

	@Test
	public void DeleteOrderTest() {
		// Check that orderList is empty and cannot delete - boundary
		if (orderList.isEmpty()) {
			assertFalse(false);
		}
		// OrderList is not empty, and order is in the list remove order- Normal
		ArrayList<MenuItem> MI = new ArrayList<MenuItem>();
		MI.add(new MenuItem("Asian", "Chicken rice", true, 5.00));
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(new Order("19013363", "2020-08-31", MI));
		boolean isdelete = false;
		if (orderList.get(0).getStudentId().equals("19013363")) {
			orderList.remove(0);
			isdelete = true;
		}
		assertTrue(true);
		// Same Order can't be deleted again - error
		orderList.add(new Order("19013363", "2020-08-31", MI));
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getStudentId().equals("19013363")
					&& orderList.get(i).getOrderDate().equals("2020-08-31")) {
				assertFalse(false);
			}
		}
	}

	@Test
	public void updateOrderTest() {
		// OrderList is not null, so that can add new orders - boundary
		if (orderList.isEmpty()) {
			assertFalse(false);
		}
		// Given that list is not empty check that input is the same then update- Normal
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getStudentId().equals("19013363")) {
				orderList.get(i).setOrderDate("2020-08-31");
			}
		}
		assertTrue(true);
		// List was not empty and enter in the change orderDate but it was not updated -
		// error
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getStudentId().equals("19013363")) {
				orderList.get(i).setOrderDate("2020-08-31");
			}
		}
		assertFalse(false);
	}

	@Test
	public void SearchOrderTest() {
		// OrderList is not empty, so can search for the ID - boundary
		if (orderList.size() > 0) {
			assertTrue(true);
		}
		// Given that list is not empty check that ID is the same then show result of
		// the ID- Normal
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getStudentId().equals("19013363")) {
				String output = " ";
				output += String.format("%-90s\n", orderList.get(i).toString());
			}
		}
		assertTrue(true);
		// List is empty so not output shown - error
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getStudentId().equals("19013363")) {
				String output = " ";
				output += String.format("%-90s\n", orderList.get(i).toString());
			}
		}
		assertFalse(false);
	}

	// QIYUE END HERE

	// Wei Kiat start
	@Test
	public void createMenuItem() {
		// items is not null, so can add new Menu Item - error condition
		assertNotNull("Check if there is a valid Menu Item arrayList to add to", items);
		// test if the menu items is created successfullly - normal
		C206_CaseStudy.createItem(items);
		assertSame("Check that menu item is created", MI1.getName(), items.get(0).getName());
		// test if menu item name is empty - error
		MI1 = new MenuItem("Western", "", false, 2.40);
		boolean emptyName = C206_CaseStudy.createItem(items, MI1);
		assertFalse("Ensure that menu item is not created due to the name being empty", emptyName);
	}

	@Test
	public void viewMenuItem() {
		// test that user can view menu items - normal
		C206_CaseStudy.createItem(items, MI1);
		C206_CaseStudy.createItem(items, MI2);
		assertEquals("Test that menu item arrayList size is 2", 2, items.size());
		// test that user cannot view menu items due to the arrayList being empty -
		// error
		items.clear();
		assertEquals("Test that menu item cannot be view due to empty list", 0, items.size());
		// test that user cannot view menu items due to incorrect search of name - error
		String name = Helper.readString("Search Name: ");
		C206_CaseStudy.createItem(items, MI1);
		assertNotEquals("Test that menu item cannot be view due to incorrect search of name", name,
				items.get(0).getName());
	}

	@Test
	public void deleteMenuItem() {
		// test that user can delete menu item - normal
		C206_CaseStudy.createItem(items, MI1);
		boolean isDeleted = C206_CaseStudy.deleteItem(items, MI1);
		assertTrue("Test that the menu item has been deleted successfully", isDeleted);
		// test that the menu item cannot be deleted due to the menu item not existing -
		// error
		C206_CaseStudy.createItem(items, MI1);
		String name = "Alibaba";
		assertNotEquals("Test that the menu item cannot be deleted due to the menu item not existing",
				items.get(0).getName(), name);
		// test that the menu item cannot be deleted due to the search field being empty
		// - error
		C206_CaseStudy.createItem(items, MI1);
		String name2 = "";
		assertNotEquals("Test that the menu item cannot be deleted due to the search field being empty",
				items.get(0).getName(), name2);
	}

	@Test
	public void updateMenuItem() {
		// test that user can update menu item - normal
		C206_CaseStudy.createItem(items, MI1);
		boolean isUpdated = C206_CaseStudy.updateItem(items, MI1);
		assertTrue("Test that the menu item has been successfully updated", isUpdated);
		// test that user cannot update menu item since search field is empty - error
		C206_CaseStudy.createItem(items, MI1);
		String name = "";
		assertNotEquals("Test that the menu item cannot be updated since search field is empty", items.get(0).getName(),
				name);
		// test that user cannot update menu item since menu item not found - error
		C206_CaseStudy.createItem(items, MI1);
		String name2 = "Alibaba";
		assertNotEquals("Test that user cannot upate menu item since menu item not found", name,
				items.get(0).getName());
	}
	// Wei Kiat end

	@After
	public void tearDown() throws Exception {
		MI1 = null;
		MI2 = null;
		a1 = null;
		order1 = null;
		order2 = null;

		items = null;
		menuList = null;
	}

	@Test
	  public void addAccounttest() { // sharan starts here
	    // Check if the list is not null but empty boundary

	    assertNotNull("Check for valid arraylist", accountList);
	    // Having added an item to an empty list, test if the list size is 1
	    C206_CaseStudy.addAccount(accountList, a1);
	    // Add an item and test if ArrayList has a size of 1
	    assertEquals("Check if arraylist size is 1" , 1, accountList.size());
	  }
	  
	  
	  @Test
	  public void retrieveAccounttest() {
	    
	    // Remove customer according to the list. Check if planned output String is the same as retrieved package list
	    String output = String.format("%-10s %-20s %-10s %-10s %-20s\n", "USERNAME", "USERROLE", "CONTACT NUMBER", "STUDENTID");
	    addAccounttest();
	    // Check if output string is similar to the received list
	    assertEquals("checks if its retrieved properly", output, C206_CaseStudy.retrieveAllAccount(accountList));

	  }
	  @Test
	  public void viewAccounttest() {
	    // Given an empty list, check if the list size is 2 after adding 2 products(Normal)
	    addAccounttest();

	    String output = C206_CaseStudy.retrieveAllAccount(accountList);
	    // Test if the predicted output String is the same as the retrieved list
	    assertEquals("Checks if view all is working properly.", output, C206_CaseStudy.retrieveAllAccount(accountList));
	  }
	  @Test
	  public void deleteAccount() {
	    
	    assertNotNull("Test if there is valid Request Quotation arraylist to retrieve item", accountList);
	    // Check if the list size is 1 given an empty list after deleting 1 customer
	    C206_CaseStudy.deleteAccount(accountList, "Account");
	    C206_CaseStudy.deleteAccount(accountList,"USERNAME");
	    assertEquals("Checks if deleted properly,", 0, accountList.size());
	  } //Sharan ends here
}
