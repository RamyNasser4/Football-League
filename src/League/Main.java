package League;
import javax.swing.*;

import League.GUI.GUI;
import League.GUI.MatchInfo;
import League.GUI.PlayerGui;

public class Main {
    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new GUI());

    }
}