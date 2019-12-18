package Bank.controller;

import Bank.model.SavingAccount;
import controller.FincoFactory;
import model.IAccount;
import model.ICustomer;

public class FincoSavingFactory extends FincoFactory {
    @Override
    public IAccount createAccount(ICustomer owner) {
        return new SavingAccount(owner);
    }
}
