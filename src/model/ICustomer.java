package model;

import java.util.List;

public interface ICustomer extends FincoObserver<IAccount> {
	
	public void addAccount(IAccount account);
	public void removeAccount(IAccount account);
	public List<IAccount> getAccountList();
	public String getName();
	public void setName(String name);
	public String getEmail();
	public void setEmail(String email);
	public void setAddress(String street, String city, String state, String zip);
	public Address getAddress();

	public void sendEmail(String msg);
	public String getType();
}
