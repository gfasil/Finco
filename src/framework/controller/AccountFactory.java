package framework.controller;

import framework.model.Account;
import framework.model.IAccount;
import framework.model.ICustomer;

public class AccountFactory implements IAccountFactory {


    public IAccount createAccount(ICustomer owner, String type) {
        return new Account(owner);
    }
}
