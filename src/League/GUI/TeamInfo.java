package League.GUI;

import League.Team.Team;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class TeamInfo extends JPanel {
    public TeamInfo(Team team){
        this.setPreferredSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(1, 1));

        JPanel panelContainer = new JPanel(new GridLayout(10, 1));
        JPanel panel1=new JPanel(new GridLayout(1, 1));
        JLabel label1 = new JLabel(team.getName());
        label1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 45));
        label1.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(label1);
        panelContainer.add(panel1);
        this.setVisible(true);

        String CaptainName;
        try {
            CaptainName = team.getCaptain().getPersonName();
        }catch (NullPointerException exp){
            CaptainName = "No Captain";
        }

        JPanel panel2=new JPanel(new GridLayout(1, 1));
        JLabel label = new JLabel("Captain");
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        JTextField field1=new JTextField(CaptainName);
        panel2.add(label);
        panel2.add(field1);
        field1.setEditable(false);
        field1.setFocusable(false);
        panelContainer.add(panel2);

        String CoachName;
        try {
            CoachName = team.getCoach().getPersonName();
        }catch (NullPointerException exp){
            CoachName = "No Coach";
        }


        JPanel panel3=new JPanel(new GridLayout(1, 1));
        JLabel label3 = new JLabel("Coach");
        label3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        JTextField field2=new JTextField(CoachName);
        panel3.add(label3);
        panel3.add(field2);
        field2.setEditable(false);
        field2.setFocusable(false);
        panelContainer.add(panel3);

        JPanel panel4=new JPanel(new GridLayout(1, 1));
        JLabel label4 = new JLabel("Number of Players");
        label4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        JTextField field3=new JTextField(Integer.toString(team.getTotal()));
        panel4.add(label4);
        panel4.add(field3);
        field3.setEditable(false);
        field3.setFocusable(false);
        panelContainer.add(panel4);

        JPanel panel5=new JPanel(new GridLayout(1, 1));
        JLabel label5 = new JLabel("Points");
        label5.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        JTextField field4=new JTextField(Integer.toString(team.getTotal_score()));
        panel5.add(label5);
        panel5.add(field4);
        field4.setEditable(false);
        field4.setFocusable(false);
        panelContainer.add(panel5);

        this.add(panelContainer);

    }
}
