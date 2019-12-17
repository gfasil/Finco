package view;

import java.util.function.Function;
import java.util.stream.Collectors;

public class EntryDialog extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	java.util.List<String> labels;
	Function<java.util.List<String>, java.util.List<String>> function;

	private static final int DIALOUGE_WIDTH = 298;
	private static final int ENTRY_HEIGHT = 24;
	private static final int INITIAL_ENTRY_Y_OFFSET = 24;
	private static final int ENTRY_LABEL_X_OFFSET = 12;
	private static final int ENTRY_TEXT_FIELD_X_OFFSET = 120;
	private static final int ENTRY_LABEL_WIDTH = 100;
	private static final int ENTRY_TEXT_FIELD_WIDTH = 156;
	private static final int OK_BUTTON_X_OFFSET = 84;
	private static final int OK_BUTTON_WIDTH = 48;
	private static final int CANCEL_BUTTON_X_OFFSET = 156;
	private static final int CANCEL_BUTTON_WIDTH = 84;

	public EntryDialog(MainWindow parent, String title, String submitButtonLabel, String cancelButtonLabel,
			java.util.List<String> labels, Function<java.util.List<String>, java.util.List<String>> function) {
		super(parent);
		setTitle(title);
		setModal(true);
		getContentPane().setLayout(null);
		setVisible(false);

		this.labels = labels;
		this.function = function;
		JLabels = new java.util.ArrayList<javax.swing.JLabel>();
		JTextFields = new java.util.ArrayList<javax.swing.JTextField>();
		setSize(DIALOUGE_WIDTH, ENTRY_HEIGHT * (labels.size() + 6));
		int entryYOffset = INITIAL_ENTRY_Y_OFFSET;
		for (String label : labels) {
			javax.swing.JLabel jLabel = new javax.swing.JLabel();
			JLabels.add(jLabel);
			jLabel.setText(label);
			getContentPane().add(jLabel);
			jLabel.setForeground(java.awt.Color.black);
			jLabel.setBounds(ENTRY_LABEL_X_OFFSET, entryYOffset, ENTRY_LABEL_WIDTH, ENTRY_HEIGHT);

			javax.swing.JTextField jTextField = new javax.swing.JTextField();
			JTextFields.add(jTextField);
			getContentPane().add(jTextField);
			jTextField.setBounds(ENTRY_TEXT_FIELD_X_OFFSET, entryYOffset, ENTRY_TEXT_FIELD_WIDTH, ENTRY_HEIGHT);
			getContentPane().add(jTextField);

			entryYOffset += ENTRY_HEIGHT;
		}
		entryYOffset += 2 * ENTRY_HEIGHT;
		JButton_OK.setText(submitButtonLabel);
		JButton_OK.setActionCommand(submitButtonLabel);
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(OK_BUTTON_WIDTH, entryYOffset, OK_BUTTON_X_OFFSET, ENTRY_HEIGHT);
		JButton_Cancel.setText(cancelButtonLabel);
		JButton_Cancel.setActionCommand(cancelButtonLabel);
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(CANCEL_BUTTON_WIDTH, entryYOffset, CANCEL_BUTTON_X_OFFSET, ENTRY_HEIGHT);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
	}

	public java.util.List<javax.swing.JLabel> JLabels;
	public java.util.List<javax.swing.JTextField> JTextFields;
	public javax.swing.JButton JButton_OK = new javax.swing.JButton();
	public javax.swing.JButton JButton_Cancel = new javax.swing.JButton();

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	public void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		Collectors.toList();
		java.util.List<String> vals = JTextFields.stream().map(javax.swing.JTextField::getText)
				.collect(Collectors.toList());
		function.apply(vals);
		dispose();

	}

	public void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}
}