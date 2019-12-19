package bank.controller;

import bank.model.CheckingAccount;
import bank.model.SavingAccount;
import framework.controller.IAccountFactory;
import framework.model.IAccount;
import framework.model.ICustomer;

public class BankAccountFactory implements IAccountFactory {
    @Override
    public IAccount createAccount(ICustomer owner, String type) {
        if (type.equalsIgnoreCase("checking"))
            return new CheckingAccount(owner);
        else if (type.equalsIgnoreCase("saving"))
            return new SavingAccount(owner);
        return null;
    }

}
