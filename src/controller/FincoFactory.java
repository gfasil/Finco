package controller;

import java.time.LocalDate;

import model.Address;
import model.Company;
import model.IAccount;
import model.ICustomer;
import model.IOperation;
import model.Person;

public class FincoFactory implements IFincoAbstractFactory {

	@Override
	public IAccount createAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOperation createOperation() {
		// TODO Auto-generated method stub
		return null;
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
