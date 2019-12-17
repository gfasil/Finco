package view;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Finco;
import model.Account;
import model.FincoObservable;
import model.FincoObserver;
import model.IAccount;
import controller.Finco;
import util.ButtonActionListener;
import view.MainWindow.SymAction;
import view.MainWindow.SymWindow;

public class MainWindow extends JFrame implements FincoObserver<IAccount> {
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
	Finco controller;

	protected DefaultTableModel model;
	protected JTable JTable1;
	protected JScrollPane JScrollPane1;

	public MainWindow(Finco controller) {
		this.controller = controller;
		setTitle("Finco");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(575, 310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 575, 310);
		/*
		 * /Add five buttons on the pane /for Adding personal account, Adding company
		 * account /Deposit, Withdraw and Exit from the system
		 */
		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		initializeModel();

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);

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
		JButton_Withdraw.setBounds(468, 164, 96, 33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468, 248, 96, 31);
		// lineBorder1.setRoundedCorners(true);
		// lineBorder1.setLineColor(java.awt.Color.green);
		// $$ lineBorder1.move(24,312);

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

	}

	public javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	public javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	public javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	public javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	public javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	public javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
	public javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	public void exitApplication() {
		try {
			this.setVisible(false); // hide the Frame
			this.dispose(); // free the system resources
			System.exit(0); // close the application
		} catch (Exception e) {
		}
	}

	public class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == MainWindow.this)
				MainWindow_windowClosing(event);
		}
	}

	public void MainWindow_windowClosing(java.awt.event.WindowEvent event) {
		// to do: code goes here.

		MainWindow_windowClosing_Interaction1(event);
	}

	public void MainWindow_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	public class SymAction implements java.awt.event.ActionListener {
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

		}
	}

	// When the Exit button is pressed this code gets executed
	// this will exit from the system
	public void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}

	public void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * JDialog_AddPAcc type object is for adding personal information construct a
		 * JDialog_AddPAcc type object set the boundaries and show it
		 */

		java.util.List<String> labels = Arrays.asList("Name", "Email", "Street", "City", "State", "Zipcode",
				"Birth Date");

		EntryDialog pac = new EntryDialog(this, "Add Personal Account", "Create", "Cancel", labels, vals -> {
			IAccount newAcc = controller.addPersonAccount(vals.get(0), vals.get(1), vals.get(2), vals.get(3),
					vals.get(4), vals.get(5), LocalDate.parse(vals.get(6)));
			addAccount(newAcc);
			return vals;
		});
		pac.show();
	}

	public void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * construct a JDialog_AddCompAcc type object set the boundaries and show it
		 */

		java.util.List<String> labels = Arrays.asList("Name", "Email", "Street", "City", "State", "Zipcode",
				"Number Of Employees");

		EntryDialog pac = new EntryDialog(this, "Add Company Account", "Create", "Cancel", labels, vals -> {
			IAccount newAcc = controller.addCompanyAccount(vals.get(0), vals.get(1), vals.get(2), vals.get(3),
					vals.get(4), vals.get(5), Integer.parseInt(vals.get(6)));
			addAccount(newAcc);
			return vals;
		});
		pac.show();

	}

	public void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, ACC_NUM_COL_IND);
			IAccount acc = controller.getAccount(accnr);
			// Show the dialog for adding deposit amount for the current mane
			java.util.List<String> labels = Arrays.asList("Name", "Amount");
			EntryDialog dep = new EntryDialog(this, "Deposit", "Submit", "Cancel", labels, vals -> {
				controller.addAccountOperation(acc, vals.get(0), Double.parseDouble(vals.get(1)));
				return vals;
			});
			dep.show();
		}
	}

	public void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, ACC_NUM_COL_IND);
			IAccount acc = controller.getAccount(accnr);

			// Show the dialog for adding withdraw amount for the current mane
			java.util.List<String> labels = Arrays.asList("Name", "Amount");
			EntryDialog wd = new EntryDialog(this, "Withdraw", "Submit", "Cancel", labels, vals -> {
				controller.addAccountOperation(acc, vals.get(0), -Double.parseDouble(vals.get(1)));
				return vals;
			});
			wd.show();
		}

	}

	public void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
		JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts",
				"Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
		controller.addInterest();
	}

	@Override
	public void update(IAccount acc) {
		for (int i = 0; i < JTable1.getRowCount(); i++) {// For each row
			if (model.getValueAt(i, ACC_NUM_COL_IND).equals(acc.getAccountNumber())) {
				updateModelRow(i, acc);
			}
		}
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
		model.addColumn("Account #");
		model.addColumn("Name");
		model.addColumn("Email");
		model.addColumn("Street");
		model.addColumn("City");
		model.addColumn("State");
		model.addColumn("Customer");
		model.addColumn("Zip");
		model.addColumn("Balance");
		model.addColumn("Type");
	}

}
