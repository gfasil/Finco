package ccard.model;

import framework.model.AbstractAccount;
import framework.model.ICustomer;

public class GoldAccount extends AbstractAccount {

    public GoldAccount(ICustomer owner) {
        super(owner);

    }

    @Override
    public double getInterest() {
        return 0.00967;
    }

    @Override
    public String getType() {
        return "CheckingAccount";
    }
}
