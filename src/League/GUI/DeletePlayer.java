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
    public DeletePlayer(League league){
        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(2, 1));
        JPanel titlepanel = new JPanel(new GridLayout(5, 1,0,30));
        JPanel contentPanel=new JPanel(new GridLayout(1, 1));
        JPanel panel2 = new JPanel(new GridLayout(4, 1,0,50));
        JLabel titleLabel = new JLabel("Delete Player");
        JLabel title2Label = new JLabel("Search by Team and Name");
        title2Label.setFont(new Font("Comic Sans",Font.BOLD,15));
        title2Label.setVerticalAlignment(JLabel.TOP);
        title2Label.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlepanel.add(titleLabel);
        titlepanel.add(title2Label);
        this.add(titlepanel);
        this.add(contentPanel);

        JPanel namepanel = new JPanel(new GridLayout(1, 1));
        JLabel nameLabel = new JLabel("Enter Name");
        namepanel.add(nameLabel);
        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        JTextField nameFeild = new JTextField("");
        namepanel.add(nameFeild);
        titlepanel.add(namepanel);

        contentPanel.add(panel2);
        JPanel teampanel = new JPanel(new GridLayout(1, 1));
        JLabel teamLabel = new JLabel("Team");
        teamLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        teampanel.add(teamLabel);
        JTextField teamFeild = new JTextField("");
        teampanel.add(teamFeild);
        titlepanel.add(teampanel);


        JButton searchButton=new JButton("Search");
        searchButton.setFocusable(false);
        searchButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        panel2.add(searchButton);
        searchButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String name=nameFeild.getText();
                String team =teamFeild.getText();
                boolean found=false;
                try {
                    for (String s : league.teamnames) {
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
                if(name.isEmpty()||team.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter valid name and team");
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

        });
    }
}
