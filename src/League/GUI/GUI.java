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
        MainPanel main = new MainPanel(league);
        SideBar sideBar = new SideBar(main, main.cardLayout,league);
        //MatchInfo MatchInfo= new MatchInfo();
        this.getContentPane().add(sideBar, BorderLayout.WEST);
        this.add(main);
            ImageIcon appIcon = new ImageIcon(getClass().getResource("/Assets/league-icon.png"));
            setIconImage(appIcon.getImage());
        //Add Player
        this.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

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

