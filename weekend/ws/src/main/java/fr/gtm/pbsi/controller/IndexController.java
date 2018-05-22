package fr.gtm.pbsi.controller;

import java.util.ArrayList;
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

@Controller
public class IndexController {
	
//	ClientConfig conf = new ClientConfig();
//	Client c = ClientBuilder.newClient(conf);
//	Employe emp = rt.postForObject(url, boss, Employe.class);
//	System.out.println(emp);
	
	private RestTemplate rt = new RestTemplate();

	private String urlCreateEmploye = "http://localhost:8080/webServiceProxiBanque/employe/";
	private String urlCreateCustomer = "http://localhost:8080/webServiceProxiBanque/customer/";
	private String urlCreateCA = "http://localhost:8080/webServiceProxiBanque/account/currentAccount";
	private String urlCreateSA = "http://localhost:8080/webServiceProxiBanque/account/savingAccount";
	
	@RequestMapping(path = "/welcome", method = RequestMethod.GET)
	public ModelAndView displayIndex() {
		System.out.println("début du displayIndex...");
		ModelAndView mav = new ModelAndView("welcome");
		
		this.createBoss();
		this.createConseiller();
		this.createCustomerToConseiller1();
		
		return mav;
	}

	private void createBoss() {
		Employe boss = new Employe("Cousin","Olivier","admin","admin",0,null);
		this.rt.postForObject(this.urlCreateEmploye, boss, Employe.class);
	}
	
	private void createConseiller() {
		Employe conseiller1 = new Employe("Fournier","Pascal","c1","c1",1,null);
		this.rt.postForObject(this.urlCreateEmploye, conseiller1, Employe.class);
		
		Employe conseiller2 = new Employe("Martin","Laurine","c2","c2",1,null);
		this.rt.postForObject(this.urlCreateEmploye, conseiller2, Employe.class);
		Employe conseiller3 = new Employe("Delcroix","Sarah","c3","c3",1,null);
		this.rt.postForObject(this.urlCreateEmploye, conseiller3, Employe.class);
		Employe conseiller4 = new Employe("Durand","Guillaume","c4","c4",1,null);
		this.rt.postForObject(this.urlCreateEmploye, conseiller4, Employe.class);
		Employe conseiller5 = new Employe("Arnaud","Claire","c5","c5",1,null);
		this.rt.postForObject(this.urlCreateEmploye, conseiller5, Employe.class);
	}
	
	private void createCustomerToConseiller1() {
		boolean active = false;
		String number = "test";
		String date = "21-05-2018";
		float solde = 0;
		float dec = 0;
		float taux = 3;
		CurrentAccount ca = new CurrentAccount(dec);
		ca.setBalance(solde);
		ca.setDateCreation(date);
		ca.setIsActive(active);
		ca.setNumberCompte(number);
		SavingAccount sa = new SavingAccount(taux);
		sa.setBalance(solde);
		sa.setDateCreation(date);
		sa.setIsActive(active);
		sa.setNumberCompte(number);
		System.out.println(ca);
		System.out.println(sa);
		
		
		CurrentAccount ca1 = this.rt.postForObject(this.urlCreateCA, ca, CurrentAccount.class);
		SavingAccount sa1 = this.rt.postForObject(this.urlCreateSA, sa, SavingAccount.class);
		Customer c1 = new Customer("Bouvier","Ludivine",2,ca1,sa1);
		CurrentAccount ca2 = this.rt.postForObject(this.urlCreateCA, ca, CurrentAccount.class);
		SavingAccount sa2 = this.rt.postForObject(this.urlCreateSA, sa, SavingAccount.class);
		Customer c2 = new Customer("Le Guen","Rébecca",2,ca2,sa2);
		CurrentAccount ca3 = this.rt.postForObject(this.urlCreateCA, ca, CurrentAccount.class);
		SavingAccount sa3 = this.rt.postForObject(this.urlCreateSA, sa, SavingAccount.class);
		Customer c3 = new Customer("Lebret","Sylvain",2,ca3,sa3);
		CurrentAccount ca4 = this.rt.postForObject(this.urlCreateCA, ca, CurrentAccount.class);
		SavingAccount sa4 = this.rt.postForObject(this.urlCreateSA, sa, SavingAccount.class);
		Customer c4 = new Customer("Corbin","Remy",2,ca4,sa4);
		CurrentAccount ca5 = this.rt.postForObject(this.urlCreateCA, ca, CurrentAccount.class);
		SavingAccount sa5 = this.rt.postForObject(this.urlCreateSA, sa, SavingAccount.class);
		Customer c5 = new Customer("Besson","Alphonse",2,ca5,sa5);
		this.rt.postForObject(this.urlCreateCustomer, c1, Customer.class);
		this.rt.postForObject(this.urlCreateCustomer, c2, Customer.class);
		this.rt.postForObject(this.urlCreateCustomer, c3, Customer.class);
		this.rt.postForObject(this.urlCreateCustomer, c4, Customer.class);
		this.rt.postForObject(this.urlCreateCustomer, c5, Customer.class);
	}
	
}
