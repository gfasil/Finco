package ccard.controller;

import ccard.view.BankWindow;
import framework.controller.FinCo;
import framework.controller.IAccountFactory;

import javax.swing.*;

public class Bank extends FinCo {


    public Bank(IAccountFactory accountFactory) {
        super(accountFactory);
    }

    public static void main(String[] args) {
        FinCo finCoApp = new Bank(new BankAccountFactory());
        finCoApp.run();
    }

    public void run() {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            // make an instance of application's frame visible.
            view = new BankWindow(this);
            view.initializeWindow();
            view.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            // Ensure the application exits with an error condition.
            System.exit(1);
        }
    }
}
