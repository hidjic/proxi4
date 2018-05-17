package fr.gtm.pbsi.domain;

public class CurrentAccount extends Account {
	
	private Float overdraft;
	
	// CONSTRUCTOR
	public CurrentAccount() {
		super();
	}
	public CurrentAccount(Float overdraft) {
		super();
		this.overdraft = overdraft;
	}
	
	// GETTERS AND SETTERS
	public Float getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(Float overdraft) {
		this.overdraft = overdraft;
	}
	
	// toString
	@Override
	public String toString() {
		return "CurrentAccount [overdraft=" + overdraft + "]";
	}
}
