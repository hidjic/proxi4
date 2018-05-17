package fr.gtm.pbsi.domain;

public class SavingAccount extends Account {
	
	private Float rate;
	
	// CONSTRUCTOR
	public SavingAccount() {
		super();
	}
	public SavingAccount(Float rate) {
		super();
		this.rate = rate;
	}
	
	// GETTERS AND SETTERS
	public Float getRate() {
		return rate;
	}
	public void setRate(Float rate) {
		this.rate = rate;
	}
	
	// toString
	@Override
	public String toString() {
		return "SavingAccount [rate=" + rate + "]";
	}
}
