package League.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import League.League;
 public class GUI extends JFrame implements ActionListener {





public GUI() {
    this.setSize(1280, 720);
    this.setResizable(false);
    this.setTitle("Football League");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new BorderLayout());
    this.setVisible(true);
    SideBar sideBar = new SideBar();
    MatchInfo MatchInfo= new MatchInfo();
    this.getContentPane().add(sideBar,BorderLayout.WEST);
    this.add(MatchInfo);
    PlayerGui PlayerGui = new PlayerGui();
    Matches Matches = new Matches();
    this.add(PlayerGui);

   // this.add(Matches);
   // this.add(MatchInfo);
    //place logo
    //  ImageIcon appicon= new ImageIcon("");
    // this.setIconImage(appicon.getImage());








}

//to be added in match

    @Override
    //to add fields of player subclasses
    public void actionPerformed(ActionEvent e) {
    /*if(e.getSource()== comboBoxBtn){*/
     /*   comboBoxChoice= (String) comboBox.getItemAt(comboBox.getSelectedIndex());
        if(comboBoxChoice.equals("Forward")){
            JTextField tacklesField=new JTextField("Enter shots here");
        }
        else if(comboBoxChoice.equals("Defender")){
            JTextField savesField=new JTextField("Enter Saves here");
            JTextField tacklesField=new JTextField("Enter tackles here");
        }
        else if(comboBoxChoice.equals("Midfielder")){

        }
        else{
            JTextField savesField=new JTextField("Enter Saves here");
            JTextField cleanSheetField=new JTextField("Enter clean sheets here");
        }*/
    }
    }

