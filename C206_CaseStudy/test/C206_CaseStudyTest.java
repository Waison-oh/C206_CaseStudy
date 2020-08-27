import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	/* ArrayList<Menu> menuList = new ArrayList<Menu>();
	ArrayList<Account> accountList = new ArrayList<Account>();
	ArrayList<Order> orderList = new ArrayList<Order>();
	ArrayList<MenuItem> items = new ArrayList<MenuItem>();
	ArrayList<Bill> billList = new ArrayList<Bill>();

	// OPTION 1 =========================================================== MENU//
	// Wei Kiat start//
	public static void createItem(ArrayList<MenuItem> items) {
	
		String newCategory = Helper.readString("Enter new Menu Item category (Western/Asian/Vegetarian):  ");
		String newName = Helper.readString("Enter new Menu Item name: ");
		boolean newHealthy = Helper.readBoolean("Is this new Menu Item a healthy choice?(true/false) ");
		double newPrice = Helper.readDouble("Enter price for new Menu Item: ");
	
		items.add(new MenuItem(newCategory, newName, newHealthy, newPrice));
	
		System.out.println("Menu added!!");
	
	}
	
	public static String viewAllMenuItems(ArrayList<MenuItem> items) {
		String output = null;
		for (int i = 0; i < items.size(); i++) {
			output = items.get(i).toString();
		}
		return output;
	}
	
	public static void deleteMenuItems(ArrayList<MenuItem> items) {
		String name = Helper.readString("Enter the menu item name: ");
		for (int i = 0; i < items.size(); i++) {
			if (name == items.get(i).getName()) {
				items.remove(i);
			} else {
				System.out.println("Menu Item does not exist");
			}
		}
	}
	
	// Wei Kiat end//
	
	// OPTION 2 ===========================================================
	// ACCOUNT//
	// Sharan start//
	public static void createAccount(ArrayList<Account> accountList) {
		String username = Helper.readString("Enter username > ");
		String password = Helper.readString("Enter password > ");
		String contactNumber = Helper.readString("Enter Contact Number > ");
		String userRole = Helper.readString("Enter User Role > ");
	
		Account newAccount = new Account(username, contactNumber, password, userRole);
		accountList.add(newAccount);
		System.out.println("Account Created");
	}
	
	public static String viewAllAccount(ArrayList<Account> accountList) {
		String output = null;
		for (int i = 0; i < accountList.size(); i++) {
			output = accountList.get(i).toString();
		}
		return output;
	}
	
	public static void deleteAccount(ArrayList<Account> accountList) {
		boolean valid = false;
		while (valid != true) {
			String username = Helper.readString("Enter username > ");
			for (int i = 0; i < accountList.size(); i++) {
				if (username == accountList.get(i).getUsername()) {
					accountList.remove(i);
					System.out.println("User Deleted!");
				}
			}
		}
		if (valid == false) {
			System.out.println("Username does not exist.");
		}
	}
	// Sharan end//
	
	// OPTION 3 =============================================================
	// ORDER//
	// Qi Yue start//
	
	private static void deleteOrder(ArrayList<Order> orderList) {
		boolean valid = false;
		while (valid != true) {
			String studentId = Helper.readString("Enter student ID of order > ");
			for (int i = 0; i < orderList.size(); i++) {
				if (studentId == orderList.get(i).getStudentId()) {
					orderList.remove(i);
					System.out.println("Order Deleted!");
				}
			}
		}
		if (valid == false) {
			System.out.println("Student ID does not exist.");
		}
	}
	
	private static void createOrder(ArrayList<Order> orderList) {
		// TODO Auto-generated method stub
		String studentId = Helper.readString("Enter student ID > ");
		String orderDate = Helper.readString("Enter order date > ");
		
		String newCategory = Helper.readString("Enter new Menu Item category (Western/Asian/Vegetarian):  ");
		String newName = Helper.readString("Enter new Menu Item name: ");
		boolean newHealthy = Helper.readBoolean("Is this new Menu Item a healthy choice?(true/false) ");
		double newPrice = Helper.readDouble("Enter price for new Menu Item: ");
		
		MenuItem newMenu = new MenuItem(newCategory, newName, newHealthy, newPrice); 
		ArrayList<MenuItem> items = new ArrayList<MenuItem>(); 
		items.add(newMenu); 
		
		Order newOrder = new Order(studentId, orderDate, items);
		orderList.add(newOrder);
		System.out.println("Order added!");
	}
	
	public static String getAllOrder(ArrayList<Order> orderList) {
		String output = "";
	
		for (int i = 0; i < orderList.size(); i++) {
			output += String.format("%-90s\n", orderList.get(i).toString());
		}
		return output;
	}
	
	public static void viewAllOrder(ArrayList<Order> orderList) {
		String output = String.format("%-10s %-30s %-10s %-10s %-30s %-30s\n", "TAG NO.", "NAME", "AVAILABLE",
				"STUDENT ID", "STUDENT NAME", "ORDER DATE");
		output += getAllOrder(orderList);
		System.out.println(output);
	}
	// Qi Yue end//
	
	// OPTION 4 ========================================================== MONTHLY
	// MENU//
	// Qiao Ling start//
	public static void createMenu() {
	
	}
	
	public static String getAllMenu(ArrayList<Menu> menuList) {
		String output = "";
	
		for (int i = 0; i < menuList.size(); i++) {
			output += String.format("%-90s\n", menuList.get(i).toString());
		}
		return output;
	}
	
	public static void viewAllMenu(ArrayList<Menu> menuList) {
		String output = String.format("%-10s %-30s %-10s %-20s %-20s %-30s\n", "TAG NO.", "NAME", "AVAILABLE",
				"DISPLAY NAME", "MONTH", "NUMBER OF OFFERS");
		output += getAllMenu(menuList);
		System.out.println(output);
	}
	
	public static void deleteMenu(ArrayList<Menu> menuList) {
	
	}
	// Qiao Ling end//
	
	// OPTION 5 ===============================================================
	// BILL//
	// ASHLEIGH STARTS HERE//
	// CREATE BILL//
	public static void createBill(ArrayList<Bill> billList) {
		String payee = Helper.readString("Enter payee name > ");
		double amount = Helper.readDouble("Enter total amount > ");
		String due = Helper.readString("Enter due date > ");
	
		Bill newBill = new Bill(payee, amount, due);
		billList.add(newBill);
		System.out.println("Bill added!");
	}
	
	// VIEW BILL//
	public static String viewBill(ArrayList<Bill> billList) {
		String output = null;
		for (int i = 0; i < billList.size(); i++) {
			output += billList.get(i).toString();
		}
		return output;
	}
	
	// DELETE BILL//
	public static void deleteBill(ArrayList<Bill> billList) {
		String payee = Helper.readString("Enter payee name > ");
		for (int i = 0; i < billList.size(); i++) {
			if (payee == billList.get(i).getPayee()) {
				billList.remove(i);
				System.out.println("Bill Deleted!");
			}
			else if (payee != billList.get(i).getPayee()) {
				System.out.println("Payee does not exist!!");
			}
			else {
				System.out.println("INVALID INPUT!!");
			}
		}
	}
	// UPDATE BILL//
	public static void updateBill(ArrayList<Bill> billList) {
		String payee = Helper.readString("Enter payee name to update > ");
		for (int i = 0; i < billList.size(); i++) {
			if (payee == billList.get(i).getPayee()) {
				double amount = Helper.readDouble("Enter updated amount > ");
				String dueDate = Helper.readString("Enter due date > "); 
				boolean isPaid = Helper.readBoolean("Is it paid? (true/false) > ");
				
				billList.get(i).setTotalAmount(amount);
				billList.get(i).setDueDate(dueDate);
				billList.get(i).setPaid(isPaid); 
				
				System.out.println("Payee Updated!!");
			}
			else if (payee != billList.get(i).getPayee()) {
				System.out.println("Payee does not exist!!");
			}
			else {
				System.out.println("INVALID INPUT!!");
			}
		}
	}
	
	//SEARCH BILL//
	public static String searchBill(ArrayList<Bill> billList) {
		String output = null;
		String payee = Helper.readString("Enter payee name > "); 
		for (int i = 0; i < billList.size(); i++) {
			if (payee == billList.get(i).getPayee()) {
				output += billList.get(i).toString(); 
			}
		}
		return output;
	}
	// ASHLEIGH ENDS HERE//
	 
	 */
	
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
	private ArrayList<Order> orderList ;
	private ArrayList<MenuItem> items ;
	private ArrayList<Bill> billList ;

	public C206_CaseStudyTest() {
		super();
	}
	@Before
	public void setUp() throws Exception {
		//fill in respectively, thanksss
		MI1 = new MenuItem(null, null, false, 0);
		MI2 = new MenuItem(null, null, false, 0);
		
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
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}
	

	@Test
	public void createMenuTest() {
				
		// test if the menu is created - normal
		C206_CaseStudy.createMenu(menuList, monthMenu);
		assertSame("Check that menu is create", monthMenu.getDisplayName(), menuList.get(0).getDisplayName());

		//test if the menu is not created due to duplicated name - error
		
		C206_CaseStudy.createMenu(menuList, monthMenu);
		monthMenu1 = new Menu("Jan menu", 2, 1, items);
		boolean isCreated = C206_CaseStudy.createMenu(menuList, monthMenu1);
		
		assertEquals("Check that menu has the same menu name",menuList.get(0).getDisplayName(),monthMenu1.getDisplayName());
		assertFalse("Ensure that menu is not created due to duplicated name",isCreated);
		
		//test if the menu name is empty - error
		monthMenu1 = new Menu("", 2, 1, items);
		boolean emptyName = C206_CaseStudy.createMenu(menuList, monthMenu1);
		assertFalse("Ensure that menu is not created due to empty menu name",emptyName);
	}	

	@Test
	public void viewMenuTest() {
		//test that if user can view the menu - normal
		C206_CaseStudy.createMenu(menuList, monthMenu);
		C206_CaseStudy.createMenu(menuList, monthMenu1);
		assertEquals("Test that menu arrayList size is 2", 2, menuList.size());
		
		//test that user cannot view the menu due to there is no menu inside the list - error
		menuList.clear();
		assertEquals("Test that menu cannot be view due to empty List",0,menuList.size());

	}
	

	@Test
	public void deleteMenuTest() {
		

	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	
	}

