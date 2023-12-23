package League.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import League.GUI.Components.playerButton;
import League.League;
import League.Person.Player.Goalkeeper;
import League.Person.Player.Player;
import League.Team.Team;

public class Players extends JPanel implements ActionListener {
    JButton SEARCH;
    JButton TOPSCORERS;
    JButton TOPGKS;
    JButton FILTERBYTEAM;
    JButton RESET;
    private League league;
    MainPanel main;
    CardLayout CARD;
    private JTable playersTable;
    private DefaultTableModel tableModel;

    public Players(MainPanel main, CardLayout card, League league) {
        this(main, card, league, new ArrayList<Player>());
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


        FILTERBYTEAM = new JButton("Team");
        FILTERBYTEAM.setFont(new Font("MVBoli", Font.PLAIN, 30));
        FILTERBYTEAM.setBackground(Color.GRAY);
        FILTERBYTEAM.setPreferredSize(new Dimension(10, 50));
        FILTERBYTEAM.addActionListener(this);

        RESET = new JButton("Reset");
        RESET.setFont(new Font("MVBoli", Font.PLAIN, 30));
        RESET.setBackground(Color.GRAY);
        RESET.setPreferredSize(new Dimension(10, 50));
        RESET.addActionListener(this);


        JPanel PANELS = new JPanel(new GridLayout(1, 5)); // Change grid layout to accommodate 4 buttons
        PANELS.add(FILTERBYTEAM);
        PANELS.add(TOPGKS);
        PANELS.add(TOPSCORERS);
        PANELS.add(SEARCH);
        PANELS.add(RESET);
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
        String[] columnNames = {"Name", "Team", "Goals", "Assists"};
        tableModel = new DefaultTableModel(columnNames, 0);
        playersTable = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // This will make all cells in the table non-editable.
            }
        };
        loadAllPlayers();
        TOPGKS.addActionListener(this);
        TOPSCORERS.addActionListener(this);


        playersTable.setFillsViewportHeight(true);
        playersTable.setRowHeight(30);
        playersTable.setFont(new Font("SansSerif", Font.PLAIN, 18));
        playersTable.setBackground(Color.DARK_GRAY);
        playersTable.setForeground(Color.BLACK);
        // bug fix
        playersTable.getTableHeader().setReorderingAllowed(false);
        playersTable.getTableHeader().setResizingAllowed(false);


        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        cellRenderer.setBackground(Color.DARK_GRAY);
        cellRenderer.setForeground(Color.BLACK);


        for (int i = 0; i < playersTable.getColumnCount(); i++) {
            playersTable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }


        JTableHeader header = playersTable.getTableHeader();
        header.setBackground(Color.DARK_GRAY);
        header.setForeground(Color.BLACK);
        header.setFont(new Font("SansSerif", Font.BOLD, 18));


        JScrollPane scrollPane = new JScrollPane(playersTable);
        scrollPane.setPreferredSize(new Dimension(950, 400));
        this.add(scrollPane);


        playersTable.repaint();
        playersTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = playersTable.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    String playerName = (String) tableModel.getValueAt(row, 0);
                    Player selectedPlayer = findPlayerByName(playerName);
                    if (selectedPlayer != null) {
                        PlayerInfo playerInfoPanel = new PlayerInfo(selectedPlayer);
                        main.add(playerInfoPanel, "PlayerInfo");
                        CARD.show(main, "PlayerInfo");
                    }
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SEARCH) {
            updateTableStructure("search");
            Search();
        } else if (e.getSource() == TOPSCORERS) {
            updateTableStructure("scorers");
            displayTopScorers();
        } else if (e.getSource() == TOPGKS) {
            updateTableStructure("goalkeepers");
            displayTopGoalkeepers();
        } else if (e.getSource() == FILTERBYTEAM) {
            filterByTeam();
        }
        else if (e.getSource() == RESET) {
            resetTable();
        }
    }


    private void displayTopScorers() {
        Player[] topScorersArray = league.DisplayTopScorers();
        ArrayList<Player> topScorersList = convertArrayToList(topScorersArray);
        updateTableWithPlayers(topScorersList, "scorers");
    }

    private void displayTopGoalkeepers() {
        Player[] topKeepersArray = league.DisplayTopGoalKeepers();
        ArrayList<Player> topKeepersList = convertArrayToList(topKeepersArray);
        updateTableWithPlayers(topKeepersList, "goalkeepers");
    }
    private void filterByTeam() {
        String teamName = JOptionPane.showInputDialog("Enter Team Name:");
        if (teamName != null && !teamName.isEmpty()) {
            ArrayList<Player> filteredPlayers = league.getPlayersByTeamName(teamName);
            updateTableWithPlayers(filteredPlayers, "default");
        }
    }

    private void loadAllPlayers() {
        updateTableStructure("default"); // Use default table structure for loading all players
        ArrayList<Player> allPlayers = league.getAllPlayers();
        updateTableWithPlayers(allPlayers, "default"); // Use default type for updating table with all players
    }
    private Player findPlayerByName(String name) {
        for (Team team : league.getTeams()) {
            Player player = team.searchPlayer(name);
            if (player != null) {
                return player;
            }
        }
        return null;
    }

    private ArrayList<Player> convertArrayToList(Player[] playersArray) {
        ArrayList<Player> playersList = new ArrayList<>();
        for (Player player : playersArray) {
            if (player != null) { // Check if the player is not null before adding
                playersList.add(player);
            }
        }
        return playersList;
    }


    private void updateTableWithPlayers(ArrayList<Player> players, String type) {
        tableModel.setRowCount(0); // Clear existing data
        for (Player player : players) {
            Object[] rowData;

            if ("goalkeepers".equals(type) && player instanceof Goalkeeper) {
                Goalkeeper goalkeeper = (Goalkeeper) player;
                rowData = new Object[]{
                        player.getPersonName(),
                        player.GetPlayerTeam(),
                        goalkeeper.GetSaves()
                };
            } else {
                // scorers or default
                rowData = new Object[]{
                        player.getPersonName(),
                        player.GetPlayerTeam(),
                        player.getGoalsScored(),
                        type.equals("scorers") ? null : player.getAssists()
                };
            }
            tableModel.addRow(rowData);
        }
        playersTable.revalidate();
        playersTable.repaint();
        updateCellRenderers();
    }

    private void updateTableStructure(String type) {
        if ("scorers".equals(type)) {
            String[] columnNames = {"Name", "Team", "Goals"};
            tableModel.setColumnIdentifiers(columnNames);
        } else if ("goalkeepers".equals(type)) {
            String[] columnNames = {"Name", "Team", "Saves"};
            tableModel.setColumnIdentifiers(columnNames);
        } else if ("search".equals(type)) {
            String[] columnNames = {"Name", "Team"};
            loadAllPlayers();
            tableModel.setColumnIdentifiers(columnNames);
        } else {
            String[] columnNames = {"Name", "Team", "Goals", "Assists"};
            tableModel.setColumnIdentifiers(columnNames);
        }
        updateCellRenderers();
    }

    private void updateCellRenderers() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < playersTable.getColumnCount(); i++) {
            playersTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    private void resetTable() {
        updateTableStructure("default");
        loadAllPlayers();
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



