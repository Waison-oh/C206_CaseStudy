import java.awt.MenuItem; //this is quick fix before the menuItem array List is out
import java.util.ArrayList;


public class Menu {

	private String displayName;
	private int month;
	private int numberOffers;
	private ArrayList<MenuItem> items;
	
	public Menu(String displayName,int month,int numberOffers, ArrayList items) {
		this.displayName = displayName;
		this.month = month;
		this.numberOffers = numberOffers;
		this.items = items;
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

	public int getNumberOffers() {
		return numberOffers;
	}

	public void setNumberOffers(int numberOffers) {
		this.numberOffers = numberOffers;
	}

	public ArrayList<MenuItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<MenuItem> items) {
		this.items = items;
	}
	

}
