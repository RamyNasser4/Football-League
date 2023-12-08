package League.GUI;

import javax.swing.*;
import java.awt.*;


public class MatchInfo extends JPanel {
    public MatchInfo() {
        this.setPreferredSize(new Dimension(980, 720));
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(3, 1)); // 3 rows, 1 column

        ImageIcon refereeIcon = new ImageIcon("src/Assets/referee.png");
        ImageIcon dateIcon = new ImageIcon("src/Assets/clock.png");
        ImageIcon stadiumIcon = new ImageIcon("src/Assets/stadium.png");

        JPanel panel1 = new JPanel(new GridLayout(1, 1));
        JPanel panel2 = new JPanel(new GridLayout(1, 2));
        JPanel panel3 = new JPanel(new GridLayout(1, 1));

        JLabel label1 = new JLabel(": Team1 vs Team2");
        label1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
        label1.setForeground(Color.WHITE);
        label1.setHorizontalAlignment(JLabel.CENTER);
        panel1.setBackground(Color.darkGray);
        panel1.add(label1);

        JLabel label2 = new JLabel(": DATE", dateIcon, JLabel.CENTER);
        label2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        label2.setForeground(Color.WHITE);
        label2.setIconTextGap(20);
        panel2.setBackground(Color.gray);
        panel2.add(label2);

        JLabel label3 = new JLabel(": REFEREE", refereeIcon, JLabel.CENTER);
        label3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        label3.setForeground(Color.WHITE);
        label3.setIconTextGap(20);
        panel2.add(label3);

        JLabel label4 = new JLabel(": STADIUM", stadiumIcon, JLabel.CENTER);
        label4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        label4.setForeground(Color.WHITE);
        label4.setIconTextGap(20);
        panel3.setBackground(Color.gray);
        panel3.add(label4);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.setVisible(true);
    }
}