package atm;

import javax.swing.*;
import java.awt.*;

public class UserProfile {
    private final Account account;

    public UserProfile(String userId) {
        this.account = new Account(userId); // Load account using userId
    }

    public void display() {
        JFrame frame = new JFrame("Welcome User");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JLabel balanceLabel = new JLabel("Balance: Rs " + account.getBalance(), SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(balanceLabel);

        JButton depositButton = new JButton("Deposit Money");
        JButton withdrawButton = new JButton("Withdraw Money");
        JButton historyButton = new JButton("Transaction History");
        JButton logoutButton = new JButton("Logout");

        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(historyButton);
        panel.add(logoutButton);

        frame.add(panel);
        frame.setVisible(true);

        depositButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter amount to deposit:");
            try {
                double amount = Double.parseDouble(input);
                account.deposit(amount);
                balanceLabel.setText("Balance: Rs " + account.getBalance());
                JOptionPane.showMessageDialog(frame, "Deposited Rs " + amount);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid amount.");
            }
        });

        withdrawButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter amount to withdraw:");
            try {
                double amount = Double.parseDouble(input);
                account.withdraw(amount);
                balanceLabel.setText("Balance: Rs " + account.getBalance());
                JOptionPane.showMessageDialog(frame, "Withdrew Rs " + amount);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid amount or insufficient balance.");
            }
        });

        historyButton.addActionListener(e -> {
            new TransactionHistory(account).display();
        });

        logoutButton.addActionListener(e -> {
            frame.dispose();
            new LoginScreen().display();
        });
    }
}
