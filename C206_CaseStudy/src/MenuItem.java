
public class MenuItem {
	private String category;
	private String name; 
	private boolean healthyChoice; 
	private double price; 
	
	public MenuItem(String category, String name, boolean healthyChoice, double price) {
		this.category = category;
		this.name = name;
		this.healthyChoice = true;
		this.price = price; 
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isHealthyChoice() {
		return healthyChoice;
	}
	
	public static String showHealthyChoice(boolean isHealthyChoice) {
		String avail; 
		
		if (isHealthyChoice == true) {
			avail = "Yes";
		}
		else {
			avail = "No"; 
		}
		return avail;
	}

	public void setHealthyChoice(boolean healthyChoice) {
		this.healthyChoice = healthyChoice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return String.format("%-10s %-30s %-10s %.2f", category,name, healthyChoice,price);//getCategory(),showHealthyChoice(isHealthyChoice()), getPrice());
	}
	
}
