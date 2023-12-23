package League.GUI;

import League.League;
import League.Person.Person;
import League.Person.Referee.Referee;

import javax.swing.*;
import javax.xml.validation.Validator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AddReferee extends JPanel {
    League league;
    MainPanel main;
    CardLayout layout;
    public AddReferee(League league, MainPanel main, CardLayout cardLayout){
        this.league=league;
        this.main=main;
        this.layout=cardLayout;
        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(2, 1));
        JPanel titlePanel= new JPanel(new GridLayout(1,1,0,30));
        JLabel titleLabel=new JLabel("Add Referee");
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);


        JPanel allPanel = new JPanel(new GridLayout(2,2,20,50));

        JPanel namePanel = new JPanel(new GridLayout(1, 1));
        JLabel nameLabel = new JLabel("Name");
        namePanel.add(nameLabel);
        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        JTextField nameField = new JTextField("");
        namePanel.add(nameField);
        allPanel.add(namePanel);

        JPanel agePanel = new JPanel(new GridLayout(1, 1));
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        agePanel.add(ageLabel);
        JTextField ageField = new JTextField("");
        agePanel.add(ageField);
        allPanel.add(agePanel);

        JButton saveButton=new JButton("Save");
        saveButton.setFocusable(false);
        saveButton.setFont(new Font("Comic Sans",Font.BOLD,20));

        allPanel.add(saveButton);
        this.add(titlePanel);
        this.add(allPanel);
        this.setVisible(true);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= nameField.getText();
                String age = ageField.getText();


                if (!Validation(name,age)){

                }
                else {

                    try{
                        int ageValue= Integer.parseInt(age);
                        Referee referee=new Referee(name,ageValue);
                        league.AddReferee(referee);
                        JOptionPane.showMessageDialog(null, "Referee saved successfully");
                        nameField.setText("");
                        ageField.setText("");
                    }
                    catch(NumberFormatException exp){
                        JOptionPane.showMessageDialog(null,"Enter a valid age");
                    }
                    main.add(new AddMatch(league,main,cardLayout),"AddMatch");
                    cardLayout.show(main,"RefereeHome");
                    main.add(new DeleteReferee(league,main,cardLayout),"DeleteReferee");
                }
            }

        });

    }

    public boolean Validation(String name, String Age){
        if (name.isEmpty()||Age.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please fill all fields");
            return false;
        }
        else {
            return true;
        }
    }
}
