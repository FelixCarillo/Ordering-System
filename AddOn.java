public class AddOn {
	private String AddOnNames;
	private int AddOnID;
	private double AddOnPrices;
	
	//constructor
	public AddOn(int AddOnID, String AddOnNames, double AddOnPrices) {
		this.AddOnID = AddOnID;
		this.AddOnNames = AddOnNames;
		this.AddOnPrices = AddOnPrices;
	}
	
	//getters
	 public int getAddOnID() {
	        return AddOnID;
	    }
	 public String getAddOnNames() {
	        return AddOnNames;
	    }
	 public Double getAddOnPrices() {
	        return AddOnPrices;
	    }
}
