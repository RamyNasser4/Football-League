package League.GUI;

import League.League;
import mainPackage.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GUI extends JFrame implements ActionListener, WindowListener {
    League league;
    public GUI(League league) {
        this.league = league;
        this.setSize(1280, 720);
        this.setResizable(false);
        this.setTitle("Football League");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
    /*PlayerGui PlayerGui = new PlayerGui();
    Matches Matches = new Matches(this);*/
        MainPanel main = new MainPanel();
        SideBar sideBar = new SideBar(main, main.cardLayout);
        //MatchInfo MatchInfo= new MatchInfo();
        this.getContentPane().add(sideBar, BorderLayout.WEST);
        this.add(main);
        //this.add(MatchInfo);

        //this.add(PlayerGui);
        //this.add(Matches);
        //this.add(MatchInfo);
        //place logo
        //  ImageIcon appicon= new ImageIcon("");
        // this.setIconImage(appicon.getImage());
        //Add Player


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

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        Main.WriteFiles(league);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}

