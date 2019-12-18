package view;

import controller.Finco;
import model.FincoObserver;
import model.IAccount;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public abstract class AbstractWindow extends JFrame implements FincoObserver<IAccount> {
    protected Finco controller;
    protected DefaultTableModel model;
    protected JTable JTable1;
    protected JScrollPane JScrollPane1;
    protected JPanel JPanel1 = new JPanel();

    public AbstractWindow(Finco controller) {
        this.controller = controller;
        setTitle("Finco");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setSize(650, 400);
        setVisible(false);
        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0, 0, 650, 500);
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12, 92, 444, 160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
    }

    abstract public void initializeWindow();

    abstract protected void initButtons();

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
            if (object == AbstractWindow.this)
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

    protected abstract void updateModelRow(int rowNum, IAccount acc);

    protected abstract void addAccount(IAccount acc);

    protected abstract void initializeModel();

}
