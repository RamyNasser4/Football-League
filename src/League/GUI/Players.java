package League.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import League.GUI.Components.playerButton;
import League.League;
import League.Person.Player.Player;
import League.Team.Team;

public class Players extends JPanel implements ActionListener {
    JButton SEARCH;
    JButton TOPSCORERS;
    JButton TOPGKS;
    private League league;
    MainPanel main;
    CardLayout CARD;

    public Players(MainPanel main, CardLayout card, League league) {
        this(main, card, league, new ArrayList<Player>()); // Calls the main constructor with an empty list
    }

    public Players(MainPanel main, CardLayout CARD, League league, ArrayList<Player> players) {
        this.league = league;
        this.main = main;
        this.CARD = CARD;
        this.setBackground(Color.white);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Use Y_AXIS for vertical alignment
        this.setPreferredSize(new Dimension(980, 720));
        TOPGKS = new JButton();
        TOPGKS.setText("TopGKS");
        TOPGKS.setFont(new Font("MVBoli", Font.PLAIN, 30));
        TOPGKS.setBackground(Color.GRAY);
        TOPGKS.setPreferredSize(new Dimension(10, 50));


        TOPSCORERS = new JButton();
        TOPSCORERS.setText("TopScorers");
        TOPSCORERS.setFont(new Font("MVBoli", Font.PLAIN, 30));
        TOPSCORERS.setBackground(Color.GRAY);
        TOPSCORERS.setPreferredSize(new Dimension(10, 50));


        SEARCH = new JButton("Search");
        SEARCH.setFont(new Font("MVBoli", Font.PLAIN, 30));
        SEARCH.setBackground(Color.GRAY);
        SEARCH.setPreferredSize(new Dimension(10, 50));
        SEARCH.addActionListener(this);


        JPanel PANELS = new JPanel(new GridLayout(1, 3));
        PANELS.add(SEARCH);
        PANELS.add(TOPGKS);
        PANELS.add(TOPSCORERS);
        this.add(PANELS);

        for (Player player : players) {
            playerButton playerButton = new playerButton("name:  " + player.getPersonName() + "                 age:  " + player.getPersonAge() + "     team:  " + player.GetPlayerTeam() + "            Goals:  " + player.getGoalsScored() + "    assists:  " + player.getAssists() + "           ", main, CARD, player);
            JPanel panel = new JPanel(new GridLayout(1, 1));
            this.add(panel);
            panel.setSize(980, 50);
            panel.add(playerButton);
            playerButton.setHorizontalAlignment(SwingConstants.LEFT);
            playerButton.setBackground(Color.darkGray);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SEARCH) {
            Search();
        }
    }
    private void Search() {
        String[] options = {"By Name", "By Team"};
        int response = JOptionPane.showOptionDialog(null, "Choose your search type:", "Search",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

        if (response == 0) {
            String nameInput = JOptionPane.showInputDialog("Enter the player name");
            Player foundPlayer = null;
            for (Team team : league.getTeams()) {
                foundPlayer = team.searchPlayer(nameInput);
                if (foundPlayer != null) {
                    // Break the loop only if a player is found
                    break;
                }
            }
            if (foundPlayer != null) {
                PlayerInfo playerInfoPanel = new PlayerInfo(foundPlayer);
                main.add(playerInfoPanel, "PlayerInfo");
                CARD.show(main, "PlayerInfo");
            } else {
                JOptionPane.showMessageDialog(null, "Player not found");
            }
        } else if (response == 1) {
            String teamInput = JOptionPane.showInputDialog("Enter the team name");
            ArrayList<Player> playersByTeam = league.getPlayersByTeamName(teamInput);
            if (!playersByTeam.isEmpty()) {
                String[] playerNames = playersByTeam.stream().map(Player::getPersonName).toArray(String[]::new);
                String selectedPlayerName = (String) JOptionPane.showInputDialog(null, "Select a player:",
                        "Player List", JOptionPane.QUESTION_MESSAGE, null, playerNames, playerNames[0]);

                Player selectedPlayer = playersByTeam.stream()
                        .filter(p -> p.getPersonName().equals(selectedPlayerName))
                        .findFirst().orElse(null);

                if (selectedPlayer != null) {
                    PlayerInfo playerInfoPanel = new PlayerInfo(selectedPlayer);
                    main.add(playerInfoPanel, "PlayerInfo");
                    CARD.show(main, "PlayerInfo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No Team found.");
            }
        }
    }
}



