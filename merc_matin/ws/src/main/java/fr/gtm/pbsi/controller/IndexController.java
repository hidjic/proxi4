package fr.gtm.pbsi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import fr.gtm.pbsi.domain.CurrentAccount;
import fr.gtm.pbsi.domain.Customer;
import fr.gtm.pbsi.domain.Employe;
import fr.gtm.pbsi.domain.SavingAccount;
import fr.gtm.pbsi.domain.Transaction;

@Controller
public class IndexController {

	private final RestTemplate rt = new RestTemplate();

	private final String urlCreateEmploye = "http://localhost:8080/webServiceProxiBanque/employe/";
	private final String urlCreateCustomer = "http://localhost:8080/webServiceProxiBanque/customer/";
	private final String urlCreateTransaction = "http://localhost:8080/webServiceProxiBanque/transaction/";
	// private final String urlCreateCA =
	// "http://localhost:8080/webServiceProxiBanque/account/currentAccount";
	// private final String urlCreateSA =
	// "http://localhost:8080/webServiceProxiBanque/account/savingAccount";

	@RequestMapping(path = "/welcome", method = RequestMethod.GET)
	public ModelAndView displayIndex() {
		final ModelAndView mav = new ModelAndView("welcome");
		
		Employe emp = new Employe();
		emp = this.rt.getForObject(this.urlCreateEmploye+"1", Employe.class);
//		System.out.println(emp);
		if(emp.getId() == 0) {
			this.createBoss();
			this.createConseiller();
			this.createCustomerToConseiller1();
//			this.createTransaction();
		}
		return mav;
	}

	private void createBoss() {
		final Employe boss = new Employe("Cousin", "Olivier", "admin", "admin", 0, 0, null);
		this.rt.postForObject(this.urlCreateEmploye, boss, Employe.class);
	}

	private void createConseiller() {
		final Employe conseiller1 = new Employe("Fournier", "Pascal", "c1", "c1", 1, 0, null);
		this.rt.postForObject(this.urlCreateEmploye, conseiller1, Employe.class);

		final Employe conseiller2 = new Employe("Martin", "Laurine", "c2", "c2", 1, 0, null);
		this.rt.postForObject(this.urlCreateEmploye, conseiller2, Employe.class);
		final Employe conseiller3 = new Employe("Delcroix", "Sarah", "c3", "c3", 1, 0, null);
		this.rt.postForObject(this.urlCreateEmploye, conseiller3, Employe.class);
		final Employe conseiller4 = new Employe("Durand", "Guillaume", "c4", "c4", 1, 0, null);
		this.rt.postForObject(this.urlCreateEmploye, conseiller4, Employe.class);
		final Employe conseiller5 = new Employe("Arnaud", "Claire", "c5", "c5", 1, 0, null);
		this.rt.postForObject(this.urlCreateEmploye, conseiller5, Employe.class);
	}

	private void createCustomerToConseiller1() {
		final Customer c1 = new Customer("Bouvier", "Ludivine", 2);
		final Customer c2 = new Customer("Le Guen", "Rébecca", 2);
		final Customer c3 = new Customer("Lebret", "Sylvain", 2);
		final Customer c4 = new Customer("Corbin", "Remy", 2);
		final Customer c5 = new Customer("Besson", "Alphonse", 2);
		this.rt.postForObject(this.urlCreateCustomer, c1, Customer.class);
		this.rt.postForObject(this.urlCreateCustomer, c2, Customer.class);
		this.rt.postForObject(this.urlCreateCustomer, c3, Customer.class);
		this.rt.postForObject(this.urlCreateCustomer, c4, Customer.class);
		this.rt.postForObject(this.urlCreateCustomer, c5, Customer.class);
	}
	
	private void createTransaction() {
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-15");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Transaction t = new Transaction((java.sql.Date) date1,1,500f,1,null,1,null);
		this.rt.postForObject(this.urlCreateTransaction, t, Transaction.class);
	}
	
	
}
