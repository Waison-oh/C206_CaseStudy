import java.util.ArrayList;

public class C206_CaseStudy {

	/**
	 * 
	 */
	private static final int OPTION_MENUITEM = 7;
	private static final int OPTION_BILL = 5;
	private static final int OPTION_EDIT = 4;
	private static final int OPTION_BUY = 3;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_MENU = 1;
	private static final int OPTION_EXIT = 6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();

		ArrayList<Bill> billList = new ArrayList<Bill>();

		ArrayList<Menu> menuList = new ArrayList<Menu>();
		ArrayList<Order> orderList = new ArrayList<Order>();

		items.add(new MenuItem("Japanese", "Sushi", true, 3.5));

		items.add(new MenuItem("Japanese", "Sushi", true, 3.50));

		int option = 0;

		while (option != OPTION_EXIT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an Option > ");

			if (option == OPTION_MENU) {
				C206_CaseStudy.viewAllMenu(menuList);
				C206_CaseStudy.viewAllOrder(orderList);
			} else {
				int MENU = 1;
				int ORDER = 2;

				if (option == OPTION_ADD) {
					C206_CaseStudy.setHeader("ADD");
					System.out.println("1. Menu");
					System.out.println("2. Order");

					int itemType = Helper.readInt("Enter option to select item type > ");

					if (itemType == MENU) {
						Menu mu = inputMenu();
						C206_CaseStudy.addMenu(menuList, mu);
					} else if (itemType == ORDER) {
						Order od = inputOrder();
						C206_CaseStudy.addOrder(orderList, od);
					} else {
						System.out.println("INVALID TYPE!!");
					}
				} else if (option == OPTION_BUY) {
					C206_CaseStudy.setHeader("ORDER");

					int itemType = ORDER;
					C206_CaseStudy.buyOrder(orderList);
				} else if (option == OPTION_EDIT) {
					C206_CaseStudy.setHeader("EDIT");
					C206_CaseStudy.setHeader("ITEM TYPES");
					System.out.println("1. MENU");
					System.out.println("2. ORDER");

					int itemType = Helper.readInt("Enter option to select item type > ");
					if (itemType == MENU) {
						C206_CaseStudy.editMenu(menuList);
					} else if (itemType == ORDER) {
						C206_CaseStudy.editOrder(orderList);
					} else {
						System.out.println("INVALID TYPE!!");
					}
				}
				// ASHLEIGH STARTS HERE - BILL//
				else if (option == OPTION_BILL) {
					int CREATE = 1;
					int VIEW = 2;
					int DELETE = 3;
					C206_CaseStudy.setHeader("BILL");
					System.out.println("1. Create bill");
					System.out.println("2. View bill");
					System.out.println("3. Delete bill");

					int actions = Helper.readInt("Enter option here > ");

					if (actions == CREATE) {
						String payee = Helper.readString("Enter payee name > ");
						double amount = Helper.readDouble("Enter amount > ");
						String dueDate = Helper.readString("Enter due date > ");
						Bill newBill = new Bill(payee, amount, dueDate);
						billList.add(newBill);
					} else if (actions == VIEW) {
						billList.toString();
					} else if (actions == DELETE) {
						C206_CaseStudy.deleteBill(billList);
					} else {
						System.out.println("INVALID OPTION!!");
					}
				} else if (option == OPTION_MENUITEM) {
					System.out.println("1. View Menu Item");
					System.out.println("2. Create Menu Item");
					System.out.println("3. Delete Menu Item");

					int choice = Helper.readInt("Enter choice: ");
					if (choice == 1) {
						C206_CaseStudy.viewItem(items);
					} else if (choice == 2) {
						C206_CaseStudy.addItem();
					} else if (choice == 3) {
						C206_CaseStudy.deleteItem(items);
					} else {
						System.out.println("Incorrect option");
					}
				} else if (option == OPTION_EXIT) {
					System.out.println("GOODBYE!!");
				} else {
					System.out.println("INVALID OPTION!!");
				}
			} // ASHLEIGH ENDS HERE//
		}
	}

	private static void editOrder(ArrayList<Order> orderList) {
		// TODO Auto-generated method stub

	}

	private static void addOrder(ArrayList<Order> orderList, Order od) {
		// TODO Auto-generated method stub
		int size = orderList.size();
		orderList.add(od);
		if (orderList.size() != 0) {
			System.out.println("Successfully added");
		} else {
			System.out.println("Add fail");
		}

	}

	private static void buyOrder(ArrayList<Order> orderList) {
		// TODO Auto-generated method stub

	}

	private static Order inputOrder() {
		// TODO Auto-generated method stub
		String category = Helper.readString("Which category is this menu item in? ");
		String name = Helper.readString("Enter menu item name: ");
		boolean choice = Helper.readBoolean("Is this menu item a healthy choice?(true/false");
		double price = Helper.readDouble("Price of menu item: ");

		MenuItem newMenuItem = new MenuItem(category, name, choice, price);

		String studentID = Helper.readString("Enter your student ID: ");
		String orderDate = Helper.readString("Enter the date of order: ");

		return null;
	}

	// =================================================================================
	private static void editMenu(ArrayList<Menu> menuList) {
		// TODO Auto-generated method stub

	}

	private static void addMenu(ArrayList<Menu> menuList, Menu mu) {
		// TODO Auto-generated method stub
		int size = menuList.size();
		menuList.add(mu);
		if (menuList.size() != 0) {
			System.out.println("Successfully added");
		} else {
			System.out.println("Add fail");
		}

	}

	private static Menu inputMenu() {
		// TODO Auto-generated method stub
		String category = Helper.readString("Which category is this menu item in? ");
		String name = Helper.readString("Enter menu item name: ");
		boolean choice = Helper.readBoolean("Is this menu item a healthy choice?(true/false");
		double price = Helper.readDouble("Price of menu item: ");

		MenuItem newMenuItem = new MenuItem(category, name, choice, price);

		String displayName = Helper.readString("Enter display name: ");
		int month = Helper.readInt("Which month is this available? ");
		int amount = Helper.readInt("How many number of items are there? ");

		return null;
	}

	private static void setHeader(String header) {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static void menu() {
		C206_CaseStudy.setHeader("SCHOOL LUNCH BOX");
		System.out.println("1. Display Menu");
		System.out.println("2. Add item");
		System.out.println("3. Buy item");
		System.out.println("4. Edit item");

		System.out.println("5. Bill");
		System.out.println("6. Exit");
		System.out.println("7. Menu Item");
		Helper.line(80, "=");

		System.out.println("5. Exit");
		Helper.line(80, "=");

	}

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}

	// OPTION 1 ============================================================ DISPLAY
	// MENU//
	public static String getAllMenu(ArrayList<Menu> menuList) {
		String output = "";

		for (int i = 0; i < menuList.size(); i++) {
			output += String.format("-90s\n", menuList.get(i).toString());
		}
		return output;
	}

	public static void viewAllMenu(ArrayList<Menu> menuList) {
		String output = String.format("%-10s %-30s %-10s %-20s %-20s %-30s\n", "TAG NO.", "NAME", "AVAILABLE",
				"DISPLAY NAME", "MONTH", "NUMBER OF OFFERS");
		output += getAllMenu(menuList);
		System.out.println(output);
	}

	public static void createMenu(ArrayList<Menu> menuList) {

	}

	public static void deleteMenu(ArrayList<Menu> menuList) {

	}

	public static String getAllOrder(ArrayList<Order> orderList) {
		String output = "";

		for (int i = 0; i < orderList.size(); i++) {
			output += String.format("%-90s\n", orderList.get(i).toString());
		}
		return output;
	}

	public static void viewAllOrder(ArrayList<Order> orderList) {
		C206_CaseStudy.setHeader("ORDER LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-30s %-30s\n", "TAG NO.", "NAME", "AVAILABLE",
				"STUDENT ID", "STUDENT NAME", "ORDER DATE");
		output += getAllOrder(orderList);
		System.out.println(output);
	}

	// OPTION 2 =========================================================== ADD
	// ITEM//
	// Wei Kiat start//
	public static void addItem() {
		String newcategory = Helper.readString("Enter new category for new menu item: ");
		String newName = Helper.readString("Enter new name for new menu item: ");
		boolean healthy = Helper.readBoolean("Is the new menu item a healthy choice?(true/false) ");
		double newPrice = Helper.readDouble("Enter price for new menu item: ");

		MenuItem newItem = new MenuItem(newcategory, newName, healthy, newPrice);
	}

	// OPTION 3 =========================================================== BUY
	// ITEM//
	public static void viewItem(ArrayList<MenuItem> items) {
		String output = String.format("%-10s %-10s %-10b %-10.2f\n", "Category", "Name", "Healthy Choice", "Price");
		for (int i = 0; i < items.size(); i++) {
			output += String.format("%-10s %-10s %-10b %-10.2f\n", items.get(i).getCategory(), items.get(i).getName(),
					items.get(i).isHealthyChoice(), items.get(i).getPrice());
		}
		System.out.println(output);
	}

	// OPTION 4 ========================================================== EDIT
	// ITEM//
	public static void deleteItem(ArrayList<MenuItem> items) {
		String name = Helper.readString("Enter menu item name: ");
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName() == name) {
				items.remove(i);
				System.out.println("Menu Item deleted");
			} else {
				System.out.println("Menu Item not found");
			}
		}

	}

	// Wei Kiat end//
	// OPTION 5 ===============================================================
	// BILL//
	// ASHLEIGH STARTS HERE - DELETE BILL//
	public static void deleteBill(ArrayList<Bill> billList) {
		C206_CaseStudy.setHeader("DELETE BILL");

		boolean valid = false;
		while (valid != true) {
			String payee = Helper.readString("Enter payee name > ");
			for (int i = 0; i < billList.size(); i++) {
				if (payee == billList.get(i).getPayee()) {
					billList.remove(i);
					System.out.println("Bill Deleted!");
				}
			}
			if (valid == false) {
				System.out.println("Payee does not exist!! \n");
			}
		}
	}
	// ASHLEIGH ENDS HERE//

}
