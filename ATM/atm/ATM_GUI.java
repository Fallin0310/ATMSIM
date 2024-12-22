package atm;

import javax.swing.*;
import java.awt.*;

public class ATM_GUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.display();
        });
    }
}
