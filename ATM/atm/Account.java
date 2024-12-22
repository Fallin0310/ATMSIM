package atm;

import java.io.*;
import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<String> transactionHistory;
    private final String userId;

    public Account(String userId) {
        this.userId = userId;
        this.transactionHistory = new ArrayList<>();
        this.balance = loadBalance();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: Rs " + amount);
            saveBalance();
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: Rs " + amount);
            saveBalance();
        } else {
            throw new IllegalArgumentException("Insufficient funds or invalid amount.");
        }
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    private double loadBalance() {
        File file = new File(userId + "_balance.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                return Double.parseDouble(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.err.println("Error loading balance for user " + userId + ": " + e.getMessage());
            }
        }
        return 1000.0; // Default initial balance
    }

    private void saveBalance() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userId + "_balance.txt"))) {
            writer.write(String.valueOf(balance));
        } catch (IOException e) {
            System.err.println("Error saving balance for user " + userId + ": " + e.getMessage());
        }
    }
}
