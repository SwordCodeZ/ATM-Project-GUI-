package prototyping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainmenus extends JFrame implements ActionListener {
    private JButton checkBalanceButton, helpButton, withdrawButton, exitButton, confirmButton;
    private JTextField amountField;
    private JLabel inputLabel;
    private int balance;

    // Constructor
    public mainmenus(int balance) {
        this.balance = balance;
        ImageIcon icon = new ImageIcon("logo.png");
        this.setIconImage(icon.getImage());

        // Frame settings
        setTitle("American Express");
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Header Text
        JLabel headerText = new JLabel("American Express", SwingConstants.CENTER);
        headerText.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));
        headerText.setForeground(Color.WHITE);
        headerText.setBounds(500, 50, 600, 60);

        JLabel subHeaderText = new JLabel("M A I N   M E N U", SwingConstants.CENTER);
        subHeaderText.setFont(new Font("Arial", Font.PLAIN, 20));
        subHeaderText.setForeground(Color.WHITE);
        subHeaderText.setBounds(500, 120, 600, 30);

        // Buttons with individual properties
        checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setFont(new Font("Arial", Font.BOLD, 20));
        checkBalanceButton.setBounds(700, 300, 200, 50);
        checkBalanceButton.addActionListener(this);

        helpButton = new JButton("Help");
        helpButton.setFont(new Font("Arial", Font.BOLD, 20));
        helpButton.setBounds(700, 370, 200, 50);
        helpButton.addActionListener(this);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setFont(new Font("Arial", Font.BOLD, 20));
        withdrawButton.setBounds(700, 440, 200, 50);
        withdrawButton.addActionListener(this);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.setBounds(700, 510, 200, 50);
        exitButton.addActionListener(this);

        // Text field for input (initially hidden)
        inputLabel = new JLabel("Enter Withdrawal Amount:");
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        inputLabel.setForeground(Color.WHITE);
        inputLabel.setBounds(600, 600, 300, 30);
        inputLabel.setVisible(false);

        amountField = new JTextField();
        amountField.setFont(new Font("Arial", Font.PLAIN, 20));
        amountField.setBounds(900, 600, 200, 30);
        amountField.setVisible(false);

        confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("Arial", Font.BOLD, 20));
        confirmButton.setBounds(750, 650, 150, 40);
        confirmButton.addActionListener(this);
        confirmButton.setVisible(false);

        // Background color setup
        getContentPane().setBackground(new Color(0, 56, 118)); // UBL-like blue background

        // Add components to the frame
        add(headerText);
        add(subHeaderText);
        add(checkBalanceButton);
        add(helpButton);
        add(withdrawButton);
        add(exitButton);
        add(inputLabel);
        add(amountField);
        add(confirmButton);

        // Frame visibility
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkBalanceButton) {
            JOptionPane.showMessageDialog(this, "Your current balance is " + balance + " $");
        } 
        else if (e.getSource() == helpButton) {
            JOptionPane.showMessageDialog(this, "For assistance, contact customer support.");
        } 
        else if (e.getSource() == withdrawButton) {
            // Show text field and confirm button
            inputLabel.setVisible(true);
            amountField.setVisible(true);
            confirmButton.setVisible(true);
        } 
        else if (e.getSource() == confirmButton) {
            try {
                int withdrawAmount = Integer.parseInt(amountField.getText());
                // Check if withdrawal amount is a multiple of 500
                if (withdrawAmount % 500 != 0) {
                    JOptionPane.showMessageDialog(this, "Amount must be a multiple of 500.");
                    return;
                }
                // Check if balance is sufficient
                if (withdrawAmount <= balance) {
                    balance -= withdrawAmount;
                    JOptionPane.showMessageDialog(this, "Withdrawal successful!\nRemaining Balance: " + balance + " $");
                    amountField.setText(""); // Clear the text field
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient Balance.\nYour balance: " + balance + " $");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
            }
        } 
        else if (e.getSource() == exitButton) {
            JOptionPane.showMessageDialog(this, "Thank you for using American Express!");
            System.exit(0);
        }
    }
}
