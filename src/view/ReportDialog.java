package view;


import javax.swing.*;
import java.awt.*;

public class ReportDialog extends JDialog
{

	public ReportDialog(Frame parent, String billstring)
	{
		super(parent);

		getContentPane().setLayout(null);
		setSize(405,367);
		setVisible(false);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24,24,358,240);
		JScrollPane1.getViewport().add(JTextArea1);
		JTextArea1.setBounds(0,0,355,237);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156,276,96,24);

		JTextArea1.setText(billstring);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
	}



	JScrollPane JScrollPane1 = new JScrollPane();
	JTextArea JTextArea1 = new JTextArea();
	JButton JButton_OK = new JButton();


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
			 
	}
}
