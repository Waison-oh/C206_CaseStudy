import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static final int OPTION_EDIT = 4;
	private static final int OPTION_BUY = 3;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_MENU = 1;
	private static final int OPTION_EXIT = 5;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<MenuItem> items = new ArrayList<MenuItem>();  
		ArrayList<Menu>menuList = new ArrayList<Menu>();
		ArrayList<Order>orderList = new ArrayList<Order>();
		
		items.add(new MenuItem("Japanese", "Sushi", true, 3.50)); 
		
		int option = 0;
		
		while (option != OPTION_EXIT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an Option > ");
			
			if (option == OPTION_MENU) {
				C206_CaseStudy.viewAllMenu(menuList);
				C206_CaseStudy.viewAllOrder(orderList);
			}
			else {
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
					}
					else if (itemType == ORDER) {
						Order od = inputOrder(); 
						C206_CaseStudy.addOrder(orderList, od);
					}
					else {
						System.out.println("INVALID TYPE!!");
					}
				}
				else if (option == OPTION_BUY) {
					C206_CaseStudy.setHeader("ORDER"); 
					
					int itemType = ORDER;
					C206_CaseStudy.buyOrder(orderList); 
				}
				else if (option == OPTION_EDIT) {
					C206_CaseStudy.setHeader("EDIT");
					C206_CaseStudy.setHeader("ITEM TYPES");
					System.out.println("1. MENU");
					System.out.println("2. ORDER");
					
					int itemType = Helper.readInt("Enter option to select item type > "); 
					if (itemType == MENU) {
						C206_CaseStudy.editMenu(menuList);
					}
					else if (itemType == ORDER) {
						C206_CaseStudy.editOrder(orderList);
					}
					else {
						System.out.println("INVALID TYPE!!");
					}
				}
				else if (option == OPTION_EXIT) {
					System.out.println("GOODBYE!!");
				}
				else {
					System.out.println("INVALID OPTION!!");
				}
			}
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
		Order newOrder = new Order(studentID, orderDate, newMenuItem);
		
		return null;
	}
	
	//=================================================================================
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
		Menu newMenu = new Menu(displayName, month, amount, newMenuItem);
		
		
	
		
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
		System.out.println("5. Exit");
		Helper.line(80, "=");
	}
	public static String showAvailability(boolean isAvailable) {
		String avail; 
		
		if (isAvailable == true) {
			avail = "Yes";
		}
		else {
			avail = "No"; 
		}
		return avail;
	}
	//OPTION 1 ============================================================ DISPLAY MENU//
	public static String getAllMenu(ArrayList<Menu> menuList) {
		String output = ""; 
		
		for (int i = 0; i < menuList.size(); i++) {
			output += String.format("-90s\n", menuList.get(i).toString());
		}
		return output;
	}
	public static void viewAllMenu(ArrayList<Menu> menuList) {		
		String output = String.format("%-10s %-30s %-10s %-20s %-20s %-30s\n", "TAG NO.", "NAME", "AVAILABLE", "DISPLAY NAME", 
					"MONTH", "NUMBER OF OFFERS");
		output += getAllMenu(menuList); 
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
		String output = String.format("%-10s %-30s %-10s %-10s %-30s %-30s\n", "TAG NO.", "NAME", "AVAILABLE", 
				"STUDENT ID", "STUDENT NAME", "ORDER DATE"); 
		output += getAllOrder(orderList); 
		System.out.println(output);
	}
	//OPTION 2 =========================================================== ADD ITEM//
	

}
