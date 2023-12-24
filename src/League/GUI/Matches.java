package League.GUI;

import League.GUI.Components.MatchButton;
import League.League;
import League.Match.Match;
import League.Team.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Matches extends JPanel implements ActionListener {
    JButton Search;
    JComboBox Searchbyteam;
    MainPanel main;
    CardLayout cardLayout;
    League league;

    public Matches(MainPanel main, CardLayout cardLayout, ArrayList<Match> upcomingMatches, ArrayList<Match> pastMatches, League league) {
        this.main = main;
        this.cardLayout = cardLayout;
        this.league = league;
        this.setPreferredSize(new Dimension(980, 720));
        this.setBackground(Color.darkGray);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        // Create a JPanel to hold your matches
        JPanel matchesPanel = new JPanel();
        matchesPanel.setLayout(new BoxLayout(matchesPanel, BoxLayout.Y_AXIS));
        matchesPanel.setBackground(Color.darkGray);
        //Search button
        Search = new JButton("Search By Date");
        Search.setBackground(Color.darkGray);
        Search.setForeground(Color.white);
        Search.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        Search.setFocusable(false);
        Border line = BorderFactory.createLineBorder(Color.white, 2);
        Border empty = BorderFactory.createEmptyBorder(5, 15, 5, 15);
        Search.setBorder(new CompoundBorder(line, empty));
        Search.addActionListener(this);
        JPanel SearchContainer = new JPanel();
        SearchContainer.setLayout(new FlowLayout(FlowLayout.RIGHT));
        SearchContainer.setBackground(Color.darkGray);
        SearchContainer.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        SearchContainer.add(Search);
        matchesPanel.add(SearchContainer);
        //Combo box for each team to display matches
        String defaultValue = "Select a Team"; // Change the default value
        Searchbyteam = new JComboBox(new DefaultComboBoxModel<>(league.teamNames.toArray()));
        Searchbyteam.addItem(defaultValue);
        Searchbyteam.setSelectedItem(defaultValue);
        Searchbyteam.setBackground(Color.darkGray);
        Searchbyteam.setForeground(Color.white);
        Searchbyteam.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        Searchbyteam.setFocusable(false);
        Searchbyteam.setBorder(new CompoundBorder(line, empty));
        Searchbyteam.addActionListener(this);
        JPanel SearchContainerbyteam = new JPanel();
        SearchContainerbyteam.setLayout(new FlowLayout(FlowLayout.LEFT));
        SearchContainerbyteam.setBackground(Color.darkGray);
        SearchContainerbyteam.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        SearchContainerbyteam.add(Searchbyteam);
        matchesPanel.add(SearchContainerbyteam);
        JLabel upcoming = new JLabel("Upcoming Matches");
        upcoming.setForeground(Color.white);
        upcoming.setBackground(Color.darkGray);
        upcoming.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        upcoming.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        matchesPanel.add(upcoming);
        upcoming.setAlignmentX(0.5f);
        for (Match match : upcomingMatches) {
            MatchButton matchButton = new MatchButton(match.getTeams()[0].getName() + " vs " + match.getTeams()[1].getName(), main, cardLayout, match);
            matchesPanel.add(matchButton);
        }
        JLabel past = new JLabel("Past Matches");
        past.setForeground(Color.white);
        past.setBackground(Color.darkGray);
        past.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        past.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        matchesPanel.add(past);
        past.setAlignmentX(0.5f);
        for (Match match : pastMatches) {
            MatchButton matchButton = new MatchButton(match.getTeams()[0].getName() + " " + match.getScore() + " " + match.getTeams()[1].getName(), main, cardLayout, match);
            matchesPanel.add(matchButton);
        }
        JScrollPane scrollPane = new JScrollPane(matchesPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Search) {
            SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
            JSpinner dateSpinner = new JSpinner(dateModel);
            JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
            dateSpinner.setEditor(dateEditor);
            int result = JOptionPane.showConfirmDialog(this, dateSpinner, "Select Date", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                Date selectedDate = (Date) dateSpinner.getValue();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                ArrayList<Match> currentDateMatches = league.Display_match_ByDateFN(dateFormat.format(selectedDate));
                Date now = new Date();
                Matches searchedMatches;
                if (selectedDate.before(now)) {
                    searchedMatches = new Matches(main, cardLayout, new ArrayList<>(), currentDateMatches, league);
                } else {
                    searchedMatches = new Matches(main, cardLayout, currentDateMatches, new ArrayList<>(), league);
                }
                main.add(searchedMatches, "Matches");
                cardLayout.show(main, "Matches");
            }
        } else if (e.getSource() == Searchbyteam) {
            String selectedTeam = (String) Searchbyteam.getSelectedItem();

            // Check if 'None' is selected and show all matches
            if ("Select a Team".equals(selectedTeam)) {
                main.add(new Matches(main, cardLayout, league.upcomingMatches, league.pastMatches, league), "SearchedMatches");
                cardLayout.show(main, "SearchedMatches");
                return;
            }

            Team searched = league.searchTeam(selectedTeam);

            try {
                ArrayList<Match> searchedMatch = searched.getMatches();
                ArrayList<Match> upcoming = new ArrayList<>();
                ArrayList<Match> past = new ArrayList<>();
                Date now = new Date();

                for (Match match : searchedMatch) {
                    if (match.getDate().before(now)) {
                        past.add(match);
                    } else {
                        upcoming.add(match);
                    }

                }


                main.add(new Matches(main, cardLayout, upcoming, past, league), "SearchedMatches");
                cardLayout.show(main, "SearchedMatches");


                Searchbyteam.setSelectedItem("Select a Team");
            } catch (NullPointerException exp) {
                // Handle case where the selected team has no matches or doesn't exist
                JOptionPane.showMessageDialog(this, "No matches found for the selected team.", "No Matches", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
