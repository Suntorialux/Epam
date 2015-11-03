package by.gsu.epamlab;

public class BusinessTrip {
	private static final int DAILY_RATE=150000;
	private String account;
	private int transportationExpenses;
	private int numberOfDay;
	
	public BusinessTrip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessTrip(String account, int transportationExpenses, int numberOfDay) {
		super();
		this.account = account;
		this.transportationExpenses = transportationExpenses;
		this.numberOfDay = numberOfDay;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getTransportationExpenses() {
		return transportationExpenses;
	}

	public void setTransportationExpenses(int transportationExpenses) {
		this.transportationExpenses = transportationExpenses;
	}

	public int getNumberOfDay() {
		return numberOfDay;
	}

	public void setNumberOfDay(int numberOfDay) {
		this.numberOfDay = numberOfDay;
	}

	private int getTotal () {
		return  transportationExpenses+DAILY_RATE*numberOfDay;
	}
	
	public void show () {
			System.out.format("rate=%d \n", DAILY_RATE);
			System.out.format("account=%s \n", account);
			System.out.format("transport=%d \n", transportationExpenses);
			System.out.format("days=%d \n", numberOfDay);
			System.out.format("total=%d \n", getTotal()); 		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return account+";"+transportationExpenses+";"+numberOfDay+";"+getTotal();
	}
	
	
	
	
		
	
	
	

}
