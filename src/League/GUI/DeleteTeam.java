package League.GUI;

import League.League;
import League.Team.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTeam extends JPanel implements ActionListener {
    JComboBox chooseTeams;
    JButton deleteTeam;
    League league;
    MainPanel main;
    CardLayout cardLayout;
    public DeleteTeam(League league,MainPanel main,CardLayout cardLayout){
        this.league = league;
        this.main = main;
        this.cardLayout = cardLayout;
        this.setSize(new Dimension(980, 720));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JPanel titlePanel = new JPanel(new GridLayout(1, 1));
        JPanel contentPanel=new JPanel(new GridLayout(5, 1,0,30));
        JLabel titleLabel = new JLabel("Delete Team");
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);
        this.add(titlePanel);
        this.add(contentPanel);
        //contentPanel.add(panel2);
        JPanel chooseTeamPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contentPanel.add(chooseTeamPanel);
        chooseTeams = new JComboBox(new DefaultComboBoxModel<>(league.teamnames.toArray()));
        chooseTeams.setSize(new Dimension(500,400));
        chooseTeams.addActionListener(this);
        chooseTeams.setEditable(false);
        chooseTeamPanel.add(chooseTeams);
        
        JPanel deleteTeamPanel = new JPanel();
        deleteTeam = new JButton("Delete Team");
        deleteTeam.setSize(new Dimension(100,30));
        deleteTeam.setFont(new Font("Comic Sans",Font.BOLD,20));
        deleteTeam.setHorizontalAlignment(SwingConstants.CENTER);
        deleteTeam.setFocusable(false);
        deleteTeam.addActionListener(this);
        deleteTeamPanel.add(deleteTeam);
        contentPanel.add(deleteTeamPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteTeam){
            String TeamName = (String) chooseTeams.getSelectedItem();
            league.DeleteTeam(TeamName);
            for (int i = 0; i < league.teamnames.size(); i++) {
                if (league.teamnames.get(i).equalsIgnoreCase(TeamName)){
                    league.teamnames.remove(i);
                }
            }
            System.out.println(league.teamnames);
            main.add(new AddPlayer(league.teamnames),"AddPlayer");
            main.add(new DeleteTeam(league,main,cardLayout),"DeleteTeam");
            cardLayout.show(main,"TeamHome");
        }
    }
}
