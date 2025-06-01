package prototyping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class opmain extends JFrame implements ActionListener {
    private JButton button1, button2, button3, button4, mainMenuButton;
    
    int balance;
    // Constructor to initialize GUI components
    public opmain(int b) {
        this.balance = b;
        ImageIcon icon = new ImageIcon("logo.png");  
        this.setIconImage(icon.getImage()); 
        // Frame settings
        setTitle("American Express");
        setSize(1600, 900); // Set JFrame size to 1600x900
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(20, 20)); // BorderLayout to manage overall layout more flexibly

        // Header panel with text at the top
        addHeaderPanel();

        // Panel setup for buttons
        JPanel buttonPanel = createButtonPanel();

        // Add button panel to the center of the frame
        add(buttonPanel, BorderLayout.CENTER);

        // Frame visibility
        setVisible(true);
    }

    // Method to create and return header panel
    private void addHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 56, 118)); // UBL-like Blue
        JLabel headerText = new JLabel("Select Your Amount");
        headerText.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50)); // Font size 50, bold, italic
        headerText.setForeground(Color.WHITE); // Set text color to white
        headerPanel.add(headerText);
        add(headerPanel, BorderLayout.NORTH); // Add header panel to the top
    }

    // Method to create and return the button panel
    private JPanel createButtonPanel() {
        // Panel setup for buttons
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 56, 118)); // UBL-like Blue
        panel.setLayout(new GridLayout(3, 2, 20, 20)); // GridLayout for 3 rows, 2 columns of buttons

        // Initialize buttons with default color and reduced height
        button1 = new JButton("10,000$");
        button1.setFont(new Font("Arial", Font.BOLD, 20)); // Font size 20, bold
        button1.setPreferredSize(new Dimension(200, 50)); // Reduced height to half
        button1.addActionListener(this);

        button2 = new JButton("5,000$");
        button2.setFont(new Font("Arial", Font.BOLD, 20)); // Font size 20, bold
        button2.setPreferredSize(new Dimension(200, 50)); // Reduced height to half
        button2.addActionListener(this);

        button3 = new JButton("20,000$");
        button3.setFont(new Font("Arial", Font.BOLD, 20)); // Font size 20, bold
        button3.setPreferredSize(new Dimension(200, 50)); // Reduced height to half
        button3.addActionListener(this);

        button4 = new JButton("25,000$");
        button4.setFont(new Font("Arial", Font.BOLD, 20)); // Font size 20, bold
        button4.setPreferredSize(new Dimension(200, 50)); // Reduced height to half
        button4.addActionListener(this);

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 20)); // Font size 20, bold
        mainMenuButton.setPreferredSize(new Dimension(200, 50)); // Reduced height to half
        mainMenuButton.addActionListener(this);

        // Add buttons to panel
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(mainMenuButton);

        return panel;
    }

    // Method to return the ActionListener for all buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check which button was pressed using e.getSource()
        if (e.getSource() == button1) {
            button1.setBackground(UIManager.getColor("Button.background")); // Default button color
            if (balance >= 10000) { // Corrected condition
                balance = balance - 10000;
                JOptionPane.showMessageDialog(null, "Your current balance is " + balance + " $");return;
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");return;
            }
        } 
        else if (e.getSource() == button2) {
            button2.setBackground(UIManager.getColor("Button.background")); // Default button color
            if (balance >= 5000) { // Corrected condition
                balance = balance - 5000;
                JOptionPane.showMessageDialog(null, "Your current balance is " + balance + " $");return;
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");return;
            }                
        } 
        else if (e.getSource() == button3) {
            button3.setBackground(UIManager.getColor("Button.background")); // Default button color
            if (balance >= 20000) { // Corrected condition
                balance = balance - 20000;
                JOptionPane.showMessageDialog(null, "Your current balance is " + balance + " $");return;
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");return;
            }
        } 
        else if (e.getSource() == button4) {
            button4.setBackground(UIManager.getColor("Button.background")); // Default button color
            if (balance >= 25000) { // Corrected condition
                balance = balance - 25000;
                JOptionPane.showMessageDialog(null, "Your current balance is " + balance + " $");
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient Balance"); return;
            }
        }
        else if (e.getSource() == mainMenuButton) {
            JOptionPane.showMessageDialog(null, "Returning to Main Menu");
            new mainmenus(balance);
            this.dispose();
        }
    }
}
