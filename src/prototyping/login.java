package prototyping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame implements ActionListener {
    // Declare components
    JPanel logpanel;
    JPanel backpanel;
    JLabel label = new JLabel();
    JTextField user;
    JPasswordField password;
    JButton login;
    int k = -1;
    // Constructor
    public login() {
    	
    	/*
    	 * icon
    	 */
        ImageIcon icon = new ImageIcon("logo.png");  
		this.setIconImage(icon.getImage()); 

		
        /*
         * Setting frame properties
         */
        this.setTitle("American Express");
        this.setSize(1600, 900);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        /*
         * Create panels
         */
        logpanel = new JPanel();          //pannel for login  and seprate
        logpanel.setLayout(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column, 10px padding
        logpanel.setPreferredSize(new Dimension(400, 200)); 
        logpanel.setOpaque(false); 

        backpanel = new JPanel();         //backscreen panel
        backpanel.setLayout(new GridBagLayout()); // Use GridBagLayout for centering
        ImageIcon back = new ImageIcon("back.jpg");
        label.setIcon(back);
        backpanel.add(label);
        
        
        
        /*
         * Username field with icon
         */
        JPanel userPanel = new JPanel(new BorderLayout());

        ImageIcon usericon = new ImageIcon("Username.png"); // Adding icon as JLabel
        JLabel userIcon = new JLabel(usericon);

        user = new JTextField(); // Adding text box
        user.setBorder(BorderFactory.createTitledBorder("Username"));
        user.setFont(new Font("Arial",Font.ITALIC,20));
        userPanel.add(userIcon, BorderLayout.WEST); // Panel
        userPanel.add(user, BorderLayout.CENTER);
        userPanel.setOpaque(false);
        logpanel.add(userPanel); // Add this panel to logpanel to display in frame

        
        
        
        /*
         * Password field with icon
         */
        JPanel passwordPanel = new JPanel(new BorderLayout());

        ImageIcon p = new ImageIcon("Password.png");
        JLabel passwordIcon = new JLabel(p); // Create JLabel for the icon

        password = new JPasswordField();
        password.setBorder(BorderFactory.createTitledBorder("Password"));
        
        passwordPanel.add(passwordIcon, BorderLayout.WEST);
        passwordPanel.add(password, BorderLayout.CENTER);
        passwordPanel.setOpaque(false);
        logpanel.add(passwordPanel);

        
        
        /*===============
            Login button
          ===============*/
        login = new JButton("Login");
        login.setPreferredSize(new Dimension(200, 70)); // Set button size
        login.addActionListener(this);
        logpanel.add(login); 

        
        
        /*
         *  Add logpanel to backpanel and set it in the center
         */
        backpanel.setLayout(null); 
        label.setLayout(new GridBagLayout()); 
        label.setBounds(0, 0, 1600, 900); 
        label.add(logpanel); // Add logpanel to the label

        this.add(backpanel); // Add backpanel to the frame
    }

    
    
    @SuppressWarnings("unused")
    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == login) {
    		k++;
            String users = user.getText();
            char[] pas = password.getPassword();
            String Password1 = new String(pas);
            check checker = new check(users, Password1);
            if(k==2) {
            JOptionPane.showMessageDialog(null, "Your Card is block due to invalid password or username", "Account Temporary Block", 0);
            login.setEnabled(false);
            this.dispose();}
            }

}}
