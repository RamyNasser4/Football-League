package League.GUI;

import javax.swing.*;
import java.awt.*;


public class MatchInfo extends JPanel {
    public MatchInfo() {
        this.setPreferredSize(new Dimension(980, 720));
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(3, 1)); // Adjusted to 3 rows, 1 column

        JPanel panel1 = new JPanel(new GridLayout(1, 1));
        JPanel panel2 = new JPanel(new GridLayout(1, 2));
        JPanel panel3 = new JPanel(new GridLayout(1, 1));

        JPanel panelLabel1 = createPanel("Team1 vs Team2", Color.darkGray);
        JPanel panelLabel2 = createPanel("DATE", Color.gray);
        JPanel panelLabel3 = createPanel("REFEREE", Color.gray);
        JPanel panelLabel4 = createPanel("STADIUM", Color.gray);

        Font bigFont = new Font(Font.SANS_SERIF, Font.BOLD, 60);
        JLabel label1 = (JLabel) panelLabel1.getComponent(0);
        label1.setFont(bigFont);

        panel1.add(panelLabel1);
        panel2.add(panelLabel2);
        panel2.add(panelLabel3);
        panel3.add(panelLabel4);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.setVisible(true);
    }

    // create panel with label
    private JPanel createPanel(String labelText, Color panelColor) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(labelText);

        Font boldFont = new Font(Font.SANS_SERIF, Font.BOLD, 40);
        Color whiteColor = Color.WHITE;

        label.setFont(boldFont);
        label.setForeground(whiteColor);
        label.setHorizontalAlignment(JLabel.CENTER);

        panel.add(label, BorderLayout.CENTER);
        panel.setBackground(panelColor);

        return panel;
    }
}