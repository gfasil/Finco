package framework.controller;

import framework.model.IAccount;
import framework.model.ICustomer;

public interface IAccountFactory {
    public IAccount createAccount(ICustomer owner, String type);

}

