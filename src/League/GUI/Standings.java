package League.GUI;


import League.League;
import League.Match.Match;
import League.Team.Team;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;


public class Standings extends JPanel implements MouseListener{
    public JTable table;
    Object[][] AllData ;
    Object[][] TableData  ;
    Object[][] AvgData ;
    Object[][] GoalData ;


League league;
    MainPanel mainPanel;
    CardLayout cardLayout;

    public Standings(MainPanel mainPanel,CardLayout cardLayout ,League league) {
        this.mainPanel=mainPanel;
        this.cardLayout=cardLayout;
        this.league=league;
        try {
            // Applying Nimbus Look and Feel
            //UIManager.setLookAndFeel("javax.swing.pilaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }



        AllData=new Object[league.getTeams().size()][4];
        for (int i = 0; i < league.getTeams().size(); i++) {
            ArrayList<Match> pastMatches = new ArrayList<Match>();
            Date now = new Date();
            for (Match match : league.DisplayTeamByAvgAge().get(i).getMatches()){
                if (match.getDate().before(now)){
                    pastMatches.add(match);
                }
            }
            AllData[i][0] = league.getTeams().get(i).getName();
            AllData[i][1] =  league.getTeams().get(i).getTotal_score();
            AllData[i][2] =   league.getTeams().get(i).getPlayers().size();
            AllData[i][3] =   pastMatches.size();





        }

        TableData=AllData;

        DefaultTableModel model = new DefaultTableModel(
                AllData,
                new Object[]{"Team", "Score", "players", "Played"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // This makes all cells non-editable
            }
        };

        table = new JTable(model);

        table.getTableHeader().setReorderingAllowed(false);

        table.addMouseListener(this);

        table.setForeground(Color.WHITE);
        table.setBackground(new Color(0, 0, 0));
        table.setFont(new Font("Arial", Font.BOLD, 16));
        table.setRowHeight(40);
        table.setGridColor(Color.LIGHT_GRAY);
        table.setIntercellSpacing(new Dimension(10, 10));
        table.repaint();
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800, 600));

        // Customizing the header row appearance
        JTableHeader header = table.getTableHeader();
        JViewport viewport = scrollPane.getViewport();
        viewport.setBackground(Color.darkGray);
        header.setForeground(Color.white);
        header.setBackground(Color.BLACK); // Change header background color
        header.setFont(new Font("Arial", Font.BOLD, 18));

        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                thumbColor = Color.WHITE;
                trackColor = Color.DARK_GRAY;
            }
        });

        JButton ByPoints = new JButton("All teams");
        ByPoints.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                AllData=new Object[league.getTeams().size()][4];
                for (int i = 0; i < league.getTeams().size(); i++) {
                    ArrayList<Match> pastMatches = new ArrayList<Match>();
                    Date now = new Date();
                    for (Match match : league.DisplayTeamByAvgAge().get(i).getMatches()){
                        if (match.getDate().before(now)){
                            pastMatches.add(match);
                        }
                    }
                    AllData[i][0] = league.getTeams().get(i).getName();
                    AllData[i][1] = league.getTeams().get(i).getTotal_score();
                    AllData[i][2] = league.getTeams().get(i).getPlayers().size();
                    AllData[i][3] = pastMatches.size();
                }
                model.setDataVector(AllData,  new Object[]{"Team", "Score", "players", "Played"});
            }
        });


        JPanel buttonPanel = new JPanel();
        JButton showListButton = new JButton("average age");
        showListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {



                // Prepare data for the table model
                AvgData = new Object[league.DisplayTeamByAvgAge().size()][4];
                for (int i = 0; i < league.DisplayTeamByAvgAge().size(); i++) {
                    ArrayList<Match> pastMatches = new ArrayList<Match>();
                    Date now = new Date();
                    for (Match match : league.DisplayTeamByAvgAge().get(i).getMatches()){
                        if (match.getDate().before(now)){
                            pastMatches.add(match);
                        }
                    }
                    AvgData[i][0] = league.DisplayTeamByAvgAge().get(i).getName();
                    AvgData[i][1] = league.DisplayTeamByAvgAge().get(i).GetAvgTeamAge();
                    AvgData[i][2] =  league.DisplayTeamByAvgAge().get(i).getPlayers().size();
                    AvgData[i][3] = pastMatches.size();
                }
                TableData=AvgData;
                model.setDataVector(AvgData,  new Object[]{"Team", "average age", "players", "Played"});
            }
        });


        JButton ByGoals = new JButton("Goals");
        ByGoals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                GoalData=new Object[league.DisplayTeamsByGoals().size()][4];
                for (int i = 0; i < league.DisplayTeamsByGoals().size(); i++) {
                    ArrayList<Match> pastMatches = new ArrayList<Match>();
                    Date now = new Date();
                    for (Match match : league.DisplayTeamByAvgAge().get(i).getMatches()){
                        if (match.getDate().before(now)){
                            pastMatches.add(match);
                        }
                    }
                    GoalData[i][0] = league.DisplayTeamsByGoals().get(i).getName();
                    GoalData[i][1] = league.DisplayTeamsByGoals().get(i).GetTeamGoals();
                    GoalData[i][2] =  league.DisplayTeamsByGoals().get(i).getPlayers().size();
                    GoalData[i][3] = pastMatches.size();;
                }
                TableData=GoalData;
                model.setDataVector(GoalData,  new Object[]{"Team", "Goals", "players", "Played"});
            }

        });
        buttonPanel.add(showListButton);
        buttonPanel.add(ByPoints);
        buttonPanel.add(ByGoals);
        buttonPanel.add(new JButton("Total "+String.valueOf(league.getTeams().size())));

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setBackground(new Color(240, 240, 240));
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int column = 0;
        int row = table.rowAtPoint(e.getPoint());
        String TeamName=(String) TableData[row][column];
        Team team=league.searchTeam(TeamName);
        mainPanel.add(new TeamInfo(team),"TeamInfo");
        cardLayout.show(mainPanel,"TeamInfo");

    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
