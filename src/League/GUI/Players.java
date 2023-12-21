package League.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    public Players(MainPanel main, CardLayout CARD, League league, ArrayList<Player> players) {
        this.league = league;
        this.main=main;
        this.CARD=CARD;
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
                    break;
                }
            }
            if (foundPlayer != null) {
                ArrayList<Player> players=new ArrayList<>();
                players.add(foundPlayer);
                main.add(new Players(main,CARD,league,players));
                CARD.show(main,"Stats" );

            } else {
                JOptionPane.showMessageDialog(null, "Player not found");
            }
        } else if (response == 1) {
            String teamInput = JOptionPane.showInputDialog("Enter the player team name");
        }
    }
}



