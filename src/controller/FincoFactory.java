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
		ICustomer customer = new Company(name, email, createAddress(street, city, state, zipcode), numberOfEmployees);
		return customer;
	}

	public Address createAddress(String street, String city, String state, String zipcode){

		return new Address(street, city, state, zipcode);
	}

	@Override
	public ICustomer createPerson(String name, String email, String street, String city, String state, String zipcode,
			LocalDate birthDate) {

		ICustomer customer = new Person(name, email, createAddress(street, city, state, zipcode), birthDate, 500);
		return customer;
	}
}
