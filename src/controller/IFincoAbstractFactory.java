package controller;

import model.IAccount;
import model.ICustomer;
import model.IOperation;

public interface IFincoAbstractFactory {
	public ICustomer createCustomer();
	public IAccount createAccount();
	public IOperation createOperation();
}
