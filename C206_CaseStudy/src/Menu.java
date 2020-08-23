import java.util.ArrayList;

public class Menu {
	private String displayName;
	private int month;
	private int numberOffers;
	private ArrayList items;
	
	public Menu(String displayName,int month,int numberOffers, ArrayList items) {
		this.displayName = displayName;
		this.month = month;
		this.numberOffers = numberOffers;
		this.items = items;
	}

}
