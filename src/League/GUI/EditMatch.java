package League.GUI;

import League.League;
import League.Match.Match;
import League.Person.Player.Player;
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

public class EditMatch extends JPanel implements ActionListener, ChangeListener {
    League league;
    MainPanel main;
    CardLayout cardLayout;
    JComboBox chooseMatch;
    JComboBox chooseTeam1;
    JComboBox chooseTeam2;
    JSpinner dateSpinner;
    JComboBox chooseReferee;
    JComboBox chooseStadium;
    JPanel enterScorePanel;
    JLabel enterScoreLabel;
    JTextField Team1ScoreInput;
    JLabel ScoreLabel;
    JTextField Team2ScoreInput;
    JButton editMatch;
    ArrayList<String> refereeNames;
    ArrayList<String> stadiumNames;
    public EditMatch(League league, MainPanel main, CardLayout cardLayout){
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
        JPanel contentPanel = new JPanel(new GridLayout(11, 1,0,30));
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // JPanel panel2 = new JPanel(new GridLayout(4, 1,0,50));
        JLabel titleLabel = new JLabel("Edit Match");
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);
        this.add(titlePanel);
        //this.add(contentPanel);
        this.add(scrollPane);
        //contentPanel.add(panel2);
        //choose Match
        JPanel chooseMatchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contentPanel.add(chooseMatchPanel);
        JLabel chooseMatchLabel = new JLabel("Choose Match : ");
        chooseMatchLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        chooseMatchLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,20));
        chooseMatchPanel.add(chooseMatchLabel);
        ArrayList<Integer> MatchesID = new ArrayList<Integer>();
        for (Match match : league.getMatches()){
            MatchesID.add(match.getMatch_ID());
        }
        chooseMatch = new JComboBox(MatchesID.toArray());
        chooseMatchPanel.add(chooseMatch);
        chooseMatch.addActionListener(this);
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
        dateSpinner.addChangeListener(this);
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
        //ScoreLabel
        enterScorePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        enterScoreLabel = new JLabel("Enter Score : ");
        enterScoreLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        enterScoreLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,25));
        enterScorePanel.add(enterScoreLabel);
        enterScorePanel.setVisible(false);
        contentPanel.add(enterScorePanel);
        Team1ScoreInput = new JTextField("");
        Team1ScoreInput.setPreferredSize(new Dimension(100,40));
        enterScorePanel.add(Team1ScoreInput);
        ScoreLabel = new JLabel("-");
        ScoreLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        enterScorePanel.add(ScoreLabel);
        Team2ScoreInput = new JTextField("");
        Team2ScoreInput.setPreferredSize(new Dimension(100,40));
        enterScorePanel.add(Team2ScoreInput);
        //edit match
        JPanel editMatchPanel = new JPanel();
        editMatch = new JButton("Edit Match");
        editMatch.setSize(new Dimension(100,30));
        editMatch.setFont(new Font("Comic Sans",Font.BOLD,20));
        editMatch.setHorizontalAlignment(SwingConstants.CENTER);
        editMatch.setFocusable(false);
        editMatch.addActionListener(this);
        editMatchPanel.add(editMatch);
        contentPanel.add(editMatchPanel);
        try {
            int MatchID = (int) chooseMatch.getSelectedItem();
            Match match = league.searchMatch(MatchID);
            System.out.println(match);
            String team1Name = match.getTeams()[0].getName();
            chooseTeam1.setSelectedItem(team1Name);
            String team2Name = match.getTeams()[1].getName();
            chooseTeam2.setSelectedItem(team2Name);
            Date matchDate = match.getDate();
            dateSpinner.setValue(matchDate);
            String refereeName = match.getReferee().getPersonName();
            chooseReferee.setSelectedItem(refereeName);
            String stadiumName = match.getStadium().getStadiumName();
            chooseStadium.setSelectedItem(stadiumName);
            String Score = match.getScore();
            String Team1Score = Score.split("-")[0];
            String Team2Score = Score.split("-")[1];
            Team1ScoreInput.setText(Team1Score);
            Team2ScoreInput.setText(Team2Score);
        }catch (NullPointerException ignored){

        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editMatch) {
            int MatchID = (int) chooseMatch.getSelectedItem();
            Match match = league.searchMatch(MatchID);
            String team1Name = (String) chooseTeam1.getSelectedItem();
            String team2Name = (String) chooseTeam2.getSelectedItem();
            Date dateObj = (Date) dateSpinner.getValue();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dateStr = dateFormat.format(dateObj);
            String refereeName = (String) chooseReferee.getSelectedItem();
            String stadiumName = (String) chooseStadium.getSelectedItem();
            Team team1 = league.searchTeam(team1Name);
            Team team2 = league.searchTeam(team2Name);
            Team[] teams = new Team[2];
            Referee referee = league.searchReferee(refereeName);
            Stadium stadium = league.searchStadium(stadiumName);
            int Team1Score;
            int Team2Score;
            try {
                Team1Score = Integer.parseInt(Team1ScoreInput.getText());
                Team2Score = Integer.parseInt(Team2ScoreInput.getText());
            }catch (Exception exception){
                Team1Score = -1;
                Team2Score = -1;
            }
            try {

                if (Validation(match,team1,team2,dateStr,Team1Score,Team2Score,referee,stadium)){
                    try {
                        match.getTeams()[0].deleteMatch(MatchID);
                        Team CurrentTeam1 = league.searchTeam(team1Name);
                        team1.AddMatch(match);
                    }catch (Exception ignored){
                    }
                    try {
                        match.getTeams()[1].deleteMatch(MatchID);
                        Team CurrentTeam2 = league.searchTeam(team2Name);
                        team2.AddMatch(match);
                    }catch (Exception ignored){

                    }

                    match.setMatchDate(dateStr);
                    Date now = new Date();
                    ArrayList<Player> team1Scorers = new ArrayList<Player>();
                    ArrayList<Player> team2Scorers = new ArrayList<>();
                    ArrayList<Player> team1Assisters = new ArrayList<>();
                    ArrayList<Player> team2Assisters = new ArrayList<>();
                    if (((Date) dateSpinner.getValue()).before(now)){
                        String Score = Team1Score + "-" + Team2Score;
                        match.setScore(Score);
                        match.setTeam1score(Team1Score);
                        match.setTeam2score(Team2Score);
                        for (Player player : match.getTeam1Scorers()){
                            player.setGoalsScored(player.getGoalsScored()-1);
                        }
                        for (Player player : match.getTeam2Scorers()){
                            player.setGoalsScored(player.getGoalsScored()-1);
                        }
                        for (Player player : match.getTeam1Assisters()){
                            player.setAssists(player.getAssists()-1);
                        }
                        for (Player player : match.getTeam2Assisters()){
                            player.setAssists(player.getAssists()-1);
                        }
                        for (int i = 1; i <= Team1Score ; i++) {
                            boolean valid = false;
                            //1st team goalscorer
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
                                    team1Scorers.add(team1.searchPlayer((String) team1players.getSelectedItem()));
                                    valid = true;
                                } catch (NullPointerException | InputMismatchException ignored) {

                                }
                            }
                            valid = false;
                            //2nd team goalscorer
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
                                    team1Assisters.add(team1.searchPlayer((String) team1players.getSelectedItem()));
                                    valid = true;
                                } catch (NullPointerException | InputMismatchException ignored) {

                                }
                            }
                        }
                        for (int i = 1; i <= Team2Score ; i++) {
                            boolean valid = false;
                            //team 2 goalscorers
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
                                    team2Scorers.add(team2.searchPlayer((String) team2players.getSelectedItem()));
                                    valid = true;
                                } catch (NullPointerException | InputMismatchException ignored) {

                                }
                            }
                            valid = false;
                            //team 2 assisters
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
                                    team2.searchPlayer((String) team2players.getSelectedItem()).MakeAssist();
                                    team2Assisters.add(team2.searchPlayer((String) team2players.getSelectedItem()));
                                    valid = true;
                                } catch (NullPointerException | InputMismatchException ignored) {
                                }
                            }
                        }
                        match.setTeam1Scorers(team1Scorers);
                        match.setTeam1Assisters(team1Assisters);
                        match.setTeam2Scorers(team2Scorers);
                        match.setTeam2Assisters(team2Assisters);
                    }
                    match.setTeams(teams);
                    match.getReferee().deleteMatch(MatchID);
                    referee.AddMatch(match);
                    match.setReferee(referee);
                    match.getStadium().deleteMatch(MatchID);
                    stadium.AddMatch(match);
                    match.setStadium(stadium);
                    main.add(new Matches(main,cardLayout,league.upcomingMatches,league.pastMatches,league),"Matches");
                    cardLayout.show(main,"LeagueHome");
                }
            }catch (InputMismatchException exp){
                JOptionPane.showConfirmDialog(this,exp.getMessage(),"Invalid Field",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == chooseMatch) {
            try {
                int MatchID = (int) chooseMatch.getSelectedItem();
                Match match = league.searchMatch(MatchID);
                System.out.println(match);
                String team1Name = match.getTeams()[0].getName();
                chooseTeam1.setSelectedItem(team1Name);
                String team2Name = match.getTeams()[1].getName();
                chooseTeam2.setSelectedItem(team2Name);
                Date matchDate = match.getDate();
                dateSpinner.setValue(matchDate);
                String refereeName = match.getReferee().getPersonName();
                chooseReferee.setSelectedItem(refereeName);
                String stadiumName = match.getStadium().getStadiumName();
                chooseStadium.setSelectedItem(stadiumName);
                String Score = match.getScore();
                System.out.println(Score);
                String Team1Score = Score.split("-")[0];
                String Team2Score = Score.split("-")[1];
                Team1ScoreInput.setText(Team1Score);
                Team2ScoreInput.setText(Team2Score);
            }catch (NullPointerException | ArrayIndexOutOfBoundsException ignored){

            }

        }
    }
    public boolean Validation(Match match,Team team1,Team team2,String DateStr,int Team1Score,int Team2Score,Referee referee,Stadium stadium) {
        Date dateObj = (Date) dateSpinner.getValue();
        Date now = new Date();
        if (team1.getName().equalsIgnoreCase(team2.getName())) {
            throw new InputMismatchException("Choose different teams");
        } else if (!team1.checkAvailability(DateStr) && !match.getDate().equals(dateObj)) {
            throw new InputMismatchException("Team 1 not available at that date");
        } else if (!team2.checkAvailability(DateStr) && !match.getDate().equals(dateObj)) {
            throw new InputMismatchException("Team 2 not available at that date");
        } else if (!referee.checkAvailability(DateStr) && !match.getDate().equals(dateObj)) {
            throw new InputMismatchException("Referee not available at that date");
        } else if (!stadium.CheckAvailability(DateStr) && !match.getDate().equals(dateObj)) {
            throw new InputMismatchException("Stadium not available at that date");
        } else if (match.getDate().before(now) && (!dateObj.equals(match.getDate()))) {
            throw new InputMismatchException("Can't update date of past match");
        } else if (match.getDate().before(now) && (Team1Score < 0 || Team2Score < 0)) {
            throw new InputMismatchException("Invalid Score");
        } else if (match.getDate().after(now) && dateObj.before(now)) {
            throw new InputMismatchException("Date must be upcoming");
        }   /*else if (team1.getTotal() < 11) {
            throw new InputMismatchException("Insufficent 1st team players");
        } else if (team2.getTotal() < 11) {
            throw new InputMismatchException("Insuffienct 2nd team players");
        }*/
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
                System.out.println("Visible");
            }else {
                enterScorePanel.setVisible(false);
                enterScoreLabel.setVisible(false);
                System.out.println("Msh visible");
            }
        }
    }
}
