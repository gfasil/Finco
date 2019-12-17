package controller;

import model.*;

import java.time.LocalDate;

public class FincoFactory implements IFincoAbstractFactory {

	@Override
	public IAccount createAccount(ICustomer owner) {
		return new Account(owner);
	}

	@Override
	public IOperation createOperation(String name, double amount) {
		return new Operation(name, amount);
	}

	@Override
	public ICustomer createCompany(String name, String email, String street, String city, String state, String zipcode,
			int numberOfEmployees) {
		Address address = new Address(street, city, state, zipcode);
		ICustomer customer = new Company(name, email, address, numberOfEmployees);
		return customer;
	}

	@Override
	public ICustomer createPerson(String name, String email, String street, String city, String state, String zipcode,
			LocalDate birthDate) {
		Address address = new Address(street, city, state, zipcode);
		ICustomer customer = new Person(name, email, address, birthDate);
		return customer;
	}
}
