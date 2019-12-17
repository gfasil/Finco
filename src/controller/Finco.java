package controller;

import model.Account;
import model.ICustomer;
import model.IOperation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Finco {

	private static List<ICustomer> customers = new ArrayList<ICustomer>();

	private static IFincoAbstractFactory fincoFactory = new FincoFactory();

	private static ICustomer findCustomer(ICustomer customer) {
		return customers.stream().filter(c -> c.equals(customer)).findFirst().orElse(customer);
	}

	public static void addCompanyAccount(String name, String email, String street, String city, String state,
			String zipcode, int numOfEmployees) {
		ICustomer customer = fincoFactory.createCompany(name, email, street, city, state, zipcode, numOfEmployees);
		customer = findCustomer(customer);
		customer.addAccount(fincoFactory.createAccount(customer));
	}

	public static void addPersonAccount(String name, String email, String street, String city, String state,
			String zipcode, LocalDate birthDate) {
		ICustomer customer = fincoFactory.createPerson(name, email, street, city, state, zipcode, birthDate);
		customer = findCustomer(customer);
		customer.addAccount(fincoFactory.createAccount(customer));

	}

	public static void addAccountOperation(Account acc, String name, double amount) {
		IOperation newOpp = fincoFactory.createOperation(name, amount);
		acc.applyOperation(newOpp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
