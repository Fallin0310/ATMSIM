package atm;

import javax.swing.*;

public class LoginScreen {
    public void display() {
        JFrame frame = new JFrame("Welcome Please Login To Continue");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, frame);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel, JFrame frame) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User ID:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(e -> {
            String userId = userText.getText();
            String password = new String(passwordText.getPassword());
        
            if (authenticate(userId, password)) {
                frame.dispose();
                new UserProfile(userId).display(); // Pass userId to UserProfile
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid login credentials!");
            }
        });
    }

    private boolean authenticate(String userId, String password) {
        // Dummy authentication
        return "user".equals(userId) && "1234".equals(password);
    }
}
