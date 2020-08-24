import java.util.ArrayList;

public class Order {
	
	private String studentId;
	private String orderDate; 
	private ArrayList<MenuItem> items;
	
	public Order(String studentId, String orderDate, ArrayList<MenuItem> items) {
		this.studentId = studentId;
		this.orderDate = orderDate; 
		this.items = items;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public ArrayList<MenuItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<MenuItem> items) {
		this.items = items;
	}
	
	public String toString() {
		String itemList = "";
		for (int i = 0; i < items.size(); i++) {
			itemList += items.get(i).getName();
			if(i != (items.size()-1)) {
				itemList += ", ";
			}
		}
		return String.format("%-20s %-20s %-20s", studentId, orderDate, itemList);
	}
}