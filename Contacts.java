public class Contacts {
	private int ContactLensID;
	private String ContactLensName;
	private String ContactLensDisposal;
	private double ContactLensPrices;
	
	//constructor
	public Contacts(int ContactLensID, String ContactLensName, String ContactLensDisposal, double ContactLensPrices) {
		this.ContactLensID = ContactLensID;
		this.ContactLensName = ContactLensName;
		this.ContactLensDisposal = ContactLensDisposal;
		this.ContactLensPrices = ContactLensPrices;
		}
	//getters
		 public int getContactLensID() {
		        return ContactLensID;
		    }
		 public String getContactLensName() {
		        return ContactLensName;
		    }        
		 public String getContactLensDisposal() {
			        return ContactLensDisposal;
		    }
		 public Double getContactLensPrices() {
		        return ContactLensPrices;
		    }
	
}
