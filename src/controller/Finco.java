package controller;

import model.Account;
import model.IAccount;
import model.ICustomer;
import model.IOperation;
import view.MainWindow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import javax.swing.UIManager;

public class Finco {

	private List<ICustomer> customers;

	private IFincoAbstractFactory fincoFactory;

	private MainWindow view;

	public Finco(IFincoAbstractFactory fincoFactory) {
		this.fincoFactory = fincoFactory;
		this.customers = new ArrayList<ICustomer>();
	}

	private ICustomer findOrAddCustomer(ICustomer customer) {
		return customers.stream().filter(c -> c.equals(customer)).findFirst().orElseGet(() -> {
			customers.add(customer);
			return customer;
		});
	}

	public IAccount addCompanyAccount(String name, String email, String street, String city, String state,
			String zipcode, int numOfEmployees) {
		ICustomer customer = fincoFactory.createCompany(name, email, street, city, state, zipcode, numOfEmployees);
		customer = findOrAddCustomer(customer);
		IAccount acc = fincoFactory.createAccount(customer);
		acc.addObserver(view);
		customer.addAccount(acc);
		return acc;
	}

	public IAccount addPersonAccount(String name, String email, String street, String city, String state,
			String zipcode, LocalDate birthDate) {
		ICustomer customer = fincoFactory.createPerson(name, email, street, city, state, zipcode, birthDate);
		customer = findOrAddCustomer(customer);
		IAccount acc = fincoFactory.createAccount(customer);
		acc.addObserver(view);
		customer.addAccount(acc);
		return acc;
	}

	public void addAccountOperation(IAccount acc, String name, double amount) {
		IOperation newOpp = fincoFactory.createOperation(name, amount);
		acc.applyOperation(newOpp);
	}

	protected BiPredicate<ICustomer, String> hasAccount = (customer, accountNumber) -> customer.getAccountList()
			.stream().anyMatch(account -> account.getAccountNumber().equals(accountNumber));

	public ICustomer getOwner(String accountNumber) {
		return customers.stream().filter(customer -> hasAccount.test(customer, accountNumber)).findFirst().get();
	}

	public IAccount getAccount(String accountNumber, ICustomer customer) {
		return customer.getAccountList().stream().filter(x -> x.getAccountNumber().equals(accountNumber)).findFirst()
				.orElse(null);
	}

	public IAccount getAccount(String accountNumber) {
		return customers.stream().flatMap(c -> c.getAccountList().stream())
				.filter(acc -> acc.getAccountNumber() == accountNumber).findFirst().orElse(null);
	}

	public List<ICustomer> getCustomers() {
		return customers;
	}

	public void addInterest() {
		customers.stream().map((ICustomer x) -> x.getAccountList())
				.forEach(a -> a.stream().forEach(b -> b.addInterest()));
	}

	public void run() {
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			// make an instance of application's frame visible.
			view = new MainWindow(this);
			view.setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		Finco fincoApp = new Finco(new FincoFactory());
		fincoApp.run();
	}
}
