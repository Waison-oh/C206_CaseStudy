import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_BILL = 5;
	private static final int OPTION_MONTHLYMENU = 4;
	private static final int OPTION_ORDER = 3;
	private static final int OPTION_ACCOUNT = 2;
	private static final int OPTION_MENU = 1;
	private static final int OPTION_EXIT = 6;
	private static final int OPTION_CREATEMENU = 7;
	private static final int OPTION_DELETEMENU = 8;

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
			
			//WEI KIAT STARTS HERE - MENU//
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
					
				}
				
				else if (action == DELETE) {
					
				}
				
				else {
					System.out.println("INVALID OPTION!!");
				}
			} 
			
			//SHARAN STARTS HERE - ACCOUNT//
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
					C206_CaseStudy.createAccount(); 
				}	
				
				else if (action == VIEW) {
					C206_CaseStudy.viewAllAccounts(accountList);
				}
				
				else if (action == DELETE) {
					C206_CaseStudy.deleteAccount(accountList);
				}
				
				else {
					System.out.println("INVALID OPTION!!");
				}
			}

			//QI YUE STARTS HERE - ORDER//
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
					C206_CaseStudy.createOrder(); 
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
			} 
			//QIAO LING STARTS HERE - MONTHLY MENU//
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
				}
				else if (action == VIEW) {
					C206_CaseStudy.viewAllMenu(menuList); 
				}
				else if (action == DELETE) {
					C206_CaseStudy.deleteMenu(orderList);
				}	
				else {
					System.out.println("INVALID OPTION!!");
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
					C206_CaseStudy.createBill(billList);
				} 
				else if (actions == VIEW) {
					billList.toString();
				} 
				else if (actions == DELETE) {
					C206_CaseStudy.deleteBill(billList);
					} 
				else {
					System.out.println("INVALID OPTION!!");
				}
			}
			else if (option == OPTION_EXIT) {
				System.out.println("GOODBYE!!");
				} 
			else {
					System.out.println("INVALID OPTION!!");
				}
			} // ASHLEIGH ENDS HERE//
		}
	}

	// ================================================================================= //

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
		for (int i = 0; i < items.size(); i++) {
			if (name == items.get(i).getName()) {
				String newCategory = Helper.readString("Enter new Menu Item category (Western/Asian/Vegetarian):  ");
				String newName = Helper.readString("Enter new Menu Item name: ");
				boolean newHealthy = Helper.readBoolean("Is this new Menu Item a healthy choice?(true/false) ");
				double newprice = Helper.readDouble("Enter price for new Menu Item: ");

				items.get(i).setCategory(newCategory);
				items.get(i).setName(newName);
				items.get(i).setHealthyChoice(newHealthy);
				items.get(i).setPrice(newprice);

				System.out.println("Menu added!!");
			} else {
				System.out.println("Menu Item invalid!!");
			}
		}
	}
	public static String viewMenuItems(ArrayList<MenuItem> items) {
		
	}
	
	public void deleteMenuItems(ArrayList<MenuItem> items) {
		
	}
	
	// Wei Kiat end//
	
	//OPTION 2 =========================================================== ACCOUNT//
	//Retrieving account list.
	  public static String retrieveAllAccounts(ArrayList<Account> accountList) {
	    String output = "";
	    for (int i = 0; i < accountList.size(); i++) {

	 

	      output += String.format("%-10s %-30s %-10.2f\n", accountList.get(i).getUsername(),
	          accountList.get(i).getPassword(), accountList.get(i).getUserRole());

	 

	    }
	    return output;
	  } //Viewing Account List
	  public static void viewAllAccounts(ArrayList<Account> accountList) {
	    for (int i = 0; i < accountList.size(); i++) {
	      C206_CaseStudy.setHeader("ACCOUNT LIST");
	      String output = String.format("%-10s %-30s %-10s\n", "USERNAME", "PASSWORD", "USER ROLE");
	      output += retrieveAllAccounts(accountList);
	      System.out.println(output);
	    }

	 } //Inputing Account
	  public static Account createAccount() {
	    String username = Helper.readString("Enter Username > ");
	    String studentId = Helper.readString("Enter Student ID > ");
	    String userRole = Helper.readString("Enter userRole > ");
	    String contactNumber = Helper.readString("Enter Contact Number > ");
	    
	    Account a = new Account(userRole, contactNumber, studentId, username);
	    return a;
	  } 
	  //Adding Account
	  public static void addAccount (ArrayList<Account> accountList, Account a) {
	    
	    accountList.add(a);
	    System.out.println("New Account Added!");
	  }
	  //Delete Account//
	  public static boolean doDelete(ArrayList<Account> accountList, String username, String password, String userRole) {
	    boolean isDeleted = false;
	    
	    for (int i = 0; i < accountList.size(); i++) {
	      String z = accountList.get(i).getUsername();
	      if (username.equalsIgnoreCase(z)) {
	        accountList.get(i).setPassword(password);
	        accountList.get(i).setUserRole(userRole);
	      }
	    }
	    return isDeleted;
	  }
	  public static void deleteAccount(ArrayList<Account> accountList) {
	    C206_CaseStudy.viewAllAccounts(accountList);
	    String username = Helper.readString("Enter Username > ");
	    String password = Helper.readString("Enter Password > ");
	    String userRole = Helper.readString("Enter User Role > ");
	    Boolean isDeleted = doDelete(accountList, username, password, userRole);
	    if (isDeleted == false) {
	      System.out.println("Account does not exist.");
	    } else {
	      System.out.println("Staff " + username + "'s account has been deleted.");
	    }
	  }
	
	
	//OPTION 3 ============================================================= ORDER//
		private static void deleteOrder(ArrayList<Order> orderList) {

		}

		private static Order createOrder() {
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

	//OPTION 4 ======================================================= MONTHLY MENU//
	private static Menu createMenu() {
		// TODO Auto-generated method stub
		String category = Helper.readString("Which category is this menu item in? ");
		String name = Helper.readString("Enter menu item name: ");
		boolean choice = Helper.readBoolean("Is this menu item a healthy choice?(true/false");
		double price = Helper.readDouble("Price of menu item: ");

		MenuItem newMenuItem = new MenuItem(category, name, choice, price);
	
	}
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

	public static void deleteMenu(ArrayList<Menu> menuList) {
		
	}

	
	// OPTION 5 =============================================================== BILL//
	//ASHLEIGH STARTS HERE//
	//CREATE BILL//
	public static void createBill(ArrayList<Bill> billList) {
		C206_CaseStudy.setHeader("CREATE BILL");
		String payee = Helper.readString("Enter payee name > ");
		double amount = Helper.readDouble("Enter total amount > ");
		String due = Helper.readString("Enter due date > ");
		
		Bill newBill = new Bill(payee, amount, due); 
		billList.add(newBill); 
		System.out.println("Bill added!");
	}
	
	//VIEW BILL//
	public static String viewBill(ArrayList<Bill> billList) {
		String output = null;
		for (int i = 0; i < billList.size(); i++) {
			output = billList.get(i).toString();
		}
		return output;
	}
	
	//DELETE BILL//
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
