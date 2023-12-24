package League.GUI;

import League.League;
import League.Person.Player.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;


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
        JPanel titlePanel = new JPanel(new GridLayout(5, 1,0,30));
        JPanel contentPanel=new JPanel(new GridLayout(1, 1));
        JPanel panel2 = new JPanel(new GridLayout(4, 1,0,50));
        JLabel titleLabel = new JLabel("Add Player");
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);
        this.add(titlePanel);
        this.add(contentPanel);
        contentPanel.add(panel2);
        JPanel namePanel = new JPanel(new GridLayout(1, 1));
        JLabel nameLabel = new JLabel("Name");
        namePanel.add(nameLabel);
        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        JTextField nameField = new JTextField("");
        namePanel.add(nameField);
        titlePanel.add(namePanel);


        JPanel agePanel = new JPanel(new GridLayout(1, 1));
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        agePanel.add(ageLabel);
        JTextField ageField = new JTextField("");
        agePanel.add(ageField);
        titlePanel.add(agePanel);

        JPanel rankPanel = new JPanel(new GridLayout(1, 1));
        JLabel rankLabel = new JLabel("Rank");
        rankLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        rankPanel.add(rankLabel);
        JTextField rankField = new JTextField("");
        rankPanel.add(rankField);
        panel2.add(rankPanel);

        JPanel numberPanel = new JPanel(new GridLayout(1, 1));
        JLabel numberLabel = new JLabel("T-shirt number");
        numberLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        numberPanel.add(numberLabel);
        JTextField numberField = new JTextField("");
        numberPanel.add(numberField );
        titlePanel.add(numberPanel);

        JPanel captainPanel = new JPanel(new GridLayout(1, 1));
        JLabel captainLabel = new JLabel("Team Captain");
        captainLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        captainPanel.add(captainLabel);
        String capList[]={"No","Yes"};
        JComboBox captainComboBox =new JComboBox(capList);
        captainPanel.add(captainComboBox);
        panel2.add(captainPanel);

        JPanel positionsPanel = new JPanel(new GridLayout(1, 1));
        JLabel positionsLabel = new JLabel("Position");
        positionsLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        positionsPanel.add(positionsLabel);
        String positions[]={"GoalKeeper","Defender","Midfielder","Forward"};
        JComboBox positionsComboBox =new JComboBox(positions);
        positionsPanel.add(positionsComboBox);
        panel2.add(positionsPanel);

        JButton saveButton=new JButton("Save");
        saveButton.setFocusable(false);
        saveButton.setFont(new Font("Comic Sans",Font.BOLD,20));

        panel2.add(saveButton);
        teamsComboBox = new JComboBox(new DefaultComboBoxModel<>(teamnames.toArray()));

        JPanel comboboxPanel = new JPanel(new GridLayout(1, 1));
        JLabel comboBoxLabel = new JLabel("Team");
        comboBoxLabel.setFont(new Font("Comic Sans",Font.BOLD,20));

        comboboxPanel.add(comboBoxLabel);
        comboboxPanel.add(teamsComboBox);
        this.setVisible(true);
        titlePanel.add(comboboxPanel);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String name = nameField.getText();
                String Age = ageField.getText();
                String rank =rankField.getText();
                String number =numberField .getText();
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


                // validation
                if (!Validation(name,Age,rank,number,position)) {


                }

                else {
                    try {
                        Integer.parseInt(Age);
                        Integer.parseInt(rank);
                        Integer.parseInt(number);
                        Player p = null;
                        for (Player player : league.searchTeam(team).getPlayers()){
                            if (player.GetPlayerNumber() == Integer.parseInt(number)){
                                throw new InputMismatchException();
                            }
                        }
                        if (captain.equals("Yes")) {
                            if (position.equals("GoalKeeper")) {
                                    p = new Goalkeeper(name, Integer.parseInt(Age), 0, team, Integer.parseInt(number), 0, Integer.parseInt(rank), 0, 0, 0, 0, 0,  true);
                            } else if (position.equals("Midfielder")) {
                                p = new Midfielder(name, Integer.parseInt(Age), 0, team, Integer.parseInt(number), 0, Integer.parseInt(rank), 0, 0, 0, 0, true);
                            } else if (position.equals("Defender")) {
                                p = new Defender(name, Integer.parseInt(Age), 0, team, Integer.parseInt(number), 0, Integer.parseInt(rank), 0, 0, 0, 0, true);
                            } else if (position.equals("Forward")) {
                                p = new Forward(name, Integer.parseInt(Age), 0, team, Integer.parseInt(number), 0, 0, 0, 0, 0, 0, 0, true);
                            }

                        } else {
                            if (position.equals("GoalKeeper")) {
                                    p = new Goalkeeper(name, Integer.parseInt(Age), 0, team, Integer.parseInt(number), 0, Integer.parseInt(rank), 0, 0, 0, 0, 0, false);
                            } else if (position.equals("Midfielder")) {
                                p = new Midfielder(name, Integer.parseInt(Age), 0, team, Integer.parseInt(number), 0, Integer.parseInt(rank), 0, 0, 0, 0, false);
                            } else if (position.equals("Defender")) {
                                p = new Defender(name, Integer.parseInt(Age), 0, team, Integer.parseInt(number), 0, Integer.parseInt(rank), 0, 0, 0, 0,  false);
                            } else if (position.equals("Forward")) {
                                p = new Forward(name, Integer.parseInt(Age), 0, team, Integer.parseInt(number), 0, 0, 0, 0, 0, 0, 0, false);
                            }
                        }

                       if(league.searchTeam(team).getCaptain()==null) {
                           if (league.searchTeam(team).noOfGoalkeepers == 3 && position.equals("GoalKeeper")) {
                               JOptionPane.showMessageDialog(null, "Only 3 gk are allowed in a team");
                               main.add(new DeletePlayer(league.teamNames,league,main,cardLayout),"DeletePlayer");
                               main.add(new EditPlayer(league.teamNames,league,main,cardLayout),"EditPlayer");
                               main.add(new Players(main, cardLayout,league),"Stats");
                               main.add(new Standings(main,cardLayout,league),"Standings");
                           }
                           else if(league.searchTeam(team).noOfPlayers == 25){
                               JOptionPane.showMessageDialog(null, "Only 25 players are allowed in a team");
                               main.add(new DeletePlayer(league.teamNames,league,main,cardLayout),"DeletePlayer");
                               main.add(new EditPlayer(league.teamNames,league,main,cardLayout),"EditPlayer");
                               main.add(new Players(main, cardLayout,league),"Stats");
                               main.add(new Standings(main,cardLayout,league),"Standings");
                           } else {
                               league.searchTeam(team).addPlayer(p);
                               if (p.getCaptain()) {
                                   league.searchTeam(team).setCaptain(p);
                               }

                               //main.add(new Players(main, cardLayout, league), "Stats");
                               main.add(new DeletePlayer(league.teamNames, league, main, cardLayout), "DeletePlayer");
                               main.add(new EditPlayer(league.teamNames, league, main, cardLayout), "EditPlayer");
                               main.add(new Players(main, cardLayout,league),"Stats");
                               main.add(new Standings(main,cardLayout,league),"Standings");
                               cardLayout.show(main, "PlayerHome");
                               JOptionPane.showMessageDialog(null, "Player added successfully");
                               nameField.setText("");
                               ageField.setText("");
                               rankField.setText("");
                               numberField .setText("");


                           }
                       }
                       else if(league.searchTeam(team).getCaptain()!=null && captain.equals("Yes")) {
                           JOptionPane.showMessageDialog(null, "Team must have 1 captain only");
                           main.add(new DeletePlayer(league.teamNames,league,main,cardLayout),"DeletePlayer");
                           main.add(new EditPlayer(league.teamNames,league,main,cardLayout),"EditPlayer");
                           main.add(new Players(main, cardLayout,league),"Stats");
                           main.add(new Standings(main,cardLayout,league),"Standings");
                       }
                       else if(captain.equals("No")) {
                           if (league.searchTeam(team).noOfGoalkeepers == 3 ) {
                               JOptionPane.showMessageDialog(null, "Only 3 gk are allowed in a team");
                               main.add(new DeletePlayer(league.teamNames,league,main,cardLayout),"DeletePlayer");
                               main.add(new EditPlayer(league.teamNames,league,main,cardLayout),"EditPlayer");
                               main.add(new Players(main, cardLayout,league),"Stats");
                               main.add(new Standings(main,cardLayout,league),"Standings");
                           }
                           else if(league.searchTeam(team).noOfPlayers == 25){
                               JOptionPane.showMessageDialog(null, "Only 25 players are allowed in a team");
                               main.add(new DeletePlayer(league.teamNames,league,main,cardLayout),"DeletePlayer");
                               main.add(new EditPlayer(league.teamNames,league,main,cardLayout),"EditPlayer");
                               main.add(new Players(main, cardLayout,league),"Stats");
                               main.add(new Standings(main,cardLayout,league),"Standings");
                           }
                           else {
                               league.searchTeam(team).addPlayer(p);
                               //main.add(new Players(main, cardLayout, league), "Stats");
                               JOptionPane.showMessageDialog(null, "Player added successfully");
                               main.add(new DeletePlayer(league.teamNames, league, main, cardLayout), "DeletePlayer");
                               main.add(new EditPlayer(league.teamNames, league, main, cardLayout), "EditPlayer");
                               main.add(new Players(main, cardLayout,league),"Stats");
                               main.add(new Standings(main,cardLayout,league),"Standings");
                               cardLayout.show(main, "PlayerHome");
                               nameField.setText("");
                               ageField.setText("");
                               rankField.setText("");
                               numberField .setText("");

                           }

                       }

                    }
                    /**
                     *
                     * @throws NumberFormatException if user enters non integers
                     */
                    catch(NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Enter a valid number in number,age and rank");
                    }catch (InputMismatchException exception){
                        JOptionPane.showMessageDialog(null, "T-shirt number is reserved for another player");
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
