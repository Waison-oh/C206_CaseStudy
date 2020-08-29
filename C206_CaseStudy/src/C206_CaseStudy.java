//NOT THE MAIN CLASS//

import java.util.ArrayList;

public class C206_CaseStudy {

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
				int UPDATE = 4;
				System.out.println("1. Create menu");
				System.out.println("2. View menu");
				System.out.println("3. Delete menu");
				System.out.println("4. Update menu");

				int action = Helper.readInt("Enter option here > ");

				if (action == CREATE) {
					C206_CaseStudy.createItem(items);
				}

				else if (action == VIEW) {
					System.out.println("1. Show menu items");
					System.out.println("2. Search by menu item name");
					System.out.println("3. Search by category");
					int choice = Helper.readInt("Enter the choice: ");
					if (choice == 1) {
						C206_CaseStudy.viewAllMenuItems(items);
					} else if (choice == 2) {
						C206_CaseStudy.searchByName(items);
					} else if (choice == 3) {
						C206_CaseStudy.searchByCategory(items);

					}

				}

				else if (action == DELETE) {
					C206_CaseStudy.deleteMenuItems(items);

				}

				else if (action == UPDATE) {

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
				Account au = inputAccount();
				C206_CaseStudy.addAccount(accountList, au);
					
				}

				else if (action == VIEW) {
					C206_CaseStudy.viewAccount(accountList);
				}

				else if (action == DELETE) {
					C206_CaseStudy.deleteAccount(accountList, "username");
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
				int UPDATE = 4;
				int SEARCH = 5;
				System.out.println("1. Create order");
				System.out.println("2. View order");
				System.out.println("3. Delete order");
				System.out.println("4. Update order");
				System.out.println("5.Search order");

				int action = Helper.readInt("Enter option here > ");

				if (action == CREATE) {
					C206_CaseStudy.createOrder(orderList);
				}

				else if (action == VIEW) {
					C206_CaseStudy.viewAllOrder(orderList);
				}

				else if (action == DELETE) {
					C206_CaseStudy.deleteOrder(orderList);
				} else if (action == UPDATE) {
					C206_CaseStudy.updateOrder(orderList);
				} else if (action == SEARCH) {
					C206_CaseStudy.searchOrder(orderList);
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
					C206_CaseStudy.createMenu(items, menuList);
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
		String output = "";
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getPrice() > 0) {
				output = items.get(i).toString();
			} else if (items.get(i).getPrice() == 0.00) {
				output += (items.get(i).getName() + "have a price of $0.00");
			}

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

	public static void updateMenuItems(ArrayList<MenuItem> items) {
		String searchName = Helper.readString("Enter menu item name to update: ");
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName() == searchName) {
				String updateName = Helper.readString("Enter new menu item name: ");
				double price = Helper.readDouble("Enter new menu item price: ");
				items.get(i).setName(updateName);
				items.get(i).setPrice(price);
				System.out.println("Update successful");
			} else {
				System.out.println("The menu item does not exist");
			}
		}
	}

	public static String searchByName(ArrayList<MenuItem> items) {
		String output = "";
		String name = Helper.readString("Enter menu item name: ");
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName() == name) {
				output += items.get(i).toString();
			}
		}
		return output;
	}

	public static String searchByCategory(ArrayList<MenuItem> items) {
		String output = "";
		String category = Helper.readString("Enter category: ");
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getCategory() == category) {
				output += items.get(i).toString();
			}
		}

		return output;
	}

	// Wei Kiat end//

	// OPTION 2 ===========================================================
	// ACCOUNT//
	// Sharan start//
	 public static Account inputAccount() {

		    String username = Helper.readString("Enter username> ");
		    String userRole = Helper.readString("Enter User Role> ");
		    String contactNumber = Helper.readString("Enter Contact Number> ");
		    String studentId = Helper.readString("Enter Student ID> ");
		    
		    Account Acc = new Account(username, userRole, contactNumber, studentId);
		    return Acc;
		  }

		  // Add Account
		  public static void addAccount(ArrayList<Account> accountList, Account Acc) {

		    accountList.add(Acc);
		    System.out.println("Customer added!");
		  }

		  // Retrieve Account
		  public static String retrieveAllAccount(ArrayList<Account> accountList) {

		    String output = "";

		    for (int i = 0; i < accountList.size(); i++) {

		      output += String.format("%-10s %-20s %-10s %-10s %-20s\n", accountList.get(i).getUsername(),accountList.get(i).getUserRole(), 
		    		  accountList.get(i).getContactNumber(), accountList.get(i).getStudentId());
		    }
		    return output;
		  }

		  // View Account
		  public static void viewAccount(ArrayList<Account> accountList) {

		    String output = String.format("%-10s %-20s %-10s %-10s %-20s\n", "USERNAME", "USERROLE", "CONTACT NUMBER", "STUDENTID");
		    output += retrieveAllAccount(accountList);
		    System.out.println(output);
		  }
		  // Delete Account
		  public static void deleteAccount(ArrayList<Account> accountList, String delete) {
			  
		    for (int i = 0; i < accountList.size(); i++) {

		      if (accountList.get(i).getUsername().equals(delete)) {
		    	  accountList.remove(i);
		        System.out.println("Account removed!");
		      }
		    }
		  }
	// Sharan end//

	// OPTION 3 =============================================================
	// ORDER//
	// Qi Yue start//
	
	

	private static void createOrder(ArrayList<Order> orderList) {
		C206_CaseStudy.setHeader("CREATE ORDER");
		
		System.out.println("Current Total Amount Of Orders: " + orderList.size());
		String studentId =Helper.readString("Enter student id> ");
		String orderDate =Helper.readString("Enter order date> ");
		
		ArrayList<MenuItem> item = new ArrayList<MenuItem>();
		// MenuItem add got error so i create a item to show.
		item.add(new MenuItem("Asian", "Chicken rice", true, 5.00));
		Order newOrder = new Order(studentId, orderDate, item); 
		orderList.add(newOrder); 
		System.out.println("Order added!");
	}
	public static Boolean doDeleteOrder(ArrayList<Order> orderList, String studentId) {
		boolean isDelete = false;
		for(int i =0; i < orderList.size(); i++) {
			String id = orderList.get(i).getStudentId();
			if(studentId.equals(id)) {
				orderList.remove(i);
				isDelete = true;
			}
		}
		return isDelete;
	}
	private static void deleteOrder(ArrayList<Order> orderList) {
		C206_CaseStudy.setHeader("DELETE ORDER");
		String studentid = Helper.readString("Enter Student ID: ");
		Boolean isDelete = doDeleteOrder(orderList, studentid);
		if(isDelete == false) {
			System.out.println("Invalid order");
		}
		else {
			System.out.println(studentid + "'s  Order Deleted");
		}
	}
	public static void searchOrder(ArrayList<Order> orderList) {
		C206_CaseStudy.setHeader("Search LIST");
		String output = String.format("%-20s %-20s %-20s\n", "STUDENT ID", "ORDER DATE", "ITEM NAME");
		String ID = Helper.readString("Enter Student ID To Search For: ");
		for (int i = 0; i < orderList.size(); i++) {
			if(orderList.get(i).getStudentId().equals(ID)) {
				output += String.format("%-90s\n", orderList.get(i).toString());
			}else {
				System.out.println("Invalid Student ID entered! ");
			}
		}
		System.out.println(output);
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
		String output = String.format("%-20s %-20s %-20s\n", "STUDENT ID", "ORDER DATE", "ITEM NAME");
		output += getAllOrder(orderList);
		System.out.println(output);
	}

	public static void updateOrder(ArrayList<Order> orderList) {
		String id = Helper.readString("Enter Student ID: ");
		for(int i = 0; i < orderList.size(); i++) {
			if(orderList.get(i).getStudentId().equals(id)) {
				String newOrderDate = Helper.readString("Enter New Order Date: ");
				orderList.get(i).setOrderDate(newOrderDate);
				System.out.println("Order Date Updated");
			}
			else {
				System.out.println("Student ID Invalid");
			}
		}
	}
	// Qi Yue end//

	// OPTION 4 ========================================================== MONTHLY
	// MENU//
	// Qiao Ling start//
	public static void createMenu(ArrayList<MenuItem> items, ArrayList<Menu> monthlyMenu) {
		// hard code item menu for local testing:
		items.add(new MenuItem("Vegetarian", "potato salad", true, 6.70));
		items.add(new MenuItem("Western", "Chicken Chop", false, 8.90));
		String listItem = String.format("%-20s %-20s %-10s %s\n", "Western", "chicken chop", "false", "8.9");
		listItem += String.format("%-20s %-20s %-10s %s\n", "Vegetarian", "potato salad", "true", "6.70");
		System.out.println(listItem);
		//
		boolean isCreated = false;
		String menuName = Helper.readString("Enter the menu name > ");
		while (menuName.equalsIgnoreCase("")) {
			menuName = Helper.readString("Please do not leave menu name blank > ");
			isCreated = false;
		}
		int month = Helper.readInt("Enter the month for this menu >");
		int ItemNum = Helper.readInt("Enter the number of item you want to add >");

		String choose = Helper.readString("Choose item to add > ");
		for (int i = 0; i < items.size(); i++) {
			String name = items.get(i).getName();

			if (choose.equalsIgnoreCase(name)) {

				String category = items.get(i).getCategory();
				boolean healthyChoice = items.get(i).isHealthyChoice();
				double price = items.get(i).getPrice();
				Menu mm = new Menu(menuName, month, ItemNum, items);
				monthlyMenu.add(mm);
				isCreated = true;
				break;
			} else {
				System.out.println("Invalid choice!");
			}

		}

		if (isCreated == true) {
			System.out.println("Menu created!");
		} else {
			System.out.println("Menu not created!");
		}

	}

	public static boolean createMenu(ArrayList<Menu> monthlyMenu, Menu mm) {

		for (int i = 0; i < monthlyMenu.size(); i++) {
			String displayName = mm.getDisplayName();
			if (monthlyMenu.get(i).getDisplayName().equalsIgnoreCase(displayName)) {
				System.out.println("Cannot have duplicate name of menu!");
				return false;
			}
		}
		monthlyMenu.add(mm);
		return true;
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
		if (menuList.isEmpty()) {
			output += "There is no menu";
		} else {
			output += getAllMenu(menuList);
		}

		System.out.println(output);
	}

	public static void deleteMenu(ArrayList<Menu> menuList) {
		boolean isDeleted = false;
		for (int i = 0; i < menuList.size(); i++) {
			String delete = Helper.readString("Enter the name of menu which you want to delete > ");
			if (delete == null) {
				delete = Helper.readString("Please enter an item name! > ");
			} else if (delete.equalsIgnoreCase(menuList.get(i).getDisplayName())) {
				menuList.remove(i);
				isDeleted = true;
			} else {
				System.out.println("The menu is not existing.");
			}
		}
		if (isDeleted == true) {
			System.out.println("Menu removed!");
		} else {
			System.out.println("Menu not found!");
		}
	}

	public static boolean deleteMenu(ArrayList<Menu> monthlyMenu, Menu mm) {
		for (int i = 0; i < monthlyMenu.size(); i++) {
			String displayName = mm.getDisplayName();
			if (monthlyMenu.get(i).getDisplayName().equalsIgnoreCase(displayName)) {
				monthlyMenu.remove(i);
				return true;
			}
		}
		return false;
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
