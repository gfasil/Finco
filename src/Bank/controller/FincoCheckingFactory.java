package Bank.controller;

import Bank.model.CheckingAccount;
import controller.FincoFactory;
import model.IAccount;
import model.ICustomer;

public class FincoCheckingFactory extends FincoFactory {
    @Override
    public IAccount createAccount(ICustomer owner) {
        return new CheckingAccount(owner);
    }
}
