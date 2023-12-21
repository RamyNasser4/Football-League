package League.GUI;

import League.League;
import League.Person.Referee.Referee;
import League.Stadium.Stadium;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AddMatch extends JPanel implements ActionListener {
    League league;
    MainPanel main;
    CardLayout cardLayout;
    JComboBox chooseTeam1;
    JComboBox chooseTeam2;
    JComboBox chooseReferee;
    JComboBox chooseStadium;
    JButton addMatch;
    ArrayList<String> refereeNames;
    ArrayList<String> stadiumNames;
    public AddMatch(League league,MainPanel main,CardLayout cardLayout){
        this.league = league;
        this.main = main;
        this.cardLayout = cardLayout;
        refereeNames = new ArrayList<>();
        for (Referee referee : league.getReferees()){
            refereeNames.add(referee.getPersonName());
        }
        stadiumNames = new ArrayList<>();
        for (Stadium stadium : league.getStadiums()){
            stadiumNames.add(stadium.getStadiumName());
        }
        this.setSize(new Dimension(980, 720));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JPanel titlePanel = new JPanel(new GridLayout(1, 1));
        JPanel contentPanel=new JPanel(new GridLayout(6, 1,0,30));
        // JPanel panel2 = new JPanel(new GridLayout(4, 1,0,50));
        JLabel titleLabel = new JLabel("Add Match");
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);
        this.add(titlePanel);
        this.add(contentPanel);
        //contentPanel.add(panel2);
        //1st team 
        JPanel chooseTeam1Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel chooseTeam1Label = new JLabel("Choose Team 1");
        chooseTeam1Label.setFont(new Font("Comic Sans",Font.BOLD,20));
        chooseTeam1Label.setBorder(BorderFactory.createEmptyBorder(0,10,0,27));
        chooseTeam1Panel.add(chooseTeam1Label);
        chooseTeam1 = new JComboBox(new DefaultComboBoxModel<>(league.teamnames.toArray()));
        chooseTeam1.addActionListener(this);
        chooseTeam1.setEditable(false);
        chooseTeam1Panel.add(chooseTeam1);
        contentPanel.add(chooseTeam1Panel);
        //2nd team
        JPanel chooseTeam2Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel chooseTeam2Label = new JLabel("Choose Team 2");
        chooseTeam2Label.setFont(new Font("Comic Sans",Font.BOLD,20));
        chooseTeam2Label.setBorder(BorderFactory.createEmptyBorder(0,10,0,27));
        chooseTeam2Panel.add(chooseTeam2Label);
        chooseTeam2 = new JComboBox(new DefaultComboBoxModel<>(league.teamnames.toArray()));
        chooseTeam2.addActionListener(this);
        chooseTeam2.setEditable(false);
        chooseTeam2Panel.add(chooseTeam2);
        contentPanel.add(chooseTeam2Panel);
        //Date
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        SpinnerDateModel model = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        JSpinner dateSpinner = new JSpinner(model);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(dateEditor);
        JLabel dateLabel = new JLabel("Choose Date");
        dateLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        dateLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,55));
        datePanel.add(dateLabel);
        datePanel.add(dateSpinner);
        contentPanel.add(datePanel);
        //Referee
        JPanel refereePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel refereeLabel = new JLabel("Choose Referee");
        refereeLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        refereeLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,25));
        refereePanel.add(refereeLabel);
        chooseReferee = new JComboBox(new DefaultComboBoxModel<>(refereeNames.toArray()));
        chooseReferee.addActionListener(this);
        chooseReferee.setEditable(false);
        refereePanel.add(chooseReferee);
        contentPanel.add(refereePanel);
        //Stadium
        JPanel stadiumPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel stadiumLabel = new JLabel("Choose Stadium");
        stadiumLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        stadiumLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,25));
        stadiumPanel.add(stadiumLabel);
        chooseStadium = new JComboBox(new DefaultComboBoxModel<>(stadiumNames.toArray()));
        chooseStadium.addActionListener(this);
        chooseStadium.setEditable(false);
        stadiumPanel.add(chooseStadium);
        contentPanel.add(stadiumPanel);
        JPanel addMatchPanel = new JPanel();
        addMatch = new JButton("Add Match");
        addMatch.setSize(new Dimension(100,30));
        addMatch.setFont(new Font("Comic Sans",Font.BOLD,20));
        addMatch.setHorizontalAlignment(SwingConstants.CENTER);
        addMatch.setFocusable(false);
        addMatch.addActionListener(this);
        addMatchPanel.add(addMatch);
        contentPanel.add(addMatchPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
