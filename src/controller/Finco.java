package controller;

import model.Account;
import model.IAccount;
import model.ICustomer;
import model.IOperation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class Finco {

	private List<ICustomer> customers = new ArrayList<ICustomer>();

	private IFincoAbstractFactory fincoFactory = new FincoFactory();

	private ICustomer findOrAddCustomer(ICustomer customer) {
		return customers.stream().filter(c -> c.equals(customer)).findFirst().orElseGet(() -> {
			customers.add(customer);
			return customer;
		});
	}

	public void addCompanyAccount(String name, String email, String street, String city, String state, String zipcode,
			int numOfEmployees) {
		ICustomer customer = fincoFactory.createCompany(name, email, street, city, state, zipcode, numOfEmployees);
		customer = findOrAddCustomer(customer);
		customer.addAccount(fincoFactory.createAccount(customer));
	}

	public void addPersonAccount(String name, String email, String street, String city, String state, String zipcode,
			LocalDate birthDate) {
		ICustomer customer = fincoFactory.createPerson(name, email, street, city, state, zipcode, birthDate);
		customer = findOrAddCustomer(customer);
		customer.addAccount(fincoFactory.createAccount(customer));

    }

	public void addAccountOperation(Account acc, String name, double amount) {
		IOperation newOpp = fincoFactory.createOperation(name, amount);
		acc.applyOperation(newOpp);
	}

    protected static BiPredicate<ICustomer, String> hasAccount = (customer, accountNumber) -> customer.getAccountList().stream()
            .anyMatch(account -> account.getAccountNumber().equals(accountNumber));

    public static ICustomer getOwner(String accountNumber) {
        return customers.stream()
                .filter(customer -> hasAccount.test(customer, accountNumber)).findFirst().get();
    }

    public static IAccount getAccount(String accountNumber, ICustomer customer) {
        return customer.getAccountList().stream().filter(x -> x.getAccountNumber().equals(accountNumber)).findFirst().orElse(null);
//		for (IAccount temp : customer.getAccountList()) {
//			if (temp.getAccountNumber().equals(accountNumber))
//				return temp;
//		}
//		return null;
    }

    public static List<ICustomer> getCustomers() {
        return customers;
    }

    public static void addInterest() {
        customers.stream().map((ICustomer x) -> x.getAccountList()).forEach(a -> a.stream().forEach(b -> b.addInterest()));
//		for (ICustomer c : customers) {
//			for (IAccount a : c.getAccountList()) {
//				a.addInterest();
//			}
//		}
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
