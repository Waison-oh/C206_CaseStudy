import java.util.ArrayList;

public class C206_CaseStudy {

	/**
	 * 
	 */

	private static final int OPTION_BILL = 5;
	private static final int OPTION_MONTHLYMENU = 4;
	private static final int OPTION_ORDER = 3;
	private static final int OPTION_ACCOUNT = 2;
	private static final int OPTION_MENU = 1;
	private static final int OPTION_EXIT = 6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Menu> menuList = new ArrayList<Menu>();
		ArrayList<Account> accountList = new ArrayList<Account>();
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();
		ArrayList<Bill> billList = new ArrayList<Bill>();

		int option = 0;

		while (option != OPTION_EXIT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an Option > ");

			// WEI KIAT STARTS HERE - MENU//
			if (option == OPTION_MENU) {
				C206_CaseStudy.setHeader("MENU");
				int CREATE = 1;
				int VIEW = 2;
				int DELETE = 3;
				System.out.println("1. Create menu");
				System.out.println("2. View menu");
				System.out.println("3. Delete menu");

				int action = Helper.readInt("Enter option here > ");

				if (action == CREATE) {
					C206_CaseStudy.createItem(items);
				}

				else if (action == VIEW) {
						C206_CaseStudy.viewAllMenuItems(items); 
				}

				else if (action == DELETE) {
					C206_CaseStudy.deleteMenuItems(items);
				}

				else {
					System.out.println("INVALID OPTION!!");
				}
			} // WEI KIAT ENDS HERE - MENU//

			// SHARAN STARTS HERE - ACCOUNT//
			else if (option == OPTION_ACCOUNT) {
				C206_CaseStudy.setHeader("ACCOUNT");
				int CREATE = 1;
				int VIEW = 2;
				int DELETE = 3;
				System.out.println("1. Create account");
				System.out.println("2. View account");
				System.out.println("3. Delete account");

				int action = Helper.readInt("Enter option here > ");

				if (action == CREATE) {
					C206_CaseStudy.createAccount(accountList);
				}

				else if (action == VIEW) {
					C206_CaseStudy.viewAllAccount(accountList);
				}

				else if (action == DELETE) {
					C206_CaseStudy.deleteAccount(accountList);
				}

				else {
					System.out.println("INVALID OPTION!!");
				}
			} // SHARAN ENDS HERE - ACCOUNT//

			// QI YUE STARTS HERE - ORDER//
			else if (option == OPTION_ORDER) {
				C206_CaseStudy.setHeader("ORDER");
				int CREATE = 1;
				int VIEW = 2;
				int DELETE = 3;
				System.out.println("1. Create order");
				System.out.println("2. View order");
				System.out.println("3. Delete order");

				int action = Helper.readInt("Enter option here > ");

				if (action == CREATE) {
					C206_CaseStudy.createOrder(orderList);
				}

				else if (action == VIEW) {
					C206_CaseStudy.viewAllOrder(orderList);
				}

				else if (action == DELETE) {
					C206_CaseStudy.deleteOrder(orderList);
				}

				else {
					System.out.println("INVALID OPTION!!");
				}
			} // QI YUE ENDS HERE - ORDER//

			// QIAO LING STARTS HERE - MONTHLY MENU//
			else if (option == OPTION_MONTHLYMENU) {
				int CREATE = 1;
				int VIEW = 2;
				int DELETE = 3;
				C206_CaseStudy.setHeader("MONTHLY MENU");
				System.out.println("1. Create monthly menu");
				System.out.println("2. View monthly menu");
				System.out.println("3. Delete monthly menu");

				int action = Helper.readInt("Enter option here > ");

				if (action == CREATE) {
					C206_CaseStudy.createMenu();
				} else if (action == VIEW) {
					C206_CaseStudy.viewAllMenu(menuList);
				} else if (action == DELETE) {
					C206_CaseStudy.deleteMenu(menuList);
				} else {
					System.out.println("INVALID OPTION!!");
				}
			} // QIAO LING ENDS HERE - MONTHLY MENU//

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
					C206_CaseStudy.createBill(billList);
				} else if (actions == VIEW) {
					billList.toString();
				} else if (actions == DELETE) {
					C206_CaseStudy.deleteBill(billList);
				} else {
					System.out.println("INVALID OPTION!!");
				} // ASHLEIGH ENDS HERE - BILL//
			} else if (option == OPTION_EXIT) {
				System.out.println("GOODBYE!!");
			} else {
				System.out.println("INVALID OPTION!!");
			}
		}
	}

	// =================================================================================
	// //

	private static void setHeader(String header) {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static void menu() {
		C206_CaseStudy.setHeader("SCHOOL LUNCH BOX");

		System.out.println("1. Menu");
		System.out.println("2. Account");
		System.out.println("3. Order");
		System.out.println("4. Monthly Menu");
		System.out.println("5. Bill");
		System.out.println("6. Exit");
		System.out.println("7. Menu Item");
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
		C206_CaseStudy.setHeader("CREATE ACCOUNT");
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

	

	private static void createOrder(ArrayList<Order> orderList) {
		C206_CaseStudy.setHeader("CREATE ORDER");
		
		String studentId =Helper.readString("Enter student id> ");
		String orderDate =Helper.readString("Enter order date> ");
		ArrayList<MenuItem> item = null;
		
		Order newOrder = new Order(studentId, orderDate, item ); 
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
	
	private static void deleteOrder(ArrayList<Order> orderList) {
		C206_CaseStudy.setHeader("DELETE ORDER");

		boolean valid = false;
		while (valid != true) {
			String studentId = Helper.readString("Enter student id > ");
			for (int i = 0; i < orderList.size(); i++) {
				if (studentId == orderList.get(i).getStudentId()) {
					orderList.remove(i);
					System.out.println("Order Deleted!");
				}
			}
			if (valid == false) {
				System.out.println("Order does not exist!! \n");
			}
		}
	}

	public static void viewAllOrder(ArrayList<Order> orderList) {
		C206_CaseStudy.setHeader("ORDER LIST");
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
		C206_CaseStudy.setHeader("CREATE BILL");
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
			output = billList.get(i).toString();
		}
		return output;
	}

	// DELETE BILL//
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
