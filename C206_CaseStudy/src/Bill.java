
public class Bill {
	private String payee;
	private double totalAmount; 
	private String dueDate;
	private boolean paid;
	
	public Bill(String payee, double totalAmount, String dueDate) {
		this.payee = payee;
		this.totalAmount = totalAmount;
		this.dueDate = dueDate; 
		this.paid = false;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	public static String showPaid(boolean isPaid) {
		String p;
		
		if (isPaid == true) {
			p = "Yes";
		}
		else {
			p = "No"; 
		}
		return p;
	}
	
	public String toString() {
		return String.format("%-20s %-10.2f %-15s %-10s", getPayee(), 
				getTotalAmount(), getDueDate(), showPaid(isPaid()));
	}
	
}
