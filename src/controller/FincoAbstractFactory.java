package controller;

import model.IAccount;
import model.IOperation;

public abstract class FincoAbstractFactory implements IFincoAbstractFactory {

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
}
