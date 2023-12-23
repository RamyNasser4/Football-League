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
        this.setLayout(new GridLayout(2, 1));//name,tshirt number , age, position , team , goals , assists, no of yellow/red
        JPanel panel1 = new JPanel(new GridLayout(1, 1));
        JPanel panel2 = new JPanel(new GridLayout(8, 2));

        JLabel label1 = new JLabel("Name: " + player.getPersonName());
        label1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
        label1.setForeground(Color.white);
        label1.setHorizontalAlignment(JLabel.CENTER);
        panel1.setBackground(Color.DARK_GRAY);
        panel1.add(label1);
        this.add(panel1);

        JLabel label2= new JLabel("Age: " + player.getPersonAge());
        label2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        label2.setForeground(Color.black);
        panel2.setBackground(Color.DARK_GRAY);
        panel2.add(label2);
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
        JLabel label3= new JLabel("Position: " + playerPosition);
        label3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        label3.setForeground(Color.black);
        panel2.add(label3);

        JLabel label4= new JLabel("Player Number: " + player.GetPlayerNumber());
        label4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        label4.setForeground(Color.black);
        panel2.add(label4);

        JLabel label5= new JLabel("Team: " + player.GetPlayerTeam());
        label5.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        label5.setForeground(Color.black);
        panel2.add(label5);

        JLabel label6= new JLabel("Goals: " + player.getGoalsScored());
        label6.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        label6.setForeground(Color.black);
        panel2.add(label6);

        JLabel label7= new JLabel("Assists: " + player.getAssists());
        label7.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        label7.setForeground(Color.black);
        panel2.add(label7);

        JLabel label8= new JLabel("Number of Yellow Cards: " + player.getNoOfYellowCards());
        label8.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        label8.setForeground(Color.black);
        panel2.add(label8);

        JLabel label9= new JLabel("Number of Red Cards: " + player.getNoOfRedCards());
        label9.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        label9.setForeground(Color.black);
        panel2.add(label9);

        this.add(panel2);
        panel2.setBorder(BorderFactory.createEmptyBorder(0,100,0,0));
    }
}
