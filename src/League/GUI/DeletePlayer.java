package League.GUI;

import League.League;
import League.Person.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static League.League.searchByNameAndTeam;


public class DeletePlayer extends JPanel {
    public DeletePlayer(ArrayList<String> teamnames,League league){
        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(2, 1));
        JPanel titlepanel = new JPanel(new GridLayout(1, 1,0,30));
        JPanel contentPanel=new JPanel(new GridLayout(8, 1));
        JPanel panel2 = new JPanel(new GridLayout(1, 1,0,50));
        JLabel titleLabel = new JLabel("Delete Player");
        JLabel title2Label = new JLabel("Search by Team and Name");
        title2Label.setFont(new Font("Comic Sans",Font.BOLD,15));
        title2Label.setVerticalAlignment(JLabel.TOP);
        title2Label.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlepanel.add(title2Label);
        contentPanel.add(titleLabel);
        this.add(titlepanel);
        this.add(contentPanel);
        contentPanel.add(titlepanel);

        JPanel teampanel = new JPanel(new GridLayout(1, 1));
        JLabel teamLabel = new JLabel("Player Team");
        teamLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
        teampanel.add(teamLabel);
        JComboBox teamComboBox = new JComboBox(new DefaultComboBoxModel<>(teamnames.toArray()));
        teampanel.add(teamComboBox);

        contentPanel.add(teampanel);





        JButton searchButton=new JButton("Search");
        searchButton.setFocusable(false);
        searchButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        contentPanel.add(searchButton);

        searchButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String team;
                try {
                    team = (String) teamComboBox.getItemAt(teamComboBox.getSelectedIndex());
                }
                catch(NullPointerException exp){
                    team="null";
                    JOptionPane.showMessageDialog(null, "No teams exist");
                }
                JPanel namepanel = new JPanel(new GridLayout(1, 1));
                JLabel nameLabel = new JLabel("Player Name");
                nameLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
                namepanel.add(nameLabel);
                JComboBox nameComboBox =new JComboBox(new DefaultComboBoxModel<>(league.searchTeam(team).getPlayernames().toArray()));
                namepanel.add(nameComboBox);
                String name;
                try {
                    name = (String) nameComboBox.getItemAt(teamComboBox.getSelectedIndex());
                }
                catch(NullPointerException exp){
                    name="null";
                    JOptionPane.showMessageDialog(null, "No Players in team");
                }
                panel2.add(namepanel);
                boolean found=false;
                try {
                    for (String s : teamnames) {
                        if (s.equalsIgnoreCase(team)) {
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Team not found");
                    }
                }
                /**
                 *
                 * @throws NullPointerException if no team exists
                 */
                catch(NullPointerException exp){
                    JOptionPane.showMessageDialog(null,"No teams Exist");
                }
                try {
                    if (name.isEmpty() || team.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Enter valid name and team");
                    }
                    else{
                        //Until League obj is added
                        //League.SearchByNameAndTeam(name,team);
                        try{ Player p= league.SearchByNameAndTeam(name,team).getFirst();

                            JLabel select =new JLabel("Select Player to delete");
                            JButton serachValue = new JButton(p.Name +" "+p.Age+" "+p.Salary);
                            panel2.add(serachValue);
                            panel2.add(select);
                            serachValue.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent arg0) {
                                    //searchByNameAndTeam.remove(0);
                                }
                            });}
                        /**
                         *
                         * @throws NullPointerException if no player exists
                         */
                        catch(NullPointerException exp){
                            JOptionPane.showMessageDialog(null,"No results Found");
                        }


                    }
                }
                catch(NullPointerException exp){
                    JOptionPane.showMessageDialog(null,"No Player Exist");
                }

            }

        });
    }
}
