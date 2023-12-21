package League.GUI;

import League.League;
import League.Person.Player.*;
import League.Team.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddPlayer extends JPanel{
    JComboBox teamsComboBox;
    League league;
    MainPanel main;
    CardLayout cardLayout;
    public AddPlayer(ArrayList<String> teamnames,League league,MainPanel main,CardLayout cardLayout){
        this.league=league;
        this.main = main;
        this.cardLayout = cardLayout;
        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(2, 1));
        JPanel titlepanel = new JPanel(new GridLayout(5, 1,0,30));
        JPanel contentPanel=new JPanel(new GridLayout(1, 1));
        JPanel panel2 = new JPanel(new GridLayout(4, 1,0,50));
        JLabel titleLabel = new JLabel("Add Player");
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlepanel.add(titleLabel);
        this.add(titlepanel);
        this.add(contentPanel);
        contentPanel.add(panel2);
        JPanel namepanel = new JPanel(new GridLayout(1, 1));
        JLabel nameLabel = new JLabel("Name");
        namepanel.add(nameLabel);
        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        JTextField nameFeild = new JTextField("");
        namepanel.add(nameFeild);
        titlepanel.add(namepanel);


        JPanel agepanel = new JPanel(new GridLayout(1, 1));
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        agepanel.add(ageLabel);
        JTextField ageFeild = new JTextField("");
        agepanel.add(ageFeild);
        titlepanel.add(agepanel);

        JPanel rankpanel = new JPanel(new GridLayout(1, 1));
        JLabel rankLabel = new JLabel("Rank");
        rankLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        rankpanel.add(rankLabel);
        JTextField rankFeild = new JTextField("");
        rankpanel.add(rankFeild);
        panel2.add(rankpanel);

        JPanel numberpanel = new JPanel(new GridLayout(1, 1));
        JLabel numberLabel = new JLabel("T-shirt number");
        numberLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        numberpanel.add(numberLabel);
        JTextField numberFeild = new JTextField("");
        numberpanel.add(numberFeild);
        titlepanel.add(numberpanel);

        JPanel captainpanel = new JPanel(new GridLayout(1, 1));
        JLabel captainLabel = new JLabel("Team Captain");
        captainLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        captainpanel.add(captainLabel);
        String capbool[]={"No","Yes"};
        JComboBox captainComboBox =new JComboBox(capbool);
        captainpanel.add(captainComboBox);
        panel2.add(captainpanel);

        JPanel positionspanel = new JPanel(new GridLayout(1, 1));
        JLabel positionsLabel = new JLabel("Position");
        positionsLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        positionspanel.add(positionsLabel);
        String positions[]={"GoalKeeper","Defender","Midfielder","Forward"};
        JComboBox positionsComboBox =new JComboBox(positions);
        positionspanel.add(positionsComboBox);
        panel2.add(positionspanel);

        JButton saveButton=new JButton("Save");
        saveButton.setFocusable(false);
        saveButton.setFont(new Font("Comic Sans",Font.BOLD,20));

        panel2.add(saveButton);
        System.out.println(teamnames);
        teamsComboBox = new JComboBox(new DefaultComboBoxModel<>(teamnames.toArray()));

        JPanel comboboxpanel = new JPanel(new GridLayout(1, 1));
        JLabel comboBoxLabel = new JLabel("Team");
        comboBoxLabel.setFont(new Font("Comic Sans",Font.BOLD,20));

        comboboxpanel.add(comboBoxLabel);
        comboboxpanel.add(teamsComboBox);
        this.setVisible(true);
        titlepanel.add(comboboxpanel);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String name = nameFeild.getText();
                String Age = ageFeild.getText();
                String rank =rankFeild.getText();
                String number =numberFeild.getText();
                String position = (String) positionsComboBox.getItemAt(positionsComboBox.getSelectedIndex());
                String captain=(String) captainComboBox.getItemAt(captainComboBox.getSelectedIndex());

                String team="Null";
                try{
                    team = (String) teamsComboBox.getItemAt(teamsComboBox.getSelectedIndex());
                }

                /**
                 *
                 * @throws NullPointerException  if no team exists
                 */
                catch(NullPointerException ignorable){
                    JOptionPane.showMessageDialog(null, "Add team first");
                }
                System.out.println("team is "+team);

                // validation
                if (!Validation(name,Age,rank,number,position)) {


                }

                else {
                    try {
                        Integer.parseInt(Age);
                        Integer.parseInt(rank);
                        Integer.parseInt(number);
                        Player p = null;
                        if (captain.equals("Yes")) {
                            if (position.equals("GoalKeeper")) {
                                p = new Goalkeeper(name, Integer.parseInt(Age), 0, team, Integer.parseInt(number), 0, Integer.parseInt(rank), 0, 0, 0, 0, 0, 0, true);
                            } else if (position.equals("Midfielder")) {
                                p = new Midfielder(name, Integer.parseInt(Age), 0, team, Integer.parseInt(number), 0, Integer.parseInt(rank), 0, 0, 0, 0, 0, true);
                            } else if (position.equals("Defender")) {
                                p = new Defender(name, Integer.parseInt(Age), 0, team, Integer.parseInt(number), 0, Integer.parseInt(rank), 0, 0, 0, 0, 0, 0, true);
                            } else if (position.equals("Forward")) {
                                p = new Forward(name, Integer.parseInt(Age), 0, team, Integer.parseInt(number), 0, 0, 0, 0, 0, 0, 0, true);
                            }

                        } else {
                            if (position.equals("GoalKeeper")) {
                                p = new Goalkeeper(name, Integer.parseInt(Age), 0, team, Integer.parseInt(number), 0, Integer.parseInt(rank), 0, 0, 0, 0, 0, 0, false);
                            } else if (position.equals("Midfielder")) {
                                p = new Midfielder(name, Integer.parseInt(Age), 0, team, Integer.parseInt(number), 0, Integer.parseInt(rank), 0, 0, 0, 0, 0, false);
                            } else if (position.equals("Defender")) {
                                p = new Defender(name, Integer.parseInt(Age), 0, team, Integer.parseInt(number), 0, Integer.parseInt(rank), 0, 0, 0, 0, 0, 0, false);
                            } else if (position.equals("Forward")) {
                                p = new Forward(name, Integer.parseInt(Age), 0, team, Integer.parseInt(number), 0, 0, 0, 0, 0, 0, 0, false);
                            }
                        }

                       if(league.searchTeam(team).getCaptain()==null) {
                           league.searchTeam(team).addPlayer(p);
                           if (p.getCaptain()) {
                               league.searchTeam(team).setCaptain(p);
                           }
                           main.add(new Players(main, cardLayout, league), "Stats");
                           main.add(new DeletePlayer(league.teamnames,league,main,cardLayout),"DeletePlayer");
                           cardLayout.show(main, "PlayerHome");
                           JOptionPane.showMessageDialog(null, "Player added successfully");

                       }
                       else if(league.searchTeam(team).getCaptain()!=null && captain.equals("Yes")) {
                           JOptionPane.showMessageDialog(null, "Team must have 1 captain only");
                       }
                       else if(captain.equals("No")) {
                           league.searchTeam(team).addPlayer(p);
                           main.add(new Players(main, cardLayout, league), "Stats");
                           JOptionPane.showMessageDialog(null, "Player added successfully");
                       }
                    }
                    /**
                     *
                     * @throws NumberFormatException if user enters non integers
                     */
                    catch(NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Enter a valid number in number,age and rank");
                    }

                }
            }
        });
    }
    public boolean Validation(String name,String Age,String number,String rank,String position){
        if (name.isEmpty()||Age.isEmpty()||number.isEmpty()||rank.isEmpty()||position.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields");
            return false;
        }
        else{
            return true;
        }
    }



}
