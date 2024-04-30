package BudgetApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BudgetGUI {
    private JFrame frame;
    private JTextField incomeField;
    private JTextField expenseField;
    private JLabel balanceLabel;

    private double balance;

    public BudgetGUI() {
        balance = BalanceManager.loadBalance();

        frame = new JFrame("Budgeting App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);
        frame.setLayout(new GridLayout(3, 2));

        JLabel incomeLabel = new JLabel("Income: $");
        incomeField = new JTextField();

        JLabel expenseLabel = new JLabel("Expense: $");
        expenseField = new JTextField();

        JButton incomeButton = getIncomeButton();

        JButton expenseButton = getExpenseButton();

        balanceLabel = new JLabel("Balance: $" + balance);

        frame.add(incomeLabel);
        frame.add(incomeField);
        frame.add(incomeButton);
        frame.add(expenseLabel);
        frame.add(expenseField);
        frame.add(expenseButton);
        frame.add(balanceLabel);

        frame.setVisible(true);

        // Save the balance when the GUI is closed
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                BalanceManager.saveBalance(balance);
            }
        });
    }

    private JButton getExpenseButton() {
        JButton expenseButton = new JButton("Add Expense");
        expenseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double expense = Double.parseDouble(expenseField.getText());
                    if (expense > balance) {
                        JOptionPane.showMessageDialog(frame, "Insufficient balance!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        balance -= expense;
                        updateBalanceLabel();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input for expense!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return expenseButton;
    }

    private JButton getIncomeButton() {
        JButton incomeButton = new JButton("Add Income");
        incomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double income = Double.parseDouble(incomeField.getText());
                    balance += income;
                    updateBalanceLabel();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input for income!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return incomeButton;
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: $" + String.format("%.2f", balance));
    }


    }

