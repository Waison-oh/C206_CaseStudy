import java.util.ArrayList;

public class Menu {

	private String displayName;
	private int month;
	private int numberOfItems;
	private ArrayList<MenuItem> items;
	
	
	public Menu(String displayName, int month, int numberOfItems, ArrayList<MenuItem> items) {
		this.displayName = displayName;
		this.month = month;
		this.numberOfItems = numberOfItems;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	public ArrayList<MenuItem> getItems() {
		return items; 
	}
	public void setItems(ArrayList<MenuItem> items) {
		this.items = items;
	}

	public String toString() {
		return String.format("%-20s %-20d %-20d %-30s", getDisplayName(), 
				getMonth(), getNumberOfItems(), getItems());
		
	}
	

}
