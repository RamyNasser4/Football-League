package League;

import League.GUI.GUI;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI());

    }
}