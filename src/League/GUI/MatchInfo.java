package League.GUI;

import League.Match.Match;

import javax.swing.*;
import java.awt.*;
import java.util.Date;


public class MatchInfo extends JPanel {
    public MatchInfo(Match match) {
        this.setPreferredSize(new Dimension(980, 720));
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(3, 1)); // 3 rows, 1 column

        ImageIcon refereeIcon = new ImageIcon("src/Assets/referee.png");
        ImageIcon dateIcon = new ImageIcon("src/Assets/clock.png");
        ImageIcon stadiumIcon = new ImageIcon("src/Assets/stadium.png");

        JPanel panel1 = new JPanel(new GridLayout(1, 1));
        JPanel panel2 = new JPanel(new GridLayout(1, 2));
        JPanel panel3 = new JPanel(new GridLayout(1, 1));
        Date now = new Date();
        JLabel label1;
        if (match.matchdate.before(now)){
            label1 = new JLabel(match.getTeams()[0].getName() + " " + match.getScore() + " " + match.getTeams()[1].getName() );
        }else {
            label1 = new JLabel(match.getTeams()[0].getName() + " vs " + match.getTeams()[1].getName() );
        }
        label1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
        label1.setForeground(Color.WHITE);
        label1.setHorizontalAlignment(JLabel.CENTER);
        panel1.setBackground(Color.darkGray);
        panel1.add(label1);
        JLabel label2 = new JLabel(": " + match.matchDate, dateIcon, JLabel.CENTER);
        label2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        label2.setForeground(Color.WHITE);
        label2.setIconTextGap(20);
        panel2.setBackground(Color.gray);
        panel2.add(label2);

        JLabel label3 = new JLabel(": " + match.getReferee().getPersonName(), refereeIcon, JLabel.CENTER);
        label3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        label3.setForeground(Color.WHITE);
        label3.setIconTextGap(20);
        panel2.add(label3);

        JLabel label4 = new JLabel(": " + match.getStadium().getStadiumName(), stadiumIcon, JLabel.CENTER);
        label4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        label4.setForeground(Color.WHITE);
        label4.setIconTextGap(20);
        panel3.setBackground(Color.gray);
        panel3.add(label4);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.setVisible(false);
    }
}