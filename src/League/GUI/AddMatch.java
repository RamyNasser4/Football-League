package League.GUI;

import League.League;
import League.Match.Match;
import League.Person.Referee.Referee;
import League.Stadium.Stadium;
import League.Team.Team;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;

public class AddMatch extends JPanel implements ActionListener, ChangeListener {
    League league;
    MainPanel main;
    CardLayout cardLayout;
    JComboBox chooseTeam1;
    JComboBox chooseTeam2;
    JSpinner dateSpinner;
    JPanel enterScorePanel;
    JLabel enterScoreLabel;
    JPanel ScoreLabelPanel;
    JTextField Team1ScoreInput;
    JLabel ScoreLabel;
    JTextField Team2ScoreInput;
    JPanel YellowCardsPanel;
    JLabel YellowCardsLabel;
    JTextField YellowCardsInput;
    JPanel RedCardsPanel;
    JLabel RedCardsLabel;
    JTextField RedCardsInput;
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
        JPanel contentPanel=new JPanel(new GridLayout(10, 1,0,30));
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // JPanel panel2 = new JPanel(new GridLayout(4, 1,0,50));
        JLabel titleLabel = new JLabel("Add Match");
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);
        this.add(titlePanel);
        this.add(scrollPane);
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
        dateSpinner = new JSpinner(model);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(dateEditor);
        JLabel dateLabel = new JLabel("Choose Date");
        dateLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        dateLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,55));
        datePanel.add(dateLabel);
        datePanel.add(dateSpinner);
        contentPanel.add(datePanel);
        dateSpinner.addChangeListener(this);
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
        //ScoreLabel
        enterScorePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        enterScoreLabel = new JLabel("Enter Score");
        enterScoreLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        enterScoreLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        enterScorePanel.add(enterScoreLabel);
        enterScorePanel.setVisible(false);
        contentPanel.add(enterScorePanel);
        ScoreLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        Team1ScoreInput = new JTextField("");
        Team1ScoreInput.setPreferredSize(new Dimension(100,40));
        ScoreLabelPanel.add(Team1ScoreInput);
        ScoreLabel = new JLabel("-");
        ScoreLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        ScoreLabelPanel.add(ScoreLabel);
        Team2ScoreInput = new JTextField("");
        Team2ScoreInput.setPreferredSize(new Dimension(100,40));
        ScoreLabelPanel.add(Team2ScoreInput);
        contentPanel.add(ScoreLabelPanel);
        ScoreLabelPanel.setVisible(false);
        //Yellow cards Label
        YellowCardsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        YellowCardsLabel = new JLabel("Enter No. Of Yellow cards : ");
        YellowCardsLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        YellowCardsLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        YellowCardsPanel.add(YellowCardsLabel);
        YellowCardsInput = new JTextField("");
        YellowCardsInput.setPreferredSize(new Dimension(100,30));
        YellowCardsPanel.add(YellowCardsInput);
        contentPanel.add(YellowCardsPanel);
        YellowCardsPanel.setVisible(false);
        //Red cards Label
        RedCardsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        RedCardsLabel = new JLabel("Enter No. Of Red cards : ");
        RedCardsLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        RedCardsLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        RedCardsPanel.add(RedCardsLabel);
        RedCardsInput = new JTextField("");
        RedCardsInput.setPreferredSize(new Dimension(100,30));
        RedCardsPanel.add(RedCardsInput);
        contentPanel.add(RedCardsPanel);
        RedCardsPanel.setVisible(false);
        //add match
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
        if (e.getSource()==addMatch){
            String team1Name = (String) chooseTeam1.getSelectedItem();
            String team2Name = (String) chooseTeam2.getSelectedItem();
            Date dateObj = (Date) dateSpinner.getValue();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dateStr = dateFormat.format(dateObj);
            String refereeName = (String) chooseReferee.getSelectedItem();
            String stadiumName = (String) chooseStadium.getSelectedItem();
            Team team1 = league.searchTeam(team1Name);
            Team team2 = league.searchTeam(team2Name);
            Referee referee = league.searchReferee(refereeName);
            Stadium stadium = league.searchStadium(stadiumName);
            int Team1Score;
            int Team2Score;
            int noOfYellowCards;
            int noOfRedCards;
            try {
                Team1Score = Integer.parseInt(Team1ScoreInput.getText());
                Team2Score = Integer.parseInt(Team2ScoreInput.getText());
            }catch (Exception exception){
                Team1Score = -1;
                Team2Score = -1;
            }
            try {
                noOfYellowCards = Integer.parseInt(YellowCardsInput.getText());
            }catch (Exception exception){
                noOfYellowCards = -1;
            }
            try {
                noOfRedCards = Integer.parseInt(RedCardsInput.getText());
            }catch (Exception exception){
                noOfRedCards = -1;
            }
            try {
                Team[] teams = new Team[2];
                teams[0] = team1;
                teams[1] = team2;
                if (Validation(team1,team2,dateStr,Team1Score,Team2Score,referee,stadium,noOfYellowCards,noOfRedCards)){
                    String Score;
                    if (((Date)dateSpinner.getValue()).before(new Date())){
                        Score = Team1Score + "-" + Team2Score;
                        for (int i = 1; i <= Team1Score ; i++) {
                            boolean valid = false;
                            while (!valid) {
                                JPanel goalScorer = new JPanel(new GridLayout(2,1));
                                JComboBox team1players = new JComboBox<>(new DefaultComboBoxModel<>(team1.getPlayernames().toArray()));
                                JLabel message = new JLabel("Who scored the " + i + " goal for the 1st Team");
                                goalScorer.add(message);
                                goalScorer.add(team1players);
                                int playerGoal = JOptionPane.showOptionDialog(this,goalScorer,"Goalscorer",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
                                try {
                                    if (playerGoal != JOptionPane.OK_OPTION){
                                        throw new InputMismatchException();
                                    }
                                    team1.searchPlayer((String) team1players.getSelectedItem()).ScoreGoal();
                                    valid = true;
                                } catch (NullPointerException | InputMismatchException ignored) {

                                }
                            }
                            valid = false;
                            while (!valid){
                                JPanel goalAssist = new JPanel(new GridLayout(2,1));
                                JComboBox team1players = new JComboBox<>(new DefaultComboBoxModel<>(team1.getPlayernames().toArray()));
                                JLabel message = new JLabel("Who assisted the " + i + " goal for the 1st Team");
                                goalAssist.add(message);
                                goalAssist.add(team1players);
                                int playerAssist = JOptionPane.showOptionDialog(this,goalAssist,"GoalAssist",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
                                try {
                                    if (playerAssist != JOptionPane.OK_OPTION){
                                        throw new InputMismatchException();
                                    }
                                    team1.searchPlayer((String) team1players.getSelectedItem()).MakeAssist();
                                    valid = true;
                                } catch (NullPointerException | InputMismatchException ignored) {

                                }
                            }
                        }
                        for (int i = 1; i <= Team2Score ; i++) {
                            boolean valid = false;
                            while (!valid) {
                                JPanel goalScorer = new JPanel(new GridLayout(2,1));
                                JComboBox team2players = new JComboBox<>(new DefaultComboBoxModel<>(team2.getPlayernames().toArray()));
                                JLabel message = new JLabel("Who scored the " + i + " goal for the 2nd Team");
                                goalScorer.add(message);
                                goalScorer.add(team2players);
                                int playerGoal = JOptionPane.showOptionDialog(this,goalScorer,"Goalscorer",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
                                try {
                                    if (playerGoal != JOptionPane.OK_OPTION){
                                        throw new InputMismatchException();
                                    }
                                    team2.searchPlayer((String) team2players.getSelectedItem()).ScoreGoal();
                                    valid = true;
                                } catch (NullPointerException | InputMismatchException ignored) {

                                }
                            }
                            valid = false;
                            while (!valid){
                                JPanel goalAssist = new JPanel(new GridLayout(2,1));
                                JComboBox team2players = new JComboBox<>(new DefaultComboBoxModel<>(team2.getPlayernames().toArray()));
                                JLabel message = new JLabel("Who assisted the " + i + " goal for the 2nd Team");
                                goalAssist.add(message);
                                goalAssist.add(team2players);
                                int playerAssist = JOptionPane.showOptionDialog(this,goalAssist,"GoalAssist",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
                                try {
                                    if (playerAssist != JOptionPane.OK_OPTION){
                                        throw new InputMismatchException();
                                    }
                                    team2.searchPlayer((String) team2players.getSelectedItem()).ScoreGoal();
                                    valid = true;
                                } catch (NullPointerException | InputMismatchException ignored) {

                                }
                            }
                        }
                        for (int i = 1; i <= noOfYellowCards ; i++) {
                            boolean valid = false;
                            while (!valid){
                                JPanel YellowCards = new JPanel(new GridLayout(3,1));
                                JLabel message = new JLabel("Who took the " + i + " yellow card");
                                String[] teamNames = {teams[0].getName(),teams[1].getName()};
                                JComboBox matchTeams = new JComboBox(teamNames);
                                JComboBox teamPlayers = new JComboBox(league.searchTeam((String)matchTeams.getSelectedItem()).getPlayernames().toArray());
                                YellowCards.add(message);
                                YellowCards.add(matchTeams);
                                YellowCards.add(teamPlayers);
                                matchTeams.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        teamPlayers.removeAllItems();
                                        for (String playerName : league.searchTeam((String) matchTeams.getSelectedItem()).getPlayernames()){
                                            teamPlayers.addItem(playerName);
                                        }
                                    }
                                });
                                int playerYellow = JOptionPane.showOptionDialog(this,YellowCards,"Yellow Card",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
                                try {
                                    if (playerYellow != JOptionPane.OK_OPTION){
                                        throw new InputMismatchException();
                                    }
                                    String playerName = (String) teamPlayers.getSelectedItem();
                                    Team playerTeam = league.searchTeam((String) matchTeams.getSelectedItem());
                                    playerTeam.searchPlayer(playerName).MakeYellowCard();
                                    valid = true;
                                }catch (NullPointerException | InputMismatchException ignored){

                                }
                            }
                        }
                        for (int i = 1; i <= noOfRedCards ; i++) {
                            boolean valid = false;
                            while (!valid){
                                JPanel RedCards = new JPanel(new GridLayout(3,1));
                                JLabel message = new JLabel("Who took the " + i + " red card");
                                String[] teamNames = {teams[0].getName(),teams[1].getName()};
                                JComboBox matchTeams = new JComboBox(teamNames);
                                JComboBox teamPlayers = new JComboBox(league.searchTeam((String)matchTeams.getSelectedItem()).getPlayernames().toArray());
                                RedCards.add(message);
                                RedCards.add(matchTeams);
                                RedCards.add(teamPlayers);
                                matchTeams.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        teamPlayers.removeAllItems();
                                        for (String playerName : league.searchTeam((String) matchTeams.getSelectedItem()).getPlayernames()){
                                            teamPlayers.addItem(playerName);
                                        }
                                    }
                                });
                                int playerRed = JOptionPane.showOptionDialog(this,RedCards,"Red Card",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
                                try {
                                    if (playerRed != JOptionPane.OK_OPTION){
                                        throw new InputMismatchException();
                                    }
                                    String playerName = (String) teamPlayers.getSelectedItem();
                                    Team playerTeam = league.searchTeam((String) matchTeams.getSelectedItem());
                                    System.out.println(playerTeam);
                                    playerTeam.searchPlayer(playerName).MakeRedCard();
                                    valid = true;
                                }catch (NullPointerException | InputMismatchException ignored){

                                }
                            }
                        }
                    }else {
                        Score = "";
                    }
                    Match newMatch = new Match(dateStr,teams,referee,Score,stadium);
                    league.AddMatch(newMatch);
                    team1.AddMatch(newMatch);
                    team2.AddMatch(newMatch);
                    stadium.AddMatch(newMatch);
                    if (dateObj.before(new Date())){
                        league.pastMatches.add(newMatch);
                    }else {
                        league.upcomingMatches.add(newMatch);
                    }
                    main.add(new Matches(main,cardLayout,league.upcomingMatches,league.pastMatches,league),"Matches");
                    cardLayout.show(main,"LeagueHome");
                }
            }catch (NullPointerException exp){

            }catch (InputMismatchException exp){
                JOptionPane.showConfirmDialog(this,exp.getMessage(),"Invalid Field",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public boolean Validation(Team team1,Team team2,String DateStr,int Team1Score,int Team2Score,Referee referee,Stadium stadium,int noOfYellowCards,int noOfRedCards){
        Date dateObj = (Date) dateSpinner.getValue();
        Date now = new Date();
        if (team1.getName().equalsIgnoreCase(team2.getName())){
            throw new InputMismatchException("Choose different teams");
        } else if (!team1.checkAvailability(DateStr)) {
            throw new InputMismatchException("Team 1 not available at that date");
        } else if (!team2.checkAvailability(DateStr)) {
            throw new InputMismatchException("Team 2 not available at that date");
        } else if (!referee.checkAvailability(DateStr)) {
            throw new InputMismatchException("Referee not available at that date");
        } else if (!stadium.CheckAvailability(DateStr,false)) {
            throw new InputMismatchException("Stadium not available at that date");
        } else if ((Team1Score == -1 || Team2Score == -1 || Team1Score < 0 || Team2Score < 0) && dateObj.before(now)) {
            throw new InputMismatchException("Invalid Score");
        } /*else if (team1.getTotal() < 11) {
            throw new InputMismatchException("Insufficent 1st team players");
        } else if (team2.getTotal() < 11) {
            throw new InputMismatchException("Insuffienct 2nd team players");
        }*/ else if ((noOfYellowCards < 0 || noOfRedCards < 0) && dateObj.before(now)){
            throw new InputMismatchException("Invalid Input");
        }
        return true;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == dateSpinner) {
            Date dateObJ = (Date) dateSpinner.getValue();
            Date now = new Date();
            if (dateObJ.before(now)){
                enterScorePanel.setVisible(true);
                enterScoreLabel.setVisible(true);
                ScoreLabelPanel.setVisible(true);
                YellowCardsPanel.setVisible(true);
                RedCardsPanel.setVisible(true);
                System.out.println("Visible");
            }else {
                enterScoreLabel.setVisible(false);
                ScoreLabelPanel.setVisible(false);
                YellowCardsPanel.setVisible(false);
                RedCardsPanel.setVisible(false);
                System.out.println("Msh visible");
            }
        }
    }
}
