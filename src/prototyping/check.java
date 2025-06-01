package prototyping;
import javax.swing.*;

public class check extends JFrame {
    private String user;
    private String password;

    // Constructor
    public check(String user, String password) {
        this.user = user;
        this.password = password;

        // Hardcoded credentials
        String[] usernames = {"Taha@012", "Qazi@04", "Micheal_001", "Taha"};
        String[] passwords = {"0405", "0124", "0124", "2005"};
        int[] Balance = {800808,54405,47805,45700,78045};
        boolean isValidUser = false; // Flag to check if the username exists

        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i].equals(user)) {
                isValidUser = true;
                if (passwords[i].equals(password)) { 
                	int balance = Balance[i];
                	new opmain(balance);
                	return; } 
                else {  JOptionPane.showMessageDialog(null, "Invalid Password", "Error", 1);  return; }
            }}

        if (!isValidUser) { JOptionPane.showMessageDialog(null, "Invalid Username", "Error", 1);  }   }



}
