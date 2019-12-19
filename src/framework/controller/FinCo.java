package framework.controller;

import framework.model.*;
import framework.view.AbstractWindow;
import framework.view.MainWindow;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class FinCo {

	protected List<ICustomer> customers;
	protected IAccountFactory accountFactory;



	protected AbstractWindow view;

	public FinCo(IAccountFactory accountFactory) {
		this.accountFactory = accountFactory;
		this.customers = new ArrayList<ICustomer>();
	}

	protected ICustomer findOrAddCustomer(ICustomer customer) {
		return customers.stream().filter(c -> c.equals(customer)).findFirst().orElseGet(() -> {
			customers.add(customer);
			return customer;
		});
	}

	public static void main(String[] args) {
		FinCo finCoApp = new FinCo(new AccountFactory());
		finCoApp.run();
	}

	public IAccount addCompanyAccount(String name, String email, String street, String city, String state,
			String zipcode, int numOfEmployees, String type) {
		ICustomer customer = new Company(name, email, new Address(street, city, state, zipcode), numOfEmployees);
		customer = findOrAddCustomer(customer);
		IAccount acc = accountFactory.createAccount(customer, type);
		acc.addObserver(view);
		customer.addAccount(acc);
		return acc;
	}

	public IAccount addPersonAccount(String name, String email, String street, String city, String state,
			String zipcode, LocalDate birthDate, String type) {
		ICustomer customer = new Person(name, email, new Address(street, city, state, zipcode), birthDate, 500);
		customer = findOrAddCustomer(customer);
		IAccount acc = accountFactory.createAccount(customer, type);
		acc.addObserver(view);
		customer.addAccount(acc);
		return acc;
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
	public  String generateReport() {
		String report = "";
		for (ICustomer c : customers) {
			report += "\nName = " + c.getName();
			report += "\nAddress = " + c.getAddress();
			report += "\nAccount = " + c.getAccountList();
			report += "\nTotal Balance = " + c.getAccountList().stream().mapToDouble(x -> x.getBalance()).sum();
			System.out.println(c.getName());

		}
		return report;
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
			view.initializeWindow();
			view.setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	public boolean addAccountOperation(IAccount acc, String name, double amount) {
		IOperation newOpp = new Operation(name, amount);
		return acc.applyOperation(newOpp);
	}
}
