package ccard.view;

import framework.controller.FinCo;
import framework.model.IAccount;
import framework.view.AbstractWindow;
import framework.view.EntryDialog;
import framework.view.ReportDialog;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Arrays;

public class BankWindow extends AbstractWindow {
    private static final int NUM_OF_COL = 10;
    private static final int ACC_NUM_COL_IND = 0;
    private static final int ACC_OWNER_NAME_COL_IND = 1;
    private static final int ACC_OWNER_EMAIL_COL_IND = 2;
    private static final int ACC_OWNER_STREET_COL_IND = 3;
    private static final int ACC_OWNER_CITY_COL_IND = 4;
    private static final int ACC_OWNER_STATE_COL_IND = 5;
    private static final int ACC_OWNER_TYPE_COL_IND = 6;
    private static final int ACC_OWNER_ZIP_COL_IND = 7;
    private static final int ACC_BALANCE_COL_IND = 8;
    private static final int ACC_TYPE_COL_IND = 9;
    /****
     * init variables in the object
     ****/

    private JButton JButton_PerAC = new JButton();
    private JButton JButton_CompAC = new JButton();
    private JButton JButton_Deposit = new JButton();
    private JButton JButton_Withdraw = new JButton();
    private JButton JButton_Addinterest = new JButton();
    private JButton JButton_Exit = new JButton();
    private JButton JButton_report = new JButton();

    public BankWindow(FinCo controller) {

        super(controller);
    }

    @Override
    public void initializeWindow() {
        System.out.println("TEST");
        initializeModel();
        initButtons();
        setTitle("FincoBank");
    }

    protected void initButtons() {
        System.out.println("TEST");
        JButton_PerAC.setText("Add personal account");
        JPanel1.add(JButton_PerAC);
        JButton_PerAC.setBounds(24, 20, 192, 33);
        JButton_CompAC.setText("Add company account");
        JButton_CompAC.setActionCommand("jbutton");
        JPanel1.add(JButton_CompAC);
        JButton_CompAC.setBounds(240, 20, 192, 33);
        JButton_Deposit.setText("Deposit");
        JPanel1.add(JButton_Deposit);
        JButton_Deposit.setBounds(468, 104, 96, 33);
        JButton_Withdraw.setText("Withdraw");
        JPanel1.add(JButton_Withdraw);
        JButton_Addinterest.setBounds(448, 20, 106, 33);
        JButton_Addinterest.setText("Add interest");
        JPanel1.add(JButton_Addinterest);
        JButton_report.setBounds(468, 200, 120, 31);
        JButton_report.setText("Generate report");
        JPanel1.add(JButton_report);
        JButton_Withdraw.setBounds(468, 164, 96, 33);
        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468, 248, 96, 31);


        JButton_PerAC.setActionCommand("jbutton");

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
        JButton_Exit.addActionListener(lSymAction);
        JButton_PerAC.addActionListener(lSymAction);
        JButton_CompAC.addActionListener(lSymAction);
        JButton_Deposit.addActionListener(lSymAction);
        JButton_Withdraw.addActionListener(lSymAction);
        JButton_Addinterest.addActionListener(lSymAction);
        JButton_report.addActionListener(lSymAction);
    }

    @Override
    public void update(IAccount acc) {
        for (int i = 0; i < JTable1.getRowCount(); i++) {// For each row
            if (model.getValueAt(i, ACC_NUM_COL_IND).equals(acc.getAccountNumber())) {
                updateModelRow(i, acc);
            }
        }
    }

    // When the Exit button is pressed this code gets executed
    // this will exit from the system
    private void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
        System.exit(0);
    }

    private void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
        /*
         * JDialog_AddPAcc type object is for adding personal information construct a
         * JDialog_AddPAcc type object set the boundaries and show it
         */

        java.util.List<String> labels = Arrays.asList("Name", "Email", "Street", "City", "State", "Zipcode",
                "Birth Date", "Account Type");

        EntryDialog pac = new EntryDialog(this, "Add Personal Account", "Create", "Cancel", labels, vals -> {
            IAccount newAcc = controller.addPersonAccount(vals.get(0), vals.get(1), vals.get(2), vals.get(3),
                    vals.get(4), vals.get(5), LocalDate.parse(vals.get(6)), vals.get(7));
            addAccount(newAcc);
            return vals;
        });
        pac.show();
    }

    private void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
        /*
         * construct a JDialog_AddCompAcc type object set the boundaries and show it
         */

        java.util.List<String> labels = Arrays.asList("Name", "Email", "Street", "City", "State", "Zipcode",
                "Number Of Employees", "Account Type");

        EntryDialog pac = new EntryDialog(this, "Add Company Account", "Create", "Cancel", labels, vals -> {
            IAccount newAcc = controller.addCompanyAccount(vals.get(0), vals.get(1), vals.get(2), vals.get(3),
                    vals.get(4), vals.get(5), Integer.parseInt(vals.get(6)), vals.get(7));
            addAccount(newAcc);
            return vals;
        });
        pac.show();

    }

    private void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) model.getValueAt(selection, ACC_NUM_COL_IND);
            IAccount acc = controller.getAccount(accnr);
            // Show the dialog for adding deposit amount for the current mane
            java.util.List<String> labels = Arrays.asList("Name", "Amount");
            EntryDialog dep = new EntryDialog(this, "Deposit", "Submit", "Cancel", labels, vals -> {
                boolean check = controller.addAccountOperation(acc, vals.get(0), Double.parseDouble(vals.get(1)));
                if (!check) {
                    String msgAlert = "Transaction Failed";
                    String titleAlert = "Transaction Alert";
                    showMessage(JButton_Deposit, msgAlert, titleAlert);
                }
                return vals;
            });
            dep.show();
        }
    }

    private void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accnr = (String) model.getValueAt(selection, ACC_NUM_COL_IND);
            IAccount acc = controller.getAccount(accnr);

            // Show the dialog for adding withdraw amount for the current mane
            java.util.List<String> labels = Arrays.asList("Name", "Amount");
            EntryDialog wd = new EntryDialog(this, "Withdraw", "Submit", "Cancel", labels, vals -> {
                boolean check = controller.addAccountOperation(acc, vals.get(0), -Double.parseDouble(vals.get(1)));
                if (!check) {
                    String msgAlert = "Transaction Failed";
                    String titleAlert = "Transaction Alert";
                    showMessage(JButton_Withdraw, msgAlert, titleAlert);
                }
                return vals;
            });
            wd.show();
        }

    }

    private void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
        JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts",
                "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
        controller.addInterest();
    }

    private void JButtonreport_actionPerformed(java.awt.event.ActionEvent event) {
        (new ReportDialog(this, controller.generateReport())).show();
    }

    protected void updateModelRow(int rowNum, IAccount acc) {
        model.setValueAt(acc.getAccountNumber(), rowNum, ACC_NUM_COL_IND);
        model.setValueAt(acc.getOwner().getName(), rowNum, ACC_OWNER_NAME_COL_IND);
        model.setValueAt(acc.getOwner().getEmail(), rowNum, ACC_OWNER_EMAIL_COL_IND);
        model.setValueAt(acc.getOwner().getAddress().getStreet(), rowNum, ACC_OWNER_STREET_COL_IND);
        model.setValueAt(acc.getOwner().getAddress().getCity(), rowNum, ACC_OWNER_CITY_COL_IND);
        model.setValueAt(acc.getOwner().getAddress().getState(), rowNum, ACC_OWNER_STATE_COL_IND);
        model.setValueAt(acc.getOwner().getType(), rowNum, ACC_OWNER_TYPE_COL_IND);
        model.setValueAt(acc.getOwner().getAddress().getZipcode(), rowNum, ACC_OWNER_ZIP_COL_IND);
        model.setValueAt(acc.getBalance(), rowNum, ACC_BALANCE_COL_IND);
        model.setValueAt(acc.getType(), rowNum, ACC_TYPE_COL_IND);
    }

    protected void addAccount(IAccount acc) {
        String[] rowData = new String[NUM_OF_COL];
        rowData[ACC_NUM_COL_IND] = acc.getAccountNumber();
        rowData[ACC_OWNER_NAME_COL_IND] = acc.getOwner().getName();
        rowData[ACC_OWNER_EMAIL_COL_IND] = acc.getOwner().getEmail();
        rowData[ACC_OWNER_STREET_COL_IND] = acc.getOwner().getAddress().getStreet();
        rowData[ACC_OWNER_CITY_COL_IND] = acc.getOwner().getAddress().getCity();
        rowData[ACC_OWNER_STATE_COL_IND] = acc.getOwner().getAddress().getState();
        rowData[ACC_OWNER_TYPE_COL_IND] = acc.getOwner().getType();
        rowData[ACC_OWNER_ZIP_COL_IND] = acc.getOwner().getAddress().getZipcode();
        rowData[ACC_BALANCE_COL_IND] = Double.toString(acc.getBalance());
        rowData[ACC_TYPE_COL_IND] = acc.getType();
        model.addRow(rowData);
    }

    protected void initializeModel() {

        Arrays.asList("Account #", "Name", "Email", "Street", "City", "State", "Customer", "Zip", "Balance", "Type(checking/saving)").stream().forEach(x -> model.addColumn(x));

    }

    private class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_Exit)
                JButtonExit_actionPerformed(event);
            else if (object == JButton_PerAC)
                JButtonPerAC_actionPerformed(event);
            else if (object == JButton_CompAC)
                JButtonCompAC_actionPerformed(event);
            else if (object == JButton_Deposit)
                JButtonDeposit_actionPerformed(event);
            else if (object == JButton_Withdraw)
                JButtonWithdraw_actionPerformed(event);
            else if (object == JButton_Addinterest)
                JButtonAddinterest_actionPerformed(event);
            else if (object == JButton_report)
                JButtonreport_actionPerformed(event);
        }
    }

}
