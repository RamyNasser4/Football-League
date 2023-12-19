package League.GUI;

import League.Team.Team;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class TeamInfo extends JPanel {
    public TeamInfo(Team team){
        this.setPreferredSize(new Dimension(980, 720));
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(4, 1)); // 3 rows, 1 column

        JPanel panel1 = new JPanel(new GridLayout(1, 1));
        JPanel panel2 = new JPanel(new GridLayout(1, 2));
        JPanel panel3 = new JPanel(new GridLayout(1, 1));
        JPanel panel4 = new JPanel(new GridLayout(1,1));
        JLabel label1 = new JLabel(team.getName());
        label1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
        label1.setForeground(Color.WHITE);
        label1.setHorizontalAlignment(JLabel.CENTER);
        panel1.setBackground(Color.darkGray);
        panel1.add(label1);
        String CaptainName;
        try {
            CaptainName = team.getCaptain().getPersonName();
        }catch (NullPointerException exp){
            CaptainName = "";
        }
        JLabel label2 = new JLabel("Captain : " + CaptainName ,JLabel.CENTER);
        label2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        label2.setForeground(Color.WHITE);
        label2.setIconTextGap(20);
        panel2.setBackground(Color.gray);
        panel2.add(label2);
        String CoachName;
        try {
            CoachName = team.getCoach().getPersonName();
        }catch (NullPointerException exp){
            CoachName = "";
        }
        JLabel label3 = new JLabel("Coach : " + CoachName, JLabel.CENTER);
        label3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        label3.setForeground(Color.WHITE);
        label3.setIconTextGap(20);
        panel2.add(label3);
        JLabel label4 = new JLabel("No. of players : " + team.getTotal(), JLabel.CENTER);
        label4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        label4.setForeground(Color.WHITE);
        label4.setIconTextGap(20);
        panel3.setBackground(Color.gray);
        panel3.add(label4);
        JLabel label5 = new JLabel("Points : " + team.getTotal_score(),JLabel.CENTER);
        label5.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        label5.setForeground(Color.WHITE);
        label5.setIconTextGap(20);
        panel3.add(label5);
        JLabel label6 = new JLabel("No. of matches : " + team.getNoOfMatches(),JLabel.CENTER);
        label6.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        label6.setForeground(Color.WHITE);
        label6.setIconTextGap(20);
        panel4.add(label6);
        panel4.setBackground(Color.gray);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.setVisible(false);
    }
}
