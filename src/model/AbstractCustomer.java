package model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCustomer implements ICustomer {

	private String name;
	private String email;
	private Address address;
	private List<IAccount> accounts = new ArrayList<>();
	
	public AbstractCustomer(String name, String email, Address address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getEmail() {
		return email;
	}
	
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public Address getAddress() {
		return address;
	}

	@Override
	public void setAddress(String street, String city, String state, String zip) {
		this.address = new Address(street, city, state, zip);
	}
	
	@Override
	public void addAccount(IAccount account) {
		this.accounts.add(account);
	}
	
	@Override
	public void removeAccount(IAccount account) {
		this.accounts.remove(account);
	}
	
	@Override
	public List<IAccount> getAccountList() {
		return accounts;
	}
	
	@Override
	public void sendEmail() {
		System.out.println("Email sent to: " + this.name + " - " + this.email);
	}
	
	//Is Customer name and email is equal to existing customer?
	@Override
	public boolean equals(Object customer) {
        if (customer == null) return false;
        if (!(customer instanceof AbstractCustomer)) return false;
		AbstractCustomer c = (AbstractCustomer)customer;
        if(this.name.equals(c.name) && this.email.equals(c.email)) return true;
        return false;
    }
}
