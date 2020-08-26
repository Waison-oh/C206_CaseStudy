import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	ArrayList<Menu> menuList = new ArrayList<Menu>();
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
	
	}


}
