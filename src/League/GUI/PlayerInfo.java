package League.GUI;

import League.Person.Player.Defender;
import League.Person.Player.Forward;
import League.Person.Player.Midfielder;
import League.Person.Player.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerInfo extends JPanel {
    public PlayerInfo(Player player){
        this.setBackground(Color.darkGray);
        this.setSize(980,720);
        this.setLayout(new GridLayout(1, 1));
        JPanel panelContainer = new JPanel(new GridLayout(10, 1));

        JPanel panel1=new JPanel(new GridLayout(1, 1));
        JLabel label1 = new JLabel("Player Highlights");
        label1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        label1.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(label1);
        panelContainer.add(panel1);
        this.setVisible(true);

        JPanel panel2=new JPanel(new GridLayout(1, 1));
        JLabel label = new JLabel("Name");
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        JTextField field1=new JTextField(player.getPersonName());
        panel2.add(label);
        panel2.add(field1);
        field1.setEditable(false);
        field1.setFocusable(false);
        panelContainer.add(panel2);

        JPanel panel3=new JPanel(new GridLayout(1, 1));
        JLabel label2= new JLabel("Age");
        label2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        JTextField field2=new JTextField(Integer.toString(player.getPersonAge()));
        field2.setEditable(false);
        field2.setFocusable(false);
        panel3.add(label2);
        panel3.add(field2);
        panelContainer.add(panel3);

        String playerPosition;
        if (player instanceof Forward){
            playerPosition = "Forward";
        } else if (player instanceof Midfielder) {
            playerPosition = "Midfielder";
        } else if (player instanceof Defender) {
            playerPosition = "Defender";
        }else {
            playerPosition = "Goalkeeper";
        }
        JPanel panel4=new JPanel(new GridLayout(1, 1));
        JLabel label3= new JLabel("Position");
        label3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        JTextField field3=new JTextField(playerPosition);
        field3.setEditable(false);
        field3.setFocusable(false);
        panel4.add(label3);
        panel4.add(field3);
        panelContainer.add(panel4);

        JPanel panel5=new JPanel(new GridLayout(1, 1));
        JLabel label4= new JLabel("Player Number");
        label4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        JTextField field4=new JTextField(Integer.toString(player.GetPlayerNumber()));
        field4.setEditable(false);
        field4.setFocusable(false);
        panel5.add(label4);
        panel5.add(field4);
        panelContainer.add(panel5);

        JPanel panel6=new JPanel(new GridLayout(1, 1));
        JLabel label5= new JLabel("Team");
        label5.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        JTextField field5=new JTextField(player.GetPlayerTeam());
        field5.setEditable(false);
        field5.setFocusable(false);
        panel6.add(label5);
        panel6.add(field5);
        panelContainer.add(panel6);

        JPanel panel7=new JPanel(new GridLayout(1, 1));
        JLabel label6= new JLabel("Goals");
        label6.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        JTextField field6=new JTextField(Integer.toString(player.getGoalsScored()));
        field6.setEditable(false);
        field6.setFocusable(false);
        panel7.add(label6);
        panel7.add(field6);
        panelContainer.add(panel7);

        JPanel panel8=new JPanel(new GridLayout(1, 1));
        JLabel label7= new JLabel("Assists");
        label7.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        JTextField field7=new JTextField(Integer.toString(player.getAssists()));
        field7.setEditable(false);
        field7.setFocusable(false);
        panel8.add(label7);
        panel8.add(field7);
        panelContainer.add(panel8);

        JPanel panel9=new JPanel(new GridLayout(1, 1));
        JLabel label8= new JLabel("Number of Yellow Cards");
        label8.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        JTextField field8=new JTextField(Integer.toString(player.getNoOfYellowCards()));
        field8.setEditable(false);
        field8.setFocusable(false);
        panel9.add(label8);
        panel9.add(field8);
        panelContainer.add(panel9);

        JPanel panel10=new JPanel(new GridLayout(1, 1));
        JLabel label9= new JLabel("Number of Red Cards");
        label9.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        JTextField field9=new JTextField(Integer.toString(player.getNoOfRedCards()));
        field9.setEditable(false);
        field9.setFocusable(false);
        panel10.add(label9);
        panel10.add(field9);
        panelContainer.add(panel10);

        this.add( panelContainer);
        panelContainer.setVisible(true);
    }
}
