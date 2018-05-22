package fr.gtm.pbsi.domain;

public class Customer extends People {

	private Integer id;
	private String email;
	private String adress;
	private String zipCode;
	private String city;
	private Integer idEmploye;
	private CurrentAccount myCurrentAccount;
	private SavingAccount mySavingAccount;

	public Customer() {
		super("Entrer nom", "Entrer prénom");
		this.id = 0;
		this.email = "Entrer email";
		this.adress = "Entrer adresse";
		this.city = "Entrer ville";
		this.zipCode = "Entrer code postal";
		this.idEmploye = 0;
	}

	public Customer(String name, String firstName) {
		super(name, firstName);
		this.id = 0;
		this.email = "Inconnu";
		this.adress = "Inconnu";
		this.city = "Inconnu";
		this.zipCode = "Inconnu";
		this.idEmploye = 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Integer idEmploye) {
		this.idEmploye = idEmploye;
	}

	public CurrentAccount getMyCurrentAccount() {
		return myCurrentAccount;
	}

	public void setMyCurrentAccount(CurrentAccount myCurrentAccount) {
		this.myCurrentAccount = myCurrentAccount;
	}

	public SavingAccount getMySavingAccount() {
		return mySavingAccount;
	}

	public void setMySavingAccount(SavingAccount mySavingAccount) {
		this.mySavingAccount = mySavingAccount;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", idConseiller=" + idEmploye + ", myCurrentAccount="
				+ myCurrentAccount + ", mySavingAccount=" + mySavingAccount + "]";
	}

}
