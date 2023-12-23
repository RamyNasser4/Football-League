package League.GUI;

import League.League;
import mainPackage.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditReferee extends JPanel {
        MainPanel main;
        CardLayout layout;
        League league;
        String rName;
        String rAge;
        public EditReferee(ArrayList<String> refereenames, League league , MainPanel main , CardLayout cardLayout){
                this.main= main;
                this.league=league;
                this.layout=cardLayout;
                this.setSize(new Dimension(980, 720));
                this.setLayout(new GridLayout(3, 1));
                JPanel titlePanel= new JPanel(new GridLayout(1,1,0,30));
                JLabel titleLabel=new JLabel("Add Referee");
                titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
                titleLabel.setVerticalAlignment(JLabel.TOP);
                titleLabel.setHorizontalAlignment(JLabel.CENTER);
                titlePanel.add(titleLabel);
        }
}
