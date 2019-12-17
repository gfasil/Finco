package model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCustomer implements ICustomer {

	private String name;
	private String email;
	private Address address;
	private List<IAccount> accounts ;
	
	public AbstractCustomer(String name, String email, Address address) {
		this.name = name;
		this.email = email;
		this.address = address;
		accounts= new ArrayList<>();
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
	public void sendEmail(String msg) {
		System.out.println( msg + " "+ "sent to: " + this.name + " - " + this.email);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractCustomer other = (AbstractCustomer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
