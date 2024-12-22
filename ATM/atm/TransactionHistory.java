package atm;

import javax.swing.*;
import java.awt.*;

public class TransactionHistory {
    private final Account account;

    public TransactionHistory(Account account) {
        this.account = account;
    }

    public void display() {
        JFrame frame = new JFrame("Transaction History");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea historyArea = new JTextArea();
        historyArea.setEditable(false);

        for (String transaction : account.getTransactionHistory()) {
            historyArea.append(transaction + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(historyArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
