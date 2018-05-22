package fr.gtm.pbsi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.gtm.pbsi.domain.Customer;
import fr.gtm.pbsi.service.CustomerService;
import fr.gtm.pbsi.service.EmployeService;

@ManagedBean(name = "customerbean")
@SessionScoped
public class CustomerBean {
	private Customer customer = new Customer();
	private CustomerService serviceCustomer = new CustomerService();
	private EmployeService serviceEmploye = new EmployeService();
	private String message = "test message";
	
	
	//============= assesseurs ============
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}//==================================================
	
	
//===================== Methode ======================
	
	public String createCustomer() {
		String forward = null;
		this.customer = serviceCustomer.createCustomer(this.customer);
		if (customer.getId() > 0) {
			forward = "success";
		} else
			forward = "fail";
		return forward;
	}

	public String updateCustomer(Customer customer) {
		String forward = null;
		Customer oldCustomer = customer;
		this.customer = serviceCustomer.updateCustomer(this.customer);
		if (customer == oldCustomer) {
			forward = "fail";

		} else
			forward = "success";
		return forward;
	}

	
	public String goUpdateCustomer(Customer customer) {
		System.out.println("-- goUpdateCustomer Méthode --");
		this.customer=customer;
		return "customerModification";
	}
	public String goTransfert(Customer customer) {
		System.out.println("-- goTransfert Méthode --");
		this.customer=customer;
		return "transfert";
	}

	public String goAccountsList(Customer customer) {
		System.out.println("-- goAccountsList Méthode --");

		this.customer=customer;
		return "accountsList";
	}
	
	public String goCreateCustomerPage () {
		System.out.println("-- showCreateCustomerPage Méthode --");
		return "customerCreation";
	}

}
